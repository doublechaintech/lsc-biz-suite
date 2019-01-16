
package com.doublechaintech.lsc.platform;

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
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.transactiontype.TransactionType;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.merchanttype.MerchantType;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;

import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatusDAO;
import com.doublechaintech.lsc.transactiontype.TransactionTypeDAO;
import com.doublechaintech.lsc.merchanttype.MerchantTypeDAO;
import com.doublechaintech.lsc.location.LocationDAO;
import com.doublechaintech.lsc.merchant.MerchantDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.transportitem.TransportItemDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class PlatformJDBCTemplateDAO extends LscNamingServiceDAO implements PlatformDAO{


			
		
	
  	private  TransactionTypeDAO  transactionTypeDAO;
 	public void setTransactionTypeDAO(TransactionTypeDAO pTransactionTypeDAO){
 	
 		if(pTransactionTypeDAO == null){
 			throw new IllegalStateException("Do not try to set transactionTypeDAO to null.");
 		}
	 	this.transactionTypeDAO = pTransactionTypeDAO;
 	}
 	public TransactionTypeDAO getTransactionTypeDAO(){
 		if(this.transactionTypeDAO == null){
 			throw new IllegalStateException("The transactionTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transactionTypeDAO;
 	}	
 	
			
		
	
  	private  MerchantTypeDAO  merchantTypeDAO;
 	public void setMerchantTypeDAO(MerchantTypeDAO pMerchantTypeDAO){
 	
 		if(pMerchantTypeDAO == null){
 			throw new IllegalStateException("Do not try to set merchantTypeDAO to null.");
 		}
	 	this.merchantTypeDAO = pMerchantTypeDAO;
 	}
 	public MerchantTypeDAO getMerchantTypeDAO(){
 		if(this.merchantTypeDAO == null){
 			throw new IllegalStateException("The merchantTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.merchantTypeDAO;
 	}	
 	
			
		
	
  	private  TransportTaskStatusDAO  transportTaskStatusDAO;
 	public void setTransportTaskStatusDAO(TransportTaskStatusDAO pTransportTaskStatusDAO){
 	
 		if(pTransportTaskStatusDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskStatusDAO to null.");
 		}
	 	this.transportTaskStatusDAO = pTransportTaskStatusDAO;
 	}
 	public TransportTaskStatusDAO getTransportTaskStatusDAO(){
 		if(this.transportTaskStatusDAO == null){
 			throw new IllegalStateException("The transportTaskStatusDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskStatusDAO;
 	}	
 	
			
		
	
  	private  LocationDAO  locationDAO;
 	public void setLocationDAO(LocationDAO pLocationDAO){
 	
 		if(pLocationDAO == null){
 			throw new IllegalStateException("Do not try to set locationDAO to null.");
 		}
	 	this.locationDAO = pLocationDAO;
 	}
 	public LocationDAO getLocationDAO(){
 		if(this.locationDAO == null){
 			throw new IllegalStateException("The locationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.locationDAO;
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
 	
			
		

	
	/*
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveTransactionTypeListEnabled(options)){
 			for(TransactionType item: newPlatform.getTransactionTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveMerchantTypeListEnabled(options)){
 			for(MerchantType item: newPlatform.getMerchantTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskStatusListEnabled(options)){
 			for(TransportTaskStatus item: newPlatform.getTransportTaskStatusList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveLocationListEnabled(options)){
 			for(Location item: newPlatform.getLocationList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveMerchantListEnabled(options)){
 			for(Merchant item: newPlatform.getMerchantList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportProjectListEnabled(options)){
 			for(TransportProject item: newPlatform.getTransportProjectList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportItemListEnabled(options)){
 			for(TransportItem item: newPlatform.getTransportItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newPlatform.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractTransactionTypeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSACTION_TYPE_LIST);
 	}
 	protected boolean isAnalyzeTransactionTypeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSACTION_TYPE_LIST+".analyze");
 	}

	protected boolean isSaveTransactionTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.TRANSACTION_TYPE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractMerchantTypeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.MERCHANT_TYPE_LIST);
 	}
 	protected boolean isAnalyzeMerchantTypeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.MERCHANT_TYPE_LIST+".analyze");
 	}

	protected boolean isSaveMerchantTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.MERCHANT_TYPE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTransportTaskStatusListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSPORT_TASK_STATUS_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskStatusListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSPORT_TASK_STATUS_LIST+".analyze");
 	}

	protected boolean isSaveTransportTaskStatusListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.TRANSPORT_TASK_STATUS_LIST);
		
 	}
 	
		
	
	protected boolean isExtractLocationListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.LOCATION_LIST);
 	}
 	protected boolean isAnalyzeLocationListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.LOCATION_LIST+".analyze");
 	}

	protected boolean isSaveLocationListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.LOCATION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractMerchantListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.MERCHANT_LIST);
 	}
 	protected boolean isAnalyzeMerchantListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.MERCHANT_LIST+".analyze");
 	}

	protected boolean isSaveMerchantListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.MERCHANT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTransportProjectListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSPORT_PROJECT_LIST);
 	}
 	protected boolean isAnalyzeTransportProjectListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSPORT_PROJECT_LIST+".analyze");
 	}

	protected boolean isSaveTransportProjectListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.TRANSPORT_PROJECT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTransportItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSPORT_ITEM_LIST);
 	}
 	protected boolean isAnalyzeTransportItemListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSPORT_ITEM_LIST+".analyze");
 	}

	protected boolean isSaveTransportItemListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.TRANSPORT_ITEM_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSPORT_TASK_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TRANSPORT_TASK_LIST+".analyze");
 	}

	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.TRANSPORT_TASK_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractTransactionTypeListEnabled(loadOptions)){
	 		extractTransactionTypeList(platform, loadOptions);
 		}	
 		if(isAnalyzeTransactionTypeListEnabled(loadOptions)){
	 		// analyzeTransactionTypeList(platform, loadOptions);
 		}
 		
		
		if(isExtractMerchantTypeListEnabled(loadOptions)){
	 		extractMerchantTypeList(platform, loadOptions);
 		}	
 		if(isAnalyzeMerchantTypeListEnabled(loadOptions)){
	 		// analyzeMerchantTypeList(platform, loadOptions);
 		}
 		
		
		if(isExtractTransportTaskStatusListEnabled(loadOptions)){
	 		extractTransportTaskStatusList(platform, loadOptions);
 		}	
 		if(isAnalyzeTransportTaskStatusListEnabled(loadOptions)){
	 		// analyzeTransportTaskStatusList(platform, loadOptions);
 		}
 		
		
		if(isExtractLocationListEnabled(loadOptions)){
	 		extractLocationList(platform, loadOptions);
 		}	
 		if(isAnalyzeLocationListEnabled(loadOptions)){
	 		// analyzeLocationList(platform, loadOptions);
 		}
 		
		
		if(isExtractMerchantListEnabled(loadOptions)){
	 		extractMerchantList(platform, loadOptions);
 		}	
 		if(isAnalyzeMerchantListEnabled(loadOptions)){
	 		// analyzeMerchantList(platform, loadOptions);
 		}
 		
		
		if(isExtractTransportProjectListEnabled(loadOptions)){
	 		extractTransportProjectList(platform, loadOptions);
 		}	
 		if(isAnalyzeTransportProjectListEnabled(loadOptions)){
	 		// analyzeTransportProjectList(platform, loadOptions);
 		}
 		
		
		if(isExtractTransportItemListEnabled(loadOptions)){
	 		extractTransportItemList(platform, loadOptions);
 		}	
 		if(isAnalyzeTransportItemListEnabled(loadOptions)){
	 		// analyzeTransportItemList(platform, loadOptions);
 		}
 		
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(platform, loadOptions);
 		}	
 		if(isAnalyzeTransportTaskListEnabled(loadOptions)){
	 		// analyzeTransportTaskList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceTransactionTypeList(SmartList<TransactionType> transactionTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractTransactionTypeList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransactionType> transactionTypeList = getTransactionTypeDAO().findTransactionTypeByPlatform(platform.getId(),options);
		if(transactionTypeList != null){
			enhanceTransactionTypeList(transactionTypeList,options);
			platform.setTransactionTypeList(transactionTypeList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeTransactionTypeList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransactionType> transactionTypeList = platform.getTransactionTypeList();
		if(transactionTypeList != null){
			getTransactionTypeDAO().analyzeTransactionTypeByPlatform(transactionTypeList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceMerchantTypeList(SmartList<MerchantType> merchantTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractMerchantTypeList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<MerchantType> merchantTypeList = getMerchantTypeDAO().findMerchantTypeByPlatform(platform.getId(),options);
		if(merchantTypeList != null){
			enhanceMerchantTypeList(merchantTypeList,options);
			platform.setMerchantTypeList(merchantTypeList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeMerchantTypeList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<MerchantType> merchantTypeList = platform.getMerchantTypeList();
		if(merchantTypeList != null){
			getMerchantTypeDAO().analyzeMerchantTypeByPlatform(merchantTypeList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceTransportTaskStatusList(SmartList<TransportTaskStatus> transportTaskStatusList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractTransportTaskStatusList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransportTaskStatus> transportTaskStatusList = getTransportTaskStatusDAO().findTransportTaskStatusByPlatform(platform.getId(),options);
		if(transportTaskStatusList != null){
			enhanceTransportTaskStatusList(transportTaskStatusList,options);
			platform.setTransportTaskStatusList(transportTaskStatusList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeTransportTaskStatusList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransportTaskStatus> transportTaskStatusList = platform.getTransportTaskStatusList();
		if(transportTaskStatusList != null){
			getTransportTaskStatusDAO().analyzeTransportTaskStatusByPlatform(transportTaskStatusList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceLocationList(SmartList<Location> locationList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractLocationList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Location> locationList = getLocationDAO().findLocationByPlatform(platform.getId(),options);
		if(locationList != null){
			enhanceLocationList(locationList,options);
			platform.setLocationList(locationList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeLocationList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Location> locationList = platform.getLocationList();
		if(locationList != null){
			getLocationDAO().analyzeLocationByPlatform(locationList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceMerchantList(SmartList<Merchant> merchantList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractMerchantList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Merchant> merchantList = getMerchantDAO().findMerchantByPlatform(platform.getId(),options);
		if(merchantList != null){
			enhanceMerchantList(merchantList,options);
			platform.setMerchantList(merchantList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeMerchantList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Merchant> merchantList = platform.getMerchantList();
		if(merchantList != null){
			getMerchantDAO().analyzeMerchantByPlatform(merchantList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceTransportProjectList(SmartList<TransportProject> transportProjectList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractTransportProjectList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransportProject> transportProjectList = getTransportProjectDAO().findTransportProjectByPlatform(platform.getId(),options);
		if(transportProjectList != null){
			enhanceTransportProjectList(transportProjectList,options);
			platform.setTransportProjectList(transportProjectList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeTransportProjectList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransportProject> transportProjectList = platform.getTransportProjectList();
		if(transportProjectList != null){
			getTransportProjectDAO().analyzeTransportProjectByPlatform(transportProjectList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceTransportItemList(SmartList<TransportItem> transportItemList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractTransportItemList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransportItem> transportItemList = getTransportItemDAO().findTransportItemByPlatform(platform.getId(),options);
		if(transportItemList != null){
			enhanceTransportItemList(transportItemList,options);
			platform.setTransportItemList(transportItemList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeTransportItemList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransportItem> transportItemList = platform.getTransportItemList();
		if(transportItemList != null){
			getTransportItemDAO().analyzeTransportItemByPlatform(transportItemList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractTransportTaskList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByPlatform(platform.getId(),options);
		if(transportTaskList != null){
			enhanceTransportTaskList(transportTaskList,options);
			platform.setTransportTaskList(transportTaskList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeTransportTaskList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();
		if(transportTaskList != null){
			getTransportTaskDAO().analyzeTransportTaskByPlatform(transportTaskList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = platform.getName();
 		parameters[1] = platform.getIntroduction();
 		parameters[2] = platform.getCurrentVersion();		
 		parameters[3] = platform.nextVersion();
 		parameters[4] = platform.getId();
 		parameters[5] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[4];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();
 		parameters[2] = platform.getIntroduction();
 		parameters[3] = platform.getCurrentVersion();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveTransactionTypeListEnabled(options)){
	 		saveTransactionTypeList(platform, options);
	 		//removeTransactionTypeList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveMerchantTypeListEnabled(options)){
	 		saveMerchantTypeList(platform, options);
	 		//removeMerchantTypeList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportTaskStatusListEnabled(options)){
	 		saveTransportTaskStatusList(platform, options);
	 		//removeTransportTaskStatusList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveLocationListEnabled(options)){
	 		saveLocationList(platform, options);
	 		//removeLocationList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveMerchantListEnabled(options)){
	 		saveMerchantList(platform, options);
	 		//removeMerchantList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportProjectListEnabled(options)){
	 		saveTransportProjectList(platform, options);
	 		//removeTransportProjectList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportItemListEnabled(options)){
	 		saveTransportItemList(platform, options);
	 		//removeTransportItemList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(platform, options);
	 		//removeTransportTaskList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveTransactionTypeList(Platform platform, String transactionTypeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransactionType.PLATFORM_PROPERTY, platform.getId());
		key.put(TransactionType.ID_PROPERTY, transactionTypeIds);
		
		SmartList<TransactionType> externalTransactionTypeList = getTransactionTypeDAO().
				findTransactionTypeWithKey(key, options);
		if(externalTransactionTypeList == null){
			return platform;
		}
		if(externalTransactionTypeList.isEmpty()){
			return platform;
		}
		
		for(TransactionType transactionType: externalTransactionTypeList){

			transactionType.clearFromAll();
		}
		
		
		SmartList<TransactionType> transactionTypeList = platform.getTransactionTypeList();		
		transactionTypeList.addAllToRemoveList(externalTransactionTypeList);
		return platform;	
	
	}


	public Platform planToRemoveMerchantTypeList(Platform platform, String merchantTypeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(MerchantType.PLATFORM_PROPERTY, platform.getId());
		key.put(MerchantType.ID_PROPERTY, merchantTypeIds);
		
		SmartList<MerchantType> externalMerchantTypeList = getMerchantTypeDAO().
				findMerchantTypeWithKey(key, options);
		if(externalMerchantTypeList == null){
			return platform;
		}
		if(externalMerchantTypeList.isEmpty()){
			return platform;
		}
		
		for(MerchantType merchantType: externalMerchantTypeList){

			merchantType.clearFromAll();
		}
		
		
		SmartList<MerchantType> merchantTypeList = platform.getMerchantTypeList();		
		merchantTypeList.addAllToRemoveList(externalMerchantTypeList);
		return platform;	
	
	}


	public Platform planToRemoveTransportTaskStatusList(Platform platform, String transportTaskStatusIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTaskStatus.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportTaskStatus.ID_PROPERTY, transportTaskStatusIds);
		
		SmartList<TransportTaskStatus> externalTransportTaskStatusList = getTransportTaskStatusDAO().
				findTransportTaskStatusWithKey(key, options);
		if(externalTransportTaskStatusList == null){
			return platform;
		}
		if(externalTransportTaskStatusList.isEmpty()){
			return platform;
		}
		
		for(TransportTaskStatus transportTaskStatus: externalTransportTaskStatusList){

			transportTaskStatus.clearFromAll();
		}
		
		
		SmartList<TransportTaskStatus> transportTaskStatusList = platform.getTransportTaskStatusList();		
		transportTaskStatusList.addAllToRemoveList(externalTransportTaskStatusList);
		return platform;	
	
	}


	public Platform planToRemoveLocationList(Platform platform, String locationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Location.PLATFORM_PROPERTY, platform.getId());
		key.put(Location.ID_PROPERTY, locationIds);
		
		SmartList<Location> externalLocationList = getLocationDAO().
				findLocationWithKey(key, options);
		if(externalLocationList == null){
			return platform;
		}
		if(externalLocationList.isEmpty()){
			return platform;
		}
		
		for(Location location: externalLocationList){

			location.clearFromAll();
		}
		
		
		SmartList<Location> locationList = platform.getLocationList();		
		locationList.addAllToRemoveList(externalLocationList);
		return platform;	
	
	}


	public Platform planToRemoveMerchantList(Platform platform, String merchantIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Merchant.PLATFORM_PROPERTY, platform.getId());
		key.put(Merchant.ID_PROPERTY, merchantIds);
		
		SmartList<Merchant> externalMerchantList = getMerchantDAO().
				findMerchantWithKey(key, options);
		if(externalMerchantList == null){
			return platform;
		}
		if(externalMerchantList.isEmpty()){
			return platform;
		}
		
		for(Merchant merchant: externalMerchantList){

			merchant.clearFromAll();
		}
		
		
		SmartList<Merchant> merchantList = platform.getMerchantList();		
		merchantList.addAllToRemoveList(externalMerchantList);
		return platform;	
	
	}


	//disconnect Platform with type in Merchant
	public Platform planToRemoveMerchantListWithType(Platform platform, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Merchant.PLATFORM_PROPERTY, platform.getId());
		key.put(Merchant.TYPE_PROPERTY, typeId);
		
		SmartList<Merchant> externalMerchantList = getMerchantDAO().
				findMerchantWithKey(key, options);
		if(externalMerchantList == null){
			return platform;
		}
		if(externalMerchantList.isEmpty()){
			return platform;
		}
		
		for(Merchant merchant: externalMerchantList){
			merchant.clearType();
			merchant.clearPlatform();
			
		}
		
		
		SmartList<Merchant> merchantList = platform.getMerchantList();		
		merchantList.addAllToRemoveList(externalMerchantList);
		return platform;
	}
	
	public int countMerchantListWithType(String platformId, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Merchant.PLATFORM_PROPERTY, platformId);
		key.put(Merchant.TYPE_PROPERTY, typeId);
		
		int count = getMerchantDAO().countMerchantWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveTransportProjectList(Platform platform, String transportProjectIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportProject.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportProject.ID_PROPERTY, transportProjectIds);
		
		SmartList<TransportProject> externalTransportProjectList = getTransportProjectDAO().
				findTransportProjectWithKey(key, options);
		if(externalTransportProjectList == null){
			return platform;
		}
		if(externalTransportProjectList.isEmpty()){
			return platform;
		}
		
		for(TransportProject transportProject: externalTransportProjectList){

			transportProject.clearFromAll();
		}
		
		
		SmartList<TransportProject> transportProjectList = platform.getTransportProjectList();		
		transportProjectList.addAllToRemoveList(externalTransportProjectList);
		return platform;	
	
	}


	//disconnect Platform with merchant in TransportProject
	public Platform planToRemoveTransportProjectListWithMerchant(Platform platform, String merchantId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportProject.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportProject.MERCHANT_PROPERTY, merchantId);
		
		SmartList<TransportProject> externalTransportProjectList = getTransportProjectDAO().
				findTransportProjectWithKey(key, options);
		if(externalTransportProjectList == null){
			return platform;
		}
		if(externalTransportProjectList.isEmpty()){
			return platform;
		}
		
		for(TransportProject transportProject: externalTransportProjectList){
			transportProject.clearMerchant();
			transportProject.clearPlatform();
			
		}
		
		
		SmartList<TransportProject> transportProjectList = platform.getTransportProjectList();		
		transportProjectList.addAllToRemoveList(externalTransportProjectList);
		return platform;
	}
	
	public int countTransportProjectListWithMerchant(String platformId, String merchantId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportProject.PLATFORM_PROPERTY, platformId);
		key.put(TransportProject.MERCHANT_PROPERTY, merchantId);
		
		int count = getTransportProjectDAO().countTransportProjectWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveTransportItemList(Platform platform, String transportItemIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportItem.ID_PROPERTY, transportItemIds);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return platform;
		}
		if(externalTransportItemList.isEmpty()){
			return platform;
		}
		
		for(TransportItem transportItem: externalTransportItemList){

			transportItem.clearFromAll();
		}
		
		
		SmartList<TransportItem> transportItemList = platform.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return platform;	
	
	}


	//disconnect Platform with project in TransportItem
	public Platform planToRemoveTransportItemListWithProject(Platform platform, String projectId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportItem.PROJECT_PROPERTY, projectId);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return platform;
		}
		if(externalTransportItemList.isEmpty()){
			return platform;
		}
		
		for(TransportItem transportItem: externalTransportItemList){
			transportItem.clearProject();
			transportItem.clearPlatform();
			
		}
		
		
		SmartList<TransportItem> transportItemList = platform.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return platform;
	}
	
	public int countTransportItemListWithProject(String platformId, String projectId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PLATFORM_PROPERTY, platformId);
		key.put(TransportItem.PROJECT_PROPERTY, projectId);
		
		int count = getTransportItemDAO().countTransportItemWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with merchant in TransportItem
	public Platform planToRemoveTransportItemListWithMerchant(Platform platform, String merchantId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportItem.MERCHANT_PROPERTY, merchantId);
		
		SmartList<TransportItem> externalTransportItemList = getTransportItemDAO().
				findTransportItemWithKey(key, options);
		if(externalTransportItemList == null){
			return platform;
		}
		if(externalTransportItemList.isEmpty()){
			return platform;
		}
		
		for(TransportItem transportItem: externalTransportItemList){
			transportItem.clearMerchant();
			transportItem.clearPlatform();
			
		}
		
		
		SmartList<TransportItem> transportItemList = platform.getTransportItemList();		
		transportItemList.addAllToRemoveList(externalTransportItemList);
		return platform;
	}
	
	public int countTransportItemListWithMerchant(String platformId, String merchantId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportItem.PLATFORM_PROPERTY, platformId);
		key.put(TransportItem.MERCHANT_PROPERTY, merchantId);
		
		int count = getTransportItemDAO().countTransportItemWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveTransportTaskList(Platform platform, String transportTaskIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return platform;
		}
		if(externalTransportTaskList.isEmpty()){
			return platform;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){

			transportTask.clearFromAll();
		}
		
		
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return platform;	
	
	}


	//disconnect Platform with source in TransportTask
	public Platform planToRemoveTransportTaskListWithSource(Platform platform, String sourceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportTask.SOURCE_PROPERTY, sourceId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return platform;
		}
		if(externalTransportTaskList.isEmpty()){
			return platform;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearSource();
			transportTask.clearPlatform();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return platform;
	}
	
	public int countTransportTaskListWithSource(String platformId, String sourceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		key.put(TransportTask.SOURCE_PROPERTY, sourceId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with destination in TransportTask
	public Platform planToRemoveTransportTaskListWithDestination(Platform platform, String destinationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportTask.DESTINATION_PROPERTY, destinationId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return platform;
		}
		if(externalTransportTaskList.isEmpty()){
			return platform;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearDestination();
			transportTask.clearPlatform();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return platform;
	}
	
	public int countTransportTaskListWithDestination(String platformId, String destinationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		key.put(TransportTask.DESTINATION_PROPERTY, destinationId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with status in TransportTask
	public Platform planToRemoveTransportTaskListWithStatus(Platform platform, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return platform;
		}
		if(externalTransportTaskList.isEmpty()){
			return platform;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearStatus();
			transportTask.clearPlatform();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return platform;
	}
	
	public int countTransportTaskListWithStatus(String platformId, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with sender in TransportTask
	public Platform planToRemoveTransportTaskListWithSender(Platform platform, String senderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportTask.SENDER_PROPERTY, senderId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return platform;
		}
		if(externalTransportTaskList.isEmpty()){
			return platform;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearSender();
			transportTask.clearPlatform();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return platform;
	}
	
	public int countTransportTaskListWithSender(String platformId, String senderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		key.put(TransportTask.SENDER_PROPERTY, senderId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with receiver in TransportTask
	public Platform planToRemoveTransportTaskListWithReceiver(Platform platform, String receiverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platform.getId());
		key.put(TransportTask.RECEIVER_PROPERTY, receiverId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return platform;
		}
		if(externalTransportTaskList.isEmpty()){
			return platform;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearReceiver();
			transportTask.clearPlatform();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return platform;
	}
	
	public int countTransportTaskListWithReceiver(String platformId, String receiverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		key.put(TransportTask.RECEIVER_PROPERTY, receiverId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	

		
	protected Platform saveTransactionTypeList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<TransactionType> transactionTypeList = platform.getTransactionTypeList();
		if(transactionTypeList == null){
			//null list means nothing
			return platform;
		}
		SmartList<TransactionType> mergedUpdateTransactionTypeList = new SmartList<TransactionType>();
		
		
		mergedUpdateTransactionTypeList.addAll(transactionTypeList); 
		if(transactionTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransactionTypeList.addAll(transactionTypeList.getToRemoveList());
			transactionTypeList.removeAll(transactionTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransactionTypeDAO().saveTransactionTypeList(mergedUpdateTransactionTypeList,options);
		
		if(transactionTypeList.getToRemoveList() != null){
			transactionTypeList.removeAll(transactionTypeList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeTransactionTypeList(Platform platform, Map<String,Object> options){
	
	
		SmartList<TransactionType> transactionTypeList = platform.getTransactionTypeList();
		if(transactionTypeList == null){
			return platform;
		}	
	
		SmartList<TransactionType> toRemoveTransactionTypeList = transactionTypeList.getToRemoveList();
		
		if(toRemoveTransactionTypeList == null){
			return platform;
		}
		if(toRemoveTransactionTypeList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransactionTypeDAO().removeTransactionTypeList(toRemoveTransactionTypeList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveMerchantTypeList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<MerchantType> merchantTypeList = platform.getMerchantTypeList();
		if(merchantTypeList == null){
			//null list means nothing
			return platform;
		}
		SmartList<MerchantType> mergedUpdateMerchantTypeList = new SmartList<MerchantType>();
		
		
		mergedUpdateMerchantTypeList.addAll(merchantTypeList); 
		if(merchantTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateMerchantTypeList.addAll(merchantTypeList.getToRemoveList());
			merchantTypeList.removeAll(merchantTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getMerchantTypeDAO().saveMerchantTypeList(mergedUpdateMerchantTypeList,options);
		
		if(merchantTypeList.getToRemoveList() != null){
			merchantTypeList.removeAll(merchantTypeList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeMerchantTypeList(Platform platform, Map<String,Object> options){
	
	
		SmartList<MerchantType> merchantTypeList = platform.getMerchantTypeList();
		if(merchantTypeList == null){
			return platform;
		}	
	
		SmartList<MerchantType> toRemoveMerchantTypeList = merchantTypeList.getToRemoveList();
		
		if(toRemoveMerchantTypeList == null){
			return platform;
		}
		if(toRemoveMerchantTypeList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getMerchantTypeDAO().removeMerchantTypeList(toRemoveMerchantTypeList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveTransportTaskStatusList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTaskStatus> transportTaskStatusList = platform.getTransportTaskStatusList();
		if(transportTaskStatusList == null){
			//null list means nothing
			return platform;
		}
		SmartList<TransportTaskStatus> mergedUpdateTransportTaskStatusList = new SmartList<TransportTaskStatus>();
		
		
		mergedUpdateTransportTaskStatusList.addAll(transportTaskStatusList); 
		if(transportTaskStatusList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskStatusList.addAll(transportTaskStatusList.getToRemoveList());
			transportTaskStatusList.removeAll(transportTaskStatusList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportTaskStatusDAO().saveTransportTaskStatusList(mergedUpdateTransportTaskStatusList,options);
		
		if(transportTaskStatusList.getToRemoveList() != null){
			transportTaskStatusList.removeAll(transportTaskStatusList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeTransportTaskStatusList(Platform platform, Map<String,Object> options){
	
	
		SmartList<TransportTaskStatus> transportTaskStatusList = platform.getTransportTaskStatusList();
		if(transportTaskStatusList == null){
			return platform;
		}	
	
		SmartList<TransportTaskStatus> toRemoveTransportTaskStatusList = transportTaskStatusList.getToRemoveList();
		
		if(toRemoveTransportTaskStatusList == null){
			return platform;
		}
		if(toRemoveTransportTaskStatusList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskStatusDAO().removeTransportTaskStatusList(toRemoveTransportTaskStatusList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveLocationList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Location> locationList = platform.getLocationList();
		if(locationList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Location> mergedUpdateLocationList = new SmartList<Location>();
		
		
		mergedUpdateLocationList.addAll(locationList); 
		if(locationList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLocationList.addAll(locationList.getToRemoveList());
			locationList.removeAll(locationList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLocationDAO().saveLocationList(mergedUpdateLocationList,options);
		
		if(locationList.getToRemoveList() != null){
			locationList.removeAll(locationList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeLocationList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Location> locationList = platform.getLocationList();
		if(locationList == null){
			return platform;
		}	
	
		SmartList<Location> toRemoveLocationList = locationList.getToRemoveList();
		
		if(toRemoveLocationList == null){
			return platform;
		}
		if(toRemoveLocationList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLocationDAO().removeLocationList(toRemoveLocationList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveMerchantList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Merchant> merchantList = platform.getMerchantList();
		if(merchantList == null){
			//null list means nothing
			return platform;
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
		
		
		return platform;
	
	}
	
	protected Platform removeMerchantList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Merchant> merchantList = platform.getMerchantList();
		if(merchantList == null){
			return platform;
		}	
	
		SmartList<Merchant> toRemoveMerchantList = merchantList.getToRemoveList();
		
		if(toRemoveMerchantList == null){
			return platform;
		}
		if(toRemoveMerchantList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getMerchantDAO().removeMerchantList(toRemoveMerchantList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveTransportProjectList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<TransportProject> transportProjectList = platform.getTransportProjectList();
		if(transportProjectList == null){
			//null list means nothing
			return platform;
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
		
		
		return platform;
	
	}
	
	protected Platform removeTransportProjectList(Platform platform, Map<String,Object> options){
	
	
		SmartList<TransportProject> transportProjectList = platform.getTransportProjectList();
		if(transportProjectList == null){
			return platform;
		}	
	
		SmartList<TransportProject> toRemoveTransportProjectList = transportProjectList.getToRemoveList();
		
		if(toRemoveTransportProjectList == null){
			return platform;
		}
		if(toRemoveTransportProjectList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportProjectDAO().removeTransportProjectList(toRemoveTransportProjectList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveTransportItemList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<TransportItem> transportItemList = platform.getTransportItemList();
		if(transportItemList == null){
			//null list means nothing
			return platform;
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
		
		
		return platform;
	
	}
	
	protected Platform removeTransportItemList(Platform platform, Map<String,Object> options){
	
	
		SmartList<TransportItem> transportItemList = platform.getTransportItemList();
		if(transportItemList == null){
			return platform;
		}	
	
		SmartList<TransportItem> toRemoveTransportItemList = transportItemList.getToRemoveList();
		
		if(toRemoveTransportItemList == null){
			return platform;
		}
		if(toRemoveTransportItemList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportItemDAO().removeTransportItemList(toRemoveTransportItemList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveTransportTaskList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();
		if(transportTaskList == null){
			//null list means nothing
			return platform;
		}
		SmartList<TransportTask> mergedUpdateTransportTaskList = new SmartList<TransportTask>();
		
		
		mergedUpdateTransportTaskList.addAll(transportTaskList); 
		if(transportTaskList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskList.addAll(transportTaskList.getToRemoveList());
			transportTaskList.removeAll(transportTaskList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportTaskDAO().saveTransportTaskList(mergedUpdateTransportTaskList,options);
		
		if(transportTaskList.getToRemoveList() != null){
			transportTaskList.removeAll(transportTaskList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeTransportTaskList(Platform platform, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();
		if(transportTaskList == null){
			return platform;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();
		
		if(toRemoveTransportTaskList == null){
			return platform;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentTransactionTypeList(platform,options);
		presentMerchantTypeList(platform,options);
		presentTransportTaskStatusList(platform,options);
		presentLocationList(platform,options);
		presentMerchantList(platform,options);
		presentTransportProjectList(platform,options);
		presentTransportItemList(platform,options);
		presentTransportTaskList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentTransactionTypeList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<TransactionType> transactionTypeList = platform.getTransactionTypeList();		
				SmartList<TransactionType> newList= presentSubList(platform.getId(),
				transactionTypeList,
				options,
				getTransactionTypeDAO()::countTransactionTypeByPlatform,
				getTransactionTypeDAO()::findTransactionTypeByPlatform
				);

		
		platform.setTransactionTypeList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentMerchantTypeList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<MerchantType> merchantTypeList = platform.getMerchantTypeList();		
				SmartList<MerchantType> newList= presentSubList(platform.getId(),
				merchantTypeList,
				options,
				getMerchantTypeDAO()::countMerchantTypeByPlatform,
				getMerchantTypeDAO()::findMerchantTypeByPlatform
				);

		
		platform.setMerchantTypeList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentTransportTaskStatusList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<TransportTaskStatus> transportTaskStatusList = platform.getTransportTaskStatusList();		
				SmartList<TransportTaskStatus> newList= presentSubList(platform.getId(),
				transportTaskStatusList,
				options,
				getTransportTaskStatusDAO()::countTransportTaskStatusByPlatform,
				getTransportTaskStatusDAO()::findTransportTaskStatusByPlatform
				);

		
		platform.setTransportTaskStatusList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentLocationList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Location> locationList = platform.getLocationList();		
				SmartList<Location> newList= presentSubList(platform.getId(),
				locationList,
				options,
				getLocationDAO()::countLocationByPlatform,
				getLocationDAO()::findLocationByPlatform
				);

		
		platform.setLocationList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentMerchantList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Merchant> merchantList = platform.getMerchantList();		
				SmartList<Merchant> newList= presentSubList(platform.getId(),
				merchantList,
				options,
				getMerchantDAO()::countMerchantByPlatform,
				getMerchantDAO()::findMerchantByPlatform
				);

		
		platform.setMerchantList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentTransportProjectList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<TransportProject> transportProjectList = platform.getTransportProjectList();		
				SmartList<TransportProject> newList= presentSubList(platform.getId(),
				transportProjectList,
				options,
				getTransportProjectDAO()::countTransportProjectByPlatform,
				getTransportProjectDAO()::findTransportProjectByPlatform
				);

		
		platform.setTransportProjectList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentTransportItemList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<TransportItem> transportItemList = platform.getTransportItemList();		
				SmartList<TransportItem> newList= presentSubList(platform.getId(),
				transportItemList,
				options,
				getTransportItemDAO()::countTransportItemByPlatform,
				getTransportItemDAO()::findTransportItemByPlatform
				);

		
		platform.setTransportItemList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentTransportTaskList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskList = platform.getTransportTaskList();		
				SmartList<TransportTask> newList= presentSubList(platform.getId(),
				transportTaskList,
				options,
				getTransportTaskDAO()::countTransportTaskByPlatform,
				getTransportTaskDAO()::findTransportTaskByPlatform
				);

		
		platform.setTransportTaskList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForTransactionType(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForMerchantType(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForTransportTaskStatus(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForLocation(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForMerchant(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForTransportProject(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForTransportItem(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForTransportTask(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
}


