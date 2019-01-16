package com.doublechaintech.lsc.location;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class LocationForm extends BaseForm {
	
	
	public LocationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LocationForm locationIdField(String parameterName, String initValue){
		FormField field = idFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm locationIdField(String initValue){
		return locationIdField("locationId",initValue);
	}
	public LocationForm locationIdField(){
		return locationIdField("locationId","");
	}


	public LocationForm nameField(String parameterName, String initValue){
		FormField field = nameFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LocationForm nameField(){
		return nameField("name","");
	}


	public LocationForm contactPersonField(String parameterName, String initValue){
		FormField field = contactPersonFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm contactPersonField(String initValue){
		return contactPersonField("contactPerson",initValue);
	}
	public LocationForm contactPersonField(){
		return contactPersonField("contactPerson","");
	}


	public LocationForm contactPhoneField(String parameterName, String initValue){
		FormField field = contactPhoneFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm contactPhoneField(String initValue){
		return contactPhoneField("contactPhone",initValue);
	}
	public LocationForm contactPhoneField(){
		return contactPhoneField("contactPhone","");
	}


	public LocationForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public LocationForm descriptionField(){
		return descriptionField("description","");
	}


	public LocationForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public LocationForm platformIdField(){
		return platformIdField("platformId","");
	}


	public LocationForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public LocationForm createTimeField(){
		return createTimeField("createTime","");
	}


	public LocationForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromLocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public LocationForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public LocationForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LocationForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public LocationForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public LocationForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LocationForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public LocationForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public LocationForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LocationForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public LocationForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public LocationForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LocationForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public LocationForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public LocationForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public LocationForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public LocationForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public LocationForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public LocationForm sourceIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  sourceIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm sourceIdFieldForTransportTask(String initValue){
		return sourceIdFieldForTransportTask("sourceId",initValue);
	}
	public LocationForm sourceIdFieldForTransportTask(){
		return sourceIdFieldForTransportTask("sourceId","");
	}


	public LocationForm destinationIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  destinationIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm destinationIdFieldForTransportTask(String initValue){
		return destinationIdFieldForTransportTask("destinationId",initValue);
	}
	public LocationForm destinationIdFieldForTransportTask(){
		return destinationIdFieldForTransportTask("destinationId","");
	}


	public LocationForm remarkFieldForTransportTask(String parameterName, String initValue){
		FormField field =  remarkFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm remarkFieldForTransportTask(String initValue){
		return remarkFieldForTransportTask("remark",initValue);
	}
	public LocationForm remarkFieldForTransportTask(){
		return remarkFieldForTransportTask("remark","");
	}


	public LocationForm statusIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  statusIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm statusIdFieldForTransportTask(String initValue){
		return statusIdFieldForTransportTask("statusId",initValue);
	}
	public LocationForm statusIdFieldForTransportTask(){
		return statusIdFieldForTransportTask("statusId","");
	}


	public LocationForm senderIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  senderIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm senderIdFieldForTransportTask(String initValue){
		return senderIdFieldForTransportTask("senderId",initValue);
	}
	public LocationForm senderIdFieldForTransportTask(){
		return senderIdFieldForTransportTask("senderId","");
	}


	public LocationForm receiverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  receiverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm receiverIdFieldForTransportTask(String initValue){
		return receiverIdFieldForTransportTask("receiverId",initValue);
	}
	public LocationForm receiverIdFieldForTransportTask(){
		return receiverIdFieldForTransportTask("receiverId","");
	}


	public LocationForm platformIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  platformIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm platformIdFieldForTransportTask(String initValue){
		return platformIdFieldForTransportTask("platformId",initValue);
	}
	public LocationForm platformIdFieldForTransportTask(){
		return platformIdFieldForTransportTask("platformId","");
	}


	public LocationForm createTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  createTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm createTimeFieldForTransportTask(String initValue){
		return createTimeFieldForTransportTask("createTime",initValue);
	}
	public LocationForm createTimeFieldForTransportTask(){
		return createTimeFieldForTransportTask("createTime","");
	}


	public LocationForm updateTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LocationForm updateTimeFieldForTransportTask(String initValue){
		return updateTimeFieldForTransportTask("updateTime",initValue);
	}
	public LocationForm updateTimeFieldForTransportTask(){
		return updateTimeFieldForTransportTask("updateTime","");
	}

	

	
 	public LocationForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/locationId/");
		this.addFormAction(action);
		return this;
	}

 

	public LocationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


