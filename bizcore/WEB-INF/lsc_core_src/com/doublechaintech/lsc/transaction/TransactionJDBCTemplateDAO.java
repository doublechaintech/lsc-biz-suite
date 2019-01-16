
package com.doublechaintech.lsc.transaction;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.lsc.LscNamingServiceDAO;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.AccessKey;
import com.doublechaintech.lsc.DateKey;
import com.doublechaintech.lsc.StatsInfo;
import com.doublechaintech.lsc.StatsItem;

import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;


import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.transactiontype.TransactionType;

import com.doublechaintech.lsc.merchantaccount.MerchantAccountDAO;
import com.doublechaintech.lsc.transactiontype.TransactionTypeDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TransactionJDBCTemplateDAO extends LscNamingServiceDAO implements TransactionDAO{
 
 	
 	private  MerchantAccountDAO  merchantAccountDAO;
 	public void setMerchantAccountDAO(MerchantAccountDAO merchantAccountDAO){
	 	this.merchantAccountDAO = merchantAccountDAO;
 	}
 	public MerchantAccountDAO getMerchantAccountDAO(){
	 	return this.merchantAccountDAO;
 	}
 
 	
 	private  TransactionTypeDAO  transactionTypeDAO;
 	public void setTransactionTypeDAO(TransactionTypeDAO transactionTypeDAO){
	 	this.transactionTypeDAO = transactionTypeDAO;
 	}
 	public TransactionTypeDAO getTransactionTypeDAO(){
	 	return this.transactionTypeDAO;
 	}


			
		

	
	/*
	protected Transaction load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransaction(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Transaction load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransaction(TransactionTable.withId(id), options);
	}
	
	
	
	public Transaction save(Transaction transaction,Map<String,Object> options){
		
		String methodName="save(Transaction transaction,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transaction, methodName, "transaction");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransaction(transaction,options);
	}
	public Transaction clone(String transactionId, Map<String,Object> options) throws Exception{
	
		return clone(TransactionTable.withId(transactionId),options);
	}
	
	protected Transaction clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transactionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Transaction newTransaction = loadInternalTransaction(accessKey, options);
		newTransaction.setVersion(0);
		
		

		
		saveInternalTransaction(newTransaction,options);
		
		return newTransaction;
	}
	
	
	
	

	protected void throwIfHasException(String transactionId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransactionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransactionNotFoundException(
					"The " + this.getTableName() + "(" + transactionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transactionId, int version) throws Exception{
	
		String methodName="delete(String transactionId, int version)";
		assertMethodArgumentNotNull(transactionId, methodName, "transactionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transactionId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transactionId,version);
		}
		
	
	}
	
	
	
	
	

	public Transaction disconnectFromAll(String transactionId, int version) throws Exception{
	
		
		Transaction transaction = loadInternalTransaction(TransactionTable.withId(transactionId), emptyOptions());
		transaction.clearFromAll();
		this.saveTransaction(transaction);
		return transaction;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransactionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transaction";
	}
	@Override
	protected String getBeanName() {
		
		return "transaction";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransactionTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractTransactionTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransactionTokens.TRANSACTIONTYPE);
 	}

 	protected boolean isSaveTransactionTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransactionTokens.TRANSACTIONTYPE);
 	}
 	

 	
  

 	protected boolean isExtractAccountEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransactionTokens.ACCOUNT);
 	}

 	protected boolean isSaveAccountEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransactionTokens.ACCOUNT);
 	}
 	

 	
 
		

	

	protected TransactionMapper getTransactionMapper(){
		return new TransactionMapper();
	}

	
	
	protected Transaction extractTransaction(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Transaction transaction = loadSingleObject(accessKey, getTransactionMapper());
			return transaction;
		}catch(EmptyResultDataAccessException e){
			throw new TransactionNotFoundException("Transaction("+accessKey+") is not found!");
		}

	}

	
	

	protected Transaction loadInternalTransaction(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Transaction transaction = extractTransaction(accessKey, loadOptions);
 	
 		if(isExtractTransactionTypeEnabled(loadOptions)){
	 		extractTransactionType(transaction, loadOptions);
 		}
  	
 		if(isExtractAccountEnabled(loadOptions)){
	 		extractAccount(transaction, loadOptions);
 		}
 
		
		return transaction;
		
	}

	 

 	protected Transaction extractTransactionType(Transaction transaction, Map<String,Object> options) throws Exception{

		if(transaction.getTransactionType() == null){
			return transaction;
		}
		String transactionTypeId = transaction.getTransactionType().getId();
		if( transactionTypeId == null){
			return transaction;
		}
		TransactionType transactionType = getTransactionTypeDAO().load(transactionTypeId,options);
		if(transactionType != null){
			transaction.setTransactionType(transactionType);
		}
		
 		
 		return transaction;
 	}
 		
  

 	protected Transaction extractAccount(Transaction transaction, Map<String,Object> options) throws Exception{

		if(transaction.getAccount() == null){
			return transaction;
		}
		String accountId = transaction.getAccount().getId();
		if( accountId == null){
			return transaction;
		}
		MerchantAccount account = getMerchantAccountDAO().load(accountId,options);
		if(account != null){
			transaction.setAccount(account);
		}
		
 		
 		return transaction;
 	}
 		
 
		
		
  	
 	public SmartList<Transaction> findTransactionByTransactionType(String transactionTypeId,Map<String,Object> options){
 	
  		SmartList<Transaction> resultList = queryWith(TransactionTable.COLUMN_TRANSACTION_TYPE, transactionTypeId, options, getTransactionMapper());
		// analyzeTransactionByTransactionType(resultList, transactionTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Transaction> findTransactionByTransactionType(String transactionTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Transaction> resultList =  queryWithRange(TransactionTable.COLUMN_TRANSACTION_TYPE, transactionTypeId, options, getTransactionMapper(), start, count);
 		//analyzeTransactionByTransactionType(resultList, transactionTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransactionByTransactionType(SmartList<Transaction> resultList, String transactionTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Transaction.TRANSACTION_TYPE_PROPERTY, transactionTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransactionByTransactionType(String transactionTypeId,Map<String,Object> options){

 		return countWith(TransactionTable.COLUMN_TRANSACTION_TYPE, transactionTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countTransactionByTransactionTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransactionTable.COLUMN_TRANSACTION_TYPE, ids, options);
	}
 	
  	
 	public SmartList<Transaction> findTransactionByAccount(String merchantAccountId,Map<String,Object> options){
 	
  		SmartList<Transaction> resultList = queryWith(TransactionTable.COLUMN_ACCOUNT, merchantAccountId, options, getTransactionMapper());
		// analyzeTransactionByAccount(resultList, merchantAccountId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Transaction> findTransactionByAccount(String merchantAccountId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Transaction> resultList =  queryWithRange(TransactionTable.COLUMN_ACCOUNT, merchantAccountId, options, getTransactionMapper(), start, count);
 		//analyzeTransactionByAccount(resultList, merchantAccountId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransactionByAccount(SmartList<Transaction> resultList, String merchantAccountId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Transaction.ACCOUNT_PROPERTY, merchantAccountId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTransactionByAccount(String merchantAccountId,Map<String,Object> options){

 		return countWith(TransactionTable.COLUMN_ACCOUNT, merchantAccountId, options);
 	}
 	@Override
	public Map<String, Integer> countTransactionByAccountIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransactionTable.COLUMN_ACCOUNT, ids, options);
	}
 	
 	
		
		
		

	

	protected Transaction saveTransaction(Transaction  transaction){
		
		if(!transaction.isChanged()){
			return transaction;
		}
		
		
		String SQL=this.getSaveTransactionSQL(transaction);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransactionParameters(transaction);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transaction.incVersion();
		return transaction;
	
	}
	public SmartList<Transaction> saveTransactionList(SmartList<Transaction> transactionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransactionList(transactionList);
		
		batchTransactionCreate((List<Transaction>)lists[CREATE_LIST_INDEX]);
		
		batchTransactionUpdate((List<Transaction>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Transaction transaction:transactionList){
			if(transaction.isChanged()){
				transaction.incVersion();
			}
			
		
		}
		
		
		return transactionList;
	}

	public SmartList<Transaction> removeTransactionList(SmartList<Transaction> transactionList,Map<String,Object> options){
		
		
		super.removeList(transactionList, options);
		
		return transactionList;
		
		
	}
	
	protected List<Object[]> prepareTransactionBatchCreateArgs(List<Transaction> transactionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Transaction transaction:transactionList ){
			Object [] parameters = prepareTransactionCreateParameters(transaction);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransactionBatchUpdateArgs(List<Transaction> transactionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Transaction transaction:transactionList ){
			if(!transaction.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransactionUpdateParameters(transaction);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransactionCreate(List<Transaction> transactionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransactionBatchCreateArgs(transactionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransactionUpdate(List<Transaction> transactionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransactionBatchUpdateArgs(transactionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransactionList(List<Transaction> transactionList){
		
		List<Transaction> transactionCreateList=new ArrayList<Transaction>();
		List<Transaction> transactionUpdateList=new ArrayList<Transaction>();
		
		for(Transaction transaction: transactionList){
			if(isUpdateRequest(transaction)){
				transactionUpdateList.add( transaction);
				continue;
			}
			transactionCreateList.add(transaction);
		}
		
		return new Object[]{transactionCreateList,transactionUpdateList};
	}
	
	protected boolean isUpdateRequest(Transaction transaction){
 		return transaction.getVersion() > 0;
 	}
 	protected String getSaveTransactionSQL(Transaction transaction){
 		if(isUpdateRequest(transaction)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransactionParameters(Transaction transaction){
 		if(isUpdateRequest(transaction) ){
 			return prepareTransactionUpdateParameters(transaction);
 		}
 		return prepareTransactionCreateParameters(transaction);
 	}
 	protected Object[] prepareTransactionUpdateParameters(Transaction transaction){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = transaction.getName();
 		parameters[1] = transaction.getAmount(); 	
 		if(transaction.getTransactionType() != null){
 			parameters[2] = transaction.getTransactionType().getId();
 		}
  	
 		if(transaction.getAccount() != null){
 			parameters[3] = transaction.getAccount().getId();
 		}
 		
 		parameters[4] = transaction.nextVersion();
 		parameters[5] = transaction.getId();
 		parameters[6] = transaction.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransactionCreateParameters(Transaction transaction){
		Object[] parameters = new Object[5];
		String newTransactionId=getNextId();
		transaction.setId(newTransactionId);
		parameters[0] =  transaction.getId();
 
 		parameters[1] = transaction.getName();
 		parameters[2] = transaction.getAmount(); 	
 		if(transaction.getTransactionType() != null){
 			parameters[3] = transaction.getTransactionType().getId();
 		
 		}
 		 	
 		if(transaction.getAccount() != null){
 			parameters[4] = transaction.getAccount().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Transaction saveInternalTransaction(Transaction transaction, Map<String,Object> options){
		
		saveTransaction(transaction);
 	
 		if(isSaveTransactionTypeEnabled(options)){
	 		saveTransactionType(transaction, options);
 		}
  	
 		if(isSaveAccountEnabled(options)){
	 		saveAccount(transaction, options);
 		}
 
		
		return transaction;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Transaction saveTransactionType(Transaction transaction, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transaction.getTransactionType() == null){
 			return transaction;//do nothing when it is null
 		}
 		
 		getTransactionTypeDAO().save(transaction.getTransactionType(),options);
 		return transaction;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Transaction saveAccount(Transaction transaction, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transaction.getAccount() == null){
 			return transaction;//do nothing when it is null
 		}
 		
 		getMerchantAccountDAO().save(transaction.getAccount(),options);
 		return transaction;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Transaction present(Transaction transaction,Map<String, Object> options){
	

		return transaction;
	
	}
		

	

	protected String getTableName(){
		return TransactionTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Transaction> transactionList) {		
		this.enhanceListInternal(transactionList, this.getTransactionMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Transaction> transactionList = ownerEntity.collectRefsWithType(Transaction.INTERNAL_TYPE);
		this.enhanceList(transactionList);
		
	}
	
	@Override
	public SmartList<Transaction> findTransactionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransactionMapper());

	}
	@Override
	public int countTransactionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransactionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Transaction> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransactionMapper());
	}
}


