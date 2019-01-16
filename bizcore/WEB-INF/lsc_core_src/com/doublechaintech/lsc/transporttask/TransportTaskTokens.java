
package com.doublechaintech.lsc.transporttask;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class TransportTaskTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transportTask";
	
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
	protected TransportTaskTokens(){
		//ensure not initialized outside the class
	}
	
	public TransportTaskTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransportTaskTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransportTaskTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransportTaskTokens start(){
		return new TransportTaskTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransportTaskTokens allTokens(){
		
		return start()
			.withProject()
			.withSource()
			.withDestination()
			.withStatus()
			.withSender()
			.withReceiver()
			.withPlatform()
			.withTransportTaskTrackList();
	
	}
	public static TransportTaskTokens withoutListsTokens(){
		
		return start()
			.withProject()
			.withSource()
			.withDestination()
			.withStatus()
			.withSender()
			.withReceiver()
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

	protected static final String PROJECT = "project";
	public String getProject(){
		return PROJECT;
	}
	public TransportTaskTokens withProject(){		
		addSimpleOptions(PROJECT);
		return this;
	}
	
	
	protected static final String SOURCE = "source";
	public String getSource(){
		return SOURCE;
	}
	public TransportTaskTokens withSource(){		
		addSimpleOptions(SOURCE);
		return this;
	}
	
	
	protected static final String DESTINATION = "destination";
	public String getDestination(){
		return DESTINATION;
	}
	public TransportTaskTokens withDestination(){		
		addSimpleOptions(DESTINATION);
		return this;
	}
	
	
	protected static final String STATUS = "status";
	public String getStatus(){
		return STATUS;
	}
	public TransportTaskTokens withStatus(){		
		addSimpleOptions(STATUS);
		return this;
	}
	
	
	protected static final String SENDER = "sender";
	public String getSender(){
		return SENDER;
	}
	public TransportTaskTokens withSender(){		
		addSimpleOptions(SENDER);
		return this;
	}
	
	
	protected static final String RECEIVER = "receiver";
	public String getReceiver(){
		return RECEIVER;
	}
	public TransportTaskTokens withReceiver(){		
		addSimpleOptions(RECEIVER);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public TransportTaskTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String TRANSPORT_TASK_TRACK_LIST = "transportTaskTrackList";
	public String getTransportTaskTrackList(){
		return TRANSPORT_TASK_TRACK_LIST;
	}
	public TransportTaskTokens withTransportTaskTrackList(){		
		addSimpleOptions(TRANSPORT_TASK_TRACK_LIST);
		return this;
	}
	public TransportTaskTokens analyzeTransportTaskTrackList(){		
		addSimpleOptions(TRANSPORT_TASK_TRACK_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskTrackListEnabled(){		
		
		return checkOptions(this.options(), TRANSPORT_TASK_TRACK_LIST+".anaylze");
	}
	public TransportTaskTokens extractMoreFromTransportTaskTrackList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_TRACK_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskTrackListSortCounter = 0;
	public TransportTaskTokens sortTransportTaskTrackListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_TRACK_LIST,transportTaskTrackListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskTrackListSearchCounter = 0;
	public TransportTaskTokens searchTransportTaskTrackListWith(String field, String verb, String value){		
		addSearchMoreOptions(TRANSPORT_TASK_TRACK_LIST,transportTaskTrackListSearchCounter++, field, verb, value);
		return this;
	}
	
	public TransportTaskTokens searchAllTextOfTransportTaskTrackList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(TRANSPORT_TASK_TRACK_LIST,transportTaskTrackListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportTaskTokens rowsPerPageOfTransportTaskTrackList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_TRACK_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TransportTaskTokens currentPageNumberOfTransportTaskTrackList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_TRACK_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TransportTaskTokens retainColumnsOfTransportTaskTrackList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_TRACK_LIST+"RetainColumns",columns);
		return this;
	}
	public TransportTaskTokens excludeColumnsOfTransportTaskTrackList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_TRACK_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  TransportTaskTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTransportTaskTrackList(verb, value);	
		return this;
	}
}

