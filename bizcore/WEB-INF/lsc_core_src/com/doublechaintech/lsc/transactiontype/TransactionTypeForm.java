package com.doublechaintech.lsc.transactiontype;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class TransactionTypeForm extends BaseForm {
	
	
	public TransactionTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransactionTypeForm transactionTypeIdField(String parameterName, String initValue){
		FormField field = idFromTransactionType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionTypeForm transactionTypeIdField(String initValue){
		return transactionTypeIdField("transactionTypeId",initValue);
	}
	public TransactionTypeForm transactionTypeIdField(){
		return transactionTypeIdField("transactionTypeId","");
	}


	public TransactionTypeForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransactionType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionTypeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransactionTypeForm nameField(){
		return nameField("name","");
	}


	public TransactionTypeForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromTransactionType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionTypeForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public TransactionTypeForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public TransactionTypeForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionTypeForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public TransactionTypeForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public TransactionTypeForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionTypeForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public TransactionTypeForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public TransactionTypeForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionTypeForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public TransactionTypeForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public TransactionTypeForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionTypeForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public TransactionTypeForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public TransactionTypeForm transactionIdFieldForTransaction(String parameterName, String initValue){
		FormField field =  idFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionTypeForm transactionIdFieldForTransaction(String initValue){
		return transactionIdFieldForTransaction("transactionId",initValue);
	}
	public TransactionTypeForm transactionIdFieldForTransaction(){
		return transactionIdFieldForTransaction("transactionId","");
	}


	public TransactionTypeForm nameFieldForTransaction(String parameterName, String initValue){
		FormField field =  nameFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionTypeForm nameFieldForTransaction(String initValue){
		return nameFieldForTransaction("name",initValue);
	}
	public TransactionTypeForm nameFieldForTransaction(){
		return nameFieldForTransaction("name","");
	}


	public TransactionTypeForm amountFieldForTransaction(String parameterName, String initValue){
		FormField field =  amountFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionTypeForm amountFieldForTransaction(String initValue){
		return amountFieldForTransaction("amount",initValue);
	}
	public TransactionTypeForm amountFieldForTransaction(){
		return amountFieldForTransaction("amount","");
	}


	public TransactionTypeForm transactionTypeIdFieldForTransaction(String parameterName, String initValue){
		FormField field =  transactionTypeIdFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionTypeForm transactionTypeIdFieldForTransaction(String initValue){
		return transactionTypeIdFieldForTransaction("transactionTypeId",initValue);
	}
	public TransactionTypeForm transactionTypeIdFieldForTransaction(){
		return transactionTypeIdFieldForTransaction("transactionTypeId","");
	}


	public TransactionTypeForm accountIdFieldForTransaction(String parameterName, String initValue){
		FormField field =  accountIdFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionTypeForm accountIdFieldForTransaction(String initValue){
		return accountIdFieldForTransaction("accountId",initValue);
	}
	public TransactionTypeForm accountIdFieldForTransaction(){
		return accountIdFieldForTransaction("accountId","");
	}

	

	
 	public TransactionTypeForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/transactionTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransactionTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


