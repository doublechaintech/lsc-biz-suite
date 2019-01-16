
package com.doublechaintech.lsc.transaction;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class TransactionTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transaction";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected TransactionTokens(){
		//ensure not initialized outside the class
	}
	
	public TransactionTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransactionTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransactionTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransactionTokens start(){
		return new TransactionTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransactionTokens allTokens(){
		
		return start()
			.withTransactionType()
			.withAccount();
	
	}
	public static TransactionTokens withoutListsTokens(){
		
		return start()
			.withTransactionType()
			.withAccount();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String TRANSACTIONTYPE = "transactionType";
	public String getTransactionType(){
		return TRANSACTIONTYPE;
	}
	public TransactionTokens withTransactionType(){		
		addSimpleOptions(TRANSACTIONTYPE);
		return this;
	}
	
	
	protected static final String ACCOUNT = "account";
	public String getAccount(){
		return ACCOUNT;
	}
	public TransactionTokens withAccount(){		
		addSimpleOptions(ACCOUNT);
		return this;
	}
	
	
	
	public  TransactionTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

