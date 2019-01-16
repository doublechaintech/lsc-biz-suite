package com.doublechaintech.lsc.platform;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm introductionField(String parameterName, String initValue){
		FormField field = introductionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionField(String initValue){
		return introductionField("introduction",initValue);
	}
	public PlatformForm introductionField(){
		return introductionField("introduction","");
	}


	public PlatformForm currentVersionField(String parameterName, String initValue){
		FormField field = currentVersionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm currentVersionField(String initValue){
		return currentVersionField("currentVersion",initValue);
	}
	public PlatformForm currentVersionField(){
		return currentVersionField("currentVersion","");
	}

	
	

	



	public PlatformForm transactionTypeIdFieldForTransactionType(String parameterName, String initValue){
		FormField field =  idFromTransactionType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm transactionTypeIdFieldForTransactionType(String initValue){
		return transactionTypeIdFieldForTransactionType("transactionTypeId",initValue);
	}
	public PlatformForm transactionTypeIdFieldForTransactionType(){
		return transactionTypeIdFieldForTransactionType("transactionTypeId","");
	}


	public PlatformForm nameFieldForTransactionType(String parameterName, String initValue){
		FormField field =  nameFromTransactionType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForTransactionType(String initValue){
		return nameFieldForTransactionType("name",initValue);
	}
	public PlatformForm nameFieldForTransactionType(){
		return nameFieldForTransactionType("name","");
	}


	public PlatformForm platformIdFieldForTransactionType(String parameterName, String initValue){
		FormField field =  platformIdFromTransactionType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForTransactionType(String initValue){
		return platformIdFieldForTransactionType("platformId",initValue);
	}
	public PlatformForm platformIdFieldForTransactionType(){
		return platformIdFieldForTransactionType("platformId","");
	}


	public PlatformForm merchantTypeIdFieldForMerchantType(String parameterName, String initValue){
		FormField field =  idFromMerchantType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm merchantTypeIdFieldForMerchantType(String initValue){
		return merchantTypeIdFieldForMerchantType("merchantTypeId",initValue);
	}
	public PlatformForm merchantTypeIdFieldForMerchantType(){
		return merchantTypeIdFieldForMerchantType("merchantTypeId","");
	}


	public PlatformForm nameFieldForMerchantType(String parameterName, String initValue){
		FormField field =  nameFromMerchantType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForMerchantType(String initValue){
		return nameFieldForMerchantType("name",initValue);
	}
	public PlatformForm nameFieldForMerchantType(){
		return nameFieldForMerchantType("name","");
	}


	public PlatformForm platformIdFieldForMerchantType(String parameterName, String initValue){
		FormField field =  platformIdFromMerchantType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForMerchantType(String initValue){
		return platformIdFieldForMerchantType("platformId",initValue);
	}
	public PlatformForm platformIdFieldForMerchantType(){
		return platformIdFieldForMerchantType("platformId","");
	}


	public PlatformForm transportTaskStatusIdFieldForTransportTaskStatus(String parameterName, String initValue){
		FormField field =  idFromTransportTaskStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm transportTaskStatusIdFieldForTransportTaskStatus(String initValue){
		return transportTaskStatusIdFieldForTransportTaskStatus("transportTaskStatusId",initValue);
	}
	public PlatformForm transportTaskStatusIdFieldForTransportTaskStatus(){
		return transportTaskStatusIdFieldForTransportTaskStatus("transportTaskStatusId","");
	}


	public PlatformForm nameFieldForTransportTaskStatus(String parameterName, String initValue){
		FormField field =  nameFromTransportTaskStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForTransportTaskStatus(String initValue){
		return nameFieldForTransportTaskStatus("name",initValue);
	}
	public PlatformForm nameFieldForTransportTaskStatus(){
		return nameFieldForTransportTaskStatus("name","");
	}


	public PlatformForm platformIdFieldForTransportTaskStatus(String parameterName, String initValue){
		FormField field =  platformIdFromTransportTaskStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForTransportTaskStatus(String initValue){
		return platformIdFieldForTransportTaskStatus("platformId",initValue);
	}
	public PlatformForm platformIdFieldForTransportTaskStatus(){
		return platformIdFieldForTransportTaskStatus("platformId","");
	}


	public PlatformForm locationIdFieldForLocation(String parameterName, String initValue){
		FormField field =  idFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm locationIdFieldForLocation(String initValue){
		return locationIdFieldForLocation("locationId",initValue);
	}
	public PlatformForm locationIdFieldForLocation(){
		return locationIdFieldForLocation("locationId","");
	}


	public PlatformForm nameFieldForLocation(String parameterName, String initValue){
		FormField field =  nameFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForLocation(String initValue){
		return nameFieldForLocation("name",initValue);
	}
	public PlatformForm nameFieldForLocation(){
		return nameFieldForLocation("name","");
	}


	public PlatformForm contactPersonFieldForLocation(String parameterName, String initValue){
		FormField field =  contactPersonFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm contactPersonFieldForLocation(String initValue){
		return contactPersonFieldForLocation("contactPerson",initValue);
	}
	public PlatformForm contactPersonFieldForLocation(){
		return contactPersonFieldForLocation("contactPerson","");
	}


	public PlatformForm contactPhoneFieldForLocation(String parameterName, String initValue){
		FormField field =  contactPhoneFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm contactPhoneFieldForLocation(String initValue){
		return contactPhoneFieldForLocation("contactPhone",initValue);
	}
	public PlatformForm contactPhoneFieldForLocation(){
		return contactPhoneFieldForLocation("contactPhone","");
	}


	public PlatformForm descriptionFieldForLocation(String parameterName, String initValue){
		FormField field =  descriptionFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm descriptionFieldForLocation(String initValue){
		return descriptionFieldForLocation("description",initValue);
	}
	public PlatformForm descriptionFieldForLocation(){
		return descriptionFieldForLocation("description","");
	}


	public PlatformForm platformIdFieldForLocation(String parameterName, String initValue){
		FormField field =  platformIdFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForLocation(String initValue){
		return platformIdFieldForLocation("platformId",initValue);
	}
	public PlatformForm platformIdFieldForLocation(){
		return platformIdFieldForLocation("platformId","");
	}


	public PlatformForm createTimeFieldForLocation(String parameterName, String initValue){
		FormField field =  createTimeFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForLocation(String initValue){
		return createTimeFieldForLocation("createTime",initValue);
	}
	public PlatformForm createTimeFieldForLocation(){
		return createTimeFieldForLocation("createTime","");
	}


	public PlatformForm updateTimeFieldForLocation(String parameterName, String initValue){
		FormField field =  updateTimeFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm updateTimeFieldForLocation(String initValue){
		return updateTimeFieldForLocation("updateTime",initValue);
	}
	public PlatformForm updateTimeFieldForLocation(){
		return updateTimeFieldForLocation("updateTime","");
	}


	public PlatformForm merchantIdFieldForMerchant(String parameterName, String initValue){
		FormField field =  idFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm merchantIdFieldForMerchant(String initValue){
		return merchantIdFieldForMerchant("merchantId",initValue);
	}
	public PlatformForm merchantIdFieldForMerchant(){
		return merchantIdFieldForMerchant("merchantId","");
	}


	public PlatformForm nameFieldForMerchant(String parameterName, String initValue){
		FormField field =  nameFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForMerchant(String initValue){
		return nameFieldForMerchant("name",initValue);
	}
	public PlatformForm nameFieldForMerchant(){
		return nameFieldForMerchant("name","");
	}


	public PlatformForm typeIdFieldForMerchant(String parameterName, String initValue){
		FormField field =  typeIdFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm typeIdFieldForMerchant(String initValue){
		return typeIdFieldForMerchant("typeId",initValue);
	}
	public PlatformForm typeIdFieldForMerchant(){
		return typeIdFieldForMerchant("typeId","");
	}


	public PlatformForm platformIdFieldForMerchant(String parameterName, String initValue){
		FormField field =  platformIdFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForMerchant(String initValue){
		return platformIdFieldForMerchant("platformId",initValue);
	}
	public PlatformForm platformIdFieldForMerchant(){
		return platformIdFieldForMerchant("platformId","");
	}


	public PlatformForm descriptionFieldForMerchant(String parameterName, String initValue){
		FormField field =  descriptionFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm descriptionFieldForMerchant(String initValue){
		return descriptionFieldForMerchant("description",initValue);
	}
	public PlatformForm descriptionFieldForMerchant(){
		return descriptionFieldForMerchant("description","");
	}


	public PlatformForm createTimeFieldForMerchant(String parameterName, String initValue){
		FormField field =  createTimeFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForMerchant(String initValue){
		return createTimeFieldForMerchant("createTime",initValue);
	}
	public PlatformForm createTimeFieldForMerchant(){
		return createTimeFieldForMerchant("createTime","");
	}


	public PlatformForm updateTimeFieldForMerchant(String parameterName, String initValue){
		FormField field =  updateTimeFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm updateTimeFieldForMerchant(String initValue){
		return updateTimeFieldForMerchant("updateTime",initValue);
	}
	public PlatformForm updateTimeFieldForMerchant(){
		return updateTimeFieldForMerchant("updateTime","");
	}


	public PlatformForm transportProjectIdFieldForTransportProject(String parameterName, String initValue){
		FormField field =  idFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm transportProjectIdFieldForTransportProject(String initValue){
		return transportProjectIdFieldForTransportProject("transportProjectId",initValue);
	}
	public PlatformForm transportProjectIdFieldForTransportProject(){
		return transportProjectIdFieldForTransportProject("transportProjectId","");
	}


	public PlatformForm nameFieldForTransportProject(String parameterName, String initValue){
		FormField field =  nameFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForTransportProject(String initValue){
		return nameFieldForTransportProject("name",initValue);
	}
	public PlatformForm nameFieldForTransportProject(){
		return nameFieldForTransportProject("name","");
	}


	public PlatformForm merchantIdFieldForTransportProject(String parameterName, String initValue){
		FormField field =  merchantIdFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm merchantIdFieldForTransportProject(String initValue){
		return merchantIdFieldForTransportProject("merchantId",initValue);
	}
	public PlatformForm merchantIdFieldForTransportProject(){
		return merchantIdFieldForTransportProject("merchantId","");
	}


	public PlatformForm platformIdFieldForTransportProject(String parameterName, String initValue){
		FormField field =  platformIdFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForTransportProject(String initValue){
		return platformIdFieldForTransportProject("platformId",initValue);
	}
	public PlatformForm platformIdFieldForTransportProject(){
		return platformIdFieldForTransportProject("platformId","");
	}


	public PlatformForm createTimeFieldForTransportProject(String parameterName, String initValue){
		FormField field =  createTimeFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForTransportProject(String initValue){
		return createTimeFieldForTransportProject("createTime",initValue);
	}
	public PlatformForm createTimeFieldForTransportProject(){
		return createTimeFieldForTransportProject("createTime","");
	}


	public PlatformForm updateTimeFieldForTransportProject(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportProject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm updateTimeFieldForTransportProject(String initValue){
		return updateTimeFieldForTransportProject("updateTime",initValue);
	}
	public PlatformForm updateTimeFieldForTransportProject(){
		return updateTimeFieldForTransportProject("updateTime","");
	}


	public PlatformForm transportItemIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  idFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm transportItemIdFieldForTransportItem(String initValue){
		return transportItemIdFieldForTransportItem("transportItemId",initValue);
	}
	public PlatformForm transportItemIdFieldForTransportItem(){
		return transportItemIdFieldForTransportItem("transportItemId","");
	}


	public PlatformForm nameFieldForTransportItem(String parameterName, String initValue){
		FormField field =  nameFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForTransportItem(String initValue){
		return nameFieldForTransportItem("name",initValue);
	}
	public PlatformForm nameFieldForTransportItem(){
		return nameFieldForTransportItem("name","");
	}


	public PlatformForm quantityFieldForTransportItem(String parameterName, String initValue){
		FormField field =  quantityFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm quantityFieldForTransportItem(String initValue){
		return quantityFieldForTransportItem("quantity",initValue);
	}
	public PlatformForm quantityFieldForTransportItem(){
		return quantityFieldForTransportItem("quantity","");
	}


	public PlatformForm unitFieldForTransportItem(String parameterName, String initValue){
		FormField field =  unitFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm unitFieldForTransportItem(String initValue){
		return unitFieldForTransportItem("unit",initValue);
	}
	public PlatformForm unitFieldForTransportItem(){
		return unitFieldForTransportItem("unit","");
	}


	public PlatformForm projectIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  projectIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm projectIdFieldForTransportItem(String initValue){
		return projectIdFieldForTransportItem("projectId",initValue);
	}
	public PlatformForm projectIdFieldForTransportItem(){
		return projectIdFieldForTransportItem("projectId","");
	}


	public PlatformForm merchantIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  merchantIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm merchantIdFieldForTransportItem(String initValue){
		return merchantIdFieldForTransportItem("merchantId",initValue);
	}
	public PlatformForm merchantIdFieldForTransportItem(){
		return merchantIdFieldForTransportItem("merchantId","");
	}


	public PlatformForm platformIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  platformIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForTransportItem(String initValue){
		return platformIdFieldForTransportItem("platformId",initValue);
	}
	public PlatformForm platformIdFieldForTransportItem(){
		return platformIdFieldForTransportItem("platformId","");
	}


	public PlatformForm createTimeFieldForTransportItem(String parameterName, String initValue){
		FormField field =  createTimeFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForTransportItem(String initValue){
		return createTimeFieldForTransportItem("createTime",initValue);
	}
	public PlatformForm createTimeFieldForTransportItem(){
		return createTimeFieldForTransportItem("createTime","");
	}


	public PlatformForm updateTimeFieldForTransportItem(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm updateTimeFieldForTransportItem(String initValue){
		return updateTimeFieldForTransportItem("updateTime",initValue);
	}
	public PlatformForm updateTimeFieldForTransportItem(){
		return updateTimeFieldForTransportItem("updateTime","");
	}


	public PlatformForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public PlatformForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public PlatformForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public PlatformForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public PlatformForm sourceIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  sourceIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm sourceIdFieldForTransportTask(String initValue){
		return sourceIdFieldForTransportTask("sourceId",initValue);
	}
	public PlatformForm sourceIdFieldForTransportTask(){
		return sourceIdFieldForTransportTask("sourceId","");
	}


	public PlatformForm destinationIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  destinationIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm destinationIdFieldForTransportTask(String initValue){
		return destinationIdFieldForTransportTask("destinationId",initValue);
	}
	public PlatformForm destinationIdFieldForTransportTask(){
		return destinationIdFieldForTransportTask("destinationId","");
	}


	public PlatformForm remarkFieldForTransportTask(String parameterName, String initValue){
		FormField field =  remarkFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForTransportTask(String initValue){
		return remarkFieldForTransportTask("remark",initValue);
	}
	public PlatformForm remarkFieldForTransportTask(){
		return remarkFieldForTransportTask("remark","");
	}


	public PlatformForm statusIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  statusIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm statusIdFieldForTransportTask(String initValue){
		return statusIdFieldForTransportTask("statusId",initValue);
	}
	public PlatformForm statusIdFieldForTransportTask(){
		return statusIdFieldForTransportTask("statusId","");
	}


	public PlatformForm senderIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  senderIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm senderIdFieldForTransportTask(String initValue){
		return senderIdFieldForTransportTask("senderId",initValue);
	}
	public PlatformForm senderIdFieldForTransportTask(){
		return senderIdFieldForTransportTask("senderId","");
	}


	public PlatformForm receiverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  receiverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm receiverIdFieldForTransportTask(String initValue){
		return receiverIdFieldForTransportTask("receiverId",initValue);
	}
	public PlatformForm receiverIdFieldForTransportTask(){
		return receiverIdFieldForTransportTask("receiverId","");
	}


	public PlatformForm platformIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  platformIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForTransportTask(String initValue){
		return platformIdFieldForTransportTask("platformId",initValue);
	}
	public PlatformForm platformIdFieldForTransportTask(){
		return platformIdFieldForTransportTask("platformId","");
	}


	public PlatformForm createTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  createTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForTransportTask(String initValue){
		return createTimeFieldForTransportTask("createTime",initValue);
	}
	public PlatformForm createTimeFieldForTransportTask(){
		return createTimeFieldForTransportTask("createTime","");
	}


	public PlatformForm updateTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm updateTimeFieldForTransportTask(String initValue){
		return updateTimeFieldForTransportTask("updateTime",initValue);
	}
	public PlatformForm updateTimeFieldForTransportTask(){
		return updateTimeFieldForTransportTask("updateTime","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


