
package com.doublechaintech.lsc.transportproject;

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
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.platform.Platform;

import com.doublechaintech.lsc.merchant.CandidateMerchant;
import com.doublechaintech.lsc.platform.CandidatePlatform;

import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;






public class TransportProjectManagerImpl extends CustomLscCheckerManager implements TransportProjectManager {
	
	private static final String SERVICE_TYPE = "TransportProject";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransportProjectManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransportProjectManagerException(message);

	}
	
	

 	protected TransportProject saveTransportProject(LscUserContext userContext, TransportProject transportProject, String [] tokensExpr) throws Exception{	
 		//return getTransportProjectDAO().save(transportProject, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportProject(userContext, transportProject, tokens);
 	}
 	
 	protected TransportProject saveTransportProjectDetail(LscUserContext userContext, TransportProject transportProject) throws Exception{	

 		
 		return saveTransportProject(userContext, transportProject, allTokens());
 	}
 	
 	public TransportProject loadTransportProject(LscUserContext userContext, String transportProjectId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportProjectManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportProject transportProject = loadTransportProject( userContext, transportProjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportProject, tokens);
 	}
 	
 	
 	 public TransportProject searchTransportProject(LscUserContext userContext, String transportProjectId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportProjectManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportProject transportProject = loadTransportProject( userContext, transportProjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportProject, tokens);
 	}
 	
 	

 	protected TransportProject present(LscUserContext userContext, TransportProject transportProject, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportProject,tokens);
		
		
		TransportProject  transportProjectToPresent = userContext.getDAOGroup().getTransportProjectDAO().present(transportProject, tokens);
		
		List<BaseEntity> entityListToNaming = transportProjectToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransportProjectDAO().alias(entityListToNaming);
		
		return  transportProjectToPresent;
		
		
	}
 
 	
 	
 	public TransportProject loadTransportProjectDetail(LscUserContext userContext, String transportProjectId) throws Exception{	
 		TransportProject transportProject = loadTransportProject( userContext, transportProjectId, allTokens());
 		return present(userContext,transportProject, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String transportProjectId) throws Exception{	
 		TransportProject transportProject = loadTransportProject( userContext, transportProjectId, viewTokens());
 		return present(userContext,transportProject, allTokens());
		
 	}
 	protected TransportProject saveTransportProject(LscUserContext userContext, TransportProject transportProject, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransportProjectDAO().save(transportProject, tokens);
 	}
 	protected TransportProject loadTransportProject(LscUserContext userContext, String transportProjectId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportProjectManagerException.class);

 
 		return userContext.getDAOGroup().getTransportProjectDAO().load(transportProjectId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportProject transportProject, Map<String, Object> tokens){
		super.addActions(userContext, transportProject, tokens);
		
		addAction(userContext, transportProject, tokens,"@create","createTransportProject","createTransportProject/","main","primary");
		addAction(userContext, transportProject, tokens,"@update","updateTransportProject","updateTransportProject/"+transportProject.getId()+"/","main","primary");
		addAction(userContext, transportProject, tokens,"@copy","cloneTransportProject","cloneTransportProject/"+transportProject.getId()+"/","main","primary");
		
		addAction(userContext, transportProject, tokens,"transport_project.transfer_to_merchant","transferToAnotherMerchant","transferToAnotherMerchant/"+transportProject.getId()+"/","main","primary");
		addAction(userContext, transportProject, tokens,"transport_project.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+transportProject.getId()+"/","main","primary");
		addAction(userContext, transportProject, tokens,"transport_project.addTransportItem","addTransportItem","addTransportItem/"+transportProject.getId()+"/","transportItemList","primary");
		addAction(userContext, transportProject, tokens,"transport_project.removeTransportItem","removeTransportItem","removeTransportItem/"+transportProject.getId()+"/","transportItemList","primary");
		addAction(userContext, transportProject, tokens,"transport_project.updateTransportItem","updateTransportItem","updateTransportItem/"+transportProject.getId()+"/","transportItemList","primary");
		addAction(userContext, transportProject, tokens,"transport_project.copyTransportItemFrom","copyTransportItemFrom","copyTransportItemFrom/"+transportProject.getId()+"/","transportItemList","primary");
		addAction(userContext, transportProject, tokens,"transport_project.addTransportTask","addTransportTask","addTransportTask/"+transportProject.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportProject, tokens,"transport_project.removeTransportTask","removeTransportTask","removeTransportTask/"+transportProject.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportProject, tokens,"transport_project.updateTransportTask","updateTransportTask","updateTransportTask/"+transportProject.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportProject, tokens,"transport_project.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+transportProject.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportProject transportProject, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportProject createTransportProject(LscUserContext userContext,String name, String merchantId, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransportProject(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);


		TransportProject transportProject=createNewTransportProject();	

		transportProject.setName(name);
			
		Merchant merchant = loadMerchant(userContext, merchantId,emptyOptions());
		transportProject.setMerchant(merchant);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		transportProject.setPlatform(platform);
		
		
		transportProject.setCreateTime(userContext.now());
		transportProject.setUpdateTime(userContext.now());

		transportProject = saveTransportProject(userContext, transportProject, emptyOptions());
		
		onNewInstanceCreated(userContext, transportProject);
		return transportProject;

		
	}
	protected TransportProject createNewTransportProject() 
	{
		
		return new TransportProject();		
	}
	
	protected void checkParamsForUpdatingTransportProject(LscUserContext userContext,String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkVersionOfTransportProject( transportProjectVersion);
		

		if(TransportProject.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportProject(parseString(newValueExpr));
		}		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
	
		
	}
	
	
	
	public TransportProject clone(LscUserContext userContext, String fromTransportProjectId) throws Exception{
		
		return userContext.getDAOGroup().getTransportProjectDAO().clone(fromTransportProjectId, this.allTokens());
	}
	
	public TransportProject internalSaveTransportProject(LscUserContext userContext, TransportProject transportProject) throws Exception 
	{
		return internalSaveTransportProject(userContext, transportProject, allTokens());

	}
	public TransportProject internalSaveTransportProject(LscUserContext userContext, TransportProject transportProject, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransportProject(userContext, transportProjectId, transportProjectVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transportProject){ 
			//will be good when the transportProject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportProject.
			
			
			transportProject = saveTransportProject(userContext, transportProject, options);
			return transportProject;
			
		}

	}
	
	public TransportProject updateTransportProject(LscUserContext userContext,String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportProject(userContext, transportProjectId, transportProjectVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
		if(transportProject.getVersion() != transportProjectVersion){
			String message = "The target version("+transportProject.getVersion()+") is not equals to version("+transportProjectVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportProject){ 
			//will be good when the transportProject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportProject.
			transportProject.updateUpdateTime(userContext.now());
			transportProject.changeProperty(property, newValueExpr);
			transportProject = saveTransportProject(userContext, transportProject, tokens().done());
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
			//return saveTransportProject(userContext, transportProject, tokens().done());
		}

	}
	
	public TransportProject updateTransportProjectProperty(LscUserContext userContext,String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportProject(userContext, transportProjectId, transportProjectVersion, property, newValueExpr, tokensExpr);
		
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
		if(transportProject.getVersion() != transportProjectVersion){
			String message = "The target version("+transportProject.getVersion()+") is not equals to version("+transportProjectVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportProject){ 
			//will be good when the transportProject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportProject.
			
			transportProject.changeProperty(property, newValueExpr);
			transportProject.updateUpdateTime(userContext.now());
			transportProject = saveTransportProject(userContext, transportProject, tokens().done());
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
			//return saveTransportProject(userContext, transportProject, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportProjectTokens tokens(){
		return TransportProjectTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportProjectTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportItemListWith("id","desc")
		.sortTransportTaskListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportProjectTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherMerchant(LscUserContext userContext, String transportProjectId, String anotherMerchantId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
 		userContext.getChecker().checkIdOfMerchant(anotherMerchantId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
 		
 	}
 	public TransportProject transferToAnotherMerchant(LscUserContext userContext, String transportProjectId, String anotherMerchantId) throws Exception
 	{
 		checkParamsForTransferingAnotherMerchant(userContext, transportProjectId,anotherMerchantId);
 
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());	
		synchronized(transportProject){
			//will be good when the transportProject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Merchant merchant = loadMerchant(userContext, anotherMerchantId, emptyOptions());		
			transportProject.updateMerchant(merchant);		
			transportProject = saveTransportProject(userContext, transportProject, emptyOptions());
			
			return present(userContext,transportProject, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateMerchant requestCandidateMerchant(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<Merchant> candidateList = userContext.getDAOGroup().getMerchantDAO().requestCandidateMerchantForTransportProject(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(LscUserContext userContext, String transportProjectId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
 		
 	}
 	public TransportProject transferToAnotherPlatform(LscUserContext userContext, String transportProjectId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, transportProjectId,anotherPlatformId);
 
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());	
		synchronized(transportProject){
			//will be good when the transportProject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			transportProject.updatePlatform(platform);		
			transportProject = saveTransportProject(userContext, transportProject, emptyOptions());
			
			return present(userContext,transportProject, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForTransportProject(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Merchant loadMerchant(LscUserContext userContext, String newMerchantId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getMerchantDAO().load(newMerchantId, options);
 	}
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(LscUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String transportProjectId, int transportProjectVersion) throws Exception {
		//deleteInternal(userContext, transportProjectId, transportProjectVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String transportProjectId, int transportProjectVersion) throws Exception{
			
		userContext.getDAOGroup().getTransportProjectDAO().delete(transportProjectId, transportProjectVersion);
	}
	
	public TransportProject forgetByAll(LscUserContext userContext, String transportProjectId, int transportProjectVersion) throws Exception {
		return forgetByAllInternal(userContext, transportProjectId, transportProjectVersion);		
	}
	protected TransportProject forgetByAllInternal(LscUserContext userContext,
			String transportProjectId, int transportProjectVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransportProjectDAO().disconnectFromAll(transportProjectId, transportProjectVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportProjectManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransportProjectDAO().deleteAll();
	}


	//disconnect TransportProject with merchant in TransportItem
	protected TransportProject breakWithTransportItemByMerchant(LscUserContext userContext, String transportProjectId, String merchantId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());

			synchronized(transportProject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportItemListWithMerchant(transportProject, merchantId, this.emptyOptions());

				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportItemList().done());
				return transportProject;
			}
	}
	//disconnect TransportProject with platform in TransportItem
	protected TransportProject breakWithTransportItemByPlatform(LscUserContext userContext, String transportProjectId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());

			synchronized(transportProject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportItemListWithPlatform(transportProject, platformId, this.emptyOptions());

				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportItemList().done());
				return transportProject;
			}
	}
	//disconnect TransportProject with source in TransportTask
	protected TransportProject breakWithTransportTaskBySource(LscUserContext userContext, String transportProjectId, String sourceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());

			synchronized(transportProject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportTaskListWithSource(transportProject, sourceId, this.emptyOptions());

				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
				return transportProject;
			}
	}
	//disconnect TransportProject with destination in TransportTask
	protected TransportProject breakWithTransportTaskByDestination(LscUserContext userContext, String transportProjectId, String destinationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());

			synchronized(transportProject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportTaskListWithDestination(transportProject, destinationId, this.emptyOptions());

				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
				return transportProject;
			}
	}
	//disconnect TransportProject with status in TransportTask
	protected TransportProject breakWithTransportTaskByStatus(LscUserContext userContext, String transportProjectId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());

			synchronized(transportProject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportTaskListWithStatus(transportProject, statusId, this.emptyOptions());

				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
				return transportProject;
			}
	}
	//disconnect TransportProject with sender in TransportTask
	protected TransportProject breakWithTransportTaskBySender(LscUserContext userContext, String transportProjectId, String senderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());

			synchronized(transportProject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportTaskListWithSender(transportProject, senderId, this.emptyOptions());

				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
				return transportProject;
			}
	}
	//disconnect TransportProject with receiver in TransportTask
	protected TransportProject breakWithTransportTaskByReceiver(LscUserContext userContext, String transportProjectId, String receiverId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());

			synchronized(transportProject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportTaskListWithReceiver(transportProject, receiverId, this.emptyOptions());

				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
				return transportProject;
			}
	}
	//disconnect TransportProject with platform in TransportTask
	protected TransportProject breakWithTransportTaskByPlatform(LscUserContext userContext, String transportProjectId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());

			synchronized(transportProject){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportTaskListWithPlatform(transportProject, platformId, this.emptyOptions());

				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
				return transportProject;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransportItem(LscUserContext userContext, String transportProjectId, String name, int quantity, String unit, String merchantId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);

		
		userContext.getChecker().checkNameOfTransportItem(name);
		
		userContext.getChecker().checkQuantityOfTransportItem(quantity);
		
		userContext.getChecker().checkUnitOfTransportItem(unit);
		
		userContext.getChecker().checkMerchantIdOfTransportItem(merchantId);
		
		userContext.getChecker().checkPlatformIdOfTransportItem(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);

	
	}
	public  TransportProject addTransportItem(LscUserContext userContext, String transportProjectId, String name, int quantity, String unit, String merchantId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportItem(userContext,transportProjectId,name, quantity, unit, merchantId, platformId,tokensExpr);
		
		TransportItem transportItem = createTransportItem(userContext,name, quantity, unit, merchantId, platformId);
		
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
		synchronized(transportProject){ 
			//Will be good when the transportProject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportProject.addTransportItem( transportItem );		
			transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportItemList().done());
			
			userContext.getManagerGroup().getTransportItemManager().onNewInstanceCreated(userContext, transportItem);
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportItemProperties(LscUserContext userContext, String transportProjectId,String id,String name,int quantity,String unit,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkIdOfTransportItem(id);
		
		userContext.getChecker().checkNameOfTransportItem( name);
		userContext.getChecker().checkQuantityOfTransportItem( quantity);
		userContext.getChecker().checkUnitOfTransportItem( unit);

		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
		
	}
	public  TransportProject updateTransportItemProperties(LscUserContext userContext, String transportProjectId, String id,String name,int quantity,String unit, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportItemProperties(userContext,transportProjectId,id,name,quantity,unit,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportItemListList()
				.searchTransportItemListWith(TransportItem.ID_PROPERTY, "is", id).done();
		
		TransportProject transportProjectToUpdate = loadTransportProject(userContext, transportProjectId, options);
		
		if(transportProjectToUpdate.getTransportItemList().isEmpty()){
			throw new TransportProjectManagerException("TransportItem is NOT FOUND with id: '"+id+"'");
		}
		
		TransportItem item = transportProjectToUpdate.getTransportItemList().first();
		
		item.updateName( name );
		item.updateQuantity( quantity );
		item.updateUnit( unit );

		
		//checkParamsForAddingTransportItem(userContext,transportProjectId,name, code, used,tokensExpr);
		TransportProject transportProject = saveTransportProject(userContext, transportProjectToUpdate, tokens().withTransportItemList().done());
		synchronized(transportProject){ 
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportItem createTransportItem(LscUserContext userContext, String name, int quantity, String unit, String merchantId, String platformId) throws Exception{

		TransportItem transportItem = new TransportItem();
		
		
		transportItem.setName(name);		
		transportItem.setQuantity(quantity);		
		transportItem.setUnit(unit);		
		MerchantType  merchant = new MerchantType();
		merchant.setId(merchantId);		
		transportItem.setMerchant(merchant);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		transportItem.setPlatform(platform);		
		transportItem.setCreateTime(userContext.now());		
		transportItem.setUpdateTime(userContext.now());
	
		
		return transportItem;
	
		
	}
	
	protected TransportItem createIndexedTransportItem(String id, int version){

		TransportItem transportItem = new TransportItem();
		transportItem.setId(id);
		transportItem.setVersion(version);
		return transportItem;			
		
	}
	
	protected void checkParamsForRemovingTransportItemList(LscUserContext userContext, String transportProjectId, 
			String transportItemIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		for(String transportItemId: transportItemIds){
			userContext.getChecker().checkIdOfTransportItem(transportItemId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
		
	}
	public  TransportProject removeTransportItemList(LscUserContext userContext, String transportProjectId, 
			String transportItemIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportItemList(userContext, transportProjectId,  transportItemIds, tokensExpr);
			
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
			synchronized(transportProject){ 
				//Will be good when the transportProject loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportItemList(transportProject, transportItemIds, allTokens());
				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportItemList().done());
				deleteRelationListInGraph(userContext, transportProject.getTransportItemList());
				return present(userContext,transportProject, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportItem(LscUserContext userContext, String transportProjectId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportProject( transportProjectId);
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem(transportItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
	
	}
	public  TransportProject removeTransportItem(LscUserContext userContext, String transportProjectId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportItem(userContext,transportProjectId, transportItemId, transportItemVersion,tokensExpr);
		
		TransportItem transportItem = createIndexedTransportItem(transportItemId, transportItemVersion);
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
		synchronized(transportProject){ 
			//Will be good when the transportProject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportProject.removeTransportItem( transportItem );		
			transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportItemList().done());
			deleteRelationInGraph(userContext, transportItem);
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportItem(LscUserContext userContext, String transportProjectId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportProject( transportProjectId);
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem(transportItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
	
	}
	public  TransportProject copyTransportItemFrom(LscUserContext userContext, String transportProjectId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportItem(userContext,transportProjectId, transportItemId, transportItemVersion,tokensExpr);
		
		TransportItem transportItem = createIndexedTransportItem(transportItemId, transportItemVersion);
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
		synchronized(transportProject){ 
			//Will be good when the transportProject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportItem.updateUpdateTime(userContext.now());
			
			transportProject.copyTransportItemFrom( transportItem );		
			transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportItemList().done());
			
			userContext.getManagerGroup().getTransportItemManager().onNewInstanceCreated(userContext, (TransportItem)transportProject.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportItem(LscUserContext userContext, String transportProjectId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem(transportItemVersion);
		

		if(TransportItem.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportItem(parseString(newValueExpr));
		}
		
		if(TransportItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfTransportItem(parseInt(newValueExpr));
		}
		
		if(TransportItem.UNIT_PROPERTY.equals(property)){
			userContext.getChecker().checkUnitOfTransportItem(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
	
	}
	
	public  TransportProject updateTransportItem(LscUserContext userContext, String transportProjectId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportItem(userContext, transportProjectId, transportItemId, transportItemVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportItemList().searchTransportItemListWith(TransportItem.ID_PROPERTY, "eq", transportItemId).done();
		
		
		
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, loadTokens);
		
		synchronized(transportProject){ 
			//Will be good when the transportProject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportProject.removeTransportItem( transportItem );	
			//make changes to AcceleraterAccount.
			TransportItem transportItemIndex = createIndexedTransportItem(transportItemId, transportItemVersion);
		
			TransportItem transportItem = transportProject.findTheTransportItem(transportItemIndex);
			if(transportItem == null){
				throw new TransportProjectManagerException(transportItem+" is NOT FOUND" );
			}
			
			transportItem.changeProperty(property, newValueExpr);
			transportItem.updateUpdateTime(userContext.now());
			transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportItemList().done());
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportTask(LscUserContext userContext, String transportProjectId, String name, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkSourceIdOfTransportTask(sourceId);
		
		userContext.getChecker().checkDestinationIdOfTransportTask(destinationId);
		
		userContext.getChecker().checkRemarkOfTransportTask(remark);
		
		userContext.getChecker().checkStatusIdOfTransportTask(statusId);
		
		userContext.getChecker().checkSenderIdOfTransportTask(senderId);
		
		userContext.getChecker().checkReceiverIdOfTransportTask(receiverId);
		
		userContext.getChecker().checkPlatformIdOfTransportTask(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);

	
	}
	public  TransportProject addTransportTask(LscUserContext userContext, String transportProjectId, String name, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,transportProjectId,name, sourceId, destinationId, remark, statusId, senderId, receiverId, platformId,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, sourceId, destinationId, remark, statusId, senderId, receiverId, platformId);
		
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
		synchronized(transportProject){ 
			//Will be good when the transportProject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportProject.addTransportTask( transportTask );		
			transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(LscUserContext userContext, String transportProjectId,String id,String name,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkRemarkOfTransportTask( remark);

		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
		
	}
	public  TransportProject updateTransportTaskProperties(LscUserContext userContext, String transportProjectId, String id,String name,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskProperties(userContext,transportProjectId,id,name,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		TransportProject transportProjectToUpdate = loadTransportProject(userContext, transportProjectId, options);
		
		if(transportProjectToUpdate.getTransportTaskList().isEmpty()){
			throw new TransportProjectManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = transportProjectToUpdate.getTransportTaskList().first();
		
		item.updateName( name );
		item.updateRemark( remark );

		
		//checkParamsForAddingTransportTask(userContext,transportProjectId,name, code, used,tokensExpr);
		TransportProject transportProject = saveTransportProject(userContext, transportProjectToUpdate, tokens().withTransportTaskList().done());
		synchronized(transportProject){ 
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTask(LscUserContext userContext, String name, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId, String platformId) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		Location  source = new Location();
		source.setId(sourceId);		
		transportTask.setSource(source);		
		Location  destination = new Location();
		destination.setId(destinationId);		
		transportTask.setDestination(destination);		
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
	
	protected TransportTask createIndexedTransportTask(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskList(LscUserContext userContext, String transportProjectId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
		
	}
	public  TransportProject removeTransportTaskList(LscUserContext userContext, String transportProjectId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskList(userContext, transportProjectId,  transportTaskIds, tokensExpr);
			
			
			TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
			synchronized(transportProject){ 
				//Will be good when the transportProject loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransportProjectDAO().planToRemoveTransportTaskList(transportProject, transportTaskIds, allTokens());
				transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, transportProject.getTransportTaskList());
				return present(userContext,transportProject, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTask(LscUserContext userContext, String transportProjectId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportProject( transportProjectId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
	
	}
	public  TransportProject removeTransportTask(LscUserContext userContext, String transportProjectId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,transportProjectId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
		synchronized(transportProject){ 
			//Will be good when the transportProject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportProject.removeTransportTask( transportTask );		
			transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTask(LscUserContext userContext, String transportProjectId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportProject( transportProjectId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
	
	}
	public  TransportProject copyTransportTaskFrom(LscUserContext userContext, String transportProjectId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,transportProjectId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, allTokens());
		synchronized(transportProject){ 
			//Will be good when the transportProject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportTask.updateUpdateTime(userContext.now());
			
			transportProject.copyTransportTaskFrom( transportTask );		
			transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)transportProject.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTask(LscUserContext userContext, String transportProjectId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTransportTask(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportProjectManagerException.class);
	
	}
	
	public  TransportProject updateTransportTask(LscUserContext userContext, String transportProjectId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, transportProjectId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		TransportProject transportProject = loadTransportProject(userContext, transportProjectId, loadTokens);
		
		synchronized(transportProject){ 
			//Will be good when the transportProject loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportProject.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = transportProject.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TransportProjectManagerException(transportTask+" is NOT FOUND" );
			}
			
			transportTask.changeProperty(property, newValueExpr);
			transportTask.updateUpdateTime(userContext.now());
			transportProject = saveTransportProject(userContext, transportProject, tokens().withTransportTaskList().done());
			return present(userContext,transportProject, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, TransportProject newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


