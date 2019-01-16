
package com.doublechaintech.lsc.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(LscUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(LscUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(LscUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(LscUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(LscUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(LscUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(LscUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


