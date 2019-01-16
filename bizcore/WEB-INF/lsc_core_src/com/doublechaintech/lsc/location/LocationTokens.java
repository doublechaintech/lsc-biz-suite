
package com.doublechaintech.lsc.location;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class LocationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="location";
	
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
	protected LocationTokens(){
		//ensure not initialized outside the class
	}
	
	public LocationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LocationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LocationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LocationTokens start(){
		return new LocationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LocationTokens allTokens(){
		
		return start()
			.withPlatform()
			.withTransportTaskListAsSource()
			.withTransportTaskListAsDestination();
	
	}
	public static LocationTokens withoutListsTokens(){
		
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
	public LocationTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String TRANSPORT_TASK_LIST_AS_SOURCE = "transportTaskListAsSource";
	public String getTransportTaskListAsSource(){
		return TRANSPORT_TASK_LIST_AS_SOURCE;
	}
	public LocationTokens withTransportTaskListAsSource(){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SOURCE);
		return this;
	}
	public LocationTokens analyzeTransportTaskListAsSource(){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SOURCE+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskListAsSourceEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_TASK_LIST_AS_SOURCE+".anaylze");
	}
	public LocationTokens extractMoreFromTransportTaskListAsSource(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SOURCE+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskListAsSourceSortCounter = 0;
	public LocationTokens sortTransportTaskListAsSourceWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_LIST_AS_SOURCE,transportTaskListAsSourceSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListAsSourceSearchCounter = 0;
	public LocationTokens searchTransportTaskListAsSourceWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_TASK_LIST_AS_SOURCE,transportTaskListAsSourceSearchCounter++, field, verb, value);
		return this;
	}
	
	public LocationTokens searchAllTextOfTransportTaskListAsSource(String verb, String value){	
		String field = "id|name|remark";
		addSearchMoreOptions(TRANSPORT_TASK_LIST_AS_SOURCE,transportTaskListAsSourceSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LocationTokens rowsPerPageOfTransportTaskListAsSource(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SOURCE+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LocationTokens currentPageNumberOfTransportTaskListAsSource(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SOURCE+"CurrentPage",currentPageNumber);
		return this;
	}
	public LocationTokens retainColumnsOfTransportTaskListAsSource(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SOURCE+"RetainColumns",columns);
		return this;
	}
	public LocationTokens excludeColumnsOfTransportTaskListAsSource(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_SOURCE+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_TASK_LIST_AS_DESTINATION = "transportTaskListAsDestination";
	public String getTransportTaskListAsDestination(){
		return TRANSPORT_TASK_LIST_AS_DESTINATION;
	}
	public LocationTokens withTransportTaskListAsDestination(){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_DESTINATION);
		return this;
	}
	public LocationTokens analyzeTransportTaskListAsDestination(){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_DESTINATION+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskListAsDestinationEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_TASK_LIST_AS_DESTINATION+".anaylze");
	}
	public LocationTokens extractMoreFromTransportTaskListAsDestination(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_DESTINATION+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskListAsDestinationSortCounter = 0;
	public LocationTokens sortTransportTaskListAsDestinationWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_LIST_AS_DESTINATION,transportTaskListAsDestinationSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListAsDestinationSearchCounter = 0;
	public LocationTokens searchTransportTaskListAsDestinationWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_TASK_LIST_AS_DESTINATION,transportTaskListAsDestinationSearchCounter++, field, verb, value);
		return this;
	}
	
	public LocationTokens searchAllTextOfTransportTaskListAsDestination(String verb, String value){	
		String field = "id|name|remark";
		addSearchMoreOptions(TRANSPORT_TASK_LIST_AS_DESTINATION,transportTaskListAsDestinationSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LocationTokens rowsPerPageOfTransportTaskListAsDestination(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_DESTINATION+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LocationTokens currentPageNumberOfTransportTaskListAsDestination(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_DESTINATION+"CurrentPage",currentPageNumber);
		return this;
	}
	public LocationTokens retainColumnsOfTransportTaskListAsDestination(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_DESTINATION+"RetainColumns",columns);
		return this;
	}
	public LocationTokens excludeColumnsOfTransportTaskListAsDestination(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST_AS_DESTINATION+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  LocationTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTransportTaskListAsSource(verb, value);	
		searchAllTextOfTransportTaskListAsDestination(verb, value);	
		return this;
	}
}

