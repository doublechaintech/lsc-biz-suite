
package com.doublechaintech.lsc.transactiontype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.lsc.BaseRowMapper;
import com.doublechaintech.lsc.platform.Platform;

public class TransactionTypeMapper extends BaseRowMapper<TransactionType>{
	
	protected TransactionType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransactionType transactionType = getTransactionType();		
		 		
 		setId(transactionType, rs, rowNumber); 		
 		setName(transactionType, rs, rowNumber); 		
 		setPlatform(transactionType, rs, rowNumber); 		
 		setVersion(transactionType, rs, rowNumber);

		return transactionType;
	}
	
	protected TransactionType getTransactionType(){
		return new TransactionType();
	}		
		
	protected void setId(TransactionType transactionType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TransactionTypeTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transactionType.setId(id);
	}
		
	protected void setName(TransactionType transactionType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TransactionTypeTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transactionType.setName(name);
	}
		 		
 	protected void setPlatform(TransactionType transactionType, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(TransactionTypeTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = transactionType.getPlatform();
 		if( platform != null ){
 			//if the root object 'transactionType' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		transactionType.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(TransactionType transactionType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TransactionTypeTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transactionType.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


