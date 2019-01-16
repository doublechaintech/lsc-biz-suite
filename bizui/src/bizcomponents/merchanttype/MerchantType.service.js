import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}merchantTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}merchantTypeManager/loadMerchantType/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}merchantTypeManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}merchantTypeManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addMerchant = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantTypeManager/addMerchant/merchantTypeId/name/platformId/description/tokensExpr/`
  const merchantTypeId = targetObjectId
  const requestParameters = { ...parameters, merchantTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateMerchant = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantTypeManager/updateMerchantProperties/merchantTypeId/id/name/description/tokensExpr/`
  const merchantTypeId = targetObjectId
  const requestParameters = { ...parameters, merchantTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeMerchantList = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantTypeManager/removeMerchantList/merchantTypeId/merchantIds/tokensExpr/`
  const requestParameters = { ...parameters, merchantTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantTypeManager/addTransportItem/merchantTypeId/name/quantity/unit/projectId/platformId/tokensExpr/`
  const merchantTypeId = targetObjectId
  const requestParameters = { ...parameters, merchantTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantTypeManager/updateTransportItemProperties/merchantTypeId/id/name/quantity/unit/tokensExpr/`
  const merchantTypeId = targetObjectId
  const requestParameters = { ...parameters, merchantTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantTypeManager/removeTransportItemList/merchantTypeId/transportItemIds/tokensExpr/`
  const requestParameters = { ...parameters, merchantTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const MerchantTypeService = { view,
  load,
  addMerchant,
  addTransportItem,
  updateMerchant,
  updateTransportItem,
  removeMerchantList,
  removeTransportItemList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default MerchantTypeService

