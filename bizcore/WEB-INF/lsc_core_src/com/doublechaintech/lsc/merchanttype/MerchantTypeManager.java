
package com.doublechaintech.lsc.merchanttype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface MerchantTypeManager{

		

	public MerchantType createMerchantType(LscUserContext userContext, String name, String platformId) throws Exception;	
	public MerchantType updateMerchantType(LscUserContext userContext,String merchantTypeId, int merchantTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MerchantType loadMerchantType(LscUserContext userContext, String merchantTypeId, String [] tokensExpr) throws Exception;
	public MerchantType internalSaveMerchantType(LscUserContext userContext, MerchantType merchantType) throws Exception;
	public MerchantType internalSaveMerchantType(LscUserContext userContext, MerchantType merchantType,Map<String,Object>option) throws Exception;
	
	public MerchantType transferToAnotherPlatform(LscUserContext userContext, String merchantTypeId, String anotherPlatformId)  throws Exception;
 

	public void delete(LscUserContext userContext, String merchantTypeId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, MerchantType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  MerchantManager getMerchantManager(LscUserContext userContext, String merchantTypeId, String name, String platformId, String description ,String [] tokensExpr)  throws Exception;
	
	public  MerchantType addMerchant(LscUserContext userContext, String merchantTypeId, String name, String platformId, String description , String [] tokensExpr)  throws Exception;
	public  MerchantType removeMerchant(LscUserContext userContext, String merchantTypeId, String merchantId, int merchantVersion,String [] tokensExpr)  throws Exception;
	public  MerchantType updateMerchant(LscUserContext userContext, String merchantTypeId, String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportItemManager getTransportItemManager(LscUserContext userContext, String merchantTypeId, String name, int quantity, String unit, String projectId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  MerchantType addTransportItem(LscUserContext userContext, String merchantTypeId, String name, int quantity, String unit, String projectId, String platformId , String [] tokensExpr)  throws Exception;
	public  MerchantType removeTransportItem(LscUserContext userContext, String merchantTypeId, String transportItemId, int transportItemVersion,String [] tokensExpr)  throws Exception;
	public  MerchantType updateTransportItem(LscUserContext userContext, String merchantTypeId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


