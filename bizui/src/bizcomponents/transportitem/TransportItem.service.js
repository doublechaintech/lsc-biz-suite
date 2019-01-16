import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportItemManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportItemManager/loadTransportItem/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateProject = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportItemManager/requestCandidateProject/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProject = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportItemManager/transferToAnotherProject/id/anotherProjectId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateMerchant = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportItemManager/requestCandidateMerchant/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherMerchant = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportItemManager/transferToAnotherMerchant/id/anotherMerchantId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportItemManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportItemManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const TransportItemService = { view,
  load,
  requestCandidateProject,
  requestCandidateMerchant,
  requestCandidatePlatform,
  transferToAnotherProject,
  transferToAnotherMerchant,
  transferToAnotherPlatform }
export default TransportItemService

