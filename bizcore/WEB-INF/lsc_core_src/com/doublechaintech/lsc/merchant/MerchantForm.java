package com.doublechaintech.lsc.merchant;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class MerchantForm extends BaseForm {
	
	
	public MerchantForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public MerchantForm merchantIdField(String parameterName, String initValue){
		FormField field = idFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm merchantIdField(String initValue){
		return merchantIdField("merchantId",initValue);
	}
	public MerchantForm merchantIdField(){
		return merchantIdField("merchantId","");
	}


	public MerchantForm nameField(String parameterName, String initValue){
		FormField field = nameFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public MerchantForm nameField(){
		return nameField("name","");
	}


	public MerchantForm typeIdField(String parameterName, String initValue){
		FormField field = typeIdFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm typeIdField(String initValue){
		return typeIdField("typeId",initValue);
	}
	public MerchantForm typeIdField(){
		return typeIdField("typeId","");
	}


	public MerchantForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public MerchantForm platformIdField(){
		return platformIdField("platformId","");
	}


	public MerchantForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public MerchantForm descriptionField(){
		return descriptionField("description","");
	}


	public MerchantForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public MerchantForm createTimeField(){
		return createTimeField("createTime","");
	}


	public MerchantForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public MerchantForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public MerchantForm merchantTypeIdFieldOfMerchantType(String parameterName, String initValue){
		FormField field =  idFromMerchantType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantForm merchantTypeIdFieldOfMerchantType(String initValue){
		return merchantTypeIdFieldOfMerchantType("merchantTypeId",initValue);
	}
	public MerchantForm merchantTypeIdFieldOfMerchantType(){
		return merchantTypeIdFieldOfMerchantType("merchantTypeId","");
	}


	public MerchantForm nameFieldOfMerchantType(String parameterName, String initValue){
		FormField field =  nameFromMerchantType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantForm nameFieldOfMerchantType(String initValue){
		return nameFieldOfMerchantType("name",initValue);
	}
	public MerchantForm nameFieldOfMerchantType(){
		return nameFieldOfMerchantType("name","");
	}


	public MerchantForm platformIdFieldOfMerchantType(String parameterName, String initValue){
		FormField field =  platformIdFromMerchantType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantForm platformIdFieldOfMerchantType(String initValue){
		return platformIdFieldOfMerchantType("platformId",initValue);
	}
	public MerchantForm platformIdFieldOfMerchantType(){
		return platformIdFieldOfMerchantType("platformId","");
	}


	public MerchantForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public MerchantForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public MerchantForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public MerchantForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public MerchantForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public MerchantForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public MerchantForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public MerchantForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public MerchantForm transportProjectIdFieldForTransportProject(String parameterName, String initValue){
		FormField field =  idFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm transportProjectIdFieldForTransportProject(String initValue){
		return transportProjectIdFieldForTransportProject("transportProjectId",initValue);
	}
	public MerchantForm transportProjectIdFieldForTransportProject(){
		return transportProjectIdFieldForTransportProject("transportProjectId","");
	}


	public MerchantForm nameFieldForTransportProject(String parameterName, String initValue){
		FormField field =  nameFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm nameFieldForTransportProject(String initValue){
		return nameFieldForTransportProject("name",initValue);
	}
	public MerchantForm nameFieldForTransportProject(){
		return nameFieldForTransportProject("name","");
	}


	public MerchantForm merchantIdFieldForTransportProject(String parameterName, String initValue){
		FormField field =  merchantIdFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm merchantIdFieldForTransportProject(String initValue){
		return merchantIdFieldForTransportProject("merchantId",initValue);
	}
	public MerchantForm merchantIdFieldForTransportProject(){
		return merchantIdFieldForTransportProject("merchantId","");
	}


	public MerchantForm platformIdFieldForTransportProject(String parameterName, String initValue){
		FormField field =  platformIdFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm platformIdFieldForTransportProject(String initValue){
		return platformIdFieldForTransportProject("platformId",initValue);
	}
	public MerchantForm platformIdFieldForTransportProject(){
		return platformIdFieldForTransportProject("platformId","");
	}


	public MerchantForm createTimeFieldForTransportProject(String parameterName, String initValue){
		FormField field =  createTimeFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm createTimeFieldForTransportProject(String initValue){
		return createTimeFieldForTransportProject("createTime",initValue);
	}
	public MerchantForm createTimeFieldForTransportProject(){
		return createTimeFieldForTransportProject("createTime","");
	}


	public MerchantForm updateTimeFieldForTransportProject(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm updateTimeFieldForTransportProject(String initValue){
		return updateTimeFieldForTransportProject("updateTime",initValue);
	}
	public MerchantForm updateTimeFieldForTransportProject(){
		return updateTimeFieldForTransportProject("updateTime","");
	}


	public MerchantForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public MerchantForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public MerchantForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public MerchantForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public MerchantForm sourceIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  sourceIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm sourceIdFieldForTransportTask(String initValue){
		return sourceIdFieldForTransportTask("sourceId",initValue);
	}
	public MerchantForm sourceIdFieldForTransportTask(){
		return sourceIdFieldForTransportTask("sourceId","");
	}


	public MerchantForm destinationIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  destinationIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm destinationIdFieldForTransportTask(String initValue){
		return destinationIdFieldForTransportTask("destinationId",initValue);
	}
	public MerchantForm destinationIdFieldForTransportTask(){
		return destinationIdFieldForTransportTask("destinationId","");
	}


	public MerchantForm remarkFieldForTransportTask(String parameterName, String initValue){
		FormField field =  remarkFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm remarkFieldForTransportTask(String initValue){
		return remarkFieldForTransportTask("remark",initValue);
	}
	public MerchantForm remarkFieldForTransportTask(){
		return remarkFieldForTransportTask("remark","");
	}


	public MerchantForm statusIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  statusIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm statusIdFieldForTransportTask(String initValue){
		return statusIdFieldForTransportTask("statusId",initValue);
	}
	public MerchantForm statusIdFieldForTransportTask(){
		return statusIdFieldForTransportTask("statusId","");
	}


	public MerchantForm senderIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  senderIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm senderIdFieldForTransportTask(String initValue){
		return senderIdFieldForTransportTask("senderId",initValue);
	}
	public MerchantForm senderIdFieldForTransportTask(){
		return senderIdFieldForTransportTask("senderId","");
	}


	public MerchantForm receiverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  receiverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm receiverIdFieldForTransportTask(String initValue){
		return receiverIdFieldForTransportTask("receiverId",initValue);
	}
	public MerchantForm receiverIdFieldForTransportTask(){
		return receiverIdFieldForTransportTask("receiverId","");
	}


	public MerchantForm platformIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  platformIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm platformIdFieldForTransportTask(String initValue){
		return platformIdFieldForTransportTask("platformId",initValue);
	}
	public MerchantForm platformIdFieldForTransportTask(){
		return platformIdFieldForTransportTask("platformId","");
	}


	public MerchantForm createTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  createTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm createTimeFieldForTransportTask(String initValue){
		return createTimeFieldForTransportTask("createTime",initValue);
	}
	public MerchantForm createTimeFieldForTransportTask(){
		return createTimeFieldForTransportTask("createTime","");
	}


	public MerchantForm updateTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm updateTimeFieldForTransportTask(String initValue){
		return updateTimeFieldForTransportTask("updateTime",initValue);
	}
	public MerchantForm updateTimeFieldForTransportTask(){
		return updateTimeFieldForTransportTask("updateTime","");
	}


	public MerchantForm merchantAccountIdFieldForMerchantAccount(String parameterName, String initValue){
		FormField field =  idFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm merchantAccountIdFieldForMerchantAccount(String initValue){
		return merchantAccountIdFieldForMerchantAccount("merchantAccountId",initValue);
	}
	public MerchantForm merchantAccountIdFieldForMerchantAccount(){
		return merchantAccountIdFieldForMerchantAccount("merchantAccountId","");
	}


	public MerchantForm nameFieldForMerchantAccount(String parameterName, String initValue){
		FormField field =  nameFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm nameFieldForMerchantAccount(String initValue){
		return nameFieldForMerchantAccount("name",initValue);
	}
	public MerchantForm nameFieldForMerchantAccount(){
		return nameFieldForMerchantAccount("name","");
	}


	public MerchantForm merchantIdFieldForMerchantAccount(String parameterName, String initValue){
		FormField field =  merchantIdFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm merchantIdFieldForMerchantAccount(String initValue){
		return merchantIdFieldForMerchantAccount("merchantId",initValue);
	}
	public MerchantForm merchantIdFieldForMerchantAccount(){
		return merchantIdFieldForMerchantAccount("merchantId","");
	}


	public MerchantForm createTimeFieldForMerchantAccount(String parameterName, String initValue){
		FormField field =  createTimeFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm createTimeFieldForMerchantAccount(String initValue){
		return createTimeFieldForMerchantAccount("createTime",initValue);
	}
	public MerchantForm createTimeFieldForMerchantAccount(){
		return createTimeFieldForMerchantAccount("createTime","");
	}


	public MerchantForm updateTimeFieldForMerchantAccount(String parameterName, String initValue){
		FormField field =  updateTimeFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantForm updateTimeFieldForMerchantAccount(String initValue){
		return updateTimeFieldForMerchantAccount("updateTime",initValue);
	}
	public MerchantForm updateTimeFieldForMerchantAccount(){
		return updateTimeFieldForMerchantAccount("updateTime","");
	}

	

	
 	public MerchantForm transferToAnotherTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherType/merchantId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public MerchantForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/merchantId/");
		this.addFormAction(action);
		return this;
	}

 

	public MerchantForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


