
package com.doublechaintech.lsc.transportproject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface TransportProjectManager{

		

	public TransportProject createTransportProject(LscUserContext userContext, String name, String merchantId, String platformId) throws Exception;	
	public TransportProject updateTransportProject(LscUserContext userContext,String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportProject loadTransportProject(LscUserContext userContext, String transportProjectId, String [] tokensExpr) throws Exception;
	public TransportProject internalSaveTransportProject(LscUserContext userContext, TransportProject transportProject) throws Exception;
	public TransportProject internalSaveTransportProject(LscUserContext userContext, TransportProject transportProject,Map<String,Object>option) throws Exception;
	
	public TransportProject transferToAnotherMerchant(LscUserContext userContext, String transportProjectId, String anotherMerchantId)  throws Exception;
 	public TransportProject transferToAnotherPlatform(LscUserContext userContext, String transportProjectId, String anotherPlatformId)  throws Exception;
 

	public void delete(LscUserContext userContext, String transportProjectId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, TransportProject newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TransportItemManager getTransportItemManager(LscUserContext userContext, String transportProjectId, String name, int quantity, String unit, String merchantId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  TransportProject addTransportItem(LscUserContext userContext, String transportProjectId, String name, int quantity, String unit, String merchantId, String platformId , String [] tokensExpr)  throws Exception;
	public  TransportProject removeTransportItem(LscUserContext userContext, String transportProjectId, String transportItemId, int transportItemVersion,String [] tokensExpr)  throws Exception;
	public  TransportProject updateTransportItem(LscUserContext userContext, String transportProjectId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


