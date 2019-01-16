import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addTransactionType = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addTransactionType/platformId/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransactionType = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateTransactionTypeProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransactionTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeTransactionTypeList/platformId/transactionTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addMerchantType = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addMerchantType/platformId/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateMerchantType = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateMerchantTypeProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeMerchantTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeMerchantTypeList/platformId/merchantTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTaskStatus = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addTransportTaskStatus/platformId/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTaskStatus = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateTransportTaskStatusProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskStatusList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeTransportTaskStatusList/platformId/transportTaskStatusIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addLocation = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addLocation/platformId/name/contactPerson/contactPhone/description/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLocation = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateLocationProperties/platformId/id/name/contactPerson/contactPhone/description/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLocationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeLocationList/platformId/locationIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addMerchant = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addMerchant/platformId/name/typeId/description/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateMerchant = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateMerchantProperties/platformId/id/name/description/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeMerchantList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeMerchantList/platformId/merchantIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportProject = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addTransportProject/platformId/name/merchantId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportProject = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateTransportProjectProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportProjectList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeTransportProjectList/platformId/transportProjectIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addTransportItem/platformId/name/quantity/unit/projectId/merchantId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateTransportItemProperties/platformId/id/name/quantity/unit/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeTransportItemList/platformId/transportItemIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addTransportTask/platformId/name/projectId/sourceId/destinationId/remark/statusId/senderId/receiverId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateTransportTaskProperties/platformId/id/name/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeTransportTaskList/platformId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PlatformService = { view,
  load,
  addTransactionType,
  addMerchantType,
  addTransportTaskStatus,
  addLocation,
  addMerchant,
  addTransportProject,
  addTransportItem,
  addTransportTask,
  updateTransactionType,
  updateMerchantType,
  updateTransportTaskStatus,
  updateLocation,
  updateMerchant,
  updateTransportProject,
  updateTransportItem,
  updateTransportTask,
  removeTransactionTypeList,
  removeMerchantTypeList,
  removeTransportTaskStatusList,
  removeLocationList,
  removeMerchantList,
  removeTransportProjectList,
  removeTransportItemList,
  removeTransportTaskList }
export default PlatformService

