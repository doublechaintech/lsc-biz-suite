
package com.doublechaintech.lsc.transporttask;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface TransportTaskManager{

		

	public TransportTask createTransportTask(LscUserContext userContext, String name, String sourceId, String destinationId, String remark, String statusId, String senderId, String receiverId, String platformId) throws Exception;	
	public TransportTask updateTransportTask(LscUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportTask loadTransportTask(LscUserContext userContext, String transportTaskId, String [] tokensExpr) throws Exception;
	public TransportTask internalSaveTransportTask(LscUserContext userContext, TransportTask transportTask) throws Exception;
	public TransportTask internalSaveTransportTask(LscUserContext userContext, TransportTask transportTask,Map<String,Object>option) throws Exception;
	
	public TransportTask transferToAnotherSource(LscUserContext userContext, String transportTaskId, String anotherSourceId)  throws Exception;
 	public TransportTask transferToAnotherDestination(LscUserContext userContext, String transportTaskId, String anotherDestinationId)  throws Exception;
 	public TransportTask transferToAnotherStatus(LscUserContext userContext, String transportTaskId, String anotherStatusId)  throws Exception;
 	public TransportTask transferToAnotherSender(LscUserContext userContext, String transportTaskId, String anotherSenderId)  throws Exception;
 	public TransportTask transferToAnotherReceiver(LscUserContext userContext, String transportTaskId, String anotherReceiverId)  throws Exception;
 	public TransportTask transferToAnotherPlatform(LscUserContext userContext, String transportTaskId, String anotherPlatformId)  throws Exception;
 

	public void delete(LscUserContext userContext, String transportTaskId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, TransportTask newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TransportTaskTrackManager getTransportTaskTrackManager(LscUserContext userContext, String transportTaskId, String name, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;
	
	public  TransportTask addTransportTaskTrack(LscUserContext userContext, String transportTaskId, String name, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  TransportTask removeTransportTaskTrack(LscUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr)  throws Exception;
	public  TransportTask updateTransportTaskTrack(LscUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


