
package com.doublechaintech.lsc.merchant;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface MerchantManager{

		

	public Merchant createMerchant(LscUserContext userContext, String name, String typeId, String platformId, String description) throws Exception;	
	public Merchant updateMerchant(LscUserContext userContext,String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Merchant loadMerchant(LscUserContext userContext, String merchantId, String [] tokensExpr) throws Exception;
	public Merchant internalSaveMerchant(LscUserContext userContext, Merchant merchant) throws Exception;
	public Merchant internalSaveMerchant(LscUserContext userContext, Merchant merchant,Map<String,Object>option) throws Exception;
	
	public Merchant transferToAnotherType(LscUserContext userContext, String merchantId, String anotherTypeId)  throws Exception;
 	public Merchant transferToAnotherPlatform(LscUserContext userContext, String merchantId, String anotherPlatformId)  throws Exception;
 

	public void delete(LscUserContext userContext, String merchantId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, Merchant newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TransportProjectManager getTransportProjectManager(LscUserContext userContext, String merchantId, String name, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Merchant addTransportProject(LscUserContext userContext, String merchantId, String name, String platformId , String [] tokensExpr)  throws Exception;
	public  Merchant removeTransportProject(LscUserContext userContext, String merchantId, String transportProjectId, int transportProjectVersion,String [] tokensExpr)  throws Exception;
	public  Merchant updateTransportProject(LscUserContext userContext, String merchantId, String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskManager getTransportTaskManager(LscUserContext userContext, String merchantId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Merchant addTransportTaskAsSender(LscUserContext userContext, String merchantId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId , String [] tokensExpr)  throws Exception;
	public  Merchant removeTransportTaskAsSender(LscUserContext userContext, String merchantId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  Merchant updateTransportTaskAsSender(LscUserContext userContext, String merchantId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskManager getTransportTaskManager(LscUserContext userContext, String merchantId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Merchant addTransportTaskAsReceiver(LscUserContext userContext, String merchantId, String name, String projectId, String sourceId, String destinationId, String remark, String statusId, String platformId , String [] tokensExpr)  throws Exception;
	public  Merchant removeTransportTaskAsReceiver(LscUserContext userContext, String merchantId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  Merchant updateTransportTaskAsReceiver(LscUserContext userContext, String merchantId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MerchantAccountManager getMerchantAccountManager(LscUserContext userContext, String merchantId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Merchant addMerchantAccount(LscUserContext userContext, String merchantId, String name , String [] tokensExpr)  throws Exception;
	public  Merchant removeMerchantAccount(LscUserContext userContext, String merchantId, String merchantAccountId, int merchantAccountVersion,String [] tokensExpr)  throws Exception;
	public  Merchant updateMerchantAccount(LscUserContext userContext, String merchantId, String merchantAccountId, int merchantAccountVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


