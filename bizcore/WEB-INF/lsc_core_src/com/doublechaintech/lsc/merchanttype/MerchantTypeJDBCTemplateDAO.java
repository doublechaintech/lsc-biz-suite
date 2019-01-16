
package com.doublechaintech.lsc.merchanttype;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.lsc.LscNamingServiceDAO;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.AccessKey;
import com.doublechaintech.lsc.DateKey;
import com.doublechaintech.lsc.StatsInfo;
import com.doublechaintech.lsc.StatsItem;

import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;


import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.platform.Platform;

import com.doublechaintech.lsc.merchant.MerchantDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;
import com.doublechaintech.lsc.transportitem.TransportItemDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class MerchantTypeJDBCTemplateDAO extends LscNamingServiceDAO implements MerchantTypeDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  MerchantDAO  merchantDAO;
 	public void setMerchantDAO(MerchantDAO pMerchantDAO){
 	
 		if(pMerchantDAO == null){
 			throw new IllegalStateException("Do not try to set merchantDAO to null.");
 		}
	 	this.merchantDAO = pMerchantDAO;
 	}
 	public MerchantDAO getMerchantDAO(){
 		if(this.merchantDAO == null){
 			throw new IllegalStateException("The merchantDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.merchantDAO;
 	}	
 	
			
		
	
  	private  TransportItemDAO  transportItemDAO;
 	public void setTransportItemDAO(TransportItemDAO pTransportItemDAO){
 	
 		if(pTransportItemDAO == null){
 			throw new IllegalStateException("Do not try to set transportItemDAO to null.");
 		}
	 	this.transportItemDAO = pTransportItemDAO;
 	}
 	public TransportItemDAO getTransportItemDAO(){
 		if(this.transportItemDAO == null){
 			throw new IllegalStateException("The transportItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportItemDAO;
 	}	
 	
			
		

	
	/*
	protected MerchantType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMerchantType(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public MerchantType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMerchantType(MerchantTypeTable.withId(id), options);
	}
	
	
	
	public MerchantType save(MerchantType merchantType,Map<String,Object> options){
		
		String methodName="save(MerchantType merchantType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(merchantType, methodName, "merchantType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalMerchantType(merchantType,options);
	}
	public MerchantType clone(String merchantTypeId, Map<String,Object> options) throws Exception{
	
		return clone(MerchantTypeTable.withId(merchantTypeId),options);
	}
	
	protected MerchantType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String merchantTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		MerchantType newMerchantType = loadInternalMerchantType(accessKey, options);
		newMerchantType.setVersion(0);
		
		
 		
 		if(isSaveMerchantListEnabled(options)){
 			for(Merchant item: newMerchantType.getMerchantList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportItemListEnabled(options)){
 			for(TransportItem item: newMerchantType.getTransportItemList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalMerchantType(newMerchantType,options);
		
		return newMerchantType;
	}
	
	
	
	

	protected void throwIfHasException(String merchantTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new MerchantTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MerchantTypeNotFoundException(
					"The " + this.getTableName() + "(" + merchantTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String merchantTypeId, int version) throws Exception{
	
		String methodName="delete(String merchantTypeId, int version)";
		assertMethodArgumentNotNull(merchantTypeId, methodName, "merchantTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{merchantTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(merchantTypeId,version);
		}
		
	
	}
	
	
	
	
	

	public MerchantType disconnectFromAll(String merchantTypeId, int version) throws Exception{
	
		
		MerchantType merchantType = loadInternalMerchantType(MerchantTypeTable.withId(merchantTypeId), emptyOptions());
		merchantType.clearFromAll();
		this.saveMerchantType(merchantType);
		return merchantType;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return MerchantTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "merchant_type";
	}
	@Override
	protected String getBeanName() {
		
		return "merchantType";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return MerchantTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MerchantTypeTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MerchantTypeTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractMerchantListEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTypeTokens.MERCHANT_LIST);
 	}
 	protected boolean isAnalyzeMerchantListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,MerchantTypeTokens.MERCHANT_LIST+".analyze");
 	}
	
	protected boolean isSaveMerchantListEnabled(Map<String,Object> options){
		return checkOptions(options, MerchantTypeTokens.MERCHANT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTransportItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTypeTokens.TRANSPORT_ITEM_LIST);
 	}
 	protected boolean isAnalyzeTransportItemListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,MerchantTypeTokens.TRANSPORT_ITEM_LIST+".analyze");
 	}
	
	protected boolean isSaveTransportItemListEnabled(Map<String,Object> options){
		return checkOptions(options, MerchantTypeTokens.TRANSPORT_ITEM_LIST);
		
 	}
 	
		

	

	protected MerchantTypeMapper getMerchantTypeMapper(){
		return new MerchantTypeMapper();
	}

	
	
	protected MerchantType extractMerchantType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			MerchantType merchantType = loadSingleObject(accessKey, getMerchantTypeMapper());
			return merchantType;
		}catch(EmptyResultDataAccessException e){
			throw new MerchantTypeNotFoundException("MerchantType("+accessKey+") is not found!");
		}

	}

	
	

	protected MerchantType loadInternalMerchantType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		MerchantType merchantType = extractMerchantType(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(merchantType, loadOptions);
 		}
 
		
		if(isExtractMerchantListEnabled(loadOptions)){
	 		extractMerchantList(merchantType, loadOptions);
 		}	
 		if(isAnalyzeMerchantListEnabled(loadOptions)){
	 		analyzeMerchantList(merchantType, loadOptions);
 		}
 		
		
		if(isExtractTransportItemListEnabled(loadOptions)){
	 		extractTransportItemList(merchantType, loadOptions);
 		}	
 		if(isAnalyzeTransportItemListEnabled(loadOptions)){
	 		analyzeTransportItemList(merchantType, loadOptions);
 		}
 		
		
		return merchantType;
		
	}

	 

 	protected MerchantType extractPlatform(MerchantType merchantType, Map<String,Object> options) throws Exception{

		if(merchantType.getPlatform() == null){
			return merchantType;
		}
		String platformId = merchantType.getPlatform().getId();
		if( platformId == null){
			return merchantType;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			merchantType.setPlatform(platform);
		}
		
 		
 		return merchantType;
 	}
 		
 
		
	protected void enhanceMerchantList(SmartList<Merchant> merchantList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected MerchantType extractMerchantList(MerchantType merchantType, Map<String,Object> options){
		
		
		if(merchantType == null){
			return null;
		}
		if(merchantType.getId() == null){
			return merchantType;
		}

		
		
		SmartList<Merchant> merchantList = getMerchantDAO().findMerchantByType(merchantType.getId(),options);
		if(merchantList != null){
			enhanceMerchantList(merchantList,options);
			merchantType.setMerchantList(merchantList);
		}
		
		return merchantType;
	
	}	
	
	protected MerchantType analyzeMerchantList(MerchantType merchantType, Map<String,Object> options){
		
		
		if(merchantType == null){
			return null;
		}
		if(merchantType.getId() == null){
			return merchantType;
		}

		
		
		SmartList<Merchant> merchantList = merchantType.getMerchantList();
		if(merchantList != null){
			getMerchantDAO().analyzeMerchantByType(merchantList, merchantType.getId(), options);
			
		}
		
		return merchantType;
	
	}	
	
		
	protected void enhanceTransportItemList(SmartList<TransportItem> transportItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected MerchantType extractTransportItemList(MerchantType merchantType, Map<String,Object> options){
		
		
		if(merchantType == null){
			return null;
		}
		if(merchantType.getId() == null){
			return merchantType;
		}

		
		
		SmartList<TransportItem> transportItemList = getTransportItemDAO().findTransportItemByMerchant(merchantType.getId(),options);
		if(transportItemList != null){
			enhanceTransportItemList(transportItemList,options);
			merchantType.setTransportItemList(transportItemList);
		}
		
		return merchantType;
	
	}	
	
	protected MerchantType analyzeTransportItemList(MerchantType merchantType, Map<String,Object> options){
		
		
		if(merchantType == null){
			return null;
		}
		if(merchantType.getId() == null){
			return merchantType;
		}

		
		
		SmartList<TransportItem> transportItemList = merchantType.getTransportItemList();
		if(transportItemList != null){
			getTransportItemDAO().analyzeTransportItemByMerchant(transportItemList, merchantType.getId(), options);
			
		}
		
		return merchantType;
	
	}	
	
		
		
  	
 	public SmartList<MerchantType> findMerchantTypeByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<MerchantType> resultList = queryWith(MerchantTypeTable.COLUMN_PLATFORM, platformId, options, getMerchantTypeMapper());
		// analyzeMerchantTypeByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<MerchantType> findMerchantTypeByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<MerchantType> resultList =  queryWithRange(MerchantTypeTable.COLUMN_PLATFORM, platformId, options, getMerchantTypeMapper(), start, count);
 		//analyzeMerchantTypeByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeMerchantTypeByPlatform(SmartList<MerchantType> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countMerchantTypeByPlatform(String platformId,Map<String,Object> options){

 		return countWith(MerchantTypeTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countMerchantTypeByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(MerchantTypeTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected MerchantType saveMerchantType(MerchantType  merchantType){
		
		if(!merchantType.isChanged()){
			return merchantType;
		}
		
		
		String SQL=this.getSaveMerchantTypeSQL(merchantType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMerchantTypeParameters(merchantType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		merchantType.incVersion();
		return merchantType;
	
	}
	public SmartList<MerchantType> saveMerchantTypeList(SmartList<MerchantType> merchantTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMerchantTypeList(merchantTypeList);
		
		batchMerchantTypeCreate((List<MerchantType>)lists[CREATE_LIST_INDEX]);
		
		batchMerchantTypeUpdate((List<MerchantType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(MerchantType merchantType:merchantTypeList){
			if(merchantType.isChanged()){
				merchantType.incVersion();
			}
			
		
		}
		
		
		return merchantTypeList;
	}

	public SmartList<MerchantType> removeMerchantTypeList(SmartList<MerchantType> merchantTypeList,Map<String,Object> options){
		
		
		super.removeList(merchantTypeList, options);
		
		return merchantTypeList;
		
		
	}
	
	protected List<Object[]> prepareMerchantTypeBatchCreateArgs(List<MerchantType> merchantTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MerchantType merchantType:merchantTypeList ){
			Object [] parameters = prepareMerchantTypeCreateParameters(merchantType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareMerchantTypeBatchUpdateArgs(List<MerchantType> merchantTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MerchantType merchantType:merchantTypeList ){
			if(!merchantType.isChanged()){
				continue;
			}
			Object [] parameters = prepareMerchantTypeUpdateParameters(merchantType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchMerchantTypeCreate(List<MerchantType> merchantTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMerchantTypeBatchCreateArgs(merchantTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchMerchantTypeUpdate(List<MerchantType> merchantTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMerchantTypeBatchUpdateArgs(merchantTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitMerchantTypeList(List<MerchantType> merchantTypeList){
		
		List<MerchantType> merchantTypeCreateList=new ArrayList<MerchantType>();
		List<MerchantType> merchantTypeUpdateList=new ArrayList<MerchantType>();
		
		for(MerchantType merchantType: merchantTypeList){
			if(isUpdateRequest(merchantType)){
				merchantTypeUpdateList.add( merchantType);
				continue;
			}
			merchantTypeCreateList.add(merchantType);
		}
		
		return new Object[]{merchantTypeCreateList,merchantTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(MerchantType merchantType){
 		return merchantType.getVersion() > 0;
 	}
 	protected String getSaveMerchantTypeSQL(MerchantType merchantType){
 		if(isUpdateRequest(merchantType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveMerchantTypeParameters(MerchantType merchantType){
 		if(isUpdateRequest(merchantType) ){
 			return prepareMerchantTypeUpdateParameters(merchantType);
 		}
 		return prepareMerchantTypeCreateParameters(merchantType);
 	}
 	protected Object[] prepareMerchantTypeUpdateParameters(MerchantType merchantType){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = merchantType.getName(); 	
 		if(merchantType.getPlatform() != null){
 			parameters[1] = merchantType.getPlatform().getId();
 		}
 		
 		parameters[2] = merchantType.nextVersion();
 		parameters[3] = merchantType.getId();
 		parameters[4] = merchantType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareMerchantTypeCreateParameters(MerchantType merchantType){
		Object[] parameters = new Object[3];
		String newMerchantTypeId=getNextId();
		merchantType.setId(newMerchantTypeId);
		parameters[0] =  merchantType.getId();
 
 		parameters[1] = merchantType.getName(); 	
 		if(merchantType.getPlatform() != null){
 			parameters[2] = merchantType.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected MerchantType saveInternalMerchantType(MerchantType merchantType, Map<String,Object> options){
		
		saveMerchantType(merchantType);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(merchantType, options);
 		}
 
		
		if(isSaveMerchantListEnabled(options)){
	 		saveMerchantList(merchantType, options);
	 		//removeMerchantList(merchantType, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportItemListEnabled(options)){
	 		saveTransportItemList(merchantType, options);
	 		//removeTransportItemList(merchantType, options);
	 		//Not delete the record
	 		
 		}		
		
		return merchantType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected MerchantType savePlatform(MerchantType merchantType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(merchantType.getPlatform() == null){
 			return merchantType;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(merchantType.getPlatform(),options);
 		return merchantType;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public MerchantType planToRemoveMerchantList(MerchantType merchantType, String merchantIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Merchant.TYPE_PROPERTY, merchantType.getId());
		key.put(Merchant.ID_PROPERTY, merchantIds);
		
		SmartList<Merchant> externalMerchantList = getMerchantDAO().
				findMerchantWithKey(key, options);
		if(externalMerchantList == null){
			return merchantType;
		}
		if(externalMerchantList.isEmpty()){
			return merchantType;
		}
		
		for(Merchant merchant: externalMerchantList){

			merchant.clearFromAll();
		}
		
		
		SmartList<Merchant> merchantList = merchantType.getMerchantList();		
		merchantList.addAllToRemoveList(externalMerchantList);
		return merchantType;	
	
	}


	//disconnect MerchantType with platform in Merchant
	public MerchantType planToRemoveMerchantListWithPlatform(MerchantType merchantType, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Merchant.TYPE_PROPERTY, merchantType.getId());
		key.put(Merchant.PLATFORM_PROPERTY, platformId);
		
		SmartList<Merchant> externalMerchantList = getMerchantDAO().
				findMerchantWithKey(key, options);
		if(externalMerchantList == null){
			return merchantType;
		}
		if(externalMerchantList.isEmpty()){
			return merchantType;
		}
		
		for(Merchant merchant: externalMerchantList){
			merchant.clearPlatform();
			merchant.clearType();
			
		}
		
		
		SmartList<Merchant> merchantList = merchantType.getMerchantList();		
		merchantList.addAllToRemoveList(externalMerchantList);
		return merchantType;
	}
	
	public int countMerchantListWithPlatform(String merchantTypeId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Merchant.TYPE_PROPERTY, merchantTypeId);
		key.put(Merchant.PLATFORM_PROPERTY, platformId);
		
		int count = getMerchantDAO().countMerchantWithKey(key, options);
		return count;
	}
	
	public MerchantType planToRemoveTransportItemList(MerchantType merchantType, String transportItemIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.MERCHANT_PROPERTY, merchantType.getId());
		key.put(TransportItem.ID_PROPERTY, transportItemIds);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return merchantType;
		}
		if(externalTransportItemList.isEmpty()){
			return merchantType;
		}
		
		for(TransportItem transportItem: externalTransportItemList){

			transportItem.clearFromAll();
		}
		
		
		SmartList<TransportItem> transportItemList = merchantType.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return merchantType;	
	
	}


	//disconnect MerchantType with project in TransportItem
	public MerchantType planToRemoveTransportItemListWithProject(MerchantType merchantType, String projectId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.MERCHANT_PROPERTY, merchantType.getId());
		key.put(TransportItem.PROJECT_PROPERTY, projectId);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return merchantType;
		}
		if(externalTransportItemList.isEmpty()){
			return merchantType;
		}
		
		for(TransportItem transportItem: externalTransportItemList){
			transportItem.clearProject();
			transportItem.clearMerchant();
			
		}
		
		
		SmartList<TransportItem> transportItemList = merchantType.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return merchantType;
	}
	
	public int countTransportItemListWithProject(String merchantTypeId, String projectId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.MERCHANT_PROPERTY, merchantTypeId);
		key.put(TransportItem.PROJECT_PROPERTY, projectId);
		
		int count = getTransportItemDAO().countTransportItemWithKey(key, options);
		return count;
	}
	
	//disconnect MerchantType with platform in TransportItem
	public MerchantType planToRemoveTransportItemListWithPlatform(MerchantType merchantType, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.MERCHANT_PROPERTY, merchantType.getId());
		key.put(TransportItem.PLATFORM_PROPERTY, platformId);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return merchantType;
		}
		if(externalTransportItemList.isEmpty()){
			return merchantType;
		}
		
		for(TransportItem transportItem: externalTransportItemList){
			transportItem.clearPlatform();
			transportItem.clearMerchant();
			
		}
		
		
		SmartList<TransportItem> transportItemList = merchantType.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return merchantType;
	}
	
	public int countTransportItemListWithPlatform(String merchantTypeId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.MERCHANT_PROPERTY, merchantTypeId);
		key.put(TransportItem.PLATFORM_PROPERTY, platformId);
		
		int count = getTransportItemDAO().countTransportItemWithKey(key, options);
		return count;
	}
	

		
	protected MerchantType saveMerchantList(MerchantType merchantType, Map<String,Object> options){
		
		
		
		
		SmartList<Merchant> merchantList = merchantType.getMerchantList();
		if(merchantList == null){
			//null list means nothing
			return merchantType;
		}
		SmartList<Merchant> mergedUpdateMerchantList = new SmartList<Merchant>();
		
		
		mergedUpdateMerchantList.addAll(merchantList); 
		if(merchantList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateMerchantList.addAll(merchantList.getToRemoveList());
			merchantList.removeAll(merchantList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getMerchantDAO().saveMerchantList(mergedUpdateMerchantList,options);
		
		if(merchantList.getToRemoveList() != null){
			merchantList.removeAll(merchantList.getToRemoveList());
		}
		
		
		return merchantType;
	
	}
	
	protected MerchantType removeMerchantList(MerchantType merchantType, Map<String,Object> options){
	
	
		SmartList<Merchant> merchantList = merchantType.getMerchantList();
		if(merchantList == null){
			return merchantType;
		}	
	
		SmartList<Merchant> toRemoveMerchantList = merchantList.getToRemoveList();
		
		if(toRemoveMerchantList == null){
			return merchantType;
		}
		if(toRemoveMerchantList.isEmpty()){
			return merchantType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getMerchantDAO().removeMerchantList(toRemoveMerchantList,options);
		
		return merchantType;
	
	}
	
	

 	
 	
	
	
	
		
	protected MerchantType saveTransportItemList(MerchantType merchantType, Map<String,Object> options){
		
		
		
		
		SmartList<TransportItem> transportItemList = merchantType.getTransportItemList();
		if(transportItemList == null){
			//null list means nothing
			return merchantType;
		}
		SmartList<TransportItem> mergedUpdateTransportItemList = new SmartList<TransportItem>();
		
		
		mergedUpdateTransportItemList.addAll(transportItemList); 
		if(transportItemList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportItemList.addAll(transportItemList.getToRemoveList());
			transportItemList.removeAll(transportItemList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportItemDAO().saveTransportItemList(mergedUpdateTransportItemList,options);
		
		if(transportItemList.getToRemoveList() != null){
			transportItemList.removeAll(transportItemList.getToRemoveList());
		}
		
		
		return merchantType;
	
	}
	
	protected MerchantType removeTransportItemList(MerchantType merchantType, Map<String,Object> options){
	
	
		SmartList<TransportItem> transportItemList = merchantType.getTransportItemList();
		if(transportItemList == null){
			return merchantType;
		}	
	
		SmartList<TransportItem> toRemoveTransportItemList = transportItemList.getToRemoveList();
		
		if(toRemoveTransportItemList == null){
			return merchantType;
		}
		if(toRemoveTransportItemList.isEmpty()){
			return merchantType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportItemDAO().removeTransportItemList(toRemoveTransportItemList,options);
		
		return merchantType;
	
	}
	
	

 	
 	
	
	
	
		

	public MerchantType present(MerchantType merchantType,Map<String, Object> options){
	
		presentMerchantList(merchantType,options);
		presentTransportItemList(merchantType,options);

		return merchantType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected MerchantType presentMerchantList(
			MerchantType merchantType,
			Map<String, Object> options) {

		SmartList<Merchant> merchantList = merchantType.getMerchantList();		
				SmartList<Merchant> newList= presentSubList(merchantType.getId(),
				merchantList,
				options,
				getMerchantDAO()::countMerchantByType,
				getMerchantDAO()::findMerchantByType
				);

		
		merchantType.setMerchantList(newList);
		

		return merchantType;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected MerchantType presentTransportItemList(
			MerchantType merchantType,
			Map<String, Object> options) {

		SmartList<TransportItem> transportItemList = merchantType.getTransportItemList();		
				SmartList<TransportItem> newList= presentSubList(merchantType.getId(),
				transportItemList,
				options,
				getTransportItemDAO()::countTransportItemByMerchant,
				getTransportItemDAO()::findTransportItemByMerchant
				);

		
		merchantType.setTransportItemList(newList);
		

		return merchantType;
	}			
		

	
    public SmartList<MerchantType> requestCandidateMerchantTypeForMerchant(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MerchantTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getMerchantTypeMapper());
    }
		
    public SmartList<MerchantType> requestCandidateMerchantTypeForTransportItem(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MerchantTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getMerchantTypeMapper());
    }
		

	protected String getTableName(){
		return MerchantTypeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<MerchantType> merchantTypeList) {		
		this.enhanceListInternal(merchantTypeList, this.getMerchantTypeMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<MerchantType> merchantTypeList = ownerEntity.collectRefsWithType(MerchantType.INTERNAL_TYPE);
		this.enhanceList(merchantTypeList);
		
	}
	
	@Override
	public SmartList<MerchantType> findMerchantTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getMerchantTypeMapper());

	}
	@Override
	public int countMerchantTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countMerchantTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<MerchantType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getMerchantTypeMapper());
	}
}


