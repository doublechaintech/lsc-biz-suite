
package com.doublechaintech.lsc.userapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface UserAppManager{

		

	public UserApp createUserApp(LscUserContext userContext, String title, String secUserId, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location) throws Exception;	
	public UserApp updateUserApp(LscUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserApp loadUserApp(LscUserContext userContext, String userAppId, String [] tokensExpr) throws Exception;
	public UserApp internalSaveUserApp(LscUserContext userContext, UserApp userApp) throws Exception;
	public UserApp internalSaveUserApp(LscUserContext userContext, UserApp userApp,Map<String,Object>option) throws Exception;
	
	public UserApp transferToAnotherSecUser(LscUserContext userContext, String userAppId, String anotherSecUserId)  throws Exception;
 

	public void delete(LscUserContext userContext, String userAppId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, UserApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ListAccessManager getListAccessManager(LscUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission ,String [] tokensExpr)  throws Exception;
	
	public  UserApp addListAccess(LscUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission , String [] tokensExpr)  throws Exception;
	public  UserApp removeListAccess(LscUserContext userContext, String userAppId, String listAccessId, int listAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateListAccess(LscUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ObjectAccessManager getObjectAccessManager(LscUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 ,String [] tokensExpr)  throws Exception;
	
	public  UserApp addObjectAccess(LscUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 , String [] tokensExpr)  throws Exception;
	public  UserApp removeObjectAccess(LscUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateObjectAccess(LscUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


