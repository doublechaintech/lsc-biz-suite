
package com.doublechaintech.lsc.transaction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.transactiontype.TransactionType;

public class TransactionMapper extends BaseRowMapper<Transaction>{
	
	protected Transaction internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Transaction transaction = getTransaction();		
		 		
 		setId(transaction, rs, rowNumber); 		
 		setName(transaction, rs, rowNumber); 		
 		setAmount(transaction, rs, rowNumber); 		
 		setTransactionType(transaction, rs, rowNumber); 		
 		setAccount(transaction, rs, rowNumber); 		
 		setVersion(transaction, rs, rowNumber);

		return transaction;
	}
	
	protected Transaction getTransaction(){
		return new Transaction();
	}		
		
	protected void setId(Transaction transaction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TransactionTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transaction.setId(id);
	}
		
	protected void setName(Transaction transaction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TransactionTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transaction.setName(name);
	}
		
	protected void setAmount(Transaction transaction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal amount = rs.getBigDecimal(TransactionTable.COLUMN_AMOUNT);
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		transaction.setAmount(amount);
	}
		 		
 	protected void setTransactionType(Transaction transaction, ResultSet rs, int rowNumber) throws SQLException{
 		String transactionTypeId = rs.getString(TransactionTable.COLUMN_TRANSACTION_TYPE);
 		if( transactionTypeId == null){
 			return;
 		}
 		if( transactionTypeId.isEmpty()){
 			return;
 		}
 		TransactionType transactionType = transaction.getTransactionType();
 		if( transactionType != null ){
 			//if the root object 'transaction' already have the property, just set the id for it;
 			transactionType.setId(transactionTypeId);
 			
 			return;
 		}
 		transaction.setTransactionType(createEmptyTransactionType(transactionTypeId));
 	}
 	 		
 	protected void setAccount(Transaction transaction, ResultSet rs, int rowNumber) throws SQLException{
 		String merchantAccountId = rs.getString(TransactionTable.COLUMN_ACCOUNT);
 		if( merchantAccountId == null){
 			return;
 		}
 		if( merchantAccountId.isEmpty()){
 			return;
 		}
 		MerchantAccount merchantAccount = transaction.getAccount();
 		if( merchantAccount != null ){
 			//if the root object 'transaction' already have the property, just set the id for it;
 			merchantAccount.setId(merchantAccountId);
 			
 			return;
 		}
 		transaction.setAccount(createEmptyAccount(merchantAccountId));
 	}
 	
	protected void setVersion(Transaction transaction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TransactionTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transaction.setVersion(version);
	}
		
		

 	protected TransactionType  createEmptyTransactionType(String transactionTypeId){
 		TransactionType transactionType = new TransactionType();
 		transactionType.setId(transactionTypeId);
 		transactionType.setVersion(Integer.MAX_VALUE);
 		return transactionType;
 	}
 	
 	protected MerchantAccount  createEmptyAccount(String merchantAccountId){
 		MerchantAccount merchantAccount = new MerchantAccount();
 		merchantAccount.setId(merchantAccountId);
 		merchantAccount.setVersion(Integer.MAX_VALUE);
 		return merchantAccount;
 	}
 	
}


