
package com.doublechaintech.lsc.secuserblocking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface SecUserBlockingManager{

		

	public SecUserBlocking createSecUserBlocking(LscUserContext userContext, String who, String comments) throws Exception;	
	public SecUserBlocking updateSecUserBlocking(LscUserContext userContext,String secUserBlockingId, int secUserBlockingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUserBlocking loadSecUserBlocking(LscUserContext userContext, String secUserBlockingId, String [] tokensExpr) throws Exception;
	public SecUserBlocking internalSaveSecUserBlocking(LscUserContext userContext, SecUserBlocking secUserBlocking) throws Exception;
	public SecUserBlocking internalSaveSecUserBlocking(LscUserContext userContext, SecUserBlocking secUserBlocking,Map<String,Object>option) throws Exception;
	


	public void delete(LscUserContext userContext, String secUserBlockingId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, SecUserBlocking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SecUserManager getSecUserManager(LscUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId ,String [] tokensExpr)  throws Exception;
	
	public  SecUserBlocking addSecUser(LscUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId , String [] tokensExpr)  throws Exception;
	public  SecUserBlocking removeSecUser(LscUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  SecUserBlocking updateSecUser(LscUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


