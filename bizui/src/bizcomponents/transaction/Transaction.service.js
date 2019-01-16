import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transactionManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transactionManager/loadTransaction/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateTransactionType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transactionManager/requestCandidateTransactionType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherTransactionType = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transactionManager/transferToAnotherTransactionType/id/anotherTransactionTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateAccount = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transactionManager/requestCandidateAccount/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAccount = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transactionManager/transferToAnotherAccount/id/anotherAccountId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const TransactionService = { view,
  load,
  requestCandidateTransactionType,
  requestCandidateAccount,
  transferToAnotherTransactionType,
  transferToAnotherAccount }
export default TransactionService

