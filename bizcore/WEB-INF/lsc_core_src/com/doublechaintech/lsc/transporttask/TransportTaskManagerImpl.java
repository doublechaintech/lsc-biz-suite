
package com.doublechaintech.lsc.transporttask;

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

import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;

import com.doublechaintech.lsc.merchant.CandidateMerchant;
import com.doublechaintech.lsc.transportproject.CandidateTransportProject;
import com.doublechaintech.lsc.location.CandidateLocation;
import com.doublechaintech.lsc.platform.CandidatePlatform;
import com.doublechaintech.lsc.transporttaskstatus.CandidateTransportTaskStatus;

import com.doublechaintech.lsc.transporttask.TransportTask;






public class TransportTaskManagerImpl extends CustomLscCheckerManager implements TransportTaskManager {
	
	private static final String SERVICE_TYPE = "TransportTask";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransportTaskManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransportTaskManagerException(message);

	}
	
	

 	protected TransportTask saveTransportTask(LscUserContext userContext, TransportTask transportTask, String [] tokensExpr) throws Exception{	
 		//return getTransportTaskDAO().save(transportTask, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTask(userContext, transportTask, tokens);
 	}
 	
 	protected TransportTask saveTransportTaskDetail(LscUserContext userContext, TransportTask transportTask) throws Exception{	

 		
 		return saveTransportTask(userContext, transportTask, allTokens());
 	}
 	
 	public TransportTask loadTransportTask(LscUserContext userContext, String transportTaskId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTask, tokens);
 	}
 	
 	
 	 public TransportTask searchTransportTask(LscUserContext userContext, String transportTaskId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTask, tokens);
 	}
 	
 	

 	protected TransportTask present(LscUserContext userContext, TransportTask transportTask, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTask,tokens);
		
		
		TransportTask  transportTaskToPresent = userContext.getDAOGroup().getTransportTaskDAO().present(transportTask, tokens);
		
		List<BaseEntity> entityListToNaming = transportTaskToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransportTaskDAO().alias(entityListToNaming);
		
		return  transportTaskToPresent;
		
		
	}
 
 	
 	
 	public TransportTask loadTransportTaskDetail(LscUserContext userContext, String transportTaskId) throws Exception{	
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, allTokens());
 		return present(userContext,transportTask, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String transportTaskId) throws Exception{	
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, viewTokens());
 		return present(userContext,transportTask, allTokens());
		
 	}
 	protected TransportTask saveTransportTask(LscUserContext userContext, TransportTask transportTask, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransportTaskDAO().save(transportTask, tokens);
 	}
 	protected TransportTask loadTransportTask(LscUserContext userContext, String transportTaskId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskManagerException.class);

 
 		return userContext.getDAOGroup().getTransportTaskDAO().load(transportTaskId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportTask transportTask, Map<String, Object> tokens){
		super.addActions(userContext, transportTask, tokens);
		
		addAction(userContext, transportTask, tokens,"@create","createTransportTask","createTransportTask/","main","primary");
		addAction(userContext, transportTask, tokens,"@update","updateTransportTask","updateTransportTask/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"@copy","cloneTransportTask","cloneTransportTask/"+transportTask.getId()+"/","main","primary");
		
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_project","transferToAnotherProject","transferToAnotherProject/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_source","transferToAnotherSource","transferToAnotherSource/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_destination","transferToAnotherDestination","transferToAnotherDestination/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_status","transferToAnotherStatus","transferToAnotherStatus/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_sender","transferToAnotherSender","transferToAnotherSender/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_receiver","transferToAnotherReceiver","transferToAnotherReceiver/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.addTransportTaskTrack","addTransportTaskTrack","addTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.removeTransportTaskTrack","removeTransportTaskTrack","removeTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.updateTransportTaskTrack","updateTransportTaskTrack","updateTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.copyTransportTaskTrackFrom","copyTransportTaskTrackFrom","copyTransportTaskTrackFrom/"+transportTask.getId()+"/","transportTaskTrackList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportTask transportTask, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportTask createTransportTask(LscUserContext userContext,String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransportTask(name);
		userContext.getChecker().checkRemarkOfTransportTask(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);


		TransportTask transportTask=createNewTransportTask();	

		transportTask.setName(name);
			
		TransportProject project = loadTransportProject(userContext, projectId,emptyOptions());
		transportTask.setProject(project);
		
		
			
		Location source = loadLocation(userContext, sourceId,emptyOptions());
		transportTask.setSource(source);
		
		
			
		Location destination = loadLocation(userContext, destinationId,emptyOptions());
		transportTask.setDestination(destination);
		
		
		transportTask.setRemark(remark);
			
		TransportTaskStatus status = loadTransportTaskStatus(userContext, statusId,emptyOptions());
		transportTask.setStatus(status);
		
		
			
		Merchant sender = loadMerchant(userContext, senderId,emptyOptions());
		transportTask.setSender(sender);
		
		
			
		Merchant receiver = loadMerchant(userContext, receiverId,emptyOptions());
		transportTask.setReceiver(receiver);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		transportTask.setPlatform(platform);
		
		
		transportTask.setCreateTime(userContext.now());
		transportTask.setUpdateTime(userContext.now());

		transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
		
		onNewInstanceCreated(userContext, transportTask);
		return transportTask;

		
	}
	protected TransportTask createNewTransportTask() 
	{
		
		return new TransportTask();		
	}
	
	protected void checkParamsForUpdatingTransportTask(LscUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask( transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}		

				

				

		
		if(TransportTask.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTransportTask(parseString(newValueExpr));
		}		

				

				

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
	
		
	}
	
	
	
	public TransportTask clone(LscUserContext userContext, String fromTransportTaskId) throws Exception{
		
		return userContext.getDAOGroup().getTransportTaskDAO().clone(fromTransportTaskId, this.allTokens());
	}
	
	public TransportTask internalSaveTransportTask(LscUserContext userContext, TransportTask transportTask) throws Exception 
	{
		return internalSaveTransportTask(userContext, transportTask, allTokens());

	}
	public TransportTask internalSaveTransportTask(LscUserContext userContext, TransportTask transportTask, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransportTask(userContext, transportTaskId, transportTaskVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transportTask){ 
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTask.
			
			
			transportTask = saveTransportTask(userContext, transportTask, options);
			return transportTask;
			
		}

	}
	
	public TransportTask updateTransportTask(LscUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTask(userContext, transportTaskId, transportTaskVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		if(transportTask.getVersion() != transportTaskVersion){
			String message = "The target version("+transportTask.getVersion()+") is not equals to version("+transportTaskVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTask){ 
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTask.
			transportTask.updateUpdateTime(userContext.now());
			transportTask.changeProperty(property, newValueExpr);
			transportTask = saveTransportTask(userContext, transportTask, tokens().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
			//return saveTransportTask(userContext, transportTask, tokens().done());
		}

	}
	
	public TransportTask updateTransportTaskProperty(LscUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTask(userContext, transportTaskId, transportTaskVersion, property, newValueExpr, tokensExpr);
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		if(transportTask.getVersion() != transportTaskVersion){
			String message = "The target version("+transportTask.getVersion()+") is not equals to version("+transportTaskVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTask){ 
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTask.
			
			transportTask.changeProperty(property, newValueExpr);
			transportTask.updateUpdateTime(userContext.now());
			transportTask = saveTransportTask(userContext, transportTask, tokens().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
			//return saveTransportTask(userContext, transportTask, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportTaskTokens tokens(){
		return TransportTaskTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTaskTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportTaskTrackListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTaskTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProject(LscUserContext userContext, String transportTaskId, String anotherProjectId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
 		userContext.getChecker().checkIdOfTransportProject(anotherProjectId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
 		
 	}
 	public TransportTask transferToAnotherProject(LscUserContext userContext, String transportTaskId, String anotherProjectId) throws Exception
 	{
 		checkParamsForTransferingAnotherProject(userContext, transportTaskId,anotherProjectId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportProject project = loadTransportProject(userContext, anotherProjectId, emptyOptions());		
			transportTask.updateProject(project);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTransportProject requestCandidateProject(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportProject result = new CandidateTransportProject();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportProject> candidateList = userContext.getDAOGroup().getTransportProjectDAO().requestCandidateTransportProjectForTransportTask(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherSource(LscUserContext userContext, String transportTaskId, String anotherSourceId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
 		userContext.getChecker().checkIdOfLocation(anotherSourceId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
 		
 	}
 	public TransportTask transferToAnotherSource(LscUserContext userContext, String transportTaskId, String anotherSourceId) throws Exception
 	{
 		checkParamsForTransferingAnotherSource(userContext, transportTaskId,anotherSourceId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Location source = loadLocation(userContext, anotherSourceId, emptyOptions());		
			transportTask.updateSource(source);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLocation requestCandidateSource(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLocation result = new CandidateLocation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Location> candidateList = userContext.getDAOGroup().getLocationDAO().requestCandidateLocationForTransportTaskAsSource(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherDestination(LscUserContext userContext, String transportTaskId, String anotherDestinationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
 		userContext.getChecker().checkIdOfLocation(anotherDestinationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
 		
 	}
 	public TransportTask transferToAnotherDestination(LscUserContext userContext, String transportTaskId, String anotherDestinationId) throws Exception
 	{
 		checkParamsForTransferingAnotherDestination(userContext, transportTaskId,anotherDestinationId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Location destination = loadLocation(userContext, anotherDestinationId, emptyOptions());		
			transportTask.updateDestination(destination);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLocation requestCandidateDestination(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLocation result = new CandidateLocation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Location> candidateList = userContext.getDAOGroup().getLocationDAO().requestCandidateLocationForTransportTaskAsDestination(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherStatus(LscUserContext userContext, String transportTaskId, String anotherStatusId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
 		userContext.getChecker().checkIdOfTransportTaskStatus(anotherStatusId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
 		
 	}
 	public TransportTask transferToAnotherStatus(LscUserContext userContext, String transportTaskId, String anotherStatusId) throws Exception
 	{
 		checkParamsForTransferingAnotherStatus(userContext, transportTaskId,anotherStatusId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTaskStatus status = loadTransportTaskStatus(userContext, anotherStatusId, emptyOptions());		
			transportTask.updateStatus(status);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTransportTaskStatus requestCandidateStatus(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportTaskStatus result = new CandidateTransportTaskStatus();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportTaskStatus> candidateList = userContext.getDAOGroup().getTransportTaskStatusDAO().requestCandidateTransportTaskStatusForTransportTask(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherSender(LscUserContext userContext, String transportTaskId, String anotherSenderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
 		userContext.getChecker().checkIdOfMerchant(anotherSenderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
 		
 	}
 	public TransportTask transferToAnotherSender(LscUserContext userContext, String transportTaskId, String anotherSenderId) throws Exception
 	{
 		checkParamsForTransferingAnotherSender(userContext, transportTaskId,anotherSenderId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Merchant sender = loadMerchant(userContext, anotherSenderId, emptyOptions());		
			transportTask.updateSender(sender);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateMerchant requestCandidateSender(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateMerchant result = new CandidateMerchant();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Merchant> candidateList = userContext.getDAOGroup().getMerchantDAO().requestCandidateMerchantForTransportTaskAsSender(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherReceiver(LscUserContext userContext, String transportTaskId, String anotherReceiverId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
 		userContext.getChecker().checkIdOfMerchant(anotherReceiverId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
 		
 	}
 	public TransportTask transferToAnotherReceiver(LscUserContext userContext, String transportTaskId, String anotherReceiverId) throws Exception
 	{
 		checkParamsForTransferingAnotherReceiver(userContext, transportTaskId,anotherReceiverId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Merchant receiver = loadMerchant(userContext, anotherReceiverId, emptyOptions());		
			transportTask.updateReceiver(receiver);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateMerchant requestCandidateReceiver(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateMerchant result = new CandidateMerchant();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Merchant> candidateList = userContext.getDAOGroup().getMerchantDAO().requestCandidateMerchantForTransportTaskAsReceiver(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(LscUserContext userContext, String transportTaskId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
 		
 	}
 	public TransportTask transferToAnotherPlatform(LscUserContext userContext, String transportTaskId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, transportTaskId,anotherPlatformId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			transportTask.updatePlatform(platform);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForTransportTask(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected TransportProject loadTransportProject(LscUserContext userContext, String newProjectId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTransportProjectDAO().load(newProjectId, options);
 	}
 	
 	
 	
	
	 	
 	protected TransportTaskStatus loadTransportTaskStatus(LscUserContext userContext, String newStatusId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTransportTaskStatusDAO().load(newStatusId, options);
 	}
 	
 	
 	
	
	 	
 	protected Merchant loadMerchant(LscUserContext userContext, String newSenderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getMerchantDAO().load(newSenderId, options);
 	}
 	
 	
 	
	
	 	
 	protected Location loadLocation(LscUserContext userContext, String newSourceId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLocationDAO().load(newSourceId, options);
 	}
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(LscUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String transportTaskId, int transportTaskVersion) throws Exception {
		//deleteInternal(userContext, transportTaskId, transportTaskVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String transportTaskId, int transportTaskVersion) throws Exception{
			
		userContext.getDAOGroup().getTransportTaskDAO().delete(transportTaskId, transportTaskVersion);
	}
	
	public TransportTask forgetByAll(LscUserContext userContext, String transportTaskId, int transportTaskVersion) throws Exception {
		return forgetByAllInternal(userContext, transportTaskId, transportTaskVersion);		
	}
	protected TransportTask forgetByAllInternal(LscUserContext userContext,
			String transportTaskId, int transportTaskVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransportTaskDAO().disconnectFromAll(transportTaskId, transportTaskVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTaskManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransportTaskDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingTransportTaskTrack(LscUserContext userContext, String transportTaskId, String name, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);

		
		userContext.getChecker().checkNameOfTransportTaskTrack(name);
		
		userContext.getChecker().checkLatitudeOfTransportTaskTrack(latitude);
		
		userContext.getChecker().checkLongitudeOfTransportTaskTrack(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);

	
	}
	public  TransportTask addTransportTaskTrack(LscUserContext userContext, String transportTaskId, String name, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTaskTrack(userContext,transportTaskId,name, latitude, longitude,tokensExpr);
		
		TransportTaskTrack transportTaskTrack = createTransportTaskTrack(userContext,name, latitude, longitude);
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.addTransportTaskTrack( transportTaskTrack );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			
			userContext.getManagerGroup().getTransportTaskTrackManager().onNewInstanceCreated(userContext, transportTaskTrack);
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskTrackProperties(LscUserContext userContext, String transportTaskId,String id,String name,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkIdOfTransportTaskTrack(id);
		
		userContext.getChecker().checkNameOfTransportTaskTrack( name);
		userContext.getChecker().checkLatitudeOfTransportTaskTrack( latitude);
		userContext.getChecker().checkLongitudeOfTransportTaskTrack( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
		
	}
	public  TransportTask updateTransportTaskTrackProperties(LscUserContext userContext, String transportTaskId, String id,String name,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskTrackProperties(userContext,transportTaskId,id,name,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskTrackListList()
				.searchTransportTaskTrackListWith(TransportTaskTrack.ID_PROPERTY, "is", id).done();
		
		TransportTask transportTaskToUpdate = loadTransportTask(userContext, transportTaskId, options);
		
		if(transportTaskToUpdate.getTransportTaskTrackList().isEmpty()){
			throw new TransportTaskManagerException("TransportTaskTrack is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTaskTrack item = transportTaskToUpdate.getTransportTaskTrackList().first();
		
		item.updateName( name );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingTransportTaskTrack(userContext,transportTaskId,name, code, used,tokensExpr);
		TransportTask transportTask = saveTransportTask(userContext, transportTaskToUpdate, tokens().withTransportTaskTrackList().done());
		synchronized(transportTask){ 
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTaskTrack createTransportTaskTrack(LscUserContext userContext, String name, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTaskTrack transportTaskTrack = new TransportTaskTrack();
		
		
		transportTaskTrack.setName(name);		
		transportTaskTrack.setLatitude(latitude);		
		transportTaskTrack.setLongitude(longitude);		
		transportTaskTrack.setCreateTime(userContext.now());		
		transportTaskTrack.setUpdateTime(userContext.now());
	
		
		return transportTaskTrack;
	
		
	}
	
	protected TransportTaskTrack createIndexedTransportTaskTrack(String id, int version){

		TransportTaskTrack transportTaskTrack = new TransportTaskTrack();
		transportTaskTrack.setId(id);
		transportTaskTrack.setVersion(version);
		return transportTaskTrack;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskTrackList(LscUserContext userContext, String transportTaskId, 
			String transportTaskTrackIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		for(String transportTaskTrackId: transportTaskTrackIds){
			userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
		
	}
	public  TransportTask removeTransportTaskTrackList(LscUserContext userContext, String transportTaskId, 
			String transportTaskTrackIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskTrackList(userContext, transportTaskId,  transportTaskTrackIds, tokensExpr);
			
			
			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
			synchronized(transportTask){ 
				//Will be good when the transportTask loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransportTaskDAO().planToRemoveTransportTaskTrackList(transportTask, transportTaskTrackIds, allTokens());
				transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
				deleteRelationListInGraph(userContext, transportTask.getTransportTaskTrackList());
				return present(userContext,transportTask, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTaskTrack(LscUserContext userContext, String transportTaskId, 
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportTask( transportTaskId);
		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().checkVersionOfTransportTaskTrack(transportTaskTrackVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
	
	}
	public  TransportTask removeTransportTaskTrack(LscUserContext userContext, String transportTaskId, 
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTaskTrack(userContext,transportTaskId, transportTaskTrackId, transportTaskTrackVersion,tokensExpr);
		
		TransportTaskTrack transportTaskTrack = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.removeTransportTaskTrack( transportTaskTrack );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			deleteRelationInGraph(userContext, transportTaskTrack);
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTaskTrack(LscUserContext userContext, String transportTaskId, 
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportTask( transportTaskId);
		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().checkVersionOfTransportTaskTrack(transportTaskTrackVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
	
	}
	public  TransportTask copyTransportTaskTrackFrom(LscUserContext userContext, String transportTaskId, 
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTaskTrack(userContext,transportTaskId, transportTaskTrackId, transportTaskTrackVersion,tokensExpr);
		
		TransportTaskTrack transportTaskTrack = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportTaskTrack.updateUpdateTime(userContext.now());
			
			transportTask.copyTransportTaskTrackFrom( transportTaskTrack );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			
			userContext.getManagerGroup().getTransportTaskTrackManager().onNewInstanceCreated(userContext, (TransportTaskTrack)transportTask.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTaskTrack(LscUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().checkVersionOfTransportTaskTrack(transportTaskTrackVersion);
		

		if(TransportTaskTrack.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTaskTrack(parseString(newValueExpr));
		}
		
		if(TransportTaskTrack.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		}
		
		if(TransportTaskTrack.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskManagerException.class);
	
	}
	
	public  TransportTask updateTransportTaskTrack(LscUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskId, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskTrackList().searchTransportTaskTrackListWith(TransportTaskTrack.ID_PROPERTY, "eq", transportTaskTrackId).done();
		
		
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, loadTokens);
		
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportTask.removeTransportTaskTrack( transportTaskTrack );	
			//make changes to AcceleraterAccount.
			TransportTaskTrack transportTaskTrackIndex = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);
		
			TransportTaskTrack transportTaskTrack = transportTask.findTheTransportTaskTrack(transportTaskTrackIndex);
			if(transportTaskTrack == null){
				throw new TransportTaskManagerException(transportTaskTrack+" is NOT FOUND" );
			}
			
			transportTaskTrack.changeProperty(property, newValueExpr);
			transportTaskTrack.updateUpdateTime(userContext.now());
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, TransportTask newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


