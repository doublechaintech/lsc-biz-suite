
package com.doublechaintech.lsc.transporttask;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;

public class TransportTaskMapper extends BaseRowMapper<TransportTask>{
	
	protected TransportTask internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransportTask transportTask = getTransportTask();		
		 		
 		setId(transportTask, rs, rowNumber); 		
 		setName(transportTask, rs, rowNumber); 		
 		setSource(transportTask, rs, rowNumber); 		
 		setDestination(transportTask, rs, rowNumber); 		
 		setRemark(transportTask, rs, rowNumber); 		
 		setStatus(transportTask, rs, rowNumber); 		
 		setSender(transportTask, rs, rowNumber); 		
 		setReceiver(transportTask, rs, rowNumber); 		
 		setPlatform(transportTask, rs, rowNumber); 		
 		setCreateTime(transportTask, rs, rowNumber); 		
 		setUpdateTime(transportTask, rs, rowNumber); 		
 		setVersion(transportTask, rs, rowNumber);

		return transportTask;
	}
	
	protected TransportTask getTransportTask(){
		return new TransportTask();
	}		
		
	protected void setId(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TransportTaskTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setId(id);
	}
		
	protected void setName(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TransportTaskTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setName(name);
	}
		 		
 	protected void setSource(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String locationId = rs.getString(TransportTaskTable.COLUMN_SOURCE);
 		if( locationId == null){
 			return;
 		}
 		if( locationId.isEmpty()){
 			return;
 		}
 		Location location = transportTask.getSource();
 		if( location != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			location.setId(locationId);
 			
 			return;
 		}
 		transportTask.setSource(createEmptySource(locationId));
 	}
 	 		
 	protected void setDestination(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String locationId = rs.getString(TransportTaskTable.COLUMN_DESTINATION);
 		if( locationId == null){
 			return;
 		}
 		if( locationId.isEmpty()){
 			return;
 		}
 		Location location = transportTask.getDestination();
 		if( location != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			location.setId(locationId);
 			
 			return;
 		}
 		transportTask.setDestination(createEmptyDestination(locationId));
 	}
 	
	protected void setRemark(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(TransportTaskTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setRemark(remark);
	}
		 		
 	protected void setStatus(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String transportTaskStatusId = rs.getString(TransportTaskTable.COLUMN_STATUS);
 		if( transportTaskStatusId == null){
 			return;
 		}
 		if( transportTaskStatusId.isEmpty()){
 			return;
 		}
 		TransportTaskStatus transportTaskStatus = transportTask.getStatus();
 		if( transportTaskStatus != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			transportTaskStatus.setId(transportTaskStatusId);
 			
 			return;
 		}
 		transportTask.setStatus(createEmptyStatus(transportTaskStatusId));
 	}
 	 		
 	protected void setSender(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String merchantId = rs.getString(TransportTaskTable.COLUMN_SENDER);
 		if( merchantId == null){
 			return;
 		}
 		if( merchantId.isEmpty()){
 			return;
 		}
 		Merchant merchant = transportTask.getSender();
 		if( merchant != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			merchant.setId(merchantId);
 			
 			return;
 		}
 		transportTask.setSender(createEmptySender(merchantId));
 	}
 	 		
 	protected void setReceiver(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String merchantId = rs.getString(TransportTaskTable.COLUMN_RECEIVER);
 		if( merchantId == null){
 			return;
 		}
 		if( merchantId.isEmpty()){
 			return;
 		}
 		Merchant merchant = transportTask.getReceiver();
 		if( merchant != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			merchant.setId(merchantId);
 			
 			return;
 		}
 		transportTask.setReceiver(createEmptyReceiver(merchantId));
 	}
 	 		
 	protected void setPlatform(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(TransportTaskTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = transportTask.getPlatform();
 		if( platform != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		transportTask.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setCreateTime(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(TransportTaskTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setUpdateTime(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(TransportTaskTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TransportTaskTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setVersion(version);
	}
		
		

 	protected Location  createEmptySource(String locationId){
 		Location location = new Location();
 		location.setId(locationId);
 		location.setVersion(Integer.MAX_VALUE);
 		return location;
 	}
 	
 	protected Location  createEmptyDestination(String locationId){
 		Location location = new Location();
 		location.setId(locationId);
 		location.setVersion(Integer.MAX_VALUE);
 		return location;
 	}
 	
 	protected TransportTaskStatus  createEmptyStatus(String transportTaskStatusId){
 		TransportTaskStatus transportTaskStatus = new TransportTaskStatus();
 		transportTaskStatus.setId(transportTaskStatusId);
 		transportTaskStatus.setVersion(Integer.MAX_VALUE);
 		return transportTaskStatus;
 	}
 	
 	protected Merchant  createEmptySender(String merchantId){
 		Merchant merchant = new Merchant();
 		merchant.setId(merchantId);
 		merchant.setVersion(Integer.MAX_VALUE);
 		return merchant;
 	}
 	
 	protected Merchant  createEmptyReceiver(String merchantId){
 		Merchant merchant = new Merchant();
 		merchant.setId(merchantId);
 		merchant.setVersion(Integer.MAX_VALUE);
 		return merchant;
 	}
 	
 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


