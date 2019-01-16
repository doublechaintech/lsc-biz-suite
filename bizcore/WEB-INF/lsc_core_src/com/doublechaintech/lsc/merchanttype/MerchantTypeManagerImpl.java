
package com.doublechaintech.lsc.merchanttype;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.lsc.BaseEntity;


import com.doublechaintech.lsc.Message;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;

import com.doublechaintech.lsc.LscUserContext;
//import com.doublechaintech.lsc.BaseManagerImpl;
import com.doublechaintech.lsc.LscCheckerManager;
import com.doublechaintech.lsc.CustomLscCheckerManager;

import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.platform.Platform;

import com.doublechaintech.lsc.platform.CandidatePlatform;

import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.merchanttype.MerchantType;






public class MerchantTypeManagerImpl extends CustomLscCheckerManager implements MerchantTypeManager {
	
	private static final String SERVICE_TYPE = "MerchantType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws MerchantTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new MerchantTypeManagerException(message);

	}
	
	

 	protected MerchantType saveMerchantType(LscUserContext userContext, MerchantType merchantType, String [] tokensExpr) throws Exception{	
 		//return getMerchantTypeDAO().save(merchantType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMerchantType(userContext, merchantType, tokens);
 	}
 	
 	protected MerchantType saveMerchantTypeDetail(LscUserContext userContext, MerchantType merchantType) throws Exception{	

 		
 		return saveMerchantType(userContext, merchantType, allTokens());
 	}
 	
 	public MerchantType loadMerchantType(LscUserContext userContext, String merchantTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MerchantType merchantType = loadMerchantType( userContext, merchantTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,merchantType, tokens);
 	}
 	
 	
 	 public MerchantType searchMerchantType(LscUserContext userContext, String merchantTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		MerchantType merchantType = loadMerchantType( userContext, merchantTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,merchantType, tokens);
 	}
 	
 	

 	protected MerchantType present(LscUserContext userContext, MerchantType merchantType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,merchantType,tokens);
		
		
		MerchantType  merchantTypeToPresent = userContext.getDAOGroup().getMerchantTypeDAO().present(merchantType, tokens);
		
		List<BaseEntity> entityListToNaming = merchantTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getMerchantTypeDAO().alias(entityListToNaming);
		
		return  merchantTypeToPresent;
		
		
	}
 
 	
 	
 	public MerchantType loadMerchantTypeDetail(LscUserContext userContext, String merchantTypeId) throws Exception{	
 		MerchantType merchantType = loadMerchantType( userContext, merchantTypeId, allTokens());
 		return present(userContext,merchantType, allTokens());
		
 	}
 	
 	public Object view(LscUserContext userContext, String merchantTypeId) throws Exception{	
 		MerchantType merchantType = loadMerchantType( userContext, merchantTypeId, viewTokens());
 		return present(userContext,merchantType, allTokens());
		
 	}
 	protected MerchantType saveMerchantType(LscUserContext userContext, MerchantType merchantType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getMerchantTypeDAO().save(merchantType, tokens);
 	}
 	protected MerchantType loadMerchantType(LscUserContext userContext, String merchantTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( MerchantTypeManagerException.class);

 
 		return userContext.getDAOGroup().getMerchantTypeDAO().load(merchantTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(LscUserContext userContext, MerchantType merchantType, Map<String, Object> tokens){
		super.addActions(userContext, merchantType, tokens);
		
		addAction(userContext, merchantType, tokens,"@create","createMerchantType","createMerchantType/","main","primary");
		addAction(userContext, merchantType, tokens,"@update","updateMerchantType","updateMerchantType/"+merchantType.getId()+"/","main","primary");
		addAction(userContext, merchantType, tokens,"@copy","cloneMerchantType","cloneMerchantType/"+merchantType.getId()+"/","main","primary");
		
		addAction(userContext, merchantType, tokens,"merchant_type.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+merchantType.getId()+"/","main","primary");
		addAction(userContext, merchantType, tokens,"merchant_type.addMerchant","addMerchant","addMerchant/"+merchantType.getId()+"/","merchantList","primary");
		addAction(userContext, merchantType, tokens,"merchant_type.removeMerchant","removeMerchant","removeMerchant/"+merchantType.getId()+"/","merchantList","primary");
		addAction(userContext, merchantType, tokens,"merchant_type.updateMerchant","updateMerchant","updateMerchant/"+merchantType.getId()+"/","merchantList","primary");
		addAction(userContext, merchantType, tokens,"merchant_type.copyMerchantFrom","copyMerchantFrom","copyMerchantFrom/"+merchantType.getId()+"/","merchantList","primary");
		addAction(userContext, merchantType, tokens,"merchant_type.addTransportItem","addTransportItem","addTransportItem/"+merchantType.getId()+"/","transportItemList","primary");
		addAction(userContext, merchantType, tokens,"merchant_type.removeTransportItem","removeTransportItem","removeTransportItem/"+merchantType.getId()+"/","transportItemList","primary");
		addAction(userContext, merchantType, tokens,"merchant_type.updateTransportItem","updateTransportItem","updateTransportItem/"+merchantType.getId()+"/","transportItemList","primary");
		addAction(userContext, merchantType, tokens,"merchant_type.copyTransportItemFrom","copyTransportItemFrom","copyTransportItemFrom/"+merchantType.getId()+"/","transportItemList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(LscUserContext userContext, MerchantType merchantType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MerchantType createMerchantType(LscUserContext userContext,String name, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfMerchantType(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);


		MerchantType merchantType=createNewMerchantType();	

		merchantType.setName(name);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		merchantType.setPlatform(platform);
		
		

		merchantType = saveMerchantType(userContext, merchantType, emptyOptions());
		
		onNewInstanceCreated(userContext, merchantType);
		return merchantType;

		
	}
	protected MerchantType createNewMerchantType() 
	{
		
		return new MerchantType();		
	}
	
	protected void checkParamsForUpdatingMerchantType(LscUserContext userContext,String merchantTypeId, int merchantTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().checkVersionOfMerchantType( merchantTypeVersion);
		

		if(MerchantType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMerchantType(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
	
		
	}
	
	
	
	public MerchantType clone(LscUserContext userContext, String fromMerchantTypeId) throws Exception{
		
		return userContext.getDAOGroup().getMerchantTypeDAO().clone(fromMerchantTypeId, this.allTokens());
	}
	
	public MerchantType internalSaveMerchantType(LscUserContext userContext, MerchantType merchantType) throws Exception 
	{
		return internalSaveMerchantType(userContext, merchantType, allTokens());

	}
	public MerchantType internalSaveMerchantType(LscUserContext userContext, MerchantType merchantType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingMerchantType(userContext, merchantTypeId, merchantTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(merchantType){ 
			//will be good when the merchantType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MerchantType.
			
			
			merchantType = saveMerchantType(userContext, merchantType, options);
			return merchantType;
			
		}

	}
	
	public MerchantType updateMerchantType(LscUserContext userContext,String merchantTypeId, int merchantTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMerchantType(userContext, merchantTypeId, merchantTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
		if(merchantType.getVersion() != merchantTypeVersion){
			String message = "The target version("+merchantType.getVersion()+") is not equals to version("+merchantTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(merchantType){ 
			//will be good when the merchantType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MerchantType.
			
			merchantType.changeProperty(property, newValueExpr);
			merchantType = saveMerchantType(userContext, merchantType, tokens().done());
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
			//return saveMerchantType(userContext, merchantType, tokens().done());
		}

	}
	
	public MerchantType updateMerchantTypeProperty(LscUserContext userContext,String merchantTypeId, int merchantTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMerchantType(userContext, merchantTypeId, merchantTypeVersion, property, newValueExpr, tokensExpr);
		
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
		if(merchantType.getVersion() != merchantTypeVersion){
			String message = "The target version("+merchantType.getVersion()+") is not equals to version("+merchantTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(merchantType){ 
			//will be good when the merchantType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MerchantType.
			
			merchantType.changeProperty(property, newValueExpr);
			
			merchantType = saveMerchantType(userContext, merchantType, tokens().done());
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
			//return saveMerchantType(userContext, merchantType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MerchantTypeTokens tokens(){
		return MerchantTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MerchantTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortMerchantListWith("id","desc")
		.sortTransportItemListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MerchantTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(LscUserContext userContext, String merchantTypeId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
 		
 	}
 	public MerchantType transferToAnotherPlatform(LscUserContext userContext, String merchantTypeId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, merchantTypeId,anotherPlatformId);
 
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());	
		synchronized(merchantType){
			//will be good when the merchantType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			merchantType.updatePlatform(platform);		
			merchantType = saveMerchantType(userContext, merchantType, emptyOptions());
			
			return present(userContext,merchantType, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForMerchantType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(LscUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(LscUserContext userContext, String merchantTypeId, int merchantTypeVersion) throws Exception {
		//deleteInternal(userContext, merchantTypeId, merchantTypeVersion);		
	}
	protected void deleteInternal(LscUserContext userContext,
			String merchantTypeId, int merchantTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getMerchantTypeDAO().delete(merchantTypeId, merchantTypeVersion);
	}
	
	public MerchantType forgetByAll(LscUserContext userContext, String merchantTypeId, int merchantTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, merchantTypeId, merchantTypeVersion);		
	}
	protected MerchantType forgetByAllInternal(LscUserContext userContext,
			String merchantTypeId, int merchantTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getMerchantTypeDAO().disconnectFromAll(merchantTypeId, merchantTypeVersion);
	}
	

	
	public int deleteAll(LscUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MerchantTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(LscUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getMerchantTypeDAO().deleteAll();
	}


	//disconnect MerchantType with platform in Merchant
	protected MerchantType breakWithMerchantByPlatform(LscUserContext userContext, String merchantTypeId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());

			synchronized(merchantType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantTypeDAO().planToRemoveMerchantListWithPlatform(merchantType, platformId, this.emptyOptions());

				merchantType = saveMerchantType(userContext, merchantType, tokens().withMerchantList().done());
				return merchantType;
			}
	}
	//disconnect MerchantType with project in TransportItem
	protected MerchantType breakWithTransportItemByProject(LscUserContext userContext, String merchantTypeId, String projectId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());

			synchronized(merchantType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantTypeDAO().planToRemoveTransportItemListWithProject(merchantType, projectId, this.emptyOptions());

				merchantType = saveMerchantType(userContext, merchantType, tokens().withTransportItemList().done());
				return merchantType;
			}
	}
	//disconnect MerchantType with platform in TransportItem
	protected MerchantType breakWithTransportItemByPlatform(LscUserContext userContext, String merchantTypeId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());

			synchronized(merchantType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getMerchantTypeDAO().planToRemoveTransportItemListWithPlatform(merchantType, platformId, this.emptyOptions());

				merchantType = saveMerchantType(userContext, merchantType, tokens().withTransportItemList().done());
				return merchantType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingMerchant(LscUserContext userContext, String merchantTypeId, String name, String platformId, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);

		
		userContext.getChecker().checkNameOfMerchant(name);
		
		userContext.getChecker().checkPlatformIdOfMerchant(platformId);
		
		userContext.getChecker().checkDescriptionOfMerchant(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);

	
	}
	public  MerchantType addMerchant(LscUserContext userContext, String merchantTypeId, String name, String platformId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMerchant(userContext,merchantTypeId,name, platformId, description,tokensExpr);
		
		Merchant merchant = createMerchant(userContext,name, platformId, description);
		
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
		synchronized(merchantType){ 
			//Will be good when the merchantType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchantType.addMerchant( merchant );		
			merchantType = saveMerchantType(userContext, merchantType, tokens().withMerchantList().done());
			
			userContext.getManagerGroup().getMerchantManager().onNewInstanceCreated(userContext, merchant);
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMerchantProperties(LscUserContext userContext, String merchantTypeId,String id,String name,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().checkIdOfMerchant(id);
		
		userContext.getChecker().checkNameOfMerchant( name);
		userContext.getChecker().checkDescriptionOfMerchant( description);

		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
		
	}
	public  MerchantType updateMerchantProperties(LscUserContext userContext, String merchantTypeId, String id,String name,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingMerchantProperties(userContext,merchantTypeId,id,name,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMerchantListList()
				.searchMerchantListWith(Merchant.ID_PROPERTY, "is", id).done();
		
		MerchantType merchantTypeToUpdate = loadMerchantType(userContext, merchantTypeId, options);
		
		if(merchantTypeToUpdate.getMerchantList().isEmpty()){
			throw new MerchantTypeManagerException("Merchant is NOT FOUND with id: '"+id+"'");
		}
		
		Merchant item = merchantTypeToUpdate.getMerchantList().first();
		
		item.updateName( name );
		item.updateDescription( description );

		
		//checkParamsForAddingMerchant(userContext,merchantTypeId,name, code, used,tokensExpr);
		MerchantType merchantType = saveMerchantType(userContext, merchantTypeToUpdate, tokens().withMerchantList().done());
		synchronized(merchantType){ 
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Merchant createMerchant(LscUserContext userContext, String name, String platformId, String description) throws Exception{

		Merchant merchant = new Merchant();
		
		
		merchant.setName(name);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		merchant.setPlatform(platform);		
		merchant.setDescription(description);		
		merchant.setCreateTime(userContext.now());		
		merchant.setUpdateTime(userContext.now());
	
		
		return merchant;
	
		
	}
	
	protected Merchant createIndexedMerchant(String id, int version){

		Merchant merchant = new Merchant();
		merchant.setId(id);
		merchant.setVersion(version);
		return merchant;			
		
	}
	
	protected void checkParamsForRemovingMerchantList(LscUserContext userContext, String merchantTypeId, 
			String merchantIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		for(String merchantId: merchantIds){
			userContext.getChecker().checkIdOfMerchant(merchantId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
		
	}
	public  MerchantType removeMerchantList(LscUserContext userContext, String merchantTypeId, 
			String merchantIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingMerchantList(userContext, merchantTypeId,  merchantIds, tokensExpr);
			
			
			MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
			synchronized(merchantType){ 
				//Will be good when the merchantType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getMerchantTypeDAO().planToRemoveMerchantList(merchantType, merchantIds, allTokens());
				merchantType = saveMerchantType(userContext, merchantType, tokens().withMerchantList().done());
				deleteRelationListInGraph(userContext, merchantType.getMerchantList());
				return present(userContext,merchantType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingMerchant(LscUserContext userContext, String merchantTypeId, 
		String merchantId, int merchantVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchantType( merchantTypeId);
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkVersionOfMerchant(merchantVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
	
	}
	public  MerchantType removeMerchant(LscUserContext userContext, String merchantTypeId, 
		String merchantId, int merchantVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMerchant(userContext,merchantTypeId, merchantId, merchantVersion,tokensExpr);
		
		Merchant merchant = createIndexedMerchant(merchantId, merchantVersion);
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
		synchronized(merchantType){ 
			//Will be good when the merchantType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchantType.removeMerchant( merchant );		
			merchantType = saveMerchantType(userContext, merchantType, tokens().withMerchantList().done());
			deleteRelationInGraph(userContext, merchant);
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingMerchant(LscUserContext userContext, String merchantTypeId, 
		String merchantId, int merchantVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchantType( merchantTypeId);
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkVersionOfMerchant(merchantVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
	
	}
	public  MerchantType copyMerchantFrom(LscUserContext userContext, String merchantTypeId, 
		String merchantId, int merchantVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMerchant(userContext,merchantTypeId, merchantId, merchantVersion,tokensExpr);
		
		Merchant merchant = createIndexedMerchant(merchantId, merchantVersion);
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
		synchronized(merchantType){ 
			//Will be good when the merchantType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			merchant.updateUpdateTime(userContext.now());
			
			merchantType.copyMerchantFrom( merchant );		
			merchantType = saveMerchantType(userContext, merchantType, tokens().withMerchantList().done());
			
			userContext.getManagerGroup().getMerchantManager().onNewInstanceCreated(userContext, (Merchant)merchantType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingMerchant(LscUserContext userContext, String merchantTypeId, String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().checkIdOfMerchant(merchantId);
		userContext.getChecker().checkVersionOfMerchant(merchantVersion);
		

		if(Merchant.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMerchant(parseString(newValueExpr));
		}
		
		if(Merchant.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfMerchant(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
	
	}
	
	public  MerchantType updateMerchant(LscUserContext userContext, String merchantTypeId, String merchantId, int merchantVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMerchant(userContext, merchantTypeId, merchantId, merchantVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withMerchantList().searchMerchantListWith(Merchant.ID_PROPERTY, "eq", merchantId).done();
		
		
		
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, loadTokens);
		
		synchronized(merchantType){ 
			//Will be good when the merchantType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//merchantType.removeMerchant( merchant );	
			//make changes to AcceleraterAccount.
			Merchant merchantIndex = createIndexedMerchant(merchantId, merchantVersion);
		
			Merchant merchant = merchantType.findTheMerchant(merchantIndex);
			if(merchant == null){
				throw new MerchantTypeManagerException(merchant+" is NOT FOUND" );
			}
			
			merchant.changeProperty(property, newValueExpr);
			merchant.updateUpdateTime(userContext.now());
			merchantType = saveMerchantType(userContext, merchantType, tokens().withMerchantList().done());
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportItem(LscUserContext userContext, String merchantTypeId, String name, int quantity, String unit, String projectId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);

		
		userContext.getChecker().checkNameOfTransportItem(name);
		
		userContext.getChecker().checkQuantityOfTransportItem(quantity);
		
		userContext.getChecker().checkUnitOfTransportItem(unit);
		
		userContext.getChecker().checkProjectIdOfTransportItem(projectId);
		
		userContext.getChecker().checkPlatformIdOfTransportItem(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);

	
	}
	public  MerchantType addTransportItem(LscUserContext userContext, String merchantTypeId, String name, int quantity, String unit, String projectId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportItem(userContext,merchantTypeId,name, quantity, unit, projectId, platformId,tokensExpr);
		
		TransportItem transportItem = createTransportItem(userContext,name, quantity, unit, projectId, platformId);
		
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
		synchronized(merchantType){ 
			//Will be good when the merchantType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchantType.addTransportItem( transportItem );		
			merchantType = saveMerchantType(userContext, merchantType, tokens().withTransportItemList().done());
			
			userContext.getManagerGroup().getTransportItemManager().onNewInstanceCreated(userContext, transportItem);
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportItemProperties(LscUserContext userContext, String merchantTypeId,String id,String name,int quantity,String unit,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().checkIdOfTransportItem(id);
		
		userContext.getChecker().checkNameOfTransportItem( name);
		userContext.getChecker().checkQuantityOfTransportItem( quantity);
		userContext.getChecker().checkUnitOfTransportItem( unit);

		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
		
	}
	public  MerchantType updateTransportItemProperties(LscUserContext userContext, String merchantTypeId, String id,String name,int quantity,String unit, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportItemProperties(userContext,merchantTypeId,id,name,quantity,unit,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportItemListList()
				.searchTransportItemListWith(TransportItem.ID_PROPERTY, "is", id).done();
		
		MerchantType merchantTypeToUpdate = loadMerchantType(userContext, merchantTypeId, options);
		
		if(merchantTypeToUpdate.getTransportItemList().isEmpty()){
			throw new MerchantTypeManagerException("TransportItem is NOT FOUND with id: '"+id+"'");
		}
		
		TransportItem item = merchantTypeToUpdate.getTransportItemList().first();
		
		item.updateName( name );
		item.updateQuantity( quantity );
		item.updateUnit( unit );

		
		//checkParamsForAddingTransportItem(userContext,merchantTypeId,name, code, used,tokensExpr);
		MerchantType merchantType = saveMerchantType(userContext, merchantTypeToUpdate, tokens().withTransportItemList().done());
		synchronized(merchantType){ 
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportItem createTransportItem(LscUserContext userContext, String name, int quantity, String unit, String projectId, String platformId) throws Exception{

		TransportItem transportItem = new TransportItem();
		
		
		transportItem.setName(name);		
		transportItem.setQuantity(quantity);		
		transportItem.setUnit(unit);		
		TransportProject  project = new TransportProject();
		project.setId(projectId);		
		transportItem.setProject(project);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		transportItem.setPlatform(platform);		
		transportItem.setCreateTime(userContext.now());		
		transportItem.setUpdateTime(userContext.now());
	
		
		return transportItem;
	
		
	}
	
	protected TransportItem createIndexedTransportItem(String id, int version){

		TransportItem transportItem = new TransportItem();
		transportItem.setId(id);
		transportItem.setVersion(version);
		return transportItem;			
		
	}
	
	protected void checkParamsForRemovingTransportItemList(LscUserContext userContext, String merchantTypeId, 
			String transportItemIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		for(String transportItemId: transportItemIds){
			userContext.getChecker().checkIdOfTransportItem(transportItemId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
		
	}
	public  MerchantType removeTransportItemList(LscUserContext userContext, String merchantTypeId, 
			String transportItemIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportItemList(userContext, merchantTypeId,  transportItemIds, tokensExpr);
			
			
			MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
			synchronized(merchantType){ 
				//Will be good when the merchantType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getMerchantTypeDAO().planToRemoveTransportItemList(merchantType, transportItemIds, allTokens());
				merchantType = saveMerchantType(userContext, merchantType, tokens().withTransportItemList().done());
				deleteRelationListInGraph(userContext, merchantType.getTransportItemList());
				return present(userContext,merchantType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportItem(LscUserContext userContext, String merchantTypeId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchantType( merchantTypeId);
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem(transportItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
	
	}
	public  MerchantType removeTransportItem(LscUserContext userContext, String merchantTypeId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportItem(userContext,merchantTypeId, transportItemId, transportItemVersion,tokensExpr);
		
		TransportItem transportItem = createIndexedTransportItem(transportItemId, transportItemVersion);
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
		synchronized(merchantType){ 
			//Will be good when the merchantType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			merchantType.removeTransportItem( transportItem );		
			merchantType = saveMerchantType(userContext, merchantType, tokens().withTransportItemList().done());
			deleteRelationInGraph(userContext, transportItem);
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportItem(LscUserContext userContext, String merchantTypeId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMerchantType( merchantTypeId);
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem(transportItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
	
	}
	public  MerchantType copyTransportItemFrom(LscUserContext userContext, String merchantTypeId, 
		String transportItemId, int transportItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportItem(userContext,merchantTypeId, transportItemId, transportItemVersion,tokensExpr);
		
		TransportItem transportItem = createIndexedTransportItem(transportItemId, transportItemVersion);
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, allTokens());
		synchronized(merchantType){ 
			//Will be good when the merchantType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			transportItem.updateUpdateTime(userContext.now());
			
			merchantType.copyTransportItemFrom( transportItem );		
			merchantType = saveMerchantType(userContext, merchantType, tokens().withTransportItemList().done());
			
			userContext.getManagerGroup().getTransportItemManager().onNewInstanceCreated(userContext, (TransportItem)merchantType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportItem(LscUserContext userContext, String merchantTypeId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfMerchantType(merchantTypeId);
		userContext.getChecker().checkIdOfTransportItem(transportItemId);
		userContext.getChecker().checkVersionOfTransportItem(transportItemVersion);
		

		if(TransportItem.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportItem(parseString(newValueExpr));
		}
		
		if(TransportItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfTransportItem(parseInt(newValueExpr));
		}
		
		if(TransportItem.UNIT_PROPERTY.equals(property)){
			userContext.getChecker().checkUnitOfTransportItem(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(MerchantTypeManagerException.class);
	
	}
	
	public  MerchantType updateTransportItem(LscUserContext userContext, String merchantTypeId, String transportItemId, int transportItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportItem(userContext, merchantTypeId, transportItemId, transportItemVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportItemList().searchTransportItemListWith(TransportItem.ID_PROPERTY, "eq", transportItemId).done();
		
		
		
		MerchantType merchantType = loadMerchantType(userContext, merchantTypeId, loadTokens);
		
		synchronized(merchantType){ 
			//Will be good when the merchantType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//merchantType.removeTransportItem( transportItem );	
			//make changes to AcceleraterAccount.
			TransportItem transportItemIndex = createIndexedTransportItem(transportItemId, transportItemVersion);
		
			TransportItem transportItem = merchantType.findTheTransportItem(transportItemIndex);
			if(transportItem == null){
				throw new MerchantTypeManagerException(transportItem+" is NOT FOUND" );
			}
			
			transportItem.changeProperty(property, newValueExpr);
			transportItem.updateUpdateTime(userContext.now());
			merchantType = saveMerchantType(userContext, merchantType, tokens().withTransportItemList().done());
			return present(userContext,merchantType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(LscUserContext userContext, MerchantType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


