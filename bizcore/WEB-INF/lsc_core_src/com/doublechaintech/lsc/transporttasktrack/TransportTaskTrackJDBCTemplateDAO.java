
package com.doublechaintech.lsc.transporttasktrack;

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

import com.doublechaintech.lsc.transporttask.TransportTaskDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TransportTaskTrackJDBCTemplateDAO extends LscNamingServiceDAO implements TransportTaskTrackDAO{
 
 	
 	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO transportTaskDAO){
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
	 	return this.transportTaskDAO;
 	}


			
		

	
	/*
	protected TransportTaskTrack load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTaskTrack(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TransportTaskTrack load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTaskTrack(TransportTaskTrackTable.withId(id), options);
	}
	
	
	
	public TransportTaskTrack save(TransportTaskTrack transportTaskTrack,Map<String,Object> options){
		
		String methodName="save(TransportTaskTrack transportTaskTrack,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportTaskTrack, methodName, "transportTaskTrack");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportTaskTrack(transportTaskTrack,options);
	}
	public TransportTaskTrack clone(String transportTaskTrackId, Map<String,Object> options) throws Exception{
	
		return clone(TransportTaskTrackTable.withId(transportTaskTrackId),options);
	}
	
	protected TransportTaskTrack clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportTaskTrackId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportTaskTrack newTransportTaskTrack = loadInternalTransportTaskTrack(accessKey, options);
		newTransportTaskTrack.setVersion(0);
		
		

		
		saveInternalTransportTaskTrack(newTransportTaskTrack,options);
		
		return newTransportTaskTrack;
	}
	
	
	
	

	protected void throwIfHasException(String transportTaskTrackId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportTaskTrackVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTaskTrackNotFoundException(
					"The " + this.getTableName() + "(" + transportTaskTrackId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transportTaskTrackId, int version) throws Exception{
	
		String methodName="delete(String transportTaskTrackId, int version)";
		assertMethodArgumentNotNull(transportTaskTrackId, methodName, "transportTaskTrackId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTaskTrackId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTaskTrackId,version);
		}
		
	
	}
	
	
	
	
	

	public TransportTaskTrack disconnectFromAll(String transportTaskTrackId, int version) throws Exception{
	
		
		TransportTaskTrack transportTaskTrack = loadInternalTransportTaskTrack(TransportTaskTrackTable.withId(transportTaskTrackId), emptyOptions());
		transportTaskTrack.clearFromAll();
		this.saveTransportTaskTrack(transportTaskTrack);
		return transportTaskTrack;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransportTaskTrackTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_task_track";
	}
	@Override
	protected String getBeanName() {
		
		return "transportTaskTrack";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportTaskTrackTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractTaskEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTrackTokens.TASK);
 	}

 	protected boolean isSaveTaskEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTrackTokens.TASK);
 	}
 	

 	
 
		

	

	protected TransportTaskTrackMapper getTransportTaskTrackMapper(){
		return new TransportTaskTrackMapper();
	}

	
	
	protected TransportTaskTrack extractTransportTaskTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportTaskTrack transportTaskTrack = loadSingleObject(accessKey, getTransportTaskTrackMapper());
			return transportTaskTrack;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskTrackNotFoundException("TransportTaskTrack("+accessKey+") is not found!");
		}

	}

	
	

	protected TransportTaskTrack loadInternalTransportTaskTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportTaskTrack transportTaskTrack = extractTransportTaskTrack(accessKey, loadOptions);
 	
 		if(isExtractTaskEnabled(loadOptions)){
	 		extractTask(transportTaskTrack, loadOptions);
 		}
 
		
		return transportTaskTrack;
		
	}

	 

 	protected TransportTaskTrack extractTask(TransportTaskTrack transportTaskTrack, Map<String,Object> options) throws Exception{

		if(transportTaskTrack.getTask() == null){
			return transportTaskTrack;
		}
		String taskId = transportTaskTrack.getTask().getId();
		if( taskId == null){
			return transportTaskTrack;
		}
		TransportTask task = getTransportTaskDAO().load(taskId,options);
		if(task != null){
			transportTaskTrack.setTask(task);
		}
		
 		
 		return transportTaskTrack;
 	}
 		
 
		
		
  	
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByTask(String transportTaskId,Map<String,Object> options){
 	
  		SmartList<TransportTaskTrack> resultList = queryWith(TransportTaskTrackTable.COLUMN_TASK, transportTaskId, options, getTransportTaskTrackMapper());
		// analyzeTransportTaskTrackByTask(resultList, transportTaskId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByTask(String transportTaskId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTaskTrack> resultList =  queryWithRange(TransportTaskTrackTable.COLUMN_TASK, transportTaskId, options, getTransportTaskTrackMapper(), start, count);
 		//analyzeTransportTaskTrackByTask(resultList, transportTaskId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskTrackByTask(SmartList<TransportTaskTrack> resultList, String transportTaskId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTaskTrack.TASK_PROPERTY, transportTaskId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//TransportTaskTrack.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Transport Task Track");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(TransportTaskTrack.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportTaskTrack.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransportTaskTrackByTask(String transportTaskId,Map<String,Object> options){

 		return countWith(TransportTaskTrackTable.COLUMN_TASK, transportTaskId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskTrackByTaskIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTrackTable.COLUMN_TASK, ids, options);
	}
 	
 	
		
		
		

	

	protected TransportTaskTrack saveTransportTaskTrack(TransportTaskTrack  transportTaskTrack){
		
		if(!transportTaskTrack.isChanged()){
			return transportTaskTrack;
		}
		
		
		String SQL=this.getSaveTransportTaskTrackSQL(transportTaskTrack);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTaskTrackParameters(transportTaskTrack);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportTaskTrack.incVersion();
		return transportTaskTrack;
	
	}
	public SmartList<TransportTaskTrack> saveTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTaskTrackList(transportTaskTrackList);
		
		batchTransportTaskTrackCreate((List<TransportTaskTrack>)lists[CREATE_LIST_INDEX]);
		
		batchTransportTaskTrackUpdate((List<TransportTaskTrack>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			if(transportTaskTrack.isChanged()){
				transportTaskTrack.incVersion();
			}
			
		
		}
		
		
		return transportTaskTrackList;
	}

	public SmartList<TransportTaskTrack> removeTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options){
		
		
		super.removeList(transportTaskTrackList, options);
		
		return transportTaskTrackList;
		
		
	}
	
	protected List<Object[]> prepareTransportTaskTrackBatchCreateArgs(List<TransportTaskTrack> transportTaskTrackList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList ){
			Object [] parameters = prepareTransportTaskTrackCreateParameters(transportTaskTrack);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportTaskTrackBatchUpdateArgs(List<TransportTaskTrack> transportTaskTrackList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList ){
			if(!transportTaskTrack.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTaskTrackUpdateParameters(transportTaskTrack);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportTaskTrackCreate(List<TransportTaskTrack> transportTaskTrackList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTaskTrackBatchCreateArgs(transportTaskTrackList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportTaskTrackUpdate(List<TransportTaskTrack> transportTaskTrackList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTaskTrackBatchUpdateArgs(transportTaskTrackList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportTaskTrackList(List<TransportTaskTrack> transportTaskTrackList){
		
		List<TransportTaskTrack> transportTaskTrackCreateList=new ArrayList<TransportTaskTrack>();
		List<TransportTaskTrack> transportTaskTrackUpdateList=new ArrayList<TransportTaskTrack>();
		
		for(TransportTaskTrack transportTaskTrack: transportTaskTrackList){
			if(isUpdateRequest(transportTaskTrack)){
				transportTaskTrackUpdateList.add( transportTaskTrack);
				continue;
			}
			transportTaskTrackCreateList.add(transportTaskTrack);
		}
		
		return new Object[]{transportTaskTrackCreateList,transportTaskTrackUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportTaskTrack transportTaskTrack){
 		return transportTaskTrack.getVersion() > 0;
 	}
 	protected String getSaveTransportTaskTrackSQL(TransportTaskTrack transportTaskTrack){
 		if(isUpdateRequest(transportTaskTrack)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportTaskTrackParameters(TransportTaskTrack transportTaskTrack){
 		if(isUpdateRequest(transportTaskTrack) ){
 			return prepareTransportTaskTrackUpdateParameters(transportTaskTrack);
 		}
 		return prepareTransportTaskTrackCreateParameters(transportTaskTrack);
 	}
 	protected Object[] prepareTransportTaskTrackUpdateParameters(TransportTaskTrack transportTaskTrack){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = transportTaskTrack.getName();
 		parameters[1] = transportTaskTrack.getLatitude();
 		parameters[2] = transportTaskTrack.getLongitude(); 	
 		if(transportTaskTrack.getTask() != null){
 			parameters[3] = transportTaskTrack.getTask().getId();
 		}
 
 		parameters[4] = transportTaskTrack.getCreateTime();
 		parameters[5] = transportTaskTrack.getUpdateTime();		
 		parameters[6] = transportTaskTrack.nextVersion();
 		parameters[7] = transportTaskTrack.getId();
 		parameters[8] = transportTaskTrack.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportTaskTrackCreateParameters(TransportTaskTrack transportTaskTrack){
		Object[] parameters = new Object[7];
		String newTransportTaskTrackId=getNextId();
		transportTaskTrack.setId(newTransportTaskTrackId);
		parameters[0] =  transportTaskTrack.getId();
 
 		parameters[1] = transportTaskTrack.getName();
 		parameters[2] = transportTaskTrack.getLatitude();
 		parameters[3] = transportTaskTrack.getLongitude(); 	
 		if(transportTaskTrack.getTask() != null){
 			parameters[4] = transportTaskTrack.getTask().getId();
 		
 		}
 		
 		parameters[5] = transportTaskTrack.getCreateTime();
 		parameters[6] = transportTaskTrack.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected TransportTaskTrack saveInternalTransportTaskTrack(TransportTaskTrack transportTaskTrack, Map<String,Object> options){
		
		saveTransportTaskTrack(transportTaskTrack);
 	
 		if(isSaveTaskEnabled(options)){
	 		saveTask(transportTaskTrack, options);
 		}
 
		
		return transportTaskTrack;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportTaskTrack saveTask(TransportTaskTrack transportTaskTrack, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTaskTrack.getTask() == null){
 			return transportTaskTrack;//do nothing when it is null
 		}
 		
 		getTransportTaskDAO().save(transportTaskTrack.getTask(),options);
 		return transportTaskTrack;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public TransportTaskTrack present(TransportTaskTrack transportTaskTrack,Map<String, Object> options){
	

		return transportTaskTrack;
	
	}
		

	

	protected String getTableName(){
		return TransportTaskTrackTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TransportTaskTrack> transportTaskTrackList) {		
		this.enhanceListInternal(transportTaskTrackList, this.getTransportTaskTrackMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransportTaskTrack> transportTaskTrackList = ownerEntity.collectRefsWithType(TransportTaskTrack.INTERNAL_TYPE);
		this.enhanceList(transportTaskTrackList);
		
	}
	
	@Override
	public SmartList<TransportTaskTrack> findTransportTaskTrackWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransportTaskTrackMapper());

	}
	@Override
	public int countTransportTaskTrackWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportTaskTrackWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TransportTaskTrack> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportTaskTrackMapper());
	}
}


