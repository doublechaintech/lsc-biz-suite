
package com.doublechaintech.lsc.merchantaccount;
import com.doublechaintech.lsc.AccessKey;


public class MerchantAccountTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="merchant_account_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_MERCHANT = "merchant";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_UPDATE_TIME = "update_time";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_MERCHANT, COLUMN_CREATE_TIME, COLUMN_UPDATE_TIME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_MERCHANT, COLUMN_CREATE_TIME, COLUMN_UPDATE_TIME
		};
	
	
}


