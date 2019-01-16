
package com.doublechaintech.lsc.transactiontype;

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

import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transaction.Transaction;

import com.doublechaintech.lsc.platform.CandidatePlatform;

import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.transactiontype.TransactionType;






public class TransactionTypeManagerImpl extends CustomLscCheckerManager implements TransactionTypeManager {
	
	private static final String SERVICE_TYPE = "TransactionType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransactionTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransactionTypeManagerException(message);

	}
	
	

 	protected TransactionType saveTransactionType(LscUserContext userContext, TransactionType transactionType, String [] tokensExpr) throws Exception{	
 		//return getTransactionTypeDAO().save(transactionType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransactionType(userContext, transactionType, tokens);
 	}
 	
 	protected TransactionType saveTransactionTypeDetail(LscUserContext userContext, TransactionType transactionType) throws Exception{	

 		
 		return saveTransactionType(userContext, transactionType, allTokens());
 	}
 	
 	public TransactionType loadTransactionType(LscUserContext userContext, String transactionTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransactionType transactionType = loadTransactionType( userContext, transactionTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transactionType, tokens);
 	}
 	
 	
 	 public TransactionType searchTransactionType(LscUserContext userContext, String transactionTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransactionType transactionType = loadTransactionType( userContext, transactionTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transactionType, tokens);
 	}
 	
 	

 	protected TransactionType present(LscUserContext userContext, TransactionType transactionType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transactionType,tokens);
		
		
		TransactionType  transactionTypeToPresent = userContext.getDAOGroup().getTransactionTypeDAO().present(transactionType, tokens);
		
		List<BaseEntity> entityListToNaming = transactionTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransactionTypeDAO().alias(entityListToNaming);
		
		return  transactionTypeToPresent;
		
		
	}
 
 	
 	
 	public TransactionType loadTransactionTypeDetail(LscUserContext userContext, String transactionTypeId) throws Exception{	
 		TransactionType transactionType = loadTransactionType( userContext, transactionTypeId, allTokens());
 		return present(userContext,transactionType, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String transactionTypeId) throws Exception{	
 		TransactionType transactionType = loadTransactionType( userContext, transactionTypeId, viewTokens());
 		return present(userContext,transactionType, allTokens());
		
 	}
 	protected TransactionType saveTransactionType(LscUserContext userContext, TransactionType transactionType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransactionTypeDAO().save(transactionType, tokens);
 	}
 	protected TransactionType loadTransactionType(LscUserContext userContext, String transactionTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionTypeManagerException.class);

 
 		return userContext.getDAOGroup().getTransactionTypeDAO().load(transactionTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransactionType transactionType, Map<String, Object> tokens){
		super.addActions(userContext, transactionType, tokens);
		
		addAction(userContext, transactionType, tokens,"@create","createTransactionType","createTransactionType/","main","primary");
		addAction(userContext, transactionType, tokens,"@update","updateTransactionType","updateTransactionType/"+transactionType.getId()+"/","main","primary");
		addAction(userContext, transactionType, tokens,"@copy","cloneTransactionType","cloneTransactionType/"+transactionType.getId()+"/","main","primary");
		
		addAction(userContext, transactionType, tokens,"transaction_type.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+transactionType.getId()+"/","main","primary");
		addAction(userContext, transactionType, tokens,"transaction_type.addTransaction","addTransaction","addTransaction/"+transactionType.getId()+"/","transactionList","primary");
		addAction(userContext, transactionType, tokens,"transaction_type.removeTransaction","removeTransaction","removeTransaction/"+transactionType.getId()+"/","transactionList","primary");
		addAction(userContext, transactionType, tokens,"transaction_type.updateTransaction","updateTransaction","updateTransaction/"+transactionType.getId()+"/","transactionList","primary");
		addAction(userContext, transactionType, tokens,"transaction_type.copyTransactionFrom","copyTransactionFrom","copyTransactionFrom/"+transactionType.getId()+"/","transactionList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, TransactionType transactionType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransactionType createTransactionType(LscUserContext userContext,String name, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransactionType(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);


		TransactionType transactionType=createNewTransactionType();	

		transactionType.setName(name);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		transactionType.setPlatform(platform);
		
		

		transactionType = saveTransactionType(userContext, transactionType, emptyOptions());
		
		onNewInstanceCreated(userContext, transactionType);
		return transactionType;

		
	}
	protected TransactionType createNewTransactionType() 
	{
		
		return new TransactionType();		
	}
	
	protected void checkParamsForUpdatingTransactionType(LscUserContext userContext,String transactionTypeId, int transactionTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().checkVersionOfTransactionType( transactionTypeVersion);
		

		if(TransactionType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransactionType(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);
	
		
	}
	
	
	
	public TransactionType clone(LscUserContext userContext, String fromTransactionTypeId) throws Exception{
		
		return userContext.getDAOGroup().getTransactionTypeDAO().clone(fromTransactionTypeId, this.allTokens());
	}
	
	public TransactionType internalSaveTransactionType(LscUserContext userContext, TransactionType transactionType) throws Exception 
	{
		return internalSaveTransactionType(userContext, transactionType, allTokens());

	}
	public TransactionType internalSaveTransactionType(LscUserContext userContext, TransactionType transactionType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransactionType(userContext, transactionTypeId, transactionTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transactionType){ 
			//will be good when the transactionType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransactionType.
			
			
			transactionType = saveTransactionType(userContext, transactionType, options);
			return transactionType;
			
		}

	}
	
	public TransactionType updateTransactionType(LscUserContext userContext,String transactionTypeId, int transactionTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransactionType(userContext, transactionTypeId, transactionTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, allTokens());
		if(transactionType.getVersion() != transactionTypeVersion){
			String message = "The target version("+transactionType.getVersion()+") is not equals to version("+transactionTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transactionType){ 
			//will be good when the transactionType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransactionType.
			
			transactionType.changeProperty(property, newValueExpr);
			transactionType = saveTransactionType(userContext, transactionType, tokens().done());
			return present(userContext,transactionType, mergedAllTokens(tokensExpr));
			//return saveTransactionType(userContext, transactionType, tokens().done());
		}

	}
	
	public TransactionType updateTransactionTypeProperty(LscUserContext userContext,String transactionTypeId, int transactionTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransactionType(userContext, transactionTypeId, transactionTypeVersion, property, newValueExpr, tokensExpr);
		
		TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, allTokens());
		if(transactionType.getVersion() != transactionTypeVersion){
			String message = "The target version("+transactionType.getVersion()+") is not equals to version("+transactionTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transactionType){ 
			//will be good when the transactionType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransactionType.
			
			transactionType.changeProperty(property, newValueExpr);
			
			transactionType = saveTransactionType(userContext, transactionType, tokens().done());
			return present(userContext,transactionType, mergedAllTokens(tokensExpr));
			//return saveTransactionType(userContext, transactionType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransactionTypeTokens tokens(){
		return TransactionTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransactionTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransactionListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransactionTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(LscUserContext userContext, String transactionTypeId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);
 		
 	}
 	public TransactionType transferToAnotherPlatform(LscUserContext userContext, String transactionTypeId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, transactionTypeId,anotherPlatformId);
 
		TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, allTokens());	
		synchronized(transactionType){
			//will be good when the transactionType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			transactionType.updatePlatform(platform);		
			transactionType = saveTransactionType(userContext, transactionType, emptyOptions());
			
			return present(userContext,transactionType, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForTransactionType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(LscUserContext userContext, String transactionTypeId, int transactionTypeVersion) throws Exception {
		//deleteInternal(userContext, transactionTypeId, transactionTypeVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String transactionTypeId, int transactionTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getTransactionTypeDAO().delete(transactionTypeId, transactionTypeVersion);
	}
	
	public TransactionType forgetByAll(LscUserContext userContext, String transactionTypeId, int transactionTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, transactionTypeId, transactionTypeVersion);		
	}
	protected TransactionType forgetByAllInternal(LscUserContext userContext,
			String transactionTypeId, int transactionTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransactionTypeDAO().disconnectFromAll(transactionTypeId, transactionTypeVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransactionTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransactionTypeDAO().deleteAll();
	}


	//disconnect TransactionType with account in Transaction
	protected TransactionType breakWithTransactionByAccount(LscUserContext userContext, String transactionTypeId, String accountId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, allTokens());

			synchronized(transactionType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransactionTypeDAO().planToRemoveTransactionListWithAccount(transactionType, accountId, this.emptyOptions());

				transactionType = saveTransactionType(userContext, transactionType, tokens().withTransactionList().done());
				return transactionType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransaction(LscUserContext userContext, String transactionTypeId, String name, BigDecimal amount, String accountId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);

		
		userContext.getChecker().checkNameOfTransaction(name);
		
		userContext.getChecker().checkAmountOfTransaction(amount);
		
		userContext.getChecker().checkAccountIdOfTransaction(accountId);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);

	
	}
	public  TransactionType addTransaction(LscUserContext userContext, String transactionTypeId, String name, BigDecimal amount, String accountId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransaction(userContext,transactionTypeId,name, amount, accountId,tokensExpr);
		
		Transaction transaction = createTransaction(userContext,name, amount, accountId);
		
		TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, allTokens());
		synchronized(transactionType){ 
			//Will be good when the transactionType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transactionType.addTransaction( transaction );		
			transactionType = saveTransactionType(userContext, transactionType, tokens().withTransactionList().done());
			
			userContext.getManagerGroup().getTransactionManager().onNewInstanceCreated(userContext, transaction);
			return present(userContext,transactionType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransactionProperties(LscUserContext userContext, String transactionTypeId,String id,String name,BigDecimal amount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().checkIdOfTransaction(id);
		
		userContext.getChecker().checkNameOfTransaction( name);
		userContext.getChecker().checkAmountOfTransaction( amount);

		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);
		
	}
	public  TransactionType updateTransactionProperties(LscUserContext userContext, String transactionTypeId, String id,String name,BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransactionProperties(userContext,transactionTypeId,id,name,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransactionListList()
				.searchTransactionListWith(Transaction.ID_PROPERTY, "is", id).done();
		
		TransactionType transactionTypeToUpdate = loadTransactionType(userContext, transactionTypeId, options);
		
		if(transactionTypeToUpdate.getTransactionList().isEmpty()){
			throw new TransactionTypeManagerException("Transaction is NOT FOUND with id: '"+id+"'");
		}
		
		Transaction item = transactionTypeToUpdate.getTransactionList().first();
		
		item.updateName( name );
		item.updateAmount( amount );

		
		//checkParamsForAddingTransaction(userContext,transactionTypeId,name, code, used,tokensExpr);
		TransactionType transactionType = saveTransactionType(userContext, transactionTypeToUpdate, tokens().withTransactionList().done());
		synchronized(transactionType){ 
			return present(userContext,transactionType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Transaction createTransaction(LscUserContext userContext, String name, BigDecimal amount, String accountId) throws Exception{

		Transaction transaction = new Transaction();
		
		
		transaction.setName(name);		
		transaction.setAmount(amount);		
		MerchantAccount  account = new MerchantAccount();
		account.setId(accountId);		
		transaction.setAccount(account);
	
		
		return transaction;
	
		
	}
	
	protected Transaction createIndexedTransaction(String id, int version){

		Transaction transaction = new Transaction();
		transaction.setId(id);
		transaction.setVersion(version);
		return transaction;			
		
	}
	
	protected void checkParamsForRemovingTransactionList(LscUserContext userContext, String transactionTypeId, 
			String transactionIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		for(String transactionId: transactionIds){
			userContext.getChecker().checkIdOfTransaction(transactionId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);
		
	}
	public  TransactionType removeTransactionList(LscUserContext userContext, String transactionTypeId, 
			String transactionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransactionList(userContext, transactionTypeId,  transactionIds, tokensExpr);
			
			
			TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, allTokens());
			synchronized(transactionType){ 
				//Will be good when the transactionType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransactionTypeDAO().planToRemoveTransactionList(transactionType, transactionIds, allTokens());
				transactionType = saveTransactionType(userContext, transactionType, tokens().withTransactionList().done());
				deleteRelationListInGraph(userContext, transactionType.getTransactionList());
				return present(userContext,transactionType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransaction(LscUserContext userContext, String transactionTypeId, 
		String transactionId, int transactionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransactionType( transactionTypeId);
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().checkVersionOfTransaction(transactionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);
	
	}
	public  TransactionType removeTransaction(LscUserContext userContext, String transactionTypeId, 
		String transactionId, int transactionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransaction(userContext,transactionTypeId, transactionId, transactionVersion,tokensExpr);
		
		Transaction transaction = createIndexedTransaction(transactionId, transactionVersion);
		TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, allTokens());
		synchronized(transactionType){ 
			//Will be good when the transactionType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transactionType.removeTransaction( transaction );		
			transactionType = saveTransactionType(userContext, transactionType, tokens().withTransactionList().done());
			deleteRelationInGraph(userContext, transaction);
			return present(userContext,transactionType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransaction(LscUserContext userContext, String transactionTypeId, 
		String transactionId, int transactionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransactionType( transactionTypeId);
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().checkVersionOfTransaction(transactionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);
	
	}
	public  TransactionType copyTransactionFrom(LscUserContext userContext, String transactionTypeId, 
		String transactionId, int transactionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransaction(userContext,transactionTypeId, transactionId, transactionVersion,tokensExpr);
		
		Transaction transaction = createIndexedTransaction(transactionId, transactionVersion);
		TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, allTokens());
		synchronized(transactionType){ 
			//Will be good when the transactionType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			transactionType.copyTransactionFrom( transaction );		
			transactionType = saveTransactionType(userContext, transactionType, tokens().withTransactionList().done());
			
			userContext.getManagerGroup().getTransactionManager().onNewInstanceCreated(userContext, (Transaction)transactionType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transactionType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransaction(LscUserContext userContext, String transactionTypeId, String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransactionType(transactionTypeId);
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().checkVersionOfTransaction(transactionVersion);
		

		if(Transaction.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransaction(parseString(newValueExpr));
		}
		
		if(Transaction.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfTransaction(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransactionTypeManagerException.class);
	
	}
	
	public  TransactionType updateTransaction(LscUserContext userContext, String transactionTypeId, String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransaction(userContext, transactionTypeId, transactionId, transactionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransactionList().searchTransactionListWith(Transaction.ID_PROPERTY, "eq", transactionId).done();
		
		
		
		TransactionType transactionType = loadTransactionType(userContext, transactionTypeId, loadTokens);
		
		synchronized(transactionType){ 
			//Will be good when the transactionType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transactionType.removeTransaction( transaction );	
			//make changes to AcceleraterAccount.
			Transaction transactionIndex = createIndexedTransaction(transactionId, transactionVersion);
		
			Transaction transaction = transactionType.findTheTransaction(transactionIndex);
			if(transaction == null){
				throw new TransactionTypeManagerException(transaction+" is NOT FOUND" );
			}
			
			transaction.changeProperty(property, newValueExpr);
			
			transactionType = saveTransactionType(userContext, transactionType, tokens().withTransactionList().done());
			return present(userContext,transactionType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, TransactionType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


