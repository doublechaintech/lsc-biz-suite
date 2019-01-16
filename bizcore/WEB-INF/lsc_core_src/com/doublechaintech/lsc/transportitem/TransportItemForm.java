package com.doublechaintech.lsc.transportitem;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class TransportItemForm extends BaseForm {
	
	
	public TransportItemForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportItemForm transportItemIdField(String parameterName, String initValue){
		FormField field = idFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm transportItemIdField(String initValue){
		return transportItemIdField("transportItemId",initValue);
	}
	public TransportItemForm transportItemIdField(){
		return transportItemIdField("transportItemId","");
	}


	public TransportItemForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransportItemForm nameField(){
		return nameField("name","");
	}


	public TransportItemForm quantityField(String parameterName, String initValue){
		FormField field = quantityFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm quantityField(String initValue){
		return quantityField("quantity",initValue);
	}
	public TransportItemForm quantityField(){
		return quantityField("quantity","");
	}


	public TransportItemForm unitField(String parameterName, String initValue){
		FormField field = unitFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm unitField(String initValue){
		return unitField("unit",initValue);
	}
	public TransportItemForm unitField(){
		return unitField("unit","");
	}


	public TransportItemForm projectIdField(String parameterName, String initValue){
		FormField field = projectIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm projectIdField(String initValue){
		return projectIdField("projectId",initValue);
	}
	public TransportItemForm projectIdField(){
		return projectIdField("projectId","");
	}


	public TransportItemForm merchantIdField(String parameterName, String initValue){
		FormField field = merchantIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm merchantIdField(String initValue){
		return merchantIdField("merchantId",initValue);
	}
	public TransportItemForm merchantIdField(){
		return merchantIdField("merchantId","");
	}


	public TransportItemForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public TransportItemForm platformIdField(){
		return platformIdField("platformId","");
	}


	public TransportItemForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public TransportItemForm createTimeField(){
		return createTimeField("createTime","");
	}


	public TransportItemForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportItemForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public TransportItemForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public TransportItemForm transportProjectIdFieldOfTransportProject(String parameterName, String initValue){
		FormField field =  idFromTransportProject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm transportProjectIdFieldOfTransportProject(String initValue){
		return transportProjectIdFieldOfTransportProject("transportProjectId",initValue);
	}
	public TransportItemForm transportProjectIdFieldOfTransportProject(){
		return transportProjectIdFieldOfTransportProject("transportProjectId","");
	}


	public TransportItemForm nameFieldOfTransportProject(String parameterName, String initValue){
		FormField field =  nameFromTransportProject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm nameFieldOfTransportProject(String initValue){
		return nameFieldOfTransportProject("name",initValue);
	}
	public TransportItemForm nameFieldOfTransportProject(){
		return nameFieldOfTransportProject("name","");
	}


	public TransportItemForm merchantIdFieldOfTransportProject(String parameterName, String initValue){
		FormField field =  merchantIdFromTransportProject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm merchantIdFieldOfTransportProject(String initValue){
		return merchantIdFieldOfTransportProject("merchantId",initValue);
	}
	public TransportItemForm merchantIdFieldOfTransportProject(){
		return merchantIdFieldOfTransportProject("merchantId","");
	}


	public TransportItemForm platformIdFieldOfTransportProject(String parameterName, String initValue){
		FormField field =  platformIdFromTransportProject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm platformIdFieldOfTransportProject(String initValue){
		return platformIdFieldOfTransportProject("platformId",initValue);
	}
	public TransportItemForm platformIdFieldOfTransportProject(){
		return platformIdFieldOfTransportProject("platformId","");
	}


	public TransportItemForm createTimeFieldOfTransportProject(String parameterName, String initValue){
		FormField field =  createTimeFromTransportProject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm createTimeFieldOfTransportProject(String initValue){
		return createTimeFieldOfTransportProject("createTime",initValue);
	}
	public TransportItemForm createTimeFieldOfTransportProject(){
		return createTimeFieldOfTransportProject("createTime","");
	}


	public TransportItemForm updateTimeFieldOfTransportProject(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportProject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm updateTimeFieldOfTransportProject(String initValue){
		return updateTimeFieldOfTransportProject("updateTime",initValue);
	}
	public TransportItemForm updateTimeFieldOfTransportProject(){
		return updateTimeFieldOfTransportProject("updateTime","");
	}


	public TransportItemForm merchantTypeIdFieldOfMerchantType(String parameterName, String initValue){
		FormField field =  idFromMerchantType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm merchantTypeIdFieldOfMerchantType(String initValue){
		return merchantTypeIdFieldOfMerchantType("merchantTypeId",initValue);
	}
	public TransportItemForm merchantTypeIdFieldOfMerchantType(){
		return merchantTypeIdFieldOfMerchantType("merchantTypeId","");
	}


	public TransportItemForm nameFieldOfMerchantType(String parameterName, String initValue){
		FormField field =  nameFromMerchantType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm nameFieldOfMerchantType(String initValue){
		return nameFieldOfMerchantType("name",initValue);
	}
	public TransportItemForm nameFieldOfMerchantType(){
		return nameFieldOfMerchantType("name","");
	}


	public TransportItemForm platformIdFieldOfMerchantType(String parameterName, String initValue){
		FormField field =  platformIdFromMerchantType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm platformIdFieldOfMerchantType(String initValue){
		return platformIdFieldOfMerchantType("platformId",initValue);
	}
	public TransportItemForm platformIdFieldOfMerchantType(){
		return platformIdFieldOfMerchantType("platformId","");
	}


	public TransportItemForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public TransportItemForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public TransportItemForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public TransportItemForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public TransportItemForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public TransportItemForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public TransportItemForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportItemForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public TransportItemForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	


	

	
 	public TransportItemForm transferToAnotherProjectAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProject/transportItemId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportItemForm transferToAnotherMerchantAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherMerchant/transportItemId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportItemForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/transportItemId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportItemForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


