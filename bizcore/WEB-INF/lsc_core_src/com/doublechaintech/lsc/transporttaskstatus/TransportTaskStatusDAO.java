
package com.doublechaintech.lsc.transporttaskstatus;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;


public interface TransportTaskStatusDAO{

	
	public TransportTaskStatus load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransportTaskStatus> transportTaskStatusList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TransportTaskStatus present(TransportTaskStatus transportTaskStatus,Map<String,Object> options) throws Exception;
	public TransportTaskStatus clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportTaskStatus save(TransportTaskStatus transportTaskStatus,Map<String,Object> options);
	public SmartList<TransportTaskStatus> saveTransportTaskStatusList(SmartList<TransportTaskStatus> transportTaskStatusList,Map<String,Object> options);
	public SmartList<TransportTaskStatus> removeTransportTaskStatusList(SmartList<TransportTaskStatus> transportTaskStatusList,Map<String,Object> options);
	public SmartList<TransportTaskStatus> findTransportTaskStatusWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransportTaskStatusWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransportTaskStatusWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transportTaskStatusId, int version) throws Exception;
	public TransportTaskStatus disconnectFromAll(String transportTaskStatusId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransportTaskDAO getTransportTaskDAO();
		
	
 	public SmartList<TransportTaskStatus> requestCandidateTransportTaskStatusForTransportTask(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TransportTaskStatus planToRemoveTransportTaskList(TransportTaskStatus transportTaskStatus, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect TransportTaskStatus with project in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithProject(TransportTaskStatus transportTaskStatus, String projectId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithProject(String transportTaskStatusId, String projectId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportTaskStatus with source in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithSource(TransportTaskStatus transportTaskStatus, String sourceId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithSource(String transportTaskStatusId, String sourceId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportTaskStatus with destination in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithDestination(TransportTaskStatus transportTaskStatus, String destinationId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithDestination(String transportTaskStatusId, String destinationId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportTaskStatus with sender in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithSender(TransportTaskStatus transportTaskStatus, String senderId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithSender(String transportTaskStatusId, String senderId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportTaskStatus with receiver in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithReceiver(TransportTaskStatus transportTaskStatus, String receiverId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithReceiver(String transportTaskStatusId, String receiverId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportTaskStatus with platform in TransportTask
	public TransportTaskStatus planToRemoveTransportTaskListWithPlatform(TransportTaskStatus transportTaskStatus, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithPlatform(String transportTaskStatusId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TransportTaskStatus> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TransportTaskStatus> findTransportTaskStatusByPlatform(String platformId, Map<String,Object> options);
 	public int countTransportTaskStatusByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskStatusByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTaskStatus> findTransportTaskStatusByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskStatusByPlatform(SmartList<TransportTaskStatus> resultList, String platformId, Map<String,Object> options);

 
 }


