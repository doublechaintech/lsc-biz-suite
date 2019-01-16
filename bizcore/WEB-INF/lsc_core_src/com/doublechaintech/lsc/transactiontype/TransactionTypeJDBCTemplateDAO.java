
package com.doublechaintech.lsc.transactiontype;

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


import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transaction.Transaction;

import com.doublechaintech.lsc.transaction.TransactionDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TransactionTypeJDBCTemplateDAO extends LscNamingServiceDAO implements TransactionTypeDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
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
	protected TransactionType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransactionType(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TransactionType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransactionType(TransactionTypeTable.withId(id), options);
	}
	
	
	
	public TransactionType save(TransactionType transactionType,Map<String,Object> options){
		
		String methodName="save(TransactionType transactionType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transactionType, methodName, "transactionType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransactionType(transactionType,options);
	}
	public TransactionType clone(String transactionTypeId, Map<String,Object> options) throws Exception{
	
		return clone(TransactionTypeTable.withId(transactionTypeId),options);
	}
	
	protected TransactionType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transactionTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransactionType newTransactionType = loadInternalTransactionType(accessKey, options);
		newTransactionType.setVersion(0);
		
		
 		
 		if(isSaveTransactionListEnabled(options)){
 			for(Transaction item: newTransactionType.getTransactionList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransactionType(newTransactionType,options);
		
		return newTransactionType;
	}
	
	
	
	

	protected void throwIfHasException(String transactionTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransactionTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransactionTypeNotFoundException(
					"The " + this.getTableName() + "(" + transactionTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transactionTypeId, int version) throws Exception{
	
		String methodName="delete(String transactionTypeId, int version)";
		assertMethodArgumentNotNull(transactionTypeId, methodName, "transactionTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transactionTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transactionTypeId,version);
		}
		
	
	}
	
	
	
	
	

	public TransactionType disconnectFromAll(String transactionTypeId, int version) throws Exception{
	
		
		TransactionType transactionType = loadInternalTransactionType(TransactionTypeTable.withId(transactionTypeId), emptyOptions());
		transactionType.clearFromAll();
		this.saveTransactionType(transactionType);
		return transactionType;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransactionTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transaction_type";
	}
	@Override
	protected String getBeanName() {
		
		return "transactionType";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransactionTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransactionTypeTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransactionTypeTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractTransactionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TransactionTypeTokens.TRANSACTION_LIST);
 	}
 	protected boolean isAnalyzeTransactionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TransactionTypeTokens.TRANSACTION_LIST+".analyze");
 	}

	protected boolean isSaveTransactionListEnabled(Map<String,Object> options){
		return checkOptions(options, TransactionTypeTokens.TRANSACTION_LIST);
		
 	}
 	
		

	

	protected TransactionTypeMapper getTransactionTypeMapper(){
		return new TransactionTypeMapper();
	}

	
	
	protected TransactionType extractTransactionType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransactionType transactionType = loadSingleObject(accessKey, getTransactionTypeMapper());
			return transactionType;
		}catch(EmptyResultDataAccessException e){
			throw new TransactionTypeNotFoundException("TransactionType("+accessKey+") is not found!");
		}

	}

	
	

	protected TransactionType loadInternalTransactionType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransactionType transactionType = extractTransactionType(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(transactionType, loadOptions);
 		}
 
		
		if(isExtractTransactionListEnabled(loadOptions)){
	 		extractTransactionList(transactionType, loadOptions);
 		}	
 		if(isAnalyzeTransactionListEnabled(loadOptions)){
	 		// analyzeTransactionList(transactionType, loadOptions);
 		}
 		
		
		return transactionType;
		
	}

	 

 	protected TransactionType extractPlatform(TransactionType transactionType, Map<String,Object> options) throws Exception{

		if(transactionType.getPlatform() == null){
			return transactionType;
		}
		String platformId = transactionType.getPlatform().getId();
		if( platformId == null){
			return transactionType;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			transactionType.setPlatform(platform);
		}
		
 		
 		return transactionType;
 	}
 		
 
		
	protected void enhanceTransactionList(SmartList<Transaction> transactionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected TransactionType extractTransactionList(TransactionType transactionType, Map<String,Object> options){
		
		
		if(transactionType == null){
			return null;
		}
		if(transactionType.getId() == null){
			return transactionType;
		}

		
		
		SmartList<Transaction> transactionList = getTransactionDAO().findTransactionByTransactionType(transactionType.getId(),options);
		if(transactionList != null){
			enhanceTransactionList(transactionList,options);
			transactionType.setTransactionList(transactionList);
		}
		
		return transactionType;
	
	}	
	
	protected TransactionType analyzeTransactionList(TransactionType transactionType, Map<String,Object> options){
		
		
		if(transactionType == null){
			return null;
		}
		if(transactionType.getId() == null){
			return transactionType;
		}

		
		
		SmartList<Transaction> transactionList = transactionType.getTransactionList();
		if(transactionList != null){
			getTransactionDAO().analyzeTransactionByTransactionType(transactionList, transactionType.getId(), options);
			
		}
		
		return transactionType;
	
	}	
	
		
		
  	
 	public SmartList<TransactionType> findTransactionTypeByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<TransactionType> resultList = queryWith(TransactionTypeTable.COLUMN_PLATFORM, platformId, options, getTransactionTypeMapper());
		// analyzeTransactionTypeByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransactionType> findTransactionTypeByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransactionType> resultList =  queryWithRange(TransactionTypeTable.COLUMN_PLATFORM, platformId, options, getTransactionTypeMapper(), start, count);
 		//analyzeTransactionTypeByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransactionTypeByPlatform(SmartList<TransactionType> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countTransactionTypeByPlatform(String platformId,Map<String,Object> options){

 		return countWith(TransactionTypeTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countTransactionTypeByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransactionTypeTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected TransactionType saveTransactionType(TransactionType  transactionType){
		
		if(!transactionType.isChanged()){
			return transactionType;
		}
		
		
		String SQL=this.getSaveTransactionTypeSQL(transactionType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransactionTypeParameters(transactionType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transactionType.incVersion();
		return transactionType;
	
	}
	public SmartList<TransactionType> saveTransactionTypeList(SmartList<TransactionType> transactionTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransactionTypeList(transactionTypeList);
		
		batchTransactionTypeCreate((List<TransactionType>)lists[CREATE_LIST_INDEX]);
		
		batchTransactionTypeUpdate((List<TransactionType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransactionType transactionType:transactionTypeList){
			if(transactionType.isChanged()){
				transactionType.incVersion();
			}
			
		
		}
		
		
		return transactionTypeList;
	}

	public SmartList<TransactionType> removeTransactionTypeList(SmartList<TransactionType> transactionTypeList,Map<String,Object> options){
		
		
		super.removeList(transactionTypeList, options);
		
		return transactionTypeList;
		
		
	}
	
	protected List<Object[]> prepareTransactionTypeBatchCreateArgs(List<TransactionType> transactionTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransactionType transactionType:transactionTypeList ){
			Object [] parameters = prepareTransactionTypeCreateParameters(transactionType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransactionTypeBatchUpdateArgs(List<TransactionType> transactionTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransactionType transactionType:transactionTypeList ){
			if(!transactionType.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransactionTypeUpdateParameters(transactionType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransactionTypeCreate(List<TransactionType> transactionTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransactionTypeBatchCreateArgs(transactionTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransactionTypeUpdate(List<TransactionType> transactionTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransactionTypeBatchUpdateArgs(transactionTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransactionTypeList(List<TransactionType> transactionTypeList){
		
		List<TransactionType> transactionTypeCreateList=new ArrayList<TransactionType>();
		List<TransactionType> transactionTypeUpdateList=new ArrayList<TransactionType>();
		
		for(TransactionType transactionType: transactionTypeList){
			if(isUpdateRequest(transactionType)){
				transactionTypeUpdateList.add( transactionType);
				continue;
			}
			transactionTypeCreateList.add(transactionType);
		}
		
		return new Object[]{transactionTypeCreateList,transactionTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(TransactionType transactionType){
 		return transactionType.getVersion() > 0;
 	}
 	protected String getSaveTransactionTypeSQL(TransactionType transactionType){
 		if(isUpdateRequest(transactionType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransactionTypeParameters(TransactionType transactionType){
 		if(isUpdateRequest(transactionType) ){
 			return prepareTransactionTypeUpdateParameters(transactionType);
 		}
 		return prepareTransactionTypeCreateParameters(transactionType);
 	}
 	protected Object[] prepareTransactionTypeUpdateParameters(TransactionType transactionType){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = transactionType.getName(); 	
 		if(transactionType.getPlatform() != null){
 			parameters[1] = transactionType.getPlatform().getId();
 		}
 		
 		parameters[2] = transactionType.nextVersion();
 		parameters[3] = transactionType.getId();
 		parameters[4] = transactionType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransactionTypeCreateParameters(TransactionType transactionType){
		Object[] parameters = new Object[3];
		String newTransactionTypeId=getNextId();
		transactionType.setId(newTransactionTypeId);
		parameters[0] =  transactionType.getId();
 
 		parameters[1] = transactionType.getName(); 	
 		if(transactionType.getPlatform() != null){
 			parameters[2] = transactionType.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TransactionType saveInternalTransactionType(TransactionType transactionType, Map<String,Object> options){
		
		saveTransactionType(transactionType);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(transactionType, options);
 		}
 
		
		if(isSaveTransactionListEnabled(options)){
	 		saveTransactionList(transactionType, options);
	 		//removeTransactionList(transactionType, options);
	 		//Not delete the record
	 		
 		}		
		
		return transactionType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransactionType savePlatform(TransactionType transactionType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transactionType.getPlatform() == null){
 			return transactionType;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(transactionType.getPlatform(),options);
 		return transactionType;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public TransactionType planToRemoveTransactionList(TransactionType transactionType, String transactionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Transaction.TRANSACTION_TYPE_PROPERTY, transactionType.getId());
		key.put(Transaction.ID_PROPERTY, transactionIds);
		
		SmartList<Transaction> externalTransactionList = getTransactionDAO().
				findTransactionWithKey(key, options);
		if(externalTransactionList == null){
			return transactionType;
		}
		if(externalTransactionList.isEmpty()){
			return transactionType;
		}
		
		for(Transaction transaction: externalTransactionList){

			transaction.clearFromAll();
		}
		
		
		SmartList<Transaction> transactionList = transactionType.getTransactionList();		
		transactionList.addAllToRemoveList(externalTransactionList);
		return transactionType;	
	
	}


	//disconnect TransactionType with account in Transaction
	public TransactionType planToRemoveTransactionListWithAccount(TransactionType transactionType, String accountId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Transaction.TRANSACTION_TYPE_PROPERTY, transactionType.getId());
		key.put(Transaction.ACCOUNT_PROPERTY, accountId);
		
		SmartList<Transaction> externalTransactionList = getTransactionDAO().
				findTransactionWithKey(key, options);
		if(externalTransactionList == null){
			return transactionType;
		}
		if(externalTransactionList.isEmpty()){
			return transactionType;
		}
		
		for(Transaction transaction: externalTransactionList){
			transaction.clearAccount();
			transaction.clearTransactionType();
			
		}
		
		
		SmartList<Transaction> transactionList = transactionType.getTransactionList();		
		transactionList.addAllToRemoveList(externalTransactionList);
		return transactionType;
	}
	
	public int countTransactionListWithAccount(String transactionTypeId, String accountId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Transaction.TRANSACTION_TYPE_PROPERTY, transactionTypeId);
		key.put(Transaction.ACCOUNT_PROPERTY, accountId);
		
		int count = getTransactionDAO().countTransactionWithKey(key, options);
		return count;
	}
	

		
	protected TransactionType saveTransactionList(TransactionType transactionType, Map<String,Object> options){
		
		
		
		
		SmartList<Transaction> transactionList = transactionType.getTransactionList();
		if(transactionList == null){
			//null list means nothing
			return transactionType;
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
		
		
		return transactionType;
	
	}
	
	protected TransactionType removeTransactionList(TransactionType transactionType, Map<String,Object> options){
	
	
		SmartList<Transaction> transactionList = transactionType.getTransactionList();
		if(transactionList == null){
			return transactionType;
		}	
	
		SmartList<Transaction> toRemoveTransactionList = transactionList.getToRemoveList();
		
		if(toRemoveTransactionList == null){
			return transactionType;
		}
		if(toRemoveTransactionList.isEmpty()){
			return transactionType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransactionDAO().removeTransactionList(toRemoveTransactionList,options);
		
		return transactionType;
	
	}
	
	

 	
 	
	
	
	
		

	public TransactionType present(TransactionType transactionType,Map<String, Object> options){
	
		presentTransactionList(transactionType,options);

		return transactionType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransactionType presentTransactionList(
			TransactionType transactionType,
			Map<String, Object> options) {

		SmartList<Transaction> transactionList = transactionType.getTransactionList();		
				SmartList<Transaction> newList= presentSubList(transactionType.getId(),
				transactionList,
				options,
				getTransactionDAO()::countTransactionByTransactionType,
				getTransactionDAO()::findTransactionByTransactionType
				);

		
		transactionType.setTransactionList(newList);
		

		return transactionType;
	}			
		

	
    public SmartList<TransactionType> requestCandidateTransactionTypeForTransaction(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransactionTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getTransactionTypeMapper());
    }
		

	protected String getTableName(){
		return TransactionTypeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TransactionType> transactionTypeList) {		
		this.enhanceListInternal(transactionTypeList, this.getTransactionTypeMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransactionType> transactionTypeList = ownerEntity.collectRefsWithType(TransactionType.INTERNAL_TYPE);
		this.enhanceList(transactionTypeList);
		
	}
	
	@Override
	public SmartList<TransactionType> findTransactionTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransactionTypeMapper());

	}
	@Override
	public int countTransactionTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransactionTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TransactionType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransactionTypeMapper());
	}
}


