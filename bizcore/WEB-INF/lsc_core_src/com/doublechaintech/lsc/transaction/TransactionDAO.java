
package com.doublechaintech.lsc.transaction;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.merchantaccount.MerchantAccountDAO;
import com.doublechaintech.lsc.transactiontype.TransactionTypeDAO;


public interface TransactionDAO{

	
	public Transaction load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Transaction> transactionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Transaction present(Transaction transaction,Map<String,Object> options) throws Exception;
	public Transaction clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Transaction save(Transaction transaction,Map<String,Object> options);
	public SmartList<Transaction> saveTransactionList(SmartList<Transaction> transactionList,Map<String,Object> options);
	public SmartList<Transaction> removeTransactionList(SmartList<Transaction> transactionList,Map<String,Object> options);
	public SmartList<Transaction> findTransactionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransactionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransactionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transactionId, int version) throws Exception;
	public Transaction disconnectFromAll(String transactionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Transaction> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Transaction> findTransactionByTransactionType(String transactionTypeId, Map<String,Object> options);
 	public int countTransactionByTransactionType(String transactionTypeId, Map<String,Object> options);
 	public Map<String, Integer> countTransactionByTransactionTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Transaction> findTransactionByTransactionType(String transactionTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeTransactionByTransactionType(SmartList<Transaction> resultList, String transactionTypeId, Map<String,Object> options);

 
  
 	public SmartList<Transaction> findTransactionByAccount(String merchantAccountId, Map<String,Object> options);
 	public int countTransactionByAccount(String merchantAccountId, Map<String,Object> options);
 	public Map<String, Integer> countTransactionByAccountIds(String[] ids, Map<String,Object> options);
 	public SmartList<Transaction> findTransactionByAccount(String merchantAccountId, int start, int count, Map<String,Object> options);
 	public void analyzeTransactionByAccount(SmartList<Transaction> resultList, String merchantAccountId, Map<String,Object> options);

 
 }


