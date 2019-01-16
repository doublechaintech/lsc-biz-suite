
package com.doublechaintech.lsc.transporttasktrack;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;


public interface TransportTaskTrackDAO{

	
	public TransportTaskTrack load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransportTaskTrack> transportTaskTrackList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TransportTaskTrack present(TransportTaskTrack transportTaskTrack,Map<String,Object> options) throws Exception;
	public TransportTaskTrack clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportTaskTrack save(TransportTaskTrack transportTaskTrack,Map<String,Object> options);
	public SmartList<TransportTaskTrack> saveTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options);
	public SmartList<TransportTaskTrack> removeTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options);
	public SmartList<TransportTaskTrack> findTransportTaskTrackWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransportTaskTrackWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransportTaskTrackWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transportTaskTrackId, int version) throws Exception;
	public TransportTaskTrack disconnectFromAll(String transportTaskTrackId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<TransportTaskTrack> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByTask(String transportTaskId, Map<String,Object> options);
 	public int countTransportTaskTrackByTask(String transportTaskId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskTrackByTaskIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByTask(String transportTaskId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskTrackByTask(SmartList<TransportTaskTrack> resultList, String transportTaskId, Map<String,Object> options);

 
 }


