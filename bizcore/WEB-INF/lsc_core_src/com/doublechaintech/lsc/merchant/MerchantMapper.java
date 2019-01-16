
package com.doublechaintech.lsc.merchant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;

public class MerchantMapper extends BaseRowMapper<Merchant>{
	
	protected Merchant internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Merchant merchant = getMerchant();		
		 		
 		setId(merchant, rs, rowNumber); 		
 		setName(merchant, rs, rowNumber); 		
 		setType(merchant, rs, rowNumber); 		
 		setPlatform(merchant, rs, rowNumber); 		
 		setDescription(merchant, rs, rowNumber); 		
 		setCreateTime(merchant, rs, rowNumber); 		
 		setUpdateTime(merchant, rs, rowNumber); 		
 		setVersion(merchant, rs, rowNumber);

		return merchant;
	}
	
	protected Merchant getMerchant(){
		return new Merchant();
	}		
		
	protected void setId(Merchant merchant, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(MerchantTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchant.setId(id);
	}
		
	protected void setName(Merchant merchant, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(MerchantTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchant.setName(name);
	}
		 		
 	protected void setType(Merchant merchant, ResultSet rs, int rowNumber) throws SQLException{
 		String merchantTypeId = rs.getString(MerchantTable.COLUMN_TYPE);
 		if( merchantTypeId == null){
 			return;
 		}
 		if( merchantTypeId.isEmpty()){
 			return;
 		}
 		MerchantType merchantType = merchant.getType();
 		if( merchantType != null ){
 			//if the root object 'merchant' already have the property, just set the id for it;
 			merchantType.setId(merchantTypeId);
 			
 			return;
 		}
 		merchant.setType(createEmptyType(merchantTypeId));
 	}
 	 		
 	protected void setPlatform(Merchant merchant, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(MerchantTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = merchant.getPlatform();
 		if( platform != null ){
 			//if the root object 'merchant' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		merchant.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setDescription(Merchant merchant, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String description = rs.getString(MerchantTable.COLUMN_DESCRIPTION);
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchant.setDescription(description);
	}
		
	protected void setCreateTime(Merchant merchant, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(MerchantTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchant.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setUpdateTime(Merchant merchant, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(MerchantTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchant.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(Merchant merchant, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(MerchantTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchant.setVersion(version);
	}
		
		

 	protected MerchantType  createEmptyType(String merchantTypeId){
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


