
package com.doublechaintech.lsc.merchantaccount;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.transaction.TransactionDAO;
import com.doublechaintech.lsc.merchant.MerchantDAO;


public interface MerchantAccountDAO{

	
	public MerchantAccount load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MerchantAccount> merchantAccountList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public MerchantAccount present(MerchantAccount merchantAccount,Map<String,Object> options) throws Exception;
	public MerchantAccount clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MerchantAccount save(MerchantAccount merchantAccount,Map<String,Object> options);
	public SmartList<MerchantAccount> saveMerchantAccountList(SmartList<MerchantAccount> merchantAccountList,Map<String,Object> options);
	public SmartList<MerchantAccount> removeMerchantAccountList(SmartList<MerchantAccount> merchantAccountList,Map<String,Object> options);
	public SmartList<MerchantAccount> findMerchantAccountWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMerchantAccountWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMerchantAccountWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String merchantAccountId, int version) throws Exception;
	public MerchantAccount disconnectFromAll(String merchantAccountId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransactionDAO getTransactionDAO();
		
	
 	public SmartList<MerchantAccount> requestCandidateMerchantAccountForTransaction(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public MerchantAccount planToRemoveTransactionList(MerchantAccount merchantAccount, String transactionIds[], Map<String,Object> options)throws Exception;


	//disconnect MerchantAccount with transaction_type in Transaction
	public MerchantAccount planToRemoveTransactionListWithTransactionType(MerchantAccount merchantAccount, String transactionTypeId, Map<String,Object> options)throws Exception;
	public int countTransactionListWithTransactionType(String merchantAccountId, String transactionTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<MerchantAccount> queryList(String sql, Object ... parmeters);
 
 	public SmartList<MerchantAccount> findMerchantAccountByMerchant(String merchantId, Map<String,Object> options);
 	public int countMerchantAccountByMerchant(String merchantId, Map<String,Object> options);
 	public Map<String, Integer> countMerchantAccountByMerchantIds(String[] ids, Map<String,Object> options);
 	public SmartList<MerchantAccount> findMerchantAccountByMerchant(String merchantId, int start, int count, Map<String,Object> options);
 	public void analyzeMerchantAccountByMerchant(SmartList<MerchantAccount> resultList, String merchantId, Map<String,Object> options);

 
 }


