
package com.doublechaintech.lsc.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.transactiontype.TransactionType;

@JsonSerialize(using = TransactionSerializer.class)
public class Transaction extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String TRANSACTION_TYPE_PROPERTY      = "transactionType"   ;
	public static final String ACCOUNT_PROPERTY               = "account"           ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Transaction";
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
	protected		BigDecimal          	mAmount             ;
	protected		TransactionType     	mTransactionType    ;
	protected		MerchantAccount     	mAccount            ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Transaction(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setTransactionType( null );
		setAccount( null );

		this.changed = true;
	}
	
	public 	Transaction(String name, BigDecimal amount, TransactionType transactionType, MerchantAccount account)
	{
		setName(name);
		setAmount(amount);
		setTransactionType(transactionType);
		setAccount(account);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
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
			
			
			
	protected void changeAmountProperty(String newValueExpr){
		BigDecimal oldValue = getAmount();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAmount(newValue);
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Transaction updateId(String id){
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
	public Transaction updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setAmount(BigDecimal amount){
		this.mAmount = amount;;
	}
	public BigDecimal getAmount(){
		return this.mAmount;
	}
	public Transaction updateAmount(BigDecimal amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	
	
	public void setTransactionType(TransactionType transactionType){
		this.mTransactionType = transactionType;;
	}
	public TransactionType getTransactionType(){
		return this.mTransactionType;
	}
	public Transaction updateTransactionType(TransactionType transactionType){
		this.mTransactionType = transactionType;;
		this.changed = true;
		return this;
	}
	
	
	public void clearTransactionType(){
		setTransactionType ( null );
		this.changed = true;
	}
	
	public void setAccount(MerchantAccount account){
		this.mAccount = account;;
	}
	public MerchantAccount getAccount(){
		return this.mAccount;
	}
	public Transaction updateAccount(MerchantAccount account){
		this.mAccount = account;;
		this.changed = true;
		return this;
	}
	
	
	public void clearAccount(){
		setAccount ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Transaction updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getTransactionType(), internalType);
		addToEntityList(this, entityList, getAccount(), internalType);

		
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
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, TRANSACTION_TYPE_PROPERTY, getTransactionType());
		appendKeyValuePair(result, ACCOUNT_PROPERTY, getAccount());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Transaction){
		
		
			Transaction dest =(Transaction)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setAmount(getAmount());
			dest.setTransactionType(getTransactionType());
			dest.setAccount(getAccount());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Transaction{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		if(getTransactionType() != null ){
 			stringBuilder.append("\ttransactionType='TransactionType("+getTransactionType().getId()+")';");
 		}
		if(getAccount() != null ){
 			stringBuilder.append("\taccount='MerchantAccount("+getAccount().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

