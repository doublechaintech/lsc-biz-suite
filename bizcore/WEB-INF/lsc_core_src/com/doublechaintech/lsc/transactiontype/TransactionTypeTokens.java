
package com.doublechaintech.lsc.transactiontype;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class TransactionTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transactionType";
	
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
	protected TransactionTypeTokens(){
		//ensure not initialized outside the class
	}
	
	public TransactionTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransactionTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransactionTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransactionTypeTokens start(){
		return new TransactionTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransactionTypeTokens allTokens(){
		
		return start()
			.withPlatform()
			.withTransactionList();
	
	}
	public static TransactionTypeTokens withoutListsTokens(){
		
		return start()
			.withPlatform();
	
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

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public TransactionTypeTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String TRANSACTION_LIST = "transactionList";
	public String getTransactionList(){
		return TRANSACTION_LIST;
	}
	public TransactionTypeTokens withTransactionList(){		
		addSimpleOptions(TRANSACTION_LIST);
		return this;
	}
	public TransactionTypeTokens analyzeTransactionList(){		
		addSimpleOptions(TRANSACTION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransactionListEnabled(){		
		
		return checkOptions(this.options(), TRANSACTION_LIST+".anaylze");
	}
	public TransactionTypeTokens extractMoreFromTransactionList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSACTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transactionListSortCounter = 0;
	public TransactionTypeTokens sortTransactionListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSACTION_LIST,transactionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transactionListSearchCounter = 0;
	public TransactionTypeTokens searchTransactionListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSACTION_LIST,transactionListSearchCounter++, field, verb, value);
		return this;
	}
	
	public TransactionTypeTokens searchAllTextOfTransactionList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(TRANSACTION_LIST,transactionListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransactionTypeTokens rowsPerPageOfTransactionList(int rowsPerPage){		
		addSimpleOptions(TRANSACTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TransactionTypeTokens currentPageNumberOfTransactionList(int currentPageNumber){		
		addSimpleOptions(TRANSACTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TransactionTypeTokens retainColumnsOfTransactionList(String[] columns){		
		addSimpleOptions(TRANSACTION_LIST+"RetainColumns",columns);
		return this;
	}
	public TransactionTypeTokens excludeColumnsOfTransactionList(String[] columns){		
		addSimpleOptions(TRANSACTION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  TransactionTypeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTransactionList(verb, value);	
		return this;
	}
}

