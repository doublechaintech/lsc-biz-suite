
package com.doublechaintech.lsc.transportproject;

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
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.platform.Platform;

@JsonSerialize(using = TransportProjectSerializer.class)
public class TransportProject extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MERCHANT_PROPERTY              = "merchant"          ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_ITEM_LIST                      = "transportItemList" ;
	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;

	public static final String INTERNAL_TYPE="TransportProject";
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
	protected		Merchant            	mMerchant           ;
	protected		Platform            	mPlatform           ;
	protected		DateTime            	mCreateTime         ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportItem>	mTransportItemList  ;
	protected		SmartList<TransportTask>	mTransportTaskList  ;
	
		
	public 	TransportProject(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setMerchant( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	TransportProject(String name, Merchant merchant, Platform platform, DateTime createTime, DateTime updateTime)
	{
		setName(name);
		setMerchant(merchant);
		setPlatform(platform);
		setCreateTime(createTime);
		setUpdateTime(updateTime);

		this.mTransportItemList = new SmartList<TransportItem>();
		this.mTransportTaskList = new SmartList<TransportTask>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
	public TransportProject updateId(String id){
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
	public TransportProject updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setMerchant(Merchant merchant){
		this.mMerchant = merchant;;
	}
	public Merchant getMerchant(){
		return this.mMerchant;
	}
	public TransportProject updateMerchant(Merchant merchant){
		this.mMerchant = merchant;;
		this.changed = true;
		return this;
	}
	
	
	public void clearMerchant(){
		setMerchant ( null );
		this.changed = true;
	}
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public TransportProject updatePlatform(Platform platform){
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
	public TransportProject updateCreateTime(DateTime createTime){
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
	public TransportProject updateUpdateTime(DateTime updateTime){
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
	public TransportProject updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<TransportItem> getTransportItemList(){
		if(this.mTransportItemList == null){
			this.mTransportItemList = new SmartList<TransportItem>();
			this.mTransportItemList.setListInternalName (TRANSPORT_ITEM_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportItemList;	
	}
	public  void setTransportItemList(SmartList<TransportItem> transportItemList){
		for( TransportItem transportItem:transportItemList){
			transportItem.setProject(this);
		}

		this.mTransportItemList = transportItemList;
		this.mTransportItemList.setListInternalName (TRANSPORT_ITEM_LIST );
		
	}
	
	public  void addTransportItem(TransportItem transportItem){
		transportItem.setProject(this);
		getTransportItemList().add(transportItem);
	}
	public  void addTransportItemList(SmartList<TransportItem> transportItemList){
		for( TransportItem transportItem:transportItemList){
			transportItem.setProject(this);
		}
		getTransportItemList().addAll(transportItemList);
	}
	
	public  TransportItem removeTransportItem(TransportItem transportItemIndex){
		
		int index = getTransportItemList().indexOf(transportItemIndex);
        if(index < 0){
        	String message = "TransportItem("+transportItemIndex.getId()+") with version='"+transportItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportItem transportItem = getTransportItemList().get(index);        
        // transportItem.clearProject(); //disconnect with Project
        transportItem.clearFromAll(); //disconnect with Project
		
		boolean result = getTransportItemList().planToRemove(transportItem);
        if(!result){
        	String message = "TransportItem("+transportItemIndex.getId()+") with version='"+transportItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportItem;
        
	
	}
	//断舍离
	public  void breakWithTransportItem(TransportItem transportItem){
		
		if(transportItem == null){
			return;
		}
		transportItem.setProject(null);
		//getTransportItemList().remove();
	
	}
	
	public  boolean hasTransportItem(TransportItem transportItem){
	
		return getTransportItemList().contains(transportItem);
  
	}
	
	public void copyTransportItemFrom(TransportItem transportItem) {

		TransportItem transportItemInList = findTheTransportItem(transportItem);
		TransportItem newTransportItem = new TransportItem();
		transportItemInList.copyTo(newTransportItem);
		newTransportItem.setVersion(0);//will trigger copy
		getTransportItemList().add(newTransportItem);
		addItemToFlexiableObject(COPIED_CHILD, newTransportItem);
	}
	
	public  TransportItem findTheTransportItem(TransportItem transportItem){
		
		int index =  getTransportItemList().indexOf(transportItem);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportItem("+transportItem.getId()+") with version='"+transportItem.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportItemList(){
		getTransportItemList().clear();
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
			transportTask.setProject(this);
		}

		this.mTransportTaskList = transportTaskList;
		this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setProject(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setProject(this);
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
        // transportTask.clearProject(); //disconnect with Project
        transportTask.clearFromAll(); //disconnect with Project
		
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
		transportTask.setProject(null);
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

		addToEntityList(this, entityList, getMerchant(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransportItemList(), internalType);
		collectFromList(this, entityList, getTransportTaskList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransportItemList());
		listOfList.add( getTransportTaskList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MERCHANT_PROPERTY, getMerchant());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TRANSPORT_ITEM_LIST, getTransportItemList());
		if(!getTransportItemList().isEmpty()){
			appendKeyValuePair(result, "transportItemCount", getTransportItemList().getTotalCount());
			appendKeyValuePair(result, "transportItemCurrentPageNumber", getTransportItemList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_TASK_LIST, getTransportTaskList());
		if(!getTransportTaskList().isEmpty()){
			appendKeyValuePair(result, "transportTaskCount", getTransportTaskList().getTotalCount());
			appendKeyValuePair(result, "transportTaskCurrentPageNumber", getTransportTaskList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportProject){
		
		
			TransportProject dest =(TransportProject)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMerchant(getMerchant());
			dest.setPlatform(getPlatform());
			dest.setCreateTime(getCreateTime());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());
			dest.setTransportItemList(getTransportItemList());
			dest.setTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TransportProject{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getMerchant() != null ){
 			stringBuilder.append("\tmerchant='Merchant("+getMerchant().getId()+")';");
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

