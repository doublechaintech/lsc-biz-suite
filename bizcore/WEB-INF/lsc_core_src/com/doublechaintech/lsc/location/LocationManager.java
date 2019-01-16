
package com.doublechaintech.lsc.location;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface LocationManager{

		

	public Location createLocation(LscUserContext userContext, String name, String contactPerson, String contactPhone, String description, String platformId) throws Exception;	
	public Location updateLocation(LscUserContext userContext,String locationId, int locationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Location loadLocation(LscUserContext userContext, String locationId, String [] tokensExpr) throws Exception;
	public Location internalSaveLocation(LscUserContext userContext, Location location) throws Exception;
	public Location internalSaveLocation(LscUserContext userContext, Location location,Map<String,Object>option) throws Exception;
	
	public Location transferToAnotherPlatform(LscUserContext userContext, String locationId, String anotherPlatformId)  throws Exception;
 

	public void delete(LscUserContext userContext, String locationId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, Location newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TransportTaskManager getTransportTaskManager(LscUserContext userContext, String locationId, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Location addTransportTaskAsSource(LscUserContext userContext, String locationId, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId , String [] tokensExpr)  throws Exception;
	public  Location removeTransportTaskAsSource(LscUserContext userContext, String locationId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  Location updateTransportTaskAsSource(LscUserContext userContext, String locationId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskManager getTransportTaskManager(LscUserContext userContext, String locationId, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Location addTransportTaskAsDestination(LscUserContext userContext, String locationId, String name, String projectId, String remark, String statusId, String senderId, String receiverId, String platformId , String [] tokensExpr)  throws Exception;
	public  Location removeTransportTaskAsDestination(LscUserContext userContext, String locationId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  Location updateTransportTaskAsDestination(LscUserContext userContext, String locationId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


