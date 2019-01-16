
package com.doublechaintech.lsc.transactiontype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface TransactionTypeManager{

		

	public TransactionType createTransactionType(LscUserContext userContext, String name, String platformId) throws Exception;	
	public TransactionType updateTransactionType(LscUserContext userContext,String transactionTypeId, int transactionTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransactionType loadTransactionType(LscUserContext userContext, String transactionTypeId, String [] tokensExpr) throws Exception;
	public TransactionType internalSaveTransactionType(LscUserContext userContext, TransactionType transactionType) throws Exception;
	public TransactionType internalSaveTransactionType(LscUserContext userContext, TransactionType transactionType,Map<String,Object>option) throws Exception;
	
	public TransactionType transferToAnotherPlatform(LscUserContext userContext, String transactionTypeId, String anotherPlatformId)  throws Exception;
 

	public void delete(LscUserContext userContext, String transactionTypeId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, TransactionType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TransactionManager getTransactionManager(LscUserContext userContext, String transactionTypeId, String name, BigDecimal amount, String accountId ,String [] tokensExpr)  throws Exception;
	
	public  TransactionType addTransaction(LscUserContext userContext, String transactionTypeId, String name, BigDecimal amount, String accountId , String [] tokensExpr)  throws Exception;
	public  TransactionType removeTransaction(LscUserContext userContext, String transactionTypeId, String transactionId, int transactionVersion,String [] tokensExpr)  throws Exception;
	public  TransactionType updateTransaction(LscUserContext userContext, String transactionTypeId, String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


