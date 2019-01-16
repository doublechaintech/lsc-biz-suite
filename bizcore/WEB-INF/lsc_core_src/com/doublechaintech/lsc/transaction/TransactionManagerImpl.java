
package com.doublechaintech.lsc.transaction;

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

import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.transactiontype.TransactionType;

import com.doublechaintech.lsc.merchantaccount.CandidateMerchantAccount;
import com.doublechaintech.lsc.transactiontype.CandidateTransactionType;







public class TransactionManagerImpl extends CustomLscCheckerManager implements TransactionManager {
	
	private static final String SERVICE_TYPE = "Transaction";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransactionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransactionManagerException(message);

	}
	
	

 	protected Transaction saveTransaction(LscUserContext userContext, Transaction transaction, String [] tokensExpr) throws Exception{	
 		//return getTransactionDAO().save(transaction, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransaction(userContext, transaction, tokens);
 	}
 	
 	protected Transaction saveTransactionDetail(LscUserContext userContext, Transaction transaction) throws Exception{	

 		
 		return saveTransaction(userContext, transaction, allTokens());
 	}
 	
 	public Transaction loadTransaction(LscUserContext userContext, String transactionId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Transaction transaction = loadTransaction( userContext, transactionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transaction, tokens);
 	}
 	
 	
 	 public Transaction searchTransaction(LscUserContext userContext, String transactionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Transaction transaction = loadTransaction( userContext, transactionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transaction, tokens);
 	}
 	
 	

 	protected Transaction present(LscUserContext userContext, Transaction transaction, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transaction,tokens);
		
		
		Transaction  transactionToPresent = userContext.getDAOGroup().getTransactionDAO().present(transaction, tokens);
		
		List<BaseEntity> entityListToNaming = transactionToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransactionDAO().alias(entityListToNaming);
		
		return  transactionToPresent;
		
		
	}
 
 	
 	
 	public Transaction loadTransactionDetail(LscUserContext userContext, String transactionId) throws Exception{	
 		Transaction transaction = loadTransaction( userContext, transactionId, allTokens());
 		return present(userContext,transaction, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String transactionId) throws Exception{	
 		Transaction transaction = loadTransaction( userContext, transactionId, viewTokens());
 		return present(userContext,transaction, allTokens());
		
 	}
 	protected Transaction saveTransaction(LscUserContext userContext, Transaction transaction, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransactionDAO().save(transaction, tokens);
 	}
 	protected Transaction loadTransaction(LscUserContext userContext, String transactionId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().throwExceptionIfHasErrors( TransactionManagerException.class);

 
 		return userContext.getDAOGroup().getTransactionDAO().load(transactionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, Transaction transaction, Map<String, Object> tokens){
		super.addActions(userContext, transaction, tokens);
		
		addAction(userContext, transaction, tokens,"@create","createTransaction","createTransaction/","main","primary");
		addAction(userContext, transaction, tokens,"@update","updateTransaction","updateTransaction/"+transaction.getId()+"/","main","primary");
		addAction(userContext, transaction, tokens,"@copy","cloneTransaction","cloneTransaction/"+transaction.getId()+"/","main","primary");
		
		addAction(userContext, transaction, tokens,"transaction.transfer_to_transaction_type","transferToAnotherTransactionType","transferToAnotherTransactionType/"+transaction.getId()+"/","main","primary");
		addAction(userContext, transaction, tokens,"transaction.transfer_to_account","transferToAnotherAccount","transferToAnotherAccount/"+transaction.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, Transaction transaction, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Transaction createTransaction(LscUserContext userContext,String name, BigDecimal amount, String transactionTypeId, String accountId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransaction(name);
		userContext.getChecker().checkAmountOfTransaction(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);


		Transaction transaction=createNewTransaction();	

		transaction.setName(name);
		transaction.setAmount(amount);
			
		TransactionType transactionType = loadTransactionType(userContext, transactionTypeId,emptyOptions());
		transaction.setTransactionType(transactionType);
		
		
			
		MerchantAccount account = loadMerchantAccount(userContext, accountId,emptyOptions());
		transaction.setAccount(account);
		
		

		transaction = saveTransaction(userContext, transaction, emptyOptions());
		
		onNewInstanceCreated(userContext, transaction);
		return transaction;

		
	}
	protected Transaction createNewTransaction() 
	{
		
		return new Transaction();		
	}
	
	protected void checkParamsForUpdatingTransaction(LscUserContext userContext,String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().checkVersionOfTransaction( transactionVersion);
		

		if(Transaction.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransaction(parseString(newValueExpr));
		}
		if(Transaction.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfTransaction(parseBigDecimal(newValueExpr));
		}		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
	
		
	}
	
	
	
	public Transaction clone(LscUserContext userContext, String fromTransactionId) throws Exception{
		
		return userContext.getDAOGroup().getTransactionDAO().clone(fromTransactionId, this.allTokens());
	}
	
	public Transaction internalSaveTransaction(LscUserContext userContext, Transaction transaction) throws Exception 
	{
		return internalSaveTransaction(userContext, transaction, allTokens());

	}
	public Transaction internalSaveTransaction(LscUserContext userContext, Transaction transaction, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransaction(userContext, transactionId, transactionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transaction){ 
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Transaction.
			
			
			transaction = saveTransaction(userContext, transaction, options);
			return transaction;
			
		}

	}
	
	public Transaction updateTransaction(LscUserContext userContext,String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransaction(userContext, transactionId, transactionVersion, property, newValueExpr, tokensExpr);
		
		
		
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());
		if(transaction.getVersion() != transactionVersion){
			String message = "The target version("+transaction.getVersion()+") is not equals to version("+transactionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transaction){ 
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Transaction.
			
			transaction.changeProperty(property, newValueExpr);
			transaction = saveTransaction(userContext, transaction, tokens().done());
			return present(userContext,transaction, mergedAllTokens(tokensExpr));
			//return saveTransaction(userContext, transaction, tokens().done());
		}

	}
	
	public Transaction updateTransactionProperty(LscUserContext userContext,String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransaction(userContext, transactionId, transactionVersion, property, newValueExpr, tokensExpr);
		
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());
		if(transaction.getVersion() != transactionVersion){
			String message = "The target version("+transaction.getVersion()+") is not equals to version("+transactionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transaction){ 
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Transaction.
			
			transaction.changeProperty(property, newValueExpr);
			
			transaction = saveTransaction(userContext, transaction, tokens().done());
			return present(userContext,transaction, mergedAllTokens(tokensExpr));
			//return saveTransaction(userContext, transaction, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransactionTokens tokens(){
		return TransactionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransactionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransactionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherTransactionType(LscUserContext userContext, String transactionId, String anotherTransactionTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransaction(transactionId);
 		userContext.getChecker().checkIdOfTransactionType(anotherTransactionTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
 		
 	}
 	public Transaction transferToAnotherTransactionType(LscUserContext userContext, String transactionId, String anotherTransactionTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherTransactionType(userContext, transactionId,anotherTransactionTypeId);
 
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());	
		synchronized(transaction){
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransactionType transactionType = loadTransactionType(userContext, anotherTransactionTypeId, emptyOptions());		
			transaction.updateTransactionType(transactionType);		
			transaction = saveTransaction(userContext, transaction, emptyOptions());
			
			return present(userContext,transaction, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTransactionType requestCandidateTransactionType(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransactionType result = new CandidateTransactionType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransactionType> candidateList = userContext.getDAOGroup().getTransactionTypeDAO().requestCandidateTransactionTypeForTransaction(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherAccount(LscUserContext userContext, String transactionId, String anotherAccountId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransaction(transactionId);
 		userContext.getChecker().checkIdOfMerchantAccount(anotherAccountId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransactionManagerException.class);
 		
 	}
 	public Transaction transferToAnotherAccount(LscUserContext userContext, String transactionId, String anotherAccountId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccount(userContext, transactionId,anotherAccountId);
 
		Transaction transaction = loadTransaction(userContext, transactionId, allTokens());	
		synchronized(transaction){
			//will be good when the transaction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			MerchantAccount account = loadMerchantAccount(userContext, anotherAccountId, emptyOptions());		
			transaction.updateAccount(account);		
			transaction = saveTransaction(userContext, transaction, emptyOptions());
			
			return present(userContext,transaction, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateMerchantAccount requestCandidateAccount(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateMerchantAccount result = new CandidateMerchantAccount();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<MerchantAccount> candidateList = userContext.getDAOGroup().getMerchantAccountDAO().requestCandidateMerchantAccountForTransaction(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected MerchantAccount loadMerchantAccount(LscUserContext userContext, String newAccountId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getMerchantAccountDAO().load(newAccountId, options);
 	}
 	
 	
 	
	
	 	
 	protected TransactionType loadTransactionType(LscUserContext userContext, String newTransactionTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTransactionTypeDAO().load(newTransactionTypeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String transactionId, int transactionVersion) throws Exception {
		//deleteInternal(userContext, transactionId, transactionVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String transactionId, int transactionVersion) throws Exception{
			
		userContext.getDAOGroup().getTransactionDAO().delete(transactionId, transactionVersion);
	}
	
	public Transaction forgetByAll(LscUserContext userContext, String transactionId, int transactionVersion) throws Exception {
		return forgetByAllInternal(userContext, transactionId, transactionVersion);		
	}
	protected Transaction forgetByAllInternal(LscUserContext userContext,
			String transactionId, int transactionVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransactionDAO().disconnectFromAll(transactionId, transactionVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransactionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransactionDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(LscUserContext userContext, Transaction newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


