import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportTaskManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportTaskManager/loadTransportTask/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateProject = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateProject/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProject = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskManager/transferToAnotherProject/id/anotherProjectId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateSource = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateSource/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSource = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskManager/transferToAnotherSource/id/anotherSourceId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDestination = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateDestination/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDestination = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskManager/transferToAnotherDestination/id/anotherDestinationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateStatus = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateStatus/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherStatus = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskManager/transferToAnotherStatus/id/anotherStatusId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateSender = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateSender/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSender = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskManager/transferToAnotherSender/id/anotherSenderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateReceiver = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateReceiver/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherReceiver = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskManager/transferToAnotherReceiver/id/anotherReceiverId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransportTaskTrack = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/addTransportTaskTrack/transportTaskId/name/latitude/longitude/tokensExpr/`
  const transportTaskId = targetObjectId
  const requestParameters = { ...parameters, transportTaskId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTaskTrack = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/updateTransportTaskTrackProperties/transportTaskId/id/name/latitude/longitude/tokensExpr/`
  const transportTaskId = targetObjectId
  const requestParameters = { ...parameters, transportTaskId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskTrackList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/removeTransportTaskTrackList/transportTaskId/transportTaskTrackIds/tokensExpr/`
  const requestParameters = { ...parameters, transportTaskId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const TransportTaskService = { view,
  load,
  addTransportTaskTrack,
  updateTransportTaskTrack,
  removeTransportTaskTrackList,
  requestCandidateProject,
  requestCandidateSource,
  requestCandidateDestination,
  requestCandidateStatus,
  requestCandidateSender,
  requestCandidateReceiver,
  requestCandidatePlatform,
  transferToAnotherProject,
  transferToAnotherSource,
  transferToAnotherDestination,
  transferToAnotherStatus,
  transferToAnotherSender,
  transferToAnotherReceiver,
  transferToAnotherPlatform }
export default TransportTaskService

