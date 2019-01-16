package com.doublechaintech.lsc.merchanttype;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class MerchantTypeForm extends BaseForm {
	
	
	public MerchantTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public MerchantTypeForm merchantTypeIdField(String parameterName, String initValue){
		FormField field = idFromMerchantType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm merchantTypeIdField(String initValue){
		return merchantTypeIdField("merchantTypeId",initValue);
	}
	public MerchantTypeForm merchantTypeIdField(){
		return merchantTypeIdField("merchantTypeId","");
	}


	public MerchantTypeForm nameField(String parameterName, String initValue){
		FormField field = nameFromMerchantType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public MerchantTypeForm nameField(){
		return nameField("name","");
	}


	public MerchantTypeForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromMerchantType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public MerchantTypeForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public MerchantTypeForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantTypeForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public MerchantTypeForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public MerchantTypeForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantTypeForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public MerchantTypeForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public MerchantTypeForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantTypeForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public MerchantTypeForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public MerchantTypeForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantTypeForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public MerchantTypeForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public MerchantTypeForm merchantIdFieldForMerchant(String parameterName, String initValue){
		FormField field =  idFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm merchantIdFieldForMerchant(String initValue){
		return merchantIdFieldForMerchant("merchantId",initValue);
	}
	public MerchantTypeForm merchantIdFieldForMerchant(){
		return merchantIdFieldForMerchant("merchantId","");
	}


	public MerchantTypeForm nameFieldForMerchant(String parameterName, String initValue){
		FormField field =  nameFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm nameFieldForMerchant(String initValue){
		return nameFieldForMerchant("name",initValue);
	}
	public MerchantTypeForm nameFieldForMerchant(){
		return nameFieldForMerchant("name","");
	}


	public MerchantTypeForm typeIdFieldForMerchant(String parameterName, String initValue){
		FormField field =  typeIdFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm typeIdFieldForMerchant(String initValue){
		return typeIdFieldForMerchant("typeId",initValue);
	}
	public MerchantTypeForm typeIdFieldForMerchant(){
		return typeIdFieldForMerchant("typeId","");
	}


	public MerchantTypeForm platformIdFieldForMerchant(String parameterName, String initValue){
		FormField field =  platformIdFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm platformIdFieldForMerchant(String initValue){
		return platformIdFieldForMerchant("platformId",initValue);
	}
	public MerchantTypeForm platformIdFieldForMerchant(){
		return platformIdFieldForMerchant("platformId","");
	}


	public MerchantTypeForm descriptionFieldForMerchant(String parameterName, String initValue){
		FormField field =  descriptionFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm descriptionFieldForMerchant(String initValue){
		return descriptionFieldForMerchant("description",initValue);
	}
	public MerchantTypeForm descriptionFieldForMerchant(){
		return descriptionFieldForMerchant("description","");
	}


	public MerchantTypeForm createTimeFieldForMerchant(String parameterName, String initValue){
		FormField field =  createTimeFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm createTimeFieldForMerchant(String initValue){
		return createTimeFieldForMerchant("createTime",initValue);
	}
	public MerchantTypeForm createTimeFieldForMerchant(){
		return createTimeFieldForMerchant("createTime","");
	}


	public MerchantTypeForm updateTimeFieldForMerchant(String parameterName, String initValue){
		FormField field =  updateTimeFromMerchant(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm updateTimeFieldForMerchant(String initValue){
		return updateTimeFieldForMerchant("updateTime",initValue);
	}
	public MerchantTypeForm updateTimeFieldForMerchant(){
		return updateTimeFieldForMerchant("updateTime","");
	}


	public MerchantTypeForm transportItemIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  idFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm transportItemIdFieldForTransportItem(String initValue){
		return transportItemIdFieldForTransportItem("transportItemId",initValue);
	}
	public MerchantTypeForm transportItemIdFieldForTransportItem(){
		return transportItemIdFieldForTransportItem("transportItemId","");
	}


	public MerchantTypeForm nameFieldForTransportItem(String parameterName, String initValue){
		FormField field =  nameFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm nameFieldForTransportItem(String initValue){
		return nameFieldForTransportItem("name",initValue);
	}
	public MerchantTypeForm nameFieldForTransportItem(){
		return nameFieldForTransportItem("name","");
	}


	public MerchantTypeForm quantityFieldForTransportItem(String parameterName, String initValue){
		FormField field =  quantityFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm quantityFieldForTransportItem(String initValue){
		return quantityFieldForTransportItem("quantity",initValue);
	}
	public MerchantTypeForm quantityFieldForTransportItem(){
		return quantityFieldForTransportItem("quantity","");
	}


	public MerchantTypeForm unitFieldForTransportItem(String parameterName, String initValue){
		FormField field =  unitFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm unitFieldForTransportItem(String initValue){
		return unitFieldForTransportItem("unit",initValue);
	}
	public MerchantTypeForm unitFieldForTransportItem(){
		return unitFieldForTransportItem("unit","");
	}


	public MerchantTypeForm projectIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  projectIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm projectIdFieldForTransportItem(String initValue){
		return projectIdFieldForTransportItem("projectId",initValue);
	}
	public MerchantTypeForm projectIdFieldForTransportItem(){
		return projectIdFieldForTransportItem("projectId","");
	}


	public MerchantTypeForm merchantIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  merchantIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm merchantIdFieldForTransportItem(String initValue){
		return merchantIdFieldForTransportItem("merchantId",initValue);
	}
	public MerchantTypeForm merchantIdFieldForTransportItem(){
		return merchantIdFieldForTransportItem("merchantId","");
	}


	public MerchantTypeForm platformIdFieldForTransportItem(String parameterName, String initValue){
		FormField field =  platformIdFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm platformIdFieldForTransportItem(String initValue){
		return platformIdFieldForTransportItem("platformId",initValue);
	}
	public MerchantTypeForm platformIdFieldForTransportItem(){
		return platformIdFieldForTransportItem("platformId","");
	}


	public MerchantTypeForm createTimeFieldForTransportItem(String parameterName, String initValue){
		FormField field =  createTimeFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm createTimeFieldForTransportItem(String initValue){
		return createTimeFieldForTransportItem("createTime",initValue);
	}
	public MerchantTypeForm createTimeFieldForTransportItem(){
		return createTimeFieldForTransportItem("createTime","");
	}


	public MerchantTypeForm updateTimeFieldForTransportItem(String parameterName, String initValue){
		FormField field =  updateTimeFromTransportItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantTypeForm updateTimeFieldForTransportItem(String initValue){
		return updateTimeFieldForTransportItem("updateTime",initValue);
	}
	public MerchantTypeForm updateTimeFieldForTransportItem(){
		return updateTimeFieldForTransportItem("updateTime","");
	}

	

	
 	public MerchantTypeForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/merchantTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public MerchantTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


