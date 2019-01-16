
package com.doublechaintech.lsc.transporttaskstatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.platform.Platform;

public class TransportTaskStatusMapper extends BaseRowMapper<TransportTaskStatus>{
	
	protected TransportTaskStatus internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransportTaskStatus transportTaskStatus = getTransportTaskStatus();		
		 		
 		setId(transportTaskStatus, rs, rowNumber); 		
 		setName(transportTaskStatus, rs, rowNumber); 		
 		setPlatform(transportTaskStatus, rs, rowNumber); 		
 		setVersion(transportTaskStatus, rs, rowNumber);

		return transportTaskStatus;
	}
	
	protected TransportTaskStatus getTransportTaskStatus(){
		return new TransportTaskStatus();
	}		
		
	protected void setId(TransportTaskStatus transportTaskStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TransportTaskStatusTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskStatus.setId(id);
	}
		
	protected void setName(TransportTaskStatus transportTaskStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TransportTaskStatusTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskStatus.setName(name);
	}
		 		
 	protected void setPlatform(TransportTaskStatus transportTaskStatus, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(TransportTaskStatusTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = transportTaskStatus.getPlatform();
 		if( platform != null ){
 			//if the root object 'transportTaskStatus' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		transportTaskStatus.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(TransportTaskStatus transportTaskStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TransportTaskStatusTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskStatus.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


