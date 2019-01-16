
package com.doublechaintech.lsc.transportitem;

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
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;

import com.doublechaintech.lsc.transportproject.CandidateTransportProject;
import com.doublechaintech.lsc.platform.CandidatePlatform;
import com.doublechaintech.lsc.merchanttype.CandidateMerchantType;







public class TransportItemManagerImpl extends CustomLscCheckerManager implements TransportItemManager {
	
	private static final String SERVICE_TYPE = "TransportItem";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransportItemManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransportItemManagerException(message);

	}
	
	

 	protected TransportItem saveTransportItem(LscUserContext userContext, TransportItem transportItem, String [] tokensExpr) throws Exception{	
 		//return getTransportItemDAO().save(transportItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportItem(userContext, transportItem, tokens);
 	}
 	
 	protected TransportItem saveTransportItemDetail(LscUserContext userContext, TransportItem transportItem) throws Exception{	

 		
 		return saveTransportItem(userContext, transportItem, allTokens());
 	}
 	
 	public TransportItem loadTransportItem(LscUserContext userContext, String transportItemId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportItem transportItem = loadTransportItem( userContext, transportItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportItem, tokens);
 	}
 	
 	
 	 public TransportItem searchTransportItem(LscUserContext userContext, String transportItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportItem transportItem = loadTransportItem( userContext, transportItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportItem, tokens);
 	}
 	
 	

 	protected TransportItem present(LscUserContext userContext, TransportItem transportItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportItem,tokens);
		
		
		TransportItem  transportItemToPresent = userContext.getDAOGroup().getTransportItemDAO().present(transportItem, tokens);
		
		List<BaseEntity> entityListToNaming = transportItemToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransportItemDAO().alias(entityListToNaming);
		
		return  transportItemToPresent;
		
		
	}
 
 	
 	
 	public TransportItem loadTransportItemDetail(LscUserContext userContext, String transportItemId) throws Exception{	
 		TransportItem transportItem = loadTransportItem( userContext, transportItemId, allTokens());
 		return present(userContext,transportItem, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String transportItemId) throws Exception{	
 		TransportItem transportItem = loadTransportItem( userContext, transportItemId, viewTokens());
 		return present(userContext,transportItem, allTokens());
		
 	}
 	protected TransportItem saveTransportItem(LscUserContext userContext, TransportItem transportItem, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransportItemDAO().save(transportItem, tokens);
 	}
 	protected TransportItem loadTransportItem(LscUserContext userContext, String transportItemId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportItemManagerException.class);

 
 		return userContext.getDAOGroup().getTransportItemDAO().load(transportItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportItem transportItem, Map<String, Object> tokens){
		super.addActions(userContext, transportItem, tokens);
		
		addAction(userContext, transportItem, tokens,"@create","createTransportItem","createTransportItem/","main","primary");
		addAction(userContext, transportItem, tokens,"@update","updateTransportItem","updateTransportItem/"+transportItem.getId()+"/","main","primary");
		addAction(userContext, transportItem, tokens,"@copy","cloneTransportItem","cloneTransportItem/"+transportItem.getId()+"/","main","primary");
		
		addAction(userContext, transportItem, tokens,"transport_item.transfer_to_project","transferToAnotherProject","transferToAnotherProject/"+transportItem.getId()+"/","main","primary");
		addAction(userContext, transportItem, tokens,"transport_item.transfer_to_merchant","transferToAnotherMerchant","transferToAnotherMerchant/"+transportItem.getId()+"/","main","primary");
		addAction(userContext, transportItem, tokens,"transport_item.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+transportItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransportItem transportItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportItem createTransportItem(LscUserContext userContext,String name, int quantity, String unit, String projectId, String merchantId, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransportItem(name);
		userContext.getChecker().checkQuantityOfTransportItem(quantity);
		userContext.getChecker().checkUnitOfTransportItem(unit);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportItemManagerException.class);


		TransportItem transportItem=createNewTransportItem();	

		transportItem.setName(name);
		transportItem.setQuantity(quantity);
		transportItem.setUnit(unit);
			
		TransportProject project = loadTransportProject(userContext, projectId,emptyOptions());
		transportItem.setProject(project);
		
		
			
		MerchantType merchant = loadMerchantType(userContext, merchantId,emptyOptions());
		transportItem.setMerchant(merchant);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		transportItem.setPlatform(platform);
		
		
		transportItem.setCreateTime(userContext.now());
		transportItem.setUpdateTime(userContext.now());

		transportItem = saveTransportItem(userContext, transportItem, emptyOptions());
		
		onNewInstanceCreated(userContext, transportItem);
		return transportItem;

		
	}
	protected TransportItem createNewTransportItem() 
	{
		
		return new TransportItem();		
	}
	
	protected void checkParamsForUpdatingTransportItem(LscUserContext userContext,String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem( transportItemVersion);
		

		if(TransportItem.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportItem(parseString(newValueExpr));
		}
		if(TransportItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfTransportItem(parseInt(newValueExpr));
		}
		if(TransportItem.UNIT_PROPERTY.equals(property)){
			userContext.getChecker().checkUnitOfTransportItem(parseString(newValueExpr));
		}		

				

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportItemManagerException.class);
	
		
	}
	
	
	
	public TransportItem clone(LscUserContext userContext, String fromTransportItemId) throws Exception{
		
		return userContext.getDAOGroup().getTransportItemDAO().clone(fromTransportItemId, this.allTokens());
	}
	
	public TransportItem internalSaveTransportItem(LscUserContext userContext, TransportItem transportItem) throws Exception 
	{
		return internalSaveTransportItem(userContext, transportItem, allTokens());

	}
	public TransportItem internalSaveTransportItem(LscUserContext userContext, TransportItem transportItem, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransportItem(userContext, transportItemId, transportItemVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transportItem){ 
			//will be good when the transportItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportItem.
			
			
			transportItem = saveTransportItem(userContext, transportItem, options);
			return transportItem;
			
		}

	}
	
	public TransportItem updateTransportItem(LscUserContext userContext,String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportItem(userContext, transportItemId, transportItemVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransportItem transportItem = loadTransportItem(userContext, transportItemId, allTokens());
		if(transportItem.getVersion() != transportItemVersion){
			String message = "The target version("+transportItem.getVersion()+") is not equals to version("+transportItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportItem){ 
			//will be good when the transportItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportItem.
			transportItem.updateUpdateTime(userContext.now());
			transportItem.changeProperty(property, newValueExpr);
			transportItem = saveTransportItem(userContext, transportItem, tokens().done());
			return present(userContext,transportItem, mergedAllTokens(tokensExpr));
			//return saveTransportItem(userContext, transportItem, tokens().done());
		}

	}
	
	public TransportItem updateTransportItemProperty(LscUserContext userContext,String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportItem(userContext, transportItemId, transportItemVersion, property, newValueExpr, tokensExpr);
		
		TransportItem transportItem = loadTransportItem(userContext, transportItemId, allTokens());
		if(transportItem.getVersion() != transportItemVersion){
			String message = "The target version("+transportItem.getVersion()+") is not equals to version("+transportItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportItem){ 
			//will be good when the transportItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportItem.
			
			transportItem.changeProperty(property, newValueExpr);
			transportItem.updateUpdateTime(userContext.now());
			transportItem = saveTransportItem(userContext, transportItem, tokens().done());
			return present(userContext,transportItem, mergedAllTokens(tokensExpr));
			//return saveTransportItem(userContext, transportItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportItemTokens tokens(){
		return TransportItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProject(LscUserContext userContext, String transportItemId, String anotherProjectId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportItem(transportItemId);
 		userContext.getChecker().checkIdOfTransportProject(anotherProjectId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportItemManagerException.class);
 		
 	}
 	public TransportItem transferToAnotherProject(LscUserContext userContext, String transportItemId, String anotherProjectId) throws Exception
 	{
 		checkParamsForTransferingAnotherProject(userContext, transportItemId,anotherProjectId);
 
		TransportItem transportItem = loadTransportItem(userContext, transportItemId, allTokens());	
		synchronized(transportItem){
			//will be good when the transportItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportProject project = loadTransportProject(userContext, anotherProjectId, emptyOptions());		
			transportItem.updateProject(project);		
			transportItem = saveTransportItem(userContext, transportItem, emptyOptions());
			
			return present(userContext,transportItem, allTokens());
			
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
		SmartList<TransportProject> candidateList = userContext.getDAOGroup().getTransportProjectDAO().requestCandidateTransportProjectForTransportItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherMerchant(LscUserContext userContext, String transportItemId, String anotherMerchantId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportItem(transportItemId);
 		userContext.getChecker().checkIdOfMerchantType(anotherMerchantId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportItemManagerException.class);
 		
 	}
 	public TransportItem transferToAnotherMerchant(LscUserContext userContext, String transportItemId, String anotherMerchantId) throws Exception
 	{
 		checkParamsForTransferingAnotherMerchant(userContext, transportItemId,anotherMerchantId);
 
		TransportItem transportItem = loadTransportItem(userContext, transportItemId, allTokens());	
		synchronized(transportItem){
			//will be good when the transportItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			MerchantType merchant = loadMerchantType(userContext, anotherMerchantId, emptyOptions());		
			transportItem.updateMerchant(merchant);		
			transportItem = saveTransportItem(userContext, transportItem, emptyOptions());
			
			return present(userContext,transportItem, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateMerchantType requestCandidateMerchant(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<MerchantType> candidateList = userContext.getDAOGroup().getMerchantTypeDAO().requestCandidateMerchantTypeForTransportItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(LscUserContext userContext, String transportItemId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportItem(transportItemId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportItemManagerException.class);
 		
 	}
 	public TransportItem transferToAnotherPlatform(LscUserContext userContext, String transportItemId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, transportItemId,anotherPlatformId);
 
		TransportItem transportItem = loadTransportItem(userContext, transportItemId, allTokens());	
		synchronized(transportItem){
			//will be good when the transportItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			transportItem.updatePlatform(platform);		
			transportItem = saveTransportItem(userContext, transportItem, emptyOptions());
			
			return present(userContext,transportItem, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForTransportItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(LscUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	 	
 	protected MerchantType loadMerchantType(LscUserContext userContext, String newMerchantId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getMerchantTypeDAO().load(newMerchantId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String transportItemId, int transportItemVersion) throws Exception {
		//deleteInternal(userContext, transportItemId, transportItemVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String transportItemId, int transportItemVersion) throws Exception{
			
		userContext.getDAOGroup().getTransportItemDAO().delete(transportItemId, transportItemVersion);
	}
	
	public TransportItem forgetByAll(LscUserContext userContext, String transportItemId, int transportItemVersion) throws Exception {
		return forgetByAllInternal(userContext, transportItemId, transportItemVersion);		
	}
	protected TransportItem forgetByAllInternal(LscUserContext userContext,
			String transportItemId, int transportItemVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransportItemDAO().disconnectFromAll(transportItemId, transportItemVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransportItemDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(LscUserContext userContext, TransportItem newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


