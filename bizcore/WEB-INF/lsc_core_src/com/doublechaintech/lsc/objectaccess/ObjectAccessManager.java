
package com.doublechaintech.lsc.objectaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface ObjectAccessManager{

		

	public ObjectAccess createObjectAccess(LscUserContext userContext, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId) throws Exception;	
	public ObjectAccess updateObjectAccess(LscUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ObjectAccess loadObjectAccess(LscUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception;
	public ObjectAccess internalSaveObjectAccess(LscUserContext userContext, ObjectAccess objectAccess) throws Exception;
	public ObjectAccess internalSaveObjectAccess(LscUserContext userContext, ObjectAccess objectAccess,Map<String,Object>option) throws Exception;
	
	public ObjectAccess transferToAnotherApp(LscUserContext userContext, String objectAccessId, String anotherAppId)  throws Exception;
 

	public void delete(LscUserContext userContext, String objectAccessId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, ObjectAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


