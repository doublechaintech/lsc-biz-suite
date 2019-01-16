
package com.doublechaintech.lsc.transporttask;

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
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;

import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatusDAO;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrackDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.location.LocationDAO;
import com.doublechaintech.lsc.merchant.MerchantDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TransportTaskJDBCTemplateDAO extends LscNamingServiceDAO implements TransportTaskDAO{
 
 	
 	private  TransportProjectDAO  transportProjectDAO;
 	public void setTransportProjectDAO(TransportProjectDAO transportProjectDAO){
	 	this.transportProjectDAO = transportProjectDAO;
 	}
 	public TransportProjectDAO getTransportProjectDAO(){
	 	return this.transportProjectDAO;
 	}
 
 	
 	private  TransportTaskStatusDAO  transportTaskStatusDAO;
 	public void setTransportTaskStatusDAO(TransportTaskStatusDAO transportTaskStatusDAO){
	 	this.transportTaskStatusDAO = transportTaskStatusDAO;
 	}
 	public TransportTaskStatusDAO getTransportTaskStatusDAO(){
	 	return this.transportTaskStatusDAO;
 	}
 
 	
 	private  MerchantDAO  merchantDAO;
 	public void setMerchantDAO(MerchantDAO merchantDAO){
	 	this.merchantDAO = merchantDAO;
 	}
 	public MerchantDAO getMerchantDAO(){
	 	return this.merchantDAO;
 	}
 
 	
 	private  LocationDAO  locationDAO;
 	public void setLocationDAO(LocationDAO locationDAO){
	 	this.locationDAO = locationDAO;
 	}
 	public LocationDAO getLocationDAO(){
	 	return this.locationDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  TransportTaskTrackDAO  transportTaskTrackDAO;
 	public void setTransportTaskTrackDAO(TransportTaskTrackDAO pTransportTaskTrackDAO){
 	
 		if(pTransportTaskTrackDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskTrackDAO to null.");
 		}
	 	this.transportTaskTrackDAO = pTransportTaskTrackDAO;
 	}
 	public TransportTaskTrackDAO getTransportTaskTrackDAO(){
 		if(this.transportTaskTrackDAO == null){
 			throw new IllegalStateException("The transportTaskTrackDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskTrackDAO;
 	}	
 	
			
		

	
	/*
	protected TransportTask load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTask(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TransportTask load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTask(TransportTaskTable.withId(id), options);
	}
	
	
	
	public TransportTask save(TransportTask transportTask,Map<String,Object> options){
		
		String methodName="save(TransportTask transportTask,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportTask, methodName, "transportTask");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportTask(transportTask,options);
	}
	public TransportTask clone(String transportTaskId, Map<String,Object> options) throws Exception{
	
		return clone(TransportTaskTable.withId(transportTaskId),options);
	}
	
	protected TransportTask clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportTaskId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportTask newTransportTask = loadInternalTransportTask(accessKey, options);
		newTransportTask.setVersion(0);
		
		
 		
 		if(isSaveTransportTaskTrackListEnabled(options)){
 			for(TransportTaskTrack item: newTransportTask.getTransportTaskTrackList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransportTask(newTransportTask,options);
		
		return newTransportTask;
	}
	
	
	
	

	protected void throwIfHasException(String transportTaskId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportTaskVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTaskNotFoundException(
					"The " + this.getTableName() + "(" + transportTaskId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transportTaskId, int version) throws Exception{
	
		String methodName="delete(String transportTaskId, int version)";
		assertMethodArgumentNotNull(transportTaskId, methodName, "transportTaskId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTaskId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTaskId,version);
		}
		
	
	}
	
	
	
	
	

	public TransportTask disconnectFromAll(String transportTaskId, int version) throws Exception{
	
		
		TransportTask transportTask = loadInternalTransportTask(TransportTaskTable.withId(transportTaskId), emptyOptions());
		transportTask.clearFromAll();
		this.saveTransportTask(transportTask);
		return transportTask;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransportTaskTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_task";
	}
	@Override
	protected String getBeanName() {
		
		return "transportTask";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportTaskTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProjectEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.PROJECT);
 	}

 	protected boolean isSaveProjectEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.PROJECT);
 	}
 	

 	
  

 	protected boolean isExtractSourceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.SOURCE);
 	}

 	protected boolean isSaveSourceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.SOURCE);
 	}
 	

 	
  

 	protected boolean isExtractDestinationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.DESTINATION);
 	}

 	protected boolean isSaveDestinationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.DESTINATION);
 	}
 	

 	
  

 	protected boolean isExtractStatusEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.STATUS);
 	}

 	protected boolean isSaveStatusEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.STATUS);
 	}
 	

 	
  

 	protected boolean isExtractSenderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.SENDER);
 	}

 	protected boolean isSaveSenderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.SENDER);
 	}
 	

 	
  

 	protected boolean isExtractReceiverEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.RECEIVER);
 	}

 	protected boolean isSaveReceiverEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.RECEIVER);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractTransportTaskTrackListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TransportTaskTokens.TRANSPORT_TASK_TRACK_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskTrackListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,TransportTaskTokens.TRANSPORT_TASK_TRACK_LIST+".analyze");
 	}
	
	protected boolean isSaveTransportTaskTrackListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportTaskTokens.TRANSPORT_TASK_TRACK_LIST);
		
 	}
 	
		

	

	protected TransportTaskMapper getTransportTaskMapper(){
		return new TransportTaskMapper();
	}

	
	
	protected TransportTask extractTransportTask(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportTask transportTask = loadSingleObject(accessKey, getTransportTaskMapper());
			return transportTask;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskNotFoundException("TransportTask("+accessKey+") is not found!");
		}

	}

	
	

	protected TransportTask loadInternalTransportTask(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportTask transportTask = extractTransportTask(accessKey, loadOptions);
 	
 		if(isExtractProjectEnabled(loadOptions)){
	 		extractProject(transportTask, loadOptions);
 		}
  	
 		if(isExtractSourceEnabled(loadOptions)){
	 		extractSource(transportTask, loadOptions);
 		}
  	
 		if(isExtractDestinationEnabled(loadOptions)){
	 		extractDestination(transportTask, loadOptions);
 		}
  	
 		if(isExtractStatusEnabled(loadOptions)){
	 		extractStatus(transportTask, loadOptions);
 		}
  	
 		if(isExtractSenderEnabled(loadOptions)){
	 		extractSender(transportTask, loadOptions);
 		}
  	
 		if(isExtractReceiverEnabled(loadOptions)){
	 		extractReceiver(transportTask, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(transportTask, loadOptions);
 		}
 
		
		if(isExtractTransportTaskTrackListEnabled(loadOptions)){
	 		extractTransportTaskTrackList(transportTask, loadOptions);
 		}	
 		if(isAnalyzeTransportTaskTrackListEnabled(loadOptions)){
	 		analyzeTransportTaskTrackList(transportTask, loadOptions);
 		}
 		
		
		return transportTask;
		
	}

	 

 	protected TransportTask extractProject(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getProject() == null){
			return transportTask;
		}
		String projectId = transportTask.getProject().getId();
		if( projectId == null){
			return transportTask;
		}
		TransportProject project = getTransportProjectDAO().load(projectId,options);
		if(project != null){
			transportTask.setProject(project);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractSource(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getSource() == null){
			return transportTask;
		}
		String sourceId = transportTask.getSource().getId();
		if( sourceId == null){
			return transportTask;
		}
		Location source = getLocationDAO().load(sourceId,options);
		if(source != null){
			transportTask.setSource(source);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractDestination(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getDestination() == null){
			return transportTask;
		}
		String destinationId = transportTask.getDestination().getId();
		if( destinationId == null){
			return transportTask;
		}
		Location destination = getLocationDAO().load(destinationId,options);
		if(destination != null){
			transportTask.setDestination(destination);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractStatus(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getStatus() == null){
			return transportTask;
		}
		String statusId = transportTask.getStatus().getId();
		if( statusId == null){
			return transportTask;
		}
		TransportTaskStatus status = getTransportTaskStatusDAO().load(statusId,options);
		if(status != null){
			transportTask.setStatus(status);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractSender(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getSender() == null){
			return transportTask;
		}
		String senderId = transportTask.getSender().getId();
		if( senderId == null){
			return transportTask;
		}
		Merchant sender = getMerchantDAO().load(senderId,options);
		if(sender != null){
			transportTask.setSender(sender);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractReceiver(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getReceiver() == null){
			return transportTask;
		}
		String receiverId = transportTask.getReceiver().getId();
		if( receiverId == null){
			return transportTask;
		}
		Merchant receiver = getMerchantDAO().load(receiverId,options);
		if(receiver != null){
			transportTask.setReceiver(receiver);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractPlatform(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getPlatform() == null){
			return transportTask;
		}
		String platformId = transportTask.getPlatform().getId();
		if( platformId == null){
			return transportTask;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			transportTask.setPlatform(platform);
		}
		
 		
 		return transportTask;
 	}
 		
 
		
	protected void enhanceTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected TransportTask extractTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
		
		
		if(transportTask == null){
			return null;
		}
		if(transportTask.getId() == null){
			return transportTask;
		}

		
		
		SmartList<TransportTaskTrack> transportTaskTrackList = getTransportTaskTrackDAO().findTransportTaskTrackByTask(transportTask.getId(),options);
		if(transportTaskTrackList != null){
			enhanceTransportTaskTrackList(transportTaskTrackList,options);
			transportTask.setTransportTaskTrackList(transportTaskTrackList);
		}
		
		return transportTask;
	
	}	
	
	protected TransportTask analyzeTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
		
		
		if(transportTask == null){
			return null;
		}
		if(transportTask.getId() == null){
			return transportTask;
		}

		
		
		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		if(transportTaskTrackList != null){
			getTransportTaskTrackDAO().analyzeTransportTaskTrackByTask(transportTaskTrackList, transportTask.getId(), options);
			
		}
		
		return transportTask;
	
	}	
	
		
		
  	
 	public SmartList<TransportTask> findTransportTaskByProject(String transportProjectId,Map<String,Object> options){
 	
  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_PROJECT, transportProjectId, options, getTransportTaskMapper());
		// analyzeTransportTaskByProject(resultList, transportProjectId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTask> findTransportTaskByProject(String transportProjectId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_PROJECT, transportProjectId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByProject(resultList, transportProjectId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskByProject(SmartList<TransportTask> resultList, String transportProjectId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.PROJECT_PROPERTY, transportProjectId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportTask.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("运输任务");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportTask.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportTask.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportTaskByProject(String transportProjectId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_PROJECT, transportProjectId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByProjectIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_PROJECT, ids, options);
	}
 	
  	
 	public SmartList<TransportTask> findTransportTaskBySource(String locationId,Map<String,Object> options){
 	
  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_SOURCE, locationId, options, getTransportTaskMapper());
		// analyzeTransportTaskBySource(resultList, locationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTask> findTransportTaskBySource(String locationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_SOURCE, locationId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskBySource(resultList, locationId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskBySource(SmartList<TransportTask> resultList, String locationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.SOURCE_PROPERTY, locationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportTask.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("运输任务");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportTask.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportTask.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportTaskBySource(String locationId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_SOURCE, locationId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskBySourceIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_SOURCE, ids, options);
	}
 	
  	
 	public SmartList<TransportTask> findTransportTaskByDestination(String locationId,Map<String,Object> options){
 	
  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_DESTINATION, locationId, options, getTransportTaskMapper());
		// analyzeTransportTaskByDestination(resultList, locationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTask> findTransportTaskByDestination(String locationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_DESTINATION, locationId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByDestination(resultList, locationId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskByDestination(SmartList<TransportTask> resultList, String locationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.DESTINATION_PROPERTY, locationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportTask.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("运输任务");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportTask.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportTask.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportTaskByDestination(String locationId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_DESTINATION, locationId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByDestinationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_DESTINATION, ids, options);
	}
 	
  	
 	public SmartList<TransportTask> findTransportTaskByStatus(String transportTaskStatusId,Map<String,Object> options){
 	
  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_STATUS, transportTaskStatusId, options, getTransportTaskMapper());
		// analyzeTransportTaskByStatus(resultList, transportTaskStatusId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTask> findTransportTaskByStatus(String transportTaskStatusId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_STATUS, transportTaskStatusId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByStatus(resultList, transportTaskStatusId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskByStatus(SmartList<TransportTask> resultList, String transportTaskStatusId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.STATUS_PROPERTY, transportTaskStatusId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportTask.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("运输任务");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportTask.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportTask.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportTaskByStatus(String transportTaskStatusId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_STATUS, transportTaskStatusId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByStatusIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_STATUS, ids, options);
	}
 	
  	
 	public SmartList<TransportTask> findTransportTaskBySender(String merchantId,Map<String,Object> options){
 	
  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_SENDER, merchantId, options, getTransportTaskMapper());
		// analyzeTransportTaskBySender(resultList, merchantId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTask> findTransportTaskBySender(String merchantId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_SENDER, merchantId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskBySender(resultList, merchantId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskBySender(SmartList<TransportTask> resultList, String merchantId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.SENDER_PROPERTY, merchantId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportTask.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("运输任务");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportTask.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportTask.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportTaskBySender(String merchantId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_SENDER, merchantId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskBySenderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_SENDER, ids, options);
	}
 	
  	
 	public SmartList<TransportTask> findTransportTaskByReceiver(String merchantId,Map<String,Object> options){
 	
  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_RECEIVER, merchantId, options, getTransportTaskMapper());
		// analyzeTransportTaskByReceiver(resultList, merchantId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTask> findTransportTaskByReceiver(String merchantId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_RECEIVER, merchantId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByReceiver(resultList, merchantId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskByReceiver(SmartList<TransportTask> resultList, String merchantId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.RECEIVER_PROPERTY, merchantId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportTask.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("运输任务");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportTask.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportTask.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportTaskByReceiver(String merchantId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_RECEIVER, merchantId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByReceiverIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_RECEIVER, ids, options);
	}
 	
  	
 	public SmartList<TransportTask> findTransportTaskByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_PLATFORM, platformId, options, getTransportTaskMapper());
		// analyzeTransportTaskByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTask> findTransportTaskByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_PLATFORM, platformId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskByPlatform(SmartList<TransportTask> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportTask.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("运输任务");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportTask.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportTask.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportTaskByPlatform(String platformId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected TransportTask saveTransportTask(TransportTask  transportTask){
		
		if(!transportTask.isChanged()){
			return transportTask;
		}
		
		
		String SQL=this.getSaveTransportTaskSQL(transportTask);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTaskParameters(transportTask);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportTask.incVersion();
		return transportTask;
	
	}
	public SmartList<TransportTask> saveTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTaskList(transportTaskList);
		
		batchTransportTaskCreate((List<TransportTask>)lists[CREATE_LIST_INDEX]);
		
		batchTransportTaskUpdate((List<TransportTask>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportTask transportTask:transportTaskList){
			if(transportTask.isChanged()){
				transportTask.incVersion();
			}
			
		
		}
		
		
		return transportTaskList;
	}

	public SmartList<TransportTask> removeTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		
		
		super.removeList(transportTaskList, options);
		
		return transportTaskList;
		
		
	}
	
	protected List<Object[]> prepareTransportTaskBatchCreateArgs(List<TransportTask> transportTaskList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTask transportTask:transportTaskList ){
			Object [] parameters = prepareTransportTaskCreateParameters(transportTask);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportTaskBatchUpdateArgs(List<TransportTask> transportTaskList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTask transportTask:transportTaskList ){
			if(!transportTask.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTaskUpdateParameters(transportTask);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportTaskCreate(List<TransportTask> transportTaskList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTaskBatchCreateArgs(transportTaskList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportTaskUpdate(List<TransportTask> transportTaskList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTaskBatchUpdateArgs(transportTaskList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportTaskList(List<TransportTask> transportTaskList){
		
		List<TransportTask> transportTaskCreateList=new ArrayList<TransportTask>();
		List<TransportTask> transportTaskUpdateList=new ArrayList<TransportTask>();
		
		for(TransportTask transportTask: transportTaskList){
			if(isUpdateRequest(transportTask)){
				transportTaskUpdateList.add( transportTask);
				continue;
			}
			transportTaskCreateList.add(transportTask);
		}
		
		return new Object[]{transportTaskCreateList,transportTaskUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportTask transportTask){
 		return transportTask.getVersion() > 0;
 	}
 	protected String getSaveTransportTaskSQL(TransportTask transportTask){
 		if(isUpdateRequest(transportTask)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportTaskParameters(TransportTask transportTask){
 		if(isUpdateRequest(transportTask) ){
 			return prepareTransportTaskUpdateParameters(transportTask);
 		}
 		return prepareTransportTaskCreateParameters(transportTask);
 	}
 	protected Object[] prepareTransportTaskUpdateParameters(TransportTask transportTask){
 		Object[] parameters = new Object[14];
 
 		parameters[0] = transportTask.getName(); 	
 		if(transportTask.getProject() != null){
 			parameters[1] = transportTask.getProject().getId();
 		}
  	
 		if(transportTask.getSource() != null){
 			parameters[2] = transportTask.getSource().getId();
 		}
  	
 		if(transportTask.getDestination() != null){
 			parameters[3] = transportTask.getDestination().getId();
 		}
 
 		parameters[4] = transportTask.getRemark(); 	
 		if(transportTask.getStatus() != null){
 			parameters[5] = transportTask.getStatus().getId();
 		}
  	
 		if(transportTask.getSender() != null){
 			parameters[6] = transportTask.getSender().getId();
 		}
  	
 		if(transportTask.getReceiver() != null){
 			parameters[7] = transportTask.getReceiver().getId();
 		}
  	
 		if(transportTask.getPlatform() != null){
 			parameters[8] = transportTask.getPlatform().getId();
 		}
 
 		parameters[9] = transportTask.getCreateTime();
 		parameters[10] = transportTask.getUpdateTime();		
 		parameters[11] = transportTask.nextVersion();
 		parameters[12] = transportTask.getId();
 		parameters[13] = transportTask.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportTaskCreateParameters(TransportTask transportTask){
		Object[] parameters = new Object[12];
		String newTransportTaskId=getNextId();
		transportTask.setId(newTransportTaskId);
		parameters[0] =  transportTask.getId();
 
 		parameters[1] = transportTask.getName(); 	
 		if(transportTask.getProject() != null){
 			parameters[2] = transportTask.getProject().getId();
 		
 		}
 		 	
 		if(transportTask.getSource() != null){
 			parameters[3] = transportTask.getSource().getId();
 		
 		}
 		 	
 		if(transportTask.getDestination() != null){
 			parameters[4] = transportTask.getDestination().getId();
 		
 		}
 		
 		parameters[5] = transportTask.getRemark(); 	
 		if(transportTask.getStatus() != null){
 			parameters[6] = transportTask.getStatus().getId();
 		
 		}
 		 	
 		if(transportTask.getSender() != null){
 			parameters[7] = transportTask.getSender().getId();
 		
 		}
 		 	
 		if(transportTask.getReceiver() != null){
 			parameters[8] = transportTask.getReceiver().getId();
 		
 		}
 		 	
 		if(transportTask.getPlatform() != null){
 			parameters[9] = transportTask.getPlatform().getId();
 		
 		}
 		
 		parameters[10] = transportTask.getCreateTime();
 		parameters[11] = transportTask.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected TransportTask saveInternalTransportTask(TransportTask transportTask, Map<String,Object> options){
		
		saveTransportTask(transportTask);
 	
 		if(isSaveProjectEnabled(options)){
	 		saveProject(transportTask, options);
 		}
  	
 		if(isSaveSourceEnabled(options)){
	 		saveSource(transportTask, options);
 		}
  	
 		if(isSaveDestinationEnabled(options)){
	 		saveDestination(transportTask, options);
 		}
  	
 		if(isSaveStatusEnabled(options)){
	 		saveStatus(transportTask, options);
 		}
  	
 		if(isSaveSenderEnabled(options)){
	 		saveSender(transportTask, options);
 		}
  	
 		if(isSaveReceiverEnabled(options)){
	 		saveReceiver(transportTask, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(transportTask, options);
 		}
 
		
		if(isSaveTransportTaskTrackListEnabled(options)){
	 		saveTransportTaskTrackList(transportTask, options);
	 		//removeTransportTaskTrackList(transportTask, options);
	 		//Not delete the record
	 		
 		}		
		
		return transportTask;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportTask saveProject(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getProject() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getTransportProjectDAO().save(transportTask.getProject(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask saveSource(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getSource() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getLocationDAO().save(transportTask.getSource(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask saveDestination(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getDestination() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getLocationDAO().save(transportTask.getDestination(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask saveStatus(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getStatus() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getTransportTaskStatusDAO().save(transportTask.getStatus(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask saveSender(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getSender() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getMerchantDAO().save(transportTask.getSender(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask saveReceiver(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getReceiver() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getMerchantDAO().save(transportTask.getReceiver(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask savePlatform(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getPlatform() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(transportTask.getPlatform(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public TransportTask planToRemoveTransportTaskTrackList(TransportTask transportTask, String transportTaskTrackIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTaskTrack.TASK_PROPERTY, transportTask.getId());
		key.put(TransportTaskTrack.ID_PROPERTY, transportTaskTrackIds);
		
		SmartList<TransportTaskTrack> externalTransportTaskTrackList = getTransportTaskTrackDAO().
				findTransportTaskTrackWithKey(key, options);
		if(externalTransportTaskTrackList == null){
			return transportTask;
		}
		if(externalTransportTaskTrackList.isEmpty()){
			return transportTask;
		}
		
		for(TransportTaskTrack transportTaskTrack: externalTransportTaskTrackList){

			transportTaskTrack.clearFromAll();
		}
		
		
		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();		
		transportTaskTrackList.addAllToRemoveList(externalTransportTaskTrackList);
		return transportTask;	
	
	}



		
	protected TransportTask saveTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		if(transportTaskTrackList == null){
			//null list means nothing
			return transportTask;
		}
		SmartList<TransportTaskTrack> mergedUpdateTransportTaskTrackList = new SmartList<TransportTaskTrack>();
		
		
		mergedUpdateTransportTaskTrackList.addAll(transportTaskTrackList); 
		if(transportTaskTrackList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskTrackList.addAll(transportTaskTrackList.getToRemoveList());
			transportTaskTrackList.removeAll(transportTaskTrackList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportTaskTrackDAO().saveTransportTaskTrackList(mergedUpdateTransportTaskTrackList,options);
		
		if(transportTaskTrackList.getToRemoveList() != null){
			transportTaskTrackList.removeAll(transportTaskTrackList.getToRemoveList());
		}
		
		
		return transportTask;
	
	}
	
	protected TransportTask removeTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
	
	
		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		if(transportTaskTrackList == null){
			return transportTask;
		}	
	
		SmartList<TransportTaskTrack> toRemoveTransportTaskTrackList = transportTaskTrackList.getToRemoveList();
		
		if(toRemoveTransportTaskTrackList == null){
			return transportTask;
		}
		if(toRemoveTransportTaskTrackList.isEmpty()){
			return transportTask;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskTrackDAO().removeTransportTaskTrackList(toRemoveTransportTaskTrackList,options);
		
		return transportTask;
	
	}
	
	

 	
 	
	
	
	
		

	public TransportTask present(TransportTask transportTask,Map<String, Object> options){
	
		presentTransportTaskTrackList(transportTask,options);

		return transportTask;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportTask presentTransportTaskTrackList(
			TransportTask transportTask,
			Map<String, Object> options) {

		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();		
				SmartList<TransportTaskTrack> newList= presentSubList(transportTask.getId(),
				transportTaskTrackList,
				options,
				getTransportTaskTrackDAO()::countTransportTaskTrackByTask,
				getTransportTaskTrackDAO()::findTransportTaskTrackByTask
				);

		
		transportTask.setTransportTaskTrackList(newList);
		

		return transportTask;
	}			
		

	
    public SmartList<TransportTask> requestCandidateTransportTaskForTransportTaskTrack(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportTaskTable.COLUMN_NAME, filterKey, pageNo, pageSize, getTransportTaskMapper());
    }
		

	protected String getTableName(){
		return TransportTaskTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TransportTask> transportTaskList) {		
		this.enhanceListInternal(transportTaskList, this.getTransportTaskMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransportTask> transportTaskList = ownerEntity.collectRefsWithType(TransportTask.INTERNAL_TYPE);
		this.enhanceList(transportTaskList);
		
	}
	
	@Override
	public SmartList<TransportTask> findTransportTaskWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransportTaskMapper());

	}
	@Override
	public int countTransportTaskWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportTaskWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TransportTask> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportTaskMapper());
	}
}


