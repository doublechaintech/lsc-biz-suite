package com.doublechaintech.lsc;
import java.text.MessageFormat;
import java.util.Date;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class LscCheckerManager extends BaseManagerImpl {
	/*
	
	
	public static final String  ID_OF_PLATFORM ="platform.id";
	protected void checkIdOfPlatform(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PLATFORM ="platform.name";
	protected void checkNameOfPlatform(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 32,NAME_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  INTRODUCTION_OF_PLATFORM ="platform.introduction";
	protected void checkIntroductionOfPlatform(LscUserContext userContext, String introduction, List<Message> messageList)
	{
		
	 	checkStringLengthRange(introduction,5, 72,INTRODUCTION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  CURRENT_VERSION_OF_PLATFORM ="platform.current_version";
	protected void checkCurrentVersionOfPlatform(LscUserContext userContext, String currentVersion, List<Message> messageList)
	{
		
	 	checkStringLengthRange(currentVersion,2, 16,CURRENT_VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PLATFORM ="platform.version";
	protected void checkVersionOfPlatform(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSACTION_TYPE ="transaction_type.id";
	protected void checkIdOfTransactionType(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSACTION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSACTION_TYPE ="transaction_type.name";
	protected void checkNameOfTransactionType(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_TRANSACTION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_TRANSACTION_TYPE ="transaction_type.platform";
	protected void checkPlatformIdOfTransactionType(LscUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfTransactionType(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSACTION_TYPE ="transaction_type.version";
	protected void checkVersionOfTransactionType(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSACTION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MERCHANT_TYPE ="merchant_type.id";
	protected void checkIdOfMerchantType(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MERCHANT_TYPE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MERCHANT_TYPE ="merchant_type.name";
	protected void checkNameOfMerchantType(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_MERCHANT_TYPE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_MERCHANT_TYPE ="merchant_type.platform";
	protected void checkPlatformIdOfMerchantType(LscUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfMerchantType(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MERCHANT_TYPE ="merchant_type.version";
	protected void checkVersionOfMerchantType(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MERCHANT_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_TASK_STATUS ="transport_task_status.id";
	protected void checkIdOfTransportTaskStatus(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK_STATUS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSPORT_TASK_STATUS ="transport_task_status.name";
	protected void checkNameOfTransportTaskStatus(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_TRANSPORT_TASK_STATUS, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_TRANSPORT_TASK_STATUS ="transport_task_status.platform";
	protected void checkPlatformIdOfTransportTaskStatus(LscUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTaskStatus(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_TASK_STATUS ="transport_task_status.version";
	protected void checkVersionOfTransportTaskStatus(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK_STATUS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOCATION ="location.id";
	protected void checkIdOfLocation(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOCATION, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LOCATION ="location.name";
	protected void checkNameOfLocation(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_LOCATION, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_PERSON_OF_LOCATION ="location.contact_person";
	protected void checkContactPersonOfLocation(LscUserContext userContext, String contactPerson, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactPerson,1, 12,CONTACT_PERSON_OF_LOCATION, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_PHONE_OF_LOCATION ="location.contact_phone";
	protected void checkContactPhoneOfLocation(LscUserContext userContext, String contactPhone, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(contactPhone,5, 44,CONTACT_PHONE_OF_LOCATION, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOCATION ="location.description";
	protected void checkDescriptionOfLocation(LscUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_LOCATION, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_LOCATION ="location.platform";
	protected void checkPlatformIdOfLocation(LscUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfLocation(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOCATION ="location.version";
	protected void checkVersionOfLocation(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOCATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MERCHANT ="merchant.id";
	protected void checkIdOfMerchant(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MERCHANT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MERCHANT ="merchant.name";
	protected void checkNameOfMerchant(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 32,NAME_OF_MERCHANT, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_MERCHANT ="merchant.type";
	protected void checkTypeIdOfMerchant(LscUserContext userContext, String typeId, List<Message> messageList)
	{
		
	 	checkIdOfMerchant(userContext,typeId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_MERCHANT ="merchant.platform";
	protected void checkPlatformIdOfMerchant(LscUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfMerchant(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_MERCHANT ="merchant.description";
	protected void checkDescriptionOfMerchant(LscUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_MERCHANT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MERCHANT ="merchant.version";
	protected void checkVersionOfMerchant(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MERCHANT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_PROJECT ="transport_project.id";
	protected void checkIdOfTransportProject(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_PROJECT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSPORT_PROJECT ="transport_project.name";
	protected void checkNameOfTransportProject(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 32,NAME_OF_TRANSPORT_PROJECT, messageList); 		
		
	}	 			
	
	public static final String  MERCHANT_OF_TRANSPORT_PROJECT ="transport_project.merchant";
	protected void checkMerchantIdOfTransportProject(LscUserContext userContext, String merchantId, List<Message> messageList)
	{
		
	 	checkIdOfTransportProject(userContext,merchantId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_TRANSPORT_PROJECT ="transport_project.platform";
	protected void checkPlatformIdOfTransportProject(LscUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfTransportProject(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_PROJECT ="transport_project.version";
	protected void checkVersionOfTransportProject(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_PROJECT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_ITEM ="transport_item.id";
	protected void checkIdOfTransportItem(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_ITEM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSPORT_ITEM ="transport_item.name";
	protected void checkNameOfTransportItem(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_TRANSPORT_ITEM, messageList); 		
		
	}	 			
	
	public static final String  QUANTITY_OF_TRANSPORT_ITEM ="transport_item.quantity";
	protected void checkQuantityOfTransportItem(LscUserContext userContext, int quantity, List<Message> messageList)
	{
		
	 	checkIntegerRange(quantity,0, 1000,QUANTITY_OF_TRANSPORT_ITEM, messageList); 		
		
	}	 			
	
	public static final String  UNIT_OF_TRANSPORT_ITEM ="transport_item.unit";
	protected void checkUnitOfTransportItem(LscUserContext userContext, String unit, List<Message> messageList)
	{
		
	 	checkStringLengthRange(unit,0, 8,UNIT_OF_TRANSPORT_ITEM, messageList); 		
		
	}	 			
	
	public static final String  PROJECT_OF_TRANSPORT_ITEM ="transport_item.project";
	protected void checkProjectIdOfTransportItem(LscUserContext userContext, String projectId, List<Message> messageList)
	{
		
	 	checkIdOfTransportItem(userContext,projectId, messageList); 		
		
	}	 			
	
	public static final String  MERCHANT_OF_TRANSPORT_ITEM ="transport_item.merchant";
	protected void checkMerchantIdOfTransportItem(LscUserContext userContext, String merchantId, List<Message> messageList)
	{
		
	 	checkIdOfTransportItem(userContext,merchantId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_TRANSPORT_ITEM ="transport_item.platform";
	protected void checkPlatformIdOfTransportItem(LscUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfTransportItem(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_ITEM ="transport_item.version";
	protected void checkVersionOfTransportItem(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_ITEM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_TASK ="transport_task.id";
	protected void checkIdOfTransportTask(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSPORT_TASK ="transport_task.name";
	protected void checkNameOfTransportTask(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  PROJECT_OF_TRANSPORT_TASK ="transport_task.project";
	protected void checkProjectIdOfTransportTask(LscUserContext userContext, String projectId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,projectId, messageList); 		
		
	}	 			
	
	public static final String  SOURCE_OF_TRANSPORT_TASK ="transport_task.source";
	protected void checkSourceIdOfTransportTask(LscUserContext userContext, String sourceId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,sourceId, messageList); 		
		
	}	 			
	
	public static final String  DESTINATION_OF_TRANSPORT_TASK ="transport_task.destination";
	protected void checkDestinationIdOfTransportTask(LscUserContext userContext, String destinationId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,destinationId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_TRANSPORT_TASK ="transport_task.remark";
	protected void checkRemarkOfTransportTask(LscUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,2, 20,REMARK_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  STATUS_OF_TRANSPORT_TASK ="transport_task.status";
	protected void checkStatusIdOfTransportTask(LscUserContext userContext, String statusId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,statusId, messageList); 		
		
	}	 			
	
	public static final String  SENDER_OF_TRANSPORT_TASK ="transport_task.sender";
	protected void checkSenderIdOfTransportTask(LscUserContext userContext, String senderId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,senderId, messageList); 		
		
	}	 			
	
	public static final String  RECEIVER_OF_TRANSPORT_TASK ="transport_task.receiver";
	protected void checkReceiverIdOfTransportTask(LscUserContext userContext, String receiverId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,receiverId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_TRANSPORT_TASK ="transport_task.platform";
	protected void checkPlatformIdOfTransportTask(LscUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_TASK ="transport_task.version";
	protected void checkVersionOfTransportTask(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_TASK_TRACK ="transport_task_track.id";
	protected void checkIdOfTransportTaskTrack(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSPORT_TASK_TRACK ="transport_task_track.name";
	protected void checkNameOfTransportTaskTrack(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.latitude";
	protected void checkLatitudeOfTransportTaskTrack(LscUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.longitude";
	protected void checkLongitudeOfTransportTaskTrack(LscUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  TASK_OF_TRANSPORT_TASK_TRACK ="transport_task_track.task";
	protected void checkTaskIdOfTransportTaskTrack(LscUserContext userContext, String taskId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTaskTrack(userContext,taskId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_TASK_TRACK ="transport_task_track.version";
	protected void checkVersionOfTransportTaskTrack(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MERCHANT_ACCOUNT ="merchant_account.id";
	protected void checkIdOfMerchantAccount(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MERCHANT_ACCOUNT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MERCHANT_ACCOUNT ="merchant_account.name";
	protected void checkNameOfMerchantAccount(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_MERCHANT_ACCOUNT, messageList); 		
		
	}	 			
	
	public static final String  MERCHANT_OF_MERCHANT_ACCOUNT ="merchant_account.merchant";
	protected void checkMerchantIdOfMerchantAccount(LscUserContext userContext, String merchantId, List<Message> messageList)
	{
		
	 	checkIdOfMerchantAccount(userContext,merchantId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MERCHANT_ACCOUNT ="merchant_account.version";
	protected void checkVersionOfMerchantAccount(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MERCHANT_ACCOUNT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSACTION ="transaction.id";
	protected void checkIdOfTransaction(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSACTION, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSACTION ="transaction.name";
	protected void checkNameOfTransaction(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_TRANSACTION, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_TRANSACTION ="transaction.amount";
	protected void checkAmountOfTransaction(LscUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 12312.12,AMOUNT_OF_TRANSACTION, messageList); 		
		
	}	 			
	
	public static final String  TRANSACTION_TYPE_OF_TRANSACTION ="transaction.transaction_type";
	protected void checkTransactionTypeIdOfTransaction(LscUserContext userContext, String transactionTypeId, List<Message> messageList)
	{
		
	 	checkIdOfTransaction(userContext,transactionTypeId, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNT_OF_TRANSACTION ="transaction.account";
	protected void checkAccountIdOfTransaction(LscUserContext userContext, String accountId, List<Message> messageList)
	{
		
	 	checkIdOfTransaction(userContext,accountId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSACTION ="transaction.version";
	protected void checkVersionOfTransaction(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSACTION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	protected void checkIdOfUserDomain(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	protected void checkNameOfUserDomain(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	protected void checkVersionOfUserDomain(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	protected void checkIdOfUserWhiteList(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	protected void checkUserIdentityOfUserWhiteList(LscUserContext userContext, String userIdentity, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	protected void checkUserSpecialFunctionsOfUserWhiteList(LscUserContext userContext, String userSpecialFunctions, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	protected void checkDomainIdOfUserWhiteList(LscUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfUserWhiteList(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	protected void checkVersionOfUserWhiteList(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	protected void checkIdOfSecUser(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	protected void checkLoginOfSecUser(LscUserContext userContext, String login, List<Message> messageList)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	protected void checkMobileOfSecUser(LscUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	protected void checkEmailOfSecUser(LscUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	protected void checkPwdOfSecUser(LscUserContext userContext, String pwd, List<Message> messageList)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	protected void checkVerificationCodeOfSecUser(LscUserContext userContext, int verificationCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	protected void checkVerificationCodeExpireOfSecUser(LscUserContext userContext, DateTime verificationCodeExpire, List<Message> messageList)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	protected void checkLastLoginTimeOfSecUser(LscUserContext userContext, DateTime lastLoginTime, List<Message> messageList)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	protected void checkDomainIdOfSecUser(LscUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfSecUser(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	protected void checkVersionOfSecUser(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	protected void checkIdOfSecUserBlocking(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	protected void checkWhoOfSecUserBlocking(LscUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	protected void checkCommentsOfSecUserBlocking(LscUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	protected void checkVersionOfSecUserBlocking(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_APP ="user_app.id";
	protected void checkIdOfUserApp(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	protected void checkTitleOfUserApp(LscUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	protected void checkSecUserIdOfUserApp(LscUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfUserApp(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	protected void checkAppIconOfUserApp(LscUserContext userContext, String appIcon, List<Message> messageList)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	protected void checkFullAccessOfUserApp(LscUserContext userContext, boolean fullAccess, List<Message> messageList)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	protected void checkPermissionOfUserApp(LscUserContext userContext, String permission, List<Message> messageList)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	protected void checkObjectTypeOfUserApp(LscUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	protected void checkObjectIdOfUserApp(LscUserContext userContext, String objectId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	protected void checkLocationOfUserApp(LscUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	protected void checkVersionOfUserApp(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	protected void checkIdOfListAccess(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	protected void checkNameOfListAccess(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	protected void checkInternalNameOfListAccess(LscUserContext userContext, String internalName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	protected void checkReadPermissionOfListAccess(LscUserContext userContext, boolean readPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	protected void checkCreatePermissionOfListAccess(LscUserContext userContext, boolean createPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	protected void checkDeletePermissionOfListAccess(LscUserContext userContext, boolean deletePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	protected void checkUpdatePermissionOfListAccess(LscUserContext userContext, boolean updatePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	protected void checkExecutionPermissionOfListAccess(LscUserContext userContext, boolean executionPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	protected void checkAppIdOfListAccess(LscUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfListAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	protected void checkVersionOfListAccess(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	protected void checkIdOfObjectAccess(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	protected void checkNameOfObjectAccess(LscUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	protected void checkObjectTypeOfObjectAccess(LscUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	protected void checkList1OfObjectAccess(LscUserContext userContext, String list1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	protected void checkList2OfObjectAccess(LscUserContext userContext, String list2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	protected void checkList3OfObjectAccess(LscUserContext userContext, String list3, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	protected void checkList4OfObjectAccess(LscUserContext userContext, String list4, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	protected void checkList5OfObjectAccess(LscUserContext userContext, String list5, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	protected void checkList6OfObjectAccess(LscUserContext userContext, String list6, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	protected void checkList7OfObjectAccess(LscUserContext userContext, String list7, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	protected void checkList8OfObjectAccess(LscUserContext userContext, String list8, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	protected void checkList9OfObjectAccess(LscUserContext userContext, String list9, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	protected void checkAppIdOfObjectAccess(LscUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfObjectAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	protected void checkVersionOfObjectAccess(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	protected void checkIdOfLoginHistory(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	protected void checkFromIpOfLoginHistory(LscUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	protected void checkDescriptionOfLoginHistory(LscUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	protected void checkSecUserIdOfLoginHistory(LscUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfLoginHistory(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	protected void checkVersionOfLoginHistory(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	protected void checkIdOfGenericForm(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	protected void checkTitleOfGenericForm(LscUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	protected void checkDescriptionOfGenericForm(LscUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	protected void checkVersionOfGenericForm(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	protected void checkIdOfFormMessage(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	protected void checkTitleOfFormMessage(LscUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	protected void checkFormIdOfFormMessage(LscUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	protected void checkLevelOfFormMessage(LscUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	protected void checkVersionOfFormMessage(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	protected void checkIdOfFormFieldMessage(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	protected void checkTitleOfFormFieldMessage(LscUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	protected void checkParameterNameOfFormFieldMessage(LscUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	protected void checkFormIdOfFormFieldMessage(LscUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormFieldMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	protected void checkLevelOfFormFieldMessage(LscUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	protected void checkVersionOfFormFieldMessage(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	protected void checkIdOfFormField(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	protected void checkLabelOfFormField(LscUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	protected void checkLocaleKeyOfFormField(LscUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	protected void checkParameterNameOfFormField(LscUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	protected void checkTypeOfFormField(LscUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	protected void checkFormIdOfFormField(LscUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormField(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	protected void checkPlaceholderOfFormField(LscUserContext userContext, String placeholder, List<Message> messageList)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	protected void checkDefaultValueOfFormField(LscUserContext userContext, String defaultValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	protected void checkDescriptionOfFormField(LscUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	protected void checkFieldGroupOfFormField(LscUserContext userContext, String fieldGroup, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	protected void checkMinimumValueOfFormField(LscUserContext userContext, String minimumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	protected void checkMaximumValueOfFormField(LscUserContext userContext, String maximumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	protected void checkRequiredOfFormField(LscUserContext userContext, boolean required, List<Message> messageList)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	protected void checkDisabledOfFormField(LscUserContext userContext, boolean disabled, List<Message> messageList)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	protected void checkCustomRenderingOfFormField(LscUserContext userContext, boolean customRendering, List<Message> messageList)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	protected void checkCandidateValuesOfFormField(LscUserContext userContext, String candidateValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	protected void checkSuggestValuesOfFormField(LscUserContext userContext, String suggestValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	protected void checkVersionOfFormField(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	protected void checkIdOfFormAction(LscUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	protected void checkLabelOfFormAction(LscUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	protected void checkLocaleKeyOfFormAction(LscUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	protected void checkActionKeyOfFormAction(LscUserContext userContext, String actionKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	protected void checkLevelOfFormAction(LscUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	protected void checkUrlOfFormAction(LscUserContext userContext, String url, List<Message> messageList)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	protected void checkFormIdOfFormAction(LscUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormAction(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	protected void checkVersionOfFormAction(LscUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION, messageList); 		
		
	}	 			public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof LscUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return accessOK();
		}
		LscUserContext userContext = (LscUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return accessOK();
		}
		return super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(LscUserContext userContext, List<Message> messageList, Class<? extends LscException> exceptionClazz) throws Exception{
		//translate messages;
		if(messageList.isEmpty()){
			return;
		}
		
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

	}
	*/

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, LscException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}











