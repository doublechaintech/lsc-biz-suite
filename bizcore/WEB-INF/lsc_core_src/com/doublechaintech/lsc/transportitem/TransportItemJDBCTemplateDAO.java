
package com.doublechaintech.lsc.transportitem;

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
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;

import com.doublechaintech.lsc.merchanttype.MerchantTypeDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TransportItemJDBCTemplateDAO extends LscNamingServiceDAO implements TransportItemDAO{
 
 	
 	private  TransportProjectDAO  transportProjectDAO;
 	public void setTransportProjectDAO(TransportProjectDAO transportProjectDAO){
	 	this.transportProjectDAO = transportProjectDAO;
 	}
 	public TransportProjectDAO getTransportProjectDAO(){
	 	return this.transportProjectDAO;
 	}
 
 	
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


			
		

	
	/*
	protected TransportItem load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportItem(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TransportItem load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportItem(TransportItemTable.withId(id), options);
	}
	
	
	
	public TransportItem save(TransportItem transportItem,Map<String,Object> options){
		
		String methodName="save(TransportItem transportItem,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportItem, methodName, "transportItem");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportItem(transportItem,options);
	}
	public TransportItem clone(String transportItemId, Map<String,Object> options) throws Exception{
	
		return clone(TransportItemTable.withId(transportItemId),options);
	}
	
	protected TransportItem clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportItemId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportItem newTransportItem = loadInternalTransportItem(accessKey, options);
		newTransportItem.setVersion(0);
		
		

		
		saveInternalTransportItem(newTransportItem,options);
		
		return newTransportItem;
	}
	
	
	
	

	protected void throwIfHasException(String transportItemId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportItemVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportItemNotFoundException(
					"The " + this.getTableName() + "(" + transportItemId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transportItemId, int version) throws Exception{
	
		String methodName="delete(String transportItemId, int version)";
		assertMethodArgumentNotNull(transportItemId, methodName, "transportItemId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportItemId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportItemId,version);
		}
		
	
	}
	
	
	
	
	

	public TransportItem disconnectFromAll(String transportItemId, int version) throws Exception{
	
		
		TransportItem transportItem = loadInternalTransportItem(TransportItemTable.withId(transportItemId), emptyOptions());
		transportItem.clearFromAll();
		this.saveTransportItem(transportItem);
		return transportItem;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransportItemTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_item";
	}
	@Override
	protected String getBeanName() {
		
		return "transportItem";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportItemTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProjectEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportItemTokens.PROJECT);
 	}

 	protected boolean isSaveProjectEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportItemTokens.PROJECT);
 	}
 	

 	
  

 	protected boolean isExtractMerchantEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportItemTokens.MERCHANT);
 	}

 	protected boolean isSaveMerchantEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportItemTokens.MERCHANT);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportItemTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportItemTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected TransportItemMapper getTransportItemMapper(){
		return new TransportItemMapper();
	}

	
	
	protected TransportItem extractTransportItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportItem transportItem = loadSingleObject(accessKey, getTransportItemMapper());
			return transportItem;
		}catch(EmptyResultDataAccessException e){
			throw new TransportItemNotFoundException("TransportItem("+accessKey+") is not found!");
		}

	}

	
	

	protected TransportItem loadInternalTransportItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportItem transportItem = extractTransportItem(accessKey, loadOptions);
 	
 		if(isExtractProjectEnabled(loadOptions)){
	 		extractProject(transportItem, loadOptions);
 		}
  	
 		if(isExtractMerchantEnabled(loadOptions)){
	 		extractMerchant(transportItem, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(transportItem, loadOptions);
 		}
 
		
		return transportItem;
		
	}

	 

 	protected TransportItem extractProject(TransportItem transportItem, Map<String,Object> options) throws Exception{

		if(transportItem.getProject() == null){
			return transportItem;
		}
		String projectId = transportItem.getProject().getId();
		if( projectId == null){
			return transportItem;
		}
		TransportProject project = getTransportProjectDAO().load(projectId,options);
		if(project != null){
			transportItem.setProject(project);
		}
		
 		
 		return transportItem;
 	}
 		
  

 	protected TransportItem extractMerchant(TransportItem transportItem, Map<String,Object> options) throws Exception{

		if(transportItem.getMerchant() == null){
			return transportItem;
		}
		String merchantId = transportItem.getMerchant().getId();
		if( merchantId == null){
			return transportItem;
		}
		MerchantType merchant = getMerchantTypeDAO().load(merchantId,options);
		if(merchant != null){
			transportItem.setMerchant(merchant);
		}
		
 		
 		return transportItem;
 	}
 		
  

 	protected TransportItem extractPlatform(TransportItem transportItem, Map<String,Object> options) throws Exception{

		if(transportItem.getPlatform() == null){
			return transportItem;
		}
		String platformId = transportItem.getPlatform().getId();
		if( platformId == null){
			return transportItem;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			transportItem.setPlatform(platform);
		}
		
 		
 		return transportItem;
 	}
 		
 
		
		
  	
 	public SmartList<TransportItem> findTransportItemByProject(String transportProjectId,Map<String,Object> options){
 	
  		SmartList<TransportItem> resultList = queryWith(TransportItemTable.COLUMN_PROJECT, transportProjectId, options, getTransportItemMapper());
		// analyzeTransportItemByProject(resultList, transportProjectId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportItem> findTransportItemByProject(String transportProjectId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportItem> resultList =  queryWithRange(TransportItemTable.COLUMN_PROJECT, transportProjectId, options, getTransportItemMapper(), start, count);
 		//analyzeTransportItemByProject(resultList, transportProjectId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportItemByProject(SmartList<TransportItem> resultList, String transportProjectId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportItem.PROJECT_PROPERTY, transportProjectId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportItem.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Transport Item");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportItem.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportItem.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportItemByProject(String transportProjectId,Map<String,Object> options){

 		return countWith(TransportItemTable.COLUMN_PROJECT, transportProjectId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportItemByProjectIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportItemTable.COLUMN_PROJECT, ids, options);
	}
 	
  	
 	public SmartList<TransportItem> findTransportItemByMerchant(String merchantTypeId,Map<String,Object> options){
 	
  		SmartList<TransportItem> resultList = queryWith(TransportItemTable.COLUMN_MERCHANT, merchantTypeId, options, getTransportItemMapper());
		// analyzeTransportItemByMerchant(resultList, merchantTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportItem> findTransportItemByMerchant(String merchantTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportItem> resultList =  queryWithRange(TransportItemTable.COLUMN_MERCHANT, merchantTypeId, options, getTransportItemMapper(), start, count);
 		//analyzeTransportItemByMerchant(resultList, merchantTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportItemByMerchant(SmartList<TransportItem> resultList, String merchantTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportItem.MERCHANT_PROPERTY, merchantTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportItem.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Transport Item");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportItem.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportItem.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportItemByMerchant(String merchantTypeId,Map<String,Object> options){

 		return countWith(TransportItemTable.COLUMN_MERCHANT, merchantTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportItemByMerchantIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportItemTable.COLUMN_MERCHANT, ids, options);
	}
 	
  	
 	public SmartList<TransportItem> findTransportItemByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<TransportItem> resultList = queryWith(TransportItemTable.COLUMN_PLATFORM, platformId, options, getTransportItemMapper());
		// analyzeTransportItemByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportItem> findTransportItemByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportItem> resultList =  queryWithRange(TransportItemTable.COLUMN_PLATFORM, platformId, options, getTransportItemMapper(), start, count);
 		//analyzeTransportItemByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportItemByPlatform(SmartList<TransportItem> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportItem.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportItem.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Transport Item");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportItem.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportItem.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportItemByPlatform(String platformId,Map<String,Object> options){

 		return countWith(TransportItemTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportItemByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportItemTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected TransportItem saveTransportItem(TransportItem  transportItem){
		
		if(!transportItem.isChanged()){
			return transportItem;
		}
		
		
		String SQL=this.getSaveTransportItemSQL(transportItem);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportItemParameters(transportItem);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportItem.incVersion();
		return transportItem;
	
	}
	public SmartList<TransportItem> saveTransportItemList(SmartList<TransportItem> transportItemList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportItemList(transportItemList);
		
		batchTransportItemCreate((List<TransportItem>)lists[CREATE_LIST_INDEX]);
		
		batchTransportItemUpdate((List<TransportItem>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportItem transportItem:transportItemList){
			if(transportItem.isChanged()){
				transportItem.incVersion();
			}
			
		
		}
		
		
		return transportItemList;
	}

	public SmartList<TransportItem> removeTransportItemList(SmartList<TransportItem> transportItemList,Map<String,Object> options){
		
		
		super.removeList(transportItemList, options);
		
		return transportItemList;
		
		
	}
	
	protected List<Object[]> prepareTransportItemBatchCreateArgs(List<TransportItem> transportItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportItem transportItem:transportItemList ){
			Object [] parameters = prepareTransportItemCreateParameters(transportItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportItemBatchUpdateArgs(List<TransportItem> transportItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportItem transportItem:transportItemList ){
			if(!transportItem.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportItemUpdateParameters(transportItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportItemCreate(List<TransportItem> transportItemList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportItemBatchCreateArgs(transportItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportItemUpdate(List<TransportItem> transportItemList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportItemBatchUpdateArgs(transportItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportItemList(List<TransportItem> transportItemList){
		
		List<TransportItem> transportItemCreateList=new ArrayList<TransportItem>();
		List<TransportItem> transportItemUpdateList=new ArrayList<TransportItem>();
		
		for(TransportItem transportItem: transportItemList){
			if(isUpdateRequest(transportItem)){
				transportItemUpdateList.add( transportItem);
				continue;
			}
			transportItemCreateList.add(transportItem);
		}
		
		return new Object[]{transportItemCreateList,transportItemUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportItem transportItem){
 		return transportItem.getVersion() > 0;
 	}
 	protected String getSaveTransportItemSQL(TransportItem transportItem){
 		if(isUpdateRequest(transportItem)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportItemParameters(TransportItem transportItem){
 		if(isUpdateRequest(transportItem) ){
 			return prepareTransportItemUpdateParameters(transportItem);
 		}
 		return prepareTransportItemCreateParameters(transportItem);
 	}
 	protected Object[] prepareTransportItemUpdateParameters(TransportItem transportItem){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = transportItem.getName();
 		parameters[1] = transportItem.getQuantity();
 		parameters[2] = transportItem.getUnit(); 	
 		if(transportItem.getProject() != null){
 			parameters[3] = transportItem.getProject().getId();
 		}
  	
 		if(transportItem.getMerchant() != null){
 			parameters[4] = transportItem.getMerchant().getId();
 		}
  	
 		if(transportItem.getPlatform() != null){
 			parameters[5] = transportItem.getPlatform().getId();
 		}
 
 		parameters[6] = transportItem.getCreateTime();
 		parameters[7] = transportItem.getUpdateTime();		
 		parameters[8] = transportItem.nextVersion();
 		parameters[9] = transportItem.getId();
 		parameters[10] = transportItem.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportItemCreateParameters(TransportItem transportItem){
		Object[] parameters = new Object[9];
		String newTransportItemId=getNextId();
		transportItem.setId(newTransportItemId);
		parameters[0] =  transportItem.getId();
 
 		parameters[1] = transportItem.getName();
 		parameters[2] = transportItem.getQuantity();
 		parameters[3] = transportItem.getUnit(); 	
 		if(transportItem.getProject() != null){
 			parameters[4] = transportItem.getProject().getId();
 		
 		}
 		 	
 		if(transportItem.getMerchant() != null){
 			parameters[5] = transportItem.getMerchant().getId();
 		
 		}
 		 	
 		if(transportItem.getPlatform() != null){
 			parameters[6] = transportItem.getPlatform().getId();
 		
 		}
 		
 		parameters[7] = transportItem.getCreateTime();
 		parameters[8] = transportItem.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected TransportItem saveInternalTransportItem(TransportItem transportItem, Map<String,Object> options){
		
		saveTransportItem(transportItem);
 	
 		if(isSaveProjectEnabled(options)){
	 		saveProject(transportItem, options);
 		}
  	
 		if(isSaveMerchantEnabled(options)){
	 		saveMerchant(transportItem, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(transportItem, options);
 		}
 
		
		return transportItem;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportItem saveProject(TransportItem transportItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportItem.getProject() == null){
 			return transportItem;//do nothing when it is null
 		}
 		
 		getTransportProjectDAO().save(transportItem.getProject(),options);
 		return transportItem;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportItem saveMerchant(TransportItem transportItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportItem.getMerchant() == null){
 			return transportItem;//do nothing when it is null
 		}
 		
 		getMerchantTypeDAO().save(transportItem.getMerchant(),options);
 		return transportItem;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportItem savePlatform(TransportItem transportItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportItem.getPlatform() == null){
 			return transportItem;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(transportItem.getPlatform(),options);
 		return transportItem;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public TransportItem present(TransportItem transportItem,Map<String, Object> options){
	

		return transportItem;
	
	}
		

	

	protected String getTableName(){
		return TransportItemTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TransportItem> transportItemList) {		
		this.enhanceListInternal(transportItemList, this.getTransportItemMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransportItem> transportItemList = ownerEntity.collectRefsWithType(TransportItem.INTERNAL_TYPE);
		this.enhanceList(transportItemList);
		
	}
	
	@Override
	public SmartList<TransportItem> findTransportItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransportItemMapper());

	}
	@Override
	public int countTransportItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TransportItem> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportItemMapper());
	}
}


