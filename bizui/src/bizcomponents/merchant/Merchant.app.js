import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Merchant.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'

const  {  filterForMenuPermission } = PermissionSettingService

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true
}

const filteredMenuItems = (targetObject, targetComponent) => {
    const menuData = sessionObject('menuData')
    const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||isMenuItemForDisplay
    return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
}



const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class MerchantBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
    // 把一级 Layout 的 children 作为菜单项
    // this.menus = getNavData().reduce((arr, current) => arr.concat(current.children), [])
    this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/merchant/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/merchant/${this.props.merchant.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>回到主页</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}列表`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/merchant/${this.props.merchant.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getTransportProjectSearch = () => {
    const {TransportProjectSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "Transport Project",
      role: "transportProject",
      data: state._merchant.transportProjectList,
      metaInfo: state._merchant.transportProjectListMetaInfo,
      count: state._merchant.transportProjectCount,
      currentPage: state._merchant.transportProjectCurrentPageNumber,
      searchFormParameters: state._merchant.transportProjectSearchFormParameters,
      searchParameters: {...state._merchant.searchParameters},
      expandForm: state._merchant.expandForm,
      loading: state._merchant.loading,
      partialList: state._merchant.partialList,
      owner: { type: '_merchant', id: state._merchant.id, 
      referenceName: 'merchant', 
      listName: 'transportProjectList', ref:state._merchant, 
      listDisplayName: 'Transport Project列表' }, // this is for model namespace and
    }))(TransportProjectSearch)
  }
  getTransportProjectCreateForm = () => {
   	const {TransportProjectCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transportProject",
      data: state._merchant.transportProjectList,
      metaInfo: state._merchant.transportProjectListMetaInfo,
      count: state._merchant.transportProjectCount,
      currentPage: state._merchant.transportProjectCurrentPageNumber,
      searchFormParameters: state._merchant.transportProjectSearchFormParameters,
      loading: state._merchant.loading,
      owner: { type: '_merchant', id: state._merchant.id, referenceName: 'merchant', listName: 'transportProjectList', ref:state._merchant, listDisplayName: 'Transport Project列表'}, // this is for model namespace and
    }))(TransportProjectCreateForm)
  }
  
  getTransportProjectUpdateForm = () => {
  	const {TransportProjectUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._merchant.selectedRows,
      role: "transportProject",
      currentUpdateIndex: state._merchant.currentUpdateIndex,
      owner: { type: '_merchant', id: state._merchant.id, listName: 'transportProjectList', ref:state._merchant, listDisplayName: 'Transport Project列表' }, // this is for model namespace and
    }))(TransportProjectUpdateForm)
  }

  getTransportTaskAsSenderSearch = () => {
    const {TransportTaskSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "Transport Task(Sender)",
      role: "transportTaskAsSender",
      data: state._merchant.transportTaskListAsSender,
      metaInfo: state._merchant.transportTaskListAsSenderMetaInfo,
      count: state._merchant.transportTaskAsSenderCount,
      currentPage: state._merchant.transportTaskAsSenderCurrentPageNumber,
      searchFormParameters: state._merchant.transportTaskAsSenderSearchFormParameters,
      searchParameters: {...state._merchant.searchParameters},
      expandForm: state._merchant.expandForm,
      loading: state._merchant.loading,
      partialList: state._merchant.partialList,
      owner: { type: '_merchant', id: state._merchant.id, 
      referenceName: 'sender', 
      listName: 'transportTaskListAsSender', ref:state._merchant, 
      listDisplayName: 'Transport Task(Sender)列表' }, // this is for model namespace and
    }))(TransportTaskSearch)
  }
  getTransportTaskAsSenderCreateForm = () => {
   	const {TransportTaskCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transportTaskAsSender",
      data: state._merchant.transportTaskListAsSender,
      metaInfo: state._merchant.transportTaskListAsSenderMetaInfo,
      count: state._merchant.transportTaskAsSenderCount,
      currentPage: state._merchant.transportTaskAsSenderCurrentPageNumber,
      searchFormParameters: state._merchant.transportTaskAsSenderSearchFormParameters,
      loading: state._merchant.loading,
      owner: { type: '_merchant', id: state._merchant.id, referenceName: 'sender', listName: 'transportTaskListAsSender', ref:state._merchant, listDisplayName: 'Transport Task列表'}, // this is for model namespace and
    }))(TransportTaskCreateForm)
  }
  
  getTransportTaskAsSenderUpdateForm = () => {
  	const {TransportTaskUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._merchant.selectedRows,
      role: "transportTaskAsSender",
      currentUpdateIndex: state._merchant.currentUpdateIndex,
      owner: { type: '_merchant', id: state._merchant.id, listName: 'transportTaskListAsSender', ref:state._merchant, listDisplayName: 'Transport Task列表' }, // this is for model namespace and
    }))(TransportTaskUpdateForm)
  }

  getTransportTaskAsReceiverSearch = () => {
    const {TransportTaskSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "Transport Task(Receiver)",
      role: "transportTaskAsReceiver",
      data: state._merchant.transportTaskListAsReceiver,
      metaInfo: state._merchant.transportTaskListAsReceiverMetaInfo,
      count: state._merchant.transportTaskAsReceiverCount,
      currentPage: state._merchant.transportTaskAsReceiverCurrentPageNumber,
      searchFormParameters: state._merchant.transportTaskAsReceiverSearchFormParameters,
      searchParameters: {...state._merchant.searchParameters},
      expandForm: state._merchant.expandForm,
      loading: state._merchant.loading,
      partialList: state._merchant.partialList,
      owner: { type: '_merchant', id: state._merchant.id, 
      referenceName: 'receiver', 
      listName: 'transportTaskListAsReceiver', ref:state._merchant, 
      listDisplayName: 'Transport Task(Receiver)列表' }, // this is for model namespace and
    }))(TransportTaskSearch)
  }
  getTransportTaskAsReceiverCreateForm = () => {
   	const {TransportTaskCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transportTaskAsReceiver",
      data: state._merchant.transportTaskListAsReceiver,
      metaInfo: state._merchant.transportTaskListAsReceiverMetaInfo,
      count: state._merchant.transportTaskAsReceiverCount,
      currentPage: state._merchant.transportTaskAsReceiverCurrentPageNumber,
      searchFormParameters: state._merchant.transportTaskAsReceiverSearchFormParameters,
      loading: state._merchant.loading,
      owner: { type: '_merchant', id: state._merchant.id, referenceName: 'receiver', listName: 'transportTaskListAsReceiver', ref:state._merchant, listDisplayName: 'Transport Task列表'}, // this is for model namespace and
    }))(TransportTaskCreateForm)
  }
  
  getTransportTaskAsReceiverUpdateForm = () => {
  	const {TransportTaskUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._merchant.selectedRows,
      role: "transportTaskAsReceiver",
      currentUpdateIndex: state._merchant.currentUpdateIndex,
      owner: { type: '_merchant', id: state._merchant.id, listName: 'transportTaskListAsReceiver', ref:state._merchant, listDisplayName: 'Transport Task列表' }, // this is for model namespace and
    }))(TransportTaskUpdateForm)
  }

  getMerchantAccountSearch = () => {
    const {MerchantAccountSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "Merchant Account",
      role: "merchantAccount",
      data: state._merchant.merchantAccountList,
      metaInfo: state._merchant.merchantAccountListMetaInfo,
      count: state._merchant.merchantAccountCount,
      currentPage: state._merchant.merchantAccountCurrentPageNumber,
      searchFormParameters: state._merchant.merchantAccountSearchFormParameters,
      searchParameters: {...state._merchant.searchParameters},
      expandForm: state._merchant.expandForm,
      loading: state._merchant.loading,
      partialList: state._merchant.partialList,
      owner: { type: '_merchant', id: state._merchant.id, 
      referenceName: 'merchant', 
      listName: 'merchantAccountList', ref:state._merchant, 
      listDisplayName: 'Merchant Account列表' }, // this is for model namespace and
    }))(MerchantAccountSearch)
  }
  getMerchantAccountCreateForm = () => {
   	const {MerchantAccountCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "merchantAccount",
      data: state._merchant.merchantAccountList,
      metaInfo: state._merchant.merchantAccountListMetaInfo,
      count: state._merchant.merchantAccountCount,
      currentPage: state._merchant.merchantAccountCurrentPageNumber,
      searchFormParameters: state._merchant.merchantAccountSearchFormParameters,
      loading: state._merchant.loading,
      owner: { type: '_merchant', id: state._merchant.id, referenceName: 'merchant', listName: 'merchantAccountList', ref:state._merchant, listDisplayName: 'Merchant Account列表'}, // this is for model namespace and
    }))(MerchantAccountCreateForm)
  }
  
  getMerchantAccountUpdateForm = () => {
  	const {MerchantAccountUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._merchant.selectedRows,
      role: "merchantAccount",
      currentUpdateIndex: state._merchant.currentUpdateIndex,
      owner: { type: '_merchant', id: state._merchant.id, listName: 'merchantAccountList', ref:state._merchant, listDisplayName: 'Merchant Account列表' }, // this is for model namespace and
    }))(MerchantAccountUpdateForm)
  }


  
  buildRouters = () =>{
  	const {MerchantDashboard} = GlobalComponents
  	const {MerchantPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/merchant/:id/dashboard", component: MerchantDashboard},
  	{path:"/merchant/:id/preference", component: MerchantPreference},
  	
  	
  	
  	{path:"/merchant/:id/list/transportProjectList", component: this.getTransportProjectSearch()},
  	{path:"/merchant/:id/list/transportProjectCreateForm", component: this.getTransportProjectCreateForm()},
  	{path:"/merchant/:id/list/transportProjectUpdateForm", component: this.getTransportProjectUpdateForm()},
   	
  	{path:"/merchant/:id/list/transportTaskListAsSender", component: this.getTransportTaskAsSenderSearch()},
  	{path:"/merchant/:id/list/transportTaskAsSenderCreateForm", component: this.getTransportTaskAsSenderCreateForm()},
  	{path:"/merchant/:id/list/transportTaskAsSenderUpdateForm", component: this.getTransportTaskAsSenderUpdateForm()},
   	
  	{path:"/merchant/:id/list/transportTaskListAsReceiver", component: this.getTransportTaskAsReceiverSearch()},
  	{path:"/merchant/:id/list/transportTaskAsReceiverCreateForm", component: this.getTransportTaskAsReceiverCreateForm()},
  	{path:"/merchant/:id/list/transportTaskAsReceiverUpdateForm", component: this.getTransportTaskAsReceiverUpdateForm()},
   	
  	{path:"/merchant/:id/list/merchantAccountList", component: this.getMerchantAccountSearch()},
  	{path:"/merchant/:id/list/merchantAccountCreateForm", component: this.getMerchantAccountCreateForm()},
  	{path:"/merchant/:id/list/merchantAccountUpdateForm", component: this.getMerchantAccountUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '物流综合服务平台'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     const { breadcrumb }  = this.props

     //const {MerchantEditDetail} = GlobalComponents
     //const {MerchantViewDetail} = GlobalComponents
     
     
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     
     
     // Don't show popup menu when it is been collapsed
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          />
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}> &gt;{item.name}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          退出</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.merchant)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  merchant: state._merchant,
  ...state,
}))(MerchantBizApp)



