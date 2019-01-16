import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}merchantManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}merchantManager/loadMerchant/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}merchantManager/requestCandidateType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherType = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}merchantManager/transferToAnotherType/id/anotherTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}merchantManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}merchantManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransportProject = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/addTransportProject/merchantId/name/platformId/tokensExpr/`
  const merchantId = targetObjectId
  const requestParameters = { ...parameters, merchantId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportProject = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/updateTransportProjectProperties/merchantId/id/name/tokensExpr/`
  const merchantId = targetObjectId
  const requestParameters = { ...parameters, merchantId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportProjectList = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/removeTransportProjectList/merchantId/transportProjectIds/tokensExpr/`
  const requestParameters = { ...parameters, merchantId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTaskAsSender = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/addTransportTaskAsSender/merchantId/name/sourceId/destinationId/remark/statusId/platformId/tokensExpr/`
  const merchantId = targetObjectId
  const requestParameters = { ...parameters, merchantId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTaskAsSender = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/updateTransportTaskAsSenderProperties/merchantId/id/name/remark/tokensExpr/`
  const merchantId = targetObjectId
  const requestParameters = { ...parameters, merchantId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskListAsSender = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/removeTransportTaskListAsSender/merchantId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, merchantId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTaskAsReceiver = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/addTransportTaskAsReceiver/merchantId/name/sourceId/destinationId/remark/statusId/platformId/tokensExpr/`
  const merchantId = targetObjectId
  const requestParameters = { ...parameters, merchantId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTaskAsReceiver = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/updateTransportTaskAsReceiverProperties/merchantId/id/name/remark/tokensExpr/`
  const merchantId = targetObjectId
  const requestParameters = { ...parameters, merchantId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskListAsReceiver = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/removeTransportTaskListAsReceiver/merchantId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, merchantId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addMerchantAccount = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/addMerchantAccount/merchantId/name/tokensExpr/`
  const merchantId = targetObjectId
  const requestParameters = { ...parameters, merchantId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateMerchantAccount = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/updateMerchantAccountProperties/merchantId/id/name/tokensExpr/`
  const merchantId = targetObjectId
  const requestParameters = { ...parameters, merchantId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeMerchantAccountList = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantManager/removeMerchantAccountList/merchantId/merchantAccountIds/tokensExpr/`
  const requestParameters = { ...parameters, merchantId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const MerchantService = { view,
  load,
  addTransportProject,
  addTransportTaskAsSender,
  addTransportTaskAsReceiver,
  addMerchantAccount,
  updateTransportProject,
  updateTransportTaskAsSender,
  updateTransportTaskAsReceiver,
  updateMerchantAccount,
  removeTransportProjectList,
  removeTransportTaskListAsSender,
  removeTransportTaskListAsReceiver,
  removeMerchantAccountList,
  requestCandidateType,
  requestCandidatePlatform,
  transferToAnotherType,
  transferToAnotherPlatform }
export default MerchantService

