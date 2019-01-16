
package com.doublechaintech.lsc.transporttask;
import com.doublechaintech.lsc.AccessKey;


public class TransportTaskTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="transport_task_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PROJECT = "project";
	static final String COLUMN_SOURCE = "source";
	static final String COLUMN_DESTINATION = "destination";
	static final String COLUMN_REMARK = "remark";
	static final String COLUMN_STATUS = "status";
	static final String COLUMN_SENDER = "sender";
	static final String COLUMN_RECEIVER = "receiver";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_UPDATE_TIME = "update_time";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_PROJECT, COLUMN_SOURCE, COLUMN_DESTINATION, COLUMN_REMARK, COLUMN_STATUS, COLUMN_SENDER, COLUMN_RECEIVER, COLUMN_PLATFORM, COLUMN_CREATE_TIME, COLUMN_UPDATE_TIME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_PROJECT, COLUMN_SOURCE, COLUMN_DESTINATION, COLUMN_REMARK, COLUMN_STATUS, COLUMN_SENDER, COLUMN_RECEIVER, COLUMN_PLATFORM, COLUMN_CREATE_TIME, COLUMN_UPDATE_TIME
		};
	
	
}


