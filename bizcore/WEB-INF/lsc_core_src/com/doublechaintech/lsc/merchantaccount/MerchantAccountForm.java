package com.doublechaintech.lsc.merchantaccount;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class MerchantAccountForm extends BaseForm {
	
	
	public MerchantAccountForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public MerchantAccountForm merchantAccountIdField(String parameterName, String initValue){
		FormField field = idFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm merchantAccountIdField(String initValue){
		return merchantAccountIdField("merchantAccountId",initValue);
	}
	public MerchantAccountForm merchantAccountIdField(){
		return merchantAccountIdField("merchantAccountId","");
	}


	public MerchantAccountForm nameField(String parameterName, String initValue){
		FormField field = nameFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public MerchantAccountForm nameField(){
		return nameField("name","");
	}


	public MerchantAccountForm merchantIdField(String parameterName, String initValue){
		FormField field = merchantIdFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm merchantIdField(String initValue){
		return merchantIdField("merchantId",initValue);
	}
	public MerchantAccountForm merchantIdField(){
		return merchantIdField("merchantId","");
	}


	public MerchantAccountForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public MerchantAccountForm createTimeField(){
		return createTimeField("createTime","");
	}


	public MerchantAccountForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromMerchantAccount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public MerchantAccountForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public MerchantAccountForm merchantIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  idFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantAccountForm merchantIdFieldOfMerchant(String initValue){
		return merchantIdFieldOfMerchant("merchantId",initValue);
	}
	public MerchantAccountForm merchantIdFieldOfMerchant(){
		return merchantIdFieldOfMerchant("merchantId","");
	}


	public MerchantAccountForm nameFieldOfMerchant(String parameterName, String initValue){
		FormField field =  nameFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantAccountForm nameFieldOfMerchant(String initValue){
		return nameFieldOfMerchant("name",initValue);
	}
	public MerchantAccountForm nameFieldOfMerchant(){
		return nameFieldOfMerchant("name","");
	}


	public MerchantAccountForm typeIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  typeIdFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantAccountForm typeIdFieldOfMerchant(String initValue){
		return typeIdFieldOfMerchant("typeId",initValue);
	}
	public MerchantAccountForm typeIdFieldOfMerchant(){
		return typeIdFieldOfMerchant("typeId","");
	}


	public MerchantAccountForm platformIdFieldOfMerchant(String parameterName, String initValue){
		FormField field =  platformIdFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantAccountForm platformIdFieldOfMerchant(String initValue){
		return platformIdFieldOfMerchant("platformId",initValue);
	}
	public MerchantAccountForm platformIdFieldOfMerchant(){
		return platformIdFieldOfMerchant("platformId","");
	}


	public MerchantAccountForm descriptionFieldOfMerchant(String parameterName, String initValue){
		FormField field =  descriptionFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantAccountForm descriptionFieldOfMerchant(String initValue){
		return descriptionFieldOfMerchant("description",initValue);
	}
	public MerchantAccountForm descriptionFieldOfMerchant(){
		return descriptionFieldOfMerchant("description","");
	}


	public MerchantAccountForm createTimeFieldOfMerchant(String parameterName, String initValue){
		FormField field =  createTimeFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantAccountForm createTimeFieldOfMerchant(String initValue){
		return createTimeFieldOfMerchant("createTime",initValue);
	}
	public MerchantAccountForm createTimeFieldOfMerchant(){
		return createTimeFieldOfMerchant("createTime","");
	}


	public MerchantAccountForm updateTimeFieldOfMerchant(String parameterName, String initValue){
		FormField field =  updateTimeFromMerchant(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MerchantAccountForm updateTimeFieldOfMerchant(String initValue){
		return updateTimeFieldOfMerchant("updateTime",initValue);
	}
	public MerchantAccountForm updateTimeFieldOfMerchant(){
		return updateTimeFieldOfMerchant("updateTime","");
	}

	



	public MerchantAccountForm transactionIdFieldForTransaction(String parameterName, String initValue){
		FormField field =  idFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm transactionIdFieldForTransaction(String initValue){
		return transactionIdFieldForTransaction("transactionId",initValue);
	}
	public MerchantAccountForm transactionIdFieldForTransaction(){
		return transactionIdFieldForTransaction("transactionId","");
	}


	public MerchantAccountForm nameFieldForTransaction(String parameterName, String initValue){
		FormField field =  nameFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm nameFieldForTransaction(String initValue){
		return nameFieldForTransaction("name",initValue);
	}
	public MerchantAccountForm nameFieldForTransaction(){
		return nameFieldForTransaction("name","");
	}


	public MerchantAccountForm amountFieldForTransaction(String parameterName, String initValue){
		FormField field =  amountFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm amountFieldForTransaction(String initValue){
		return amountFieldForTransaction("amount",initValue);
	}
	public MerchantAccountForm amountFieldForTransaction(){
		return amountFieldForTransaction("amount","");
	}


	public MerchantAccountForm transactionTypeIdFieldForTransaction(String parameterName, String initValue){
		FormField field =  transactionTypeIdFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm transactionTypeIdFieldForTransaction(String initValue){
		return transactionTypeIdFieldForTransaction("transactionTypeId",initValue);
	}
	public MerchantAccountForm transactionTypeIdFieldForTransaction(){
		return transactionTypeIdFieldForTransaction("transactionTypeId","");
	}


	public MerchantAccountForm accountIdFieldForTransaction(String parameterName, String initValue){
		FormField field =  accountIdFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MerchantAccountForm accountIdFieldForTransaction(String initValue){
		return accountIdFieldForTransaction("accountId",initValue);
	}
	public MerchantAccountForm accountIdFieldForTransaction(){
		return accountIdFieldForTransaction("accountId","");
	}

	

	
 	public MerchantAccountForm transferToAnotherMerchantAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherMerchant/merchantAccountId/");
		this.addFormAction(action);
		return this;
	}

 

	public MerchantAccountForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


