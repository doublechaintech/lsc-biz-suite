
package com.doublechaintech.lsc.transportproject;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class TransportProjectTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transportProject";
	
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
	protected TransportProjectTokens(){
		//ensure not initialized outside the class
	}
	
	public TransportProjectTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransportProjectTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransportProjectTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransportProjectTokens start(){
		return new TransportProjectTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransportProjectTokens allTokens(){
		
		return start()
			.withMerchant()
			.withPlatform()
			.withTransportItemList();
	
	}
	public static TransportProjectTokens withoutListsTokens(){
		
		return start()
			.withMerchant()
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

	protected static final String MERCHANT = "merchant";
	public String getMerchant(){
		return MERCHANT;
	}
	public TransportProjectTokens withMerchant(){		
		addSimpleOptions(MERCHANT);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public TransportProjectTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String TRANSPORT_ITEM_LIST = "transportItemList";
	public String getTransportItemList(){
		return TRANSPORT_ITEM_LIST;
	}
	public TransportProjectTokens withTransportItemList(){		
		addSimpleOptions(TRANSPORT_ITEM_LIST);
		return this;
	}
	public TransportProjectTokens analyzeTransportItemList(){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportItemListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_ITEM_LIST+".anaylze");
	}
	public TransportProjectTokens extractMoreFromTransportItemList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportItemListSortCounter = 0;
	public TransportProjectTokens sortTransportItemListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportItemListSearchCounter = 0;
	public TransportProjectTokens searchTransportItemListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	public TransportProjectTokens searchAllTextOfTransportItemList(String verb, String value){	
		String field = "id|name|unit";
		addSearchMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportProjectTokens rowsPerPageOfTransportItemList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TransportProjectTokens currentPageNumberOfTransportItemList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TransportProjectTokens retainColumnsOfTransportItemList(String[] columns){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"RetainColumns",columns);
		return this;
	}
	public TransportProjectTokens excludeColumnsOfTransportItemList(String[] columns){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  TransportProjectTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTransportItemList(verb, value);	
		return this;
	}
}

