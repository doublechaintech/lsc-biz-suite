import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportProjectManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportProjectManager/loadTransportProject/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateMerchant = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportProjectManager/requestCandidateMerchant/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherMerchant = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportProjectManager/transferToAnotherMerchant/id/anotherMerchantId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportProjectManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportProjectManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransportItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportProjectManager/addTransportItem/transportProjectId/name/quantity/unit/merchantId/platformId/tokensExpr/`
  const transportProjectId = targetObjectId
  const requestParameters = { ...parameters, transportProjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportProjectManager/updateTransportItemProperties/transportProjectId/id/name/quantity/unit/tokensExpr/`
  const transportProjectId = targetObjectId
  const requestParameters = { ...parameters, transportProjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportProjectManager/removeTransportItemList/transportProjectId/transportItemIds/tokensExpr/`
  const requestParameters = { ...parameters, transportProjectId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportProjectManager/addTransportTask/transportProjectId/name/sourceId/destinationId/remark/statusId/senderId/receiverId/platformId/tokensExpr/`
  const transportProjectId = targetObjectId
  const requestParameters = { ...parameters, transportProjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportProjectManager/updateTransportTaskProperties/transportProjectId/id/name/remark/tokensExpr/`
  const transportProjectId = targetObjectId
  const requestParameters = { ...parameters, transportProjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportProjectManager/removeTransportTaskList/transportProjectId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, transportProjectId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const TransportProjectService = { view,
  load,
  addTransportItem,
  addTransportTask,
  updateTransportItem,
  updateTransportTask,
  removeTransportItemList,
  removeTransportTaskList,
  requestCandidateMerchant,
  requestCandidatePlatform,
  transferToAnotherMerchant,
  transferToAnotherPlatform }
export default TransportProjectService

