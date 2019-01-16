
package com.doublechaintech.lsc.merchantaccount;

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
import com.doublechaintech.lsc.transaction.Transaction;

import com.doublechaintech.lsc.merchant.CandidateMerchant;

import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.transactiontype.TransactionType;






public class MerchantAccountManagerImpl extends CustomLscCheckerManager implements MerchantAccountManager {
	
	private static final String SERVICE_TYPE = "MerchantAccount";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws MerchantAccountManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new MerchantAccountManagerException(message);

	}
	
	

 	protected MerchantAccount saveMerchantAccount(LscUserContext userContext, MerchantAccount merchantAccount, String [] tokensExpr) throws Exception{	
 		//return getMerchantAccountDAO().save(merchantAccount, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMerchantAccount(userContext, merchantAccount, tokens);
 	}
 	
 	protected MerchantAccount saveMerchantAccountDetail(LscUserContext userContext, MerchantAccount merchantAccount) throws Exception{	

 		
 		return saveMerchantAccount(userContext, merchantAccount, allTokens());
 	}
 	
 	public MerchantAccount loadMerchantAccount(LscUserContext userContext, String merchantAccountId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantAccountManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MerchantAccount merchantAccount = loadMerchantAccount( userContext, merchantAccountId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,merchantAccount, tokens);
 	}
 	
 	
 	 public MerchantAccount searchMerchantAccount(LscUserContext userContext, String merchantAccountId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantAccountManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		MerchantAccount merchantAccount = loadMerchantAccount( userContext, merchantAccountId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,merchantAccount, tokens);
 	}
 	
 	

 	protected MerchantAccount present(LscUserContext userContext, MerchantAccount merchantAccount, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,merchantAccount,tokens);
		
		
		MerchantAccount  merchantAccountToPresent = userContext.getDAOGroup().getMerchantAccountDAO().present(merchantAccount, tokens);
		
		List<BaseEntity> entityListToNaming = merchantAccountToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getMerchantAccountDAO().alias(entityListToNaming);
		
		return  merchantAccountToPresent;
		
		
	}
 
 	
 	
 	public MerchantAccount loadMerchantAccountDetail(LscUserContext userContext, String merchantAccountId) throws Exception{	
 		MerchantAccount merchantAccount = loadMerchantAccount( userContext, merchantAccountId, allTokens());
 		return present(userContext,merchantAccount, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String merchantAccountId) throws Exception{	
 		MerchantAccount merchantAccount = loadMerchantAccount( userContext, merchantAccountId, viewTokens());
 		return present(userContext,merchantAccount, allTokens());
		
 	}
 	protected MerchantAccount saveMerchantAccount(LscUserContext userContext, MerchantAccount merchantAccount, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getMerchantAccountDAO().save(merchantAccount, tokens);
 	}
 	protected MerchantAccount loadMerchantAccount(LscUserContext userContext, String merchantAccountId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantAccountManagerException.class);

 
 		return userContext.getDAOGroup().getMerchantAccountDAO().load(merchantAccountId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, MerchantAccount merchantAccount, Map<String, Object> tokens){
		super.addActions(userContext, merchantAccount, tokens);
		
		addAction(userContext, merchantAccount, tokens,"@create","createMerchantAccount","createMerchantAccount/","main","primary");
		addAction(userContext, merchantAccount, tokens,"@update","updateMerchantAccount","updateMerchantAccount/"+merchantAccount.getId()+"/","main","primary");
		addAction(userContext, merchantAccount, tokens,"@copy","cloneMerchantAccount","cloneMerchantAccount/"+merchantAccount.getId()+"/","main","primary");
		
		addAction(userContext, merchantAccount, tokens,"merchant_account.transfer_to_merchant","transferToAnotherMerchant","transferToAnotherMerchant/"+merchantAccount.getId()+"/","main","primary");
		addAction(userContext, merchantAccount, tokens,"merchant_account.addTransaction","addTransaction","addTransaction/"+merchantAccount.getId()+"/","transactionList","primary");
		addAction(userContext, merchantAccount, tokens,"merchant_account.removeTransaction","removeTransaction","removeTransaction/"+merchantAccount.getId()+"/","transactionList","primary");
		addAction(userContext, merchantAccount, tokens,"merchant_account.updateTransaction","updateTransaction","updateTransaction/"+merchantAccount.getId()+"/","transactionList","primary");
		addAction(userContext, merchantAccount, tokens,"merchant_account.copyTransactionFrom","copyTransactionFrom","copyTransactionFrom/"+merchantAccount.getId()+"/","transactionList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, MerchantAccount merchantAccount, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MerchantAccount createMerchantAccount(LscUserContext userContext,String name, String merchantId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfMerchantAccount(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);


		MerchantAccount merchantAccount=createNewMerchantAccount();	

		merchantAccount.setName(name);
			
		Merchant merchant = loadMerchant(userContext, merchantId,emptyOptions());
		merchantAccount.setMerchant(merchant);
		
		
		merchantAccount.setCreateTime(userContext.now());
		merchantAccount.setUpdateTime(userContext.now());

		merchantAccount = saveMerchantAccount(userContext, merchantAccount, emptyOptions());
		
		onNewInstanceCreated(userContext, merchantAccount);
		return merchantAccount;

		
	}
	protected MerchantAccount createNewMerchantAccount() 
	{
		
		return new MerchantAccount();		
	}
	
	protected void checkParamsForUpdatingMerchantAccount(LscUserContext userContext,String merchantAccountId, int merchantAccountVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().checkVersionOfMerchantAccount( merchantAccountVersion);
		

		if(MerchantAccount.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMerchantAccount(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);
	
		
	}
	
	
	
	public MerchantAccount clone(LscUserContext userContext, String fromMerchantAccountId) throws Exception{
		
		return userContext.getDAOGroup().getMerchantAccountDAO().clone(fromMerchantAccountId, this.allTokens());
	}
	
	public MerchantAccount internalSaveMerchantAccount(LscUserContext userContext, MerchantAccount merchantAccount) throws Exception 
	{
		return internalSaveMerchantAccount(userContext, merchantAccount, allTokens());

	}
	public MerchantAccount internalSaveMerchantAccount(LscUserContext userContext, MerchantAccount merchantAccount, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingMerchantAccount(userContext, merchantAccountId, merchantAccountVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(merchantAccount){ 
			//will be good when the merchantAccount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MerchantAccount.
			
			
			merchantAccount = saveMerchantAccount(userContext, merchantAccount, options);
			return merchantAccount;
			
		}

	}
	
	public MerchantAccount updateMerchantAccount(LscUserContext userContext,String merchantAccountId, int merchantAccountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMerchantAccount(userContext, merchantAccountId, merchantAccountVersion, property, newValueExpr, tokensExpr);
		
		
		
		MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, allTokens());
		if(merchantAccount.getVersion() != merchantAccountVersion){
			String message = "The target version("+merchantAccount.getVersion()+") is not equals to version("+merchantAccountVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(merchantAccount){ 
			//will be good when the merchantAccount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MerchantAccount.
			merchantAccount.updateUpdateTime(userContext.now());
			merchantAccount.changeProperty(property, newValueExpr);
			merchantAccount = saveMerchantAccount(userContext, merchantAccount, tokens().done());
			return present(userContext,merchantAccount, mergedAllTokens(tokensExpr));
			//return saveMerchantAccount(userContext, merchantAccount, tokens().done());
		}

	}
	
	public MerchantAccount updateMerchantAccountProperty(LscUserContext userContext,String merchantAccountId, int merchantAccountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMerchantAccount(userContext, merchantAccountId, merchantAccountVersion, property, newValueExpr, tokensExpr);
		
		MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, allTokens());
		if(merchantAccount.getVersion() != merchantAccountVersion){
			String message = "The target version("+merchantAccount.getVersion()+") is not equals to version("+merchantAccountVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(merchantAccount){ 
			//will be good when the merchantAccount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MerchantAccount.
			
			merchantAccount.changeProperty(property, newValueExpr);
			merchantAccount.updateUpdateTime(userContext.now());
			merchantAccount = saveMerchantAccount(userContext, merchantAccount, tokens().done());
			return present(userContext,merchantAccount, mergedAllTokens(tokensExpr));
			//return saveMerchantAccount(userContext, merchantAccount, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MerchantAccountTokens tokens(){
		return MerchantAccountTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MerchantAccountTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransactionListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MerchantAccountTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherMerchant(LscUserContext userContext, String merchantAccountId, String anotherMerchantId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
 		userContext.getChecker().checkIdOfMerchant(anotherMerchantId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);
 		
 	}
 	public MerchantAccount transferToAnotherMerchant(LscUserContext userContext, String merchantAccountId, String anotherMerchantId) throws Exception
 	{
 		checkParamsForTransferingAnotherMerchant(userContext, merchantAccountId,anotherMerchantId);
 
		MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, allTokens());	
		synchronized(merchantAccount){
			//will be good when the merchantAccount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Merchant merchant = loadMerchant(userContext, anotherMerchantId, emptyOptions());		
			merchantAccount.updateMerchant(merchant);		
			merchantAccount = saveMerchantAccount(userContext, merchantAccount, emptyOptions());
			
			return present(userContext,merchantAccount, allTokens());
			
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
		SmartList<Merchant> candidateList = userContext.getDAOGroup().getMerchantDAO().requestCandidateMerchantForMerchantAccount(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String merchantAccountId, int merchantAccountVersion) throws Exception {
		//deleteInternal(userContext, merchantAccountId, merchantAccountVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String merchantAccountId, int merchantAccountVersion) throws Exception{
			
		userContext.getDAOGroup().getMerchantAccountDAO().delete(merchantAccountId, merchantAccountVersion);
	}
	
	public MerchantAccount forgetByAll(LscUserContext userContext, String merchantAccountId, int merchantAccountVersion) throws Exception {
		return forgetByAllInternal(userContext, merchantAccountId, merchantAccountVersion);		
	}
	protected MerchantAccount forgetByAllInternal(LscUserContext userContext,
			String merchantAccountId, int merchantAccountVersion) throws Exception{
			
		return userContext.getDAOGroup().getMerchantAccountDAO().disconnectFromAll(merchantAccountId, merchantAccountVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MerchantAccountManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getMerchantAccountDAO().deleteAll();
	}


	//disconnect MerchantAccount with transaction_type in Transaction
	protected MerchantAccount breakWithTransactionByTransactionType(LscUserContext userContext, String merchantAccountId, String transactionTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, allTokens());

			synchronized(merchantAccount){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantAccountDAO().planToRemoveTransactionListWithTransactionType(merchantAccount, transactionTypeId, this.emptyOptions());

				merchantAccount = saveMerchantAccount(userContext, merchantAccount, tokens().withTransactionList().done());
				return merchantAccount;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransaction(LscUserContext userContext, String merchantAccountId, String name, BigDecimal amount, String transactionTypeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);

		
		userContext.getChecker().checkNameOfTransaction(name);
		
		userContext.getChecker().checkAmountOfTransaction(amount);
		
		userContext.getChecker().checkTransactionTypeIdOfTransaction(transactionTypeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);

	
	}
	public  MerchantAccount addTransaction(LscUserContext userContext, String merchantAccountId, String name, BigDecimal amount, String transactionTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransaction(userContext,merchantAccountId,name, amount, transactionTypeId,tokensExpr);
		
		Transaction transaction = createTransaction(userContext,name, amount, transactionTypeId);
		
		MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, allTokens());
		synchronized(merchantAccount){ 
			//Will be good when the merchantAccount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchantAccount.addTransaction( transaction );		
			merchantAccount = saveMerchantAccount(userContext, merchantAccount, tokens().withTransactionList().done());
			
			userContext.getManagerGroup().getTransactionManager().onNewInstanceCreated(userContext, transaction);
			return present(userContext,merchantAccount, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransactionProperties(LscUserContext userContext, String merchantAccountId,String id,String name,BigDecimal amount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().checkIdOfTransaction(id);
		
		userContext.getChecker().checkNameOfTransaction( name);
		userContext.getChecker().checkAmountOfTransaction( amount);

		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);
		
	}
	public  MerchantAccount updateTransactionProperties(LscUserContext userContext, String merchantAccountId, String id,String name,BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransactionProperties(userContext,merchantAccountId,id,name,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransactionListList()
				.searchTransactionListWith(Transaction.ID_PROPERTY, "is", id).done();
		
		MerchantAccount merchantAccountToUpdate = loadMerchantAccount(userContext, merchantAccountId, options);
		
		if(merchantAccountToUpdate.getTransactionList().isEmpty()){
			throw new MerchantAccountManagerException("Transaction is NOT FOUND with id: '"+id+"'");
		}
		
		Transaction item = merchantAccountToUpdate.getTransactionList().first();
		
		item.updateName( name );
		item.updateAmount( amount );

		
		//checkParamsForAddingTransaction(userContext,merchantAccountId,name, code, used,tokensExpr);
		MerchantAccount merchantAccount = saveMerchantAccount(userContext, merchantAccountToUpdate, tokens().withTransactionList().done());
		synchronized(merchantAccount){ 
			return present(userContext,merchantAccount, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Transaction createTransaction(LscUserContext userContext, String name, BigDecimal amount, String transactionTypeId) throws Exception{

		Transaction transaction = new Transaction();
		
		
		transaction.setName(name);		
		transaction.setAmount(amount);		
		TransactionType  transactionType = new TransactionType();
		transactionType.setId(transactionTypeId);		
		transaction.setTransactionType(transactionType);
	
		
		return transaction;
	
		
	}
	
	protected Transaction createIndexedTransaction(String id, int version){

		Transaction transaction = new Transaction();
		transaction.setId(id);
		transaction.setVersion(version);
		return transaction;			
		
	}
	
	protected void checkParamsForRemovingTransactionList(LscUserContext userContext, String merchantAccountId, 
			String transactionIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		for(String transactionId: transactionIds){
			userContext.getChecker().checkIdOfTransaction(transactionId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);
		
	}
	public  MerchantAccount removeTransactionList(LscUserContext userContext, String merchantAccountId, 
			String transactionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransactionList(userContext, merchantAccountId,  transactionIds, tokensExpr);
			
			
			MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, allTokens());
			synchronized(merchantAccount){ 
				//Will be good when the merchantAccount loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getMerchantAccountDAO().planToRemoveTransactionList(merchantAccount, transactionIds, allTokens());
				merchantAccount = saveMerchantAccount(userContext, merchantAccount, tokens().withTransactionList().done());
				deleteRelationListInGraph(userContext, merchantAccount.getTransactionList());
				return present(userContext,merchantAccount, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransaction(LscUserContext userContext, String merchantAccountId, 
		String transactionId, int transactionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchantAccount( merchantAccountId);
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().checkVersionOfTransaction(transactionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);
	
	}
	public  MerchantAccount removeTransaction(LscUserContext userContext, String merchantAccountId, 
		String transactionId, int transactionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransaction(userContext,merchantAccountId, transactionId, transactionVersion,tokensExpr);
		
		Transaction transaction = createIndexedTransaction(transactionId, transactionVersion);
		MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, allTokens());
		synchronized(merchantAccount){ 
			//Will be good when the merchantAccount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchantAccount.removeTransaction( transaction );		
			merchantAccount = saveMerchantAccount(userContext, merchantAccount, tokens().withTransactionList().done());
			deleteRelationInGraph(userContext, transaction);
			return present(userContext,merchantAccount, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransaction(LscUserContext userContext, String merchantAccountId, 
		String transactionId, int transactionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchantAccount( merchantAccountId);
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().checkVersionOfTransaction(transactionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);
	
	}
	public  MerchantAccount copyTransactionFrom(LscUserContext userContext, String merchantAccountId, 
		String transactionId, int transactionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransaction(userContext,merchantAccountId, transactionId, transactionVersion,tokensExpr);
		
		Transaction transaction = createIndexedTransaction(transactionId, transactionVersion);
		MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, allTokens());
		synchronized(merchantAccount){ 
			//Will be good when the merchantAccount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			merchantAccount.copyTransactionFrom( transaction );		
			merchantAccount = saveMerchantAccount(userContext, merchantAccount, tokens().withTransactionList().done());
			
			userContext.getManagerGroup().getTransactionManager().onNewInstanceCreated(userContext, (Transaction)merchantAccount.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,merchantAccount, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransaction(LscUserContext userContext, String merchantAccountId, String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfMerchantAccount(merchantAccountId);
		userContext.getChecker().checkIdOfTransaction(transactionId);
		userContext.getChecker().checkVersionOfTransaction(transactionVersion);
		

		if(Transaction.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransaction(parseString(newValueExpr));
		}
		
		if(Transaction.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfTransaction(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantAccountManagerException.class);
	
	}
	
	public  MerchantAccount updateTransaction(LscUserContext userContext, String merchantAccountId, String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransaction(userContext, merchantAccountId, transactionId, transactionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransactionList().searchTransactionListWith(Transaction.ID_PROPERTY, "eq", transactionId).done();
		
		
		
		MerchantAccount merchantAccount = loadMerchantAccount(userContext, merchantAccountId, loadTokens);
		
		synchronized(merchantAccount){ 
			//Will be good when the merchantAccount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//merchantAccount.removeTransaction( transaction );	
			//make changes to AcceleraterAccount.
			Transaction transactionIndex = createIndexedTransaction(transactionId, transactionVersion);
		
			Transaction transaction = merchantAccount.findTheTransaction(transactionIndex);
			if(transaction == null){
				throw new MerchantAccountManagerException(transaction+" is NOT FOUND" );
			}
			
			transaction.changeProperty(property, newValueExpr);
			
			merchantAccount = saveMerchantAccount(userContext, merchantAccount, tokens().withTransactionList().done());
			return present(userContext,merchantAccount, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, MerchantAccount newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


