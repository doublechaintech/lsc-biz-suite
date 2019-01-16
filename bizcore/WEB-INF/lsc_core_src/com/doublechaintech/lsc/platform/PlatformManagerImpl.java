
package com.doublechaintech.lsc.platform;

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
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.transactiontype.TransactionType;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.merchanttype.MerchantType;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;


import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;






public class PlatformManagerImpl extends CustomLscCheckerManager implements PlatformManager {
	
	private static final String SERVICE_TYPE = "Platform";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}
	
	

 	protected Platform savePlatform(LscUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(LscUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(LscUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(LscUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(LscUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = userContext.getDAOGroup().getPlatformDAO().present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPlatformDAO().alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(LscUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(LscUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPlatformDAO().save(platform, tokens);
 	}
 	protected Platform loadPlatform(LscUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return userContext.getDAOGroup().getPlatformDAO().load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addTransactionType","addTransactionType","addTransactionType/"+platform.getId()+"/","transactionTypeList","primary");
		addAction(userContext, platform, tokens,"platform.removeTransactionType","removeTransactionType","removeTransactionType/"+platform.getId()+"/","transactionTypeList","primary");
		addAction(userContext, platform, tokens,"platform.updateTransactionType","updateTransactionType","updateTransactionType/"+platform.getId()+"/","transactionTypeList","primary");
		addAction(userContext, platform, tokens,"platform.copyTransactionTypeFrom","copyTransactionTypeFrom","copyTransactionTypeFrom/"+platform.getId()+"/","transactionTypeList","primary");
		addAction(userContext, platform, tokens,"platform.addMerchantType","addMerchantType","addMerchantType/"+platform.getId()+"/","merchantTypeList","primary");
		addAction(userContext, platform, tokens,"platform.removeMerchantType","removeMerchantType","removeMerchantType/"+platform.getId()+"/","merchantTypeList","primary");
		addAction(userContext, platform, tokens,"platform.updateMerchantType","updateMerchantType","updateMerchantType/"+platform.getId()+"/","merchantTypeList","primary");
		addAction(userContext, platform, tokens,"platform.copyMerchantTypeFrom","copyMerchantTypeFrom","copyMerchantTypeFrom/"+platform.getId()+"/","merchantTypeList","primary");
		addAction(userContext, platform, tokens,"platform.addTransportTaskStatus","addTransportTaskStatus","addTransportTaskStatus/"+platform.getId()+"/","transportTaskStatusList","primary");
		addAction(userContext, platform, tokens,"platform.removeTransportTaskStatus","removeTransportTaskStatus","removeTransportTaskStatus/"+platform.getId()+"/","transportTaskStatusList","primary");
		addAction(userContext, platform, tokens,"platform.updateTransportTaskStatus","updateTransportTaskStatus","updateTransportTaskStatus/"+platform.getId()+"/","transportTaskStatusList","primary");
		addAction(userContext, platform, tokens,"platform.copyTransportTaskStatusFrom","copyTransportTaskStatusFrom","copyTransportTaskStatusFrom/"+platform.getId()+"/","transportTaskStatusList","primary");
		addAction(userContext, platform, tokens,"platform.addLocation","addLocation","addLocation/"+platform.getId()+"/","locationList","primary");
		addAction(userContext, platform, tokens,"platform.removeLocation","removeLocation","removeLocation/"+platform.getId()+"/","locationList","primary");
		addAction(userContext, platform, tokens,"platform.updateLocation","updateLocation","updateLocation/"+platform.getId()+"/","locationList","primary");
		addAction(userContext, platform, tokens,"platform.copyLocationFrom","copyLocationFrom","copyLocationFrom/"+platform.getId()+"/","locationList","primary");
		addAction(userContext, platform, tokens,"platform.addMerchant","addMerchant","addMerchant/"+platform.getId()+"/","merchantList","primary");
		addAction(userContext, platform, tokens,"platform.removeMerchant","removeMerchant","removeMerchant/"+platform.getId()+"/","merchantList","primary");
		addAction(userContext, platform, tokens,"platform.updateMerchant","updateMerchant","updateMerchant/"+platform.getId()+"/","merchantList","primary");
		addAction(userContext, platform, tokens,"platform.copyMerchantFrom","copyMerchantFrom","copyMerchantFrom/"+platform.getId()+"/","merchantList","primary");
		addAction(userContext, platform, tokens,"platform.addTransportProject","addTransportProject","addTransportProject/"+platform.getId()+"/","transportProjectList","primary");
		addAction(userContext, platform, tokens,"platform.removeTransportProject","removeTransportProject","removeTransportProject/"+platform.getId()+"/","transportProjectList","primary");
		addAction(userContext, platform, tokens,"platform.updateTransportProject","updateTransportProject","updateTransportProject/"+platform.getId()+"/","transportProjectList","primary");
		addAction(userContext, platform, tokens,"platform.copyTransportProjectFrom","copyTransportProjectFrom","copyTransportProjectFrom/"+platform.getId()+"/","transportProjectList","primary");
		addAction(userContext, platform, tokens,"platform.addTransportItem","addTransportItem","addTransportItem/"+platform.getId()+"/","transportItemList","primary");
		addAction(userContext, platform, tokens,"platform.removeTransportItem","removeTransportItem","removeTransportItem/"+platform.getId()+"/","transportItemList","primary");
		addAction(userContext, platform, tokens,"platform.updateTransportItem","updateTransportItem","updateTransportItem/"+platform.getId()+"/","transportItemList","primary");
		addAction(userContext, platform, tokens,"platform.copyTransportItemFrom","copyTransportItemFrom","copyTransportItemFrom/"+platform.getId()+"/","transportItemList","primary");
		addAction(userContext, platform, tokens,"platform.addTransportTask","addTransportTask","addTransportTask/"+platform.getId()+"/","transportTaskList","primary");
		addAction(userContext, platform, tokens,"platform.removeTransportTask","removeTransportTask","removeTransportTask/"+platform.getId()+"/","transportTaskList","primary");
		addAction(userContext, platform, tokens,"platform.updateTransportTask","updateTransportTask","updateTransportTask/"+platform.getId()+"/","transportTaskList","primary");
		addAction(userContext, platform, tokens,"platform.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+platform.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Platform createPlatform(LscUserContext userContext,String name, String introduction, String currentVersion) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPlatform(name);
		userContext.getChecker().checkIntroductionOfPlatform(introduction);
		userContext.getChecker().checkCurrentVersionOfPlatform(currentVersion);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);
		platform.setIntroduction(introduction);
		platform.setCurrentVersion(currentVersion);

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;

		
	}
	protected Platform createNewPlatform() 
	{
		
		return new Platform();		
	}
	
	protected void checkParamsForUpdatingPlatform(LscUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPlatform(parseString(newValueExpr));
		}
		if(Platform.INTRODUCTION_PROPERTY.equals(property)){
			userContext.getChecker().checkIntroductionOfPlatform(parseString(newValueExpr));
		}
		if(Platform.CURRENT_VERSION_PROPERTY.equals(property)){
			userContext.getChecker().checkCurrentVersionOfPlatform(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
		
	}
	
	
	
	public Platform clone(LscUserContext userContext, String fromPlatformId) throws Exception{
		
		return userContext.getDAOGroup().getPlatformDAO().clone(fromPlatformId, this.allTokens());
	}
	
	public Platform internalSavePlatform(LscUserContext userContext, Platform platform) throws Exception 
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(LscUserContext userContext, Platform platform, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			
			platform = savePlatform(userContext, platform, options);
			return platform;
			
		}

	}
	
	public Platform updatePlatform(LscUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	
	public Platform updatePlatformProperty(LscUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransactionTypeListWith("id","desc")
		.sortMerchantTypeListWith("id","desc")
		.sortTransportTaskStatusListWith("id","desc")
		.sortLocationListWith("id","desc")
		.sortMerchantListWith("id","desc")
		.sortTransportProjectListWith("id","desc")
		.sortTransportItemListWith("id","desc")
		.sortTransportTaskListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		userContext.getDAOGroup().getPlatformDAO().delete(platformId, platformVersion);
	}
	
	public Platform forgetByAll(LscUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);		
	}
	protected Platform forgetByAllInternal(LscUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		return userContext.getDAOGroup().getPlatformDAO().disconnectFromAll(platformId, platformVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPlatformDAO().deleteAll();
	}


	//disconnect Platform with type in Merchant
	protected Platform breakWithMerchantByType(LscUserContext userContext, String platformId, String typeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveMerchantListWithType(platform, typeId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withMerchantList().done());
				return platform;
			}
	}
	//disconnect Platform with merchant in TransportProject
	protected Platform breakWithTransportProjectByMerchant(LscUserContext userContext, String platformId, String merchantId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportProjectListWithMerchant(platform, merchantId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportProjectList().done());
				return platform;
			}
	}
	//disconnect Platform with project in TransportItem
	protected Platform breakWithTransportItemByProject(LscUserContext userContext, String platformId, String projectId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportItemListWithProject(platform, projectId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportItemList().done());
				return platform;
			}
	}
	//disconnect Platform with merchant in TransportItem
	protected Platform breakWithTransportItemByMerchant(LscUserContext userContext, String platformId, String merchantId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportItemListWithMerchant(platform, merchantId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportItemList().done());
				return platform;
			}
	}
	//disconnect Platform with project in TransportTask
	protected Platform breakWithTransportTaskByProject(LscUserContext userContext, String platformId, String projectId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportTaskListWithProject(platform, projectId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
				return platform;
			}
	}
	//disconnect Platform with source in TransportTask
	protected Platform breakWithTransportTaskBySource(LscUserContext userContext, String platformId, String sourceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportTaskListWithSource(platform, sourceId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
				return platform;
			}
	}
	//disconnect Platform with destination in TransportTask
	protected Platform breakWithTransportTaskByDestination(LscUserContext userContext, String platformId, String destinationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportTaskListWithDestination(platform, destinationId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
				return platform;
			}
	}
	//disconnect Platform with status in TransportTask
	protected Platform breakWithTransportTaskByStatus(LscUserContext userContext, String platformId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportTaskListWithStatus(platform, statusId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
				return platform;
			}
	}
	//disconnect Platform with sender in TransportTask
	protected Platform breakWithTransportTaskBySender(LscUserContext userContext, String platformId, String senderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportTaskListWithSender(platform, senderId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
				return platform;
			}
	}
	//disconnect Platform with receiver in TransportTask
	protected Platform breakWithTransportTaskByReceiver(LscUserContext userContext, String platformId, String receiverId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportTaskListWithReceiver(platform, receiverId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
				return platform;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransactionType(LscUserContext userContext, String platformId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfTransactionType(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addTransactionType(LscUserContext userContext, String platformId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransactionType(userContext,platformId,name,tokensExpr);
		
		TransactionType transactionType = createTransactionType(userContext,name);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addTransactionType( transactionType );		
			platform = savePlatform(userContext, platform, tokens().withTransactionTypeList().done());
			
			userContext.getManagerGroup().getTransactionTypeManager().onNewInstanceCreated(userContext, transactionType);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransactionTypeProperties(LscUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransactionType(id);
		
		userContext.getChecker().checkNameOfTransactionType( name);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateTransactionTypeProperties(LscUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransactionTypeProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransactionTypeListList()
				.searchTransactionTypeListWith(TransactionType.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getTransactionTypeList().isEmpty()){
			throw new PlatformManagerException("TransactionType is NOT FOUND with id: '"+id+"'");
		}
		
		TransactionType item = platformToUpdate.getTransactionTypeList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingTransactionType(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withTransactionTypeList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransactionType createTransactionType(LscUserContext userContext, String name) throws Exception{

		TransactionType transactionType = new TransactionType();
		
		
		transactionType.setName(name);
	
		
		return transactionType;
	
		
	}
	
	protected TransactionType createIndexedTransactionType(String id, int version){

		TransactionType transactionType = new TransactionType();
		transactionType.setId(id);
		transactionType.setVersion(version);
		return transactionType;			
		
	}
	
	protected void checkParamsForRemovingTransactionTypeList(LscUserContext userContext, String platformId, 
			String transactionTypeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String transactionTypeId: transactionTypeIds){
			userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeTransactionTypeList(LscUserContext userContext, String platformId, 
			String transactionTypeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransactionTypeList(userContext, platformId,  transactionTypeIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransactionTypeList(platform, transactionTypeIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withTransactionTypeList().done());
				deleteRelationListInGraph(userContext, platform.getTransactionTypeList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransactionType(LscUserContext userContext, String platformId, 
		String transactionTypeId, int transactionTypeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().checkVersionOfTransactionType(transactionTypeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeTransactionType(LscUserContext userContext, String platformId, 
		String transactionTypeId, int transactionTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransactionType(userContext,platformId, transactionTypeId, transactionTypeVersion,tokensExpr);
		
		TransactionType transactionType = createIndexedTransactionType(transactionTypeId, transactionTypeVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeTransactionType( transactionType );		
			platform = savePlatform(userContext, platform, tokens().withTransactionTypeList().done());
			deleteRelationInGraph(userContext, transactionType);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransactionType(LscUserContext userContext, String platformId, 
		String transactionTypeId, int transactionTypeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().checkVersionOfTransactionType(transactionTypeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyTransactionTypeFrom(LscUserContext userContext, String platformId, 
		String transactionTypeId, int transactionTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransactionType(userContext,platformId, transactionTypeId, transactionTypeVersion,tokensExpr);
		
		TransactionType transactionType = createIndexedTransactionType(transactionTypeId, transactionTypeVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyTransactionTypeFrom( transactionType );		
			platform = savePlatform(userContext, platform, tokens().withTransactionTypeList().done());
			
			userContext.getManagerGroup().getTransactionTypeManager().onNewInstanceCreated(userContext, (TransactionType)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransactionType(LscUserContext userContext, String platformId, String transactionTypeId, int transactionTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().checkVersionOfTransactionType(transactionTypeVersion);
		

		if(TransactionType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransactionType(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateTransactionType(LscUserContext userContext, String platformId, String transactionTypeId, int transactionTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransactionType(userContext, platformId, transactionTypeId, transactionTypeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransactionTypeList().searchTransactionTypeListWith(TransactionType.ID_PROPERTY, "eq", transactionTypeId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeTransactionType( transactionType );	
			//make changes to AcceleraterAccount.
			TransactionType transactionTypeIndex = createIndexedTransactionType(transactionTypeId, transactionTypeVersion);
		
			TransactionType transactionType = platform.findTheTransactionType(transactionTypeIndex);
			if(transactionType == null){
				throw new PlatformManagerException(transactionType+" is NOT FOUND" );
			}
			
			transactionType.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withTransactionTypeList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingMerchantType(LscUserContext userContext, String platformId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfMerchantType(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addMerchantType(LscUserContext userContext, String platformId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMerchantType(userContext,platformId,name,tokensExpr);
		
		MerchantType merchantType = createMerchantType(userContext,name);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addMerchantType( merchantType );		
			platform = savePlatform(userContext, platform, tokens().withMerchantTypeList().done());
			
			userContext.getManagerGroup().getMerchantTypeManager().onNewInstanceCreated(userContext, merchantType);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMerchantTypeProperties(LscUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfMerchantType(id);
		
		userContext.getChecker().checkNameOfMerchantType( name);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateMerchantTypeProperties(LscUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingMerchantTypeProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMerchantTypeListList()
				.searchMerchantTypeListWith(MerchantType.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getMerchantTypeList().isEmpty()){
			throw new PlatformManagerException("MerchantType is NOT FOUND with id: '"+id+"'");
		}
		
		MerchantType item = platformToUpdate.getMerchantTypeList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingMerchantType(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withMerchantTypeList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected MerchantType createMerchantType(LscUserContext userContext, String name) throws Exception{

		MerchantType merchantType = new MerchantType();
		
		
		merchantType.setName(name);
	
		
		return merchantType;
	
		
	}
	
	protected MerchantType createIndexedMerchantType(String id, int version){

		MerchantType merchantType = new MerchantType();
		merchantType.setId(id);
		merchantType.setVersion(version);
		return merchantType;			
		
	}
	
	protected void checkParamsForRemovingMerchantTypeList(LscUserContext userContext, String platformId, 
			String merchantTypeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String merchantTypeId: merchantTypeIds){
			userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeMerchantTypeList(LscUserContext userContext, String platformId, 
			String merchantTypeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingMerchantTypeList(userContext, platformId,  merchantTypeIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveMerchantTypeList(platform, merchantTypeIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withMerchantTypeList().done());
				deleteRelationListInGraph(userContext, platform.getMerchantTypeList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingMerchantType(LscUserContext userContext, String platformId, 
		String merchantTypeId, int merchantTypeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().checkVersionOfMerchantType(merchantTypeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeMerchantType(LscUserContext userContext, String platformId, 
		String merchantTypeId, int merchantTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMerchantType(userContext,platformId, merchantTypeId, merchantTypeVersion,tokensExpr);
		
		MerchantType merchantType = createIndexedMerchantType(merchantTypeId, merchantTypeVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeMerchantType( merchantType );		
			platform = savePlatform(userContext, platform, tokens().withMerchantTypeList().done());
			deleteRelationInGraph(userContext, merchantType);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingMerchantType(LscUserContext userContext, String platformId, 
		String merchantTypeId, int merchantTypeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().checkVersionOfMerchantType(merchantTypeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyMerchantTypeFrom(LscUserContext userContext, String platformId, 
		String merchantTypeId, int merchantTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMerchantType(userContext,platformId, merchantTypeId, merchantTypeVersion,tokensExpr);
		
		MerchantType merchantType = createIndexedMerchantType(merchantTypeId, merchantTypeVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyMerchantTypeFrom( merchantType );		
			platform = savePlatform(userContext, platform, tokens().withMerchantTypeList().done());
			
			userContext.getManagerGroup().getMerchantTypeManager().onNewInstanceCreated(userContext, (MerchantType)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingMerchantType(LscUserContext userContext, String platformId, String merchantTypeId, int merchantTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().checkVersionOfMerchantType(merchantTypeVersion);
		

		if(MerchantType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMerchantType(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateMerchantType(LscUserContext userContext, String platformId, String merchantTypeId, int merchantTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMerchantType(userContext, platformId, merchantTypeId, merchantTypeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withMerchantTypeList().searchMerchantTypeListWith(MerchantType.ID_PROPERTY, "eq", merchantTypeId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeMerchantType( merchantType );	
			//make changes to AcceleraterAccount.
			MerchantType merchantTypeIndex = createIndexedMerchantType(merchantTypeId, merchantTypeVersion);
		
			MerchantType merchantType = platform.findTheMerchantType(merchantTypeIndex);
			if(merchantType == null){
				throw new PlatformManagerException(merchantType+" is NOT FOUND" );
			}
			
			merchantType.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withMerchantTypeList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportTaskStatus(LscUserContext userContext, String platformId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfTransportTaskStatus(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addTransportTaskStatus(LscUserContext userContext, String platformId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTaskStatus(userContext,platformId,name,tokensExpr);
		
		TransportTaskStatus transportTaskStatus = createTransportTaskStatus(userContext,name);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addTransportTaskStatus( transportTaskStatus );		
			platform = savePlatform(userContext, platform, tokens().withTransportTaskStatusList().done());
			
			userContext.getManagerGroup().getTransportTaskStatusManager().onNewInstanceCreated(userContext, transportTaskStatus);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskStatusProperties(LscUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransportTaskStatus(id);
		
		userContext.getChecker().checkNameOfTransportTaskStatus( name);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateTransportTaskStatusProperties(LscUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskStatusProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskStatusListList()
				.searchTransportTaskStatusListWith(TransportTaskStatus.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getTransportTaskStatusList().isEmpty()){
			throw new PlatformManagerException("TransportTaskStatus is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTaskStatus item = platformToUpdate.getTransportTaskStatusList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingTransportTaskStatus(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withTransportTaskStatusList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTaskStatus createTransportTaskStatus(LscUserContext userContext, String name) throws Exception{

		TransportTaskStatus transportTaskStatus = new TransportTaskStatus();
		
		
		transportTaskStatus.setName(name);
	
		
		return transportTaskStatus;
	
		
	}
	
	protected TransportTaskStatus createIndexedTransportTaskStatus(String id, int version){

		TransportTaskStatus transportTaskStatus = new TransportTaskStatus();
		transportTaskStatus.setId(id);
		transportTaskStatus.setVersion(version);
		return transportTaskStatus;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskStatusList(LscUserContext userContext, String platformId, 
			String transportTaskStatusIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String transportTaskStatusId: transportTaskStatusIds){
			userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeTransportTaskStatusList(LscUserContext userContext, String platformId, 
			String transportTaskStatusIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskStatusList(userContext, platformId,  transportTaskStatusIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportTaskStatusList(platform, transportTaskStatusIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withTransportTaskStatusList().done());
				deleteRelationListInGraph(userContext, platform.getTransportTaskStatusList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTaskStatus(LscUserContext userContext, String platformId, 
		String transportTaskStatusId, int transportTaskStatusVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().checkVersionOfTransportTaskStatus(transportTaskStatusVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeTransportTaskStatus(LscUserContext userContext, String platformId, 
		String transportTaskStatusId, int transportTaskStatusVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTaskStatus(userContext,platformId, transportTaskStatusId, transportTaskStatusVersion,tokensExpr);
		
		TransportTaskStatus transportTaskStatus = createIndexedTransportTaskStatus(transportTaskStatusId, transportTaskStatusVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeTransportTaskStatus( transportTaskStatus );		
			platform = savePlatform(userContext, platform, tokens().withTransportTaskStatusList().done());
			deleteRelationInGraph(userContext, transportTaskStatus);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTaskStatus(LscUserContext userContext, String platformId, 
		String transportTaskStatusId, int transportTaskStatusVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().checkVersionOfTransportTaskStatus(transportTaskStatusVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyTransportTaskStatusFrom(LscUserContext userContext, String platformId, 
		String transportTaskStatusId, int transportTaskStatusVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTaskStatus(userContext,platformId, transportTaskStatusId, transportTaskStatusVersion,tokensExpr);
		
		TransportTaskStatus transportTaskStatus = createIndexedTransportTaskStatus(transportTaskStatusId, transportTaskStatusVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyTransportTaskStatusFrom( transportTaskStatus );		
			platform = savePlatform(userContext, platform, tokens().withTransportTaskStatusList().done());
			
			userContext.getManagerGroup().getTransportTaskStatusManager().onNewInstanceCreated(userContext, (TransportTaskStatus)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTaskStatus(LscUserContext userContext, String platformId, String transportTaskStatusId, int transportTaskStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransportTaskStatus(transportTaskStatusId);
		userContext.getChecker().checkVersionOfTransportTaskStatus(transportTaskStatusVersion);
		

		if(TransportTaskStatus.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTaskStatus(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateTransportTaskStatus(LscUserContext userContext, String platformId, String transportTaskStatusId, int transportTaskStatusVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTaskStatus(userContext, platformId, transportTaskStatusId, transportTaskStatusVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskStatusList().searchTransportTaskStatusListWith(TransportTaskStatus.ID_PROPERTY, "eq", transportTaskStatusId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeTransportTaskStatus( transportTaskStatus );	
			//make changes to AcceleraterAccount.
			TransportTaskStatus transportTaskStatusIndex = createIndexedTransportTaskStatus(transportTaskStatusId, transportTaskStatusVersion);
		
			TransportTaskStatus transportTaskStatus = platform.findTheTransportTaskStatus(transportTaskStatusIndex);
			if(transportTaskStatus == null){
				throw new PlatformManagerException(transportTaskStatus+" is NOT FOUND" );
			}
			
			transportTaskStatus.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withTransportTaskStatusList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingLocation(LscUserContext userContext, String platformId, String name, String contactPerson, String contactPhone, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfLocation(name);
		
		userContext.getChecker().checkContactPersonOfLocation(contactPerson);
		
		userContext.getChecker().checkContactPhoneOfLocation(contactPhone);
		
		userContext.getChecker().checkDescriptionOfLocation(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addLocation(LscUserContext userContext, String platformId, String name, String contactPerson, String contactPhone, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLocation(userContext,platformId,name, contactPerson, contactPhone, description,tokensExpr);
		
		Location location = createLocation(userContext,name, contactPerson, contactPhone, description);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addLocation( location );		
			platform = savePlatform(userContext, platform, tokens().withLocationList().done());
			
			userContext.getManagerGroup().getLocationManager().onNewInstanceCreated(userContext, location);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLocationProperties(LscUserContext userContext, String platformId,String id,String name,String contactPerson,String contactPhone,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfLocation(id);
		
		userContext.getChecker().checkNameOfLocation( name);
		userContext.getChecker().checkContactPersonOfLocation( contactPerson);
		userContext.getChecker().checkContactPhoneOfLocation( contactPhone);
		userContext.getChecker().checkDescriptionOfLocation( description);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateLocationProperties(LscUserContext userContext, String platformId, String id,String name,String contactPerson,String contactPhone,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLocationProperties(userContext,platformId,id,name,contactPerson,contactPhone,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLocationListList()
				.searchLocationListWith(Location.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getLocationList().isEmpty()){
			throw new PlatformManagerException("Location is NOT FOUND with id: '"+id+"'");
		}
		
		Location item = platformToUpdate.getLocationList().first();
		
		item.updateName( name );
		item.updateContactPerson( contactPerson );
		item.updateContactPhone( contactPhone );
		item.updateDescription( description );

		
		//checkParamsForAddingLocation(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withLocationList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Location createLocation(LscUserContext userContext, String name, String contactPerson, String contactPhone, String description) throws Exception{

		Location location = new Location();
		
		
		location.setName(name);		
		location.setContactPerson(contactPerson);		
		location.setContactPhone(contactPhone);		
		location.setDescription(description);		
		location.setCreateTime(userContext.now());		
		location.setUpdateTime(userContext.now());
	
		
		return location;
	
		
	}
	
	protected Location createIndexedLocation(String id, int version){

		Location location = new Location();
		location.setId(id);
		location.setVersion(version);
		return location;			
		
	}
	
	protected void checkParamsForRemovingLocationList(LscUserContext userContext, String platformId, 
			String locationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String locationId: locationIds){
			userContext.getChecker().checkIdOfLocation(locationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeLocationList(LscUserContext userContext, String platformId, 
			String locationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLocationList(userContext, platformId,  locationIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveLocationList(platform, locationIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withLocationList().done());
				deleteRelationListInGraph(userContext, platform.getLocationList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLocation(LscUserContext userContext, String platformId, 
		String locationId, int locationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().checkVersionOfLocation(locationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeLocation(LscUserContext userContext, String platformId, 
		String locationId, int locationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLocation(userContext,platformId, locationId, locationVersion,tokensExpr);
		
		Location location = createIndexedLocation(locationId, locationVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeLocation( location );		
			platform = savePlatform(userContext, platform, tokens().withLocationList().done());
			deleteRelationInGraph(userContext, location);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLocation(LscUserContext userContext, String platformId, 
		String locationId, int locationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().checkVersionOfLocation(locationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyLocationFrom(LscUserContext userContext, String platformId, 
		String locationId, int locationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLocation(userContext,platformId, locationId, locationVersion,tokensExpr);
		
		Location location = createIndexedLocation(locationId, locationVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			location.updateUpdateTime(userContext.now());
			
			platform.copyLocationFrom( location );		
			platform = savePlatform(userContext, platform, tokens().withLocationList().done());
			
			userContext.getManagerGroup().getLocationManager().onNewInstanceCreated(userContext, (Location)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLocation(LscUserContext userContext, String platformId, String locationId, int locationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfLocation(locationId);
		userContext.getChecker().checkVersionOfLocation(locationVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateLocation(LscUserContext userContext, String platformId, String locationId, int locationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLocation(userContext, platformId, locationId, locationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLocationList().searchLocationListWith(Location.ID_PROPERTY, "eq", locationId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeLocation( location );	
			//make changes to AcceleraterAccount.
			Location locationIndex = createIndexedLocation(locationId, locationVersion);
		
			Location location = platform.findTheLocation(locationIndex);
			if(location == null){
				throw new PlatformManagerException(location+" is NOT FOUND" );
			}
			
			location.changeProperty(property, newValueExpr);
			location.updateUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withLocationList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingMerchant(LscUserContext userContext, String platformId, String name, String typeId, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfMerchant(name);
		
		userContext.getChecker().checkTypeIdOfMerchant(typeId);
		
		userContext.getChecker().checkDescriptionOfMerchant(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addMerchant(LscUserContext userContext, String platformId, String name, String typeId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMerchant(userContext,platformId,name, typeId, description,tokensExpr);
		
		Merchant merchant = createMerchant(userContext,name, typeId, description);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addMerchant( merchant );		
			platform = savePlatform(userContext, platform, tokens().withMerchantList().done());
			
			userContext.getManagerGroup().getMerchantManager().onNewInstanceCreated(userContext, merchant);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMerchantProperties(LscUserContext userContext, String platformId,String id,String name,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfMerchant(id);
		
		userContext.getChecker().checkNameOfMerchant( name);
		userContext.getChecker().checkDescriptionOfMerchant( description);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateMerchantProperties(LscUserContext userContext, String platformId, String id,String name,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingMerchantProperties(userContext,platformId,id,name,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMerchantListList()
				.searchMerchantListWith(Merchant.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getMerchantList().isEmpty()){
			throw new PlatformManagerException("Merchant is NOT FOUND with id: '"+id+"'");
		}
		
		Merchant item = platformToUpdate.getMerchantList().first();
		
		item.updateName( name );
		item.updateDescription( description );

		
		//checkParamsForAddingMerchant(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withMerchantList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Merchant createMerchant(LscUserContext userContext, String name, String typeId, String description) throws Exception{

		Merchant merchant = new Merchant();
		
		
		merchant.setName(name);		
		MerchantType  type = new MerchantType();
		type.setId(typeId);		
		merchant.setType(type);		
		merchant.setDescription(description);		
		merchant.setCreateTime(userContext.now());		
		merchant.setUpdateTime(userContext.now());
	
		
		return merchant;
	
		
	}
	
	protected Merchant createIndexedMerchant(String id, int version){

		Merchant merchant = new Merchant();
		merchant.setId(id);
		merchant.setVersion(version);
		return merchant;			
		
	}
	
	protected void checkParamsForRemovingMerchantList(LscUserContext userContext, String platformId, 
			String merchantIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String merchantId: merchantIds){
			userContext.getChecker().checkIdOfMerchant(merchantId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeMerchantList(LscUserContext userContext, String platformId, 
			String merchantIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingMerchantList(userContext, platformId,  merchantIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveMerchantList(platform, merchantIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withMerchantList().done());
				deleteRelationListInGraph(userContext, platform.getMerchantList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingMerchant(LscUserContext userContext, String platformId, 
		String merchantId, int merchantVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkVersionOfMerchant(merchantVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeMerchant(LscUserContext userContext, String platformId, 
		String merchantId, int merchantVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMerchant(userContext,platformId, merchantId, merchantVersion,tokensExpr);
		
		Merchant merchant = createIndexedMerchant(merchantId, merchantVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeMerchant( merchant );		
			platform = savePlatform(userContext, platform, tokens().withMerchantList().done());
			deleteRelationInGraph(userContext, merchant);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingMerchant(LscUserContext userContext, String platformId, 
		String merchantId, int merchantVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkVersionOfMerchant(merchantVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyMerchantFrom(LscUserContext userContext, String platformId, 
		String merchantId, int merchantVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMerchant(userContext,platformId, merchantId, merchantVersion,tokensExpr);
		
		Merchant merchant = createIndexedMerchant(merchantId, merchantVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			merchant.updateUpdateTime(userContext.now());
			
			platform.copyMerchantFrom( merchant );		
			platform = savePlatform(userContext, platform, tokens().withMerchantList().done());
			
			userContext.getManagerGroup().getMerchantManager().onNewInstanceCreated(userContext, (Merchant)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingMerchant(LscUserContext userContext, String platformId, String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkVersionOfMerchant(merchantVersion);
		

		if(Merchant.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMerchant(parseString(newValueExpr));
		}
		
		if(Merchant.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfMerchant(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateMerchant(LscUserContext userContext, String platformId, String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMerchant(userContext, platformId, merchantId, merchantVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withMerchantList().searchMerchantListWith(Merchant.ID_PROPERTY, "eq", merchantId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeMerchant( merchant );	
			//make changes to AcceleraterAccount.
			Merchant merchantIndex = createIndexedMerchant(merchantId, merchantVersion);
		
			Merchant merchant = platform.findTheMerchant(merchantIndex);
			if(merchant == null){
				throw new PlatformManagerException(merchant+" is NOT FOUND" );
			}
			
			merchant.changeProperty(property, newValueExpr);
			merchant.updateUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withMerchantList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportProject(LscUserContext userContext, String platformId, String name, String merchantId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfTransportProject(name);
		
		userContext.getChecker().checkMerchantIdOfTransportProject(merchantId);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addTransportProject(LscUserContext userContext, String platformId, String name, String merchantId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportProject(userContext,platformId,name, merchantId,tokensExpr);
		
		TransportProject transportProject = createTransportProject(userContext,name, merchantId);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addTransportProject( transportProject );		
			platform = savePlatform(userContext, platform, tokens().withTransportProjectList().done());
			
			userContext.getManagerGroup().getTransportProjectManager().onNewInstanceCreated(userContext, transportProject);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportProjectProperties(LscUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransportProject(id);
		
		userContext.getChecker().checkNameOfTransportProject( name);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateTransportProjectProperties(LscUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportProjectProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportProjectListList()
				.searchTransportProjectListWith(TransportProject.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getTransportProjectList().isEmpty()){
			throw new PlatformManagerException("TransportProject is NOT FOUND with id: '"+id+"'");
		}
		
		TransportProject item = platformToUpdate.getTransportProjectList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingTransportProject(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withTransportProjectList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportProject createTransportProject(LscUserContext userContext, String name, String merchantId) throws Exception{

		TransportProject transportProject = new TransportProject();
		
		
		transportProject.setName(name);		
		Merchant  merchant = new Merchant();
		merchant.setId(merchantId);		
		transportProject.setMerchant(merchant);		
		transportProject.setCreateTime(userContext.now());		
		transportProject.setUpdateTime(userContext.now());
	
		
		return transportProject;
	
		
	}
	
	protected TransportProject createIndexedTransportProject(String id, int version){

		TransportProject transportProject = new TransportProject();
		transportProject.setId(id);
		transportProject.setVersion(version);
		return transportProject;			
		
	}
	
	protected void checkParamsForRemovingTransportProjectList(LscUserContext userContext, String platformId, 
			String transportProjectIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String transportProjectId: transportProjectIds){
			userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeTransportProjectList(LscUserContext userContext, String platformId, 
			String transportProjectIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportProjectList(userContext, platformId,  transportProjectIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportProjectList(platform, transportProjectIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withTransportProjectList().done());
				deleteRelationListInGraph(userContext, platform.getTransportProjectList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportProject(LscUserContext userContext, String platformId, 
		String transportProjectId, int transportProjectVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkVersionOfTransportProject(transportProjectVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeTransportProject(LscUserContext userContext, String platformId, 
		String transportProjectId, int transportProjectVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportProject(userContext,platformId, transportProjectId, transportProjectVersion,tokensExpr);
		
		TransportProject transportProject = createIndexedTransportProject(transportProjectId, transportProjectVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeTransportProject( transportProject );		
			platform = savePlatform(userContext, platform, tokens().withTransportProjectList().done());
			deleteRelationInGraph(userContext, transportProject);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportProject(LscUserContext userContext, String platformId, 
		String transportProjectId, int transportProjectVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkVersionOfTransportProject(transportProjectVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyTransportProjectFrom(LscUserContext userContext, String platformId, 
		String transportProjectId, int transportProjectVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportProject(userContext,platformId, transportProjectId, transportProjectVersion,tokensExpr);
		
		TransportProject transportProject = createIndexedTransportProject(transportProjectId, transportProjectVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportProject.updateUpdateTime(userContext.now());
			
			platform.copyTransportProjectFrom( transportProject );		
			platform = savePlatform(userContext, platform, tokens().withTransportProjectList().done());
			
			userContext.getManagerGroup().getTransportProjectManager().onNewInstanceCreated(userContext, (TransportProject)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportProject(LscUserContext userContext, String platformId, String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkVersionOfTransportProject(transportProjectVersion);
		

		if(TransportProject.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportProject(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateTransportProject(LscUserContext userContext, String platformId, String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportProject(userContext, platformId, transportProjectId, transportProjectVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportProjectList().searchTransportProjectListWith(TransportProject.ID_PROPERTY, "eq", transportProjectId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeTransportProject( transportProject );	
			//make changes to AcceleraterAccount.
			TransportProject transportProjectIndex = createIndexedTransportProject(transportProjectId, transportProjectVersion);
		
			TransportProject transportProject = platform.findTheTransportProject(transportProjectIndex);
			if(transportProject == null){
				throw new PlatformManagerException(transportProject+" is NOT FOUND" );
			}
			
			transportProject.changeProperty(property, newValueExpr);
			transportProject.updateUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withTransportProjectList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportItem(LscUserContext userContext, String platformId, String name, int quantity, String unit, String projectId, String merchantId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfTransportItem(name);
		
		userContext.getChecker().checkQuantityOfTransportItem(quantity);
		
		userContext.getChecker().checkUnitOfTransportItem(unit);
		
		userContext.getChecker().checkProjectIdOfTransportItem(projectId);
		
		userContext.getChecker().checkMerchantIdOfTransportItem(merchantId);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addTransportItem(LscUserContext userContext, String platformId, String name, int quantity, String unit, String projectId, String merchantId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportItem(userContext,platformId,name, quantity, unit, projectId, merchantId,tokensExpr);
		
		TransportItem transportItem = createTransportItem(userContext,name, quantity, unit, projectId, merchantId);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addTransportItem( transportItem );		
			platform = savePlatform(userContext, platform, tokens().withTransportItemList().done());
			
			userContext.getManagerGroup().getTransportItemManager().onNewInstanceCreated(userContext, transportItem);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportItemProperties(LscUserContext userContext, String platformId,String id,String name,int quantity,String unit,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransportItem(id);
		
		userContext.getChecker().checkNameOfTransportItem( name);
		userContext.getChecker().checkQuantityOfTransportItem( quantity);
		userContext.getChecker().checkUnitOfTransportItem( unit);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateTransportItemProperties(LscUserContext userContext, String platformId, String id,String name,int quantity,String unit, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportItemProperties(userContext,platformId,id,name,quantity,unit,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportItemListList()
				.searchTransportItemListWith(TransportItem.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getTransportItemList().isEmpty()){
			throw new PlatformManagerException("TransportItem is NOT FOUND with id: '"+id+"'");
		}
		
		TransportItem item = platformToUpdate.getTransportItemList().first();
		
		item.updateName( name );
		item.updateQuantity( quantity );
		item.updateUnit( unit );

		
		//checkParamsForAddingTransportItem(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withTransportItemList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportItem createTransportItem(LscUserContext userContext, String name, int quantity, String unit, String projectId, String merchantId) throws Exception{

		TransportItem transportItem = new TransportItem();
		
		
		transportItem.setName(name);		
		transportItem.setQuantity(quantity);		
		transportItem.setUnit(unit);		
		TransportProject  project = new TransportProject();
		project.setId(projectId);		
		transportItem.setProject(project);		
		MerchantType  merchant = new MerchantType();
		merchant.setId(merchantId);		
		transportItem.setMerchant(merchant);		
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
	
	protected void checkParamsForRemovingTransportItemList(LscUserContext userContext, String platformId, 
			String transportItemIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String transportItemId: transportItemIds){
			userContext.getChecker().checkIdOfTransportItem(transportItemId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeTransportItemList(LscUserContext userContext, String platformId, 
			String transportItemIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportItemList(userContext, platformId,  transportItemIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportItemList(platform, transportItemIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withTransportItemList().done());
				deleteRelationListInGraph(userContext, platform.getTransportItemList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportItem(LscUserContext userContext, String platformId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem(transportItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeTransportItem(LscUserContext userContext, String platformId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportItem(userContext,platformId, transportItemId, transportItemVersion,tokensExpr);
		
		TransportItem transportItem = createIndexedTransportItem(transportItemId, transportItemVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeTransportItem( transportItem );		
			platform = savePlatform(userContext, platform, tokens().withTransportItemList().done());
			deleteRelationInGraph(userContext, transportItem);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportItem(LscUserContext userContext, String platformId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem(transportItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyTransportItemFrom(LscUserContext userContext, String platformId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportItem(userContext,platformId, transportItemId, transportItemVersion,tokensExpr);
		
		TransportItem transportItem = createIndexedTransportItem(transportItemId, transportItemVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportItem.updateUpdateTime(userContext.now());
			
			platform.copyTransportItemFrom( transportItem );		
			platform = savePlatform(userContext, platform, tokens().withTransportItemList().done());
			
			userContext.getManagerGroup().getTransportItemManager().onNewInstanceCreated(userContext, (TransportItem)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportItem(LscUserContext userContext, String platformId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateTransportItem(LscUserContext userContext, String platformId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportItem(userContext, platformId, transportItemId, transportItemVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportItemList().searchTransportItemListWith(TransportItem.ID_PROPERTY, "eq", transportItemId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeTransportItem( transportItem );	
			//make changes to AcceleraterAccount.
			TransportItem transportItemIndex = createIndexedTransportItem(transportItemId, transportItemVersion);
		
			TransportItem transportItem = platform.findTheTransportItem(transportItemIndex);
			if(transportItem == null){
				throw new PlatformManagerException(transportItem+" is NOT FOUND" );
			}
			
			transportItem.changeProperty(property, newValueExpr);
			transportItem.updateUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withTransportItemList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportTask(LscUserContext userContext, String platformId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkProjectIdOfTransportTask(projectId);
		
		userContext.getChecker().checkSourceIdOfTransportTask(sourceId);
		
		userContext.getChecker().checkDestinationIdOfTransportTask(destinationId);
		
		userContext.getChecker().checkRemarkOfTransportTask(remark);
		
		userContext.getChecker().checkStatusIdOfTransportTask(statusId);
		
		userContext.getChecker().checkSenderIdOfTransportTask(senderId);
		
		userContext.getChecker().checkReceiverIdOfTransportTask(receiverId);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addTransportTask(LscUserContext userContext, String platformId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,platformId,name, projectId, sourceId, destinationId, remark, statusId, senderId, receiverId,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, projectId, sourceId, destinationId, remark, statusId, senderId, receiverId);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addTransportTask( transportTask );		
			platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(LscUserContext userContext, String platformId,String id,String name,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkRemarkOfTransportTask( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateTransportTaskProperties(LscUserContext userContext, String platformId, String id,String name,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskProperties(userContext,platformId,id,name,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getTransportTaskList().isEmpty()){
			throw new PlatformManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = platformToUpdate.getTransportTaskList().first();
		
		item.updateName( name );
		item.updateRemark( remark );

		
		//checkParamsForAddingTransportTask(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withTransportTaskList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTask(LscUserContext userContext, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		TransportProject  project = new TransportProject();
		project.setId(projectId);		
		transportTask.setProject(project);		
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
	
	protected void checkParamsForRemovingTransportTaskList(LscUserContext userContext, String platformId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeTransportTaskList(LscUserContext userContext, String platformId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskList(userContext, platformId,  transportTaskIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTransportTaskList(platform, transportTaskIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, platform.getTransportTaskList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTask(LscUserContext userContext, String platformId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeTransportTask(LscUserContext userContext, String platformId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,platformId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeTransportTask( transportTask );		
			platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTask(LscUserContext userContext, String platformId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyTransportTaskFrom(LscUserContext userContext, String platformId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,platformId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportTask.updateUpdateTime(userContext.now());
			
			platform.copyTransportTaskFrom( transportTask );		
			platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTask(LscUserContext userContext, String platformId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTransportTask(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateTransportTask(LscUserContext userContext, String platformId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, platformId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = platform.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new PlatformManagerException(transportTask+" is NOT FOUND" );
			}
			
			transportTask.changeProperty(property, newValueExpr);
			transportTask.updateUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withTransportTaskList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, Platform newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


