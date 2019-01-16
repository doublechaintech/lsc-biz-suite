
package com.doublechaintech.lsc.transaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface TransactionManager{

		

	public Transaction createTransaction(LscUserContext userContext, String name, BigDecimal amount, String transactionTypeId, String accountId) throws Exception;	
	public Transaction updateTransaction(LscUserContext userContext,String transactionId, int transactionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Transaction loadTransaction(LscUserContext userContext, String transactionId, String [] tokensExpr) throws Exception;
	public Transaction internalSaveTransaction(LscUserContext userContext, Transaction transaction) throws Exception;
	public Transaction internalSaveTransaction(LscUserContext userContext, Transaction transaction,Map<String,Object>option) throws Exception;
	
	public Transaction transferToAnotherTransactionType(LscUserContext userContext, String transactionId, String anotherTransactionTypeId)  throws Exception;
 	public Transaction transferToAnotherAccount(LscUserContext userContext, String transactionId, String anotherAccountId)  throws Exception;
 

	public void delete(LscUserContext userContext, String transactionId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, Transaction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


