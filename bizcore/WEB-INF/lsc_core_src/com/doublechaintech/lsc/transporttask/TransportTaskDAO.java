
package com.doublechaintech.lsc.transporttask;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatusDAO;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrackDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.location.LocationDAO;
import com.doublechaintech.lsc.merchant.MerchantDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;


public interface TransportTaskDAO{

	
	public TransportTask load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransportTask> transportTaskList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TransportTask present(TransportTask transportTask,Map<String,Object> options) throws Exception;
	public TransportTask clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportTask save(TransportTask transportTask,Map<String,Object> options);
	public SmartList<TransportTask> saveTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options);
	public SmartList<TransportTask> removeTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options);
	public SmartList<TransportTask> findTransportTaskWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransportTaskWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransportTaskWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transportTaskId, int version) throws Exception;
	public TransportTask disconnectFromAll(String transportTaskId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransportTaskTrackDAO getTransportTaskTrackDAO();
		
	
 	public SmartList<TransportTask> requestCandidateTransportTaskForTransportTaskTrack(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TransportTask planToRemoveTransportTaskTrackList(TransportTask transportTask, String transportTaskTrackIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<TransportTask> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TransportTask> findTransportTaskByProject(String transportProjectId, Map<String,Object> options);
 	public int countTransportTaskByProject(String transportProjectId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskByProjectIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByProject(String transportProjectId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskByProject(SmartList<TransportTask> resultList, String transportProjectId, Map<String,Object> options);

 
  
 	public SmartList<TransportTask> findTransportTaskBySource(String locationId, Map<String,Object> options);
 	public int countTransportTaskBySource(String locationId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskBySourceIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskBySource(String locationId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskBySource(SmartList<TransportTask> resultList, String locationId, Map<String,Object> options);

 
  
 	public SmartList<TransportTask> findTransportTaskByDestination(String locationId, Map<String,Object> options);
 	public int countTransportTaskByDestination(String locationId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskByDestinationIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByDestination(String locationId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskByDestination(SmartList<TransportTask> resultList, String locationId, Map<String,Object> options);

 
  
 	public SmartList<TransportTask> findTransportTaskByStatus(String transportTaskStatusId, Map<String,Object> options);
 	public int countTransportTaskByStatus(String transportTaskStatusId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskByStatusIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByStatus(String transportTaskStatusId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskByStatus(SmartList<TransportTask> resultList, String transportTaskStatusId, Map<String,Object> options);

 
  
 	public SmartList<TransportTask> findTransportTaskBySender(String merchantId, Map<String,Object> options);
 	public int countTransportTaskBySender(String merchantId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskBySenderIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskBySender(String merchantId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskBySender(SmartList<TransportTask> resultList, String merchantId, Map<String,Object> options);

 
  
 	public SmartList<TransportTask> findTransportTaskByReceiver(String merchantId, Map<String,Object> options);
 	public int countTransportTaskByReceiver(String merchantId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskByReceiverIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByReceiver(String merchantId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskByReceiver(SmartList<TransportTask> resultList, String merchantId, Map<String,Object> options);

 
  
 	public SmartList<TransportTask> findTransportTaskByPlatform(String platformId, Map<String,Object> options);
 	public int countTransportTaskByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskByPlatform(SmartList<TransportTask> resultList, String platformId, Map<String,Object> options);

 
 }


