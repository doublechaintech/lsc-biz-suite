package com.doublechaintech.lsc.transportproject;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class TransportProjectForm extends BaseForm {
	
	
	public TransportProjectForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportProjectForm transportProjectIdField(String parameterName, String initValue){
		FormField field = idFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm transportProjectIdField(String initValue){
		return transportProjectIdField("transportProjectId",initValue);
	}
	public TransportProjectForm transportProjectIdField(){
		return transportProjectIdField("transportProjectId","");
	}


	public TransportProjectForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransportProjectForm nameField(){
		return nameField("name","");
	}


	public TransportProjectForm merchantIdField(String parameterName, String initValue){
		FormField field = merchantIdFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm merchantIdField(String initValue){
		return merchantIdField("merchantId",initValue);
	}
	public TransportProjectForm merchantIdField(){
		return merchantIdField("merchantId","");
	}


	public TransportProjectForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public TransportProjectForm platformIdField(){
		return platformIdField("platformId","");
	}


	public TransportProjectForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public TransportProjectForm createTimeField(){
		return createTimeField("createTime","");
	}


	public TransportProjectForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public TransportProjectForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public TransportProjectForm merchantIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  idFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm merchantIdFieldOfMerchant(String initValue){
		return merchantIdFieldOfMerchant("merchantId",initValue);
	}
	public TransportProjectForm merchantIdFieldOfMerchant(){
		return merchantIdFieldOfMerchant("merchantId","");
	}


	public TransportProjectForm nameFieldOfMerchant(String parameterName, String initValue){
		FormField field =  nameFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm nameFieldOfMerchant(String initValue){
		return nameFieldOfMerchant("name",initValue);
	}
	public TransportProjectForm nameFieldOfMerchant(){
		return nameFieldOfMerchant("name","");
	}


	public TransportProjectForm typeIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  typeIdFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm typeIdFieldOfMerchant(String initValue){
		return typeIdFieldOfMerchant("typeId",initValue);
	}
	public TransportProjectForm typeIdFieldOfMerchant(){
		return typeIdFieldOfMerchant("typeId","");
	}


	public TransportProjectForm platformIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  platformIdFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm platformIdFieldOfMerchant(String initValue){
		return platformIdFieldOfMerchant("platformId",initValue);
	}
	public TransportProjectForm platformIdFieldOfMerchant(){
		return platformIdFieldOfMerchant("platformId","");
	}


	public TransportProjectForm descriptionFieldOfMerchant(String parameterName, String initValue){
		FormField field =  descriptionFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm descriptionFieldOfMerchant(String initValue){
		return descriptionFieldOfMerchant("description",initValue);
	}
	public TransportProjectForm descriptionFieldOfMerchant(){
		return descriptionFieldOfMerchant("description","");
	}


	public TransportProjectForm createTimeFieldOfMerchant(String parameterName, String initValue){
		FormField field =  createTimeFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm createTimeFieldOfMerchant(String initValue){
		return createTimeFieldOfMerchant("createTime",initValue);
	}
	public TransportProjectForm createTimeFieldOfMerchant(){
		return createTimeFieldOfMerchant("createTime","");
	}


	public TransportProjectForm updateTimeFieldOfMerchant(String parameterName, String initValue){
		FormField field =  updateTimeFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm updateTimeFieldOfMerchant(String initValue){
		return updateTimeFieldOfMerchant("updateTime",initValue);
	}
	public TransportProjectForm updateTimeFieldOfMerchant(){
		return updateTimeFieldOfMerchant("updateTime","");
	}


	public TransportProjectForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public TransportProjectForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public TransportProjectForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public TransportProjectForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public TransportProjectForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public TransportProjectForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public TransportProjectForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportProjectForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public TransportProjectForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public TransportProjectForm transportItemIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  idFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm transportItemIdFieldForTransportItem(String initValue){
		return transportItemIdFieldForTransportItem("transportItemId",initValue);
	}
	public TransportProjectForm transportItemIdFieldForTransportItem(){
		return transportItemIdFieldForTransportItem("transportItemId","");
	}


	public TransportProjectForm nameFieldForTransportItem(String parameterName, String initValue){
		FormField field =  nameFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm nameFieldForTransportItem(String initValue){
		return nameFieldForTransportItem("name",initValue);
	}
	public TransportProjectForm nameFieldForTransportItem(){
		return nameFieldForTransportItem("name","");
	}


	public TransportProjectForm quantityFieldForTransportItem(String parameterName, String initValue){
		FormField field =  quantityFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm quantityFieldForTransportItem(String initValue){
		return quantityFieldForTransportItem("quantity",initValue);
	}
	public TransportProjectForm quantityFieldForTransportItem(){
		return quantityFieldForTransportItem("quantity","");
	}


	public TransportProjectForm unitFieldForTransportItem(String parameterName, String initValue){
		FormField field =  unitFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm unitFieldForTransportItem(String initValue){
		return unitFieldForTransportItem("unit",initValue);
	}
	public TransportProjectForm unitFieldForTransportItem(){
		return unitFieldForTransportItem("unit","");
	}


	public TransportProjectForm projectIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  projectIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm projectIdFieldForTransportItem(String initValue){
		return projectIdFieldForTransportItem("projectId",initValue);
	}
	public TransportProjectForm projectIdFieldForTransportItem(){
		return projectIdFieldForTransportItem("projectId","");
	}


	public TransportProjectForm merchantIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  merchantIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm merchantIdFieldForTransportItem(String initValue){
		return merchantIdFieldForTransportItem("merchantId",initValue);
	}
	public TransportProjectForm merchantIdFieldForTransportItem(){
		return merchantIdFieldForTransportItem("merchantId","");
	}


	public TransportProjectForm platformIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  platformIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm platformIdFieldForTransportItem(String initValue){
		return platformIdFieldForTransportItem("platformId",initValue);
	}
	public TransportProjectForm platformIdFieldForTransportItem(){
		return platformIdFieldForTransportItem("platformId","");
	}


	public TransportProjectForm createTimeFieldForTransportItem(String parameterName, String initValue){
		FormField field =  createTimeFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm createTimeFieldForTransportItem(String initValue){
		return createTimeFieldForTransportItem("createTime",initValue);
	}
	public TransportProjectForm createTimeFieldForTransportItem(){
		return createTimeFieldForTransportItem("createTime","");
	}


	public TransportProjectForm updateTimeFieldForTransportItem(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm updateTimeFieldForTransportItem(String initValue){
		return updateTimeFieldForTransportItem("updateTime",initValue);
	}
	public TransportProjectForm updateTimeFieldForTransportItem(){
		return updateTimeFieldForTransportItem("updateTime","");
	}


	public TransportProjectForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public TransportProjectForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public TransportProjectForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public TransportProjectForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public TransportProjectForm projectIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  projectIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm projectIdFieldForTransportTask(String initValue){
		return projectIdFieldForTransportTask("projectId",initValue);
	}
	public TransportProjectForm projectIdFieldForTransportTask(){
		return projectIdFieldForTransportTask("projectId","");
	}


	public TransportProjectForm sourceIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  sourceIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm sourceIdFieldForTransportTask(String initValue){
		return sourceIdFieldForTransportTask("sourceId",initValue);
	}
	public TransportProjectForm sourceIdFieldForTransportTask(){
		return sourceIdFieldForTransportTask("sourceId","");
	}


	public TransportProjectForm destinationIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  destinationIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm destinationIdFieldForTransportTask(String initValue){
		return destinationIdFieldForTransportTask("destinationId",initValue);
	}
	public TransportProjectForm destinationIdFieldForTransportTask(){
		return destinationIdFieldForTransportTask("destinationId","");
	}


	public TransportProjectForm remarkFieldForTransportTask(String parameterName, String initValue){
		FormField field =  remarkFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm remarkFieldForTransportTask(String initValue){
		return remarkFieldForTransportTask("remark",initValue);
	}
	public TransportProjectForm remarkFieldForTransportTask(){
		return remarkFieldForTransportTask("remark","");
	}


	public TransportProjectForm statusIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  statusIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm statusIdFieldForTransportTask(String initValue){
		return statusIdFieldForTransportTask("statusId",initValue);
	}
	public TransportProjectForm statusIdFieldForTransportTask(){
		return statusIdFieldForTransportTask("statusId","");
	}


	public TransportProjectForm senderIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  senderIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm senderIdFieldForTransportTask(String initValue){
		return senderIdFieldForTransportTask("senderId",initValue);
	}
	public TransportProjectForm senderIdFieldForTransportTask(){
		return senderIdFieldForTransportTask("senderId","");
	}


	public TransportProjectForm receiverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  receiverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm receiverIdFieldForTransportTask(String initValue){
		return receiverIdFieldForTransportTask("receiverId",initValue);
	}
	public TransportProjectForm receiverIdFieldForTransportTask(){
		return receiverIdFieldForTransportTask("receiverId","");
	}


	public TransportProjectForm platformIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  platformIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm platformIdFieldForTransportTask(String initValue){
		return platformIdFieldForTransportTask("platformId",initValue);
	}
	public TransportProjectForm platformIdFieldForTransportTask(){
		return platformIdFieldForTransportTask("platformId","");
	}


	public TransportProjectForm createTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  createTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm createTimeFieldForTransportTask(String initValue){
		return createTimeFieldForTransportTask("createTime",initValue);
	}
	public TransportProjectForm createTimeFieldForTransportTask(){
		return createTimeFieldForTransportTask("createTime","");
	}


	public TransportProjectForm updateTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportProjectForm updateTimeFieldForTransportTask(String initValue){
		return updateTimeFieldForTransportTask("updateTime",initValue);
	}
	public TransportProjectForm updateTimeFieldForTransportTask(){
		return updateTimeFieldForTransportTask("updateTime","");
	}

	

	
 	public TransportProjectForm transferToAnotherMerchantAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherMerchant/transportProjectId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportProjectForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/transportProjectId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportProjectForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


