
package com.doublechaintech.lsc.secuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface SecUserManager{

		
	

	public SecUser loadSecUserWithLogin(LscUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 
	

	public SecUser loadSecUserWithEmail(LscUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 
	

	public SecUser loadSecUserWithMobile(LscUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

	public SecUser createSecUser(LscUserContext userContext, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId) throws Exception;	
	public SecUser updateSecUser(LscUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(LscUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public SecUser internalSaveSecUser(LscUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(LscUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;
	
	public SecUser transferToAnotherDomain(LscUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 	public SecUser block(LscUserContext userContext, String secUserId, String who, String comments
)  throws Exception;


	public void delete(LscUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, SecUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserAppManager getUserAppManager(LscUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;
	
	public  SecUser addUserApp(LscUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(LscUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(LscUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(LscUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;
	
	public  SecUser addLoginHistory(LscUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(LscUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(LscUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


