
package com.doublechaintech.lsc.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;

@JsonSerialize(using = MerchantSerializer.class)
public class Merchant extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_PROJECT_LIST                   = "transportProjectList";
	public static final String TRANSPORT_TASK_LIST_AS_SENDER            = "transportTaskListAsSender";
	public static final String TRANSPORT_TASK_LIST_AS_RECEIVER          = "transportTaskListAsReceiver";
	public static final String MERCHANT_ACCOUNT_LIST                    = "merchantAccountList";

	public static final String INTERNAL_TYPE="Merchant";
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
	protected		MerchantType        	mType               ;
	protected		Platform            	mPlatform           ;
	protected		String              	mDescription        ;
	protected		DateTime            	mCreateTime         ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportProject>	mTransportProjectList;
	protected		SmartList<TransportTask>	mTransportTaskListAsSender;
	protected		SmartList<TransportTask>	mTransportTaskListAsReceiver;
	protected		SmartList<MerchantAccount>	mMerchantAccountList;
	
		
	public 	Merchant(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setType( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Merchant(String name, MerchantType type, Platform platform, String description, DateTime createTime, DateTime updateTime)
	{
		setName(name);
		setType(type);
		setPlatform(platform);
		setDescription(description);
		setCreateTime(createTime);
		setUpdateTime(updateTime);

		this.mTransportProjectList = new SmartList<TransportProject>();
		this.mTransportTaskListAsSender = new SmartList<TransportTask>();
		this.mTransportTaskListAsReceiver = new SmartList<TransportTask>();
		this.mMerchantAccountList = new SmartList<MerchantAccount>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
	public Merchant updateId(String id){
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
	public Merchant updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setType(MerchantType type){
		this.mType = type;;
	}
	public MerchantType getType(){
		return this.mType;
	}
	public Merchant updateType(MerchantType type){
		this.mType = type;;
		this.changed = true;
		return this;
	}
	
	
	public void clearType(){
		setType ( null );
		this.changed = true;
	}
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Merchant updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setDescription(String description){
		this.mDescription = description;;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public Merchant updateDescription(String description){
		this.mDescription = description;;
		this.changed = true;
		return this;
	}
	
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public Merchant updateCreateTime(DateTime createTime){
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
	public Merchant updateUpdateTime(DateTime updateTime){
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
	public Merchant updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<TransportProject> getTransportProjectList(){
		if(this.mTransportProjectList == null){
			this.mTransportProjectList = new SmartList<TransportProject>();
			this.mTransportProjectList.setListInternalName (TRANSPORT_PROJECT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportProjectList;	
	}
	public  void setTransportProjectList(SmartList<TransportProject> transportProjectList){
		for( TransportProject transportProject:transportProjectList){
			transportProject.setMerchant(this);
		}

		this.mTransportProjectList = transportProjectList;
		this.mTransportProjectList.setListInternalName (TRANSPORT_PROJECT_LIST );
		
	}
	
	public  void addTransportProject(TransportProject transportProject){
		transportProject.setMerchant(this);
		getTransportProjectList().add(transportProject);
	}
	public  void addTransportProjectList(SmartList<TransportProject> transportProjectList){
		for( TransportProject transportProject:transportProjectList){
			transportProject.setMerchant(this);
		}
		getTransportProjectList().addAll(transportProjectList);
	}
	
	public  TransportProject removeTransportProject(TransportProject transportProjectIndex){
		
		int index = getTransportProjectList().indexOf(transportProjectIndex);
        if(index < 0){
        	String message = "TransportProject("+transportProjectIndex.getId()+") with version='"+transportProjectIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportProject transportProject = getTransportProjectList().get(index);        
        // transportProject.clearMerchant(); //disconnect with Merchant
        transportProject.clearFromAll(); //disconnect with Merchant
		
		boolean result = getTransportProjectList().planToRemove(transportProject);
        if(!result){
        	String message = "TransportProject("+transportProjectIndex.getId()+") with version='"+transportProjectIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportProject;
        
	
	}
	//断舍离
	public  void breakWithTransportProject(TransportProject transportProject){
		
		if(transportProject == null){
			return;
		}
		transportProject.setMerchant(null);
		//getTransportProjectList().remove();
	
	}
	
	public  boolean hasTransportProject(TransportProject transportProject){
	
		return getTransportProjectList().contains(transportProject);
  
	}
	
	public void copyTransportProjectFrom(TransportProject transportProject) {

		TransportProject transportProjectInList = findTheTransportProject(transportProject);
		TransportProject newTransportProject = new TransportProject();
		transportProjectInList.copyTo(newTransportProject);
		newTransportProject.setVersion(0);//will trigger copy
		getTransportProjectList().add(newTransportProject);
		addItemToFlexiableObject(COPIED_CHILD, newTransportProject);
	}
	
	public  TransportProject findTheTransportProject(TransportProject transportProject){
		
		int index =  getTransportProjectList().indexOf(transportProject);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportProject("+transportProject.getId()+") with version='"+transportProject.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportProjectList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportProjectList(){
		getTransportProjectList().clear();
	}
	
	
	


	public  SmartList<TransportTask> getTransportTaskListAsSender(){
		if(this.mTransportTaskListAsSender == null){
			this.mTransportTaskListAsSender = new SmartList<TransportTask>();
			this.mTransportTaskListAsSender.setListInternalName (TRANSPORT_TASK_LIST_AS_SENDER );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskListAsSender;	
	}
	public  void setTransportTaskListAsSender(SmartList<TransportTask> transportTaskListAsSender){
		for( TransportTask transportTask:transportTaskListAsSender){
			transportTask.setSender(this);
		}

		this.mTransportTaskListAsSender = transportTaskListAsSender;
		this.mTransportTaskListAsSender.setListInternalName (TRANSPORT_TASK_LIST_AS_SENDER );
		
	}
	
	public  void addTransportTaskAsSender(TransportTask transportTask){
		transportTask.setSender(this);
		getTransportTaskListAsSender().add(transportTask);
	}
	public  void addTransportTaskListAsSender(SmartList<TransportTask> transportTaskListAsSender){
		for( TransportTask transportTask:transportTaskListAsSender){
			transportTask.setSender(this);
		}
		getTransportTaskListAsSender().addAll(transportTaskListAsSender);
	}
	
	public  TransportTask removeTransportTaskAsSender(TransportTask transportTaskIndex){
		
		int index = getTransportTaskListAsSender().indexOf(transportTaskIndex);
        if(index < 0){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTask transportTask = getTransportTaskListAsSender().get(index);        
        // transportTask.clearSender(); //disconnect with Sender
        transportTask.clearFromAll(); //disconnect with Sender
		
		boolean result = getTransportTaskListAsSender().planToRemove(transportTask);
        if(!result){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTask;
        
	
	}
	//断舍离
	public  void breakWithTransportTaskAsSender(TransportTask transportTask){
		
		if(transportTask == null){
			return;
		}
		transportTask.setSender(null);
		//getTransportTaskListAsSender().remove();
	
	}
	
	public  boolean hasTransportTaskAsSender(TransportTask transportTask){
	
		return getTransportTaskListAsSender().contains(transportTask);
  
	}
	
	public void copyTransportTaskAsSenderFrom(TransportTask transportTask) {

		TransportTask transportTaskInList = findTheTransportTaskAsSender(transportTask);
		TransportTask newTransportTask = new TransportTask();
		transportTaskInList.copyTo(newTransportTask);
		newTransportTask.setVersion(0);//will trigger copy
		getTransportTaskListAsSender().add(newTransportTask);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTask);
	}
	
	public  TransportTask findTheTransportTaskAsSender(TransportTask transportTask){
		
		int index =  getTransportTaskListAsSender().indexOf(transportTask);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskListAsSender().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskListAsSender(){
		getTransportTaskListAsSender().clear();
	}
	
	
	


	public  SmartList<TransportTask> getTransportTaskListAsReceiver(){
		if(this.mTransportTaskListAsReceiver == null){
			this.mTransportTaskListAsReceiver = new SmartList<TransportTask>();
			this.mTransportTaskListAsReceiver.setListInternalName (TRANSPORT_TASK_LIST_AS_RECEIVER );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskListAsReceiver;	
	}
	public  void setTransportTaskListAsReceiver(SmartList<TransportTask> transportTaskListAsReceiver){
		for( TransportTask transportTask:transportTaskListAsReceiver){
			transportTask.setReceiver(this);
		}

		this.mTransportTaskListAsReceiver = transportTaskListAsReceiver;
		this.mTransportTaskListAsReceiver.setListInternalName (TRANSPORT_TASK_LIST_AS_RECEIVER );
		
	}
	
	public  void addTransportTaskAsReceiver(TransportTask transportTask){
		transportTask.setReceiver(this);
		getTransportTaskListAsReceiver().add(transportTask);
	}
	public  void addTransportTaskListAsReceiver(SmartList<TransportTask> transportTaskListAsReceiver){
		for( TransportTask transportTask:transportTaskListAsReceiver){
			transportTask.setReceiver(this);
		}
		getTransportTaskListAsReceiver().addAll(transportTaskListAsReceiver);
	}
	
	public  TransportTask removeTransportTaskAsReceiver(TransportTask transportTaskIndex){
		
		int index = getTransportTaskListAsReceiver().indexOf(transportTaskIndex);
        if(index < 0){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTask transportTask = getTransportTaskListAsReceiver().get(index);        
        // transportTask.clearReceiver(); //disconnect with Receiver
        transportTask.clearFromAll(); //disconnect with Receiver
		
		boolean result = getTransportTaskListAsReceiver().planToRemove(transportTask);
        if(!result){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTask;
        
	
	}
	//断舍离
	public  void breakWithTransportTaskAsReceiver(TransportTask transportTask){
		
		if(transportTask == null){
			return;
		}
		transportTask.setSender(null);
		//getTransportTaskListAsReceiver().remove();
	
	}
	
	public  boolean hasTransportTaskAsReceiver(TransportTask transportTask){
	
		return getTransportTaskListAsReceiver().contains(transportTask);
  
	}
	
	public void copyTransportTaskAsReceiverFrom(TransportTask transportTask) {

		TransportTask transportTaskInList = findTheTransportTaskAsReceiver(transportTask);
		TransportTask newTransportTask = new TransportTask();
		transportTaskInList.copyTo(newTransportTask);
		newTransportTask.setVersion(0);//will trigger copy
		getTransportTaskListAsReceiver().add(newTransportTask);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTask);
	}
	
	public  TransportTask findTheTransportTaskAsReceiver(TransportTask transportTask){
		
		int index =  getTransportTaskListAsReceiver().indexOf(transportTask);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskListAsReceiver().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskListAsReceiver(){
		getTransportTaskListAsReceiver().clear();
	}
	
	
	


	public  SmartList<MerchantAccount> getMerchantAccountList(){
		if(this.mMerchantAccountList == null){
			this.mMerchantAccountList = new SmartList<MerchantAccount>();
			this.mMerchantAccountList.setListInternalName (MERCHANT_ACCOUNT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mMerchantAccountList;	
	}
	public  void setMerchantAccountList(SmartList<MerchantAccount> merchantAccountList){
		for( MerchantAccount merchantAccount:merchantAccountList){
			merchantAccount.setMerchant(this);
		}

		this.mMerchantAccountList = merchantAccountList;
		this.mMerchantAccountList.setListInternalName (MERCHANT_ACCOUNT_LIST );
		
	}
	
	public  void addMerchantAccount(MerchantAccount merchantAccount){
		merchantAccount.setMerchant(this);
		getMerchantAccountList().add(merchantAccount);
	}
	public  void addMerchantAccountList(SmartList<MerchantAccount> merchantAccountList){
		for( MerchantAccount merchantAccount:merchantAccountList){
			merchantAccount.setMerchant(this);
		}
		getMerchantAccountList().addAll(merchantAccountList);
	}
	
	public  MerchantAccount removeMerchantAccount(MerchantAccount merchantAccountIndex){
		
		int index = getMerchantAccountList().indexOf(merchantAccountIndex);
        if(index < 0){
        	String message = "MerchantAccount("+merchantAccountIndex.getId()+") with version='"+merchantAccountIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        MerchantAccount merchantAccount = getMerchantAccountList().get(index);        
        // merchantAccount.clearMerchant(); //disconnect with Merchant
        merchantAccount.clearFromAll(); //disconnect with Merchant
		
		boolean result = getMerchantAccountList().planToRemove(merchantAccount);
        if(!result){
        	String message = "MerchantAccount("+merchantAccountIndex.getId()+") with version='"+merchantAccountIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return merchantAccount;
        
	
	}
	//断舍离
	public  void breakWithMerchantAccount(MerchantAccount merchantAccount){
		
		if(merchantAccount == null){
			return;
		}
		merchantAccount.setMerchant(null);
		//getMerchantAccountList().remove();
	
	}
	
	public  boolean hasMerchantAccount(MerchantAccount merchantAccount){
	
		return getMerchantAccountList().contains(merchantAccount);
  
	}
	
	public void copyMerchantAccountFrom(MerchantAccount merchantAccount) {

		MerchantAccount merchantAccountInList = findTheMerchantAccount(merchantAccount);
		MerchantAccount newMerchantAccount = new MerchantAccount();
		merchantAccountInList.copyTo(newMerchantAccount);
		newMerchantAccount.setVersion(0);//will trigger copy
		getMerchantAccountList().add(newMerchantAccount);
		addItemToFlexiableObject(COPIED_CHILD, newMerchantAccount);
	}
	
	public  MerchantAccount findTheMerchantAccount(MerchantAccount merchantAccount){
		
		int index =  getMerchantAccountList().indexOf(merchantAccount);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "MerchantAccount("+merchantAccount.getId()+") with version='"+merchantAccount.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getMerchantAccountList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMerchantAccountList(){
		getMerchantAccountList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getType(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransportProjectList(), internalType);
		collectFromList(this, entityList, getTransportTaskListAsSender(), internalType);
		collectFromList(this, entityList, getTransportTaskListAsReceiver(), internalType);
		collectFromList(this, entityList, getMerchantAccountList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransportProjectList());
		listOfList.add( getTransportTaskListAsSender());
		listOfList.add( getTransportTaskListAsReceiver());
		listOfList.add( getMerchantAccountList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TRANSPORT_PROJECT_LIST, getTransportProjectList());
		if(!getTransportProjectList().isEmpty()){
			appendKeyValuePair(result, "transportProjectCount", getTransportProjectList().getTotalCount());
			appendKeyValuePair(result, "transportProjectCurrentPageNumber", getTransportProjectList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_TASK_LIST_AS_SENDER, getTransportTaskListAsSender());
		if(!getTransportTaskListAsSender().isEmpty()){
			appendKeyValuePair(result, "transportTaskAsSenderCount", getTransportTaskListAsSender().getTotalCount());
			appendKeyValuePair(result, "transportTaskAsSenderCurrentPageNumber", getTransportTaskListAsSender().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_TASK_LIST_AS_RECEIVER, getTransportTaskListAsReceiver());
		if(!getTransportTaskListAsReceiver().isEmpty()){
			appendKeyValuePair(result, "transportTaskAsReceiverCount", getTransportTaskListAsReceiver().getTotalCount());
			appendKeyValuePair(result, "transportTaskAsReceiverCurrentPageNumber", getTransportTaskListAsReceiver().getCurrentPageNumber());
		}
		appendKeyValuePair(result, MERCHANT_ACCOUNT_LIST, getMerchantAccountList());
		if(!getMerchantAccountList().isEmpty()){
			appendKeyValuePair(result, "merchantAccountCount", getMerchantAccountList().getTotalCount());
			appendKeyValuePair(result, "merchantAccountCurrentPageNumber", getMerchantAccountList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Merchant){
		
		
			Merchant dest =(Merchant)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setType(getType());
			dest.setPlatform(getPlatform());
			dest.setDescription(getDescription());
			dest.setCreateTime(getCreateTime());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());
			dest.setTransportProjectList(getTransportProjectList());
			dest.setTransportTaskListAsSender(getTransportTaskListAsSender());
			dest.setTransportTaskListAsReceiver(getTransportTaskListAsReceiver());
			dest.setMerchantAccountList(getMerchantAccountList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Merchant{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getType() != null ){
 			stringBuilder.append("\ttype='MerchantType("+getType().getId()+")';");
 		}
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tupdateTime='"+getUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

