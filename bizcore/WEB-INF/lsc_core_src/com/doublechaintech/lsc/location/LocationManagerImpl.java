
package com.doublechaintech.lsc.location;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.BaseEntity;


import com.doublechaintech.lsc.Message;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;

import com.doublechaintech.lsc.LscUserContext;
//import com.doublechaintech.lsc.BaseManagerImpl;
import com.doublechaintech.lsc.LscCheckerManager;
import com.doublechaintech.lsc.CustomLscCheckerManager;

import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.platform.Platform;

import com.doublechaintech.lsc.platform.CandidatePlatform;

import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;






public class LocationManagerImpl extends CustomLscCheckerManager implements LocationManager {
	
	private static final String SERVICE_TYPE = "Location";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LocationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LocationManagerException(message);

	}
	
	

 	protected Location saveLocation(LscUserContext userContext, Location location, String [] tokensExpr) throws Exception{	
 		//return getLocationDAO().save(location, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLocation(userContext, location, tokens);
 	}
 	
 	protected Location saveLocationDetail(LscUserContext userContext, Location location) throws Exception{	

 		
 		return saveLocation(userContext, location, allTokens());
 	}
 	
 	public Location loadLocation(LscUserContext userContext, String locationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().throwExceptionIfHasErrors( LocationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Location location = loadLocation( userContext, locationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,location, tokens);
 	}
 	
 	
 	 public Location searchLocation(LscUserContext userContext, String locationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().throwExceptionIfHasErrors( LocationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Location location = loadLocation( userContext, locationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,location, tokens);
 	}
 	
 	

 	protected Location present(LscUserContext userContext, Location location, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,location,tokens);
		
		
		Location  locationToPresent = userContext.getDAOGroup().getLocationDAO().present(location, tokens);
		
		List<BaseEntity> entityListToNaming = locationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLocationDAO().alias(entityListToNaming);
		
		return  locationToPresent;
		
		
	}
 
 	
 	
 	public Location loadLocationDetail(LscUserContext userContext, String locationId) throws Exception{	
 		Location location = loadLocation( userContext, locationId, allTokens());
 		return present(userContext,location, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String locationId) throws Exception{	
 		Location location = loadLocation( userContext, locationId, viewTokens());
 		return present(userContext,location, allTokens());
		
 	}
 	protected Location saveLocation(LscUserContext userContext, Location location, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLocationDAO().save(location, tokens);
 	}
 	protected Location loadLocation(LscUserContext userContext, String locationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().throwExceptionIfHasErrors( LocationManagerException.class);

 
 		return userContext.getDAOGroup().getLocationDAO().load(locationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, Location location, Map<String, Object> tokens){
		super.addActions(userContext, location, tokens);
		
		addAction(userContext, location, tokens,"@create","createLocation","createLocation/","main","primary");
		addAction(userContext, location, tokens,"@update","updateLocation","updateLocation/"+location.getId()+"/","main","primary");
		addAction(userContext, location, tokens,"@copy","cloneLocation","cloneLocation/"+location.getId()+"/","main","primary");
		
		addAction(userContext, location, tokens,"location.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+location.getId()+"/","main","primary");
		addAction(userContext, location, tokens,"location.addTransportTask","addTransportTask","addTransportTask/"+location.getId()+"/","transportTaskListAsSource","primary");
		addAction(userContext, location, tokens,"location.removeTransportTask","removeTransportTask","removeTransportTask/"+location.getId()+"/","transportTaskListAsSource","primary");
		addAction(userContext, location, tokens,"location.updateTransportTask","updateTransportTask","updateTransportTask/"+location.getId()+"/","transportTaskListAsSource","primary");
		addAction(userContext, location, tokens,"location.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+location.getId()+"/","transportTaskListAsSource","primary");
		addAction(userContext, location, tokens,"location.addTransportTask","addTransportTask","addTransportTask/"+location.getId()+"/","transportTaskListAsDestination","primary");
		addAction(userContext, location, tokens,"location.removeTransportTask","removeTransportTask","removeTransportTask/"+location.getId()+"/","transportTaskListAsDestination","primary");
		addAction(userContext, location, tokens,"location.updateTransportTask","updateTransportTask","updateTransportTask/"+location.getId()+"/","transportTaskListAsDestination","primary");
		addAction(userContext, location, tokens,"location.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+location.getId()+"/","transportTaskListAsDestination","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, Location location, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Location createLocation(LscUserContext userContext,String name, String contactPerson, String contactPhone, String description, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLocation(name);
		userContext.getChecker().checkContactPersonOfLocation(contactPerson);
		userContext.getChecker().checkContactPhoneOfLocation(contactPhone);
		userContext.getChecker().checkDescriptionOfLocation(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);


		Location location=createNewLocation();	

		location.setName(name);
		location.setContactPerson(contactPerson);
		location.setContactPhone(contactPhone);
		location.setDescription(description);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		location.setPlatform(platform);
		
		
		location.setCreateTime(userContext.now());
		location.setUpdateTime(userContext.now());

		location = saveLocation(userContext, location, emptyOptions());
		
		onNewInstanceCreated(userContext, location);
		return location;

		
	}
	protected Location createNewLocation() 
	{
		
		return new Location();		
	}
	
	protected void checkParamsForUpdatingLocation(LscUserContext userContext,String locationId, int locationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().checkVersionOfLocation( locationVersion);
		

		if(Location.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLocation(parseString(newValueExpr));
		}
		if(Location.CONTACT_PERSON_PROPERTY.equals(property)){
			userContext.getChecker().checkContactPersonOfLocation(parseString(newValueExpr));
		}
		if(Location.CONTACT_PHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkContactPhoneOfLocation(parseString(newValueExpr));
		}
		if(Location.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfLocation(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
	
		
	}
	
	
	
	public Location clone(LscUserContext userContext, String fromLocationId) throws Exception{
		
		return userContext.getDAOGroup().getLocationDAO().clone(fromLocationId, this.allTokens());
	}
	
	public Location internalSaveLocation(LscUserContext userContext, Location location) throws Exception 
	{
		return internalSaveLocation(userContext, location, allTokens());

	}
	public Location internalSaveLocation(LscUserContext userContext, Location location, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLocation(userContext, locationId, locationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(location){ 
			//will be good when the location loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Location.
			
			
			location = saveLocation(userContext, location, options);
			return location;
			
		}

	}
	
	public Location updateLocation(LscUserContext userContext,String locationId, int locationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLocation(userContext, locationId, locationVersion, property, newValueExpr, tokensExpr);
		
		
		
		Location location = loadLocation(userContext, locationId, allTokens());
		if(location.getVersion() != locationVersion){
			String message = "The target version("+location.getVersion()+") is not equals to version("+locationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(location){ 
			//will be good when the location loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Location.
			location.updateUpdateTime(userContext.now());
			location.changeProperty(property, newValueExpr);
			location = saveLocation(userContext, location, tokens().done());
			return present(userContext,location, mergedAllTokens(tokensExpr));
			//return saveLocation(userContext, location, tokens().done());
		}

	}
	
	public Location updateLocationProperty(LscUserContext userContext,String locationId, int locationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLocation(userContext, locationId, locationVersion, property, newValueExpr, tokensExpr);
		
		Location location = loadLocation(userContext, locationId, allTokens());
		if(location.getVersion() != locationVersion){
			String message = "The target version("+location.getVersion()+") is not equals to version("+locationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(location){ 
			//will be good when the location loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Location.
			
			location.changeProperty(property, newValueExpr);
			location.updateUpdateTime(userContext.now());
			location = saveLocation(userContext, location, tokens().done());
			return present(userContext,location, mergedAllTokens(tokensExpr));
			//return saveLocation(userContext, location, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LocationTokens tokens(){
		return LocationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LocationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportTaskListAsSourceWith("id","desc")
		.sortTransportTaskListAsDestinationWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LocationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(LscUserContext userContext, String locationId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLocation(locationId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
 		
 	}
 	public Location transferToAnotherPlatform(LscUserContext userContext, String locationId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, locationId,anotherPlatformId);
 
		Location location = loadLocation(userContext, locationId, allTokens());	
		synchronized(location){
			//will be good when the location loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			location.updatePlatform(platform);		
			location = saveLocation(userContext, location, emptyOptions());
			
			return present(userContext,location, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForLocation(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(LscUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String locationId, int locationVersion) throws Exception {
		//deleteInternal(userContext, locationId, locationVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String locationId, int locationVersion) throws Exception{
			
		userContext.getDAOGroup().getLocationDAO().delete(locationId, locationVersion);
	}
	
	public Location forgetByAll(LscUserContext userContext, String locationId, int locationVersion) throws Exception {
		return forgetByAllInternal(userContext, locationId, locationVersion);		
	}
	protected Location forgetByAllInternal(LscUserContext userContext,
			String locationId, int locationVersion) throws Exception{
			
		return userContext.getDAOGroup().getLocationDAO().disconnectFromAll(locationId, locationVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LocationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLocationDAO().deleteAll();
	}


	//disconnect Location with project in TransportTask
	protected Location breakWithTransportTaskAsSourceByProject(LscUserContext userContext, String locationId, String projectId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsSourceWithProject(location, projectId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
				return location;
			}
	}
	//disconnect Location with status in TransportTask
	protected Location breakWithTransportTaskAsSourceByStatus(LscUserContext userContext, String locationId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsSourceWithStatus(location, statusId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
				return location;
			}
	}
	//disconnect Location with sender in TransportTask
	protected Location breakWithTransportTaskAsSourceBySender(LscUserContext userContext, String locationId, String senderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsSourceWithSender(location, senderId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
				return location;
			}
	}
	//disconnect Location with receiver in TransportTask
	protected Location breakWithTransportTaskAsSourceByReceiver(LscUserContext userContext, String locationId, String receiverId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsSourceWithReceiver(location, receiverId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
				return location;
			}
	}
	//disconnect Location with platform in TransportTask
	protected Location breakWithTransportTaskAsSourceByPlatform(LscUserContext userContext, String locationId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsSourceWithPlatform(location, platformId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
				return location;
			}
	}
	//disconnect Location with project in TransportTask
	protected Location breakWithTransportTaskAsDestinationByProject(LscUserContext userContext, String locationId, String projectId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsDestinationWithProject(location, projectId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
				return location;
			}
	}
	//disconnect Location with status in TransportTask
	protected Location breakWithTransportTaskAsDestinationByStatus(LscUserContext userContext, String locationId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsDestinationWithStatus(location, statusId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
				return location;
			}
	}
	//disconnect Location with sender in TransportTask
	protected Location breakWithTransportTaskAsDestinationBySender(LscUserContext userContext, String locationId, String senderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsDestinationWithSender(location, senderId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
				return location;
			}
	}
	//disconnect Location with receiver in TransportTask
	protected Location breakWithTransportTaskAsDestinationByReceiver(LscUserContext userContext, String locationId, String receiverId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsDestinationWithReceiver(location, receiverId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
				return location;
			}
	}
	//disconnect Location with platform in TransportTask
	protected Location breakWithTransportTaskAsDestinationByPlatform(LscUserContext userContext, String locationId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Location location = loadLocation(userContext, locationId, allTokens());

			synchronized(location){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsDestinationWithPlatform(location, platformId, this.emptyOptions());

				location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
				return location;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransportTaskAsSource(LscUserContext userContext, String locationId, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLocation(locationId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkProjectIdOfTransportTask(projectId);
		
		userContext.getChecker().checkRemarkOfTransportTask(remark);
		
		userContext.getChecker().checkStatusIdOfTransportTask(statusId);
		
		userContext.getChecker().checkSenderIdOfTransportTask(senderId);
		
		userContext.getChecker().checkReceiverIdOfTransportTask(receiverId);
		
		userContext.getChecker().checkPlatformIdOfTransportTask(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);

	
	}
	public  Location addTransportTaskAsSource(LscUserContext userContext, String locationId, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTaskAsSource(userContext,locationId,name, projectId, remark, statusId, senderId, receiverId, platformId,tokensExpr);
		
		TransportTask transportTask = createTransportTaskAsSource(userContext,name, projectId, remark, statusId, senderId, receiverId, platformId);
		
		Location location = loadLocation(userContext, locationId, allTokens());
		synchronized(location){ 
			//Will be good when the location loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			location.addTransportTaskAsSource( transportTask );		
			location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskAsSourceProperties(LscUserContext userContext, String locationId,String id,String name,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkRemarkOfTransportTask( remark);

		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
		
	}
	public  Location updateTransportTaskAsSourceProperties(LscUserContext userContext, String locationId, String id,String name,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskAsSourceProperties(userContext,locationId,id,name,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListAsSourceList()
				.searchTransportTaskListAsSourceWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		Location locationToUpdate = loadLocation(userContext, locationId, options);
		
		if(locationToUpdate.getTransportTaskListAsSource().isEmpty()){
			throw new LocationManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = locationToUpdate.getTransportTaskListAsSource().first();
		
		item.updateName( name );
		item.updateRemark( remark );

		
		//checkParamsForAddingTransportTaskAsSource(userContext,locationId,name, code, used,tokensExpr);
		Location location = saveLocation(userContext, locationToUpdate, tokens().withTransportTaskListAsSource().done());
		synchronized(location){ 
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTaskAsSource(LscUserContext userContext, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		TransportProject  project = new TransportProject();
		project.setId(projectId);		
		transportTask.setProject(project);		
		transportTask.setRemark(remark);		
		TransportTaskStatus  status = new TransportTaskStatus();
		status.setId(statusId);		
		transportTask.setStatus(status);		
		Merchant  sender = new Merchant();
		sender.setId(senderId);		
		transportTask.setSender(sender);		
		Merchant  receiver = new Merchant();
		receiver.setId(receiverId);		
		transportTask.setReceiver(receiver);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		transportTask.setPlatform(platform);		
		transportTask.setCreateTime(userContext.now());		
		transportTask.setUpdateTime(userContext.now());
	
		
		return transportTask;
	
		
	}
	
	protected TransportTask createIndexedTransportTaskAsSource(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskListAsSource(LscUserContext userContext, String locationId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLocation(locationId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
		
	}
	public  Location removeTransportTaskListAsSource(LscUserContext userContext, String locationId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskListAsSource(userContext, locationId,  transportTaskIds, tokensExpr);
			
			
			Location location = loadLocation(userContext, locationId, allTokens());
			synchronized(location){ 
				//Will be good when the location loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsSource(location, transportTaskIds, allTokens());
				location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
				deleteRelationListInGraph(userContext, location.getTransportTaskListAsSource());
				return present(userContext,location, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTaskAsSource(LscUserContext userContext, String locationId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLocation( locationId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
	
	}
	public  Location removeTransportTaskAsSource(LscUserContext userContext, String locationId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTaskAsSource(userContext,locationId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTaskAsSource(transportTaskId, transportTaskVersion);
		Location location = loadLocation(userContext, locationId, allTokens());
		synchronized(location){ 
			//Will be good when the location loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			location.removeTransportTaskAsSource( transportTask );		
			location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTaskAsSource(LscUserContext userContext, String locationId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLocation( locationId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
	
	}
	public  Location copyTransportTaskAsSourceFrom(LscUserContext userContext, String locationId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTaskAsSource(userContext,locationId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTaskAsSource = createIndexedTransportTaskAsSource(transportTaskId, transportTaskVersion);
		Location location = loadLocation(userContext, locationId, allTokens());
		synchronized(location){ 
			//Will be good when the location loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportTaskAsSource.updateUpdateTime(userContext.now());
			
			location.copyTransportTaskAsSourceFrom( transportTaskAsSource );		
			location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)location.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTaskAsSource(LscUserContext userContext, String locationId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTransportTask(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
	
	}
	
	public  Location updateTransportTaskAsSource(LscUserContext userContext, String locationId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTaskAsSource(userContext, locationId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskListAsSource().searchTransportTaskListAsSourceWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		Location location = loadLocation(userContext, locationId, loadTokens);
		
		synchronized(location){ 
			//Will be good when the location loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//location.removeTransportTaskAsSource( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTaskAsSource(transportTaskId, transportTaskVersion);
		
			TransportTask transportTaskAsSource = location.findTheTransportTaskAsSource(transportTaskIndex);
			if(transportTaskAsSource == null){
				throw new LocationManagerException(transportTaskAsSource+" is NOT FOUND" );
			}
			
			transportTaskAsSource.changeProperty(property, newValueExpr);
			transportTaskAsSource.updateUpdateTime(userContext.now());
			location = saveLocation(userContext, location, tokens().withTransportTaskListAsSource().done());
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportTaskAsDestination(LscUserContext userContext, String locationId, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLocation(locationId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkProjectIdOfTransportTask(projectId);
		
		userContext.getChecker().checkRemarkOfTransportTask(remark);
		
		userContext.getChecker().checkStatusIdOfTransportTask(statusId);
		
		userContext.getChecker().checkSenderIdOfTransportTask(senderId);
		
		userContext.getChecker().checkReceiverIdOfTransportTask(receiverId);
		
		userContext.getChecker().checkPlatformIdOfTransportTask(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);

	
	}
	public  Location addTransportTaskAsDestination(LscUserContext userContext, String locationId, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTaskAsDestination(userContext,locationId,name, projectId, remark, statusId, senderId, receiverId, platformId,tokensExpr);
		
		TransportTask transportTask = createTransportTaskAsDestination(userContext,name, projectId, remark, statusId, senderId, receiverId, platformId);
		
		Location location = loadLocation(userContext, locationId, allTokens());
		synchronized(location){ 
			//Will be good when the location loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			location.addTransportTaskAsDestination( transportTask );		
			location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskAsDestinationProperties(LscUserContext userContext, String locationId,String id,String name,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkRemarkOfTransportTask( remark);

		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
		
	}
	public  Location updateTransportTaskAsDestinationProperties(LscUserContext userContext, String locationId, String id,String name,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskAsDestinationProperties(userContext,locationId,id,name,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListAsDestinationList()
				.searchTransportTaskListAsDestinationWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		Location locationToUpdate = loadLocation(userContext, locationId, options);
		
		if(locationToUpdate.getTransportTaskListAsDestination().isEmpty()){
			throw new LocationManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = locationToUpdate.getTransportTaskListAsDestination().first();
		
		item.updateName( name );
		item.updateRemark( remark );

		
		//checkParamsForAddingTransportTaskAsDestination(userContext,locationId,name, code, used,tokensExpr);
		Location location = saveLocation(userContext, locationToUpdate, tokens().withTransportTaskListAsDestination().done());
		synchronized(location){ 
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTaskAsDestination(LscUserContext userContext, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		TransportProject  project = new TransportProject();
		project.setId(projectId);		
		transportTask.setProject(project);		
		transportTask.setRemark(remark);		
		TransportTaskStatus  status = new TransportTaskStatus();
		status.setId(statusId);		
		transportTask.setStatus(status);		
		Merchant  sender = new Merchant();
		sender.setId(senderId);		
		transportTask.setSender(sender);		
		Merchant  receiver = new Merchant();
		receiver.setId(receiverId);		
		transportTask.setReceiver(receiver);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		transportTask.setPlatform(platform);		
		transportTask.setCreateTime(userContext.now());		
		transportTask.setUpdateTime(userContext.now());
	
		
		return transportTask;
	
		
	}
	
	protected TransportTask createIndexedTransportTaskAsDestination(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskListAsDestination(LscUserContext userContext, String locationId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLocation(locationId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
		
	}
	public  Location removeTransportTaskListAsDestination(LscUserContext userContext, String locationId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskListAsDestination(userContext, locationId,  transportTaskIds, tokensExpr);
			
			
			Location location = loadLocation(userContext, locationId, allTokens());
			synchronized(location){ 
				//Will be good when the location loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLocationDAO().planToRemoveTransportTaskListAsDestination(location, transportTaskIds, allTokens());
				location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
				deleteRelationListInGraph(userContext, location.getTransportTaskListAsDestination());
				return present(userContext,location, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTaskAsDestination(LscUserContext userContext, String locationId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLocation( locationId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
	
	}
	public  Location removeTransportTaskAsDestination(LscUserContext userContext, String locationId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTaskAsDestination(userContext,locationId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTaskAsDestination(transportTaskId, transportTaskVersion);
		Location location = loadLocation(userContext, locationId, allTokens());
		synchronized(location){ 
			//Will be good when the location loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			location.removeTransportTaskAsDestination( transportTask );		
			location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTaskAsDestination(LscUserContext userContext, String locationId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLocation( locationId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
	
	}
	public  Location copyTransportTaskAsDestinationFrom(LscUserContext userContext, String locationId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTaskAsDestination(userContext,locationId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTaskAsDestination = createIndexedTransportTaskAsDestination(transportTaskId, transportTaskVersion);
		Location location = loadLocation(userContext, locationId, allTokens());
		synchronized(location){ 
			//Will be good when the location loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportTaskAsDestination.updateUpdateTime(userContext.now());
			
			location.copyTransportTaskAsDestinationFrom( transportTaskAsDestination );		
			location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)location.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTaskAsDestination(LscUserContext userContext, String locationId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTransportTask(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LocationManagerException.class);
	
	}
	
	public  Location updateTransportTaskAsDestination(LscUserContext userContext, String locationId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTaskAsDestination(userContext, locationId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskListAsDestination().searchTransportTaskListAsDestinationWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		Location location = loadLocation(userContext, locationId, loadTokens);
		
		synchronized(location){ 
			//Will be good when the location loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//location.removeTransportTaskAsDestination( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTaskAsDestination(transportTaskId, transportTaskVersion);
		
			TransportTask transportTaskAsDestination = location.findTheTransportTaskAsDestination(transportTaskIndex);
			if(transportTaskAsDestination == null){
				throw new LocationManagerException(transportTaskAsDestination+" is NOT FOUND" );
			}
			
			transportTaskAsDestination.changeProperty(property, newValueExpr);
			transportTaskAsDestination.updateUpdateTime(userContext.now());
			location = saveLocation(userContext, location, tokens().withTransportTaskListAsDestination().done());
			return present(userContext,location, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, Location newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


