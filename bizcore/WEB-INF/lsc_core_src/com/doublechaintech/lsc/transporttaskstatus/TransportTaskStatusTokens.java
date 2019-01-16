
package com.doublechaintech.lsc.transporttaskstatus;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class TransportTaskStatusTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transportTaskStatus";
	
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
	protected TransportTaskStatusTokens(){
		//ensure not initialized outside the class
	}
	
	public TransportTaskStatusTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransportTaskStatusTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransportTaskStatusTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransportTaskStatusTokens start(){
		return new TransportTaskStatusTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransportTaskStatusTokens allTokens(){
		
		return start()
			.withPlatform()
			.withTransportTaskList();
	
	}
	public static TransportTaskStatusTokens withoutListsTokens(){
		
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
	public TransportTaskStatusTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	public String getTransportTaskList(){
		return TRANSPORT_TASK_LIST;
	}
	public TransportTaskStatusTokens withTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST);
		return this;
	}
	public TransportTaskStatusTokens analyzeTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_TASK_LIST+".anaylze");
	}
	public TransportTaskStatusTokens extractMoreFromTransportTaskList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskListSortCounter = 0;
	public TransportTaskStatusTokens sortTransportTaskListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListSearchCounter = 0;
	public TransportTaskStatusTokens searchTransportTaskListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}
	
	public TransportTaskStatusTokens searchAllTextOfTransportTaskList(String verb, String value){	
		String field = "id|name|remark";
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportTaskStatusTokens rowsPerPageOfTransportTaskList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TransportTaskStatusTokens currentPageNumberOfTransportTaskList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TransportTaskStatusTokens retainColumnsOfTransportTaskList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"RetainColumns",columns);
		return this;
	}
	public TransportTaskStatusTokens excludeColumnsOfTransportTaskList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  TransportTaskStatusTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTransportTaskList(verb, value);	
		return this;
	}
}

