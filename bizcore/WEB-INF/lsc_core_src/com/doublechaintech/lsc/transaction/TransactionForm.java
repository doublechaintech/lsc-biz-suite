package com.doublechaintech.lsc.transaction;
import com.doublechaintech.lsc.BaseForm;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;



public class TransactionForm extends BaseForm {
	
	
	public TransactionForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransactionForm transactionIdField(String parameterName, String initValue){
		FormField field = idFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionForm transactionIdField(String initValue){
		return transactionIdField("transactionId",initValue);
	}
	public TransactionForm transactionIdField(){
		return transactionIdField("transactionId","");
	}


	public TransactionForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransactionForm nameField(){
		return nameField("name","");
	}


	public TransactionForm amountField(String parameterName, String initValue){
		FormField field = amountFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public TransactionForm amountField(){
		return amountField("amount","");
	}


	public TransactionForm transactionTypeIdField(String parameterName, String initValue){
		FormField field = transactionTypeIdFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionForm transactionTypeIdField(String initValue){
		return transactionTypeIdField("transactionTypeId",initValue);
	}
	public TransactionForm transactionTypeIdField(){
		return transactionTypeIdField("transactionTypeId","");
	}


	public TransactionForm accountIdField(String parameterName, String initValue){
		FormField field = accountIdFromTransaction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionForm accountIdField(String initValue){
		return accountIdField("accountId",initValue);
	}
	public TransactionForm accountIdField(){
		return accountIdField("accountId","");
	}

	
	


	public TransactionForm transactionTypeIdFieldOfTransactionType(String parameterName, String initValue){
		FormField field =  idFromTransactionType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionForm transactionTypeIdFieldOfTransactionType(String initValue){
		return transactionTypeIdFieldOfTransactionType("transactionTypeId",initValue);
	}
	public TransactionForm transactionTypeIdFieldOfTransactionType(){
		return transactionTypeIdFieldOfTransactionType("transactionTypeId","");
	}


	public TransactionForm nameFieldOfTransactionType(String parameterName, String initValue){
		FormField field =  nameFromTransactionType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionForm nameFieldOfTransactionType(String initValue){
		return nameFieldOfTransactionType("name",initValue);
	}
	public TransactionForm nameFieldOfTransactionType(){
		return nameFieldOfTransactionType("name","");
	}


	public TransactionForm platformIdFieldOfTransactionType(String parameterName, String initValue){
		FormField field =  platformIdFromTransactionType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionForm platformIdFieldOfTransactionType(String initValue){
		return platformIdFieldOfTransactionType("platformId",initValue);
	}
	public TransactionForm platformIdFieldOfTransactionType(){
		return platformIdFieldOfTransactionType("platformId","");
	}


	public TransactionForm merchantAccountIdFieldOfMerchantAccount(String parameterName, String initValue){
		FormField field =  idFromMerchantAccount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionForm merchantAccountIdFieldOfMerchantAccount(String initValue){
		return merchantAccountIdFieldOfMerchantAccount("merchantAccountId",initValue);
	}
	public TransactionForm merchantAccountIdFieldOfMerchantAccount(){
		return merchantAccountIdFieldOfMerchantAccount("merchantAccountId","");
	}


	public TransactionForm nameFieldOfMerchantAccount(String parameterName, String initValue){
		FormField field =  nameFromMerchantAccount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionForm nameFieldOfMerchantAccount(String initValue){
		return nameFieldOfMerchantAccount("name",initValue);
	}
	public TransactionForm nameFieldOfMerchantAccount(){
		return nameFieldOfMerchantAccount("name","");
	}


	public TransactionForm merchantIdFieldOfMerchantAccount(String parameterName, String initValue){
		FormField field =  merchantIdFromMerchantAccount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionForm merchantIdFieldOfMerchantAccount(String initValue){
		return merchantIdFieldOfMerchantAccount("merchantId",initValue);
	}
	public TransactionForm merchantIdFieldOfMerchantAccount(){
		return merchantIdFieldOfMerchantAccount("merchantId","");
	}


	public TransactionForm createTimeFieldOfMerchantAccount(String parameterName, String initValue){
		FormField field =  createTimeFromMerchantAccount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionForm createTimeFieldOfMerchantAccount(String initValue){
		return createTimeFieldOfMerchantAccount("createTime",initValue);
	}
	public TransactionForm createTimeFieldOfMerchantAccount(){
		return createTimeFieldOfMerchantAccount("createTime","");
	}


	public TransactionForm updateTimeFieldOfMerchantAccount(String parameterName, String initValue){
		FormField field =  updateTimeFromMerchantAccount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionForm updateTimeFieldOfMerchantAccount(String initValue){
		return updateTimeFieldOfMerchantAccount("updateTime",initValue);
	}
	public TransactionForm updateTimeFieldOfMerchantAccount(){
		return updateTimeFieldOfMerchantAccount("updateTime","");
	}

	


	

	
 	public TransactionForm transferToAnotherTransactionTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherTransactionType/transactionId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransactionForm transferToAnotherAccountAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherAccount/transactionId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransactionForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


