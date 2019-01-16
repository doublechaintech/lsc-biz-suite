
package com.doublechaintech.lsc.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatusDAO;
import com.doublechaintech.lsc.transactiontype.TransactionTypeDAO;
import com.doublechaintech.lsc.merchanttype.MerchantTypeDAO;
import com.doublechaintech.lsc.location.LocationDAO;
import com.doublechaintech.lsc.merchant.MerchantDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.transportitem.TransportItemDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransactionTypeDAO getTransactionTypeDAO();
		
	public MerchantTypeDAO getMerchantTypeDAO();
		
	public TransportTaskStatusDAO getTransportTaskStatusDAO();
		
	public LocationDAO getLocationDAO();
		
	public MerchantDAO getMerchantDAO();
		
	public TransportProjectDAO getTransportProjectDAO();
		
	public TransportItemDAO getTransportItemDAO();
		
	public TransportTaskDAO getTransportTaskDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForTransactionType(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForMerchantType(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForTransportTaskStatus(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForLocation(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForMerchant(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForTransportProject(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForTransportItem(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForTransportTask(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveTransactionTypeList(Platform platform, String transactionTypeIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveMerchantTypeList(Platform platform, String merchantTypeIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveTransportTaskStatusList(Platform platform, String transportTaskStatusIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveLocationList(Platform platform, String locationIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveMerchantList(Platform platform, String merchantIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with type in Merchant
	public Platform planToRemoveMerchantListWithType(Platform platform, String typeId, Map<String,Object> options)throws Exception;
	public int countMerchantListWithType(String platformId, String typeId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveTransportProjectList(Platform platform, String transportProjectIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with merchant in TransportProject
	public Platform planToRemoveTransportProjectListWithMerchant(Platform platform, String merchantId, Map<String,Object> options)throws Exception;
	public int countTransportProjectListWithMerchant(String platformId, String merchantId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveTransportItemList(Platform platform, String transportItemIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with project in TransportItem
	public Platform planToRemoveTransportItemListWithProject(Platform platform, String projectId, Map<String,Object> options)throws Exception;
	public int countTransportItemListWithProject(String platformId, String projectId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with merchant in TransportItem
	public Platform planToRemoveTransportItemListWithMerchant(Platform platform, String merchantId, Map<String,Object> options)throws Exception;
	public int countTransportItemListWithMerchant(String platformId, String merchantId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveTransportTaskList(Platform platform, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with project in TransportTask
	public Platform planToRemoveTransportTaskListWithProject(Platform platform, String projectId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithProject(String platformId, String projectId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with source in TransportTask
	public Platform planToRemoveTransportTaskListWithSource(Platform platform, String sourceId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithSource(String platformId, String sourceId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with destination in TransportTask
	public Platform planToRemoveTransportTaskListWithDestination(Platform platform, String destinationId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithDestination(String platformId, String destinationId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with status in TransportTask
	public Platform planToRemoveTransportTaskListWithStatus(Platform platform, String statusId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithStatus(String platformId, String statusId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with sender in TransportTask
	public Platform planToRemoveTransportTaskListWithSender(Platform platform, String senderId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithSender(String platformId, String senderId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with receiver in TransportTask
	public Platform planToRemoveTransportTaskListWithReceiver(Platform platform, String receiverId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithReceiver(String platformId, String receiverId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


