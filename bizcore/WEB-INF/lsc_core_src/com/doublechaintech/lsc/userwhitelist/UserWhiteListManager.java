
package com.doublechaintech.lsc.userwhitelist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface UserWhiteListManager{

		

	public UserWhiteList createUserWhiteList(LscUserContext userContext, String userIdentity, String userSpecialFunctions, String domainId) throws Exception;	
	public UserWhiteList updateUserWhiteList(LscUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserWhiteList loadUserWhiteList(LscUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(LscUserContext userContext, UserWhiteList userWhiteList) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(LscUserContext userContext, UserWhiteList userWhiteList,Map<String,Object>option) throws Exception;
	
	public UserWhiteList transferToAnotherDomain(LscUserContext userContext, String userWhiteListId, String anotherDomainId)  throws Exception;
 

	public void delete(LscUserContext userContext, String userWhiteListId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, UserWhiteList newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


