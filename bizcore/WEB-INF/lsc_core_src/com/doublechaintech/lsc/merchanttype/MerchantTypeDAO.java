
package com.doublechaintech.lsc.merchanttype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.lsc.BaseEntity;
import com.doublechaintech.lsc.SmartList;
import com.doublechaintech.lsc.MultipleAccessKey;
import com.doublechaintech.lsc.LscUserContext;
import com.doublechaintech.lsc.merchant.MerchantDAO;
import com.doublechaintech.lsc.platform.PlatformDAO;
import com.doublechaintech.lsc.transportitem.TransportItemDAO;


public interface MerchantTypeDAO{

	
	public MerchantType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MerchantType> merchantTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public MerchantType present(MerchantType merchantType,Map<String,Object> options) throws Exception;
	public MerchantType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MerchantType save(MerchantType merchantType,Map<String,Object> options);
	public SmartList<MerchantType> saveMerchantTypeList(SmartList<MerchantType> merchantTypeList,Map<String,Object> options);
	public SmartList<MerchantType> removeMerchantTypeList(SmartList<MerchantType> merchantTypeList,Map<String,Object> options);
	public SmartList<MerchantType> findMerchantTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMerchantTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMerchantTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String merchantTypeId, int version) throws Exception;
	public MerchantType disconnectFromAll(String merchantTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public MerchantDAO getMerchantDAO();
		
	public TransportItemDAO getTransportItemDAO();
		
	
 	public SmartList<MerchantType> requestCandidateMerchantTypeForMerchant(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<MerchantType> requestCandidateMerchantTypeForTransportItem(LscUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public MerchantType planToRemoveMerchantList(MerchantType merchantType, String merchantIds[], Map<String,Object> options)throws Exception;


	//disconnect MerchantType with platform in Merchant
	public MerchantType planToRemoveMerchantListWithPlatform(MerchantType merchantType, String platformId, Map<String,Object> options)throws Exception;
	public int countMerchantListWithPlatform(String merchantTypeId, String platformId, Map<String,Object> options)throws Exception;
	
	public MerchantType planToRemoveTransportItemList(MerchantType merchantType, String transportItemIds[], Map<String,Object> options)throws Exception;


	//disconnect MerchantType with project in TransportItem
	public MerchantType planToRemoveTransportItemListWithProject(MerchantType merchantType, String projectId, Map<String,Object> options)throws Exception;
	public int countTransportItemListWithProject(String merchantTypeId, String projectId, Map<String,Object> options)throws Exception;
	
	//disconnect MerchantType with platform in TransportItem
	public MerchantType planToRemoveTransportItemListWithPlatform(MerchantType merchantType, String platformId, Map<String,Object> options)throws Exception;
	public int countTransportItemListWithPlatform(String merchantTypeId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<MerchantType> queryList(String sql, Object ... parmeters);
 
 	public SmartList<MerchantType> findMerchantTypeByPlatform(String platformId, Map<String,Object> options);
 	public int countMerchantTypeByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countMerchantTypeByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<MerchantType> findMerchantTypeByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeMerchantTypeByPlatform(SmartList<MerchantType> resultList, String platformId, Map<String,Object> options);

 
 }


