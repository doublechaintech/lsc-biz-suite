
package com.doublechaintech.lsc.merchantaccount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.merchant.Merchant;

public class MerchantAccountMapper extends BaseRowMapper<MerchantAccount>{
	
	protected MerchantAccount internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		MerchantAccount merchantAccount = getMerchantAccount();		
		 		
 		setId(merchantAccount, rs, rowNumber); 		
 		setName(merchantAccount, rs, rowNumber); 		
 		setMerchant(merchantAccount, rs, rowNumber); 		
 		setCreateTime(merchantAccount, rs, rowNumber); 		
 		setUpdateTime(merchantAccount, rs, rowNumber); 		
 		setVersion(merchantAccount, rs, rowNumber);

		return merchantAccount;
	}
	
	protected MerchantAccount getMerchantAccount(){
		return new MerchantAccount();
	}		
		
	protected void setId(MerchantAccount merchantAccount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(MerchantAccountTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchantAccount.setId(id);
	}
		
	protected void setName(MerchantAccount merchantAccount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(MerchantAccountTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchantAccount.setName(name);
	}
		 		
 	protected void setMerchant(MerchantAccount merchantAccount, ResultSet rs, int rowNumber) throws SQLException{
 		String merchantId = rs.getString(MerchantAccountTable.COLUMN_MERCHANT);
 		if( merchantId == null){
 			return;
 		}
 		if( merchantId.isEmpty()){
 			return;
 		}
 		Merchant merchant = merchantAccount.getMerchant();
 		if( merchant != null ){
 			//if the root object 'merchantAccount' already have the property, just set the id for it;
 			merchant.setId(merchantId);
 			
 			return;
 		}
 		merchantAccount.setMerchant(createEmptyMerchant(merchantId));
 	}
 	
	protected void setCreateTime(MerchantAccount merchantAccount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(MerchantAccountTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchantAccount.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setUpdateTime(MerchantAccount merchantAccount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(MerchantAccountTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchantAccount.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(MerchantAccount merchantAccount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(MerchantAccountTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		merchantAccount.setVersion(version);
	}
		
		

 	protected Merchant  createEmptyMerchant(String merchantId){
 		Merchant merchant = new Merchant();
 		merchant.setId(merchantId);
 		merchant.setVersion(Integer.MAX_VALUE);
 		return merchant;
 	}
 	
}


