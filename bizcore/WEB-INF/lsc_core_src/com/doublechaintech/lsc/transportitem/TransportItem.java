
package com.doublechaintech.lsc.transportitem;

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
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;

@JsonSerialize(using = TransportItemSerializer.class)
public class TransportItem extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String UNIT_PROPERTY                  = "unit"              ;
	public static final String PROJECT_PROPERTY               = "project"           ;
	public static final String MERCHANT_PROPERTY              = "merchant"          ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="TransportItem";
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
	protected		int                 	mQuantity           ;
	protected		String              	mUnit               ;
	protected		TransportProject    	mProject            ;
	protected		MerchantType        	mMerchant           ;
	protected		Platform            	mPlatform           ;
	protected		DateTime            	mCreateTime         ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	TransportItem(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProject( null );
		setMerchant( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	TransportItem(String name, int quantity, String unit, TransportProject project, MerchantType merchant, Platform platform, DateTime createTime, DateTime updateTime)
	{
		setName(name);
		setQuantity(quantity);
		setUnit(unit);
		setProject(project);
		setMerchant(merchant);
		setPlatform(platform);
		setCreateTime(createTime);
		setUpdateTime(updateTime);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(QUANTITY_PROPERTY.equals(property)){
			changeQuantityProperty(newValueExpr);
		}
		if(UNIT_PROPERTY.equals(property)){
			changeUnitProperty(newValueExpr);
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
			
			
			
	protected void changeQuantityProperty(String newValueExpr){
		int oldValue = getQuantity();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateQuantity(newValue);
		this.onChangeProperty(QUANTITY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeUnitProperty(String newValueExpr){
		String oldValue = getUnit();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUnit(newValue);
		this.onChangeProperty(UNIT_PROPERTY, oldValue, newValue);
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
	public TransportItem updateId(String id){
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
	public TransportItem updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setQuantity(int quantity){
		this.mQuantity = quantity;;
	}
	public int getQuantity(){
		return this.mQuantity;
	}
	public TransportItem updateQuantity(int quantity){
		this.mQuantity = quantity;;
		this.changed = true;
		return this;
	}
	
	
	public void setUnit(String unit){
		this.mUnit = trimString(unit);;
	}
	public String getUnit(){
		return this.mUnit;
	}
	public TransportItem updateUnit(String unit){
		this.mUnit = trimString(unit);;
		this.changed = true;
		return this;
	}
	
	
	public void setProject(TransportProject project){
		this.mProject = project;;
	}
	public TransportProject getProject(){
		return this.mProject;
	}
	public TransportItem updateProject(TransportProject project){
		this.mProject = project;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProject(){
		setProject ( null );
		this.changed = true;
	}
	
	public void setMerchant(MerchantType merchant){
		this.mMerchant = merchant;;
	}
	public MerchantType getMerchant(){
		return this.mMerchant;
	}
	public TransportItem updateMerchant(MerchantType merchant){
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
	public TransportItem updatePlatform(Platform platform){
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
	public TransportItem updateCreateTime(DateTime createTime){
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
	public TransportItem updateUpdateTime(DateTime updateTime){
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
	public TransportItem updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProject(), internalType);
		addToEntityList(this, entityList, getMerchant(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, QUANTITY_PROPERTY, getQuantity());
		appendKeyValuePair(result, UNIT_PROPERTY, getUnit());
		appendKeyValuePair(result, PROJECT_PROPERTY, getProject());
		appendKeyValuePair(result, MERCHANT_PROPERTY, getMerchant());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportItem){
		
		
			TransportItem dest =(TransportItem)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setQuantity(getQuantity());
			dest.setUnit(getUnit());
			dest.setProject(getProject());
			dest.setMerchant(getMerchant());
			dest.setPlatform(getPlatform());
			dest.setCreateTime(getCreateTime());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TransportItem{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tunit='"+getUnit()+"';");
		if(getProject() != null ){
 			stringBuilder.append("\tproject='TransportProject("+getProject().getId()+")';");
 		}
		if(getMerchant() != null ){
 			stringBuilder.append("\tmerchant='MerchantType("+getMerchant().getId()+")';");
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
	
	public void increaseQuantity(int incQuantity){
		updateQuantity(this.mQuantity +  incQuantity);
	}
	public void decreaseQuantity(int decQuantity){
		updateQuantity(this.mQuantity - decQuantity);
	}
	

}

