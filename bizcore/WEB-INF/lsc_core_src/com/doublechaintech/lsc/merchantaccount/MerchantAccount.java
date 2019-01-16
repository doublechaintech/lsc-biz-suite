
package com.doublechaintech.lsc.merchantaccount;

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
import com.doublechaintech.lsc.transaction.Transaction;

@JsonSerialize(using = MerchantAccountSerializer.class)
public class MerchantAccount extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MERCHANT_PROPERTY              = "merchant"          ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSACTION_LIST                         = "transactionList"   ;

	public static final String INTERNAL_TYPE="MerchantAccount";
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
	protected		DateTime            	mCreateTime         ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Transaction>	mTransactionList    ;
	
		
	public 	MerchantAccount(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setMerchant( null );

		this.changed = true;
	}
	
	public 	MerchantAccount(String name, Merchant merchant, DateTime createTime, DateTime updateTime)
	{
		setName(name);
		setMerchant(merchant);
		setCreateTime(createTime);
		setUpdateTime(updateTime);

		this.mTransactionList = new SmartList<Transaction>();	
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
	public MerchantAccount updateId(String id){
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
	public MerchantAccount updateName(String name){
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
	public MerchantAccount updateMerchant(Merchant merchant){
		this.mMerchant = merchant;;
		this.changed = true;
		return this;
	}
	
	
	public void clearMerchant(){
		setMerchant ( null );
		this.changed = true;
	}
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public MerchantAccount updateCreateTime(DateTime createTime){
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
	public MerchantAccount updateUpdateTime(DateTime updateTime){
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
	public MerchantAccount updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<Transaction> getTransactionList(){
		if(this.mTransactionList == null){
			this.mTransactionList = new SmartList<Transaction>();
			this.mTransactionList.setListInternalName (TRANSACTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransactionList;	
	}
	public  void setTransactionList(SmartList<Transaction> transactionList){
		for( Transaction transaction:transactionList){
			transaction.setAccount(this);
		}

		this.mTransactionList = transactionList;
		this.mTransactionList.setListInternalName (TRANSACTION_LIST );
		
	}
	
	public  void addTransaction(Transaction transaction){
		transaction.setAccount(this);
		getTransactionList().add(transaction);
	}
	public  void addTransactionList(SmartList<Transaction> transactionList){
		for( Transaction transaction:transactionList){
			transaction.setAccount(this);
		}
		getTransactionList().addAll(transactionList);
	}
	
	public  Transaction removeTransaction(Transaction transactionIndex){
		
		int index = getTransactionList().indexOf(transactionIndex);
        if(index < 0){
        	String message = "Transaction("+transactionIndex.getId()+") with version='"+transactionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Transaction transaction = getTransactionList().get(index);        
        // transaction.clearAccount(); //disconnect with Account
        transaction.clearFromAll(); //disconnect with Account
		
		boolean result = getTransactionList().planToRemove(transaction);
        if(!result){
        	String message = "Transaction("+transactionIndex.getId()+") with version='"+transactionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transaction;
        
	
	}
	//断舍离
	public  void breakWithTransaction(Transaction transaction){
		
		if(transaction == null){
			return;
		}
		transaction.setAccount(null);
		//getTransactionList().remove();
	
	}
	
	public  boolean hasTransaction(Transaction transaction){
	
		return getTransactionList().contains(transaction);
  
	}
	
	public void copyTransactionFrom(Transaction transaction) {

		Transaction transactionInList = findTheTransaction(transaction);
		Transaction newTransaction = new Transaction();
		transactionInList.copyTo(newTransaction);
		newTransaction.setVersion(0);//will trigger copy
		getTransactionList().add(newTransaction);
		addItemToFlexiableObject(COPIED_CHILD, newTransaction);
	}
	
	public  Transaction findTheTransaction(Transaction transaction){
		
		int index =  getTransactionList().indexOf(transaction);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Transaction("+transaction.getId()+") with version='"+transaction.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransactionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransactionList(){
		getTransactionList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getMerchant(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransactionList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransactionList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MERCHANT_PROPERTY, getMerchant());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TRANSACTION_LIST, getTransactionList());
		if(!getTransactionList().isEmpty()){
			appendKeyValuePair(result, "transactionCount", getTransactionList().getTotalCount());
			appendKeyValuePair(result, "transactionCurrentPageNumber", getTransactionList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof MerchantAccount){
		
		
			MerchantAccount dest =(MerchantAccount)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMerchant(getMerchant());
			dest.setCreateTime(getCreateTime());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());
			dest.setTransactionList(getTransactionList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("MerchantAccount{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getMerchant() != null ){
 			stringBuilder.append("\tmerchant='Merchant("+getMerchant().getId()+")';");
 		}
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tupdateTime='"+getUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

