
package com.doublechaintech.lsc.formfieldmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;

public interface FormFieldMessageManager{

		

	public FormFieldMessage createFormFieldMessage(LscUserContext userContext, String title, String parameterName, String formId, String level) throws Exception;	
	public FormFieldMessage updateFormFieldMessage(LscUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormFieldMessage loadFormFieldMessage(LscUserContext userContext, String formFieldMessageId, String [] tokensExpr) throws Exception;
	public FormFieldMessage internalSaveFormFieldMessage(LscUserContext userContext, FormFieldMessage formFieldMessage) throws Exception;
	public FormFieldMessage internalSaveFormFieldMessage(LscUserContext userContext, FormFieldMessage formFieldMessage,Map<String,Object>option) throws Exception;
	
	public FormFieldMessage transferToAnotherForm(LscUserContext userContext, String formFieldMessageId, String anotherFormId)  throws Exception;
 

	public void delete(LscUserContext userContext, String formFieldMessageId, int version) throws Exception;
	public int deleteAll(LscUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(LscUserContext userContext, FormFieldMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


