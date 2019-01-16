
package com.doublechaintech.lsc.transporttaskstatus;

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
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;






public class TransportTaskStatusManagerImpl extends CustomLscCheckerManager implements TransportTaskStatusManager {
	
	private static final String SERVICE_TYPE = "TransportTaskStatus";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransportTaskStatusManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransportTaskStatusManagerException(message);

	}
	
	

 	protected TransportTaskStatus saveTransportTaskStatus(LscUserContext userContext, TransportTaskStatus transportTaskStatus, String [] tokensExpr) throws Exception{	
 		//return getTransportTaskStatusDAO().save(transportTaskStatus, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTaskStatus(userContext, transportTaskStatus, tokens);
 	}
 	
 	protected TransportTaskStatus saveTransportTaskStatusDetail(LscUserContext userContext, TransportTaskStatus transportTaskStatus) throws Exception{	

 		
 		return saveTransportTaskStatus(userContext, transportTaskStatus, allTokens());
 	}
 	
 	public TransportTaskStatus loadTransportTaskStatus(LscUserContext userContext, String transportTaskStatusId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskStatusManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus( userContext, transportTaskStatusId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskStatus, tokens);
 	}
 	
 	
 	 public TransportTaskStatus searchTransportTaskStatus(LscUserContext userContext, String transportTaskStatusId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskStatusManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus( userContext, transportTaskStatusId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskStatus, tokens);
 	}
 	
 	

 	protected TransportTaskStatus present(LscUserContext userContext, TransportTaskStatus transportTaskStatus, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTaskStatus,tokens);
		
		
		TransportTaskStatus  transportTaskStatusToPresent = userContext.getDAOGroup().getTransportTaskStatusDAO().present(transportTaskStatus, tokens);
		
		List<BaseEntity> entityListToNaming = transportTaskStatusToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransportTaskStatusDAO().alias(entityListToNaming);
		
		return  transportTaskStatusToPresent;
		
		
	}
 
 	
 	
 	public TransportTaskStatus loadTransportTaskStatusDetail(LscUserContext userContext, String transportTaskStatusId) throws Exception{	
 		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus( userContext, transportTaskStatusId, allTokens());
 		return present(userContext,transportTaskStatus, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String transportTaskStatusId) throws Exception{	
 		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus( userContext, transportTaskStatusId, viewTokens());
 		return present(userContext,transportTaskStatus, allTokens());
		
 	}
 	protected TransportTaskStatus saveTransportTaskStatus(LscUserContext userContext, TransportTaskStatus transportTaskStatus, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransportTaskStatusDAO().save(transportTaskStatus, tokens);
 	}
 	protected TransportTaskStatus loadTransportTaskStatus(LscUserContext userContext, String transportTaskStatusId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskStatusManagerException.class);

 
 		return userContext.getDAOGroup().getTransportTaskStatusDAO().load(transportTaskStatusId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportTaskStatus transportTaskStatus, Map<String, Object> tokens){
		super.addActions(userContext, transportTaskStatus, tokens);
		
		addAction(userContext, transportTaskStatus, tokens,"@create","createTransportTaskStatus","createTransportTaskStatus/","main","primary");
		addAction(userContext, transportTaskStatus, tokens,"@update","updateTransportTaskStatus","updateTransportTaskStatus/"+transportTaskStatus.getId()+"/","main","primary");
		addAction(userContext, transportTaskStatus, tokens,"@copy","cloneTransportTaskStatus","cloneTransportTaskStatus/"+transportTaskStatus.getId()+"/","main","primary");
		
		addAction(userContext, transportTaskStatus, tokens,"transport_task_status.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+transportTaskStatus.getId()+"/","main","primary");
		addAction(userContext, transportTaskStatus, tokens,"transport_task_status.addTransportTask","addTransportTask","addTransportTask/"+transportTaskStatus.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTaskStatus, tokens,"transport_task_status.removeTransportTask","removeTransportTask","removeTransportTask/"+transportTaskStatus.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTaskStatus, tokens,"transport_task_status.updateTransportTask","updateTransportTask","updateTransportTask/"+transportTaskStatus.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTaskStatus, tokens,"transport_task_status.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+transportTaskStatus.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportTaskStatus transportTaskStatus, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportTaskStatus createTransportTaskStatus(LscUserContext userContext,String name, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransportTaskStatus(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);


		TransportTaskStatus transportTaskStatus=createNewTransportTaskStatus();	

		transportTaskStatus.setName(name);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		transportTaskStatus.setPlatform(platform);
		
		

		transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, emptyOptions());
		
		onNewInstanceCreated(userContext, transportTaskStatus);
		return transportTaskStatus;

		
	}
	protected TransportTaskStatus createNewTransportTaskStatus() 
	{
		
		return new TransportTaskStatus();		
	}
	
	protected void checkParamsForUpdatingTransportTaskStatus(LscUserContext userContext,String transportTaskStatusId, int transportTaskStatusVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().checkVersionOfTransportTaskStatus( transportTaskStatusVersion);
		

		if(TransportTaskStatus.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTaskStatus(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);
	
		
	}
	
	
	
	public TransportTaskStatus clone(LscUserContext userContext, String fromTransportTaskStatusId) throws Exception{
		
		return userContext.getDAOGroup().getTransportTaskStatusDAO().clone(fromTransportTaskStatusId, this.allTokens());
	}
	
	public TransportTaskStatus internalSaveTransportTaskStatus(LscUserContext userContext, TransportTaskStatus transportTaskStatus) throws Exception 
	{
		return internalSaveTransportTaskStatus(userContext, transportTaskStatus, allTokens());

	}
	public TransportTaskStatus internalSaveTransportTaskStatus(LscUserContext userContext, TransportTaskStatus transportTaskStatus, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransportTaskStatus(userContext, transportTaskStatusId, transportTaskStatusVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transportTaskStatus){ 
			//will be good when the transportTaskStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskStatus.
			
			
			transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, options);
			return transportTaskStatus;
			
		}

	}
	
	public TransportTaskStatus updateTransportTaskStatus(LscUserContext userContext,String transportTaskStatusId, int transportTaskStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTaskStatus(userContext, transportTaskStatusId, transportTaskStatusVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());
		if(transportTaskStatus.getVersion() != transportTaskStatusVersion){
			String message = "The target version("+transportTaskStatus.getVersion()+") is not equals to version("+transportTaskStatusVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTaskStatus){ 
			//will be good when the transportTaskStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskStatus.
			
			transportTaskStatus.changeProperty(property, newValueExpr);
			transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().done());
			return present(userContext,transportTaskStatus, mergedAllTokens(tokensExpr));
			//return saveTransportTaskStatus(userContext, transportTaskStatus, tokens().done());
		}

	}
	
	public TransportTaskStatus updateTransportTaskStatusProperty(LscUserContext userContext,String transportTaskStatusId, int transportTaskStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTaskStatus(userContext, transportTaskStatusId, transportTaskStatusVersion, property, newValueExpr, tokensExpr);
		
		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());
		if(transportTaskStatus.getVersion() != transportTaskStatusVersion){
			String message = "The target version("+transportTaskStatus.getVersion()+") is not equals to version("+transportTaskStatusVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTaskStatus){ 
			//will be good when the transportTaskStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskStatus.
			
			transportTaskStatus.changeProperty(property, newValueExpr);
			
			transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().done());
			return present(userContext,transportTaskStatus, mergedAllTokens(tokensExpr));
			//return saveTransportTaskStatus(userContext, transportTaskStatus, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportTaskStatusTokens tokens(){
		return TransportTaskStatusTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTaskStatusTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportTaskListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTaskStatusTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(LscUserContext userContext, String transportTaskStatusId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);
 		
 	}
 	public TransportTaskStatus transferToAnotherPlatform(LscUserContext userContext, String transportTaskStatusId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, transportTaskStatusId,anotherPlatformId);
 
		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());	
		synchronized(transportTaskStatus){
			//will be good when the transportTaskStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			transportTaskStatus.updatePlatform(platform);		
			transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, emptyOptions());
			
			return present(userContext,transportTaskStatus, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForTransportTaskStatus(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(LscUserContext userContext, String transportTaskStatusId, int transportTaskStatusVersion) throws Exception {
		//deleteInternal(userContext, transportTaskStatusId, transportTaskStatusVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String transportTaskStatusId, int transportTaskStatusVersion) throws Exception{
			
		userContext.getDAOGroup().getTransportTaskStatusDAO().delete(transportTaskStatusId, transportTaskStatusVersion);
	}
	
	public TransportTaskStatus forgetByAll(LscUserContext userContext, String transportTaskStatusId, int transportTaskStatusVersion) throws Exception {
		return forgetByAllInternal(userContext, transportTaskStatusId, transportTaskStatusVersion);		
	}
	protected TransportTaskStatus forgetByAllInternal(LscUserContext userContext,
			String transportTaskStatusId, int transportTaskStatusVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransportTaskStatusDAO().disconnectFromAll(transportTaskStatusId, transportTaskStatusVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTaskStatusManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransportTaskStatusDAO().deleteAll();
	}


	//disconnect TransportTaskStatus with source in TransportTask
	protected TransportTaskStatus breakWithTransportTaskBySource(LscUserContext userContext, String transportTaskStatusId, String sourceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());

			synchronized(transportTaskStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportTaskStatusDAO().planToRemoveTransportTaskListWithSource(transportTaskStatus, sourceId, this.emptyOptions());

				transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
				return transportTaskStatus;
			}
	}
	//disconnect TransportTaskStatus with destination in TransportTask
	protected TransportTaskStatus breakWithTransportTaskByDestination(LscUserContext userContext, String transportTaskStatusId, String destinationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());

			synchronized(transportTaskStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportTaskStatusDAO().planToRemoveTransportTaskListWithDestination(transportTaskStatus, destinationId, this.emptyOptions());

				transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
				return transportTaskStatus;
			}
	}
	//disconnect TransportTaskStatus with sender in TransportTask
	protected TransportTaskStatus breakWithTransportTaskBySender(LscUserContext userContext, String transportTaskStatusId, String senderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());

			synchronized(transportTaskStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportTaskStatusDAO().planToRemoveTransportTaskListWithSender(transportTaskStatus, senderId, this.emptyOptions());

				transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
				return transportTaskStatus;
			}
	}
	//disconnect TransportTaskStatus with receiver in TransportTask
	protected TransportTaskStatus breakWithTransportTaskByReceiver(LscUserContext userContext, String transportTaskStatusId, String receiverId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());

			synchronized(transportTaskStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportTaskStatusDAO().planToRemoveTransportTaskListWithReceiver(transportTaskStatus, receiverId, this.emptyOptions());

				transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
				return transportTaskStatus;
			}
	}
	//disconnect TransportTaskStatus with platform in TransportTask
	protected TransportTaskStatus breakWithTransportTaskByPlatform(LscUserContext userContext, String transportTaskStatusId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());

			synchronized(transportTaskStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportTaskStatusDAO().planToRemoveTransportTaskListWithPlatform(transportTaskStatus, platformId, this.emptyOptions());

				transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
				return transportTaskStatus;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransportTask(LscUserContext userContext, String transportTaskStatusId, String name, String sourceId, String destinationId, String remark, String senderId, String receiverId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkSourceIdOfTransportTask(sourceId);
		
		userContext.getChecker().checkDestinationIdOfTransportTask(destinationId);
		
		userContext.getChecker().checkRemarkOfTransportTask(remark);
		
		userContext.getChecker().checkSenderIdOfTransportTask(senderId);
		
		userContext.getChecker().checkReceiverIdOfTransportTask(receiverId);
		
		userContext.getChecker().checkPlatformIdOfTransportTask(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);

	
	}
	public  TransportTaskStatus addTransportTask(LscUserContext userContext, String transportTaskStatusId, String name, String sourceId, String destinationId, String remark, String senderId, String receiverId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,transportTaskStatusId,name, sourceId, destinationId, remark, senderId, receiverId, platformId,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, sourceId, destinationId, remark, senderId, receiverId, platformId);
		
		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());
		synchronized(transportTaskStatus){ 
			//Will be good when the transportTaskStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTaskStatus.addTransportTask( transportTask );		
			transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,transportTaskStatus, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(LscUserContext userContext, String transportTaskStatusId,String id,String name,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkRemarkOfTransportTask( remark);

		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);
		
	}
	public  TransportTaskStatus updateTransportTaskProperties(LscUserContext userContext, String transportTaskStatusId, String id,String name,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskProperties(userContext,transportTaskStatusId,id,name,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		TransportTaskStatus transportTaskStatusToUpdate = loadTransportTaskStatus(userContext, transportTaskStatusId, options);
		
		if(transportTaskStatusToUpdate.getTransportTaskList().isEmpty()){
			throw new TransportTaskStatusManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = transportTaskStatusToUpdate.getTransportTaskList().first();
		
		item.updateName( name );
		item.updateRemark( remark );

		
		//checkParamsForAddingTransportTask(userContext,transportTaskStatusId,name, code, used,tokensExpr);
		TransportTaskStatus transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatusToUpdate, tokens().withTransportTaskList().done());
		synchronized(transportTaskStatus){ 
			return present(userContext,transportTaskStatus, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTask(LscUserContext userContext, String name, String sourceId, String destinationId, String remark, String senderId, String receiverId, String platformId) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		Location  source = new Location();
		source.setId(sourceId);		
		transportTask.setSource(source);		
		Location  destination = new Location();
		destination.setId(destinationId);		
		transportTask.setDestination(destination);		
		transportTask.setRemark(remark);		
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
	
	protected TransportTask createIndexedTransportTask(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskList(LscUserContext userContext, String transportTaskStatusId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);
		
	}
	public  TransportTaskStatus removeTransportTaskList(LscUserContext userContext, String transportTaskStatusId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskList(userContext, transportTaskStatusId,  transportTaskIds, tokensExpr);
			
			
			TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());
			synchronized(transportTaskStatus){ 
				//Will be good when the transportTaskStatus loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransportTaskStatusDAO().planToRemoveTransportTaskList(transportTaskStatus, transportTaskIds, allTokens());
				transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, transportTaskStatus.getTransportTaskList());
				return present(userContext,transportTaskStatus, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTask(LscUserContext userContext, String transportTaskStatusId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportTaskStatus( transportTaskStatusId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);
	
	}
	public  TransportTaskStatus removeTransportTask(LscUserContext userContext, String transportTaskStatusId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,transportTaskStatusId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());
		synchronized(transportTaskStatus){ 
			//Will be good when the transportTaskStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTaskStatus.removeTransportTask( transportTask );		
			transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,transportTaskStatus, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTask(LscUserContext userContext, String transportTaskStatusId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportTaskStatus( transportTaskStatusId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);
	
	}
	public  TransportTaskStatus copyTransportTaskFrom(LscUserContext userContext, String transportTaskStatusId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,transportTaskStatusId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, allTokens());
		synchronized(transportTaskStatus){ 
			//Will be good when the transportTaskStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportTask.updateUpdateTime(userContext.now());
			
			transportTaskStatus.copyTransportTaskFrom( transportTask );		
			transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)transportTaskStatus.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportTaskStatus, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTask(LscUserContext userContext, String transportTaskStatusId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTransportTask(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskStatusManagerException.class);
	
	}
	
	public  TransportTaskStatus updateTransportTask(LscUserContext userContext, String transportTaskStatusId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, transportTaskStatusId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		TransportTaskStatus transportTaskStatus = loadTransportTaskStatus(userContext, transportTaskStatusId, loadTokens);
		
		synchronized(transportTaskStatus){ 
			//Will be good when the transportTaskStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportTaskStatus.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = transportTaskStatus.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TransportTaskStatusManagerException(transportTask+" is NOT FOUND" );
			}
			
			transportTask.changeProperty(property, newValueExpr);
			transportTask.updateUpdateTime(userContext.now());
			transportTaskStatus = saveTransportTaskStatus(userContext, transportTaskStatus, tokens().withTransportTaskList().done());
			return present(userContext,transportTaskStatus, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, TransportTaskStatus newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


