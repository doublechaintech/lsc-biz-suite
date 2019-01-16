
package com.doublechaintech.lsc.transportitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;

public class TransportItemMapper extends BaseRowMapper<TransportItem>{
	
	protected TransportItem internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransportItem transportItem = getTransportItem();		
		 		
 		setId(transportItem, rs, rowNumber); 		
 		setName(transportItem, rs, rowNumber); 		
 		setQuantity(transportItem, rs, rowNumber); 		
 		setUnit(transportItem, rs, rowNumber); 		
 		setProject(transportItem, rs, rowNumber); 		
 		setMerchant(transportItem, rs, rowNumber); 		
 		setPlatform(transportItem, rs, rowNumber); 		
 		setCreateTime(transportItem, rs, rowNumber); 		
 		setUpdateTime(transportItem, rs, rowNumber); 		
 		setVersion(transportItem, rs, rowNumber);

		return transportItem;
	}
	
	protected TransportItem getTransportItem(){
		return new TransportItem();
	}		
		
	protected void setId(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TransportItemTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportItem.setId(id);
	}
		
	protected void setName(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TransportItemTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportItem.setName(name);
	}
		
	protected void setQuantity(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer quantity = rs.getInt(TransportItemTable.COLUMN_QUANTITY);
		if(quantity == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportItem.setQuantity(quantity);
	}
		
	protected void setUnit(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String unit = rs.getString(TransportItemTable.COLUMN_UNIT);
		if(unit == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportItem.setUnit(unit);
	}
		 		
 	protected void setProject(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
 		String transportProjectId = rs.getString(TransportItemTable.COLUMN_PROJECT);
 		if( transportProjectId == null){
 			return;
 		}
 		if( transportProjectId.isEmpty()){
 			return;
 		}
 		TransportProject transportProject = transportItem.getProject();
 		if( transportProject != null ){
 			//if the root object 'transportItem' already have the property, just set the id for it;
 			transportProject.setId(transportProjectId);
 			
 			return;
 		}
 		transportItem.setProject(createEmptyProject(transportProjectId));
 	}
 	 		
 	protected void setMerchant(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
 		String merchantTypeId = rs.getString(TransportItemTable.COLUMN_MERCHANT);
 		if( merchantTypeId == null){
 			return;
 		}
 		if( merchantTypeId.isEmpty()){
 			return;
 		}
 		MerchantType merchantType = transportItem.getMerchant();
 		if( merchantType != null ){
 			//if the root object 'transportItem' already have the property, just set the id for it;
 			merchantType.setId(merchantTypeId);
 			
 			return;
 		}
 		transportItem.setMerchant(createEmptyMerchant(merchantTypeId));
 	}
 	 		
 	protected void setPlatform(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(TransportItemTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = transportItem.getPlatform();
 		if( platform != null ){
 			//if the root object 'transportItem' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		transportItem.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setCreateTime(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(TransportItemTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportItem.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setUpdateTime(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(TransportItemTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportItem.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(TransportItem transportItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TransportItemTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportItem.setVersion(version);
	}
		
		

 	protected TransportProject  createEmptyProject(String transportProjectId){
 		TransportProject transportProject = new TransportProject();
 		transportProject.setId(transportProjectId);
 		transportProject.setVersion(Integer.MAX_VALUE);
 		return transportProject;
 	}
 	
 	protected MerchantType  createEmptyMerchant(String merchantTypeId){
 		MerchantType merchantType = new MerchantType();
 		merchantType.setId(merchantTypeId);
 		merchantType.setVersion(Integer.MAX_VALUE);
 		return merchantType;
 	}
 	
 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


