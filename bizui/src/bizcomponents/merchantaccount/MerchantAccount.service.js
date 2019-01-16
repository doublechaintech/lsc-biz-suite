import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}merchantAccountManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}merchantAccountManager/loadMerchantAccount/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateMerchant = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}merchantAccountManager/requestCandidateMerchant/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherMerchant = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}merchantAccountManager/transferToAnotherMerchant/id/anotherMerchantId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransaction = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantAccountManager/addTransaction/merchantAccountId/name/amount/transactionTypeId/tokensExpr/`
  const merchantAccountId = targetObjectId
  const requestParameters = { ...parameters, merchantAccountId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransaction = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantAccountManager/updateTransactionProperties/merchantAccountId/id/name/amount/tokensExpr/`
  const merchantAccountId = targetObjectId
  const requestParameters = { ...parameters, merchantAccountId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransactionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}merchantAccountManager/removeTransactionList/merchantAccountId/transactionIds/tokensExpr/`
  const requestParameters = { ...parameters, merchantAccountId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const MerchantAccountService = { view,
  load,
  addTransaction,
  updateTransaction,
  removeTransactionList,
  requestCandidateMerchant,
  transferToAnotherMerchant }
export default MerchantAccountService

