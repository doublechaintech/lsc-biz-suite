
package com.doublechaintech.lsc.merchant;

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


import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;

import com.doublechaintech.lsc.merchantaccount.MerchantAccountDAO;
import com.doublechaintech.lsc.merchanttype.MerchantTypeDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class MerchantJDBCTemplateDAO extends LscNamingServiceDAO implements MerchantDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}
 
 	
 	private  MerchantTypeDAO  merchantTypeDAO;
 	public void setMerchantTypeDAO(MerchantTypeDAO merchantTypeDAO){
	 	this.merchantTypeDAO = merchantTypeDAO;
 	}
 	public MerchantTypeDAO getMerchantTypeDAO(){
	 	return this.merchantTypeDAO;
 	}


			
		
	
  	private  TransportProjectDAO  transportProjectDAO;
 	public void setTransportProjectDAO(TransportProjectDAO pTransportProjectDAO){
 	
 		if(pTransportProjectDAO == null){
 			throw new IllegalStateException("Do not try to set transportProjectDAO to null.");
 		}
	 	this.transportProjectDAO = pTransportProjectDAO;
 	}
 	public TransportProjectDAO getTransportProjectDAO(){
 		if(this.transportProjectDAO == null){
 			throw new IllegalStateException("The transportProjectDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportProjectDAO;
 	}	
 	
			
		
	
  	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO pTransportTaskDAO){
 	
 		if(pTransportTaskDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskDAO to null.");
 		}
	 	this.transportTaskDAO = pTransportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
 		if(this.transportTaskDAO == null){
 			throw new IllegalStateException("The transportTaskDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskDAO;
 	}	
 	
			
		
	
  	private  MerchantAccountDAO  merchantAccountDAO;
 	public void setMerchantAccountDAO(MerchantAccountDAO pMerchantAccountDAO){
 	
 		if(pMerchantAccountDAO == null){
 			throw new IllegalStateException("Do not try to set merchantAccountDAO to null.");
 		}
	 	this.merchantAccountDAO = pMerchantAccountDAO;
 	}
 	public MerchantAccountDAO getMerchantAccountDAO(){
 		if(this.merchantAccountDAO == null){
 			throw new IllegalStateException("The merchantAccountDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.merchantAccountDAO;
 	}	
 	
			
		

	
	/*
	protected Merchant load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMerchant(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Merchant load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMerchant(MerchantTable.withId(id), options);
	}
	
	
	
	public Merchant save(Merchant merchant,Map<String,Object> options){
		
		String methodName="save(Merchant merchant,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(merchant, methodName, "merchant");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalMerchant(merchant,options);
	}
	public Merchant clone(String merchantId, Map<String,Object> options) throws Exception{
	
		return clone(MerchantTable.withId(merchantId),options);
	}
	
	protected Merchant clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String merchantId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Merchant newMerchant = loadInternalMerchant(accessKey, options);
		newMerchant.setVersion(0);
		
		
 		
 		if(isSaveTransportProjectListEnabled(options)){
 			for(TransportProject item: newMerchant.getTransportProjectList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskListAsSenderEnabled(options)){
 			for(TransportTask item: newMerchant.getTransportTaskListAsSender()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskListAsReceiverEnabled(options)){
 			for(TransportTask item: newMerchant.getTransportTaskListAsReceiver()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveMerchantAccountListEnabled(options)){
 			for(MerchantAccount item: newMerchant.getMerchantAccountList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalMerchant(newMerchant,options);
		
		return newMerchant;
	}
	
	
	
	

	protected void throwIfHasException(String merchantId,int version,int count) throws Exception{
		if (count == 1) {
			throw new MerchantVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MerchantNotFoundException(
					"The " + this.getTableName() + "(" + merchantId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String merchantId, int version) throws Exception{
	
		String methodName="delete(String merchantId, int version)";
		assertMethodArgumentNotNull(merchantId, methodName, "merchantId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{merchantId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(merchantId,version);
		}
		
	
	}
	
	
	
	
	

	public Merchant disconnectFromAll(String merchantId, int version) throws Exception{
	
		
		Merchant merchant = loadInternalMerchant(MerchantTable.withId(merchantId), emptyOptions());
		merchant.clearFromAll();
		this.saveMerchant(merchant);
		return merchant;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return MerchantTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "merchant";
	}
	@Override
	protected String getBeanName() {
		
		return "merchant";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return MerchantTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MerchantTokens.TYPE);
 	}

 	protected boolean isSaveTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MerchantTokens.TYPE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MerchantTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MerchantTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractTransportProjectListEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTokens.TRANSPORT_PROJECT_LIST);
 	}
 	protected boolean isAnalyzeTransportProjectListEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTokens.TRANSPORT_PROJECT_LIST+".analyze");
 	}

	protected boolean isSaveTransportProjectListEnabled(Map<String,Object> options){
		return checkOptions(options, MerchantTokens.TRANSPORT_PROJECT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTransportTaskListAsSenderEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTokens.TRANSPORT_TASK_LIST_AS_SENDER);
 	}
 	protected boolean isAnalyzeTransportTaskListAsSenderEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTokens.TRANSPORT_TASK_LIST_AS_SENDER+".analyze");
 	}

	protected boolean isSaveTransportTaskListAsSenderEnabled(Map<String,Object> options){
		return checkOptions(options, MerchantTokens.TRANSPORT_TASK_LIST_AS_SENDER);
		
 	}
 	
		
	
	protected boolean isExtractTransportTaskListAsReceiverEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTokens.TRANSPORT_TASK_LIST_AS_RECEIVER);
 	}
 	protected boolean isAnalyzeTransportTaskListAsReceiverEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTokens.TRANSPORT_TASK_LIST_AS_RECEIVER+".analyze");
 	}

	protected boolean isSaveTransportTaskListAsReceiverEnabled(Map<String,Object> options){
		return checkOptions(options, MerchantTokens.TRANSPORT_TASK_LIST_AS_RECEIVER);
		
 	}
 	
		
	
	protected boolean isExtractMerchantAccountListEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTokens.MERCHANT_ACCOUNT_LIST);
 	}
 	protected boolean isAnalyzeMerchantAccountListEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantTokens.MERCHANT_ACCOUNT_LIST+".analyze");
 	}

	protected boolean isSaveMerchantAccountListEnabled(Map<String,Object> options){
		return checkOptions(options, MerchantTokens.MERCHANT_ACCOUNT_LIST);
		
 	}
 	
		

	

	protected MerchantMapper getMerchantMapper(){
		return new MerchantMapper();
	}

	
	
	protected Merchant extractMerchant(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Merchant merchant = loadSingleObject(accessKey, getMerchantMapper());
			return merchant;
		}catch(EmptyResultDataAccessException e){
			throw new MerchantNotFoundException("Merchant("+accessKey+") is not found!");
		}

	}

	
	

	protected Merchant loadInternalMerchant(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Merchant merchant = extractMerchant(accessKey, loadOptions);
 	
 		if(isExtractTypeEnabled(loadOptions)){
	 		extractType(merchant, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(merchant, loadOptions);
 		}
 
		
		if(isExtractTransportProjectListEnabled(loadOptions)){
	 		extractTransportProjectList(merchant, loadOptions);
 		}	
 		if(isAnalyzeTransportProjectListEnabled(loadOptions)){
	 		// analyzeTransportProjectList(merchant, loadOptions);
 		}
 		
		
		if(isExtractTransportTaskListAsSenderEnabled(loadOptions)){
	 		extractTransportTaskListAsSender(merchant, loadOptions);
 		}	
 		if(isAnalyzeTransportTaskListAsSenderEnabled(loadOptions)){
	 		// analyzeTransportTaskListAsSender(merchant, loadOptions);
 		}
 		
		
		if(isExtractTransportTaskListAsReceiverEnabled(loadOptions)){
	 		extractTransportTaskListAsReceiver(merchant, loadOptions);
 		}	
 		if(isAnalyzeTransportTaskListAsReceiverEnabled(loadOptions)){
	 		// analyzeTransportTaskListAsReceiver(merchant, loadOptions);
 		}
 		
		
		if(isExtractMerchantAccountListEnabled(loadOptions)){
	 		extractMerchantAccountList(merchant, loadOptions);
 		}	
 		if(isAnalyzeMerchantAccountListEnabled(loadOptions)){
	 		// analyzeMerchantAccountList(merchant, loadOptions);
 		}
 		
		
		return merchant;
		
	}

	 

 	protected Merchant extractType(Merchant merchant, Map<String,Object> options) throws Exception{

		if(merchant.getType() == null){
			return merchant;
		}
		String typeId = merchant.getType().getId();
		if( typeId == null){
			return merchant;
		}
		MerchantType type = getMerchantTypeDAO().load(typeId,options);
		if(type != null){
			merchant.setType(type);
		}
		
 		
 		return merchant;
 	}
 		
  

 	protected Merchant extractPlatform(Merchant merchant, Map<String,Object> options) throws Exception{

		if(merchant.getPlatform() == null){
			return merchant;
		}
		String platformId = merchant.getPlatform().getId();
		if( platformId == null){
			return merchant;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			merchant.setPlatform(platform);
		}
		
 		
 		return merchant;
 	}
 		
 
		
	protected void enhanceTransportProjectList(SmartList<TransportProject> transportProjectList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Merchant extractTransportProjectList(Merchant merchant, Map<String,Object> options){
		
		
		if(merchant == null){
			return null;
		}
		if(merchant.getId() == null){
			return merchant;
		}

		
		
		SmartList<TransportProject> transportProjectList = getTransportProjectDAO().findTransportProjectByMerchant(merchant.getId(),options);
		if(transportProjectList != null){
			enhanceTransportProjectList(transportProjectList,options);
			merchant.setTransportProjectList(transportProjectList);
		}
		
		return merchant;
	
	}	
	
	protected Merchant analyzeTransportProjectList(Merchant merchant, Map<String,Object> options){
		
		
		if(merchant == null){
			return null;
		}
		if(merchant.getId() == null){
			return merchant;
		}

		
		
		SmartList<TransportProject> transportProjectList = merchant.getTransportProjectList();
		if(transportProjectList != null){
			getTransportProjectDAO().analyzeTransportProjectByMerchant(transportProjectList, merchant.getId(), options);
			
		}
		
		return merchant;
	
	}	
	
		
	protected void enhanceTransportTaskListAsSender(SmartList<TransportTask> transportTaskListAsSender,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Merchant extractTransportTaskListAsSender(Merchant merchant, Map<String,Object> options){
		
		
		if(merchant == null){
			return null;
		}
		if(merchant.getId() == null){
			return merchant;
		}
		convertListOptions(options,"transportTaskListAsSender","transportTaskList");

		
		
		SmartList<TransportTask> transportTaskListAsSender = getTransportTaskDAO().findTransportTaskBySender(merchant.getId(),options);
		if(transportTaskListAsSender != null){
			enhanceTransportTaskListAsSender(transportTaskListAsSender,options);
			merchant.setTransportTaskListAsSender(transportTaskListAsSender);
		}
		
		return merchant;
	
	}	
	
	protected Merchant analyzeTransportTaskListAsSender(Merchant merchant, Map<String,Object> options){
		
		
		if(merchant == null){
			return null;
		}
		if(merchant.getId() == null){
			return merchant;
		}
		convertListOptions(options,"transportTaskListAsSender","transportTaskList");

		
		
		SmartList<TransportTask> transportTaskListAsSender = merchant.getTransportTaskListAsSender();
		if(transportTaskListAsSender != null){
			getTransportTaskDAO().analyzeTransportTaskBySender(transportTaskListAsSender, merchant.getId(), options);
			
		}
		
		return merchant;
	
	}	
	
		
	protected void enhanceTransportTaskListAsReceiver(SmartList<TransportTask> transportTaskListAsReceiver,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Merchant extractTransportTaskListAsReceiver(Merchant merchant, Map<String,Object> options){
		
		
		if(merchant == null){
			return null;
		}
		if(merchant.getId() == null){
			return merchant;
		}
		convertListOptions(options,"transportTaskListAsReceiver","transportTaskList");

		
		
		SmartList<TransportTask> transportTaskListAsReceiver = getTransportTaskDAO().findTransportTaskByReceiver(merchant.getId(),options);
		if(transportTaskListAsReceiver != null){
			enhanceTransportTaskListAsReceiver(transportTaskListAsReceiver,options);
			merchant.setTransportTaskListAsReceiver(transportTaskListAsReceiver);
		}
		
		return merchant;
	
	}	
	
	protected Merchant analyzeTransportTaskListAsReceiver(Merchant merchant, Map<String,Object> options){
		
		
		if(merchant == null){
			return null;
		}
		if(merchant.getId() == null){
			return merchant;
		}
		convertListOptions(options,"transportTaskListAsReceiver","transportTaskList");

		
		
		SmartList<TransportTask> transportTaskListAsReceiver = merchant.getTransportTaskListAsReceiver();
		if(transportTaskListAsReceiver != null){
			getTransportTaskDAO().analyzeTransportTaskBySender(transportTaskListAsReceiver, merchant.getId(), options);
			
		}
		
		return merchant;
	
	}	
	
		
	protected void enhanceMerchantAccountList(SmartList<MerchantAccount> merchantAccountList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Merchant extractMerchantAccountList(Merchant merchant, Map<String,Object> options){
		
		
		if(merchant == null){
			return null;
		}
		if(merchant.getId() == null){
			return merchant;
		}

		
		
		SmartList<MerchantAccount> merchantAccountList = getMerchantAccountDAO().findMerchantAccountByMerchant(merchant.getId(),options);
		if(merchantAccountList != null){
			enhanceMerchantAccountList(merchantAccountList,options);
			merchant.setMerchantAccountList(merchantAccountList);
		}
		
		return merchant;
	
	}	
	
	protected Merchant analyzeMerchantAccountList(Merchant merchant, Map<String,Object> options){
		
		
		if(merchant == null){
			return null;
		}
		if(merchant.getId() == null){
			return merchant;
		}

		
		
		SmartList<MerchantAccount> merchantAccountList = merchant.getMerchantAccountList();
		if(merchantAccountList != null){
			getMerchantAccountDAO().analyzeMerchantAccountByMerchant(merchantAccountList, merchant.getId(), options);
			
		}
		
		return merchant;
	
	}	
	
		
		
  	
 	public SmartList<Merchant> findMerchantByType(String merchantTypeId,Map<String,Object> options){
 	
  		SmartList<Merchant> resultList = queryWith(MerchantTable.COLUMN_TYPE, merchantTypeId, options, getMerchantMapper());
		// analyzeMerchantByType(resultList, merchantTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Merchant> findMerchantByType(String merchantTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Merchant> resultList =  queryWithRange(MerchantTable.COLUMN_TYPE, merchantTypeId, options, getMerchantMapper(), start, count);
 		//analyzeMerchantByType(resultList, merchantTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeMerchantByType(SmartList<Merchant> resultList, String merchantTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Merchant.TYPE_PROPERTY, merchantTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//Merchant.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Merchant");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(Merchant.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Merchant.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countMerchantByType(String merchantTypeId,Map<String,Object> options){

 		return countWith(MerchantTable.COLUMN_TYPE, merchantTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countMerchantByTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(MerchantTable.COLUMN_TYPE, ids, options);
	}
 	
  	
 	public SmartList<Merchant> findMerchantByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Merchant> resultList = queryWith(MerchantTable.COLUMN_PLATFORM, platformId, options, getMerchantMapper());
		// analyzeMerchantByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Merchant> findMerchantByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Merchant> resultList =  queryWithRange(MerchantTable.COLUMN_PLATFORM, platformId, options, getMerchantMapper(), start, count);
 		//analyzeMerchantByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeMerchantByPlatform(SmartList<Merchant> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Merchant.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//Merchant.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Merchant");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(Merchant.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Merchant.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countMerchantByPlatform(String platformId,Map<String,Object> options){

 		return countWith(MerchantTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countMerchantByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(MerchantTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Merchant saveMerchant(Merchant  merchant){
		
		if(!merchant.isChanged()){
			return merchant;
		}
		
		
		String SQL=this.getSaveMerchantSQL(merchant);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMerchantParameters(merchant);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		merchant.incVersion();
		return merchant;
	
	}
	public SmartList<Merchant> saveMerchantList(SmartList<Merchant> merchantList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMerchantList(merchantList);
		
		batchMerchantCreate((List<Merchant>)lists[CREATE_LIST_INDEX]);
		
		batchMerchantUpdate((List<Merchant>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Merchant merchant:merchantList){
			if(merchant.isChanged()){
				merchant.incVersion();
			}
			
		
		}
		
		
		return merchantList;
	}

	public SmartList<Merchant> removeMerchantList(SmartList<Merchant> merchantList,Map<String,Object> options){
		
		
		super.removeList(merchantList, options);
		
		return merchantList;
		
		
	}
	
	protected List<Object[]> prepareMerchantBatchCreateArgs(List<Merchant> merchantList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Merchant merchant:merchantList ){
			Object [] parameters = prepareMerchantCreateParameters(merchant);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareMerchantBatchUpdateArgs(List<Merchant> merchantList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Merchant merchant:merchantList ){
			if(!merchant.isChanged()){
				continue;
			}
			Object [] parameters = prepareMerchantUpdateParameters(merchant);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchMerchantCreate(List<Merchant> merchantList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMerchantBatchCreateArgs(merchantList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchMerchantUpdate(List<Merchant> merchantList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMerchantBatchUpdateArgs(merchantList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitMerchantList(List<Merchant> merchantList){
		
		List<Merchant> merchantCreateList=new ArrayList<Merchant>();
		List<Merchant> merchantUpdateList=new ArrayList<Merchant>();
		
		for(Merchant merchant: merchantList){
			if(isUpdateRequest(merchant)){
				merchantUpdateList.add( merchant);
				continue;
			}
			merchantCreateList.add(merchant);
		}
		
		return new Object[]{merchantCreateList,merchantUpdateList};
	}
	
	protected boolean isUpdateRequest(Merchant merchant){
 		return merchant.getVersion() > 0;
 	}
 	protected String getSaveMerchantSQL(Merchant merchant){
 		if(isUpdateRequest(merchant)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveMerchantParameters(Merchant merchant){
 		if(isUpdateRequest(merchant) ){
 			return prepareMerchantUpdateParameters(merchant);
 		}
 		return prepareMerchantCreateParameters(merchant);
 	}
 	protected Object[] prepareMerchantUpdateParameters(Merchant merchant){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = merchant.getName(); 	
 		if(merchant.getType() != null){
 			parameters[1] = merchant.getType().getId();
 		}
  	
 		if(merchant.getPlatform() != null){
 			parameters[2] = merchant.getPlatform().getId();
 		}
 
 		parameters[3] = merchant.getDescription();
 		parameters[4] = merchant.getCreateTime();
 		parameters[5] = merchant.getUpdateTime();		
 		parameters[6] = merchant.nextVersion();
 		parameters[7] = merchant.getId();
 		parameters[8] = merchant.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareMerchantCreateParameters(Merchant merchant){
		Object[] parameters = new Object[7];
		String newMerchantId=getNextId();
		merchant.setId(newMerchantId);
		parameters[0] =  merchant.getId();
 
 		parameters[1] = merchant.getName(); 	
 		if(merchant.getType() != null){
 			parameters[2] = merchant.getType().getId();
 		
 		}
 		 	
 		if(merchant.getPlatform() != null){
 			parameters[3] = merchant.getPlatform().getId();
 		
 		}
 		
 		parameters[4] = merchant.getDescription();
 		parameters[5] = merchant.getCreateTime();
 		parameters[6] = merchant.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected Merchant saveInternalMerchant(Merchant merchant, Map<String,Object> options){
		
		saveMerchant(merchant);
 	
 		if(isSaveTypeEnabled(options)){
	 		saveType(merchant, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(merchant, options);
 		}
 
		
		if(isSaveTransportProjectListEnabled(options)){
	 		saveTransportProjectList(merchant, options);
	 		//removeTransportProjectList(merchant, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportTaskListAsSenderEnabled(options)){
	 		saveTransportTaskListAsSender(merchant, options);
	 		//removeTransportTaskListAsSender(merchant, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportTaskListAsReceiverEnabled(options)){
	 		saveTransportTaskListAsReceiver(merchant, options);
	 		//removeTransportTaskListAsReceiver(merchant, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveMerchantAccountListEnabled(options)){
	 		saveMerchantAccountList(merchant, options);
	 		//removeMerchantAccountList(merchant, options);
	 		//Not delete the record
	 		
 		}		
		
		return merchant;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Merchant saveType(Merchant merchant, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(merchant.getType() == null){
 			return merchant;//do nothing when it is null
 		}
 		
 		getMerchantTypeDAO().save(merchant.getType(),options);
 		return merchant;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Merchant savePlatform(Merchant merchant, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(merchant.getPlatform() == null){
 			return merchant;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(merchant.getPlatform(),options);
 		return merchant;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Merchant planToRemoveTransportProjectList(Merchant merchant, String transportProjectIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportProject.MERCHANT_PROPERTY, merchant.getId());
		key.put(TransportProject.ID_PROPERTY, transportProjectIds);
		
		SmartList<TransportProject> externalTransportProjectList = getTransportProjectDAO().
				findTransportProjectWithKey(key, options);
		if(externalTransportProjectList == null){
			return merchant;
		}
		if(externalTransportProjectList.isEmpty()){
			return merchant;
		}
		
		for(TransportProject transportProject: externalTransportProjectList){

			transportProject.clearFromAll();
		}
		
		
		SmartList<TransportProject> transportProjectList = merchant.getTransportProjectList();		
		transportProjectList.addAllToRemoveList(externalTransportProjectList);
		return merchant;	
	
	}


	//disconnect Merchant with platform in TransportProject
	public Merchant planToRemoveTransportProjectListWithPlatform(Merchant merchant, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportProject.MERCHANT_PROPERTY, merchant.getId());
		key.put(TransportProject.PLATFORM_PROPERTY, platformId);
		
		SmartList<TransportProject> externalTransportProjectList = getTransportProjectDAO().
				findTransportProjectWithKey(key, options);
		if(externalTransportProjectList == null){
			return merchant;
		}
		if(externalTransportProjectList.isEmpty()){
			return merchant;
		}
		
		for(TransportProject transportProject: externalTransportProjectList){
			transportProject.clearPlatform();
			transportProject.clearMerchant();
			
		}
		
		
		SmartList<TransportProject> transportProjectList = merchant.getTransportProjectList();		
		transportProjectList.addAllToRemoveList(externalTransportProjectList);
		return merchant;
	}
	
	public int countTransportProjectListWithPlatform(String merchantId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportProject.MERCHANT_PROPERTY, merchantId);
		key.put(TransportProject.PLATFORM_PROPERTY, platformId);
		
		int count = getTransportProjectDAO().countTransportProjectWithKey(key, options);
		return count;
	}
	
	public Merchant planToRemoveTransportTaskListAsSender(Merchant merchant, String transportTaskIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){

			transportTask.clearFromAll();
		}
		
		
		SmartList<TransportTask> transportTaskListAsSender = merchant.getTransportTaskListAsSender();		
		transportTaskListAsSender.addAllToRemoveList(externalTransportTaskList);
		return merchant;	
	
	}


	//disconnect Merchant with source in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithSource(Merchant merchant, String sourceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.SOURCE_PROPERTY, sourceId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearSource();
			transportTask.clearSender();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = merchant.getTransportTaskListAsSender();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return merchant;
	}
	
	public int countTransportTaskListAsSenderWithSource(String merchantId, String sourceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchantId);
		key.put(TransportTask.SOURCE_PROPERTY, sourceId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Merchant with destination in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithDestination(Merchant merchant, String destinationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.DESTINATION_PROPERTY, destinationId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearDestination();
			transportTask.clearSender();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = merchant.getTransportTaskListAsSender();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return merchant;
	}
	
	public int countTransportTaskListAsSenderWithDestination(String merchantId, String destinationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchantId);
		key.put(TransportTask.DESTINATION_PROPERTY, destinationId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Merchant with status in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithStatus(Merchant merchant, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearStatus();
			transportTask.clearSender();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = merchant.getTransportTaskListAsSender();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return merchant;
	}
	
	public int countTransportTaskListAsSenderWithStatus(String merchantId, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchantId);
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Merchant with platform in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithPlatform(Merchant merchant, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearPlatform();
			transportTask.clearSender();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = merchant.getTransportTaskListAsSender();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return merchant;
	}
	
	public int countTransportTaskListAsSenderWithPlatform(String merchantId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchantId);
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	public Merchant planToRemoveTransportTaskListAsReceiver(Merchant merchant, String transportTaskIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){

			transportTask.clearFromAll();
		}
		
		
		SmartList<TransportTask> transportTaskListAsReceiver = merchant.getTransportTaskListAsReceiver();		
		transportTaskListAsReceiver.addAllToRemoveList(externalTransportTaskList);
		return merchant;	
	
	}


	//disconnect Merchant with source in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithSource(Merchant merchant, String sourceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.SOURCE_PROPERTY, sourceId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearSource();
			transportTask.clearSender();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = merchant.getTransportTaskListAsSender();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return merchant;
	}
	
	public int countTransportTaskListAsReceiverWithSource(String merchantId, String sourceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchantId);
		key.put(TransportTask.SOURCE_PROPERTY, sourceId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Merchant with destination in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithDestination(Merchant merchant, String destinationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.DESTINATION_PROPERTY, destinationId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearDestination();
			transportTask.clearSender();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = merchant.getTransportTaskListAsSender();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return merchant;
	}
	
	public int countTransportTaskListAsReceiverWithDestination(String merchantId, String destinationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchantId);
		key.put(TransportTask.DESTINATION_PROPERTY, destinationId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Merchant with status in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithStatus(Merchant merchant, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearStatus();
			transportTask.clearSender();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = merchant.getTransportTaskListAsSender();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return merchant;
	}
	
	public int countTransportTaskListAsReceiverWithStatus(String merchantId, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchantId);
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Merchant with platform in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithPlatform(Merchant merchant, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchant.getId());
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return merchant;
		}
		if(externalTransportTaskList.isEmpty()){
			return merchant;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearPlatform();
			transportTask.clearSender();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = merchant.getTransportTaskListAsSender();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return merchant;
	}
	
	public int countTransportTaskListAsReceiverWithPlatform(String merchantId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SENDER_PROPERTY, merchantId);
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	public Merchant planToRemoveMerchantAccountList(Merchant merchant, String merchantAccountIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(MerchantAccount.MERCHANT_PROPERTY, merchant.getId());
		key.put(MerchantAccount.ID_PROPERTY, merchantAccountIds);
		
		SmartList<MerchantAccount> externalMerchantAccountList = getMerchantAccountDAO().
				findMerchantAccountWithKey(key, options);
		if(externalMerchantAccountList == null){
			return merchant;
		}
		if(externalMerchantAccountList.isEmpty()){
			return merchant;
		}
		
		for(MerchantAccount merchantAccount: externalMerchantAccountList){

			merchantAccount.clearFromAll();
		}
		
		
		SmartList<MerchantAccount> merchantAccountList = merchant.getMerchantAccountList();		
		merchantAccountList.addAllToRemoveList(externalMerchantAccountList);
		return merchant;	
	
	}



		
	protected Merchant saveTransportProjectList(Merchant merchant, Map<String,Object> options){
		
		
		
		
		SmartList<TransportProject> transportProjectList = merchant.getTransportProjectList();
		if(transportProjectList == null){
			//null list means nothing
			return merchant;
		}
		SmartList<TransportProject> mergedUpdateTransportProjectList = new SmartList<TransportProject>();
		
		
		mergedUpdateTransportProjectList.addAll(transportProjectList); 
		if(transportProjectList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportProjectList.addAll(transportProjectList.getToRemoveList());
			transportProjectList.removeAll(transportProjectList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportProjectDAO().saveTransportProjectList(mergedUpdateTransportProjectList,options);
		
		if(transportProjectList.getToRemoveList() != null){
			transportProjectList.removeAll(transportProjectList.getToRemoveList());
		}
		
		
		return merchant;
	
	}
	
	protected Merchant removeTransportProjectList(Merchant merchant, Map<String,Object> options){
	
	
		SmartList<TransportProject> transportProjectList = merchant.getTransportProjectList();
		if(transportProjectList == null){
			return merchant;
		}	
	
		SmartList<TransportProject> toRemoveTransportProjectList = transportProjectList.getToRemoveList();
		
		if(toRemoveTransportProjectList == null){
			return merchant;
		}
		if(toRemoveTransportProjectList.isEmpty()){
			return merchant;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportProjectDAO().removeTransportProjectList(toRemoveTransportProjectList,options);
		
		return merchant;
	
	}
	
	

 	
 	
	
	
	
		
	protected Merchant saveTransportTaskListAsSender(Merchant merchant, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTask> transportTaskListAsSender = merchant.getTransportTaskListAsSender();
		if(transportTaskListAsSender == null){
			//null list means nothing
			return merchant;
		}
		SmartList<TransportTask> mergedUpdateTransportTaskListAsSender = new SmartList<TransportTask>();
		
		
		mergedUpdateTransportTaskListAsSender.addAll(transportTaskListAsSender); 
		if(transportTaskListAsSender.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskListAsSender.addAll(transportTaskListAsSender.getToRemoveList());
			transportTaskListAsSender.removeAll(transportTaskListAsSender.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportTaskDAO().saveTransportTaskList(mergedUpdateTransportTaskListAsSender,options);
		
		if(transportTaskListAsSender.getToRemoveList() != null){
			transportTaskListAsSender.removeAll(transportTaskListAsSender.getToRemoveList());
		}
		
		
		return merchant;
	
	}
	
	protected Merchant removeTransportTaskListAsSender(Merchant merchant, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskListAsSender = merchant.getTransportTaskListAsSender();
		if(transportTaskListAsSender == null){
			return merchant;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskListAsSender = transportTaskListAsSender.getToRemoveList();
		
		if(toRemoveTransportTaskListAsSender == null){
			return merchant;
		}
		if(toRemoveTransportTaskListAsSender.isEmpty()){
			return merchant;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskListAsSender,options);
		
		return merchant;
	
	}
	
	

 	
 	
	
	
	
		
	protected Merchant saveTransportTaskListAsReceiver(Merchant merchant, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTask> transportTaskListAsReceiver = merchant.getTransportTaskListAsReceiver();
		if(transportTaskListAsReceiver == null){
			//null list means nothing
			return merchant;
		}
		SmartList<TransportTask> mergedUpdateTransportTaskListAsReceiver = new SmartList<TransportTask>();
		
		
		mergedUpdateTransportTaskListAsReceiver.addAll(transportTaskListAsReceiver); 
		if(transportTaskListAsReceiver.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskListAsReceiver.addAll(transportTaskListAsReceiver.getToRemoveList());
			transportTaskListAsReceiver.removeAll(transportTaskListAsReceiver.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportTaskDAO().saveTransportTaskList(mergedUpdateTransportTaskListAsReceiver,options);
		
		if(transportTaskListAsReceiver.getToRemoveList() != null){
			transportTaskListAsReceiver.removeAll(transportTaskListAsReceiver.getToRemoveList());
		}
		
		
		return merchant;
	
	}
	
	protected Merchant removeTransportTaskListAsReceiver(Merchant merchant, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskListAsReceiver = merchant.getTransportTaskListAsReceiver();
		if(transportTaskListAsReceiver == null){
			return merchant;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskListAsReceiver = transportTaskListAsReceiver.getToRemoveList();
		
		if(toRemoveTransportTaskListAsReceiver == null){
			return merchant;
		}
		if(toRemoveTransportTaskListAsReceiver.isEmpty()){
			return merchant;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskListAsReceiver,options);
		
		return merchant;
	
	}
	
	

 	
 	
	
	
	
		
	protected Merchant saveMerchantAccountList(Merchant merchant, Map<String,Object> options){
		
		
		
		
		SmartList<MerchantAccount> merchantAccountList = merchant.getMerchantAccountList();
		if(merchantAccountList == null){
			//null list means nothing
			return merchant;
		}
		SmartList<MerchantAccount> mergedUpdateMerchantAccountList = new SmartList<MerchantAccount>();
		
		
		mergedUpdateMerchantAccountList.addAll(merchantAccountList); 
		if(merchantAccountList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateMerchantAccountList.addAll(merchantAccountList.getToRemoveList());
			merchantAccountList.removeAll(merchantAccountList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getMerchantAccountDAO().saveMerchantAccountList(mergedUpdateMerchantAccountList,options);
		
		if(merchantAccountList.getToRemoveList() != null){
			merchantAccountList.removeAll(merchantAccountList.getToRemoveList());
		}
		
		
		return merchant;
	
	}
	
	protected Merchant removeMerchantAccountList(Merchant merchant, Map<String,Object> options){
	
	
		SmartList<MerchantAccount> merchantAccountList = merchant.getMerchantAccountList();
		if(merchantAccountList == null){
			return merchant;
		}	
	
		SmartList<MerchantAccount> toRemoveMerchantAccountList = merchantAccountList.getToRemoveList();
		
		if(toRemoveMerchantAccountList == null){
			return merchant;
		}
		if(toRemoveMerchantAccountList.isEmpty()){
			return merchant;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getMerchantAccountDAO().removeMerchantAccountList(toRemoveMerchantAccountList,options);
		
		return merchant;
	
	}
	
	

 	
 	
	
	
	
		

	public Merchant present(Merchant merchant,Map<String, Object> options){
	
		presentTransportProjectList(merchant,options);
		presentTransportTaskListAsSender(merchant,options);
		presentTransportTaskListAsReceiver(merchant,options);
		presentMerchantAccountList(merchant,options);

		return merchant;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Merchant presentTransportProjectList(
			Merchant merchant,
			Map<String, Object> options) {

		SmartList<TransportProject> transportProjectList = merchant.getTransportProjectList();		
				SmartList<TransportProject> newList= presentSubList(merchant.getId(),
				transportProjectList,
				options,
				getTransportProjectDAO()::countTransportProjectByMerchant,
				getTransportProjectDAO()::findTransportProjectByMerchant
				);

		
		merchant.setTransportProjectList(newList);
		

		return merchant;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Merchant presentTransportTaskListAsSender(
			Merchant merchant,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskListAsSender = merchant.getTransportTaskListAsSender();		
				SmartList<TransportTask> newList= presentSubList(merchant.getId(),
				transportTaskListAsSender,
				options,
				getTransportTaskDAO()::countTransportTaskBySender,
				getTransportTaskDAO()::findTransportTaskBySender
				);

		
		merchant.setTransportTaskListAsSender(newList);
		

		return merchant;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Merchant presentTransportTaskListAsReceiver(
			Merchant merchant,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskListAsReceiver = merchant.getTransportTaskListAsReceiver();		
				SmartList<TransportTask> newList= presentSubList(merchant.getId(),
				transportTaskListAsReceiver,
				options,
				getTransportTaskDAO()::countTransportTaskByReceiver,
				getTransportTaskDAO()::findTransportTaskByReceiver
				);

		
		merchant.setTransportTaskListAsReceiver(newList);
		

		return merchant;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Merchant presentMerchantAccountList(
			Merchant merchant,
			Map<String, Object> options) {

		SmartList<MerchantAccount> merchantAccountList = merchant.getMerchantAccountList();		
				SmartList<MerchantAccount> newList= presentSubList(merchant.getId(),
				merchantAccountList,
				options,
				getMerchantAccountDAO()::countMerchantAccountByMerchant,
				getMerchantAccountDAO()::findMerchantAccountByMerchant
				);

		
		merchant.setMerchantAccountList(newList);
		

		return merchant;
	}			
		

	
    public SmartList<Merchant> requestCandidateMerchantForTransportProject(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MerchantTable.COLUMN_NAME, filterKey, pageNo, pageSize, getMerchantMapper());
    }
		
    public SmartList<Merchant> requestCandidateMerchantForTransportTaskAsSender(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MerchantTable.COLUMN_NAME, filterKey, pageNo, pageSize, getMerchantMapper());
    }
		
    public SmartList<Merchant> requestCandidateMerchantForTransportTaskAsReceiver(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MerchantTable.COLUMN_NAME, filterKey, pageNo, pageSize, getMerchantMapper());
    }
		
    public SmartList<Merchant> requestCandidateMerchantForMerchantAccount(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MerchantTable.COLUMN_NAME, filterKey, pageNo, pageSize, getMerchantMapper());
    }
		

	protected String getTableName(){
		return MerchantTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Merchant> merchantList) {		
		this.enhanceListInternal(merchantList, this.getMerchantMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Merchant> merchantList = ownerEntity.collectRefsWithType(Merchant.INTERNAL_TYPE);
		this.enhanceList(merchantList);
		
	}
	
	@Override
	public SmartList<Merchant> findMerchantWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getMerchantMapper());

	}
	@Override
	public int countMerchantWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countMerchantWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Merchant> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getMerchantMapper());
	}
}


