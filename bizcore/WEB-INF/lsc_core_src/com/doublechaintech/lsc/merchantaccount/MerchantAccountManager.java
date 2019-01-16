
package com.doublechaintech.lsc.merchantaccount;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface MerchantAccountManager{

		

	public MerchantAccount createMerchantAccount(LscUserContext userContext, String name, String merchantId) throws Exception;	
	public MerchantAccount updateMerchantAccount(LscUserContext userContext,String merchantAccountId, int merchantAccountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MerchantAccount loadMerchantAccount(LscUserContext userContext, String merchantAccountId, String [] tokensExpr) throws Exception;
	public MerchantAccount internalSaveMerchantAccount(LscUserContext userContext, MerchantAccount merchantAccount) throws Exception;
	public MerchantAccount internalSaveMerchantAccount(LscUserContext userContext, MerchantAccount merchantAccount,Map<String,Object>option) throws Exception;
	
	public MerchantAccount transferToAnotherMerchant(LscUserContext userContext, String merchantAccountId, String anotherMerchantId)  throws Exception;
 

	public void delete(LscUserContext userContext, String merchantAccountId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, MerchantAccount newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TransactionManager getTransactionManager(LscUserContext userContext, String merchantAccountId, String name, BigDecimal amount, String transactionTypeId ,String [] tokensExpr)  throws Exception;
	
	public  MerchantAccount addTransaction(LscUserContext userContext, String merchantAccountId, String name, BigDecimal amount, String transactionTypeId , String [] tokensExpr)  throws Exception;
	public  MerchantAccount removeTransaction(LscUserContext userContext, String merchantAccountId, String transactionId, int transactionVersion,String [] tokensExpr)  throws Exception;
	public  MerchantAccount updateTransaction(LscUserContext userContext, String merchantAccountId, String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


