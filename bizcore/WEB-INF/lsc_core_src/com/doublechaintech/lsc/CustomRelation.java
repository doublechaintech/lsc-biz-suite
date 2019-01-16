
package com.doublechaintech.lsc;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("TransactionType"                       , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("MerchantType"                          , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("TransportTaskStatus"                   , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Location"                              , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Merchant"                              , BaseRelation.TRUST_CHAIN_ALL, "type");
		//replaceGenericRelation("Merchant"                              , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("TransportProject"                      , BaseRelation.TRUST_CHAIN_ALL, "merchant");
		//replaceGenericRelation("TransportProject"                      , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("TransportItem"                         , BaseRelation.TRUST_CHAIN_ALL, "project");
		//replaceGenericRelation("TransportItem"                         , BaseRelation.TRUST_CHAIN_ALL, "merchant");
		//replaceGenericRelation("TransportItem"                         , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "source");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "destination");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "status");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "sender");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "receiver");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("TransportTaskTrack"                    , BaseRelation.TRUST_CHAIN_ALL, "task");
		//replaceGenericRelation("MerchantAccount"                       , BaseRelation.TRUST_CHAIN_ALL, "merchant");
		//replaceGenericRelation("Transaction"                           , BaseRelation.TRUST_CHAIN_ALL, "transactionType");
		//replaceGenericRelation("Transaction"                           , BaseRelation.TRUST_CHAIN_ALL, "account");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] transactionTypeRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("TransactionType",transactionTypeRelatedObjectNames);

		//String [] merchantTypeRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("MerchantType",merchantTypeRelatedObjectNames);

		//String [] transportTaskStatusRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("TransportTaskStatus",transportTaskStatusRelatedObjectNames);

		//String [] locationRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Location",locationRelatedObjectNames);

		//String [] merchantRelatedObjectNames = {"type:MerchantType","platform:Platform"};
		//replaceRelationIndex("Merchant",merchantRelatedObjectNames);

		//String [] transportProjectRelatedObjectNames = {"merchant:Merchant","platform:Platform"};
		//replaceRelationIndex("TransportProject",transportProjectRelatedObjectNames);

		//String [] transportItemRelatedObjectNames = {"project:TransportProject","merchant:MerchantType","platform:Platform"};
		//replaceRelationIndex("TransportItem",transportItemRelatedObjectNames);

		//String [] transportTaskRelatedObjectNames = {"source:Location","destination:Location","status:TransportTaskStatus","sender:Merchant","receiver:Merchant","platform:Platform"};
		//replaceRelationIndex("TransportTask",transportTaskRelatedObjectNames);

		//String [] transportTaskTrackRelatedObjectNames = {"task:TransportTask"};
		//replaceRelationIndex("TransportTaskTrack",transportTaskTrackRelatedObjectNames);

		//String [] merchantAccountRelatedObjectNames = {"merchant:Merchant"};
		//replaceRelationIndex("MerchantAccount",merchantAccountRelatedObjectNames);

		//String [] transactionRelatedObjectNames = {"transaction_type:TransactionType","account:MerchantAccount"};
		//replaceRelationIndex("Transaction",transactionRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] formMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormMessage",formMessageRelatedObjectNames);

		//String [] formFieldMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormFieldMessage",formFieldMessageRelatedObjectNames);

		//String [] formFieldRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormField",formFieldRelatedObjectNames);

		//String [] formActionRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormAction",formActionRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}













