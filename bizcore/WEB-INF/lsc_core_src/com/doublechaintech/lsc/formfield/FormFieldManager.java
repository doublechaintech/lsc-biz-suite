
package com.doublechaintech.lsc.formfield;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface FormFieldManager{

		

	public FormField createFormField(LscUserContext userContext, String label, String localeKey, String parameterName, String type, String formId, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues) throws Exception;	
	public FormField updateFormField(LscUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormField loadFormField(LscUserContext userContext, String formFieldId, String [] tokensExpr) throws Exception;
	public FormField internalSaveFormField(LscUserContext userContext, FormField formField) throws Exception;
	public FormField internalSaveFormField(LscUserContext userContext, FormField formField,Map<String,Object>option) throws Exception;
	
	public FormField transferToAnotherForm(LscUserContext userContext, String formFieldId, String anotherFormId)  throws Exception;
 

	public void delete(LscUserContext userContext, String formFieldId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, FormField newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


