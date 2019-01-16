
package com.doublechaintech.lsc.transportitem;
import com.doublechaintech.lsc.CommonTokens;
import java.util.Map;
public class TransportItemTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transportItem";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected TransportItemTokens(){
		//ensure not initialized outside the class
	}
	
	public TransportItemTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransportItemTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransportItemTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransportItemTokens start(){
		return new TransportItemTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransportItemTokens allTokens(){
		
		return start()
			.withProject()
			.withMerchant()
			.withPlatform();
	
	}
	public static TransportItemTokens withoutListsTokens(){
		
		return start()
			.withProject()
			.withMerchant()
			.withPlatform();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String PROJECT = "project";
	public String getProject(){
		return PROJECT;
	}
	public TransportItemTokens withProject(){		
		addSimpleOptions(PROJECT);
		return this;
	}
	
	
	protected static final String MERCHANT = "merchant";
	public String getMerchant(){
		return MERCHANT;
	}
	public TransportItemTokens withMerchant(){		
		addSimpleOptions(MERCHANT);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public TransportItemTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	
	public  TransportItemTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

