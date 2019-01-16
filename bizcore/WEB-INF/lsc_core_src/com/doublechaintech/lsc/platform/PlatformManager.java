
package com.doublechaintech.lsc.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(LscUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(LscUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(LscUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(LscUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(LscUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(LscUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TransactionTypeManager getTransactionTypeManager(LscUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTransactionType(LscUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeTransactionType(LscUserContext userContext, String platformId, String transactionTypeId, int transactionTypeVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTransactionType(LscUserContext userContext, String platformId, String transactionTypeId, int transactionTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MerchantTypeManager getMerchantTypeManager(LscUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addMerchantType(LscUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeMerchantType(LscUserContext userContext, String platformId, String merchantTypeId, int merchantTypeVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateMerchantType(LscUserContext userContext, String platformId, String merchantTypeId, int merchantTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskStatusManager getTransportTaskStatusManager(LscUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTransportTaskStatus(LscUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeTransportTaskStatus(LscUserContext userContext, String platformId, String transportTaskStatusId, int transportTaskStatusVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTransportTaskStatus(LscUserContext userContext, String platformId, String transportTaskStatusId, int transportTaskStatusVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LocationManager getLocationManager(LscUserContext userContext, String platformId, String name, String contactPerson, String contactPhone, String description ,String [] tokensExpr)  throws Exception;
	
	public  Platform addLocation(LscUserContext userContext, String platformId, String name, String contactPerson, String contactPhone, String description , String [] tokensExpr)  throws Exception;
	public  Platform removeLocation(LscUserContext userContext, String platformId, String locationId, int locationVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateLocation(LscUserContext userContext, String platformId, String locationId, int locationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MerchantManager getMerchantManager(LscUserContext userContext, String platformId, String name, String typeId, String description ,String [] tokensExpr)  throws Exception;
	
	public  Platform addMerchant(LscUserContext userContext, String platformId, String name, String typeId, String description , String [] tokensExpr)  throws Exception;
	public  Platform removeMerchant(LscUserContext userContext, String platformId, String merchantId, int merchantVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateMerchant(LscUserContext userContext, String platformId, String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportProjectManager getTransportProjectManager(LscUserContext userContext, String platformId, String name, String merchantId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTransportProject(LscUserContext userContext, String platformId, String name, String merchantId , String [] tokensExpr)  throws Exception;
	public  Platform removeTransportProject(LscUserContext userContext, String platformId, String transportProjectId, int transportProjectVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTransportProject(LscUserContext userContext, String platformId, String transportProjectId, int transportProjectVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportItemManager getTransportItemManager(LscUserContext userContext, String platformId, String name, int quantity, String unit, String projectId, String merchantId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTransportItem(LscUserContext userContext, String platformId, String name, int quantity, String unit, String projectId, String merchantId , String [] tokensExpr)  throws Exception;
	public  Platform removeTransportItem(LscUserContext userContext, String platformId, String transportItemId, int transportItemVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTransportItem(LscUserContext userContext, String platformId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskManager getTransportTaskManager(LscUserContext userContext, String platformId, String name, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTransportTask(LscUserContext userContext, String platformId, String name, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId , String [] tokensExpr)  throws Exception;
	public  Platform removeTransportTask(LscUserContext userContext, String platformId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTransportTask(LscUserContext userContext, String platformId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


