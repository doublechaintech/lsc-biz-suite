
package com.doublechaintech.lsc.transporttaskstatus;

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


import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.platform.Platform;

import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TransportTaskStatusJDBCTemplateDAO extends LscNamingServiceDAO implements TransportTaskStatusDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
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
	protected TransportTaskStatus load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTaskStatus(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TransportTaskStatus load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTaskStatus(TransportTaskStatusTable.withId(id), options);
	}
	
	
	
	public TransportTaskStatus save(TransportTaskStatus transportTaskStatus,Map<String,Object> options){
		
		String methodName="save(TransportTaskStatus transportTaskStatus,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportTaskStatus, methodName, "transportTaskStatus");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportTaskStatus(transportTaskStatus,options);
	}
	public TransportTaskStatus clone(String transportTaskStatusId, Map<String,Object> options) throws Exception{
	
		return clone(TransportTaskStatusTable.withId(transportTaskStatusId),options);
	}
	
	protected TransportTaskStatus clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportTaskStatusId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportTaskStatus newTransportTaskStatus = loadInternalTransportTaskStatus(accessKey, options);
		newTransportTaskStatus.setVersion(0);
		
		
 		
 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newTransportTaskStatus.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransportTaskStatus(newTransportTaskStatus,options);
		
		return newTransportTaskStatus;
	}
	
	
	
	

	protected void throwIfHasException(String transportTaskStatusId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportTaskStatusVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTaskStatusNotFoundException(
					"The " + this.getTableName() + "(" + transportTaskStatusId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transportTaskStatusId, int version) throws Exception{
	
		String methodName="delete(String transportTaskStatusId, int version)";
		assertMethodArgumentNotNull(transportTaskStatusId, methodName, "transportTaskStatusId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTaskStatusId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTaskStatusId,version);
		}
		
	
	}
	
	
	
	
	

	public TransportTaskStatus disconnectFromAll(String transportTaskStatusId, int version) throws Exception{
	
		
		TransportTaskStatus transportTaskStatus = loadInternalTransportTaskStatus(TransportTaskStatusTable.withId(transportTaskStatusId), emptyOptions());
		transportTaskStatus.clearFromAll();
		this.saveTransportTaskStatus(transportTaskStatus);
		return transportTaskStatus;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransportTaskStatusTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_task_status";
	}
	@Override
	protected String getBeanName() {
		
		return "transportTaskStatus";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportTaskStatusTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskStatusTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskStatusTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TransportTaskStatusTokens.TRANSPORT_TASK_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,TransportTaskStatusTokens.TRANSPORT_TASK_LIST+".analyze");
 	}
	
	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportTaskStatusTokens.TRANSPORT_TASK_LIST);
		
 	}
 	
		

	

	protected TransportTaskStatusMapper getTransportTaskStatusMapper(){
		return new TransportTaskStatusMapper();
	}

	
	
	protected TransportTaskStatus extractTransportTaskStatus(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportTaskStatus transportTaskStatus = loadSingleObject(accessKey, getTransportTaskStatusMapper());
			return transportTaskStatus;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskStatusNotFoundException("TransportTaskStatus("+accessKey+") is not found!");
		}

	}

	
	

	protected TransportTaskStatus loadInternalTransportTaskStatus(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportTaskStatus transportTaskStatus = extractTransportTaskStatus(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(transportTaskStatus, loadOptions);
 		}
 
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(transportTaskStatus, loadOptions);
 		}	
 		if(isAnalyzeTransportTaskListEnabled(loadOptions)){
	 		analyzeTransportTaskList(transportTaskStatus, loadOptions);
 		}
 		
		
		return transportTaskStatus;
		
	}

	 

 	protected TransportTaskStatus extractPlatform(TransportTaskStatus transportTaskStatus, Map<String,Object> options) throws Exception{

		if(transportTaskStatus.getPlatform() == null){
			return transportTaskStatus;
		}
		String platformId = transportTaskStatus.getPlatform().getId();
		if( platformId == null){
			return transportTaskStatus;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			transportTaskStatus.setPlatform(platform);
		}
		
 		
 		return transportTaskStatus;
 	}
 		
 
		
	protected void enhanceTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected TransportTaskStatus extractTransportTaskList(TransportTaskStatus transportTaskStatus, Map<String,Object> options){
		
		
		if(transportTaskStatus == null){
			return null;
		}
		if(transportTaskStatus.getId() == null){
			return transportTaskStatus;
		}

		
		
		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByStatus(transportTaskStatus.getId(),options);
		if(transportTaskList != null){
			enhanceTransportTaskList(transportTaskList,options);
			transportTaskStatus.setTransportTaskList(transportTaskList);
		}
		
		return transportTaskStatus;
	
	}	
	
	protected TransportTaskStatus analyzeTransportTaskList(TransportTaskStatus transportTaskStatus, Map<String,Object> options){
		
		
		if(transportTaskStatus == null){
			return null;
		}
		if(transportTaskStatus.getId() == null){
			return transportTaskStatus;
		}

		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();
		if(transportTaskList != null){
			getTransportTaskDAO().analyzeTransportTaskByStatus(transportTaskList, transportTaskStatus.getId(), options);
			
		}
		
		return transportTaskStatus;
	
	}	
	
		
		
  	
 	public SmartList<TransportTaskStatus> findTransportTaskStatusByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<TransportTaskStatus> resultList = queryWith(TransportTaskStatusTable.COLUMN_PLATFORM, platformId, options, getTransportTaskStatusMapper());
		// analyzeTransportTaskStatusByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTaskStatus> findTransportTaskStatusByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTaskStatus> resultList =  queryWithRange(TransportTaskStatusTable.COLUMN_PLATFORM, platformId, options, getTransportTaskStatusMapper(), start, count);
 		//analyzeTransportTaskStatusByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskStatusByPlatform(SmartList<TransportTaskStatus> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countTransportTaskStatusByPlatform(String platformId,Map<String,Object> options){

 		return countWith(TransportTaskStatusTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskStatusByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskStatusTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected TransportTaskStatus saveTransportTaskStatus(TransportTaskStatus  transportTaskStatus){
		
		if(!transportTaskStatus.isChanged()){
			return transportTaskStatus;
		}
		
		
		String SQL=this.getSaveTransportTaskStatusSQL(transportTaskStatus);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTaskStatusParameters(transportTaskStatus);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportTaskStatus.incVersion();
		return transportTaskStatus;
	
	}
	public SmartList<TransportTaskStatus> saveTransportTaskStatusList(SmartList<TransportTaskStatus> transportTaskStatusList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTaskStatusList(transportTaskStatusList);
		
		batchTransportTaskStatusCreate((List<TransportTaskStatus>)lists[CREATE_LIST_INDEX]);
		
		batchTransportTaskStatusUpdate((List<TransportTaskStatus>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportTaskStatus transportTaskStatus:transportTaskStatusList){
			if(transportTaskStatus.isChanged()){
				transportTaskStatus.incVersion();
			}
			
		
		}
		
		
		return transportTaskStatusList;
	}

	public SmartList<TransportTaskStatus> removeTransportTaskStatusList(SmartList<TransportTaskStatus> transportTaskStatusList,Map<String,Object> options){
		
		
		super.removeList(transportTaskStatusList, options);
		
		return transportTaskStatusList;
		
		
	}
	
	protected List<Object[]> prepareTransportTaskStatusBatchCreateArgs(List<TransportTaskStatus> transportTaskStatusList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTaskStatus transportTaskStatus:transportTaskStatusList ){
			Object [] parameters = prepareTransportTaskStatusCreateParameters(transportTaskStatus);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportTaskStatusBatchUpdateArgs(List<TransportTaskStatus> transportTaskStatusList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTaskStatus transportTaskStatus:transportTaskStatusList ){
			if(!transportTaskStatus.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTaskStatusUpdateParameters(transportTaskStatus);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportTaskStatusCreate(List<TransportTaskStatus> transportTaskStatusList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTaskStatusBatchCreateArgs(transportTaskStatusList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportTaskStatusUpdate(List<TransportTaskStatus> transportTaskStatusList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTaskStatusBatchUpdateArgs(transportTaskStatusList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportTaskStatusList(List<TransportTaskStatus> transportTaskStatusList){
		
		List<TransportTaskStatus> transportTaskStatusCreateList=new ArrayList<TransportTaskStatus>();
		List<TransportTaskStatus> transportTaskStatusUpdateList=new ArrayList<TransportTaskStatus>();
		
		for(TransportTaskStatus transportTaskStatus: transportTaskStatusList){
			if(isUpdateRequest(transportTaskStatus)){
				transportTaskStatusUpdateList.add( transportTaskStatus);
				continue;
			}
			transportTaskStatusCreateList.add(transportTaskStatus);
		}
		
		return new Object[]{transportTaskStatusCreateList,transportTaskStatusUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportTaskStatus transportTaskStatus){
 		return transportTaskStatus.getVersion() > 0;
 	}
 	protected String getSaveTransportTaskStatusSQL(TransportTaskStatus transportTaskStatus){
 		if(isUpdateRequest(transportTaskStatus)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportTaskStatusParameters(TransportTaskStatus transportTaskStatus){
 		if(isUpdateRequest(transportTaskStatus) ){
 			return prepareTransportTaskStatusUpdateParameters(transportTaskStatus);
 		}
 		return prepareTransportTaskStatusCreateParameters(transportTaskStatus);
 	}
 	protected Object[] prepareTransportTaskStatusUpdateParameters(TransportTaskStatus transportTaskStatus){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = transportTaskStatus.getName(); 	
 		if(transportTaskStatus.getPlatform() != null){
 			parameters[1] = transportTaskStatus.getPlatform().getId();
 		}
 		
 		parameters[2] = transportTaskStatus.nextVersion();
 		parameters[3] = transportTaskStatus.getId();
 		parameters[4] = transportTaskStatus.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportTaskStatusCreateParameters(TransportTaskStatus transportTaskStatus){
		Object[] parameters = new Object[3];
		String newTransportTaskStatusId=getNextId();
		transportTaskStatus.setId(newTransportTaskStatusId);
		parameters[0] =  transportTaskStatus.getId();
 
 		parameters[1] = transportTaskStatus.getName(); 	
 		if(transportTaskStatus.getPlatform() != null){
 			parameters[2] = transportTaskStatus.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TransportTaskStatus saveInternalTransportTaskStatus(TransportTaskStatus transportTaskStatus, Map<String,Object> options){
		
		saveTransportTaskStatus(transportTaskStatus);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(transportTaskStatus, options);
 		}
 
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(transportTaskStatus, options);
	 		//removeTransportTaskList(transportTaskStatus, options);
	 		//Not delete the record
	 		
 		}		
		
		return transportTaskStatus;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportTaskStatus savePlatform(TransportTaskStatus transportTaskStatus, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTaskStatus.getPlatform() == null){
 			return transportTaskStatus;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(transportTaskStatus.getPlatform(),options);
 		return transportTaskStatus;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public TransportTaskStatus planToRemoveTransportTaskList(TransportTaskStatus transportTaskStatus, String transportTaskIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatus.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTaskStatus;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTaskStatus;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){

			transportTask.clearFromAll();
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTaskStatus;	
	
	}


	//disconnect TransportTaskStatus with project in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithProject(TransportTaskStatus transportTaskStatus, String projectId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatus.getId());
		key.put(TransportTask.PROJECT_PROPERTY, projectId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTaskStatus;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTaskStatus;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearProject();
			transportTask.clearStatus();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTaskStatus;
	}
	
	public int countTransportTaskListWithProject(String transportTaskStatusId, String projectId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatusId);
		key.put(TransportTask.PROJECT_PROPERTY, projectId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTaskStatus with source in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithSource(TransportTaskStatus transportTaskStatus, String sourceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatus.getId());
		key.put(TransportTask.SOURCE_PROPERTY, sourceId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTaskStatus;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTaskStatus;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearSource();
			transportTask.clearStatus();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTaskStatus;
	}
	
	public int countTransportTaskListWithSource(String transportTaskStatusId, String sourceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatusId);
		key.put(TransportTask.SOURCE_PROPERTY, sourceId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTaskStatus with destination in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithDestination(TransportTaskStatus transportTaskStatus, String destinationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatus.getId());
		key.put(TransportTask.DESTINATION_PROPERTY, destinationId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTaskStatus;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTaskStatus;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearDestination();
			transportTask.clearStatus();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTaskStatus;
	}
	
	public int countTransportTaskListWithDestination(String transportTaskStatusId, String destinationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatusId);
		key.put(TransportTask.DESTINATION_PROPERTY, destinationId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTaskStatus with sender in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithSender(TransportTaskStatus transportTaskStatus, String senderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatus.getId());
		key.put(TransportTask.SENDER_PROPERTY, senderId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTaskStatus;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTaskStatus;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearSender();
			transportTask.clearStatus();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTaskStatus;
	}
	
	public int countTransportTaskListWithSender(String transportTaskStatusId, String senderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatusId);
		key.put(TransportTask.SENDER_PROPERTY, senderId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTaskStatus with receiver in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithReceiver(TransportTaskStatus transportTaskStatus, String receiverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatus.getId());
		key.put(TransportTask.RECEIVER_PROPERTY, receiverId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTaskStatus;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTaskStatus;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearReceiver();
			transportTask.clearStatus();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTaskStatus;
	}
	
	public int countTransportTaskListWithReceiver(String transportTaskStatusId, String receiverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatusId);
		key.put(TransportTask.RECEIVER_PROPERTY, receiverId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTaskStatus with platform in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithPlatform(TransportTaskStatus transportTaskStatus, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatus.getId());
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTaskStatus;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTaskStatus;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearPlatform();
			transportTask.clearStatus();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTaskStatus;
	}
	
	public int countTransportTaskListWithPlatform(String transportTaskStatusId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.STATUS_PROPERTY, transportTaskStatusId);
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	

		
	protected TransportTaskStatus saveTransportTaskList(TransportTaskStatus transportTaskStatus, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();
		if(transportTaskList == null){
			//null list means nothing
			return transportTaskStatus;
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
		
		
		return transportTaskStatus;
	
	}
	
	protected TransportTaskStatus removeTransportTaskList(TransportTaskStatus transportTaskStatus, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();
		if(transportTaskList == null){
			return transportTaskStatus;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();
		
		if(toRemoveTransportTaskList == null){
			return transportTaskStatus;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return transportTaskStatus;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);
		
		return transportTaskStatus;
	
	}
	
	

 	
 	
	
	
	
		

	public TransportTaskStatus present(TransportTaskStatus transportTaskStatus,Map<String, Object> options){
	
		presentTransportTaskList(transportTaskStatus,options);

		return transportTaskStatus;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportTaskStatus presentTransportTaskList(
			TransportTaskStatus transportTaskStatus,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskList = transportTaskStatus.getTransportTaskList();		
				SmartList<TransportTask> newList= presentSubList(transportTaskStatus.getId(),
				transportTaskList,
				options,
				getTransportTaskDAO()::countTransportTaskByStatus,
				getTransportTaskDAO()::findTransportTaskByStatus
				);

		
		transportTaskStatus.setTransportTaskList(newList);
		

		return transportTaskStatus;
	}			
		

	
    public SmartList<TransportTaskStatus> requestCandidateTransportTaskStatusForTransportTask(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportTaskStatusTable.COLUMN_NAME, filterKey, pageNo, pageSize, getTransportTaskStatusMapper());
    }
		

	protected String getTableName(){
		return TransportTaskStatusTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TransportTaskStatus> transportTaskStatusList) {		
		this.enhanceListInternal(transportTaskStatusList, this.getTransportTaskStatusMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransportTaskStatus> transportTaskStatusList = ownerEntity.collectRefsWithType(TransportTaskStatus.INTERNAL_TYPE);
		this.enhanceList(transportTaskStatusList);
		
	}
	
	@Override
	public SmartList<TransportTaskStatus> findTransportTaskStatusWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransportTaskStatusMapper());

	}
	@Override
	public int countTransportTaskStatusWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportTaskStatusWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TransportTaskStatus> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportTaskStatusMapper());
	}
}


