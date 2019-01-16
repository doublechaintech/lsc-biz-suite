
package com.doublechaintech.lsc.transportitem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.merchanttype.MerchantTypeDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;


public interface TransportItemDAO{

	
	public TransportItem load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransportItem> transportItemList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TransportItem present(TransportItem transportItem,Map<String,Object> options) throws Exception;
	public TransportItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportItem save(TransportItem transportItem,Map<String,Object> options);
	public SmartList<TransportItem> saveTransportItemList(SmartList<TransportItem> transportItemList,Map<String,Object> options);
	public SmartList<TransportItem> removeTransportItemList(SmartList<TransportItem> transportItemList,Map<String,Object> options);
	public SmartList<TransportItem> findTransportItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransportItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransportItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transportItemId, int version) throws Exception;
	public TransportItem disconnectFromAll(String transportItemId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<TransportItem> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TransportItem> findTransportItemByProject(String transportProjectId, Map<String,Object> options);
 	public int countTransportItemByProject(String transportProjectId, Map<String,Object> options);
 	public Map<String, Integer> countTransportItemByProjectIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportItem> findTransportItemByProject(String transportProjectId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportItemByProject(SmartList<TransportItem> resultList, String transportProjectId, Map<String,Object> options);

 
  
 	public SmartList<TransportItem> findTransportItemByMerchant(String merchantTypeId, Map<String,Object> options);
 	public int countTransportItemByMerchant(String merchantTypeId, Map<String,Object> options);
 	public Map<String, Integer> countTransportItemByMerchantIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportItem> findTransportItemByMerchant(String merchantTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportItemByMerchant(SmartList<TransportItem> resultList, String merchantTypeId, Map<String,Object> options);

 
  
 	public SmartList<TransportItem> findTransportItemByPlatform(String platformId, Map<String,Object> options);
 	public int countTransportItemByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countTransportItemByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportItem> findTransportItemByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportItemByPlatform(SmartList<TransportItem> resultList, String platformId, Map<String,Object> options);

 
 }


