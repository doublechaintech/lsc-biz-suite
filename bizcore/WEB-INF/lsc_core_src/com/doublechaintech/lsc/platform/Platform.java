
package com.doublechaintech.lsc.platform;

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
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.transactiontype.TransactionType;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.merchanttype.MerchantType;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String INTRODUCTION_PROPERTY          = "introduction"      ;
	public static final String CURRENT_VERSION_PROPERTY       = "currentVersion"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSACTION_TYPE_LIST                    = "transactionTypeList";
	public static final String MERCHANT_TYPE_LIST                       = "merchantTypeList"  ;
	public static final String TRANSPORT_TASK_STATUS_LIST               = "transportTaskStatusList";
	public static final String LOCATION_LIST                            = "locationList"      ;
	public static final String MERCHANT_LIST                            = "merchantList"      ;
	public static final String TRANSPORT_PROJECT_LIST                   = "transportProjectList";
	public static final String TRANSPORT_ITEM_LIST                      = "transportItemList" ;
	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;

	public static final String INTERNAL_TYPE="Platform";
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
	protected		String              	mIntroduction       ;
	protected		String              	mCurrentVersion     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransactionType>	mTransactionTypeList;
	protected		SmartList<MerchantType>	mMerchantTypeList   ;
	protected		SmartList<TransportTaskStatus>	mTransportTaskStatusList;
	protected		SmartList<Location> 	mLocationList       ;
	protected		SmartList<Merchant> 	mMerchantList       ;
	protected		SmartList<TransportProject>	mTransportProjectList;
	protected		SmartList<TransportItem>	mTransportItemList  ;
	protected		SmartList<TransportTask>	mTransportTaskList  ;
	
		
	public 	Platform(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name, String introduction, String currentVersion)
	{
		setName(name);
		setIntroduction(introduction);
		setCurrentVersion(currentVersion);

		this.mTransactionTypeList = new SmartList<TransactionType>();
		this.mMerchantTypeList = new SmartList<MerchantType>();
		this.mTransportTaskStatusList = new SmartList<TransportTaskStatus>();
		this.mLocationList = new SmartList<Location>();
		this.mMerchantList = new SmartList<Merchant>();
		this.mTransportProjectList = new SmartList<TransportProject>();
		this.mTransportItemList = new SmartList<TransportItem>();
		this.mTransportTaskList = new SmartList<TransportTask>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(INTRODUCTION_PROPERTY.equals(property)){
			changeIntroductionProperty(newValueExpr);
		}
		if(CURRENT_VERSION_PROPERTY.equals(property)){
			changeCurrentVersionProperty(newValueExpr);
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
			
			
			
	protected void changeIntroductionProperty(String newValueExpr){
		String oldValue = getIntroduction();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIntroduction(newValue);
		this.onChangeProperty(INTRODUCTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCurrentVersionProperty(String newValueExpr){
		String oldValue = getCurrentVersion();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCurrentVersion(newValue);
		this.onChangeProperty(CURRENT_VERSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Platform updateId(String id){
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
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
	}
	public String getIntroduction(){
		return this.mIntroduction;
	}
	public Platform updateIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
		this.changed = true;
		return this;
	}
	
	
	public void setCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
	}
	public String getCurrentVersion(){
		return this.mCurrentVersion;
	}
	public Platform updateCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<TransactionType> getTransactionTypeList(){
		if(this.mTransactionTypeList == null){
			this.mTransactionTypeList = new SmartList<TransactionType>();
			this.mTransactionTypeList.setListInternalName (TRANSACTION_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransactionTypeList;	
	}
	public  void setTransactionTypeList(SmartList<TransactionType> transactionTypeList){
		for( TransactionType transactionType:transactionTypeList){
			transactionType.setPlatform(this);
		}

		this.mTransactionTypeList = transactionTypeList;
		this.mTransactionTypeList.setListInternalName (TRANSACTION_TYPE_LIST );
		
	}
	
	public  void addTransactionType(TransactionType transactionType){
		transactionType.setPlatform(this);
		getTransactionTypeList().add(transactionType);
	}
	public  void addTransactionTypeList(SmartList<TransactionType> transactionTypeList){
		for( TransactionType transactionType:transactionTypeList){
			transactionType.setPlatform(this);
		}
		getTransactionTypeList().addAll(transactionTypeList);
	}
	
	public  TransactionType removeTransactionType(TransactionType transactionTypeIndex){
		
		int index = getTransactionTypeList().indexOf(transactionTypeIndex);
        if(index < 0){
        	String message = "TransactionType("+transactionTypeIndex.getId()+") with version='"+transactionTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransactionType transactionType = getTransactionTypeList().get(index);        
        // transactionType.clearPlatform(); //disconnect with Platform
        transactionType.clearFromAll(); //disconnect with Platform
		
		boolean result = getTransactionTypeList().planToRemove(transactionType);
        if(!result){
        	String message = "TransactionType("+transactionTypeIndex.getId()+") with version='"+transactionTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transactionType;
        
	
	}
	//断舍离
	public  void breakWithTransactionType(TransactionType transactionType){
		
		if(transactionType == null){
			return;
		}
		transactionType.setPlatform(null);
		//getTransactionTypeList().remove();
	
	}
	
	public  boolean hasTransactionType(TransactionType transactionType){
	
		return getTransactionTypeList().contains(transactionType);
  
	}
	
	public void copyTransactionTypeFrom(TransactionType transactionType) {

		TransactionType transactionTypeInList = findTheTransactionType(transactionType);
		TransactionType newTransactionType = new TransactionType();
		transactionTypeInList.copyTo(newTransactionType);
		newTransactionType.setVersion(0);//will trigger copy
		getTransactionTypeList().add(newTransactionType);
		addItemToFlexiableObject(COPIED_CHILD, newTransactionType);
	}
	
	public  TransactionType findTheTransactionType(TransactionType transactionType){
		
		int index =  getTransactionTypeList().indexOf(transactionType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransactionType("+transactionType.getId()+") with version='"+transactionType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransactionTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransactionTypeList(){
		getTransactionTypeList().clear();
	}
	
	
	


	public  SmartList<MerchantType> getMerchantTypeList(){
		if(this.mMerchantTypeList == null){
			this.mMerchantTypeList = new SmartList<MerchantType>();
			this.mMerchantTypeList.setListInternalName (MERCHANT_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mMerchantTypeList;	
	}
	public  void setMerchantTypeList(SmartList<MerchantType> merchantTypeList){
		for( MerchantType merchantType:merchantTypeList){
			merchantType.setPlatform(this);
		}

		this.mMerchantTypeList = merchantTypeList;
		this.mMerchantTypeList.setListInternalName (MERCHANT_TYPE_LIST );
		
	}
	
	public  void addMerchantType(MerchantType merchantType){
		merchantType.setPlatform(this);
		getMerchantTypeList().add(merchantType);
	}
	public  void addMerchantTypeList(SmartList<MerchantType> merchantTypeList){
		for( MerchantType merchantType:merchantTypeList){
			merchantType.setPlatform(this);
		}
		getMerchantTypeList().addAll(merchantTypeList);
	}
	
	public  MerchantType removeMerchantType(MerchantType merchantTypeIndex){
		
		int index = getMerchantTypeList().indexOf(merchantTypeIndex);
        if(index < 0){
        	String message = "MerchantType("+merchantTypeIndex.getId()+") with version='"+merchantTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        MerchantType merchantType = getMerchantTypeList().get(index);        
        // merchantType.clearPlatform(); //disconnect with Platform
        merchantType.clearFromAll(); //disconnect with Platform
		
		boolean result = getMerchantTypeList().planToRemove(merchantType);
        if(!result){
        	String message = "MerchantType("+merchantTypeIndex.getId()+") with version='"+merchantTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return merchantType;
        
	
	}
	//断舍离
	public  void breakWithMerchantType(MerchantType merchantType){
		
		if(merchantType == null){
			return;
		}
		merchantType.setPlatform(null);
		//getMerchantTypeList().remove();
	
	}
	
	public  boolean hasMerchantType(MerchantType merchantType){
	
		return getMerchantTypeList().contains(merchantType);
  
	}
	
	public void copyMerchantTypeFrom(MerchantType merchantType) {

		MerchantType merchantTypeInList = findTheMerchantType(merchantType);
		MerchantType newMerchantType = new MerchantType();
		merchantTypeInList.copyTo(newMerchantType);
		newMerchantType.setVersion(0);//will trigger copy
		getMerchantTypeList().add(newMerchantType);
		addItemToFlexiableObject(COPIED_CHILD, newMerchantType);
	}
	
	public  MerchantType findTheMerchantType(MerchantType merchantType){
		
		int index =  getMerchantTypeList().indexOf(merchantType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "MerchantType("+merchantType.getId()+") with version='"+merchantType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getMerchantTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMerchantTypeList(){
		getMerchantTypeList().clear();
	}
	
	
	


	public  SmartList<TransportTaskStatus> getTransportTaskStatusList(){
		if(this.mTransportTaskStatusList == null){
			this.mTransportTaskStatusList = new SmartList<TransportTaskStatus>();
			this.mTransportTaskStatusList.setListInternalName (TRANSPORT_TASK_STATUS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskStatusList;	
	}
	public  void setTransportTaskStatusList(SmartList<TransportTaskStatus> transportTaskStatusList){
		for( TransportTaskStatus transportTaskStatus:transportTaskStatusList){
			transportTaskStatus.setPlatform(this);
		}

		this.mTransportTaskStatusList = transportTaskStatusList;
		this.mTransportTaskStatusList.setListInternalName (TRANSPORT_TASK_STATUS_LIST );
		
	}
	
	public  void addTransportTaskStatus(TransportTaskStatus transportTaskStatus){
		transportTaskStatus.setPlatform(this);
		getTransportTaskStatusList().add(transportTaskStatus);
	}
	public  void addTransportTaskStatusList(SmartList<TransportTaskStatus> transportTaskStatusList){
		for( TransportTaskStatus transportTaskStatus:transportTaskStatusList){
			transportTaskStatus.setPlatform(this);
		}
		getTransportTaskStatusList().addAll(transportTaskStatusList);
	}
	
	public  TransportTaskStatus removeTransportTaskStatus(TransportTaskStatus transportTaskStatusIndex){
		
		int index = getTransportTaskStatusList().indexOf(transportTaskStatusIndex);
        if(index < 0){
        	String message = "TransportTaskStatus("+transportTaskStatusIndex.getId()+") with version='"+transportTaskStatusIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTaskStatus transportTaskStatus = getTransportTaskStatusList().get(index);        
        // transportTaskStatus.clearPlatform(); //disconnect with Platform
        transportTaskStatus.clearFromAll(); //disconnect with Platform
		
		boolean result = getTransportTaskStatusList().planToRemove(transportTaskStatus);
        if(!result){
        	String message = "TransportTaskStatus("+transportTaskStatusIndex.getId()+") with version='"+transportTaskStatusIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTaskStatus;
        
	
	}
	//断舍离
	public  void breakWithTransportTaskStatus(TransportTaskStatus transportTaskStatus){
		
		if(transportTaskStatus == null){
			return;
		}
		transportTaskStatus.setPlatform(null);
		//getTransportTaskStatusList().remove();
	
	}
	
	public  boolean hasTransportTaskStatus(TransportTaskStatus transportTaskStatus){
	
		return getTransportTaskStatusList().contains(transportTaskStatus);
  
	}
	
	public void copyTransportTaskStatusFrom(TransportTaskStatus transportTaskStatus) {

		TransportTaskStatus transportTaskStatusInList = findTheTransportTaskStatus(transportTaskStatus);
		TransportTaskStatus newTransportTaskStatus = new TransportTaskStatus();
		transportTaskStatusInList.copyTo(newTransportTaskStatus);
		newTransportTaskStatus.setVersion(0);//will trigger copy
		getTransportTaskStatusList().add(newTransportTaskStatus);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTaskStatus);
	}
	
	public  TransportTaskStatus findTheTransportTaskStatus(TransportTaskStatus transportTaskStatus){
		
		int index =  getTransportTaskStatusList().indexOf(transportTaskStatus);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTaskStatus("+transportTaskStatus.getId()+") with version='"+transportTaskStatus.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskStatusList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskStatusList(){
		getTransportTaskStatusList().clear();
	}
	
	
	


	public  SmartList<Location> getLocationList(){
		if(this.mLocationList == null){
			this.mLocationList = new SmartList<Location>();
			this.mLocationList.setListInternalName (LOCATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLocationList;	
	}
	public  void setLocationList(SmartList<Location> locationList){
		for( Location location:locationList){
			location.setPlatform(this);
		}

		this.mLocationList = locationList;
		this.mLocationList.setListInternalName (LOCATION_LIST );
		
	}
	
	public  void addLocation(Location location){
		location.setPlatform(this);
		getLocationList().add(location);
	}
	public  void addLocationList(SmartList<Location> locationList){
		for( Location location:locationList){
			location.setPlatform(this);
		}
		getLocationList().addAll(locationList);
	}
	
	public  Location removeLocation(Location locationIndex){
		
		int index = getLocationList().indexOf(locationIndex);
        if(index < 0){
        	String message = "Location("+locationIndex.getId()+") with version='"+locationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Location location = getLocationList().get(index);        
        // location.clearPlatform(); //disconnect with Platform
        location.clearFromAll(); //disconnect with Platform
		
		boolean result = getLocationList().planToRemove(location);
        if(!result){
        	String message = "Location("+locationIndex.getId()+") with version='"+locationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return location;
        
	
	}
	//断舍离
	public  void breakWithLocation(Location location){
		
		if(location == null){
			return;
		}
		location.setPlatform(null);
		//getLocationList().remove();
	
	}
	
	public  boolean hasLocation(Location location){
	
		return getLocationList().contains(location);
  
	}
	
	public void copyLocationFrom(Location location) {

		Location locationInList = findTheLocation(location);
		Location newLocation = new Location();
		locationInList.copyTo(newLocation);
		newLocation.setVersion(0);//will trigger copy
		getLocationList().add(newLocation);
		addItemToFlexiableObject(COPIED_CHILD, newLocation);
	}
	
	public  Location findTheLocation(Location location){
		
		int index =  getLocationList().indexOf(location);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Location("+location.getId()+") with version='"+location.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLocationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLocationList(){
		getLocationList().clear();
	}
	
	
	


	public  SmartList<Merchant> getMerchantList(){
		if(this.mMerchantList == null){
			this.mMerchantList = new SmartList<Merchant>();
			this.mMerchantList.setListInternalName (MERCHANT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mMerchantList;	
	}
	public  void setMerchantList(SmartList<Merchant> merchantList){
		for( Merchant merchant:merchantList){
			merchant.setPlatform(this);
		}

		this.mMerchantList = merchantList;
		this.mMerchantList.setListInternalName (MERCHANT_LIST );
		
	}
	
	public  void addMerchant(Merchant merchant){
		merchant.setPlatform(this);
		getMerchantList().add(merchant);
	}
	public  void addMerchantList(SmartList<Merchant> merchantList){
		for( Merchant merchant:merchantList){
			merchant.setPlatform(this);
		}
		getMerchantList().addAll(merchantList);
	}
	
	public  Merchant removeMerchant(Merchant merchantIndex){
		
		int index = getMerchantList().indexOf(merchantIndex);
        if(index < 0){
        	String message = "Merchant("+merchantIndex.getId()+") with version='"+merchantIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Merchant merchant = getMerchantList().get(index);        
        // merchant.clearPlatform(); //disconnect with Platform
        merchant.clearFromAll(); //disconnect with Platform
		
		boolean result = getMerchantList().planToRemove(merchant);
        if(!result){
        	String message = "Merchant("+merchantIndex.getId()+") with version='"+merchantIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return merchant;
        
	
	}
	//断舍离
	public  void breakWithMerchant(Merchant merchant){
		
		if(merchant == null){
			return;
		}
		merchant.setPlatform(null);
		//getMerchantList().remove();
	
	}
	
	public  boolean hasMerchant(Merchant merchant){
	
		return getMerchantList().contains(merchant);
  
	}
	
	public void copyMerchantFrom(Merchant merchant) {

		Merchant merchantInList = findTheMerchant(merchant);
		Merchant newMerchant = new Merchant();
		merchantInList.copyTo(newMerchant);
		newMerchant.setVersion(0);//will trigger copy
		getMerchantList().add(newMerchant);
		addItemToFlexiableObject(COPIED_CHILD, newMerchant);
	}
	
	public  Merchant findTheMerchant(Merchant merchant){
		
		int index =  getMerchantList().indexOf(merchant);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Merchant("+merchant.getId()+") with version='"+merchant.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getMerchantList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMerchantList(){
		getMerchantList().clear();
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
			transportProject.setPlatform(this);
		}

		this.mTransportProjectList = transportProjectList;
		this.mTransportProjectList.setListInternalName (TRANSPORT_PROJECT_LIST );
		
	}
	
	public  void addTransportProject(TransportProject transportProject){
		transportProject.setPlatform(this);
		getTransportProjectList().add(transportProject);
	}
	public  void addTransportProjectList(SmartList<TransportProject> transportProjectList){
		for( TransportProject transportProject:transportProjectList){
			transportProject.setPlatform(this);
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
        // transportProject.clearPlatform(); //disconnect with Platform
        transportProject.clearFromAll(); //disconnect with Platform
		
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
		transportProject.setPlatform(null);
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
			transportItem.setPlatform(this);
		}

		this.mTransportItemList = transportItemList;
		this.mTransportItemList.setListInternalName (TRANSPORT_ITEM_LIST );
		
	}
	
	public  void addTransportItem(TransportItem transportItem){
		transportItem.setPlatform(this);
		getTransportItemList().add(transportItem);
	}
	public  void addTransportItemList(SmartList<TransportItem> transportItemList){
		for( TransportItem transportItem:transportItemList){
			transportItem.setPlatform(this);
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
        // transportItem.clearPlatform(); //disconnect with Platform
        transportItem.clearFromAll(); //disconnect with Platform
		
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
		transportItem.setPlatform(null);
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
			transportTask.setPlatform(this);
		}

		this.mTransportTaskList = transportTaskList;
		this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setPlatform(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setPlatform(this);
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
        // transportTask.clearPlatform(); //disconnect with Platform
        transportTask.clearFromAll(); //disconnect with Platform
		
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
		transportTask.setPlatform(null);
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


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransactionTypeList(), internalType);
		collectFromList(this, entityList, getMerchantTypeList(), internalType);
		collectFromList(this, entityList, getTransportTaskStatusList(), internalType);
		collectFromList(this, entityList, getLocationList(), internalType);
		collectFromList(this, entityList, getMerchantList(), internalType);
		collectFromList(this, entityList, getTransportProjectList(), internalType);
		collectFromList(this, entityList, getTransportItemList(), internalType);
		collectFromList(this, entityList, getTransportTaskList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransactionTypeList());
		listOfList.add( getMerchantTypeList());
		listOfList.add( getTransportTaskStatusList());
		listOfList.add( getLocationList());
		listOfList.add( getMerchantList());
		listOfList.add( getTransportProjectList());
		listOfList.add( getTransportItemList());
		listOfList.add( getTransportTaskList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, INTRODUCTION_PROPERTY, getIntroduction());
		appendKeyValuePair(result, CURRENT_VERSION_PROPERTY, getCurrentVersion());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TRANSACTION_TYPE_LIST, getTransactionTypeList());
		if(!getTransactionTypeList().isEmpty()){
			appendKeyValuePair(result, "transactionTypeCount", getTransactionTypeList().getTotalCount());
			appendKeyValuePair(result, "transactionTypeCurrentPageNumber", getTransactionTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, MERCHANT_TYPE_LIST, getMerchantTypeList());
		if(!getMerchantTypeList().isEmpty()){
			appendKeyValuePair(result, "merchantTypeCount", getMerchantTypeList().getTotalCount());
			appendKeyValuePair(result, "merchantTypeCurrentPageNumber", getMerchantTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_TASK_STATUS_LIST, getTransportTaskStatusList());
		if(!getTransportTaskStatusList().isEmpty()){
			appendKeyValuePair(result, "transportTaskStatusCount", getTransportTaskStatusList().getTotalCount());
			appendKeyValuePair(result, "transportTaskStatusCurrentPageNumber", getTransportTaskStatusList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, LOCATION_LIST, getLocationList());
		if(!getLocationList().isEmpty()){
			appendKeyValuePair(result, "locationCount", getLocationList().getTotalCount());
			appendKeyValuePair(result, "locationCurrentPageNumber", getLocationList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, MERCHANT_LIST, getMerchantList());
		if(!getMerchantList().isEmpty()){
			appendKeyValuePair(result, "merchantCount", getMerchantList().getTotalCount());
			appendKeyValuePair(result, "merchantCurrentPageNumber", getMerchantList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_PROJECT_LIST, getTransportProjectList());
		if(!getTransportProjectList().isEmpty()){
			appendKeyValuePair(result, "transportProjectCount", getTransportProjectList().getTotalCount());
			appendKeyValuePair(result, "transportProjectCurrentPageNumber", getTransportProjectList().getCurrentPageNumber());
		}
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
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setIntroduction(getIntroduction());
			dest.setCurrentVersion(getCurrentVersion());
			dest.setVersion(getVersion());
			dest.setTransactionTypeList(getTransactionTypeList());
			dest.setMerchantTypeList(getMerchantTypeList());
			dest.setTransportTaskStatusList(getTransportTaskStatusList());
			dest.setLocationList(getLocationList());
			dest.setMerchantList(getMerchantList());
			dest.setTransportProjectList(getTransportProjectList());
			dest.setTransportItemList(getTransportItemList());
			dest.setTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tintroduction='"+getIntroduction()+"';");
		stringBuilder.append("\tcurrentVersion='"+getCurrentVersion()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

