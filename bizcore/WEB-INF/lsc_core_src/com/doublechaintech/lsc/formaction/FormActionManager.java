
package com.doublechaintech.lsc.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface FormActionManager{

		

	public FormAction createFormAction(LscUserContext userContext, String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception;	
	public FormAction updateFormAction(LscUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(LscUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(LscUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(LscUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;
	
	public FormAction transferToAnotherForm(LscUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(LscUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}














