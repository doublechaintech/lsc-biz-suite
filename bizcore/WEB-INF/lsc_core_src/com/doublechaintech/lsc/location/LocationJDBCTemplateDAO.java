
package com.doublechaintech.lsc.location;

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

public class LocationJDBCTemplateDAO extends LscNamingServiceDAO implements LocationDAO{
 
 	
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
	protected Location load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLocation(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Location load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLocation(LocationTable.withId(id), options);
	}
	
	
	
	public Location save(Location location,Map<String,Object> options){
		
		String methodName="save(Location location,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(location, methodName, "location");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLocation(location,options);
	}
	public Location clone(String locationId, Map<String,Object> options) throws Exception{
	
		return clone(LocationTable.withId(locationId),options);
	}
	
	protected Location clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String locationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Location newLocation = loadInternalLocation(accessKey, options);
		newLocation.setVersion(0);
		
		
 		
 		if(isSaveTransportTaskListAsSourceEnabled(options)){
 			for(TransportTask item: newLocation.getTransportTaskListAsSource()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskListAsDestinationEnabled(options)){
 			for(TransportTask item: newLocation.getTransportTaskListAsDestination()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLocation(newLocation,options);
		
		return newLocation;
	}
	
	
	
	

	protected void throwIfHasException(String locationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LocationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LocationNotFoundException(
					"The " + this.getTableName() + "(" + locationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String locationId, int version) throws Exception{
	
		String methodName="delete(String locationId, int version)";
		assertMethodArgumentNotNull(locationId, methodName, "locationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{locationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(locationId,version);
		}
		
	
	}
	
	
	
	
	

	public Location disconnectFromAll(String locationId, int version) throws Exception{
	
		
		Location location = loadInternalLocation(LocationTable.withId(locationId), emptyOptions());
		location.clearFromAll();
		this.saveLocation(location);
		return location;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LocationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "location";
	}
	@Override
	protected String getBeanName() {
		
		return "location";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LocationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LocationTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LocationTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractTransportTaskListAsSourceEnabled(Map<String,Object> options){		
 		return checkOptions(options,LocationTokens.TRANSPORT_TASK_LIST_AS_SOURCE);
 	}
 	protected boolean isAnalyzeTransportTaskListAsSourceEnabled(Map<String,Object> options){		
 		return checkOptions(options,LocationTokens.TRANSPORT_TASK_LIST_AS_SOURCE+".analyze");
 	}

	protected boolean isSaveTransportTaskListAsSourceEnabled(Map<String,Object> options){
		return checkOptions(options, LocationTokens.TRANSPORT_TASK_LIST_AS_SOURCE);
		
 	}
 	
		
	
	protected boolean isExtractTransportTaskListAsDestinationEnabled(Map<String,Object> options){		
 		return checkOptions(options,LocationTokens.TRANSPORT_TASK_LIST_AS_DESTINATION);
 	}
 	protected boolean isAnalyzeTransportTaskListAsDestinationEnabled(Map<String,Object> options){		
 		return checkOptions(options,LocationTokens.TRANSPORT_TASK_LIST_AS_DESTINATION+".analyze");
 	}

	protected boolean isSaveTransportTaskListAsDestinationEnabled(Map<String,Object> options){
		return checkOptions(options, LocationTokens.TRANSPORT_TASK_LIST_AS_DESTINATION);
		
 	}
 	
		

	

	protected LocationMapper getLocationMapper(){
		return new LocationMapper();
	}

	
	
	protected Location extractLocation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Location location = loadSingleObject(accessKey, getLocationMapper());
			return location;
		}catch(EmptyResultDataAccessException e){
			throw new LocationNotFoundException("Location("+accessKey+") is not found!");
		}

	}

	
	

	protected Location loadInternalLocation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Location location = extractLocation(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(location, loadOptions);
 		}
 
		
		if(isExtractTransportTaskListAsSourceEnabled(loadOptions)){
	 		extractTransportTaskListAsSource(location, loadOptions);
 		}	
 		if(isAnalyzeTransportTaskListAsSourceEnabled(loadOptions)){
	 		// analyzeTransportTaskListAsSource(location, loadOptions);
 		}
 		
		
		if(isExtractTransportTaskListAsDestinationEnabled(loadOptions)){
	 		extractTransportTaskListAsDestination(location, loadOptions);
 		}	
 		if(isAnalyzeTransportTaskListAsDestinationEnabled(loadOptions)){
	 		// analyzeTransportTaskListAsDestination(location, loadOptions);
 		}
 		
		
		return location;
		
	}

	 

 	protected Location extractPlatform(Location location, Map<String,Object> options) throws Exception{

		if(location.getPlatform() == null){
			return location;
		}
		String platformId = location.getPlatform().getId();
		if( platformId == null){
			return location;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			location.setPlatform(platform);
		}
		
 		
 		return location;
 	}
 		
 
		
	protected void enhanceTransportTaskListAsSource(SmartList<TransportTask> transportTaskListAsSource,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Location extractTransportTaskListAsSource(Location location, Map<String,Object> options){
		
		
		if(location == null){
			return null;
		}
		if(location.getId() == null){
			return location;
		}
		convertListOptions(options,"transportTaskListAsSource","transportTaskList");

		
		
		SmartList<TransportTask> transportTaskListAsSource = getTransportTaskDAO().findTransportTaskBySource(location.getId(),options);
		if(transportTaskListAsSource != null){
			enhanceTransportTaskListAsSource(transportTaskListAsSource,options);
			location.setTransportTaskListAsSource(transportTaskListAsSource);
		}
		
		return location;
	
	}	
	
	protected Location analyzeTransportTaskListAsSource(Location location, Map<String,Object> options){
		
		
		if(location == null){
			return null;
		}
		if(location.getId() == null){
			return location;
		}
		convertListOptions(options,"transportTaskListAsSource","transportTaskList");

		
		
		SmartList<TransportTask> transportTaskListAsSource = location.getTransportTaskListAsSource();
		if(transportTaskListAsSource != null){
			getTransportTaskDAO().analyzeTransportTaskBySource(transportTaskListAsSource, location.getId(), options);
			
		}
		
		return location;
	
	}	
	
		
	protected void enhanceTransportTaskListAsDestination(SmartList<TransportTask> transportTaskListAsDestination,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Location extractTransportTaskListAsDestination(Location location, Map<String,Object> options){
		
		
		if(location == null){
			return null;
		}
		if(location.getId() == null){
			return location;
		}
		convertListOptions(options,"transportTaskListAsDestination","transportTaskList");

		
		
		SmartList<TransportTask> transportTaskListAsDestination = getTransportTaskDAO().findTransportTaskByDestination(location.getId(),options);
		if(transportTaskListAsDestination != null){
			enhanceTransportTaskListAsDestination(transportTaskListAsDestination,options);
			location.setTransportTaskListAsDestination(transportTaskListAsDestination);
		}
		
		return location;
	
	}	
	
	protected Location analyzeTransportTaskListAsDestination(Location location, Map<String,Object> options){
		
		
		if(location == null){
			return null;
		}
		if(location.getId() == null){
			return location;
		}
		convertListOptions(options,"transportTaskListAsDestination","transportTaskList");

		
		
		SmartList<TransportTask> transportTaskListAsDestination = location.getTransportTaskListAsDestination();
		if(transportTaskListAsDestination != null){
			getTransportTaskDAO().analyzeTransportTaskBySource(transportTaskListAsDestination, location.getId(), options);
			
		}
		
		return location;
	
	}	
	
		
		
  	
 	public SmartList<Location> findLocationByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Location> resultList = queryWith(LocationTable.COLUMN_PLATFORM, platformId, options, getLocationMapper());
		// analyzeLocationByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Location> findLocationByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Location> resultList =  queryWithRange(LocationTable.COLUMN_PLATFORM, platformId, options, getLocationMapper(), start, count);
 		//analyzeLocationByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeLocationByPlatform(SmartList<Location> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Location.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//Location.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("位置");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(Location.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Location.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countLocationByPlatform(String platformId,Map<String,Object> options){

 		return countWith(LocationTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countLocationByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LocationTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Location saveLocation(Location  location){
		
		if(!location.isChanged()){
			return location;
		}
		
		
		String SQL=this.getSaveLocationSQL(location);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLocationParameters(location);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		location.incVersion();
		return location;
	
	}
	public SmartList<Location> saveLocationList(SmartList<Location> locationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLocationList(locationList);
		
		batchLocationCreate((List<Location>)lists[CREATE_LIST_INDEX]);
		
		batchLocationUpdate((List<Location>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Location location:locationList){
			if(location.isChanged()){
				location.incVersion();
			}
			
		
		}
		
		
		return locationList;
	}

	public SmartList<Location> removeLocationList(SmartList<Location> locationList,Map<String,Object> options){
		
		
		super.removeList(locationList, options);
		
		return locationList;
		
		
	}
	
	protected List<Object[]> prepareLocationBatchCreateArgs(List<Location> locationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Location location:locationList ){
			Object [] parameters = prepareLocationCreateParameters(location);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLocationBatchUpdateArgs(List<Location> locationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Location location:locationList ){
			if(!location.isChanged()){
				continue;
			}
			Object [] parameters = prepareLocationUpdateParameters(location);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLocationCreate(List<Location> locationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLocationBatchCreateArgs(locationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLocationUpdate(List<Location> locationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLocationBatchUpdateArgs(locationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLocationList(List<Location> locationList){
		
		List<Location> locationCreateList=new ArrayList<Location>();
		List<Location> locationUpdateList=new ArrayList<Location>();
		
		for(Location location: locationList){
			if(isUpdateRequest(location)){
				locationUpdateList.add( location);
				continue;
			}
			locationCreateList.add(location);
		}
		
		return new Object[]{locationCreateList,locationUpdateList};
	}
	
	protected boolean isUpdateRequest(Location location){
 		return location.getVersion() > 0;
 	}
 	protected String getSaveLocationSQL(Location location){
 		if(isUpdateRequest(location)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLocationParameters(Location location){
 		if(isUpdateRequest(location) ){
 			return prepareLocationUpdateParameters(location);
 		}
 		return prepareLocationCreateParameters(location);
 	}
 	protected Object[] prepareLocationUpdateParameters(Location location){
 		Object[] parameters = new Object[10];
 
 		parameters[0] = location.getName();
 		parameters[1] = location.getContactPerson();
 		parameters[2] = location.getContactPhone();
 		parameters[3] = location.getDescription(); 	
 		if(location.getPlatform() != null){
 			parameters[4] = location.getPlatform().getId();
 		}
 
 		parameters[5] = location.getCreateTime();
 		parameters[6] = location.getUpdateTime();		
 		parameters[7] = location.nextVersion();
 		parameters[8] = location.getId();
 		parameters[9] = location.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLocationCreateParameters(Location location){
		Object[] parameters = new Object[8];
		String newLocationId=getNextId();
		location.setId(newLocationId);
		parameters[0] =  location.getId();
 
 		parameters[1] = location.getName();
 		parameters[2] = location.getContactPerson();
 		parameters[3] = location.getContactPhone();
 		parameters[4] = location.getDescription(); 	
 		if(location.getPlatform() != null){
 			parameters[5] = location.getPlatform().getId();
 		
 		}
 		
 		parameters[6] = location.getCreateTime();
 		parameters[7] = location.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected Location saveInternalLocation(Location location, Map<String,Object> options){
		
		saveLocation(location);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(location, options);
 		}
 
		
		if(isSaveTransportTaskListAsSourceEnabled(options)){
	 		saveTransportTaskListAsSource(location, options);
	 		//removeTransportTaskListAsSource(location, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportTaskListAsDestinationEnabled(options)){
	 		saveTransportTaskListAsDestination(location, options);
	 		//removeTransportTaskListAsDestination(location, options);
	 		//Not delete the record
	 		
 		}		
		
		return location;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Location savePlatform(Location location, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(location.getPlatform() == null){
 			return location;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(location.getPlatform(),options);
 		return location;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Location planToRemoveTransportTaskListAsSource(Location location, String transportTaskIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){

			transportTask.clearFromAll();
		}
		
		
		SmartList<TransportTask> transportTaskListAsSource = location.getTransportTaskListAsSource();		
		transportTaskListAsSource.addAllToRemoveList(externalTransportTaskList);
		return location;	
	
	}


	//disconnect Location with status in TransportTask
	public Location planToRemoveTransportTaskListAsSourceWithStatus(Location location, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearStatus();
			transportTask.clearSource();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = location.getTransportTaskListAsSource();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return location;
	}
	
	public int countTransportTaskListAsSourceWithStatus(String locationId, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, locationId);
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Location with sender in TransportTask
	public Location planToRemoveTransportTaskListAsSourceWithSender(Location location, String senderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.SENDER_PROPERTY, senderId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearSender();
			transportTask.clearSource();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = location.getTransportTaskListAsSource();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return location;
	}
	
	public int countTransportTaskListAsSourceWithSender(String locationId, String senderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, locationId);
		key.put(TransportTask.SENDER_PROPERTY, senderId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Location with receiver in TransportTask
	public Location planToRemoveTransportTaskListAsSourceWithReceiver(Location location, String receiverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.RECEIVER_PROPERTY, receiverId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearReceiver();
			transportTask.clearSource();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = location.getTransportTaskListAsSource();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return location;
	}
	
	public int countTransportTaskListAsSourceWithReceiver(String locationId, String receiverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, locationId);
		key.put(TransportTask.RECEIVER_PROPERTY, receiverId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Location with platform in TransportTask
	public Location planToRemoveTransportTaskListAsSourceWithPlatform(Location location, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearPlatform();
			transportTask.clearSource();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = location.getTransportTaskListAsSource();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return location;
	}
	
	public int countTransportTaskListAsSourceWithPlatform(String locationId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, locationId);
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	public Location planToRemoveTransportTaskListAsDestination(Location location, String transportTaskIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){

			transportTask.clearFromAll();
		}
		
		
		SmartList<TransportTask> transportTaskListAsDestination = location.getTransportTaskListAsDestination();		
		transportTaskListAsDestination.addAllToRemoveList(externalTransportTaskList);
		return location;	
	
	}


	//disconnect Location with status in TransportTask
	public Location planToRemoveTransportTaskListAsDestinationWithStatus(Location location, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearStatus();
			transportTask.clearSource();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = location.getTransportTaskListAsSource();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return location;
	}
	
	public int countTransportTaskListAsDestinationWithStatus(String locationId, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, locationId);
		key.put(TransportTask.STATUS_PROPERTY, statusId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Location with sender in TransportTask
	public Location planToRemoveTransportTaskListAsDestinationWithSender(Location location, String senderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.SENDER_PROPERTY, senderId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearSender();
			transportTask.clearSource();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = location.getTransportTaskListAsSource();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return location;
	}
	
	public int countTransportTaskListAsDestinationWithSender(String locationId, String senderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, locationId);
		key.put(TransportTask.SENDER_PROPERTY, senderId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Location with receiver in TransportTask
	public Location planToRemoveTransportTaskListAsDestinationWithReceiver(Location location, String receiverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.RECEIVER_PROPERTY, receiverId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearReceiver();
			transportTask.clearSource();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = location.getTransportTaskListAsSource();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return location;
	}
	
	public int countTransportTaskListAsDestinationWithReceiver(String locationId, String receiverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, locationId);
		key.put(TransportTask.RECEIVER_PROPERTY, receiverId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect Location with platform in TransportTask
	public Location planToRemoveTransportTaskListAsDestinationWithPlatform(Location location, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, location.getId());
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return location;
		}
		if(externalTransportTaskList.isEmpty()){
			return location;
		}
		
		for(TransportTask transportTask: externalTransportTaskList){
			transportTask.clearPlatform();
			transportTask.clearSource();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = location.getTransportTaskListAsSource();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return location;
	}
	
	public int countTransportTaskListAsDestinationWithPlatform(String locationId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.SOURCE_PROPERTY, locationId);
		key.put(TransportTask.PLATFORM_PROPERTY, platformId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	

		
	protected Location saveTransportTaskListAsSource(Location location, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTask> transportTaskListAsSource = location.getTransportTaskListAsSource();
		if(transportTaskListAsSource == null){
			//null list means nothing
			return location;
		}
		SmartList<TransportTask> mergedUpdateTransportTaskListAsSource = new SmartList<TransportTask>();
		
		
		mergedUpdateTransportTaskListAsSource.addAll(transportTaskListAsSource); 
		if(transportTaskListAsSource.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskListAsSource.addAll(transportTaskListAsSource.getToRemoveList());
			transportTaskListAsSource.removeAll(transportTaskListAsSource.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportTaskDAO().saveTransportTaskList(mergedUpdateTransportTaskListAsSource,options);
		
		if(transportTaskListAsSource.getToRemoveList() != null){
			transportTaskListAsSource.removeAll(transportTaskListAsSource.getToRemoveList());
		}
		
		
		return location;
	
	}
	
	protected Location removeTransportTaskListAsSource(Location location, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskListAsSource = location.getTransportTaskListAsSource();
		if(transportTaskListAsSource == null){
			return location;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskListAsSource = transportTaskListAsSource.getToRemoveList();
		
		if(toRemoveTransportTaskListAsSource == null){
			return location;
		}
		if(toRemoveTransportTaskListAsSource.isEmpty()){
			return location;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskListAsSource,options);
		
		return location;
	
	}
	
	

 	
 	
	
	
	
		
	protected Location saveTransportTaskListAsDestination(Location location, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTask> transportTaskListAsDestination = location.getTransportTaskListAsDestination();
		if(transportTaskListAsDestination == null){
			//null list means nothing
			return location;
		}
		SmartList<TransportTask> mergedUpdateTransportTaskListAsDestination = new SmartList<TransportTask>();
		
		
		mergedUpdateTransportTaskListAsDestination.addAll(transportTaskListAsDestination); 
		if(transportTaskListAsDestination.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskListAsDestination.addAll(transportTaskListAsDestination.getToRemoveList());
			transportTaskListAsDestination.removeAll(transportTaskListAsDestination.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportTaskDAO().saveTransportTaskList(mergedUpdateTransportTaskListAsDestination,options);
		
		if(transportTaskListAsDestination.getToRemoveList() != null){
			transportTaskListAsDestination.removeAll(transportTaskListAsDestination.getToRemoveList());
		}
		
		
		return location;
	
	}
	
	protected Location removeTransportTaskListAsDestination(Location location, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskListAsDestination = location.getTransportTaskListAsDestination();
		if(transportTaskListAsDestination == null){
			return location;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskListAsDestination = transportTaskListAsDestination.getToRemoveList();
		
		if(toRemoveTransportTaskListAsDestination == null){
			return location;
		}
		if(toRemoveTransportTaskListAsDestination.isEmpty()){
			return location;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskListAsDestination,options);
		
		return location;
	
	}
	
	

 	
 	
	
	
	
		

	public Location present(Location location,Map<String, Object> options){
	
		presentTransportTaskListAsSource(location,options);
		presentTransportTaskListAsDestination(location,options);

		return location;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Location presentTransportTaskListAsSource(
			Location location,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskListAsSource = location.getTransportTaskListAsSource();		
				SmartList<TransportTask> newList= presentSubList(location.getId(),
				transportTaskListAsSource,
				options,
				getTransportTaskDAO()::countTransportTaskBySource,
				getTransportTaskDAO()::findTransportTaskBySource
				);

		
		location.setTransportTaskListAsSource(newList);
		

		return location;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Location presentTransportTaskListAsDestination(
			Location location,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskListAsDestination = location.getTransportTaskListAsDestination();		
				SmartList<TransportTask> newList= presentSubList(location.getId(),
				transportTaskListAsDestination,
				options,
				getTransportTaskDAO()::countTransportTaskByDestination,
				getTransportTaskDAO()::findTransportTaskByDestination
				);

		
		location.setTransportTaskListAsDestination(newList);
		

		return location;
	}			
		

	
    public SmartList<Location> requestCandidateLocationForTransportTaskAsSource(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LocationTable.COLUMN_NAME, filterKey, pageNo, pageSize, getLocationMapper());
    }
		
    public SmartList<Location> requestCandidateLocationForTransportTaskAsDestination(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LocationTable.COLUMN_NAME, filterKey, pageNo, pageSize, getLocationMapper());
    }
		

	protected String getTableName(){
		return LocationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Location> locationList) {		
		this.enhanceListInternal(locationList, this.getLocationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Location> locationList = ownerEntity.collectRefsWithType(Location.INTERNAL_TYPE);
		this.enhanceList(locationList);
		
	}
	
	@Override
	public SmartList<Location> findLocationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLocationMapper());

	}
	@Override
	public int countLocationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLocationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Location> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLocationMapper());
	}
}


