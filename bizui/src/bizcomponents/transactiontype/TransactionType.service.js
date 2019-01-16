import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transactionTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transactionTypeManager/loadTransactionType/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transactionTypeManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transactionTypeManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransaction = (targetObjectId, parameters) => {
  const url = `${PREFIX}transactionTypeManager/addTransaction/transactionTypeId/name/amount/accountId/tokensExpr/`
  const transactionTypeId = targetObjectId
  const requestParameters = { ...parameters, transactionTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransaction = (targetObjectId, parameters) => {
  const url = `${PREFIX}transactionTypeManager/updateTransactionProperties/transactionTypeId/id/name/amount/tokensExpr/`
  const transactionTypeId = targetObjectId
  const requestParameters = { ...parameters, transactionTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransactionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transactionTypeManager/removeTransactionList/transactionTypeId/transactionIds/tokensExpr/`
  const requestParameters = { ...parameters, transactionTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const TransactionTypeService = { view,
  load,
  addTransaction,
  updateTransaction,
  removeTransactionList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default TransactionTypeService

