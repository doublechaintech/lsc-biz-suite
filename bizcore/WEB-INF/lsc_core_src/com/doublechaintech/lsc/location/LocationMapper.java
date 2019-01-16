
package com.doublechaintech.lsc.location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.platform.Platform;

public class LocationMapper extends BaseRowMapper<Location>{
	
	protected Location internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Location location = getLocation();		
		 		
 		setId(location, rs, rowNumber); 		
 		setName(location, rs, rowNumber); 		
 		setContactPerson(location, rs, rowNumber); 		
 		setContactPhone(location, rs, rowNumber); 		
 		setDescription(location, rs, rowNumber); 		
 		setPlatform(location, rs, rowNumber); 		
 		setCreateTime(location, rs, rowNumber); 		
 		setUpdateTime(location, rs, rowNumber); 		
 		setVersion(location, rs, rowNumber);

		return location;
	}
	
	protected Location getLocation(){
		return new Location();
	}		
		
	protected void setId(Location location, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(LocationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		location.setId(id);
	}
		
	protected void setName(Location location, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(LocationTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		location.setName(name);
	}
		
	protected void setContactPerson(Location location, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String contactPerson = rs.getString(LocationTable.COLUMN_CONTACT_PERSON);
		if(contactPerson == null){
			//do nothing when nothing found in database
			return;
		}
		
		location.setContactPerson(contactPerson);
	}
		
	protected void setContactPhone(Location location, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String contactPhone = rs.getString(LocationTable.COLUMN_CONTACT_PHONE);
		if(contactPhone == null){
			//do nothing when nothing found in database
			return;
		}
		
		location.setContactPhone(contactPhone);
	}
		
	protected void setDescription(Location location, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String description = rs.getString(LocationTable.COLUMN_DESCRIPTION);
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		location.setDescription(description);
	}
		 		
 	protected void setPlatform(Location location, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(LocationTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = location.getPlatform();
 		if( platform != null ){
 			//if the root object 'location' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		location.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setCreateTime(Location location, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(LocationTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		location.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setUpdateTime(Location location, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(LocationTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		location.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(Location location, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(LocationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		location.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


