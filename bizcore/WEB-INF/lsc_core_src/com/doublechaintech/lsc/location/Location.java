
package com.doublechaintech.lsc.location;

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

@JsonSerialize(using = LocationSerializer.class)
public class Location extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CONTACT_PERSON_PROPERTY        = "contactPerson"     ;
	public static final String CONTACT_PHONE_PROPERTY         = "contactPhone"      ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TASK_LIST_AS_SOURCE            = "transportTaskListAsSource";
	public static final String TRANSPORT_TASK_LIST_AS_DESTINATION       = "transportTaskListAsDestination";

	public static final String INTERNAL_TYPE="Location";
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
	protected		String              	mContactPerson      ;
	protected		String              	mContactPhone       ;
	protected		String              	mDescription        ;
	protected		Platform            	mPlatform           ;
	protected		DateTime            	mCreateTime         ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTask>	mTransportTaskListAsSource;
	protected		SmartList<TransportTask>	mTransportTaskListAsDestination;
	
		
	public 	Location(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Location(String name, String contactPerson, String contactPhone, String description, Platform platform, DateTime createTime, DateTime updateTime)
	{
		setName(name);
		setContactPerson(contactPerson);
		setContactPhone(contactPhone);
		setDescription(description);
		setPlatform(platform);
		setCreateTime(createTime);
		setUpdateTime(updateTime);

		this.mTransportTaskListAsSource = new SmartList<TransportTask>();
		this.mTransportTaskListAsDestination = new SmartList<TransportTask>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CONTACT_PERSON_PROPERTY.equals(property)){
			changeContactPersonProperty(newValueExpr);
		}
		if(CONTACT_PHONE_PROPERTY.equals(property)){
			changeContactPhoneProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}
		if(UPDATE_TIME_PROPERTY.equals(property)){
			changeUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeContactPersonProperty(String newValueExpr){
		String oldValue = getContactPerson();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContactPerson(newValue);
		this.onChangeProperty(CONTACT_PERSON_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeContactPhoneProperty(String newValueExpr){
		String oldValue = getContactPhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContactPhone(newValue);
		this.onChangeProperty(CONTACT_PHONE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCreateTimeProperty(String newValueExpr){
		DateTime oldValue = getCreateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCreateTime(newValue);
		this.onChangeProperty(CREATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeUpdateTimeProperty(String newValueExpr){
		DateTime oldValue = getUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUpdateTime(newValue);
		this.onChangeProperty(UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Location updateId(String id){
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
	public Location updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setContactPerson(String contactPerson){
		this.mContactPerson = trimString(contactPerson);;
	}
	public String getContactPerson(){
		return this.mContactPerson;
	}
	public Location updateContactPerson(String contactPerson){
		this.mContactPerson = trimString(contactPerson);;
		this.changed = true;
		return this;
	}
	
	
	public void setContactPhone(String contactPhone){
		this.mContactPhone = trimString(contactPhone);;
	}
	public String getContactPhone(){
		return this.mContactPhone;
	}
	public Location updateContactPhone(String contactPhone){
		this.mContactPhone = trimString(contactPhone);;
		this.changed = true;
		return this;
	}
	
	
	
	public String getMaskedContactPhone(){
		String mobilePhoneNumber = getContactPhone();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setDescription(String description){
		this.mDescription = description;;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public Location updateDescription(String description){
		this.mDescription = description;;
		this.changed = true;
		return this;
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Location updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public Location updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
	}
	public DateTime getUpdateTime(){
		return this.mUpdateTime;
	}
	public Location updateUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Location updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<TransportTask> getTransportTaskListAsSource(){
		if(this.mTransportTaskListAsSource == null){
			this.mTransportTaskListAsSource = new SmartList<TransportTask>();
			this.mTransportTaskListAsSource.setListInternalName (TRANSPORT_TASK_LIST_AS_SOURCE );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskListAsSource;	
	}
	public  void setTransportTaskListAsSource(SmartList<TransportTask> transportTaskListAsSource){
		for( TransportTask transportTask:transportTaskListAsSource){
			transportTask.setSource(this);
		}

		this.mTransportTaskListAsSource = transportTaskListAsSource;
		this.mTransportTaskListAsSource.setListInternalName (TRANSPORT_TASK_LIST_AS_SOURCE );
		
	}
	
	public  void addTransportTaskAsSource(TransportTask transportTask){
		transportTask.setSource(this);
		getTransportTaskListAsSource().add(transportTask);
	}
	public  void addTransportTaskListAsSource(SmartList<TransportTask> transportTaskListAsSource){
		for( TransportTask transportTask:transportTaskListAsSource){
			transportTask.setSource(this);
		}
		getTransportTaskListAsSource().addAll(transportTaskListAsSource);
	}
	
	public  TransportTask removeTransportTaskAsSource(TransportTask transportTaskIndex){
		
		int index = getTransportTaskListAsSource().indexOf(transportTaskIndex);
        if(index < 0){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTask transportTask = getTransportTaskListAsSource().get(index);        
        // transportTask.clearSource(); //disconnect with Source
        transportTask.clearFromAll(); //disconnect with Source
		
		boolean result = getTransportTaskListAsSource().planToRemove(transportTask);
        if(!result){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTask;
        
	
	}
	//断舍离
	public  void breakWithTransportTaskAsSource(TransportTask transportTask){
		
		if(transportTask == null){
			return;
		}
		transportTask.setSource(null);
		//getTransportTaskListAsSource().remove();
	
	}
	
	public  boolean hasTransportTaskAsSource(TransportTask transportTask){
	
		return getTransportTaskListAsSource().contains(transportTask);
  
	}
	
	public void copyTransportTaskAsSourceFrom(TransportTask transportTask) {

		TransportTask transportTaskInList = findTheTransportTaskAsSource(transportTask);
		TransportTask newTransportTask = new TransportTask();
		transportTaskInList.copyTo(newTransportTask);
		newTransportTask.setVersion(0);//will trigger copy
		getTransportTaskListAsSource().add(newTransportTask);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTask);
	}
	
	public  TransportTask findTheTransportTaskAsSource(TransportTask transportTask){
		
		int index =  getTransportTaskListAsSource().indexOf(transportTask);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskListAsSource().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskListAsSource(){
		getTransportTaskListAsSource().clear();
	}
	
	
	


	public  SmartList<TransportTask> getTransportTaskListAsDestination(){
		if(this.mTransportTaskListAsDestination == null){
			this.mTransportTaskListAsDestination = new SmartList<TransportTask>();
			this.mTransportTaskListAsDestination.setListInternalName (TRANSPORT_TASK_LIST_AS_DESTINATION );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskListAsDestination;	
	}
	public  void setTransportTaskListAsDestination(SmartList<TransportTask> transportTaskListAsDestination){
		for( TransportTask transportTask:transportTaskListAsDestination){
			transportTask.setDestination(this);
		}

		this.mTransportTaskListAsDestination = transportTaskListAsDestination;
		this.mTransportTaskListAsDestination.setListInternalName (TRANSPORT_TASK_LIST_AS_DESTINATION );
		
	}
	
	public  void addTransportTaskAsDestination(TransportTask transportTask){
		transportTask.setDestination(this);
		getTransportTaskListAsDestination().add(transportTask);
	}
	public  void addTransportTaskListAsDestination(SmartList<TransportTask> transportTaskListAsDestination){
		for( TransportTask transportTask:transportTaskListAsDestination){
			transportTask.setDestination(this);
		}
		getTransportTaskListAsDestination().addAll(transportTaskListAsDestination);
	}
	
	public  TransportTask removeTransportTaskAsDestination(TransportTask transportTaskIndex){
		
		int index = getTransportTaskListAsDestination().indexOf(transportTaskIndex);
        if(index < 0){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTask transportTask = getTransportTaskListAsDestination().get(index);        
        // transportTask.clearDestination(); //disconnect with Destination
        transportTask.clearFromAll(); //disconnect with Destination
		
		boolean result = getTransportTaskListAsDestination().planToRemove(transportTask);
        if(!result){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTask;
        
	
	}
	//断舍离
	public  void breakWithTransportTaskAsDestination(TransportTask transportTask){
		
		if(transportTask == null){
			return;
		}
		transportTask.setSource(null);
		//getTransportTaskListAsDestination().remove();
	
	}
	
	public  boolean hasTransportTaskAsDestination(TransportTask transportTask){
	
		return getTransportTaskListAsDestination().contains(transportTask);
  
	}
	
	public void copyTransportTaskAsDestinationFrom(TransportTask transportTask) {

		TransportTask transportTaskInList = findTheTransportTaskAsDestination(transportTask);
		TransportTask newTransportTask = new TransportTask();
		transportTaskInList.copyTo(newTransportTask);
		newTransportTask.setVersion(0);//will trigger copy
		getTransportTaskListAsDestination().add(newTransportTask);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTask);
	}
	
	public  TransportTask findTheTransportTaskAsDestination(TransportTask transportTask){
		
		int index =  getTransportTaskListAsDestination().indexOf(transportTask);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskListAsDestination().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskListAsDestination(){
		getTransportTaskListAsDestination().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransportTaskListAsSource(), internalType);
		collectFromList(this, entityList, getTransportTaskListAsDestination(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransportTaskListAsSource());
		listOfList.add( getTransportTaskListAsDestination());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CONTACT_PERSON_PROPERTY, getContactPerson());
		appendKeyValuePair(result, CONTACT_PHONE_PROPERTY, getMaskedContactPhone());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TRANSPORT_TASK_LIST_AS_SOURCE, getTransportTaskListAsSource());
		if(!getTransportTaskListAsSource().isEmpty()){
			appendKeyValuePair(result, "transportTaskAsSourceCount", getTransportTaskListAsSource().getTotalCount());
			appendKeyValuePair(result, "transportTaskAsSourceCurrentPageNumber", getTransportTaskListAsSource().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_TASK_LIST_AS_DESTINATION, getTransportTaskListAsDestination());
		if(!getTransportTaskListAsDestination().isEmpty()){
			appendKeyValuePair(result, "transportTaskAsDestinationCount", getTransportTaskListAsDestination().getTotalCount());
			appendKeyValuePair(result, "transportTaskAsDestinationCurrentPageNumber", getTransportTaskListAsDestination().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Location){
		
		
			Location dest =(Location)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setContactPerson(getContactPerson());
			dest.setContactPhone(getContactPhone());
			dest.setDescription(getDescription());
			dest.setPlatform(getPlatform());
			dest.setCreateTime(getCreateTime());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());
			dest.setTransportTaskListAsSource(getTransportTaskListAsSource());
			dest.setTransportTaskListAsDestination(getTransportTaskListAsDestination());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Location{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcontactPerson='"+getContactPerson()+"';");
		stringBuilder.append("\tcontactPhone='"+getContactPhone()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tupdateTime='"+getUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

