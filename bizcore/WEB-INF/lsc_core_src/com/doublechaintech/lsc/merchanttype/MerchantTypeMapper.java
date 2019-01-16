
package com.doublechaintech.lsc.merchanttype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.platform.Platform;

public class MerchantTypeMapper extends BaseRowMapper<MerchantType>{
	
	protected MerchantType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		MerchantType merchantType = getMerchantType();		
		 		
 		setId(merchantType, rs, rowNumber); 		
 		setName(merchantType, rs, rowNumber); 		
 		setPlatform(merchantType, rs, rowNumber); 		
 		setVersion(merchantType, rs, rowNumber);

		return merchantType;
	}
	
	protected MerchantType getMerchantType(){
		return new MerchantType();
	}		
		
	protected void setId(MerchantType merchantType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(MerchantTypeTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchantType.setId(id);
	}
		
	protected void setName(MerchantType merchantType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(MerchantTypeTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchantType.setName(name);
	}
		 		
 	protected void setPlatform(MerchantType merchantType, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(MerchantTypeTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = merchantType.getPlatform();
 		if( platform != null ){
 			//if the root object 'merchantType' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		merchantType.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(MerchantType merchantType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(MerchantTypeTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchantType.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


