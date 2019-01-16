import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}locationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}locationManager/loadLocation/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}locationManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}locationManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransportTaskAsSource = (targetObjectId, parameters) => {
  const url = `${PREFIX}locationManager/addTransportTaskAsSource/locationId/name/remark/statusId/senderId/receiverId/platformId/tokensExpr/`
  const locationId = targetObjectId
  const requestParameters = { ...parameters, locationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTaskAsSource = (targetObjectId, parameters) => {
  const url = `${PREFIX}locationManager/updateTransportTaskAsSourceProperties/locationId/id/name/remark/tokensExpr/`
  const locationId = targetObjectId
  const requestParameters = { ...parameters, locationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskListAsSource = (targetObjectId, parameters) => {
  const url = `${PREFIX}locationManager/removeTransportTaskListAsSource/locationId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, locationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTaskAsDestination = (targetObjectId, parameters) => {
  const url = `${PREFIX}locationManager/addTransportTaskAsDestination/locationId/name/remark/statusId/senderId/receiverId/platformId/tokensExpr/`
  const locationId = targetObjectId
  const requestParameters = { ...parameters, locationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTaskAsDestination = (targetObjectId, parameters) => {
  const url = `${PREFIX}locationManager/updateTransportTaskAsDestinationProperties/locationId/id/name/remark/tokensExpr/`
  const locationId = targetObjectId
  const requestParameters = { ...parameters, locationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskListAsDestination = (targetObjectId, parameters) => {
  const url = `${PREFIX}locationManager/removeTransportTaskListAsDestination/locationId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, locationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const LocationService = { view,
  load,
  addTransportTaskAsSource,
  addTransportTaskAsDestination,
  updateTransportTaskAsSource,
  updateTransportTaskAsDestination,
  removeTransportTaskListAsSource,
  removeTransportTaskListAsDestination,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default LocationService

