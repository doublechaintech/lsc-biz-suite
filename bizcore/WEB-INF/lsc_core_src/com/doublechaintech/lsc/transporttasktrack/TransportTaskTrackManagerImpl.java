
package com.doublechaintech.lsc.transporttasktrack;

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

import com.doublechaintech.lsc.transporttask.CandidateTransportTask;







public class TransportTaskTrackManagerImpl extends CustomLscCheckerManager implements TransportTaskTrackManager {
	
	private static final String SERVICE_TYPE = "TransportTaskTrack";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransportTaskTrackManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransportTaskTrackManagerException(message);

	}
	
	

 	protected TransportTaskTrack saveTransportTaskTrack(LscUserContext userContext, TransportTaskTrack transportTaskTrack, String [] tokensExpr) throws Exception{	
 		//return getTransportTaskTrackDAO().save(transportTaskTrack, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTaskTrack(userContext, transportTaskTrack, tokens);
 	}
 	
 	protected TransportTaskTrack saveTransportTaskTrackDetail(LscUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception{	

 		
 		return saveTransportTaskTrack(userContext, transportTaskTrack, allTokens());
 	}
 	
 	public TransportTaskTrack loadTransportTaskTrack(LscUserContext userContext, String transportTaskTrackId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskTrack, tokens);
 	}
 	
 	
 	 public TransportTaskTrack searchTransportTaskTrack(LscUserContext userContext, String transportTaskTrackId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskTrack, tokens);
 	}
 	
 	

 	protected TransportTaskTrack present(LscUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTaskTrack,tokens);
		
		
		TransportTaskTrack  transportTaskTrackToPresent = userContext.getDAOGroup().getTransportTaskTrackDAO().present(transportTaskTrack, tokens);
		
		List<BaseEntity> entityListToNaming = transportTaskTrackToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransportTaskTrackDAO().alias(entityListToNaming);
		
		return  transportTaskTrackToPresent;
		
		
	}
 
 	
 	
 	public TransportTaskTrack loadTransportTaskTrackDetail(LscUserContext userContext, String transportTaskTrackId) throws Exception{	
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, allTokens());
 		return present(userContext,transportTaskTrack, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String transportTaskTrackId) throws Exception{	
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, viewTokens());
 		return present(userContext,transportTaskTrack, allTokens());
		
 	}
 	protected TransportTaskTrack saveTransportTaskTrack(LscUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransportTaskTrackDAO().save(transportTaskTrack, tokens);
 	}
 	protected TransportTaskTrack loadTransportTaskTrack(LscUserContext userContext, String transportTaskTrackId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 
 		return userContext.getDAOGroup().getTransportTaskTrackDAO().load(transportTaskTrackId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){
		super.addActions(userContext, transportTaskTrack, tokens);
		
		addAction(userContext, transportTaskTrack, tokens,"@create","createTransportTaskTrack","createTransportTaskTrack/","main","primary");
		addAction(userContext, transportTaskTrack, tokens,"@update","updateTransportTaskTrack","updateTransportTaskTrack/"+transportTaskTrack.getId()+"/","main","primary");
		addAction(userContext, transportTaskTrack, tokens,"@copy","cloneTransportTaskTrack","cloneTransportTaskTrack/"+transportTaskTrack.getId()+"/","main","primary");
		
		addAction(userContext, transportTaskTrack, tokens,"transport_task_track.transfer_to_task","transferToAnotherTask","transferToAnotherTask/"+transportTaskTrack.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportTaskTrack createTransportTaskTrack(LscUserContext userContext,String name, BigDecimal latitude, BigDecimal longitude, String taskId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransportTaskTrack(name);
		userContext.getChecker().checkLatitudeOfTransportTaskTrack(latitude);
		userContext.getChecker().checkLongitudeOfTransportTaskTrack(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);


		TransportTaskTrack transportTaskTrack=createNewTransportTaskTrack();	

		transportTaskTrack.setName(name);
		transportTaskTrack.setLatitude(latitude);
		transportTaskTrack.setLongitude(longitude);
			
		TransportTask task = loadTransportTask(userContext, taskId,emptyOptions());
		transportTaskTrack.setTask(task);
		
		
		transportTaskTrack.setCreateTime(userContext.now());
		transportTaskTrack.setUpdateTime(userContext.now());

		transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());
		
		onNewInstanceCreated(userContext, transportTaskTrack);
		return transportTaskTrack;

		
	}
	protected TransportTaskTrack createNewTransportTaskTrack() 
	{
		
		return new TransportTaskTrack();		
	}
	
	protected void checkParamsForUpdatingTransportTaskTrack(LscUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().checkVersionOfTransportTaskTrack( transportTaskTrackVersion);
		

		if(TransportTaskTrack.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTaskTrack(parseString(newValueExpr));
		}
		if(TransportTaskTrack.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		}
		if(TransportTaskTrack.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);
	
		
	}
	
	
	
	public TransportTaskTrack clone(LscUserContext userContext, String fromTransportTaskTrackId) throws Exception{
		
		return userContext.getDAOGroup().getTransportTaskTrackDAO().clone(fromTransportTaskTrackId, this.allTokens());
	}
	
	public TransportTaskTrack internalSaveTransportTaskTrack(LscUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception 
	{
		return internalSaveTransportTaskTrack(userContext, transportTaskTrack, allTokens());

	}
	public TransportTaskTrack internalSaveTransportTaskTrack(LscUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transportTaskTrack){ 
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			
			
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, options);
			return transportTaskTrack;
			
		}

	}
	
	public TransportTaskTrack updateTransportTaskTrack(LscUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
		if(transportTaskTrack.getVersion() != transportTaskTrackVersion){
			String message = "The target version("+transportTaskTrack.getVersion()+") is not equals to version("+transportTaskTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTaskTrack){ 
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			transportTaskTrack.updateUpdateTime(userContext.now());
			transportTaskTrack.changeProperty(property, newValueExpr);
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
			return present(userContext,transportTaskTrack, mergedAllTokens(tokensExpr));
			//return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
		}

	}
	
	public TransportTaskTrack updateTransportTaskTrackProperty(LscUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);
		
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
		if(transportTaskTrack.getVersion() != transportTaskTrackVersion){
			String message = "The target version("+transportTaskTrack.getVersion()+") is not equals to version("+transportTaskTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTaskTrack){ 
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			
			transportTaskTrack.changeProperty(property, newValueExpr);
			transportTaskTrack.updateUpdateTime(userContext.now());
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
			return present(userContext,transportTaskTrack, mergedAllTokens(tokensExpr));
			//return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportTaskTrackTokens tokens(){
		return TransportTaskTrackTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTaskTrackTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTaskTrackTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherTask(LscUserContext userContext, String transportTaskTrackId, String anotherTaskId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
 		userContext.getChecker().checkIdOfTransportTask(anotherTaskId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);
 		
 	}
 	public TransportTaskTrack transferToAnotherTask(LscUserContext userContext, String transportTaskTrackId, String anotherTaskId) throws Exception
 	{
 		checkParamsForTransferingAnotherTask(userContext, transportTaskTrackId,anotherTaskId);
 
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());	
		synchronized(transportTaskTrack){
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTask task = loadTransportTask(userContext, anotherTaskId, emptyOptions());		
			transportTaskTrack.updateTask(task);		
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());
			
			return present(userContext,transportTaskTrack, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTransportTask requestCandidateTask(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportTask result = new CandidateTransportTask();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportTask> candidateList = userContext.getDAOGroup().getTransportTaskDAO().requestCandidateTransportTaskForTransportTaskTrack(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected TransportTask loadTransportTask(LscUserContext userContext, String newTaskId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTransportTaskDAO().load(newTaskId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion) throws Exception {
		//deleteInternal(userContext, transportTaskTrackId, transportTaskTrackVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String transportTaskTrackId, int transportTaskTrackVersion) throws Exception{
			
		userContext.getDAOGroup().getTransportTaskTrackDAO().delete(transportTaskTrackId, transportTaskTrackVersion);
	}
	
	public TransportTaskTrack forgetByAll(LscUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion) throws Exception {
		return forgetByAllInternal(userContext, transportTaskTrackId, transportTaskTrackVersion);		
	}
	protected TransportTaskTrack forgetByAllInternal(LscUserContext userContext,
			String transportTaskTrackId, int transportTaskTrackVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransportTaskTrackDAO().disconnectFromAll(transportTaskTrackId, transportTaskTrackVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTaskTrackManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransportTaskTrackDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(LscUserContext userContext, TransportTaskTrack newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


