
package com.doublechaintech.lsc.transportproject;

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

public class TransportProjectJDBCTemplateDAO extends LscNamingServiceDAO implements TransportProjectDAO{
 
 	
 	private  MerchantDAO  merchantDAO;
 	public void setMerchantDAO(MerchantDAO merchantDAO){
	 	this.merchantDAO = merchantDAO;
 	}
 	public MerchantDAO getMerchantDAO(){
	 	return this.merchantDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
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
	protected TransportProject load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportProject(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TransportProject load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportProject(TransportProjectTable.withId(id), options);
	}
	
	
	
	public TransportProject save(TransportProject transportProject,Map<String,Object> options){
		
		String methodName="save(TransportProject transportProject,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportProject, methodName, "transportProject");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportProject(transportProject,options);
	}
	public TransportProject clone(String transportProjectId, Map<String,Object> options) throws Exception{
	
		return clone(TransportProjectTable.withId(transportProjectId),options);
	}
	
	protected TransportProject clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportProjectId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportProject newTransportProject = loadInternalTransportProject(accessKey, options);
		newTransportProject.setVersion(0);
		
		
 		
 		if(isSaveTransportItemListEnabled(options)){
 			for(TransportItem item: newTransportProject.getTransportItemList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransportProject(newTransportProject,options);
		
		return newTransportProject;
	}
	
	
	
	

	protected void throwIfHasException(String transportProjectId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportProjectVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportProjectNotFoundException(
					"The " + this.getTableName() + "(" + transportProjectId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transportProjectId, int version) throws Exception{
	
		String methodName="delete(String transportProjectId, int version)";
		assertMethodArgumentNotNull(transportProjectId, methodName, "transportProjectId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportProjectId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportProjectId,version);
		}
		
	
	}
	
	
	
	
	

	public TransportProject disconnectFromAll(String transportProjectId, int version) throws Exception{
	
		
		TransportProject transportProject = loadInternalTransportProject(TransportProjectTable.withId(transportProjectId), emptyOptions());
		transportProject.clearFromAll();
		this.saveTransportProject(transportProject);
		return transportProject;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransportProjectTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_project";
	}
	@Override
	protected String getBeanName() {
		
		return "transportProject";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportProjectTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractMerchantEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportProjectTokens.MERCHANT);
 	}

 	protected boolean isSaveMerchantEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportProjectTokens.MERCHANT);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportProjectTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportProjectTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractTransportItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TransportProjectTokens.TRANSPORT_ITEM_LIST);
 	}
 	protected boolean isAnalyzeTransportItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TransportProjectTokens.TRANSPORT_ITEM_LIST+".analyze");
 	}

	protected boolean isSaveTransportItemListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportProjectTokens.TRANSPORT_ITEM_LIST);
		
 	}
 	
		

	

	protected TransportProjectMapper getTransportProjectMapper(){
		return new TransportProjectMapper();
	}

	
	
	protected TransportProject extractTransportProject(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportProject transportProject = loadSingleObject(accessKey, getTransportProjectMapper());
			return transportProject;
		}catch(EmptyResultDataAccessException e){
			throw new TransportProjectNotFoundException("TransportProject("+accessKey+") is not found!");
		}

	}

	
	

	protected TransportProject loadInternalTransportProject(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportProject transportProject = extractTransportProject(accessKey, loadOptions);
 	
 		if(isExtractMerchantEnabled(loadOptions)){
	 		extractMerchant(transportProject, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(transportProject, loadOptions);
 		}
 
		
		if(isExtractTransportItemListEnabled(loadOptions)){
	 		extractTransportItemList(transportProject, loadOptions);
 		}	
 		if(isAnalyzeTransportItemListEnabled(loadOptions)){
	 		// analyzeTransportItemList(transportProject, loadOptions);
 		}
 		
		
		return transportProject;
		
	}

	 

 	protected TransportProject extractMerchant(TransportProject transportProject, Map<String,Object> options) throws Exception{

		if(transportProject.getMerchant() == null){
			return transportProject;
		}
		String merchantId = transportProject.getMerchant().getId();
		if( merchantId == null){
			return transportProject;
		}
		Merchant merchant = getMerchantDAO().load(merchantId,options);
		if(merchant != null){
			transportProject.setMerchant(merchant);
		}
		
 		
 		return transportProject;
 	}
 		
  

 	protected TransportProject extractPlatform(TransportProject transportProject, Map<String,Object> options) throws Exception{

		if(transportProject.getPlatform() == null){
			return transportProject;
		}
		String platformId = transportProject.getPlatform().getId();
		if( platformId == null){
			return transportProject;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			transportProject.setPlatform(platform);
		}
		
 		
 		return transportProject;
 	}
 		
 
		
	protected void enhanceTransportItemList(SmartList<TransportItem> transportItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected TransportProject extractTransportItemList(TransportProject transportProject, Map<String,Object> options){
		
		
		if(transportProject == null){
			return null;
		}
		if(transportProject.getId() == null){
			return transportProject;
		}

		
		
		SmartList<TransportItem> transportItemList = getTransportItemDAO().findTransportItemByProject(transportProject.getId(),options);
		if(transportItemList != null){
			enhanceTransportItemList(transportItemList,options);
			transportProject.setTransportItemList(transportItemList);
		}
		
		return transportProject;
	
	}	
	
	protected TransportProject analyzeTransportItemList(TransportProject transportProject, Map<String,Object> options){
		
		
		if(transportProject == null){
			return null;
		}
		if(transportProject.getId() == null){
			return transportProject;
		}

		
		
		SmartList<TransportItem> transportItemList = transportProject.getTransportItemList();
		if(transportItemList != null){
			getTransportItemDAO().analyzeTransportItemByProject(transportItemList, transportProject.getId(), options);
			
		}
		
		return transportProject;
	
	}	
	
		
		
  	
 	public SmartList<TransportProject> findTransportProjectByMerchant(String merchantId,Map<String,Object> options){
 	
  		SmartList<TransportProject> resultList = queryWith(TransportProjectTable.COLUMN_MERCHANT, merchantId, options, getTransportProjectMapper());
		// analyzeTransportProjectByMerchant(resultList, merchantId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportProject> findTransportProjectByMerchant(String merchantId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportProject> resultList =  queryWithRange(TransportProjectTable.COLUMN_MERCHANT, merchantId, options, getTransportProjectMapper(), start, count);
 		//analyzeTransportProjectByMerchant(resultList, merchantId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportProjectByMerchant(SmartList<TransportProject> resultList, String merchantId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportProject.MERCHANT_PROPERTY, merchantId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportProject.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Transport Project");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportProject.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportProject.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportProjectByMerchant(String merchantId,Map<String,Object> options){

 		return countWith(TransportProjectTable.COLUMN_MERCHANT, merchantId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportProjectByMerchantIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportProjectTable.COLUMN_MERCHANT, ids, options);
	}
 	
  	
 	public SmartList<TransportProject> findTransportProjectByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<TransportProject> resultList = queryWith(TransportProjectTable.COLUMN_PLATFORM, platformId, options, getTransportProjectMapper());
		// analyzeTransportProjectByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportProject> findTransportProjectByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportProject> resultList =  queryWithRange(TransportProjectTable.COLUMN_PLATFORM, platformId, options, getTransportProjectMapper(), start, count);
 		//analyzeTransportProjectByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportProjectByPlatform(SmartList<TransportProject> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportProject.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportProject.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Transport Project");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportProject.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportProject.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportProjectByPlatform(String platformId,Map<String,Object> options){

 		return countWith(TransportProjectTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportProjectByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportProjectTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected TransportProject saveTransportProject(TransportProject  transportProject){
		
		if(!transportProject.isChanged()){
			return transportProject;
		}
		
		
		String SQL=this.getSaveTransportProjectSQL(transportProject);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportProjectParameters(transportProject);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportProject.incVersion();
		return transportProject;
	
	}
	public SmartList<TransportProject> saveTransportProjectList(SmartList<TransportProject> transportProjectList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportProjectList(transportProjectList);
		
		batchTransportProjectCreate((List<TransportProject>)lists[CREATE_LIST_INDEX]);
		
		batchTransportProjectUpdate((List<TransportProject>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportProject transportProject:transportProjectList){
			if(transportProject.isChanged()){
				transportProject.incVersion();
			}
			
		
		}
		
		
		return transportProjectList;
	}

	public SmartList<TransportProject> removeTransportProjectList(SmartList<TransportProject> transportProjectList,Map<String,Object> options){
		
		
		super.removeList(transportProjectList, options);
		
		return transportProjectList;
		
		
	}
	
	protected List<Object[]> prepareTransportProjectBatchCreateArgs(List<TransportProject> transportProjectList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportProject transportProject:transportProjectList ){
			Object [] parameters = prepareTransportProjectCreateParameters(transportProject);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportProjectBatchUpdateArgs(List<TransportProject> transportProjectList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportProject transportProject:transportProjectList ){
			if(!transportProject.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportProjectUpdateParameters(transportProject);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportProjectCreate(List<TransportProject> transportProjectList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportProjectBatchCreateArgs(transportProjectList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportProjectUpdate(List<TransportProject> transportProjectList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportProjectBatchUpdateArgs(transportProjectList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportProjectList(List<TransportProject> transportProjectList){
		
		List<TransportProject> transportProjectCreateList=new ArrayList<TransportProject>();
		List<TransportProject> transportProjectUpdateList=new ArrayList<TransportProject>();
		
		for(TransportProject transportProject: transportProjectList){
			if(isUpdateRequest(transportProject)){
				transportProjectUpdateList.add( transportProject);
				continue;
			}
			transportProjectCreateList.add(transportProject);
		}
		
		return new Object[]{transportProjectCreateList,transportProjectUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportProject transportProject){
 		return transportProject.getVersion() > 0;
 	}
 	protected String getSaveTransportProjectSQL(TransportProject transportProject){
 		if(isUpdateRequest(transportProject)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportProjectParameters(TransportProject transportProject){
 		if(isUpdateRequest(transportProject) ){
 			return prepareTransportProjectUpdateParameters(transportProject);
 		}
 		return prepareTransportProjectCreateParameters(transportProject);
 	}
 	protected Object[] prepareTransportProjectUpdateParameters(TransportProject transportProject){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = transportProject.getName(); 	
 		if(transportProject.getMerchant() != null){
 			parameters[1] = transportProject.getMerchant().getId();
 		}
  	
 		if(transportProject.getPlatform() != null){
 			parameters[2] = transportProject.getPlatform().getId();
 		}
 
 		parameters[3] = transportProject.getCreateTime();
 		parameters[4] = transportProject.getUpdateTime();		
 		parameters[5] = transportProject.nextVersion();
 		parameters[6] = transportProject.getId();
 		parameters[7] = transportProject.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportProjectCreateParameters(TransportProject transportProject){
		Object[] parameters = new Object[6];
		String newTransportProjectId=getNextId();
		transportProject.setId(newTransportProjectId);
		parameters[0] =  transportProject.getId();
 
 		parameters[1] = transportProject.getName(); 	
 		if(transportProject.getMerchant() != null){
 			parameters[2] = transportProject.getMerchant().getId();
 		
 		}
 		 	
 		if(transportProject.getPlatform() != null){
 			parameters[3] = transportProject.getPlatform().getId();
 		
 		}
 		
 		parameters[4] = transportProject.getCreateTime();
 		parameters[5] = transportProject.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected TransportProject saveInternalTransportProject(TransportProject transportProject, Map<String,Object> options){
		
		saveTransportProject(transportProject);
 	
 		if(isSaveMerchantEnabled(options)){
	 		saveMerchant(transportProject, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(transportProject, options);
 		}
 
		
		if(isSaveTransportItemListEnabled(options)){
	 		saveTransportItemList(transportProject, options);
	 		//removeTransportItemList(transportProject, options);
	 		//Not delete the record
	 		
 		}		
		
		return transportProject;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportProject saveMerchant(TransportProject transportProject, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportProject.getMerchant() == null){
 			return transportProject;//do nothing when it is null
 		}
 		
 		getMerchantDAO().save(transportProject.getMerchant(),options);
 		return transportProject;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportProject savePlatform(TransportProject transportProject, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportProject.getPlatform() == null){
 			return transportProject;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(transportProject.getPlatform(),options);
 		return transportProject;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public TransportProject planToRemoveTransportItemList(TransportProject transportProject, String transportItemIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PROJECT_PROPERTY, transportProject.getId());
		key.put(TransportItem.ID_PROPERTY, transportItemIds);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return transportProject;
		}
		if(externalTransportItemList.isEmpty()){
			return transportProject;
		}
		
		for(TransportItem transportItem: externalTransportItemList){

			transportItem.clearFromAll();
		}
		
		
		SmartList<TransportItem> transportItemList = transportProject.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return transportProject;	
	
	}


	//disconnect TransportProject with merchant in TransportItem
	public TransportProject planToRemoveTransportItemListWithMerchant(TransportProject transportProject, String merchantId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PROJECT_PROPERTY, transportProject.getId());
		key.put(TransportItem.MERCHANT_PROPERTY, merchantId);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return transportProject;
		}
		if(externalTransportItemList.isEmpty()){
			return transportProject;
		}
		
		for(TransportItem transportItem: externalTransportItemList){
			transportItem.clearMerchant();
			transportItem.clearProject();
			
		}
		
		
		SmartList<TransportItem> transportItemList = transportProject.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return transportProject;
	}
	
	public int countTransportItemListWithMerchant(String transportProjectId, String merchantId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PROJECT_PROPERTY, transportProjectId);
		key.put(TransportItem.MERCHANT_PROPERTY, merchantId);
		
		int count = getTransportItemDAO().countTransportItemWithKey(key, options);
		return count;
	}
	
	//disconnect TransportProject with platform in TransportItem
	public TransportProject planToRemoveTransportItemListWithPlatform(TransportProject transportProject, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PROJECT_PROPERTY, transportProject.getId());
		key.put(TransportItem.PLATFORM_PROPERTY, platformId);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return transportProject;
		}
		if(externalTransportItemList.isEmpty()){
			return transportProject;
		}
		
		for(TransportItem transportItem: externalTransportItemList){
			transportItem.clearPlatform();
			transportItem.clearProject();
			
		}
		
		
		SmartList<TransportItem> transportItemList = transportProject.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return transportProject;
	}
	
	public int countTransportItemListWithPlatform(String transportProjectId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PROJECT_PROPERTY, transportProjectId);
		key.put(TransportItem.PLATFORM_PROPERTY, platformId);
		
		int count = getTransportItemDAO().countTransportItemWithKey(key, options);
		return count;
	}
	

		
	protected TransportProject saveTransportItemList(TransportProject transportProject, Map<String,Object> options){
		
		
		
		
		SmartList<TransportItem> transportItemList = transportProject.getTransportItemList();
		if(transportItemList == null){
			//null list means nothing
			return transportProject;
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
		
		
		return transportProject;
	
	}
	
	protected TransportProject removeTransportItemList(TransportProject transportProject, Map<String,Object> options){
	
	
		SmartList<TransportItem> transportItemList = transportProject.getTransportItemList();
		if(transportItemList == null){
			return transportProject;
		}	
	
		SmartList<TransportItem> toRemoveTransportItemList = transportItemList.getToRemoveList();
		
		if(toRemoveTransportItemList == null){
			return transportProject;
		}
		if(toRemoveTransportItemList.isEmpty()){
			return transportProject;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportItemDAO().removeTransportItemList(toRemoveTransportItemList,options);
		
		return transportProject;
	
	}
	
	

 	
 	
	
	
	
		

	public TransportProject present(TransportProject transportProject,Map<String, Object> options){
	
		presentTransportItemList(transportProject,options);

		return transportProject;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportProject presentTransportItemList(
			TransportProject transportProject,
			Map<String, Object> options) {

		SmartList<TransportItem> transportItemList = transportProject.getTransportItemList();		
				SmartList<TransportItem> newList= presentSubList(transportProject.getId(),
				transportItemList,
				options,
				getTransportItemDAO()::countTransportItemByProject,
				getTransportItemDAO()::findTransportItemByProject
				);

		
		transportProject.setTransportItemList(newList);
		

		return transportProject;
	}			
		

	
    public SmartList<TransportProject> requestCandidateTransportProjectForTransportItem(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportProjectTable.COLUMN_NAME, filterKey, pageNo, pageSize, getTransportProjectMapper());
    }
		

	protected String getTableName(){
		return TransportProjectTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TransportProject> transportProjectList) {		
		this.enhanceListInternal(transportProjectList, this.getTransportProjectMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransportProject> transportProjectList = ownerEntity.collectRefsWithType(TransportProject.INTERNAL_TYPE);
		this.enhanceList(transportProjectList);
		
	}
	
	@Override
	public SmartList<TransportProject> findTransportProjectWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransportProjectMapper());

	}
	@Override
	public int countTransportProjectWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportProjectWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TransportProject> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportProjectMapper());
	}
}


