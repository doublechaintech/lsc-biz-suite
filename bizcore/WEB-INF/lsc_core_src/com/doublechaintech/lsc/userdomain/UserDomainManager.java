
package com.doublechaintech.lsc.userdomain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface UserDomainManager{

		

	public UserDomain createUserDomain(LscUserContext userContext, String name) throws Exception;	
	public UserDomain updateUserDomain(LscUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserDomain loadUserDomain(LscUserContext userContext, String userDomainId, String [] tokensExpr) throws Exception;
	public UserDomain internalSaveUserDomain(LscUserContext userContext, UserDomain userDomain) throws Exception;
	public UserDomain internalSaveUserDomain(LscUserContext userContext, UserDomain userDomain,Map<String,Object>option) throws Exception;
	


	public void delete(LscUserContext userContext, String userDomainId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, UserDomain newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserWhiteListManager getUserWhiteListManager(LscUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions ,String [] tokensExpr)  throws Exception;
	
	public  UserDomain addUserWhiteList(LscUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions , String [] tokensExpr)  throws Exception;
	public  UserDomain removeUserWhiteList(LscUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateUserWhiteList(LscUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SecUserManager getSecUserManager(LscUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;
	
	public  UserDomain addSecUser(LscUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  UserDomain removeSecUser(LscUserContext userContext, String userDomainId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateSecUser(LscUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  UserDomain associateSecUserListToNewBlocking(LscUserContext userContext, String userDomainId, String  secUserIds[], String who, String comments, String [] tokensExpr) throws Exception ;
	public  UserDomain associateSecUserListToBlocking(LscUserContext userContext, String userDomainId, String  secUserIds[],String blockingId, String [] tokensExpr) throws Exception ;

	*/



}


