
package com.doublechaintech.lsc.transportproject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.platform.Platform;

public class TransportProjectMapper extends BaseRowMapper<TransportProject>{
	
	protected TransportProject internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransportProject transportProject = getTransportProject();		
		 		
 		setId(transportProject, rs, rowNumber); 		
 		setName(transportProject, rs, rowNumber); 		
 		setMerchant(transportProject, rs, rowNumber); 		
 		setPlatform(transportProject, rs, rowNumber); 		
 		setCreateTime(transportProject, rs, rowNumber); 		
 		setUpdateTime(transportProject, rs, rowNumber); 		
 		setVersion(transportProject, rs, rowNumber);

		return transportProject;
	}
	
	protected TransportProject getTransportProject(){
		return new TransportProject();
	}		
		
	protected void setId(TransportProject transportProject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TransportProjectTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportProject.setId(id);
	}
		
	protected void setName(TransportProject transportProject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TransportProjectTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportProject.setName(name);
	}
		 		
 	protected void setMerchant(TransportProject transportProject, ResultSet rs, int rowNumber) throws SQLException{
 		String merchantId = rs.getString(TransportProjectTable.COLUMN_MERCHANT);
 		if( merchantId == null){
 			return;
 		}
 		if( merchantId.isEmpty()){
 			return;
 		}
 		Merchant merchant = transportProject.getMerchant();
 		if( merchant != null ){
 			//if the root object 'transportProject' already have the property, just set the id for it;
 			merchant.setId(merchantId);
 			
 			return;
 		}
 		transportProject.setMerchant(createEmptyMerchant(merchantId));
 	}
 	 		
 	protected void setPlatform(TransportProject transportProject, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(TransportProjectTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = transportProject.getPlatform();
 		if( platform != null ){
 			//if the root object 'transportProject' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		transportProject.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setCreateTime(TransportProject transportProject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(TransportProjectTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportProject.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setUpdateTime(TransportProject transportProject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(TransportProjectTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportProject.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(TransportProject transportProject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TransportProjectTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportProject.setVersion(version);
	}
		
		

 	protected Merchant  createEmptyMerchant(String merchantId){
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


