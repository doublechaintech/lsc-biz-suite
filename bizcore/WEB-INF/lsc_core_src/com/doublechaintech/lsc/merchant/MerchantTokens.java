
package com.doublechaintech.lsc.merchant;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class MerchantTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="merchant";
	
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
	protected MerchantTokens(){
		//ensure not initialized outside the class
	}
	
	public MerchantTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static MerchantTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected MerchantTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static MerchantTokens start(){
		return new MerchantTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static MerchantTokens allTokens(){
		
		return start()
			.withType()
			.withPlatform()
			.withTransportProjectList()
			.withTransportTaskListAsSender()
			.withTransportTaskListAsReceiver()
			.withMerchantAccountList();
	
	}
	public static MerchantTokens withoutListsTokens(){
		
		return start()
			.withType()
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

	protected static final String TYPE = "type";
	public String getType(){
		return TYPE;
	}
	public MerchantTokens withType(){		
		addSimpleOptions(TYPE);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public MerchantTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String TRANSPORT_PROJECT_LIST = "transportProjectList";
	public String getTransportProjectList(){
		return TRANSPORT_PROJECT_LIST;
	}
	public MerchantTokens withTransportProjectList(){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST);
		return this;
	}
	public MerchantTokens analyzeTransportProjectList(){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportProjectListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_PROJECT_LIST+".anaylze");
	}
	public MerchantTokens extractMoreFromTransportProjectList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportProjectListSortCounter = 0;
	public MerchantTokens sortTransportProjectListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_PROJECT_LIST,transportProjectListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportProjectListSearchCounter = 0;
	public MerchantTokens searchTransportProjectListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_PROJECT_LIST,transportProjectListSearchCounter++, field, verb, value);
		return this;
	}
	
	public MerchantTokens searchAllTextOfTransportProjectList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(TRANSPORT_PROJECT_LIST,transportProjectListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public MerchantTokens rowsPerPageOfTransportProjectList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public MerchantTokens currentPageNumberOfTransportProjectList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public MerchantTokens retainColumnsOfTransportProjectList(String[] columns){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+"RetainColumns",columns);
		return this;
	}
	public MerchantTokens excludeColumnsOfTransportProjectList(String[] columns){		
		addSimpleOptions(TRANSPORT_PROJECT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_TASK_LIST_AS_SENDER = "transportTaskListAsSender";
	public String getTransportTaskListAsSender(){
		return TRANSPORT_TASK_LIST_AS_SENDER;
	}
	public MerchantTokens withTransportTaskListAsSender(){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SENDER);
		return this;
	}
	public MerchantTokens analyzeTransportTaskListAsSender(){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SENDER+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskListAsSenderEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_TASK_LIST_AS_SENDER+".anaylze");
	}
	public MerchantTokens extractMoreFromTransportTaskListAsSender(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SENDER+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskListAsSenderSortCounter = 0;
	public MerchantTokens sortTransportTaskListAsSenderWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_LIST_AS_SENDER,transportTaskListAsSenderSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListAsSenderSearchCounter = 0;
	public MerchantTokens searchTransportTaskListAsSenderWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_TASK_LIST_AS_SENDER,transportTaskListAsSenderSearchCounter++, field, verb, value);
		return this;
	}
	
	public MerchantTokens searchAllTextOfTransportTaskListAsSender(String verb, String value){	
		String field = "id|name|remark";
		addSearchMoreOptions(TRANSPORT_TASK_LIST_AS_SENDER,transportTaskListAsSenderSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public MerchantTokens rowsPerPageOfTransportTaskListAsSender(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SENDER+"RowsPerPage",rowsPerPage);
		return this;
	}
	public MerchantTokens currentPageNumberOfTransportTaskListAsSender(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SENDER+"CurrentPage",currentPageNumber);
		return this;
	}
	public MerchantTokens retainColumnsOfTransportTaskListAsSender(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SENDER+"RetainColumns",columns);
		return this;
	}
	public MerchantTokens excludeColumnsOfTransportTaskListAsSender(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SENDER+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_TASK_LIST_AS_RECEIVER = "transportTaskListAsReceiver";
	public String getTransportTaskListAsReceiver(){
		return TRANSPORT_TASK_LIST_AS_RECEIVER;
	}
	public MerchantTokens withTransportTaskListAsReceiver(){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_RECEIVER);
		return this;
	}
	public MerchantTokens analyzeTransportTaskListAsReceiver(){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_RECEIVER+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskListAsReceiverEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_TASK_LIST_AS_RECEIVER+".anaylze");
	}
	public MerchantTokens extractMoreFromTransportTaskListAsReceiver(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_RECEIVER+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskListAsReceiverSortCounter = 0;
	public MerchantTokens sortTransportTaskListAsReceiverWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_LIST_AS_RECEIVER,transportTaskListAsReceiverSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListAsReceiverSearchCounter = 0;
	public MerchantTokens searchTransportTaskListAsReceiverWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_TASK_LIST_AS_RECEIVER,transportTaskListAsReceiverSearchCounter++, field, verb, value);
		return this;
	}
	
	public MerchantTokens searchAllTextOfTransportTaskListAsReceiver(String verb, String value){	
		String field = "id|name|remark";
		addSearchMoreOptions(TRANSPORT_TASK_LIST_AS_RECEIVER,transportTaskListAsReceiverSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public MerchantTokens rowsPerPageOfTransportTaskListAsReceiver(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_RECEIVER+"RowsPerPage",rowsPerPage);
		return this;
	}
	public MerchantTokens currentPageNumberOfTransportTaskListAsReceiver(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_RECEIVER+"CurrentPage",currentPageNumber);
		return this;
	}
	public MerchantTokens retainColumnsOfTransportTaskListAsReceiver(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_RECEIVER+"RetainColumns",columns);
		return this;
	}
	public MerchantTokens excludeColumnsOfTransportTaskListAsReceiver(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_RECEIVER+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String MERCHANT_ACCOUNT_LIST = "merchantAccountList";
	public String getMerchantAccountList(){
		return MERCHANT_ACCOUNT_LIST;
	}
	public MerchantTokens withMerchantAccountList(){		
		addSimpleOptions(MERCHANT_ACCOUNT_LIST);
		return this;
	}
	public MerchantTokens analyzeMerchantAccountList(){		
		addSimpleOptions(MERCHANT_ACCOUNT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeMerchantAccountListEnabled(){		
		
		return checkOptions(this.options(), MERCHANT_ACCOUNT_LIST+".anaylze");
	}
	public MerchantTokens extractMoreFromMerchantAccountList(String idsSeperatedWithComma){		
		addSimpleOptions(MERCHANT_ACCOUNT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int merchantAccountListSortCounter = 0;
	public MerchantTokens sortMerchantAccountListWith(String field, String descOrAsc){		
		addSortMoreOptions(MERCHANT_ACCOUNT_LIST,merchantAccountListSortCounter++, field, descOrAsc);
		return this;
	}
	private int merchantAccountListSearchCounter = 0;
	public MerchantTokens searchMerchantAccountListWith(String field, String verb, String value){		
		addSearchMoreOptions(MERCHANT_ACCOUNT_LIST,merchantAccountListSearchCounter++, field, verb, value);
		return this;
	}
	
	public MerchantTokens searchAllTextOfMerchantAccountList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(MERCHANT_ACCOUNT_LIST,merchantAccountListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public MerchantTokens rowsPerPageOfMerchantAccountList(int rowsPerPage){		
		addSimpleOptions(MERCHANT_ACCOUNT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public MerchantTokens currentPageNumberOfMerchantAccountList(int currentPageNumber){		
		addSimpleOptions(MERCHANT_ACCOUNT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public MerchantTokens retainColumnsOfMerchantAccountList(String[] columns){		
		addSimpleOptions(MERCHANT_ACCOUNT_LIST+"RetainColumns",columns);
		return this;
	}
	public MerchantTokens excludeColumnsOfMerchantAccountList(String[] columns){		
		addSimpleOptions(MERCHANT_ACCOUNT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  MerchantTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTransportProjectList(verb, value);	
		searchAllTextOfTransportTaskListAsSender(verb, value);	
		searchAllTextOfTransportTaskListAsReceiver(verb, value);	
		searchAllTextOfMerchantAccountList(verb, value);	
		return this;
	}
}

