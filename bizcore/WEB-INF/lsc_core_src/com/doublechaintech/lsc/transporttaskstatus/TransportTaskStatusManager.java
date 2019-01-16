
package com.doublechaintech.lsc.transporttaskstatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface TransportTaskStatusManager{

		

	public TransportTaskStatus createTransportTaskStatus(LscUserContext userContext, String name, String platformId) throws Exception;	
	public TransportTaskStatus updateTransportTaskStatus(LscUserContext userContext,String transportTaskStatusId, int transportTaskStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportTaskStatus loadTransportTaskStatus(LscUserContext userContext, String transportTaskStatusId, String [] tokensExpr) throws Exception;
	public TransportTaskStatus internalSaveTransportTaskStatus(LscUserContext userContext, TransportTaskStatus transportTaskStatus) throws Exception;
	public TransportTaskStatus internalSaveTransportTaskStatus(LscUserContext userContext, TransportTaskStatus transportTaskStatus,Map<String,Object>option) throws Exception;
	
	public TransportTaskStatus transferToAnotherPlatform(LscUserContext userContext, String transportTaskStatusId, String anotherPlatformId)  throws Exception;
 

	public void delete(LscUserContext userContext, String transportTaskStatusId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, TransportTaskStatus newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TransportTaskManager getTransportTaskManager(LscUserContext userContext, String transportTaskStatusId, String name, String sourceId, String destinationId, String remark, String senderId, String receiverId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  TransportTaskStatus addTransportTask(LscUserContext userContext, String transportTaskStatusId, String name, String sourceId, String destinationId, String remark, String senderId, String receiverId, String platformId , String [] tokensExpr)  throws Exception;
	public  TransportTaskStatus removeTransportTask(LscUserContext userContext, String transportTaskStatusId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TransportTaskStatus updateTransportTask(LscUserContext userContext, String transportTaskStatusId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


