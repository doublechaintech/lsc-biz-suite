
package com.doublechaintech.lsc.merchant;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.merchantaccount.MerchantAccountDAO;
import com.doublechaintech.lsc.merchanttype.MerchantTypeDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;


public interface MerchantDAO{

	
	public Merchant load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Merchant> merchantList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Merchant present(Merchant merchant,Map<String,Object> options) throws Exception;
	public Merchant clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Merchant save(Merchant merchant,Map<String,Object> options);
	public SmartList<Merchant> saveMerchantList(SmartList<Merchant> merchantList,Map<String,Object> options);
	public SmartList<Merchant> removeMerchantList(SmartList<Merchant> merchantList,Map<String,Object> options);
	public SmartList<Merchant> findMerchantWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMerchantWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMerchantWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String merchantId, int version) throws Exception;
	public Merchant disconnectFromAll(String merchantId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransportProjectDAO getTransportProjectDAO();
		
	public TransportTaskDAO getTransportTaskDAO();
		
	public MerchantAccountDAO getMerchantAccountDAO();
		
	
 	public SmartList<Merchant> requestCandidateMerchantForTransportProject(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Merchant> requestCandidateMerchantForTransportTaskAsSender(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Merchant> requestCandidateMerchantForTransportTaskAsReceiver(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Merchant> requestCandidateMerchantForMerchantAccount(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Merchant planToRemoveTransportProjectList(Merchant merchant, String transportProjectIds[], Map<String,Object> options)throws Exception;


	//disconnect Merchant with platform in TransportProject
	public Merchant planToRemoveTransportProjectListWithPlatform(Merchant merchant, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportProjectListWithPlatform(String merchantId, String platformId, Map<String,Object> options)throws Exception;
	
	public Merchant planToRemoveTransportTaskListAsSender(Merchant merchant, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect Merchant with project in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithProject(Merchant merchant, String projectId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSenderWithProject(String merchantId, String projectId, Map<String,Object> options)throws Exception;
	
	//disconnect Merchant with source in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithSource(Merchant merchant, String sourceId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSenderWithSource(String merchantId, String sourceId, Map<String,Object> options)throws Exception;
	
	//disconnect Merchant with destination in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithDestination(Merchant merchant, String destinationId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSenderWithDestination(String merchantId, String destinationId, Map<String,Object> options)throws Exception;
	
	//disconnect Merchant with status in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithStatus(Merchant merchant, String statusId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSenderWithStatus(String merchantId, String statusId, Map<String,Object> options)throws Exception;
	
	//disconnect Merchant with platform in TransportTask
	public Merchant planToRemoveTransportTaskListAsSenderWithPlatform(Merchant merchant, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSenderWithPlatform(String merchantId, String platformId, Map<String,Object> options)throws Exception;
	
	public Merchant planToRemoveTransportTaskListAsReceiver(Merchant merchant, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect Merchant with project in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithProject(Merchant merchant, String projectId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsReceiverWithProject(String merchantId, String projectId, Map<String,Object> options)throws Exception;
	
	//disconnect Merchant with source in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithSource(Merchant merchant, String sourceId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsReceiverWithSource(String merchantId, String sourceId, Map<String,Object> options)throws Exception;
	
	//disconnect Merchant with destination in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithDestination(Merchant merchant, String destinationId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsReceiverWithDestination(String merchantId, String destinationId, Map<String,Object> options)throws Exception;
	
	//disconnect Merchant with status in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithStatus(Merchant merchant, String statusId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsReceiverWithStatus(String merchantId, String statusId, Map<String,Object> options)throws Exception;
	
	//disconnect Merchant with platform in TransportTask
	public Merchant planToRemoveTransportTaskListAsReceiverWithPlatform(Merchant merchant, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsReceiverWithPlatform(String merchantId, String platformId, Map<String,Object> options)throws Exception;
	
	public Merchant planToRemoveMerchantAccountList(Merchant merchant, String merchantAccountIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Merchant> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Merchant> findMerchantByType(String merchantTypeId, Map<String,Object> options);
 	public int countMerchantByType(String merchantTypeId, Map<String,Object> options);
 	public Map<String, Integer> countMerchantByTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Merchant> findMerchantByType(String merchantTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeMerchantByType(SmartList<Merchant> resultList, String merchantTypeId, Map<String,Object> options);

 
  
 	public SmartList<Merchant> findMerchantByPlatform(String platformId, Map<String,Object> options);
 	public int countMerchantByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countMerchantByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Merchant> findMerchantByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeMerchantByPlatform(SmartList<Merchant> resultList, String platformId, Map<String,Object> options);

 
 }


