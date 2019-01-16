
package com.doublechaintech.lsc.location;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;


public interface LocationDAO{

	
	public Location load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Location> locationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Location present(Location location,Map<String,Object> options) throws Exception;
	public Location clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Location save(Location location,Map<String,Object> options);
	public SmartList<Location> saveLocationList(SmartList<Location> locationList,Map<String,Object> options);
	public SmartList<Location> removeLocationList(SmartList<Location> locationList,Map<String,Object> options);
	public SmartList<Location> findLocationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLocationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLocationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String locationId, int version) throws Exception;
	public Location disconnectFromAll(String locationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransportTaskDAO getTransportTaskDAO();
		
	
 	public SmartList<Location> requestCandidateLocationForTransportTaskAsSource(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Location> requestCandidateLocationForTransportTaskAsDestination(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Location planToRemoveTransportTaskListAsSource(Location location, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect Location with status in TransportTask
	public Location planToRemoveTransportTaskListAsSourceWithStatus(Location location, String statusId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSourceWithStatus(String locationId, String statusId, Map<String,Object> options)throws Exception;
	
	//disconnect Location with sender in TransportTask
	public Location planToRemoveTransportTaskListAsSourceWithSender(Location location, String senderId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSourceWithSender(String locationId, String senderId, Map<String,Object> options)throws Exception;
	
	//disconnect Location with receiver in TransportTask
	public Location planToRemoveTransportTaskListAsSourceWithReceiver(Location location, String receiverId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSourceWithReceiver(String locationId, String receiverId, Map<String,Object> options)throws Exception;
	
	//disconnect Location with platform in TransportTask
	public Location planToRemoveTransportTaskListAsSourceWithPlatform(Location location, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsSourceWithPlatform(String locationId, String platformId, Map<String,Object> options)throws Exception;
	
	public Location planToRemoveTransportTaskListAsDestination(Location location, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect Location with status in TransportTask
	public Location planToRemoveTransportTaskListAsDestinationWithStatus(Location location, String statusId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsDestinationWithStatus(String locationId, String statusId, Map<String,Object> options)throws Exception;
	
	//disconnect Location with sender in TransportTask
	public Location planToRemoveTransportTaskListAsDestinationWithSender(Location location, String senderId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsDestinationWithSender(String locationId, String senderId, Map<String,Object> options)throws Exception;
	
	//disconnect Location with receiver in TransportTask
	public Location planToRemoveTransportTaskListAsDestinationWithReceiver(Location location, String receiverId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsDestinationWithReceiver(String locationId, String receiverId, Map<String,Object> options)throws Exception;
	
	//disconnect Location with platform in TransportTask
	public Location planToRemoveTransportTaskListAsDestinationWithPlatform(Location location, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListAsDestinationWithPlatform(String locationId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Location> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Location> findLocationByPlatform(String platformId, Map<String,Object> options);
 	public int countLocationByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countLocationByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Location> findLocationByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeLocationByPlatform(SmartList<Location> resultList, String platformId, Map<String,Object> options);

 
 }


