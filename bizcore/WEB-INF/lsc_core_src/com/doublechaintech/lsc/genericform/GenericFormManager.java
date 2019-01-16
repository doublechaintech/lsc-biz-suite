
package com.doublechaintech.lsc.genericform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface GenericFormManager{

		

	public GenericForm createGenericForm(LscUserContext userContext, String title, String description) throws Exception;	
	public GenericForm updateGenericForm(LscUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GenericForm loadGenericForm(LscUserContext userContext, String genericFormId, String [] tokensExpr) throws Exception;
	public GenericForm internalSaveGenericForm(LscUserContext userContext, GenericForm genericForm) throws Exception;
	public GenericForm internalSaveGenericForm(LscUserContext userContext, GenericForm genericForm,Map<String,Object>option) throws Exception;
	


	public void delete(LscUserContext userContext, String genericFormId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, GenericForm newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  FormMessageManager getFormMessageManager(LscUserContext userContext, String genericFormId, String title, String level ,String [] tokensExpr)  throws Exception;
	
	public  GenericForm addFormMessage(LscUserContext userContext, String genericFormId, String title, String level , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormMessage(LscUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormMessage(LscUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormFieldMessageManager getFormFieldMessageManager(LscUserContext userContext, String genericFormId, String title, String parameterName, String level ,String [] tokensExpr)  throws Exception;
	
	public  GenericForm addFormFieldMessage(LscUserContext userContext, String genericFormId, String title, String parameterName, String level , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormFieldMessage(LscUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormFieldMessage(LscUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormFieldManager getFormFieldManager(LscUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues ,String [] tokensExpr)  throws Exception;
	
	public  GenericForm addFormField(LscUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormField(LscUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormField(LscUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormActionManager getFormActionManager(LscUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url ,String [] tokensExpr)  throws Exception;
	
	public  GenericForm addFormAction(LscUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormAction(LscUserContext userContext, String genericFormId, String formActionId, int formActionVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormAction(LscUserContext userContext, String genericFormId, String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


