
package com.doublechaintech.lsc.transportproject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.merchant.MerchantDAO;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;
import com.doublechaintech.lsc.transportitem.TransportItemDAO;


public interface TransportProjectDAO{

	
	public TransportProject load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransportProject> transportProjectList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TransportProject present(TransportProject transportProject,Map<String,Object> options) throws Exception;
	public TransportProject clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportProject save(TransportProject transportProject,Map<String,Object> options);
	public SmartList<TransportProject> saveTransportProjectList(SmartList<TransportProject> transportProjectList,Map<String,Object> options);
	public SmartList<TransportProject> removeTransportProjectList(SmartList<TransportProject> transportProjectList,Map<String,Object> options);
	public SmartList<TransportProject> findTransportProjectWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransportProjectWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransportProjectWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transportProjectId, int version) throws Exception;
	public TransportProject disconnectFromAll(String transportProjectId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransportItemDAO getTransportItemDAO();
		
	public TransportTaskDAO getTransportTaskDAO();
		
	
 	public SmartList<TransportProject> requestCandidateTransportProjectForTransportItem(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<TransportProject> requestCandidateTransportProjectForTransportTask(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TransportProject planToRemoveTransportItemList(TransportProject transportProject, String transportItemIds[], Map<String,Object> options)throws Exception;


	//disconnect TransportProject with merchant in TransportItem
	public TransportProject planToRemoveTransportItemListWithMerchant(TransportProject transportProject, String merchantId, Map<String,Object> options)throws Exception;
	public int countTransportItemListWithMerchant(String transportProjectId, String merchantId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportProject with platform in TransportItem
	public TransportProject planToRemoveTransportItemListWithPlatform(TransportProject transportProject, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportItemListWithPlatform(String transportProjectId, String platformId, Map<String,Object> options)throws Exception;
	
	public TransportProject planToRemoveTransportTaskList(TransportProject transportProject, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect TransportProject with source in TransportTask
	public TransportProject planToRemoveTransportTaskListWithSource(TransportProject transportProject, String sourceId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithSource(String transportProjectId, String sourceId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportProject with destination in TransportTask
	public TransportProject planToRemoveTransportTaskListWithDestination(TransportProject transportProject, String destinationId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithDestination(String transportProjectId, String destinationId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportProject with status in TransportTask
	public TransportProject planToRemoveTransportTaskListWithStatus(TransportProject transportProject, String statusId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithStatus(String transportProjectId, String statusId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportProject with sender in TransportTask
	public TransportProject planToRemoveTransportTaskListWithSender(TransportProject transportProject, String senderId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithSender(String transportProjectId, String senderId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportProject with receiver in TransportTask
	public TransportProject planToRemoveTransportTaskListWithReceiver(TransportProject transportProject, String receiverId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithReceiver(String transportProjectId, String receiverId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportProject with platform in TransportTask
	public TransportProject planToRemoveTransportTaskListWithPlatform(TransportProject transportProject, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithPlatform(String transportProjectId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TransportProject> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TransportProject> findTransportProjectByMerchant(String merchantId, Map<String,Object> options);
 	public int countTransportProjectByMerchant(String merchantId, Map<String,Object> options);
 	public Map<String, Integer> countTransportProjectByMerchantIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportProject> findTransportProjectByMerchant(String merchantId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportProjectByMerchant(SmartList<TransportProject> resultList, String merchantId, Map<String,Object> options);

 
  
 	public SmartList<TransportProject> findTransportProjectByPlatform(String platformId, Map<String,Object> options);
 	public int countTransportProjectByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countTransportProjectByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportProject> findTransportProjectByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportProjectByPlatform(SmartList<TransportProject> resultList, String platformId, Map<String,Object> options);

 
 }


