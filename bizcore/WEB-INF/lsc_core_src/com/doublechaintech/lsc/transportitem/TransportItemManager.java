
package com.doublechaintech.lsc.transportitem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface TransportItemManager{

		

	public TransportItem createTransportItem(LscUserContext userContext, String name, int quantity, String unit, String projectId, String merchantId, String platformId) throws Exception;	
	public TransportItem updateTransportItem(LscUserContext userContext,String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportItem loadTransportItem(LscUserContext userContext, String transportItemId, String [] tokensExpr) throws Exception;
	public TransportItem internalSaveTransportItem(LscUserContext userContext, TransportItem transportItem) throws Exception;
	public TransportItem internalSaveTransportItem(LscUserContext userContext, TransportItem transportItem,Map<String,Object>option) throws Exception;
	
	public TransportItem transferToAnotherProject(LscUserContext userContext, String transportItemId, String anotherProjectId)  throws Exception;
 	public TransportItem transferToAnotherMerchant(LscUserContext userContext, String transportItemId, String anotherMerchantId)  throws Exception;
 	public TransportItem transferToAnotherPlatform(LscUserContext userContext, String transportItemId, String anotherPlatformId)  throws Exception;
 

	public void delete(LscUserContext userContext, String transportItemId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, TransportItem newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


