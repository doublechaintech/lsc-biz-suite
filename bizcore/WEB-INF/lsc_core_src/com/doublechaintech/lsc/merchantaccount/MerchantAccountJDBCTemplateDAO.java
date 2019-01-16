
package com.doublechaintech.lsc.merchantaccount;

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


import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transaction.Transaction;

import com.doublechaintech.lsc.transaction.TransactionDAO;
import com.doublechaintech.lsc.merchant.MerchantDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class MerchantAccountJDBCTemplateDAO extends LscNamingServiceDAO implements MerchantAccountDAO{
 
 	
 	private  MerchantDAO  merchantDAO;
 	public void setMerchantDAO(MerchantDAO merchantDAO){
	 	this.merchantDAO = merchantDAO;
 	}
 	public MerchantDAO getMerchantDAO(){
	 	return this.merchantDAO;
 	}


			
		
	
  	private  TransactionDAO  transactionDAO;
 	public void setTransactionDAO(TransactionDAO pTransactionDAO){
 	
 		if(pTransactionDAO == null){
 			throw new IllegalStateException("Do not try to set transactionDAO to null.");
 		}
	 	this.transactionDAO = pTransactionDAO;
 	}
 	public TransactionDAO getTransactionDAO(){
 		if(this.transactionDAO == null){
 			throw new IllegalStateException("The transactionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transactionDAO;
 	}	
 	
			
		

	
	/*
	protected MerchantAccount load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMerchantAccount(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public MerchantAccount load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMerchantAccount(MerchantAccountTable.withId(id), options);
	}
	
	
	
	public MerchantAccount save(MerchantAccount merchantAccount,Map<String,Object> options){
		
		String methodName="save(MerchantAccount merchantAccount,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(merchantAccount, methodName, "merchantAccount");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalMerchantAccount(merchantAccount,options);
	}
	public MerchantAccount clone(String merchantAccountId, Map<String,Object> options) throws Exception{
	
		return clone(MerchantAccountTable.withId(merchantAccountId),options);
	}
	
	protected MerchantAccount clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String merchantAccountId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		MerchantAccount newMerchantAccount = loadInternalMerchantAccount(accessKey, options);
		newMerchantAccount.setVersion(0);
		
		
 		
 		if(isSaveTransactionListEnabled(options)){
 			for(Transaction item: newMerchantAccount.getTransactionList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalMerchantAccount(newMerchantAccount,options);
		
		return newMerchantAccount;
	}
	
	
	
	

	protected void throwIfHasException(String merchantAccountId,int version,int count) throws Exception{
		if (count == 1) {
			throw new MerchantAccountVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MerchantAccountNotFoundException(
					"The " + this.getTableName() + "(" + merchantAccountId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String merchantAccountId, int version) throws Exception{
	
		String methodName="delete(String merchantAccountId, int version)";
		assertMethodArgumentNotNull(merchantAccountId, methodName, "merchantAccountId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{merchantAccountId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(merchantAccountId,version);
		}
		
	
	}
	
	
	
	
	

	public MerchantAccount disconnectFromAll(String merchantAccountId, int version) throws Exception{
	
		
		MerchantAccount merchantAccount = loadInternalMerchantAccount(MerchantAccountTable.withId(merchantAccountId), emptyOptions());
		merchantAccount.clearFromAll();
		this.saveMerchantAccount(merchantAccount);
		return merchantAccount;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return MerchantAccountTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "merchant_account";
	}
	@Override
	protected String getBeanName() {
		
		return "merchantAccount";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return MerchantAccountTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractMerchantEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MerchantAccountTokens.MERCHANT);
 	}

 	protected boolean isSaveMerchantEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MerchantAccountTokens.MERCHANT);
 	}
 	

 	
 
		
	
	protected boolean isExtractTransactionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantAccountTokens.TRANSACTION_LIST);
 	}
 	protected boolean isAnalyzeTransactionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,MerchantAccountTokens.TRANSACTION_LIST+".analyze");
 	}

	protected boolean isSaveTransactionListEnabled(Map<String,Object> options){
		return checkOptions(options, MerchantAccountTokens.TRANSACTION_LIST);
		
 	}
 	
		

	

	protected MerchantAccountMapper getMerchantAccountMapper(){
		return new MerchantAccountMapper();
	}

	
	
	protected MerchantAccount extractMerchantAccount(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			MerchantAccount merchantAccount = loadSingleObject(accessKey, getMerchantAccountMapper());
			return merchantAccount;
		}catch(EmptyResultDataAccessException e){
			throw new MerchantAccountNotFoundException("MerchantAccount("+accessKey+") is not found!");
		}

	}

	
	

	protected MerchantAccount loadInternalMerchantAccount(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		MerchantAccount merchantAccount = extractMerchantAccount(accessKey, loadOptions);
 	
 		if(isExtractMerchantEnabled(loadOptions)){
	 		extractMerchant(merchantAccount, loadOptions);
 		}
 
		
		if(isExtractTransactionListEnabled(loadOptions)){
	 		extractTransactionList(merchantAccount, loadOptions);
 		}	
 		if(isAnalyzeTransactionListEnabled(loadOptions)){
	 		// analyzeTransactionList(merchantAccount, loadOptions);
 		}
 		
		
		return merchantAccount;
		
	}

	 

 	protected MerchantAccount extractMerchant(MerchantAccount merchantAccount, Map<String,Object> options) throws Exception{

		if(merchantAccount.getMerchant() == null){
			return merchantAccount;
		}
		String merchantId = merchantAccount.getMerchant().getId();
		if( merchantId == null){
			return merchantAccount;
		}
		Merchant merchant = getMerchantDAO().load(merchantId,options);
		if(merchant != null){
			merchantAccount.setMerchant(merchant);
		}
		
 		
 		return merchantAccount;
 	}
 		
 
		
	protected void enhanceTransactionList(SmartList<Transaction> transactionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected MerchantAccount extractTransactionList(MerchantAccount merchantAccount, Map<String,Object> options){
		
		
		if(merchantAccount == null){
			return null;
		}
		if(merchantAccount.getId() == null){
			return merchantAccount;
		}

		
		
		SmartList<Transaction> transactionList = getTransactionDAO().findTransactionByAccount(merchantAccount.getId(),options);
		if(transactionList != null){
			enhanceTransactionList(transactionList,options);
			merchantAccount.setTransactionList(transactionList);
		}
		
		return merchantAccount;
	
	}	
	
	protected MerchantAccount analyzeTransactionList(MerchantAccount merchantAccount, Map<String,Object> options){
		
		
		if(merchantAccount == null){
			return null;
		}
		if(merchantAccount.getId() == null){
			return merchantAccount;
		}

		
		
		SmartList<Transaction> transactionList = merchantAccount.getTransactionList();
		if(transactionList != null){
			getTransactionDAO().analyzeTransactionByAccount(transactionList, merchantAccount.getId(), options);
			
		}
		
		return merchantAccount;
	
	}	
	
		
		
  	
 	public SmartList<MerchantAccount> findMerchantAccountByMerchant(String merchantId,Map<String,Object> options){
 	
  		SmartList<MerchantAccount> resultList = queryWith(MerchantAccountTable.COLUMN_MERCHANT, merchantId, options, getMerchantAccountMapper());
		// analyzeMerchantAccountByMerchant(resultList, merchantId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<MerchantAccount> findMerchantAccountByMerchant(String merchantId, int start, int count,Map<String,Object> options){
 		
 		SmartList<MerchantAccount> resultList =  queryWithRange(MerchantAccountTable.COLUMN_MERCHANT, merchantId, options, getMerchantAccountMapper(), start, count);
 		//analyzeMerchantAccountByMerchant(resultList, merchantId, options);
 		return resultList;
 		
 	}
 	public void analyzeMerchantAccountByMerchant(SmartList<MerchantAccount> resultList, String merchantId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(MerchantAccount.MERCHANT_PROPERTY, merchantId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//MerchantAccount.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Merchant Account");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(MerchantAccount.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(MerchantAccount.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countMerchantAccountByMerchant(String merchantId,Map<String,Object> options){

 		return countWith(MerchantAccountTable.COLUMN_MERCHANT, merchantId, options);
 	}
 	@Override
	public Map<String, Integer> countMerchantAccountByMerchantIds(String[] ids, Map<String, Object> options) {
		return countWithIds(MerchantAccountTable.COLUMN_MERCHANT, ids, options);
	}
 	
 	
		
		
		

	

	protected MerchantAccount saveMerchantAccount(MerchantAccount  merchantAccount){
		
		if(!merchantAccount.isChanged()){
			return merchantAccount;
		}
		
		
		String SQL=this.getSaveMerchantAccountSQL(merchantAccount);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMerchantAccountParameters(merchantAccount);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		merchantAccount.incVersion();
		return merchantAccount;
	
	}
	public SmartList<MerchantAccount> saveMerchantAccountList(SmartList<MerchantAccount> merchantAccountList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMerchantAccountList(merchantAccountList);
		
		batchMerchantAccountCreate((List<MerchantAccount>)lists[CREATE_LIST_INDEX]);
		
		batchMerchantAccountUpdate((List<MerchantAccount>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(MerchantAccount merchantAccount:merchantAccountList){
			if(merchantAccount.isChanged()){
				merchantAccount.incVersion();
			}
			
		
		}
		
		
		return merchantAccountList;
	}

	public SmartList<MerchantAccount> removeMerchantAccountList(SmartList<MerchantAccount> merchantAccountList,Map<String,Object> options){
		
		
		super.removeList(merchantAccountList, options);
		
		return merchantAccountList;
		
		
	}
	
	protected List<Object[]> prepareMerchantAccountBatchCreateArgs(List<MerchantAccount> merchantAccountList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MerchantAccount merchantAccount:merchantAccountList ){
			Object [] parameters = prepareMerchantAccountCreateParameters(merchantAccount);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareMerchantAccountBatchUpdateArgs(List<MerchantAccount> merchantAccountList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MerchantAccount merchantAccount:merchantAccountList ){
			if(!merchantAccount.isChanged()){
				continue;
			}
			Object [] parameters = prepareMerchantAccountUpdateParameters(merchantAccount);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchMerchantAccountCreate(List<MerchantAccount> merchantAccountList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMerchantAccountBatchCreateArgs(merchantAccountList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchMerchantAccountUpdate(List<MerchantAccount> merchantAccountList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMerchantAccountBatchUpdateArgs(merchantAccountList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitMerchantAccountList(List<MerchantAccount> merchantAccountList){
		
		List<MerchantAccount> merchantAccountCreateList=new ArrayList<MerchantAccount>();
		List<MerchantAccount> merchantAccountUpdateList=new ArrayList<MerchantAccount>();
		
		for(MerchantAccount merchantAccount: merchantAccountList){
			if(isUpdateRequest(merchantAccount)){
				merchantAccountUpdateList.add( merchantAccount);
				continue;
			}
			merchantAccountCreateList.add(merchantAccount);
		}
		
		return new Object[]{merchantAccountCreateList,merchantAccountUpdateList};
	}
	
	protected boolean isUpdateRequest(MerchantAccount merchantAccount){
 		return merchantAccount.getVersion() > 0;
 	}
 	protected String getSaveMerchantAccountSQL(MerchantAccount merchantAccount){
 		if(isUpdateRequest(merchantAccount)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveMerchantAccountParameters(MerchantAccount merchantAccount){
 		if(isUpdateRequest(merchantAccount) ){
 			return prepareMerchantAccountUpdateParameters(merchantAccount);
 		}
 		return prepareMerchantAccountCreateParameters(merchantAccount);
 	}
 	protected Object[] prepareMerchantAccountUpdateParameters(MerchantAccount merchantAccount){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = merchantAccount.getName(); 	
 		if(merchantAccount.getMerchant() != null){
 			parameters[1] = merchantAccount.getMerchant().getId();
 		}
 
 		parameters[2] = merchantAccount.getCreateTime();
 		parameters[3] = merchantAccount.getUpdateTime();		
 		parameters[4] = merchantAccount.nextVersion();
 		parameters[5] = merchantAccount.getId();
 		parameters[6] = merchantAccount.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareMerchantAccountCreateParameters(MerchantAccount merchantAccount){
		Object[] parameters = new Object[5];
		String newMerchantAccountId=getNextId();
		merchantAccount.setId(newMerchantAccountId);
		parameters[0] =  merchantAccount.getId();
 
 		parameters[1] = merchantAccount.getName(); 	
 		if(merchantAccount.getMerchant() != null){
 			parameters[2] = merchantAccount.getMerchant().getId();
 		
 		}
 		
 		parameters[3] = merchantAccount.getCreateTime();
 		parameters[4] = merchantAccount.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected MerchantAccount saveInternalMerchantAccount(MerchantAccount merchantAccount, Map<String,Object> options){
		
		saveMerchantAccount(merchantAccount);
 	
 		if(isSaveMerchantEnabled(options)){
	 		saveMerchant(merchantAccount, options);
 		}
 
		
		if(isSaveTransactionListEnabled(options)){
	 		saveTransactionList(merchantAccount, options);
	 		//removeTransactionList(merchantAccount, options);
	 		//Not delete the record
	 		
 		}		
		
		return merchantAccount;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected MerchantAccount saveMerchant(MerchantAccount merchantAccount, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(merchantAccount.getMerchant() == null){
 			return merchantAccount;//do nothing when it is null
 		}
 		
 		getMerchantDAO().save(merchantAccount.getMerchant(),options);
 		return merchantAccount;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public MerchantAccount planToRemoveTransactionList(MerchantAccount merchantAccount, String transactionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Transaction.ACCOUNT_PROPERTY, merchantAccount.getId());
		key.put(Transaction.ID_PROPERTY, transactionIds);
		
		SmartList<Transaction> externalTransactionList = getTransactionDAO().
				findTransactionWithKey(key, options);
		if(externalTransactionList == null){
			return merchantAccount;
		}
		if(externalTransactionList.isEmpty()){
			return merchantAccount;
		}
		
		for(Transaction transaction: externalTransactionList){

			transaction.clearFromAll();
		}
		
		
		SmartList<Transaction> transactionList = merchantAccount.getTransactionList();		
		transactionList.addAllToRemoveList(externalTransactionList);
		return merchantAccount;	
	
	}


	//disconnect MerchantAccount with transaction_type in Transaction
	public MerchantAccount planToRemoveTransactionListWithTransactionType(MerchantAccount merchantAccount, String transactionTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Transaction.ACCOUNT_PROPERTY, merchantAccount.getId());
		key.put(Transaction.TRANSACTION_TYPE_PROPERTY, transactionTypeId);
		
		SmartList<Transaction> externalTransactionList = getTransactionDAO().
				findTransactionWithKey(key, options);
		if(externalTransactionList == null){
			return merchantAccount;
		}
		if(externalTransactionList.isEmpty()){
			return merchantAccount;
		}
		
		for(Transaction transaction: externalTransactionList){
			transaction.clearTransactionType();
			transaction.clearAccount();
			
		}
		
		
		SmartList<Transaction> transactionList = merchantAccount.getTransactionList();		
		transactionList.addAllToRemoveList(externalTransactionList);
		return merchantAccount;
	}
	
	public int countTransactionListWithTransactionType(String merchantAccountId, String transactionTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Transaction.ACCOUNT_PROPERTY, merchantAccountId);
		key.put(Transaction.TRANSACTION_TYPE_PROPERTY, transactionTypeId);
		
		int count = getTransactionDAO().countTransactionWithKey(key, options);
		return count;
	}
	

		
	protected MerchantAccount saveTransactionList(MerchantAccount merchantAccount, Map<String,Object> options){
		
		
		
		
		SmartList<Transaction> transactionList = merchantAccount.getTransactionList();
		if(transactionList == null){
			//null list means nothing
			return merchantAccount;
		}
		SmartList<Transaction> mergedUpdateTransactionList = new SmartList<Transaction>();
		
		
		mergedUpdateTransactionList.addAll(transactionList); 
		if(transactionList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransactionList.addAll(transactionList.getToRemoveList());
			transactionList.removeAll(transactionList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransactionDAO().saveTransactionList(mergedUpdateTransactionList,options);
		
		if(transactionList.getToRemoveList() != null){
			transactionList.removeAll(transactionList.getToRemoveList());
		}
		
		
		return merchantAccount;
	
	}
	
	protected MerchantAccount removeTransactionList(MerchantAccount merchantAccount, Map<String,Object> options){
	
	
		SmartList<Transaction> transactionList = merchantAccount.getTransactionList();
		if(transactionList == null){
			return merchantAccount;
		}	
	
		SmartList<Transaction> toRemoveTransactionList = transactionList.getToRemoveList();
		
		if(toRemoveTransactionList == null){
			return merchantAccount;
		}
		if(toRemoveTransactionList.isEmpty()){
			return merchantAccount;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransactionDAO().removeTransactionList(toRemoveTransactionList,options);
		
		return merchantAccount;
	
	}
	
	

 	
 	
	
	
	
		

	public MerchantAccount present(MerchantAccount merchantAccount,Map<String, Object> options){
	
		presentTransactionList(merchantAccount,options);

		return merchantAccount;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected MerchantAccount presentTransactionList(
			MerchantAccount merchantAccount,
			Map<String, Object> options) {

		SmartList<Transaction> transactionList = merchantAccount.getTransactionList();		
				SmartList<Transaction> newList= presentSubList(merchantAccount.getId(),
				transactionList,
				options,
				getTransactionDAO()::countTransactionByAccount,
				getTransactionDAO()::findTransactionByAccount
				);

		
		merchantAccount.setTransactionList(newList);
		

		return merchantAccount;
	}			
		

	
    public SmartList<MerchantAccount> requestCandidateMerchantAccountForTransaction(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MerchantAccountTable.COLUMN_NAME, filterKey, pageNo, pageSize, getMerchantAccountMapper());
    }
		

	protected String getTableName(){
		return MerchantAccountTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<MerchantAccount> merchantAccountList) {		
		this.enhanceListInternal(merchantAccountList, this.getMerchantAccountMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<MerchantAccount> merchantAccountList = ownerEntity.collectRefsWithType(MerchantAccount.INTERNAL_TYPE);
		this.enhanceList(merchantAccountList);
		
	}
	
	@Override
	public SmartList<MerchantAccount> findMerchantAccountWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getMerchantAccountMapper());

	}
	@Override
	public int countMerchantAccountWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countMerchantAccountWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<MerchantAccount> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getMerchantAccountMapper());
	}
}


