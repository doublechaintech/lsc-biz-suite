package com.doublechaintech.lsc.transporttasktrack;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class TransportTaskTrackForm extends BaseForm {
	
	
	public TransportTaskTrackForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportTaskTrackForm transportTaskTrackIdField(String parameterName, String initValue){
		FormField field = idFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm transportTaskTrackIdField(String initValue){
		return transportTaskTrackIdField("transportTaskTrackId",initValue);
	}
	public TransportTaskTrackForm transportTaskTrackIdField(){
		return transportTaskTrackIdField("transportTaskTrackId","");
	}


	public TransportTaskTrackForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransportTaskTrackForm nameField(){
		return nameField("name","");
	}


	public TransportTaskTrackForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public TransportTaskTrackForm latitudeField(){
		return latitudeField("latitude","");
	}


	public TransportTaskTrackForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public TransportTaskTrackForm longitudeField(){
		return longitudeField("longitude","");
	}


	public TransportTaskTrackForm taskIdField(String parameterName, String initValue){
		FormField field = taskIdFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm taskIdField(String initValue){
		return taskIdField("taskId",initValue);
	}
	public TransportTaskTrackForm taskIdField(){
		return taskIdField("taskId","");
	}


	public TransportTaskTrackForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public TransportTaskTrackForm createTimeField(){
		return createTimeField("createTime","");
	}


	public TransportTaskTrackForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public TransportTaskTrackForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public TransportTaskTrackForm transportTaskIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm transportTaskIdFieldOfTransportTask(String initValue){
		return transportTaskIdFieldOfTransportTask("transportTaskId",initValue);
	}
	public TransportTaskTrackForm transportTaskIdFieldOfTransportTask(){
		return transportTaskIdFieldOfTransportTask("transportTaskId","");
	}


	public TransportTaskTrackForm nameFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm nameFieldOfTransportTask(String initValue){
		return nameFieldOfTransportTask("name",initValue);
	}
	public TransportTaskTrackForm nameFieldOfTransportTask(){
		return nameFieldOfTransportTask("name","");
	}


	public TransportTaskTrackForm sourceIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  sourceIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm sourceIdFieldOfTransportTask(String initValue){
		return sourceIdFieldOfTransportTask("sourceId",initValue);
	}
	public TransportTaskTrackForm sourceIdFieldOfTransportTask(){
		return sourceIdFieldOfTransportTask("sourceId","");
	}


	public TransportTaskTrackForm destinationIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  destinationIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm destinationIdFieldOfTransportTask(String initValue){
		return destinationIdFieldOfTransportTask("destinationId",initValue);
	}
	public TransportTaskTrackForm destinationIdFieldOfTransportTask(){
		return destinationIdFieldOfTransportTask("destinationId","");
	}


	public TransportTaskTrackForm remarkFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  remarkFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm remarkFieldOfTransportTask(String initValue){
		return remarkFieldOfTransportTask("remark",initValue);
	}
	public TransportTaskTrackForm remarkFieldOfTransportTask(){
		return remarkFieldOfTransportTask("remark","");
	}


	public TransportTaskTrackForm statusIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  statusIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm statusIdFieldOfTransportTask(String initValue){
		return statusIdFieldOfTransportTask("statusId",initValue);
	}
	public TransportTaskTrackForm statusIdFieldOfTransportTask(){
		return statusIdFieldOfTransportTask("statusId","");
	}


	public TransportTaskTrackForm senderIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  senderIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm senderIdFieldOfTransportTask(String initValue){
		return senderIdFieldOfTransportTask("senderId",initValue);
	}
	public TransportTaskTrackForm senderIdFieldOfTransportTask(){
		return senderIdFieldOfTransportTask("senderId","");
	}


	public TransportTaskTrackForm receiverIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  receiverIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm receiverIdFieldOfTransportTask(String initValue){
		return receiverIdFieldOfTransportTask("receiverId",initValue);
	}
	public TransportTaskTrackForm receiverIdFieldOfTransportTask(){
		return receiverIdFieldOfTransportTask("receiverId","");
	}


	public TransportTaskTrackForm platformIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  platformIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm platformIdFieldOfTransportTask(String initValue){
		return platformIdFieldOfTransportTask("platformId",initValue);
	}
	public TransportTaskTrackForm platformIdFieldOfTransportTask(){
		return platformIdFieldOfTransportTask("platformId","");
	}


	public TransportTaskTrackForm createTimeFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  createTimeFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm createTimeFieldOfTransportTask(String initValue){
		return createTimeFieldOfTransportTask("createTime",initValue);
	}
	public TransportTaskTrackForm createTimeFieldOfTransportTask(){
		return createTimeFieldOfTransportTask("createTime","");
	}


	public TransportTaskTrackForm updateTimeFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm updateTimeFieldOfTransportTask(String initValue){
		return updateTimeFieldOfTransportTask("updateTime",initValue);
	}
	public TransportTaskTrackForm updateTimeFieldOfTransportTask(){
		return updateTimeFieldOfTransportTask("updateTime","");
	}

	


	

	
 	public TransportTaskTrackForm transferToAnotherTaskAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherTask/transportTaskTrackId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportTaskTrackForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


