
package com.doublechaintech.lsc.transaction;
import com.doublechaintech.lsc.AccessKey;


public class TransactionTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="transaction_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_TRANSACTION_TYPE = "transaction_type";
	static final String COLUMN_ACCOUNT = "account";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_AMOUNT, COLUMN_TRANSACTION_TYPE, COLUMN_ACCOUNT, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_AMOUNT, COLUMN_TRANSACTION_TYPE, COLUMN_ACCOUNT
		};
	
	
}


