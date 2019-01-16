
package com.doublechaintech.lsc.transporttaskstatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.platform.Platform;

@JsonSerialize(using = TransportTaskStatusSerializer.class)
public class TransportTaskStatus extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;

	public static final String INTERNAL_TYPE="TransportTaskStatus";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTask>	mTransportTaskList  ;
	
		
	public 	TransportTaskStatus(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	TransportTaskStatus(String name, Platform platform)
	{
		setName(name);
		setPlatform(platform);

		this.mTransportTaskList = new SmartList<TransportTask>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public TransportTaskStatus updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public TransportTaskStatus updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public TransportTaskStatus updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TransportTaskStatus updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<TransportTask> getTransportTaskList(){
		if(this.mTransportTaskList == null){
			this.mTransportTaskList = new SmartList<TransportTask>();
			this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskList;	
	}
	public  void setTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setStatus(this);
		}

		this.mTransportTaskList = transportTaskList;
		this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setStatus(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setStatus(this);
		}
		getTransportTaskList().addAll(transportTaskList);
	}
	
	public  TransportTask removeTransportTask(TransportTask transportTaskIndex){
		
		int index = getTransportTaskList().indexOf(transportTaskIndex);
        if(index < 0){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTask transportTask = getTransportTaskList().get(index);        
        // transportTask.clearStatus(); //disconnect with Status
        transportTask.clearFromAll(); //disconnect with Status
		
		boolean result = getTransportTaskList().planToRemove(transportTask);
        if(!result){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTask;
        
	
	}
	//断舍离
	public  void breakWithTransportTask(TransportTask transportTask){
		
		if(transportTask == null){
			return;
		}
		transportTask.setStatus(null);
		//getTransportTaskList().remove();
	
	}
	
	public  boolean hasTransportTask(TransportTask transportTask){
	
		return getTransportTaskList().contains(transportTask);
  
	}
	
	public void copyTransportTaskFrom(TransportTask transportTask) {

		TransportTask transportTaskInList = findTheTransportTask(transportTask);
		TransportTask newTransportTask = new TransportTask();
		transportTaskInList.copyTo(newTransportTask);
		newTransportTask.setVersion(0);//will trigger copy
		getTransportTaskList().add(newTransportTask);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTask);
	}
	
	public  TransportTask findTheTransportTask(TransportTask transportTask){
		
		int index =  getTransportTaskList().indexOf(transportTask);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskList(){
		getTransportTaskList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransportTaskList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransportTaskList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TRANSPORT_TASK_LIST, getTransportTaskList());
		if(!getTransportTaskList().isEmpty()){
			appendKeyValuePair(result, "transportTaskCount", getTransportTaskList().getTotalCount());
			appendKeyValuePair(result, "transportTaskCurrentPageNumber", getTransportTaskList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportTaskStatus){
		
		
			TransportTaskStatus dest =(TransportTaskStatus)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TransportTaskStatus{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

