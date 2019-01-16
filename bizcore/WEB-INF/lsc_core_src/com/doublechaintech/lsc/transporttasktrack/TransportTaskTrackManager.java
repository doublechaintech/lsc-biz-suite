
package com.doublechaintech.lsc.transporttasktrack;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface TransportTaskTrackManager{

		

	public TransportTaskTrack createTransportTaskTrack(LscUserContext userContext, String name, BigDecimal latitude, BigDecimal longitude, String taskId) throws Exception;	
	public TransportTaskTrack updateTransportTaskTrack(LscUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportTaskTrack loadTransportTaskTrack(LscUserContext userContext, String transportTaskTrackId, String [] tokensExpr) throws Exception;
	public TransportTaskTrack internalSaveTransportTaskTrack(LscUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception;
	public TransportTaskTrack internalSaveTransportTaskTrack(LscUserContext userContext, TransportTaskTrack transportTaskTrack,Map<String,Object>option) throws Exception;
	
	public TransportTaskTrack transferToAnotherTask(LscUserContext userContext, String transportTaskTrackId, String anotherTaskId)  throws Exception;
 

	public void delete(LscUserContext userContext, String transportTaskTrackId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, TransportTaskTrack newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


