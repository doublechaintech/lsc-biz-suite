
package com.doublechaintech.lsc.transporttask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;

@JsonSerialize(using = TransportTaskSerializer.class)
public class TransportTask extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PROJECT_PROPERTY               = "project"           ;
	public static final String SOURCE_PROPERTY                = "source"            ;
	public static final String DESTINATION_PROPERTY           = "destination"       ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String STATUS_PROPERTY                = "status"            ;
	public static final String SENDER_PROPERTY                = "sender"            ;
	public static final String RECEIVER_PROPERTY              = "receiver"          ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TASK_TRACK_LIST                = "transportTaskTrackList";

	public static final String INTERNAL_TYPE="TransportTask";
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
	protected		TransportProject    	mProject            ;
	protected		Location            	mSource             ;
	protected		Location            	mDestination        ;
	protected		String              	mRemark             ;
	protected		TransportTaskStatus 	mStatus             ;
	protected		Merchant            	mSender             ;
	protected		Merchant            	mReceiver           ;
	protected		Platform            	mPlatform           ;
	protected		DateTime            	mCreateTime         ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTaskTrack>	mTransportTaskTrackList;
	
		
	public 	TransportTask(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProject( null );
		setSource( null );
		setDestination( null );
		setStatus( null );
		setSender( null );
		setReceiver( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	TransportTask(String name, TransportProject project, Location source, Location destination, String remark, TransportTaskStatus status, Merchant sender, Merchant receiver, Platform platform, DateTime createTime, DateTime updateTime)
	{
		setName(name);
		setProject(project);
		setSource(source);
		setDestination(destination);
		setRemark(remark);
		setStatus(status);
		setSender(sender);
		setReceiver(receiver);
		setPlatform(platform);
		setCreateTime(createTime);
		setUpdateTime(updateTime);

		this.mTransportTaskTrackList = new SmartList<TransportTaskTrack>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
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
			
			
			
	protected void changeRemarkProperty(String newValueExpr){
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemark(newValue);
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
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
	public TransportTask updateId(String id){
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
	public TransportTask updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setProject(TransportProject project){
		this.mProject = project;;
	}
	public TransportProject getProject(){
		return this.mProject;
	}
	public TransportTask updateProject(TransportProject project){
		this.mProject = project;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProject(){
		setProject ( null );
		this.changed = true;
	}
	
	public void setSource(Location source){
		this.mSource = source;;
	}
	public Location getSource(){
		return this.mSource;
	}
	public TransportTask updateSource(Location source){
		this.mSource = source;;
		this.changed = true;
		return this;
	}
	
	
	public void clearSource(){
		setSource ( null );
		this.changed = true;
	}
	
	public void setDestination(Location destination){
		this.mDestination = destination;;
	}
	public Location getDestination(){
		return this.mDestination;
	}
	public TransportTask updateDestination(Location destination){
		this.mDestination = destination;;
		this.changed = true;
		return this;
	}
	
	
	public void clearDestination(){
		setDestination ( null );
		this.changed = true;
	}
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public TransportTask updateRemark(String remark){
		this.mRemark = trimString(remark);;
		this.changed = true;
		return this;
	}
	
	
	public void setStatus(TransportTaskStatus status){
		this.mStatus = status;;
	}
	public TransportTaskStatus getStatus(){
		return this.mStatus;
	}
	public TransportTask updateStatus(TransportTaskStatus status){
		this.mStatus = status;;
		this.changed = true;
		return this;
	}
	
	
	public void clearStatus(){
		setStatus ( null );
		this.changed = true;
	}
	
	public void setSender(Merchant sender){
		this.mSender = sender;;
	}
	public Merchant getSender(){
		return this.mSender;
	}
	public TransportTask updateSender(Merchant sender){
		this.mSender = sender;;
		this.changed = true;
		return this;
	}
	
	
	public void clearSender(){
		setSender ( null );
		this.changed = true;
	}
	
	public void setReceiver(Merchant receiver){
		this.mReceiver = receiver;;
	}
	public Merchant getReceiver(){
		return this.mReceiver;
	}
	public TransportTask updateReceiver(Merchant receiver){
		this.mReceiver = receiver;;
		this.changed = true;
		return this;
	}
	
	
	public void clearReceiver(){
		setReceiver ( null );
		this.changed = true;
	}
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public TransportTask updatePlatform(Platform platform){
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
	public TransportTask updateCreateTime(DateTime createTime){
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
	public TransportTask updateUpdateTime(DateTime updateTime){
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
	public TransportTask updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<TransportTaskTrack> getTransportTaskTrackList(){
		if(this.mTransportTaskTrackList == null){
			this.mTransportTaskTrackList = new SmartList<TransportTaskTrack>();
			this.mTransportTaskTrackList.setListInternalName (TRANSPORT_TASK_TRACK_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskTrackList;	
	}
	public  void setTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList){
		for( TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			transportTaskTrack.setTask(this);
		}

		this.mTransportTaskTrackList = transportTaskTrackList;
		this.mTransportTaskTrackList.setListInternalName (TRANSPORT_TASK_TRACK_LIST );
		
	}
	
	public  void addTransportTaskTrack(TransportTaskTrack transportTaskTrack){
		transportTaskTrack.setTask(this);
		getTransportTaskTrackList().add(transportTaskTrack);
	}
	public  void addTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList){
		for( TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			transportTaskTrack.setTask(this);
		}
		getTransportTaskTrackList().addAll(transportTaskTrackList);
	}
	
	public  TransportTaskTrack removeTransportTaskTrack(TransportTaskTrack transportTaskTrackIndex){
		
		int index = getTransportTaskTrackList().indexOf(transportTaskTrackIndex);
        if(index < 0){
        	String message = "TransportTaskTrack("+transportTaskTrackIndex.getId()+") with version='"+transportTaskTrackIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTaskTrack transportTaskTrack = getTransportTaskTrackList().get(index);        
        // transportTaskTrack.clearTask(); //disconnect with Task
        transportTaskTrack.clearFromAll(); //disconnect with Task
		
		boolean result = getTransportTaskTrackList().planToRemove(transportTaskTrack);
        if(!result){
        	String message = "TransportTaskTrack("+transportTaskTrackIndex.getId()+") with version='"+transportTaskTrackIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTaskTrack;
        
	
	}
	//断舍离
	public  void breakWithTransportTaskTrack(TransportTaskTrack transportTaskTrack){
		
		if(transportTaskTrack == null){
			return;
		}
		transportTaskTrack.setTask(null);
		//getTransportTaskTrackList().remove();
	
	}
	
	public  boolean hasTransportTaskTrack(TransportTaskTrack transportTaskTrack){
	
		return getTransportTaskTrackList().contains(transportTaskTrack);
  
	}
	
	public void copyTransportTaskTrackFrom(TransportTaskTrack transportTaskTrack) {

		TransportTaskTrack transportTaskTrackInList = findTheTransportTaskTrack(transportTaskTrack);
		TransportTaskTrack newTransportTaskTrack = new TransportTaskTrack();
		transportTaskTrackInList.copyTo(newTransportTaskTrack);
		newTransportTaskTrack.setVersion(0);//will trigger copy
		getTransportTaskTrackList().add(newTransportTaskTrack);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTaskTrack);
	}
	
	public  TransportTaskTrack findTheTransportTaskTrack(TransportTaskTrack transportTaskTrack){
		
		int index =  getTransportTaskTrackList().indexOf(transportTaskTrack);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTaskTrack("+transportTaskTrack.getId()+") with version='"+transportTaskTrack.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskTrackList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskTrackList(){
		getTransportTaskTrackList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProject(), internalType);
		addToEntityList(this, entityList, getSource(), internalType);
		addToEntityList(this, entityList, getDestination(), internalType);
		addToEntityList(this, entityList, getStatus(), internalType);
		addToEntityList(this, entityList, getSender(), internalType);
		addToEntityList(this, entityList, getReceiver(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransportTaskTrackList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransportTaskTrackList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PROJECT_PROPERTY, getProject());
		appendKeyValuePair(result, SOURCE_PROPERTY, getSource());
		appendKeyValuePair(result, DESTINATION_PROPERTY, getDestination());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, STATUS_PROPERTY, getStatus());
		appendKeyValuePair(result, SENDER_PROPERTY, getSender());
		appendKeyValuePair(result, RECEIVER_PROPERTY, getReceiver());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TRANSPORT_TASK_TRACK_LIST, getTransportTaskTrackList());
		if(!getTransportTaskTrackList().isEmpty()){
			appendKeyValuePair(result, "transportTaskTrackCount", getTransportTaskTrackList().getTotalCount());
			appendKeyValuePair(result, "transportTaskTrackCurrentPageNumber", getTransportTaskTrackList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportTask){
		
		
			TransportTask dest =(TransportTask)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setProject(getProject());
			dest.setSource(getSource());
			dest.setDestination(getDestination());
			dest.setRemark(getRemark());
			dest.setStatus(getStatus());
			dest.setSender(getSender());
			dest.setReceiver(getReceiver());
			dest.setPlatform(getPlatform());
			dest.setCreateTime(getCreateTime());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());
			dest.setTransportTaskTrackList(getTransportTaskTrackList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TransportTask{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getProject() != null ){
 			stringBuilder.append("\tproject='TransportProject("+getProject().getId()+")';");
 		}
		if(getSource() != null ){
 			stringBuilder.append("\tsource='Location("+getSource().getId()+")';");
 		}
		if(getDestination() != null ){
 			stringBuilder.append("\tdestination='Location("+getDestination().getId()+")';");
 		}
		stringBuilder.append("\tremark='"+getRemark()+"';");
		if(getStatus() != null ){
 			stringBuilder.append("\tstatus='TransportTaskStatus("+getStatus().getId()+")';");
 		}
		if(getSender() != null ){
 			stringBuilder.append("\tsender='Merchant("+getSender().getId()+")';");
 		}
		if(getReceiver() != null ){
 			stringBuilder.append("\treceiver='Merchant("+getReceiver().getId()+")';");
 		}
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

