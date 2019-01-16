
package com.doublechaintech.lsc.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface ListAccessManager{

		

	public ListAccess createListAccess(LscUserContext userContext, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String appId) throws Exception;	
	public ListAccess updateListAccess(LscUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(LscUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(LscUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(LscUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;
	
	public ListAccess transferToAnotherApp(LscUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(LscUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


