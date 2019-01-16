
package com.doublechaintech.lsc.transporttasktrack;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.transporttask.TransportTask;

public class TransportTaskTrackMapper extends BaseRowMapper<TransportTaskTrack>{
	
	protected TransportTaskTrack internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransportTaskTrack transportTaskTrack = getTransportTaskTrack();		
		 		
 		setId(transportTaskTrack, rs, rowNumber); 		
 		setName(transportTaskTrack, rs, rowNumber); 		
 		setLatitude(transportTaskTrack, rs, rowNumber); 		
 		setLongitude(transportTaskTrack, rs, rowNumber); 		
 		setTask(transportTaskTrack, rs, rowNumber); 		
 		setCreateTime(transportTaskTrack, rs, rowNumber); 		
 		setUpdateTime(transportTaskTrack, rs, rowNumber); 		
 		setVersion(transportTaskTrack, rs, rowNumber);

		return transportTaskTrack;
	}
	
	protected TransportTaskTrack getTransportTaskTrack(){
		return new TransportTaskTrack();
	}		
		
	protected void setId(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TransportTaskTrackTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskTrack.setId(id);
	}
		
	protected void setName(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TransportTaskTrackTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskTrack.setName(name);
	}
		
	protected void setLatitude(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal latitude = rs.getBigDecimal(TransportTaskTrackTable.COLUMN_LATITUDE);
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskTrack.setLatitude(latitude);
	}
		
	protected void setLongitude(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal longitude = rs.getBigDecimal(TransportTaskTrackTable.COLUMN_LONGITUDE);
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskTrack.setLongitude(longitude);
	}
		 		
 	protected void setTask(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber) throws SQLException{
 		String transportTaskId = rs.getString(TransportTaskTrackTable.COLUMN_TASK);
 		if( transportTaskId == null){
 			return;
 		}
 		if( transportTaskId.isEmpty()){
 			return;
 		}
 		TransportTask transportTask = transportTaskTrack.getTask();
 		if( transportTask != null ){
 			//if the root object 'transportTaskTrack' already have the property, just set the id for it;
 			transportTask.setId(transportTaskId);
 			
 			return;
 		}
 		transportTaskTrack.setTask(createEmptyTask(transportTaskId));
 	}
 	
	protected void setCreateTime(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(TransportTaskTrackTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskTrack.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setUpdateTime(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(TransportTaskTrackTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskTrack.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TransportTaskTrackTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTaskTrack.setVersion(version);
	}
		
		

 	protected TransportTask  createEmptyTask(String transportTaskId){
 		TransportTask transportTask = new TransportTask();
 		transportTask.setId(transportTaskId);
 		transportTask.setVersion(Integer.MAX_VALUE);
 		return transportTask;
 	}
 	
}


