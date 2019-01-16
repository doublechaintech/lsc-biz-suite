
package com.doublechaintech.lsc.merchanttype;

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
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.platform.Platform;

@JsonSerialize(using = MerchantTypeSerializer.class)
public class MerchantType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String MERCHANT_LIST                            = "merchantList"      ;
	public static final String TRANSPORT_ITEM_LIST                      = "transportItemList" ;

	public static final String INTERNAL_TYPE="MerchantType";
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
	
	
	protected		SmartList<Merchant> 	mMerchantList       ;
	protected		SmartList<TransportItem>	mTransportItemList  ;
	
		
	public 	MerchantType(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	MerchantType(String name, Platform platform)
	{
		setName(name);
		setPlatform(platform);

		this.mMerchantList = new SmartList<Merchant>();
		this.mTransportItemList = new SmartList<TransportItem>();	
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
	public MerchantType updateId(String id){
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
	public MerchantType updateName(String name){
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
	public MerchantType updatePlatform(Platform platform){
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
	public MerchantType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
			merchant.setType(this);
		}

		this.mMerchantList = merchantList;
		this.mMerchantList.setListInternalName (MERCHANT_LIST );
		
	}
	
	public  void addMerchant(Merchant merchant){
		merchant.setType(this);
		getMerchantList().add(merchant);
	}
	public  void addMerchantList(SmartList<Merchant> merchantList){
		for( Merchant merchant:merchantList){
			merchant.setType(this);
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
        // merchant.clearType(); //disconnect with Type
        merchant.clearFromAll(); //disconnect with Type
		
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
		merchant.setType(null);
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
			transportItem.setMerchant(this);
		}

		this.mTransportItemList = transportItemList;
		this.mTransportItemList.setListInternalName (TRANSPORT_ITEM_LIST );
		
	}
	
	public  void addTransportItem(TransportItem transportItem){
		transportItem.setMerchant(this);
		getTransportItemList().add(transportItem);
	}
	public  void addTransportItemList(SmartList<TransportItem> transportItemList){
		for( TransportItem transportItem:transportItemList){
			transportItem.setMerchant(this);
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
        // transportItem.clearMerchant(); //disconnect with Merchant
        transportItem.clearFromAll(); //disconnect with Merchant
		
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
		transportItem.setMerchant(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getMerchantList(), internalType);
		collectFromList(this, entityList, getTransportItemList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getMerchantList());
		listOfList.add( getTransportItemList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, MERCHANT_LIST, getMerchantList());
		if(!getMerchantList().isEmpty()){
			appendKeyValuePair(result, "merchantCount", getMerchantList().getTotalCount());
			appendKeyValuePair(result, "merchantCurrentPageNumber", getMerchantList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_ITEM_LIST, getTransportItemList());
		if(!getTransportItemList().isEmpty()){
			appendKeyValuePair(result, "transportItemCount", getTransportItemList().getTotalCount());
			appendKeyValuePair(result, "transportItemCurrentPageNumber", getTransportItemList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof MerchantType){
		
		
			MerchantType dest =(MerchantType)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setMerchantList(getMerchantList());
			dest.setTransportItemList(getTransportItemList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("MerchantType{");
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

