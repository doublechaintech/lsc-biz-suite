package com.doublechaintech.lsc.transporttaskstatus;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class TransportTaskStatusForm extends BaseForm {
	
	
	public TransportTaskStatusForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportTaskStatusForm transportTaskStatusIdField(String parameterName, String initValue){
		FormField field = idFromTransportTaskStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm transportTaskStatusIdField(String initValue){
		return transportTaskStatusIdField("transportTaskStatusId",initValue);
	}
	public TransportTaskStatusForm transportTaskStatusIdField(){
		return transportTaskStatusIdField("transportTaskStatusId","");
	}


	public TransportTaskStatusForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransportTaskStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransportTaskStatusForm nameField(){
		return nameField("name","");
	}


	public TransportTaskStatusForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromTransportTaskStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public TransportTaskStatusForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public TransportTaskStatusForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskStatusForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public TransportTaskStatusForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public TransportTaskStatusForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskStatusForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public TransportTaskStatusForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public TransportTaskStatusForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskStatusForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public TransportTaskStatusForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public TransportTaskStatusForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskStatusForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public TransportTaskStatusForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public TransportTaskStatusForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public TransportTaskStatusForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public TransportTaskStatusForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public TransportTaskStatusForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public TransportTaskStatusForm sourceIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  sourceIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm sourceIdFieldForTransportTask(String initValue){
		return sourceIdFieldForTransportTask("sourceId",initValue);
	}
	public TransportTaskStatusForm sourceIdFieldForTransportTask(){
		return sourceIdFieldForTransportTask("sourceId","");
	}


	public TransportTaskStatusForm destinationIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  destinationIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm destinationIdFieldForTransportTask(String initValue){
		return destinationIdFieldForTransportTask("destinationId",initValue);
	}
	public TransportTaskStatusForm destinationIdFieldForTransportTask(){
		return destinationIdFieldForTransportTask("destinationId","");
	}


	public TransportTaskStatusForm remarkFieldForTransportTask(String parameterName, String initValue){
		FormField field =  remarkFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm remarkFieldForTransportTask(String initValue){
		return remarkFieldForTransportTask("remark",initValue);
	}
	public TransportTaskStatusForm remarkFieldForTransportTask(){
		return remarkFieldForTransportTask("remark","");
	}


	public TransportTaskStatusForm statusIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  statusIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm statusIdFieldForTransportTask(String initValue){
		return statusIdFieldForTransportTask("statusId",initValue);
	}
	public TransportTaskStatusForm statusIdFieldForTransportTask(){
		return statusIdFieldForTransportTask("statusId","");
	}


	public TransportTaskStatusForm senderIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  senderIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm senderIdFieldForTransportTask(String initValue){
		return senderIdFieldForTransportTask("senderId",initValue);
	}
	public TransportTaskStatusForm senderIdFieldForTransportTask(){
		return senderIdFieldForTransportTask("senderId","");
	}


	public TransportTaskStatusForm receiverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  receiverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm receiverIdFieldForTransportTask(String initValue){
		return receiverIdFieldForTransportTask("receiverId",initValue);
	}
	public TransportTaskStatusForm receiverIdFieldForTransportTask(){
		return receiverIdFieldForTransportTask("receiverId","");
	}


	public TransportTaskStatusForm platformIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  platformIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm platformIdFieldForTransportTask(String initValue){
		return platformIdFieldForTransportTask("platformId",initValue);
	}
	public TransportTaskStatusForm platformIdFieldForTransportTask(){
		return platformIdFieldForTransportTask("platformId","");
	}


	public TransportTaskStatusForm createTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  createTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm createTimeFieldForTransportTask(String initValue){
		return createTimeFieldForTransportTask("createTime",initValue);
	}
	public TransportTaskStatusForm createTimeFieldForTransportTask(){
		return createTimeFieldForTransportTask("createTime","");
	}


	public TransportTaskStatusForm updateTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskStatusForm updateTimeFieldForTransportTask(String initValue){
		return updateTimeFieldForTransportTask("updateTime",initValue);
	}
	public TransportTaskStatusForm updateTimeFieldForTransportTask(){
		return updateTimeFieldForTransportTask("updateTime","");
	}

	

	
 	public TransportTaskStatusForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/transportTaskStatusId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportTaskStatusForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


