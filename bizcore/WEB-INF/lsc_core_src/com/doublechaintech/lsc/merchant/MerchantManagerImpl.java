
package com.doublechaintech.lsc.merchant;

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

import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;

import com.doublechaintech.lsc.platform.CandidatePlatform;
import com.doublechaintech.lsc.merchanttype.CandidateMerchantType;

import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;






public class MerchantManagerImpl extends CustomLscCheckerManager implements MerchantManager {
	
	private static final String SERVICE_TYPE = "Merchant";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws MerchantManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new MerchantManagerException(message);

	}
	
	

 	protected Merchant saveMerchant(LscUserContext userContext, Merchant merchant, String [] tokensExpr) throws Exception{	
 		//return getMerchantDAO().save(merchant, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMerchant(userContext, merchant, tokens);
 	}
 	
 	protected Merchant saveMerchantDetail(LscUserContext userContext, Merchant merchant) throws Exception{	

 		
 		return saveMerchant(userContext, merchant, allTokens());
 	}
 	
 	public Merchant loadMerchant(LscUserContext userContext, String merchantId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Merchant merchant = loadMerchant( userContext, merchantId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,merchant, tokens);
 	}
 	
 	
 	 public Merchant searchMerchant(LscUserContext userContext, String merchantId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Merchant merchant = loadMerchant( userContext, merchantId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,merchant, tokens);
 	}
 	
 	

 	protected Merchant present(LscUserContext userContext, Merchant merchant, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,merchant,tokens);
		
		
		Merchant  merchantToPresent = userContext.getDAOGroup().getMerchantDAO().present(merchant, tokens);
		
		List<BaseEntity> entityListToNaming = merchantToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getMerchantDAO().alias(entityListToNaming);
		
		return  merchantToPresent;
		
		
	}
 
 	
 	
 	public Merchant loadMerchantDetail(LscUserContext userContext, String merchantId) throws Exception{	
 		Merchant merchant = loadMerchant( userContext, merchantId, allTokens());
 		return present(userContext,merchant, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String merchantId) throws Exception{	
 		Merchant merchant = loadMerchant( userContext, merchantId, viewTokens());
 		return present(userContext,merchant, allTokens());
		
 	}
 	protected Merchant saveMerchant(LscUserContext userContext, Merchant merchant, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getMerchantDAO().save(merchant, tokens);
 	}
 	protected Merchant loadMerchant(LscUserContext userContext, String merchantId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantManagerException.class);

 
 		return userContext.getDAOGroup().getMerchantDAO().load(merchantId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, Merchant merchant, Map<String, Object> tokens){
		super.addActions(userContext, merchant, tokens);
		
		addAction(userContext, merchant, tokens,"@create","createMerchant","createMerchant/","main","primary");
		addAction(userContext, merchant, tokens,"@update","updateMerchant","updateMerchant/"+merchant.getId()+"/","main","primary");
		addAction(userContext, merchant, tokens,"@copy","cloneMerchant","cloneMerchant/"+merchant.getId()+"/","main","primary");
		
		addAction(userContext, merchant, tokens,"merchant.transfer_to_type","transferToAnotherType","transferToAnotherType/"+merchant.getId()+"/","main","primary");
		addAction(userContext, merchant, tokens,"merchant.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+merchant.getId()+"/","main","primary");
		addAction(userContext, merchant, tokens,"merchant.addTransportProject","addTransportProject","addTransportProject/"+merchant.getId()+"/","transportProjectList","primary");
		addAction(userContext, merchant, tokens,"merchant.removeTransportProject","removeTransportProject","removeTransportProject/"+merchant.getId()+"/","transportProjectList","primary");
		addAction(userContext, merchant, tokens,"merchant.updateTransportProject","updateTransportProject","updateTransportProject/"+merchant.getId()+"/","transportProjectList","primary");
		addAction(userContext, merchant, tokens,"merchant.copyTransportProjectFrom","copyTransportProjectFrom","copyTransportProjectFrom/"+merchant.getId()+"/","transportProjectList","primary");
		addAction(userContext, merchant, tokens,"merchant.addTransportTask","addTransportTask","addTransportTask/"+merchant.getId()+"/","transportTaskListAsSender","primary");
		addAction(userContext, merchant, tokens,"merchant.removeTransportTask","removeTransportTask","removeTransportTask/"+merchant.getId()+"/","transportTaskListAsSender","primary");
		addAction(userContext, merchant, tokens,"merchant.updateTransportTask","updateTransportTask","updateTransportTask/"+merchant.getId()+"/","transportTaskListAsSender","primary");
		addAction(userContext, merchant, tokens,"merchant.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+merchant.getId()+"/","transportTaskListAsSender","primary");
		addAction(userContext, merchant, tokens,"merchant.addTransportTask","addTransportTask","addTransportTask/"+merchant.getId()+"/","transportTaskListAsReceiver","primary");
		addAction(userContext, merchant, tokens,"merchant.removeTransportTask","removeTransportTask","removeTransportTask/"+merchant.getId()+"/","transportTaskListAsReceiver","primary");
		addAction(userContext, merchant, tokens,"merchant.updateTransportTask","updateTransportTask","updateTransportTask/"+merchant.getId()+"/","transportTaskListAsReceiver","primary");
		addAction(userContext, merchant, tokens,"merchant.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+merchant.getId()+"/","transportTaskListAsReceiver","primary");
		addAction(userContext, merchant, tokens,"merchant.addMerchantAccount","addMerchantAccount","addMerchantAccount/"+merchant.getId()+"/","merchantAccountList","primary");
		addAction(userContext, merchant, tokens,"merchant.removeMerchantAccount","removeMerchantAccount","removeMerchantAccount/"+merchant.getId()+"/","merchantAccountList","primary");
		addAction(userContext, merchant, tokens,"merchant.updateMerchantAccount","updateMerchantAccount","updateMerchantAccount/"+merchant.getId()+"/","merchantAccountList","primary");
		addAction(userContext, merchant, tokens,"merchant.copyMerchantAccountFrom","copyMerchantAccountFrom","copyMerchantAccountFrom/"+merchant.getId()+"/","merchantAccountList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, Merchant merchant, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Merchant createMerchant(LscUserContext userContext,String name, String typeId, String platformId, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfMerchant(name);
		userContext.getChecker().checkDescriptionOfMerchant(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);


		Merchant merchant=createNewMerchant();	

		merchant.setName(name);
			
		MerchantType type = loadMerchantType(userContext, typeId,emptyOptions());
		merchant.setType(type);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		merchant.setPlatform(platform);
		
		
		merchant.setDescription(description);
		merchant.setCreateTime(userContext.now());
		merchant.setUpdateTime(userContext.now());

		merchant = saveMerchant(userContext, merchant, emptyOptions());
		
		onNewInstanceCreated(userContext, merchant);
		return merchant;

		
	}
	protected Merchant createNewMerchant() 
	{
		
		return new Merchant();		
	}
	
	protected void checkParamsForUpdatingMerchant(LscUserContext userContext,String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkVersionOfMerchant( merchantVersion);
		

		if(Merchant.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMerchant(parseString(newValueExpr));
		}		

				

		
		if(Merchant.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfMerchant(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
		
	}
	
	
	
	public Merchant clone(LscUserContext userContext, String fromMerchantId) throws Exception{
		
		return userContext.getDAOGroup().getMerchantDAO().clone(fromMerchantId, this.allTokens());
	}
	
	public Merchant internalSaveMerchant(LscUserContext userContext, Merchant merchant) throws Exception 
	{
		return internalSaveMerchant(userContext, merchant, allTokens());

	}
	public Merchant internalSaveMerchant(LscUserContext userContext, Merchant merchant, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingMerchant(userContext, merchantId, merchantVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(merchant){ 
			//will be good when the merchant loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Merchant.
			
			
			merchant = saveMerchant(userContext, merchant, options);
			return merchant;
			
		}

	}
	
	public Merchant updateMerchant(LscUserContext userContext,String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMerchant(userContext, merchantId, merchantVersion, property, newValueExpr, tokensExpr);
		
		
		
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		if(merchant.getVersion() != merchantVersion){
			String message = "The target version("+merchant.getVersion()+") is not equals to version("+merchantVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(merchant){ 
			//will be good when the merchant loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Merchant.
			merchant.updateUpdateTime(userContext.now());
			merchant.changeProperty(property, newValueExpr);
			merchant = saveMerchant(userContext, merchant, tokens().done());
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
			//return saveMerchant(userContext, merchant, tokens().done());
		}

	}
	
	public Merchant updateMerchantProperty(LscUserContext userContext,String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMerchant(userContext, merchantId, merchantVersion, property, newValueExpr, tokensExpr);
		
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		if(merchant.getVersion() != merchantVersion){
			String message = "The target version("+merchant.getVersion()+") is not equals to version("+merchantVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(merchant){ 
			//will be good when the merchant loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Merchant.
			
			merchant.changeProperty(property, newValueExpr);
			merchant.updateUpdateTime(userContext.now());
			merchant = saveMerchant(userContext, merchant, tokens().done());
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
			//return saveMerchant(userContext, merchant, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MerchantTokens tokens(){
		return MerchantTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MerchantTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportProjectListWith("id","desc")
		.sortTransportTaskListAsSenderWith("id","desc")
		.sortTransportTaskListAsReceiverWith("id","desc")
		.sortMerchantAccountListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MerchantTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherType(LscUserContext userContext, String merchantId, String anotherTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfMerchant(merchantId);
 		userContext.getChecker().checkIdOfMerchantType(anotherTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
 		
 	}
 	public Merchant transferToAnotherType(LscUserContext userContext, String merchantId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, merchantId,anotherTypeId);
 
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());	
		synchronized(merchant){
			//will be good when the merchant loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			MerchantType type = loadMerchantType(userContext, anotherTypeId, emptyOptions());		
			merchant.updateType(type);		
			merchant = saveMerchant(userContext, merchant, emptyOptions());
			
			return present(userContext,merchant, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateMerchantType requestCandidateType(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateMerchantType result = new CandidateMerchantType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<MerchantType> candidateList = userContext.getDAOGroup().getMerchantTypeDAO().requestCandidateMerchantTypeForMerchant(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(LscUserContext userContext, String merchantId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfMerchant(merchantId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
 		
 	}
 	public Merchant transferToAnotherPlatform(LscUserContext userContext, String merchantId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, merchantId,anotherPlatformId);
 
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());	
		synchronized(merchant){
			//will be good when the merchant loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			merchant.updatePlatform(platform);		
			merchant = saveMerchant(userContext, merchant, emptyOptions());
			
			return present(userContext,merchant, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForMerchant(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected MerchantType loadMerchantType(LscUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getMerchantTypeDAO().load(newTypeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String merchantId, int merchantVersion) throws Exception {
		//deleteInternal(userContext, merchantId, merchantVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String merchantId, int merchantVersion) throws Exception{
			
		userContext.getDAOGroup().getMerchantDAO().delete(merchantId, merchantVersion);
	}
	
	public Merchant forgetByAll(LscUserContext userContext, String merchantId, int merchantVersion) throws Exception {
		return forgetByAllInternal(userContext, merchantId, merchantVersion);		
	}
	protected Merchant forgetByAllInternal(LscUserContext userContext,
			String merchantId, int merchantVersion) throws Exception{
			
		return userContext.getDAOGroup().getMerchantDAO().disconnectFromAll(merchantId, merchantVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MerchantManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getMerchantDAO().deleteAll();
	}


	//disconnect Merchant with platform in TransportProject
	protected Merchant breakWithTransportProjectByPlatform(LscUserContext userContext, String merchantId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportProjectListWithPlatform(merchant, platformId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportProjectList().done());
				return merchant;
			}
	}
	//disconnect Merchant with project in TransportTask
	protected Merchant breakWithTransportTaskAsSenderByProject(LscUserContext userContext, String merchantId, String projectId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsSenderWithProject(merchant, projectId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
				return merchant;
			}
	}
	//disconnect Merchant with source in TransportTask
	protected Merchant breakWithTransportTaskAsSenderBySource(LscUserContext userContext, String merchantId, String sourceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsSenderWithSource(merchant, sourceId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
				return merchant;
			}
	}
	//disconnect Merchant with destination in TransportTask
	protected Merchant breakWithTransportTaskAsSenderByDestination(LscUserContext userContext, String merchantId, String destinationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsSenderWithDestination(merchant, destinationId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
				return merchant;
			}
	}
	//disconnect Merchant with status in TransportTask
	protected Merchant breakWithTransportTaskAsSenderByStatus(LscUserContext userContext, String merchantId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsSenderWithStatus(merchant, statusId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
				return merchant;
			}
	}
	//disconnect Merchant with platform in TransportTask
	protected Merchant breakWithTransportTaskAsSenderByPlatform(LscUserContext userContext, String merchantId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsSenderWithPlatform(merchant, platformId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
				return merchant;
			}
	}
	//disconnect Merchant with project in TransportTask
	protected Merchant breakWithTransportTaskAsReceiverByProject(LscUserContext userContext, String merchantId, String projectId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsReceiverWithProject(merchant, projectId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
				return merchant;
			}
	}
	//disconnect Merchant with source in TransportTask
	protected Merchant breakWithTransportTaskAsReceiverBySource(LscUserContext userContext, String merchantId, String sourceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsReceiverWithSource(merchant, sourceId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
				return merchant;
			}
	}
	//disconnect Merchant with destination in TransportTask
	protected Merchant breakWithTransportTaskAsReceiverByDestination(LscUserContext userContext, String merchantId, String destinationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsReceiverWithDestination(merchant, destinationId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
				return merchant;
			}
	}
	//disconnect Merchant with status in TransportTask
	protected Merchant breakWithTransportTaskAsReceiverByStatus(LscUserContext userContext, String merchantId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsReceiverWithStatus(merchant, statusId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
				return merchant;
			}
	}
	//disconnect Merchant with platform in TransportTask
	protected Merchant breakWithTransportTaskAsReceiverByPlatform(LscUserContext userContext, String merchantId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());

			synchronized(merchant){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsReceiverWithPlatform(merchant, platformId, this.emptyOptions());

				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
				return merchant;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransportProject(LscUserContext userContext, String merchantId, String name, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfMerchant(merchantId);

		
		userContext.getChecker().checkNameOfTransportProject(name);
		
		userContext.getChecker().checkPlatformIdOfTransportProject(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);

	
	}
	public  Merchant addTransportProject(LscUserContext userContext, String merchantId, String name, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportProject(userContext,merchantId,name, platformId,tokensExpr);
		
		TransportProject transportProject = createTransportProject(userContext,name, platformId);
		
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchant.addTransportProject( transportProject );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportProjectList().done());
			
			userContext.getManagerGroup().getTransportProjectManager().onNewInstanceCreated(userContext, transportProject);
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportProjectProperties(LscUserContext userContext, String merchantId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkIdOfTransportProject(id);
		
		userContext.getChecker().checkNameOfTransportProject( name);

		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
		
	}
	public  Merchant updateTransportProjectProperties(LscUserContext userContext, String merchantId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportProjectProperties(userContext,merchantId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportProjectListList()
				.searchTransportProjectListWith(TransportProject.ID_PROPERTY, "is", id).done();
		
		Merchant merchantToUpdate = loadMerchant(userContext, merchantId, options);
		
		if(merchantToUpdate.getTransportProjectList().isEmpty()){
			throw new MerchantManagerException("TransportProject is NOT FOUND with id: '"+id+"'");
		}
		
		TransportProject item = merchantToUpdate.getTransportProjectList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingTransportProject(userContext,merchantId,name, code, used,tokensExpr);
		Merchant merchant = saveMerchant(userContext, merchantToUpdate, tokens().withTransportProjectList().done());
		synchronized(merchant){ 
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportProject createTransportProject(LscUserContext userContext, String name, String platformId) throws Exception{

		TransportProject transportProject = new TransportProject();
		
		
		transportProject.setName(name);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		transportProject.setPlatform(platform);		
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
	
	protected void checkParamsForRemovingTransportProjectList(LscUserContext userContext, String merchantId, 
			String transportProjectIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		for(String transportProjectId: transportProjectIds){
			userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
		
	}
	public  Merchant removeTransportProjectList(LscUserContext userContext, String merchantId, 
			String transportProjectIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportProjectList(userContext, merchantId,  transportProjectIds, tokensExpr);
			
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
			synchronized(merchant){ 
				//Will be good when the merchant loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportProjectList(merchant, transportProjectIds, allTokens());
				merchant = saveMerchant(userContext, merchant, tokens().withTransportProjectList().done());
				deleteRelationListInGraph(userContext, merchant.getTransportProjectList());
				return present(userContext,merchant, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportProject(LscUserContext userContext, String merchantId, 
		String transportProjectId, int transportProjectVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchant( merchantId);
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkVersionOfTransportProject(transportProjectVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	public  Merchant removeTransportProject(LscUserContext userContext, String merchantId, 
		String transportProjectId, int transportProjectVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportProject(userContext,merchantId, transportProjectId, transportProjectVersion,tokensExpr);
		
		TransportProject transportProject = createIndexedTransportProject(transportProjectId, transportProjectVersion);
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchant.removeTransportProject( transportProject );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportProjectList().done());
			deleteRelationInGraph(userContext, transportProject);
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportProject(LscUserContext userContext, String merchantId, 
		String transportProjectId, int transportProjectVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchant( merchantId);
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkVersionOfTransportProject(transportProjectVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	public  Merchant copyTransportProjectFrom(LscUserContext userContext, String merchantId, 
		String transportProjectId, int transportProjectVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportProject(userContext,merchantId, transportProjectId, transportProjectVersion,tokensExpr);
		
		TransportProject transportProject = createIndexedTransportProject(transportProjectId, transportProjectVersion);
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportProject.updateUpdateTime(userContext.now());
			
			merchant.copyTransportProjectFrom( transportProject );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportProjectList().done());
			
			userContext.getManagerGroup().getTransportProjectManager().onNewInstanceCreated(userContext, (TransportProject)merchant.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportProject(LscUserContext userContext, String merchantId, String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkIdOfTransportProject(transportProjectId);
		userContext.getChecker().checkVersionOfTransportProject(transportProjectVersion);
		

		if(TransportProject.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportProject(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	
	public  Merchant updateTransportProject(LscUserContext userContext, String merchantId, String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportProject(userContext, merchantId, transportProjectId, transportProjectVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportProjectList().searchTransportProjectListWith(TransportProject.ID_PROPERTY, "eq", transportProjectId).done();
		
		
		
		Merchant merchant = loadMerchant(userContext, merchantId, loadTokens);
		
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//merchant.removeTransportProject( transportProject );	
			//make changes to AcceleraterAccount.
			TransportProject transportProjectIndex = createIndexedTransportProject(transportProjectId, transportProjectVersion);
		
			TransportProject transportProject = merchant.findTheTransportProject(transportProjectIndex);
			if(transportProject == null){
				throw new MerchantManagerException(transportProject+" is NOT FOUND" );
			}
			
			transportProject.changeProperty(property, newValueExpr);
			transportProject.updateUpdateTime(userContext.now());
			merchant = saveMerchant(userContext, merchant, tokens().withTransportProjectList().done());
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportTaskAsSender(LscUserContext userContext, String merchantId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfMerchant(merchantId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkProjectIdOfTransportTask(projectId);
		
		userContext.getChecker().checkSourceIdOfTransportTask(sourceId);
		
		userContext.getChecker().checkDestinationIdOfTransportTask(destinationId);
		
		userContext.getChecker().checkRemarkOfTransportTask(remark);
		
		userContext.getChecker().checkStatusIdOfTransportTask(statusId);
		
		userContext.getChecker().checkPlatformIdOfTransportTask(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);

	
	}
	public  Merchant addTransportTaskAsSender(LscUserContext userContext, String merchantId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTaskAsSender(userContext,merchantId,name, projectId, sourceId, destinationId, remark, statusId, platformId,tokensExpr);
		
		TransportTask transportTask = createTransportTaskAsSender(userContext,name, projectId, sourceId, destinationId, remark, statusId, platformId);
		
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchant.addTransportTaskAsSender( transportTask );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskAsSenderProperties(LscUserContext userContext, String merchantId,String id,String name,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkRemarkOfTransportTask( remark);

		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
		
	}
	public  Merchant updateTransportTaskAsSenderProperties(LscUserContext userContext, String merchantId, String id,String name,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskAsSenderProperties(userContext,merchantId,id,name,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListAsSenderList()
				.searchTransportTaskListAsSenderWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		Merchant merchantToUpdate = loadMerchant(userContext, merchantId, options);
		
		if(merchantToUpdate.getTransportTaskListAsSender().isEmpty()){
			throw new MerchantManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = merchantToUpdate.getTransportTaskListAsSender().first();
		
		item.updateName( name );
		item.updateRemark( remark );

		
		//checkParamsForAddingTransportTaskAsSender(userContext,merchantId,name, code, used,tokensExpr);
		Merchant merchant = saveMerchant(userContext, merchantToUpdate, tokens().withTransportTaskListAsSender().done());
		synchronized(merchant){ 
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTaskAsSender(LscUserContext userContext, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId) throws Exception{

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
		Platform  platform = new Platform();
		platform.setId(platformId);		
		transportTask.setPlatform(platform);		
		transportTask.setCreateTime(userContext.now());		
		transportTask.setUpdateTime(userContext.now());
	
		
		return transportTask;
	
		
	}
	
	protected TransportTask createIndexedTransportTaskAsSender(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskListAsSender(LscUserContext userContext, String merchantId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
		
	}
	public  Merchant removeTransportTaskListAsSender(LscUserContext userContext, String merchantId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskListAsSender(userContext, merchantId,  transportTaskIds, tokensExpr);
			
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
			synchronized(merchant){ 
				//Will be good when the merchant loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsSender(merchant, transportTaskIds, allTokens());
				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
				deleteRelationListInGraph(userContext, merchant.getTransportTaskListAsSender());
				return present(userContext,merchant, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTaskAsSender(LscUserContext userContext, String merchantId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchant( merchantId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	public  Merchant removeTransportTaskAsSender(LscUserContext userContext, String merchantId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTaskAsSender(userContext,merchantId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTaskAsSender(transportTaskId, transportTaskVersion);
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchant.removeTransportTaskAsSender( transportTask );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTaskAsSender(LscUserContext userContext, String merchantId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchant( merchantId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	public  Merchant copyTransportTaskAsSenderFrom(LscUserContext userContext, String merchantId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTaskAsSender(userContext,merchantId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTaskAsSender = createIndexedTransportTaskAsSender(transportTaskId, transportTaskVersion);
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportTaskAsSender.updateUpdateTime(userContext.now());
			
			merchant.copyTransportTaskAsSenderFrom( transportTaskAsSender );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)merchant.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTaskAsSender(LscUserContext userContext, String merchantId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTransportTask(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	
	public  Merchant updateTransportTaskAsSender(LscUserContext userContext, String merchantId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTaskAsSender(userContext, merchantId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskListAsSender().searchTransportTaskListAsSenderWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		Merchant merchant = loadMerchant(userContext, merchantId, loadTokens);
		
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//merchant.removeTransportTaskAsSender( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTaskAsSender(transportTaskId, transportTaskVersion);
		
			TransportTask transportTaskAsSender = merchant.findTheTransportTaskAsSender(transportTaskIndex);
			if(transportTaskAsSender == null){
				throw new MerchantManagerException(transportTaskAsSender+" is NOT FOUND" );
			}
			
			transportTaskAsSender.changeProperty(property, newValueExpr);
			transportTaskAsSender.updateUpdateTime(userContext.now());
			merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsSender().done());
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportTaskAsReceiver(LscUserContext userContext, String merchantId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfMerchant(merchantId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkProjectIdOfTransportTask(projectId);
		
		userContext.getChecker().checkSourceIdOfTransportTask(sourceId);
		
		userContext.getChecker().checkDestinationIdOfTransportTask(destinationId);
		
		userContext.getChecker().checkRemarkOfTransportTask(remark);
		
		userContext.getChecker().checkStatusIdOfTransportTask(statusId);
		
		userContext.getChecker().checkPlatformIdOfTransportTask(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);

	
	}
	public  Merchant addTransportTaskAsReceiver(LscUserContext userContext, String merchantId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTaskAsReceiver(userContext,merchantId,name, projectId, sourceId, destinationId, remark, statusId, platformId,tokensExpr);
		
		TransportTask transportTask = createTransportTaskAsReceiver(userContext,name, projectId, sourceId, destinationId, remark, statusId, platformId);
		
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchant.addTransportTaskAsReceiver( transportTask );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskAsReceiverProperties(LscUserContext userContext, String merchantId,String id,String name,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkRemarkOfTransportTask( remark);

		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
		
	}
	public  Merchant updateTransportTaskAsReceiverProperties(LscUserContext userContext, String merchantId, String id,String name,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskAsReceiverProperties(userContext,merchantId,id,name,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListAsReceiverList()
				.searchTransportTaskListAsReceiverWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		Merchant merchantToUpdate = loadMerchant(userContext, merchantId, options);
		
		if(merchantToUpdate.getTransportTaskListAsReceiver().isEmpty()){
			throw new MerchantManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = merchantToUpdate.getTransportTaskListAsReceiver().first();
		
		item.updateName( name );
		item.updateRemark( remark );

		
		//checkParamsForAddingTransportTaskAsReceiver(userContext,merchantId,name, code, used,tokensExpr);
		Merchant merchant = saveMerchant(userContext, merchantToUpdate, tokens().withTransportTaskListAsReceiver().done());
		synchronized(merchant){ 
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTaskAsReceiver(LscUserContext userContext, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId) throws Exception{

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
		Platform  platform = new Platform();
		platform.setId(platformId);		
		transportTask.setPlatform(platform);		
		transportTask.setCreateTime(userContext.now());		
		transportTask.setUpdateTime(userContext.now());
	
		
		return transportTask;
	
		
	}
	
	protected TransportTask createIndexedTransportTaskAsReceiver(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskListAsReceiver(LscUserContext userContext, String merchantId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
		
	}
	public  Merchant removeTransportTaskListAsReceiver(LscUserContext userContext, String merchantId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskListAsReceiver(userContext, merchantId,  transportTaskIds, tokensExpr);
			
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
			synchronized(merchant){ 
				//Will be good when the merchant loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getMerchantDAO().planToRemoveTransportTaskListAsReceiver(merchant, transportTaskIds, allTokens());
				merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
				deleteRelationListInGraph(userContext, merchant.getTransportTaskListAsReceiver());
				return present(userContext,merchant, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTaskAsReceiver(LscUserContext userContext, String merchantId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchant( merchantId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	public  Merchant removeTransportTaskAsReceiver(LscUserContext userContext, String merchantId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTaskAsReceiver(userContext,merchantId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTaskAsReceiver(transportTaskId, transportTaskVersion);
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchant.removeTransportTaskAsReceiver( transportTask );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTaskAsReceiver(LscUserContext userContext, String merchantId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchant( merchantId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	public  Merchant copyTransportTaskAsReceiverFrom(LscUserContext userContext, String merchantId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTaskAsReceiver(userContext,merchantId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTaskAsReceiver = createIndexedTransportTaskAsReceiver(transportTaskId, transportTaskVersion);
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportTaskAsReceiver.updateUpdateTime(userContext.now());
			
			merchant.copyTransportTaskAsReceiverFrom( transportTaskAsReceiver );		
			merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)merchant.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTaskAsReceiver(LscUserContext userContext, String merchantId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTransportTask(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	
	public  Merchant updateTransportTaskAsReceiver(LscUserContext userContext, String merchantId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTaskAsReceiver(userContext, merchantId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskListAsReceiver().searchTransportTaskListAsReceiverWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		Merchant merchant = loadMerchant(userContext, merchantId, loadTokens);
		
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//merchant.removeTransportTaskAsReceiver( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTaskAsReceiver(transportTaskId, transportTaskVersion);
		
			TransportTask transportTaskAsReceiver = merchant.findTheTransportTaskAsReceiver(transportTaskIndex);
			if(transportTaskAsReceiver == null){
				throw new MerchantManagerException(transportTaskAsReceiver+" is NOT FOUND" );
			}
			
			transportTaskAsReceiver.changeProperty(property, newValueExpr);
			transportTaskAsReceiver.updateUpdateTime(userContext.now());
			merchant = saveMerchant(userContext, merchant, tokens().withTransportTaskListAsReceiver().done());
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingMerchantAccount(LscUserContext userContext, String merchantId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfMerchant(merchantId);

		
		userContext.getChecker().checkNameOfMerchantAccount(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);

	
	}
	public  Merchant addMerchantAccount(LscUserContext userContext, String merchantId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMerchantAccount(userContext,merchantId,name,tokensExpr);
		
		MerchantAccount merchantAccount = createMerchantAccount(userContext,name);
		
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchant.addMerchantAccount( merchantAccount );		
			merchant = saveMerchant(userContext, merchant, tokens().withMerchantAccountList().done());
			
			userContext.getManagerGroup().getMerchantAccountManager().onNewInstanceCreated(userContext, merchantAccount);
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMerchantAccountProperties(LscUserContext userContext, String merchantId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkIdOfMerchantAccount(id);
		
		userContext.getChecker().checkNameOfMerchantAccount( name);

		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
		
	}
	public  Merchant updateMerchantAccountProperties(LscUserContext userContext, String merchantId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingMerchantAccountProperties(userContext,merchantId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMerchantAccountListList()
				.searchMerchantAccountListWith(MerchantAccount.ID_PROPERTY, "is", id).done();
		
		Merchant merchantToUpdate = loadMerchant(userContext, merchantId, options);
		
		if(merchantToUpdate.getMerchantAccountList().isEmpty()){
			throw new MerchantManagerException("MerchantAccount is NOT FOUND with id: '"+id+"'");
		}
		
		MerchantAccount item = merchantToUpdate.getMerchantAccountList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingMerchantAccount(userContext,merchantId,name, code, used,tokensExpr);
		Merchant merchant = saveMerchant(userContext, merchantToUpdate, tokens().withMerchantAccountList().done());
		synchronized(merchant){ 
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected MerchantAccount createMerchantAccount(LscUserContext userContext, String name) throws Exception{

		MerchantAccount merchantAccount = new MerchantAccount();
		
		
		merchantAccount.setName(name);		
		merchantAccount.setCreateTime(userContext.now());		
		merchantAccount.setUpdateTime(userContext.now());
	
		
		return merchantAccount;
	
		
	}
	
	protected MerchantAccount createIndexedMerchantAccount(String id, int version){

		MerchantAccount merchantAccount = new MerchantAccount();
		merchantAccount.setId(id);
		merchantAccount.setVersion(version);
		return merchantAccount;			
		
	}
	
	protected void checkParamsForRemovingMerchantAccountList(LscUserContext userContext, String merchantId, 
			String merchantAccountIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		for(String merchantAccountId: merchantAccountIds){
			userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
		
	}
	public  Merchant removeMerchantAccountList(LscUserContext userContext, String merchantId, 
			String merchantAccountIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingMerchantAccountList(userContext, merchantId,  merchantAccountIds, tokensExpr);
			
			
			Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
			synchronized(merchant){ 
				//Will be good when the merchant loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getMerchantDAO().planToRemoveMerchantAccountList(merchant, merchantAccountIds, allTokens());
				merchant = saveMerchant(userContext, merchant, tokens().withMerchantAccountList().done());
				deleteRelationListInGraph(userContext, merchant.getMerchantAccountList());
				return present(userContext,merchant, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingMerchantAccount(LscUserContext userContext, String merchantId, 
		String merchantAccountId, int merchantAccountVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchant( merchantId);
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().checkVersionOfMerchantAccount(merchantAccountVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	public  Merchant removeMerchantAccount(LscUserContext userContext, String merchantId, 
		String merchantAccountId, int merchantAccountVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMerchantAccount(userContext,merchantId, merchantAccountId, merchantAccountVersion,tokensExpr);
		
		MerchantAccount merchantAccount = createIndexedMerchantAccount(merchantAccountId, merchantAccountVersion);
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchant.removeMerchantAccount( merchantAccount );		
			merchant = saveMerchant(userContext, merchant, tokens().withMerchantAccountList().done());
			deleteRelationInGraph(userContext, merchantAccount);
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingMerchantAccount(LscUserContext userContext, String merchantId, 
		String merchantAccountId, int merchantAccountVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchant( merchantId);
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().checkVersionOfMerchantAccount(merchantAccountVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	public  Merchant copyMerchantAccountFrom(LscUserContext userContext, String merchantId, 
		String merchantAccountId, int merchantAccountVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMerchantAccount(userContext,merchantId, merchantAccountId, merchantAccountVersion,tokensExpr);
		
		MerchantAccount merchantAccount = createIndexedMerchantAccount(merchantAccountId, merchantAccountVersion);
		Merchant merchant = loadMerchant(userContext, merchantId, allTokens());
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			merchantAccount.updateUpdateTime(userContext.now());
			
			merchant.copyMerchantAccountFrom( merchantAccount );		
			merchant = saveMerchant(userContext, merchant, tokens().withMerchantAccountList().done());
			
			userContext.getManagerGroup().getMerchantAccountManager().onNewInstanceCreated(userContext, (MerchantAccount)merchant.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingMerchantAccount(LscUserContext userContext, String merchantId, String merchantAccountId, int merchantAccountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().checkVersionOfMerchantAccount(merchantAccountVersion);
		

		if(MerchantAccount.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMerchantAccount(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantManagerException.class);
	
	}
	
	public  Merchant updateMerchantAccount(LscUserContext userContext, String merchantId, String merchantAccountId, int merchantAccountVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMerchantAccount(userContext, merchantId, merchantAccountId, merchantAccountVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withMerchantAccountList().searchMerchantAccountListWith(MerchantAccount.ID_PROPERTY, "eq", merchantAccountId).done();
		
		
		
		Merchant merchant = loadMerchant(userContext, merchantId, loadTokens);
		
		synchronized(merchant){ 
			//Will be good when the merchant loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//merchant.removeMerchantAccount( merchantAccount );	
			//make changes to AcceleraterAccount.
			MerchantAccount merchantAccountIndex = createIndexedMerchantAccount(merchantAccountId, merchantAccountVersion);
		
			MerchantAccount merchantAccount = merchant.findTheMerchantAccount(merchantAccountIndex);
			if(merchantAccount == null){
				throw new MerchantManagerException(merchantAccount+" is NOT FOUND" );
			}
			
			merchantAccount.changeProperty(property, newValueExpr);
			merchantAccount.updateUpdateTime(userContext.now());
			merchant = saveMerchant(userContext, merchant, tokens().withMerchantAccountList().done());
			return present(userContext,merchant, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, Merchant newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


