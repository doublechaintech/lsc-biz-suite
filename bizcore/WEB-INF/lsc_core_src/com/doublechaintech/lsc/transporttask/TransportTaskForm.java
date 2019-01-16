package com.doublechaintech.lsc.transporttask;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class TransportTaskForm extends BaseForm {
	
	
	public TransportTaskForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportTaskForm transportTaskIdField(String parameterName, String initValue){
		FormField field = idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm transportTaskIdField(String initValue){
		return transportTaskIdField("transportTaskId",initValue);
	}
	public TransportTaskForm transportTaskIdField(){
		return transportTaskIdField("transportTaskId","");
	}


	public TransportTaskForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransportTaskForm nameField(){
		return nameField("name","");
	}


	public TransportTaskForm sourceIdField(String parameterName, String initValue){
		FormField field = sourceIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm sourceIdField(String initValue){
		return sourceIdField("sourceId",initValue);
	}
	public TransportTaskForm sourceIdField(){
		return sourceIdField("sourceId","");
	}


	public TransportTaskForm destinationIdField(String parameterName, String initValue){
		FormField field = destinationIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm destinationIdField(String initValue){
		return destinationIdField("destinationId",initValue);
	}
	public TransportTaskForm destinationIdField(){
		return destinationIdField("destinationId","");
	}


	public TransportTaskForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public TransportTaskForm remarkField(){
		return remarkField("remark","");
	}


	public TransportTaskForm statusIdField(String parameterName, String initValue){
		FormField field = statusIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm statusIdField(String initValue){
		return statusIdField("statusId",initValue);
	}
	public TransportTaskForm statusIdField(){
		return statusIdField("statusId","");
	}


	public TransportTaskForm senderIdField(String parameterName, String initValue){
		FormField field = senderIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm senderIdField(String initValue){
		return senderIdField("senderId",initValue);
	}
	public TransportTaskForm senderIdField(){
		return senderIdField("senderId","");
	}


	public TransportTaskForm receiverIdField(String parameterName, String initValue){
		FormField field = receiverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm receiverIdField(String initValue){
		return receiverIdField("receiverId",initValue);
	}
	public TransportTaskForm receiverIdField(){
		return receiverIdField("receiverId","");
	}


	public TransportTaskForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public TransportTaskForm platformIdField(){
		return platformIdField("platformId","");
	}


	public TransportTaskForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public TransportTaskForm createTimeField(){
		return createTimeField("createTime","");
	}


	public TransportTaskForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public TransportTaskForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public TransportTaskForm locationIdFieldOfLocation(String parameterName, String initValue){
		FormField field =  idFromLocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm locationIdFieldOfLocation(String initValue){
		return locationIdFieldOfLocation("locationId",initValue);
	}
	public TransportTaskForm locationIdFieldOfLocation(){
		return locationIdFieldOfLocation("locationId","");
	}


	public TransportTaskForm nameFieldOfLocation(String parameterName, String initValue){
		FormField field =  nameFromLocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm nameFieldOfLocation(String initValue){
		return nameFieldOfLocation("name",initValue);
	}
	public TransportTaskForm nameFieldOfLocation(){
		return nameFieldOfLocation("name","");
	}


	public TransportTaskForm contactPersonFieldOfLocation(String parameterName, String initValue){
		FormField field =  contactPersonFromLocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm contactPersonFieldOfLocation(String initValue){
		return contactPersonFieldOfLocation("contactPerson",initValue);
	}
	public TransportTaskForm contactPersonFieldOfLocation(){
		return contactPersonFieldOfLocation("contactPerson","");
	}


	public TransportTaskForm contactPhoneFieldOfLocation(String parameterName, String initValue){
		FormField field =  contactPhoneFromLocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm contactPhoneFieldOfLocation(String initValue){
		return contactPhoneFieldOfLocation("contactPhone",initValue);
	}
	public TransportTaskForm contactPhoneFieldOfLocation(){
		return contactPhoneFieldOfLocation("contactPhone","");
	}


	public TransportTaskForm descriptionFieldOfLocation(String parameterName, String initValue){
		FormField field =  descriptionFromLocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm descriptionFieldOfLocation(String initValue){
		return descriptionFieldOfLocation("description",initValue);
	}
	public TransportTaskForm descriptionFieldOfLocation(){
		return descriptionFieldOfLocation("description","");
	}


	public TransportTaskForm platformIdFieldOfLocation(String parameterName, String initValue){
		FormField field =  platformIdFromLocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm platformIdFieldOfLocation(String initValue){
		return platformIdFieldOfLocation("platformId",initValue);
	}
	public TransportTaskForm platformIdFieldOfLocation(){
		return platformIdFieldOfLocation("platformId","");
	}


	public TransportTaskForm createTimeFieldOfLocation(String parameterName, String initValue){
		FormField field =  createTimeFromLocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm createTimeFieldOfLocation(String initValue){
		return createTimeFieldOfLocation("createTime",initValue);
	}
	public TransportTaskForm createTimeFieldOfLocation(){
		return createTimeFieldOfLocation("createTime","");
	}


	public TransportTaskForm updateTimeFieldOfLocation(String parameterName, String initValue){
		FormField field =  updateTimeFromLocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm updateTimeFieldOfLocation(String initValue){
		return updateTimeFieldOfLocation("updateTime",initValue);
	}
	public TransportTaskForm updateTimeFieldOfLocation(){
		return updateTimeFieldOfLocation("updateTime","");
	}


	public TransportTaskForm transportTaskStatusIdFieldOfTransportTaskStatus(String parameterName, String initValue){
		FormField field =  idFromTransportTaskStatus(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm transportTaskStatusIdFieldOfTransportTaskStatus(String initValue){
		return transportTaskStatusIdFieldOfTransportTaskStatus("transportTaskStatusId",initValue);
	}
	public TransportTaskForm transportTaskStatusIdFieldOfTransportTaskStatus(){
		return transportTaskStatusIdFieldOfTransportTaskStatus("transportTaskStatusId","");
	}


	public TransportTaskForm nameFieldOfTransportTaskStatus(String parameterName, String initValue){
		FormField field =  nameFromTransportTaskStatus(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm nameFieldOfTransportTaskStatus(String initValue){
		return nameFieldOfTransportTaskStatus("name",initValue);
	}
	public TransportTaskForm nameFieldOfTransportTaskStatus(){
		return nameFieldOfTransportTaskStatus("name","");
	}


	public TransportTaskForm platformIdFieldOfTransportTaskStatus(String parameterName, String initValue){
		FormField field =  platformIdFromTransportTaskStatus(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm platformIdFieldOfTransportTaskStatus(String initValue){
		return platformIdFieldOfTransportTaskStatus("platformId",initValue);
	}
	public TransportTaskForm platformIdFieldOfTransportTaskStatus(){
		return platformIdFieldOfTransportTaskStatus("platformId","");
	}


	public TransportTaskForm merchantIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  idFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm merchantIdFieldOfMerchant(String initValue){
		return merchantIdFieldOfMerchant("merchantId",initValue);
	}
	public TransportTaskForm merchantIdFieldOfMerchant(){
		return merchantIdFieldOfMerchant("merchantId","");
	}


	public TransportTaskForm nameFieldOfMerchant(String parameterName, String initValue){
		FormField field =  nameFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm nameFieldOfMerchant(String initValue){
		return nameFieldOfMerchant("name",initValue);
	}
	public TransportTaskForm nameFieldOfMerchant(){
		return nameFieldOfMerchant("name","");
	}


	public TransportTaskForm typeIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  typeIdFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm typeIdFieldOfMerchant(String initValue){
		return typeIdFieldOfMerchant("typeId",initValue);
	}
	public TransportTaskForm typeIdFieldOfMerchant(){
		return typeIdFieldOfMerchant("typeId","");
	}


	public TransportTaskForm platformIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  platformIdFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm platformIdFieldOfMerchant(String initValue){
		return platformIdFieldOfMerchant("platformId",initValue);
	}
	public TransportTaskForm platformIdFieldOfMerchant(){
		return platformIdFieldOfMerchant("platformId","");
	}


	public TransportTaskForm descriptionFieldOfMerchant(String parameterName, String initValue){
		FormField field =  descriptionFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm descriptionFieldOfMerchant(String initValue){
		return descriptionFieldOfMerchant("description",initValue);
	}
	public TransportTaskForm descriptionFieldOfMerchant(){
		return descriptionFieldOfMerchant("description","");
	}


	public TransportTaskForm createTimeFieldOfMerchant(String parameterName, String initValue){
		FormField field =  createTimeFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm createTimeFieldOfMerchant(String initValue){
		return createTimeFieldOfMerchant("createTime",initValue);
	}
	public TransportTaskForm createTimeFieldOfMerchant(){
		return createTimeFieldOfMerchant("createTime","");
	}


	public TransportTaskForm updateTimeFieldOfMerchant(String parameterName, String initValue){
		FormField field =  updateTimeFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm updateTimeFieldOfMerchant(String initValue){
		return updateTimeFieldOfMerchant("updateTime",initValue);
	}
	public TransportTaskForm updateTimeFieldOfMerchant(){
		return updateTimeFieldOfMerchant("updateTime","");
	}


	public TransportTaskForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public TransportTaskForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public TransportTaskForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public TransportTaskForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public TransportTaskForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public TransportTaskForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public TransportTaskForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public TransportTaskForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public TransportTaskForm transportTaskTrackIdFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  idFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm transportTaskTrackIdFieldForTransportTaskTrack(String initValue){
		return transportTaskTrackIdFieldForTransportTaskTrack("transportTaskTrackId",initValue);
	}
	public TransportTaskForm transportTaskTrackIdFieldForTransportTaskTrack(){
		return transportTaskTrackIdFieldForTransportTaskTrack("transportTaskTrackId","");
	}


	public TransportTaskForm nameFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  nameFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm nameFieldForTransportTaskTrack(String initValue){
		return nameFieldForTransportTaskTrack("name",initValue);
	}
	public TransportTaskForm nameFieldForTransportTaskTrack(){
		return nameFieldForTransportTaskTrack("name","");
	}


	public TransportTaskForm latitudeFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  latitudeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm latitudeFieldForTransportTaskTrack(String initValue){
		return latitudeFieldForTransportTaskTrack("latitude",initValue);
	}
	public TransportTaskForm latitudeFieldForTransportTaskTrack(){
		return latitudeFieldForTransportTaskTrack("latitude","");
	}


	public TransportTaskForm longitudeFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  longitudeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm longitudeFieldForTransportTaskTrack(String initValue){
		return longitudeFieldForTransportTaskTrack("longitude",initValue);
	}
	public TransportTaskForm longitudeFieldForTransportTaskTrack(){
		return longitudeFieldForTransportTaskTrack("longitude","");
	}


	public TransportTaskForm taskIdFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  taskIdFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm taskIdFieldForTransportTaskTrack(String initValue){
		return taskIdFieldForTransportTaskTrack("taskId",initValue);
	}
	public TransportTaskForm taskIdFieldForTransportTaskTrack(){
		return taskIdFieldForTransportTaskTrack("taskId","");
	}


	public TransportTaskForm createTimeFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  createTimeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm createTimeFieldForTransportTaskTrack(String initValue){
		return createTimeFieldForTransportTaskTrack("createTime",initValue);
	}
	public TransportTaskForm createTimeFieldForTransportTaskTrack(){
		return createTimeFieldForTransportTaskTrack("createTime","");
	}


	public TransportTaskForm updateTimeFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm updateTimeFieldForTransportTaskTrack(String initValue){
		return updateTimeFieldForTransportTaskTrack("updateTime",initValue);
	}
	public TransportTaskForm updateTimeFieldForTransportTaskTrack(){
		return updateTimeFieldForTransportTaskTrack("updateTime","");
	}

	

	
 	public TransportTaskForm transferToAnotherSourceAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSource/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportTaskForm transferToAnotherDestinationAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDestination/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportTaskForm transferToAnotherStatusAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherStatus/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportTaskForm transferToAnotherSenderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSender/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportTaskForm transferToAnotherReceiverAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherReceiver/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportTaskForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportTaskForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


