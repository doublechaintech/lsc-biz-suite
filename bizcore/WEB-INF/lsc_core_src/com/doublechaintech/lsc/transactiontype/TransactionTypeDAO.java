
package com.doublechaintech.lsc.transactiontype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.transaction.TransactionDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;


public interface TransactionTypeDAO{

	
	public TransactionType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransactionType> transactionTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TransactionType present(TransactionType transactionType,Map<String,Object> options) throws Exception;
	public TransactionType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransactionType save(TransactionType transactionType,Map<String,Object> options);
	public SmartList<TransactionType> saveTransactionTypeList(SmartList<TransactionType> transactionTypeList,Map<String,Object> options);
	public SmartList<TransactionType> removeTransactionTypeList(SmartList<TransactionType> transactionTypeList,Map<String,Object> options);
	public SmartList<TransactionType> findTransactionTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransactionTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransactionTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transactionTypeId, int version) throws Exception;
	public TransactionType disconnectFromAll(String transactionTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransactionDAO getTransactionDAO();
		
	
 	public SmartList<TransactionType> requestCandidateTransactionTypeForTransaction(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TransactionType planToRemoveTransactionList(TransactionType transactionType, String transactionIds[], Map<String,Object> options)throws Exception;


	//disconnect TransactionType with account in Transaction
	public TransactionType planToRemoveTransactionListWithAccount(TransactionType transactionType, String accountId, Map<String,Object> options)throws Exception;
	public int countTransactionListWithAccount(String transactionTypeId, String accountId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TransactionType> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TransactionType> findTransactionTypeByPlatform(String platformId, Map<String,Object> options);
 	public int countTransactionTypeByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countTransactionTypeByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransactionType> findTransactionTypeByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeTransactionTypeByPlatform(SmartList<TransactionType> resultList, String platformId, Map<String,Object> options);

 
 }


