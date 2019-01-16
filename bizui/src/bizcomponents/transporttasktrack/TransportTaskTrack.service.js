import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportTaskTrackManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportTaskTrackManager/loadTransportTaskTrack/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateTask = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskTrackManager/requestCandidateTask/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherTask = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskTrackManager/transferToAnotherTask/id/anotherTaskId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const TransportTaskTrackService = { view,
  load,
  requestCandidateTask,
  transferToAnotherTask }
export default TransportTaskTrackService

