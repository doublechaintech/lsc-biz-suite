
package com.doublechaintech.lsc.platform;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
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
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withTransactionTypeList()
			.withMerchantTypeList()
			.withTransportTaskStatusList()
			.withLocationList()
			.withMerchantList()
			.withTransportProjectList()
			.withTransportItemList()
			.withTransportTaskList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
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

	protected static final String TRANSACTION_TYPE_LIST = "transactionTypeList";
	public String getTransactionTypeList(){
		return TRANSACTION_TYPE_LIST;
	}
	public PlatformTokens withTransactionTypeList(){		
		addSimpleOptions(TRANSACTION_TYPE_LIST);
		return this;
	}
	public PlatformTokens analyzeTransactionTypeList(){		
		addSimpleOptions(TRANSACTION_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransactionTypeListEnabled(){		
		
		return checkOptions(this.options(), TRANSACTION_TYPE_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromTransactionTypeList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSACTION_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transactionTypeListSortCounter = 0;
	public PlatformTokens sortTransactionTypeListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSACTION_TYPE_LIST,transactionTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transactionTypeListSearchCounter = 0;
	public PlatformTokens searchTransactionTypeListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSACTION_TYPE_LIST,transactionTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfTransactionTypeList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(TRANSACTION_TYPE_LIST,transactionTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfTransactionTypeList(int rowsPerPage){		
		addSimpleOptions(TRANSACTION_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfTransactionTypeList(int currentPageNumber){		
		addSimpleOptions(TRANSACTION_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfTransactionTypeList(String[] columns){		
		addSimpleOptions(TRANSACTION_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfTransactionTypeList(String[] columns){		
		addSimpleOptions(TRANSACTION_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String MERCHANT_TYPE_LIST = "merchantTypeList";
	public String getMerchantTypeList(){
		return MERCHANT_TYPE_LIST;
	}
	public PlatformTokens withMerchantTypeList(){		
		addSimpleOptions(MERCHANT_TYPE_LIST);
		return this;
	}
	public PlatformTokens analyzeMerchantTypeList(){		
		addSimpleOptions(MERCHANT_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeMerchantTypeListEnabled(){		
		
		return checkOptions(this.options(), MERCHANT_TYPE_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromMerchantTypeList(String idsSeperatedWithComma){		
		addSimpleOptions(MERCHANT_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int merchantTypeListSortCounter = 0;
	public PlatformTokens sortMerchantTypeListWith(String field, String descOrAsc){		
		addSortMoreOptions(MERCHANT_TYPE_LIST,merchantTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int merchantTypeListSearchCounter = 0;
	public PlatformTokens searchMerchantTypeListWith(String field, String verb, String value){		
		addSearchMoreOptions(MERCHANT_TYPE_LIST,merchantTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfMerchantTypeList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(MERCHANT_TYPE_LIST,merchantTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfMerchantTypeList(int rowsPerPage){		
		addSimpleOptions(MERCHANT_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfMerchantTypeList(int currentPageNumber){		
		addSimpleOptions(MERCHANT_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfMerchantTypeList(String[] columns){		
		addSimpleOptions(MERCHANT_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfMerchantTypeList(String[] columns){		
		addSimpleOptions(MERCHANT_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_TASK_STATUS_LIST = "transportTaskStatusList";
	public String getTransportTaskStatusList(){
		return TRANSPORT_TASK_STATUS_LIST;
	}
	public PlatformTokens withTransportTaskStatusList(){		
		addSimpleOptions(TRANSPORT_TASK_STATUS_LIST);
		return this;
	}
	public PlatformTokens analyzeTransportTaskStatusList(){		
		addSimpleOptions(TRANSPORT_TASK_STATUS_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskStatusListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_TASK_STATUS_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromTransportTaskStatusList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_STATUS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskStatusListSortCounter = 0;
	public PlatformTokens sortTransportTaskStatusListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_STATUS_LIST,transportTaskStatusListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskStatusListSearchCounter = 0;
	public PlatformTokens searchTransportTaskStatusListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_TASK_STATUS_LIST,transportTaskStatusListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfTransportTaskStatusList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(TRANSPORT_TASK_STATUS_LIST,transportTaskStatusListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfTransportTaskStatusList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_STATUS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfTransportTaskStatusList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_STATUS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfTransportTaskStatusList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_STATUS_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfTransportTaskStatusList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_STATUS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String LOCATION_LIST = "locationList";
	public String getLocationList(){
		return LOCATION_LIST;
	}
	public PlatformTokens withLocationList(){		
		addSimpleOptions(LOCATION_LIST);
		return this;
	}
	public PlatformTokens analyzeLocationList(){		
		addSimpleOptions(LOCATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLocationListEnabled(){		
		
		return checkOptions(this.options(), LOCATION_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromLocationList(String idsSeperatedWithComma){		
		addSimpleOptions(LOCATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int locationListSortCounter = 0;
	public PlatformTokens sortLocationListWith(String field, String descOrAsc){		
		addSortMoreOptions(LOCATION_LIST,locationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int locationListSearchCounter = 0;
	public PlatformTokens searchLocationListWith(String field, String verb, String value){		
		addSearchMoreOptions(LOCATION_LIST,locationListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfLocationList(String verb, String value){	
		String field = "id|name|contactPerson|contactPhone|description";
		addSearchMoreOptions(LOCATION_LIST,locationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfLocationList(int rowsPerPage){		
		addSimpleOptions(LOCATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfLocationList(int currentPageNumber){		
		addSimpleOptions(LOCATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfLocationList(String[] columns){		
		addSimpleOptions(LOCATION_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfLocationList(String[] columns){		
		addSimpleOptions(LOCATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String MERCHANT_LIST = "merchantList";
	public String getMerchantList(){
		return MERCHANT_LIST;
	}
	public PlatformTokens withMerchantList(){		
		addSimpleOptions(MERCHANT_LIST);
		return this;
	}
	public PlatformTokens analyzeMerchantList(){		
		addSimpleOptions(MERCHANT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeMerchantListEnabled(){		
		
		return checkOptions(this.options(), MERCHANT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromMerchantList(String idsSeperatedWithComma){		
		addSimpleOptions(MERCHANT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int merchantListSortCounter = 0;
	public PlatformTokens sortMerchantListWith(String field, String descOrAsc){		
		addSortMoreOptions(MERCHANT_LIST,merchantListSortCounter++, field, descOrAsc);
		return this;
	}
	private int merchantListSearchCounter = 0;
	public PlatformTokens searchMerchantListWith(String field, String verb, String value){		
		addSearchMoreOptions(MERCHANT_LIST,merchantListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfMerchantList(String verb, String value){	
		String field = "id|name|description";
		addSearchMoreOptions(MERCHANT_LIST,merchantListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfMerchantList(int rowsPerPage){		
		addSimpleOptions(MERCHANT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfMerchantList(int currentPageNumber){		
		addSimpleOptions(MERCHANT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfMerchantList(String[] columns){		
		addSimpleOptions(MERCHANT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfMerchantList(String[] columns){		
		addSimpleOptions(MERCHANT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_PROJECT_LIST = "transportProjectList";
	public String getTransportProjectList(){
		return TRANSPORT_PROJECT_LIST;
	}
	public PlatformTokens withTransportProjectList(){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST);
		return this;
	}
	public PlatformTokens analyzeTransportProjectList(){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportProjectListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_PROJECT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromTransportProjectList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportProjectListSortCounter = 0;
	public PlatformTokens sortTransportProjectListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_PROJECT_LIST,transportProjectListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportProjectListSearchCounter = 0;
	public PlatformTokens searchTransportProjectListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_PROJECT_LIST,transportProjectListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfTransportProjectList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(TRANSPORT_PROJECT_LIST,transportProjectListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfTransportProjectList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfTransportProjectList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfTransportProjectList(String[] columns){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfTransportProjectList(String[] columns){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_ITEM_LIST = "transportItemList";
	public String getTransportItemList(){
		return TRANSPORT_ITEM_LIST;
	}
	public PlatformTokens withTransportItemList(){		
		addSimpleOptions(TRANSPORT_ITEM_LIST);
		return this;
	}
	public PlatformTokens analyzeTransportItemList(){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportItemListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_ITEM_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromTransportItemList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportItemListSortCounter = 0;
	public PlatformTokens sortTransportItemListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportItemListSearchCounter = 0;
	public PlatformTokens searchTransportItemListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfTransportItemList(String verb, String value){	
		String field = "id|name|unit";
		addSearchMoreOptions(TRANSPORT_ITEM_LIST,transportItemListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfTransportItemList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfTransportItemList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfTransportItemList(String[] columns){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfTransportItemList(String[] columns){		
		addSimpleOptions(TRANSPORT_ITEM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	public String getTransportTaskList(){
		return TRANSPORT_TASK_LIST;
	}
	public PlatformTokens withTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST);
		return this;
	}
	public PlatformTokens analyzeTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_TASK_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromTransportTaskList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskListSortCounter = 0;
	public PlatformTokens sortTransportTaskListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListSearchCounter = 0;
	public PlatformTokens searchTransportTaskListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfTransportTaskList(String verb, String value){	
		String field = "id|name|remark";
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfTransportTaskList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfTransportTaskList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfTransportTaskList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfTransportTaskList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTransactionTypeList(verb, value);	
		searchAllTextOfMerchantTypeList(verb, value);	
		searchAllTextOfTransportTaskStatusList(verb, value);	
		searchAllTextOfLocationList(verb, value);	
		searchAllTextOfMerchantList(verb, value);	
		searchAllTextOfTransportProjectList(verb, value);	
		searchAllTextOfTransportItemList(verb, value);	
		searchAllTextOfTransportTaskList(verb, value);	
		return this;
	}
}

