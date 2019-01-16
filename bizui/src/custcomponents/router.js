

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { LocaleProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {PlatformBizApp} = GlobalComponents
	const {TransactionTypeBizApp} = GlobalComponents
	const {MerchantTypeBizApp} = GlobalComponents
	const {TransportTaskStatusBizApp} = GlobalComponents
	const {LocationBizApp} = GlobalComponents
	const {MerchantBizApp} = GlobalComponents
	const {TransportProjectBizApp} = GlobalComponents
	const {TransportItemBizApp} = GlobalComponents
	const {TransportTaskBizApp} = GlobalComponents
	const {TransportTaskTrackBizApp} = GlobalComponents
	const {MerchantAccountBizApp} = GlobalComponents
	const {TransactionBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {SecUserBlockingBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents



  return (
    <LocaleProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
         <Route path="/home" component={Launcher} />
         <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/platform/" component={PlatformBizApp} />
          <Route path="/transactionType/" component={TransactionTypeBizApp} />
          <Route path="/merchantType/" component={MerchantTypeBizApp} />
          <Route path="/transportTaskStatus/" component={TransportTaskStatusBizApp} />
          <Route path="/location/" component={LocationBizApp} />
          <Route path="/merchant/" component={MerchantBizApp} />
          <Route path="/transportProject/" component={TransportProjectBizApp} />
          <Route path="/transportItem/" component={TransportItemBizApp} />
          <Route path="/transportTask/" component={TransportTaskBizApp} />
          <Route path="/transportTaskTrack/" component={TransportTaskTrackBizApp} />
          <Route path="/merchantAccount/" component={MerchantAccountBizApp} />
          <Route path="/transaction/" component={TransactionBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/secUserBlocking/" component={SecUserBlockingBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
         <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </LocaleProvider>
  )
}

export default RouterConfig










