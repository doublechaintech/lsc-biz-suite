
package com.doublechaintech.lsc.loginhistory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface LoginHistoryManager{

		

	public LoginHistory createLoginHistory(LscUserContext userContext, String fromIp, String description, String secUserId) throws Exception;	
	public LoginHistory updateLoginHistory(LscUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(LscUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public LoginHistory internalSaveLoginHistory(LscUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(LscUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;
	
	public LoginHistory transferToAnotherSecUser(LscUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 

	public void delete(LscUserContext userContext, String loginHistoryId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, LoginHistory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


