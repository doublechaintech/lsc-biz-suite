package com.doublechaintech.lsc;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class LscChecker extends BaseChecker{
	
	
	protected LscUserContext userContext;
	public LscUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(LscUserContext userContext) {
		this.userContext = userContext;
	}
	
	public LscChecker() {
		this.messageList = new ArrayList<Message>();
	}

	

	public static final String  ID_OF_PLATFORM ="platform.id";
	public LscChecker checkIdOfPlatform(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PLATFORM ="platform.name";
	public LscChecker checkNameOfPlatform(String name)
	{
		
	 	checkStringLengthRange(name,3, 32,NAME_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  INTRODUCTION_OF_PLATFORM ="platform.introduction";
	public LscChecker checkIntroductionOfPlatform(String introduction)
	{
		
	 	checkStringLengthRange(introduction,5, 72,INTRODUCTION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  CURRENT_VERSION_OF_PLATFORM ="platform.current_version";
	public LscChecker checkCurrentVersionOfPlatform(String currentVersion)
	{
		
	 	checkStringLengthRange(currentVersion,2, 16,CURRENT_VERSION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PLATFORM ="platform.version";
	public LscChecker checkVersionOfPlatform(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSACTION_TYPE ="transaction_type.id";
	public LscChecker checkIdOfTransactionType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSACTION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSACTION_TYPE ="transaction_type.name";
	public LscChecker checkNameOfTransactionType(String name)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_TRANSACTION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_TRANSACTION_TYPE ="transaction_type.platform";
	public LscChecker checkPlatformIdOfTransactionType(String platformId)
	{
		
	 	checkIdOfTransactionType(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSACTION_TYPE ="transaction_type.version";
	public LscChecker checkVersionOfTransactionType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSACTION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MERCHANT_TYPE ="merchant_type.id";
	public LscChecker checkIdOfMerchantType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MERCHANT_TYPE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MERCHANT_TYPE ="merchant_type.name";
	public LscChecker checkNameOfMerchantType(String name)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_MERCHANT_TYPE ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_MERCHANT_TYPE ="merchant_type.platform";
	public LscChecker checkPlatformIdOfMerchantType(String platformId)
	{
		
	 	checkIdOfMerchantType(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MERCHANT_TYPE ="merchant_type.version";
	public LscChecker checkVersionOfMerchantType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MERCHANT_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_TASK_STATUS ="transport_task_status.id";
	public LscChecker checkIdOfTransportTaskStatus(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK_STATUS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSPORT_TASK_STATUS ="transport_task_status.name";
	public LscChecker checkNameOfTransportTaskStatus(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_TRANSPORT_TASK_STATUS ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_TRANSPORT_TASK_STATUS ="transport_task_status.platform";
	public LscChecker checkPlatformIdOfTransportTaskStatus(String platformId)
	{
		
	 	checkIdOfTransportTaskStatus(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_TASK_STATUS ="transport_task_status.version";
	public LscChecker checkVersionOfTransportTaskStatus(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK_STATUS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LOCATION ="location.id";
	public LscChecker checkIdOfLocation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOCATION ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LOCATION ="location.name";
	public LscChecker checkNameOfLocation(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_LOCATION ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_PERSON_OF_LOCATION ="location.contact_person";
	public LscChecker checkContactPersonOfLocation(String contactPerson)
	{
		
	 	checkStringLengthRange(contactPerson,1, 12,CONTACT_PERSON_OF_LOCATION ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_PHONE_OF_LOCATION ="location.contact_phone";
	public LscChecker checkContactPhoneOfLocation(String contactPhone)
	{
		
	 	checkChinaMobilePhone(contactPhone,5, 44,CONTACT_PHONE_OF_LOCATION ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LOCATION ="location.description";
	public LscChecker checkDescriptionOfLocation(String description)
	{
		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_LOCATION ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_LOCATION ="location.platform";
	public LscChecker checkPlatformIdOfLocation(String platformId)
	{
		
	 	checkIdOfLocation(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LOCATION ="location.version";
	public LscChecker checkVersionOfLocation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOCATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MERCHANT ="merchant.id";
	public LscChecker checkIdOfMerchant(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MERCHANT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MERCHANT ="merchant.name";
	public LscChecker checkNameOfMerchant(String name)
	{
		
	 	checkStringLengthRange(name,1, 32,NAME_OF_MERCHANT ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_MERCHANT ="merchant.type";
	public LscChecker checkTypeIdOfMerchant(String typeId)
	{
		
	 	checkIdOfMerchant(typeId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_MERCHANT ="merchant.platform";
	public LscChecker checkPlatformIdOfMerchant(String platformId)
	{
		
	 	checkIdOfMerchant(platformId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_MERCHANT ="merchant.description";
	public LscChecker checkDescriptionOfMerchant(String description)
	{
		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_MERCHANT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MERCHANT ="merchant.version";
	public LscChecker checkVersionOfMerchant(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MERCHANT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_PROJECT ="transport_project.id";
	public LscChecker checkIdOfTransportProject(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_PROJECT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSPORT_PROJECT ="transport_project.name";
	public LscChecker checkNameOfTransportProject(String name)
	{
		
	 	checkStringLengthRange(name,3, 32,NAME_OF_TRANSPORT_PROJECT ); 		
		
		return this;
	}	 			

	public static final String  MERCHANT_OF_TRANSPORT_PROJECT ="transport_project.merchant";
	public LscChecker checkMerchantIdOfTransportProject(String merchantId)
	{
		
	 	checkIdOfTransportProject(merchantId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_TRANSPORT_PROJECT ="transport_project.platform";
	public LscChecker checkPlatformIdOfTransportProject(String platformId)
	{
		
	 	checkIdOfTransportProject(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_PROJECT ="transport_project.version";
	public LscChecker checkVersionOfTransportProject(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_PROJECT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_ITEM ="transport_item.id";
	public LscChecker checkIdOfTransportItem(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_ITEM ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSPORT_ITEM ="transport_item.name";
	public LscChecker checkNameOfTransportItem(String name)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_TRANSPORT_ITEM ); 		
		
		return this;
	}	 			

	public static final String  QUANTITY_OF_TRANSPORT_ITEM ="transport_item.quantity";
	public LscChecker checkQuantityOfTransportItem(int quantity)
	{
		
	 	checkIntegerRange(quantity,0, 1000,QUANTITY_OF_TRANSPORT_ITEM ); 		
		
		return this;
	}	 			

	public static final String  UNIT_OF_TRANSPORT_ITEM ="transport_item.unit";
	public LscChecker checkUnitOfTransportItem(String unit)
	{
		
	 	checkStringLengthRange(unit,0, 8,UNIT_OF_TRANSPORT_ITEM ); 		
		
		return this;
	}	 			

	public static final String  PROJECT_OF_TRANSPORT_ITEM ="transport_item.project";
	public LscChecker checkProjectIdOfTransportItem(String projectId)
	{
		
	 	checkIdOfTransportItem(projectId ); 		
		
		return this;
	}	 			

	public static final String  MERCHANT_OF_TRANSPORT_ITEM ="transport_item.merchant";
	public LscChecker checkMerchantIdOfTransportItem(String merchantId)
	{
		
	 	checkIdOfTransportItem(merchantId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_TRANSPORT_ITEM ="transport_item.platform";
	public LscChecker checkPlatformIdOfTransportItem(String platformId)
	{
		
	 	checkIdOfTransportItem(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_ITEM ="transport_item.version";
	public LscChecker checkVersionOfTransportItem(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_ITEM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_TASK ="transport_task.id";
	public LscChecker checkIdOfTransportTask(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSPORT_TASK ="transport_task.name";
	public LscChecker checkNameOfTransportTask(String name)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  SOURCE_OF_TRANSPORT_TASK ="transport_task.source";
	public LscChecker checkSourceIdOfTransportTask(String sourceId)
	{
		
	 	checkIdOfTransportTask(sourceId ); 		
		
		return this;
	}	 			

	public static final String  DESTINATION_OF_TRANSPORT_TASK ="transport_task.destination";
	public LscChecker checkDestinationIdOfTransportTask(String destinationId)
	{
		
	 	checkIdOfTransportTask(destinationId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_TRANSPORT_TASK ="transport_task.remark";
	public LscChecker checkRemarkOfTransportTask(String remark)
	{
		
	 	checkStringLengthRange(remark,2, 20,REMARK_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  STATUS_OF_TRANSPORT_TASK ="transport_task.status";
	public LscChecker checkStatusIdOfTransportTask(String statusId)
	{
		
	 	checkIdOfTransportTask(statusId ); 		
		
		return this;
	}	 			

	public static final String  SENDER_OF_TRANSPORT_TASK ="transport_task.sender";
	public LscChecker checkSenderIdOfTransportTask(String senderId)
	{
		
	 	checkIdOfTransportTask(senderId ); 		
		
		return this;
	}	 			

	public static final String  RECEIVER_OF_TRANSPORT_TASK ="transport_task.receiver";
	public LscChecker checkReceiverIdOfTransportTask(String receiverId)
	{
		
	 	checkIdOfTransportTask(receiverId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_TRANSPORT_TASK ="transport_task.platform";
	public LscChecker checkPlatformIdOfTransportTask(String platformId)
	{
		
	 	checkIdOfTransportTask(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_TASK ="transport_task.version";
	public LscChecker checkVersionOfTransportTask(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_TASK_TRACK ="transport_task_track.id";
	public LscChecker checkIdOfTransportTaskTrack(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSPORT_TASK_TRACK ="transport_task_track.name";
	public LscChecker checkNameOfTransportTaskTrack(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.latitude";
	public LscChecker checkLatitudeOfTransportTaskTrack(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.longitude";
	public LscChecker checkLongitudeOfTransportTaskTrack(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  TASK_OF_TRANSPORT_TASK_TRACK ="transport_task_track.task";
	public LscChecker checkTaskIdOfTransportTaskTrack(String taskId)
	{
		
	 	checkIdOfTransportTaskTrack(taskId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_TASK_TRACK ="transport_task_track.version";
	public LscChecker checkVersionOfTransportTaskTrack(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MERCHANT_ACCOUNT ="merchant_account.id";
	public LscChecker checkIdOfMerchantAccount(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MERCHANT_ACCOUNT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MERCHANT_ACCOUNT ="merchant_account.name";
	public LscChecker checkNameOfMerchantAccount(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_MERCHANT_ACCOUNT ); 		
		
		return this;
	}	 			

	public static final String  MERCHANT_OF_MERCHANT_ACCOUNT ="merchant_account.merchant";
	public LscChecker checkMerchantIdOfMerchantAccount(String merchantId)
	{
		
	 	checkIdOfMerchantAccount(merchantId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MERCHANT_ACCOUNT ="merchant_account.version";
	public LscChecker checkVersionOfMerchantAccount(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MERCHANT_ACCOUNT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSACTION ="transaction.id";
	public LscChecker checkIdOfTransaction(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSACTION ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSACTION ="transaction.name";
	public LscChecker checkNameOfTransaction(String name)
	{
		
	 	checkStringLengthRange(name,1, 8,NAME_OF_TRANSACTION ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_TRANSACTION ="transaction.amount";
	public LscChecker checkAmountOfTransaction(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 12312.12,AMOUNT_OF_TRANSACTION ); 		
		
		return this;
	}	 			

	public static final String  TRANSACTION_TYPE_OF_TRANSACTION ="transaction.transaction_type";
	public LscChecker checkTransactionTypeIdOfTransaction(String transactionTypeId)
	{
		
	 	checkIdOfTransaction(transactionTypeId ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNT_OF_TRANSACTION ="transaction.account";
	public LscChecker checkAccountIdOfTransaction(String accountId)
	{
		
	 	checkIdOfTransaction(accountId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSACTION ="transaction.version";
	public LscChecker checkVersionOfTransaction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSACTION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public LscChecker checkIdOfUserDomain(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public LscChecker checkNameOfUserDomain(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public LscChecker checkVersionOfUserDomain(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public LscChecker checkIdOfUserWhiteList(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public LscChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public LscChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public LscChecker checkDomainIdOfUserWhiteList(String domainId)
	{
		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public LscChecker checkVersionOfUserWhiteList(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public LscChecker checkIdOfSecUser(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public LscChecker checkLoginOfSecUser(String login)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public LscChecker checkMobileOfSecUser(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public LscChecker checkEmailOfSecUser(String email)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public LscChecker checkPwdOfSecUser(String pwd)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public LscChecker checkVerificationCodeOfSecUser(int verificationCode)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public LscChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public LscChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public LscChecker checkDomainIdOfSecUser(String domainId)
	{
		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public LscChecker checkVersionOfSecUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	public LscChecker checkIdOfSecUserBlocking(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	public LscChecker checkWhoOfSecUserBlocking(String who)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	public LscChecker checkCommentsOfSecUserBlocking(String comments)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	public LscChecker checkVersionOfSecUserBlocking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_APP ="user_app.id";
	public LscChecker checkIdOfUserApp(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public LscChecker checkTitleOfUserApp(String title)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public LscChecker checkSecUserIdOfUserApp(String secUserId)
	{
		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	 			

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public LscChecker checkAppIconOfUserApp(String appIcon)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public LscChecker checkFullAccessOfUserApp(boolean fullAccess)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public LscChecker checkPermissionOfUserApp(String permission)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public LscChecker checkObjectTypeOfUserApp(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public LscChecker checkObjectIdOfUserApp(String objectId)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public LscChecker checkLocationOfUserApp(String location)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public LscChecker checkVersionOfUserApp(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public LscChecker checkIdOfListAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public LscChecker checkNameOfListAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public LscChecker checkInternalNameOfListAccess(String internalName)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public LscChecker checkReadPermissionOfListAccess(boolean readPermission)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public LscChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public LscChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public LscChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public LscChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public LscChecker checkAppIdOfListAccess(String appId)
	{
		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public LscChecker checkVersionOfListAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public LscChecker checkIdOfObjectAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public LscChecker checkNameOfObjectAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public LscChecker checkObjectTypeOfObjectAccess(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public LscChecker checkList1OfObjectAccess(String list1)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public LscChecker checkList2OfObjectAccess(String list2)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public LscChecker checkList3OfObjectAccess(String list3)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public LscChecker checkList4OfObjectAccess(String list4)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public LscChecker checkList5OfObjectAccess(String list5)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public LscChecker checkList6OfObjectAccess(String list6)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public LscChecker checkList7OfObjectAccess(String list7)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public LscChecker checkList8OfObjectAccess(String list8)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public LscChecker checkList9OfObjectAccess(String list9)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public LscChecker checkAppIdOfObjectAccess(String appId)
	{
		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public LscChecker checkVersionOfObjectAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public LscChecker checkIdOfLoginHistory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public LscChecker checkFromIpOfLoginHistory(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public LscChecker checkDescriptionOfLoginHistory(String description)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public LscChecker checkSecUserIdOfLoginHistory(String secUserId)
	{
		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public LscChecker checkVersionOfLoginHistory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public LscChecker checkIdOfGenericForm(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public LscChecker checkTitleOfGenericForm(String title)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public LscChecker checkDescriptionOfGenericForm(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public LscChecker checkVersionOfGenericForm(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public LscChecker checkIdOfFormMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public LscChecker checkTitleOfFormMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public LscChecker checkFormIdOfFormMessage(String formId)
	{
		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public LscChecker checkLevelOfFormMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public LscChecker checkVersionOfFormMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public LscChecker checkIdOfFormFieldMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public LscChecker checkTitleOfFormFieldMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public LscChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public LscChecker checkFormIdOfFormFieldMessage(String formId)
	{
		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public LscChecker checkLevelOfFormFieldMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public LscChecker checkVersionOfFormFieldMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public LscChecker checkIdOfFormField(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public LscChecker checkLabelOfFormField(String label)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public LscChecker checkLocaleKeyOfFormField(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public LscChecker checkParameterNameOfFormField(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public LscChecker checkTypeOfFormField(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public LscChecker checkFormIdOfFormField(String formId)
	{
		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	 			

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public LscChecker checkPlaceholderOfFormField(String placeholder)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public LscChecker checkDefaultValueOfFormField(String defaultValue)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public LscChecker checkDescriptionOfFormField(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public LscChecker checkFieldGroupOfFormField(String fieldGroup)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public LscChecker checkMinimumValueOfFormField(String minimumValue)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public LscChecker checkMaximumValueOfFormField(String maximumValue)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public LscChecker checkRequiredOfFormField(boolean required)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public LscChecker checkDisabledOfFormField(boolean disabled)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public LscChecker checkCustomRenderingOfFormField(boolean customRendering)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public LscChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public LscChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public LscChecker checkVersionOfFormField(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public LscChecker checkIdOfFormAction(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public LscChecker checkLabelOfFormAction(String label)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public LscChecker checkLocaleKeyOfFormAction(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public LscChecker checkActionKeyOfFormAction(String actionKey)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public LscChecker checkLevelOfFormAction(String level)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public LscChecker checkUrlOfFormAction(String url)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public LscChecker checkFormIdOfFormAction(String formId)
	{
		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public LscChecker checkVersionOfFormAction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	 			
	public void throwExceptionIfHasErrors(Class<? extends Exception> exceptionClazz) throws Exception {
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

    
}












