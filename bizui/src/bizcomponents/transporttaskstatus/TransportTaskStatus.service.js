import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportTaskStatusManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportTaskStatusManager/loadTransportTaskStatus/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskStatusManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskStatusManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskStatusManager/addTransportTask/transportTaskStatusId/name/projectId/sourceId/destinationId/remark/senderId/receiverId/platformId/tokensExpr/`
  const transportTaskStatusId = targetObjectId
  const requestParameters = { ...parameters, transportTaskStatusId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskStatusManager/updateTransportTaskProperties/transportTaskStatusId/id/name/remark/tokensExpr/`
  const transportTaskStatusId = targetObjectId
  const requestParameters = { ...parameters, transportTaskStatusId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskStatusManager/removeTransportTaskList/transportTaskStatusId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, transportTaskStatusId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const TransportTaskStatusService = { view,
  load,
  addTransportTask,
  updateTransportTask,
  removeTransportTaskList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default TransportTaskStatusService

