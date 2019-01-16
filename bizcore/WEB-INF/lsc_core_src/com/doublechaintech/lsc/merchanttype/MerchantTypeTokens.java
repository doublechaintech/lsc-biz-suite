
package com.doublechaintech.lsc.merchanttype;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class MerchantTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="merchantType";
	
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
	protected MerchantTypeTokens(){
		//ensure not initialized outside the class
	}
	
	public MerchantTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static MerchantTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected MerchantTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static MerchantTypeTokens start(){
		return new MerchantTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static MerchantTypeTokens allTokens(){
		
		return start()
			.withPlatform()
			.withMerchantList()
			.withTransportItemList();
	
	}
	public static MerchantTypeTokens withoutListsTokens(){
		
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
	public MerchantTypeTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String MERCHANT_LIST = "merchantList";
	public String getMerchantList(){
		return MERCHANT_LIST;
	}
	public MerchantTypeTokens withMerchantList(){		
		addSimpleOptions(MERCHANT_LIST);
		return this;
	}
	public MerchantTypeTokens analyzeMerchantList(){		
		addSimpleOptions(MERCHANT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeMerchantListEnabled(){		
		
		return checkOptions(this.options(), MERCHANT_LIST+".anaylze");
	}
	public MerchantTypeTokens extractMoreFromMerchantList(String idsSeperatedWithComma){		
		addSimpleOptions(MERCHANT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int merchantListSortCounter = 0;
	public MerchantTypeTokens sortMerchantListWith(String field, String descOrAsc){		
		addSortMoreOptions(MERCHANT_LIST,merchantListSortCounter++, field, descOrAsc);
		return this;
	}
	private int merchantListSearchCounter = 0;
	public MerchantTypeTokens searchMerchantListWith(String field, String verb, String value){		
		addSearchMoreOptions(MERCHANT_LIST,merchantListSearchCounter++, field, verb, value);
		return this;
	}
	
	public MerchantTypeTokens searchAllTextOfMerchantList(String verb, String value){	
		String field = "id|name|description";
		addSearchMoreOptions(MERCHANT_LIST,merchantListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public MerchantTypeTokens rowsPerPageOfMerchantList(int rowsPerPage){		
		addSimpleOptions(MERCHANT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public MerchantTypeTokens currentPageNumberOfMerchantList(int currentPageNumber){		
		addSimpleOptions(MERCHANT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public MerchantTypeTokens retainColumnsOfMerchantList(String[] columns){		
		addSimpleOptions(MERCHANT_LIST+"RetainColumns",columns);
		return this;
	}
	public MerchantTypeTokens excludeColumnsOfMerchantList(String[] columns){		
		addSimpleOptions(MERCHANT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_ITEM_LIST = "transportItemList";
	public String getTransportItemList(){
		return TRANSPORT_ITEM_LIST;
	}
	public MerchantTypeTokens withTransportItemList(){		
		addSimpleOptions(TRANSPORT_ITEM_LIST);
		return this;
	}
	public MerchantTypeTokens analyzeTransportItemList(){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportItemListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_ITEM_LIST+".anaylze");
	}
	public MerchantTypeTokens extractMoreFromTransportItemList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportItemListSortCounter = 0;
	public MerchantTypeTokens sortTransportItemListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportItemListSearchCounter = 0;
	public MerchantTypeTokens searchTransportItemListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	public MerchantTypeTokens searchAllTextOfTransportItemList(String verb, String value){	
		String field = "id|name|unit";
		addSearchMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public MerchantTypeTokens rowsPerPageOfTransportItemList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public MerchantTypeTokens currentPageNumberOfTransportItemList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public MerchantTypeTokens retainColumnsOfTransportItemList(String[] columns){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"RetainColumns",columns);
		return this;
	}
	public MerchantTypeTokens excludeColumnsOfTransportItemList(String[] columns){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  MerchantTypeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfMerchantList(verb, value);	
		searchAllTextOfTransportItemList(verb, value);	
		return this;
	}
}

