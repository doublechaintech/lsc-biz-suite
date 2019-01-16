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
import styles from './Platform.app.less'
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




class PlatformBizApp extends React.PureComponent {
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
      return ['/platform/']
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
               <Link to={`/platform/${this.props.platform.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/platform/${this.props.platform.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getTransactionTypeSearch = () => {
    const {TransactionTypeSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "交易类型",
      role: "transactionType",
      data: state._platform.transactionTypeList,
      metaInfo: state._platform.transactionTypeListMetaInfo,
      count: state._platform.transactionTypeCount,
      currentPage: state._platform.transactionTypeCurrentPageNumber,
      searchFormParameters: state._platform.transactionTypeSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'transactionTypeList', ref:state._platform, 
      listDisplayName: '交易类型列表' }, // this is for model namespace and
    }))(TransactionTypeSearch)
  }
  getTransactionTypeCreateForm = () => {
   	const {TransactionTypeCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transactionType",
      data: state._platform.transactionTypeList,
      metaInfo: state._platform.transactionTypeListMetaInfo,
      count: state._platform.transactionTypeCount,
      currentPage: state._platform.transactionTypeCurrentPageNumber,
      searchFormParameters: state._platform.transactionTypeSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'transactionTypeList', ref:state._platform, listDisplayName: '交易类型列表'}, // this is for model namespace and
    }))(TransactionTypeCreateForm)
  }
  
  getTransactionTypeUpdateForm = () => {
  	const {TransactionTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "transactionType",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'transactionTypeList', ref:state._platform, listDisplayName: '交易类型列表' }, // this is for model namespace and
    }))(TransactionTypeUpdateForm)
  }

  getMerchantTypeSearch = () => {
    const {MerchantTypeSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "商人类型",
      role: "merchantType",
      data: state._platform.merchantTypeList,
      metaInfo: state._platform.merchantTypeListMetaInfo,
      count: state._platform.merchantTypeCount,
      currentPage: state._platform.merchantTypeCurrentPageNumber,
      searchFormParameters: state._platform.merchantTypeSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'merchantTypeList', ref:state._platform, 
      listDisplayName: '商人类型列表' }, // this is for model namespace and
    }))(MerchantTypeSearch)
  }
  getMerchantTypeCreateForm = () => {
   	const {MerchantTypeCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "merchantType",
      data: state._platform.merchantTypeList,
      metaInfo: state._platform.merchantTypeListMetaInfo,
      count: state._platform.merchantTypeCount,
      currentPage: state._platform.merchantTypeCurrentPageNumber,
      searchFormParameters: state._platform.merchantTypeSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'merchantTypeList', ref:state._platform, listDisplayName: '商人类型列表'}, // this is for model namespace and
    }))(MerchantTypeCreateForm)
  }
  
  getMerchantTypeUpdateForm = () => {
  	const {MerchantTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "merchantType",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'merchantTypeList', ref:state._platform, listDisplayName: '商人类型列表' }, // this is for model namespace and
    }))(MerchantTypeUpdateForm)
  }

  getTransportTaskStatusSearch = () => {
    const {TransportTaskStatusSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "运输任务状态",
      role: "transportTaskStatus",
      data: state._platform.transportTaskStatusList,
      metaInfo: state._platform.transportTaskStatusListMetaInfo,
      count: state._platform.transportTaskStatusCount,
      currentPage: state._platform.transportTaskStatusCurrentPageNumber,
      searchFormParameters: state._platform.transportTaskStatusSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'transportTaskStatusList', ref:state._platform, 
      listDisplayName: '运输任务状态列表' }, // this is for model namespace and
    }))(TransportTaskStatusSearch)
  }
  getTransportTaskStatusCreateForm = () => {
   	const {TransportTaskStatusCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transportTaskStatus",
      data: state._platform.transportTaskStatusList,
      metaInfo: state._platform.transportTaskStatusListMetaInfo,
      count: state._platform.transportTaskStatusCount,
      currentPage: state._platform.transportTaskStatusCurrentPageNumber,
      searchFormParameters: state._platform.transportTaskStatusSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'transportTaskStatusList', ref:state._platform, listDisplayName: '运输任务状态列表'}, // this is for model namespace and
    }))(TransportTaskStatusCreateForm)
  }
  
  getTransportTaskStatusUpdateForm = () => {
  	const {TransportTaskStatusUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "transportTaskStatus",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'transportTaskStatusList', ref:state._platform, listDisplayName: '运输任务状态列表' }, // this is for model namespace and
    }))(TransportTaskStatusUpdateForm)
  }

  getLocationSearch = () => {
    const {LocationSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "位置",
      role: "location",
      data: state._platform.locationList,
      metaInfo: state._platform.locationListMetaInfo,
      count: state._platform.locationCount,
      currentPage: state._platform.locationCurrentPageNumber,
      searchFormParameters: state._platform.locationSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'locationList', ref:state._platform, 
      listDisplayName: '位置列表' }, // this is for model namespace and
    }))(LocationSearch)
  }
  getLocationCreateForm = () => {
   	const {LocationCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "location",
      data: state._platform.locationList,
      metaInfo: state._platform.locationListMetaInfo,
      count: state._platform.locationCount,
      currentPage: state._platform.locationCurrentPageNumber,
      searchFormParameters: state._platform.locationSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'locationList', ref:state._platform, listDisplayName: '位置列表'}, // this is for model namespace and
    }))(LocationCreateForm)
  }
  
  getLocationUpdateForm = () => {
  	const {LocationUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "location",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'locationList', ref:state._platform, listDisplayName: '位置列表' }, // this is for model namespace and
    }))(LocationUpdateForm)
  }

  getMerchantSearch = () => {
    const {MerchantSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "商人",
      role: "merchant",
      data: state._platform.merchantList,
      metaInfo: state._platform.merchantListMetaInfo,
      count: state._platform.merchantCount,
      currentPage: state._platform.merchantCurrentPageNumber,
      searchFormParameters: state._platform.merchantSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'merchantList', ref:state._platform, 
      listDisplayName: '商人列表' }, // this is for model namespace and
    }))(MerchantSearch)
  }
  getMerchantCreateForm = () => {
   	const {MerchantCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "merchant",
      data: state._platform.merchantList,
      metaInfo: state._platform.merchantListMetaInfo,
      count: state._platform.merchantCount,
      currentPage: state._platform.merchantCurrentPageNumber,
      searchFormParameters: state._platform.merchantSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'merchantList', ref:state._platform, listDisplayName: '商人列表'}, // this is for model namespace and
    }))(MerchantCreateForm)
  }
  
  getMerchantUpdateForm = () => {
  	const {MerchantUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "merchant",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'merchantList', ref:state._platform, listDisplayName: '商人列表' }, // this is for model namespace and
    }))(MerchantUpdateForm)
  }

  getTransportProjectSearch = () => {
    const {TransportProjectSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "交通项目",
      role: "transportProject",
      data: state._platform.transportProjectList,
      metaInfo: state._platform.transportProjectListMetaInfo,
      count: state._platform.transportProjectCount,
      currentPage: state._platform.transportProjectCurrentPageNumber,
      searchFormParameters: state._platform.transportProjectSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'transportProjectList', ref:state._platform, 
      listDisplayName: '交通项目列表' }, // this is for model namespace and
    }))(TransportProjectSearch)
  }
  getTransportProjectCreateForm = () => {
   	const {TransportProjectCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transportProject",
      data: state._platform.transportProjectList,
      metaInfo: state._platform.transportProjectListMetaInfo,
      count: state._platform.transportProjectCount,
      currentPage: state._platform.transportProjectCurrentPageNumber,
      searchFormParameters: state._platform.transportProjectSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'transportProjectList', ref:state._platform, listDisplayName: '交通项目列表'}, // this is for model namespace and
    }))(TransportProjectCreateForm)
  }
  
  getTransportProjectUpdateForm = () => {
  	const {TransportProjectUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "transportProject",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'transportProjectList', ref:state._platform, listDisplayName: '交通项目列表' }, // this is for model namespace and
    }))(TransportProjectUpdateForm)
  }

  getTransportItemSearch = () => {
    const {TransportItemSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "运输项目",
      role: "transportItem",
      data: state._platform.transportItemList,
      metaInfo: state._platform.transportItemListMetaInfo,
      count: state._platform.transportItemCount,
      currentPage: state._platform.transportItemCurrentPageNumber,
      searchFormParameters: state._platform.transportItemSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'transportItemList', ref:state._platform, 
      listDisplayName: '运输项目列表' }, // this is for model namespace and
    }))(TransportItemSearch)
  }
  getTransportItemCreateForm = () => {
   	const {TransportItemCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transportItem",
      data: state._platform.transportItemList,
      metaInfo: state._platform.transportItemListMetaInfo,
      count: state._platform.transportItemCount,
      currentPage: state._platform.transportItemCurrentPageNumber,
      searchFormParameters: state._platform.transportItemSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'transportItemList', ref:state._platform, listDisplayName: '运输项目列表'}, // this is for model namespace and
    }))(TransportItemCreateForm)
  }
  
  getTransportItemUpdateForm = () => {
  	const {TransportItemUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "transportItem",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'transportItemList', ref:state._platform, listDisplayName: '运输项目列表' }, // this is for model namespace and
    }))(TransportItemUpdateForm)
  }

  getTransportTaskSearch = () => {
    const {TransportTaskSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "运输任务",
      role: "transportTask",
      data: state._platform.transportTaskList,
      metaInfo: state._platform.transportTaskListMetaInfo,
      count: state._platform.transportTaskCount,
      currentPage: state._platform.transportTaskCurrentPageNumber,
      searchFormParameters: state._platform.transportTaskSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'transportTaskList', ref:state._platform, 
      listDisplayName: '运输任务列表' }, // this is for model namespace and
    }))(TransportTaskSearch)
  }
  getTransportTaskCreateForm = () => {
   	const {TransportTaskCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transportTask",
      data: state._platform.transportTaskList,
      metaInfo: state._platform.transportTaskListMetaInfo,
      count: state._platform.transportTaskCount,
      currentPage: state._platform.transportTaskCurrentPageNumber,
      searchFormParameters: state._platform.transportTaskSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'transportTaskList', ref:state._platform, listDisplayName: '运输任务列表'}, // this is for model namespace and
    }))(TransportTaskCreateForm)
  }
  
  getTransportTaskUpdateForm = () => {
  	const {TransportTaskUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "transportTask",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'transportTaskList', ref:state._platform, listDisplayName: '运输任务列表' }, // this is for model namespace and
    }))(TransportTaskUpdateForm)
  }


  
  buildRouters = () =>{
  	const {PlatformDashboard} = GlobalComponents
  	const {PlatformPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/platform/:id/dashboard", component: PlatformDashboard},
  	{path:"/platform/:id/preference", component: PlatformPreference},
  	
  	
  	
  	{path:"/platform/:id/list/transactionTypeList", component: this.getTransactionTypeSearch()},
  	{path:"/platform/:id/list/transactionTypeCreateForm", component: this.getTransactionTypeCreateForm()},
  	{path:"/platform/:id/list/transactionTypeUpdateForm", component: this.getTransactionTypeUpdateForm()},
   	
  	{path:"/platform/:id/list/merchantTypeList", component: this.getMerchantTypeSearch()},
  	{path:"/platform/:id/list/merchantTypeCreateForm", component: this.getMerchantTypeCreateForm()},
  	{path:"/platform/:id/list/merchantTypeUpdateForm", component: this.getMerchantTypeUpdateForm()},
   	
  	{path:"/platform/:id/list/transportTaskStatusList", component: this.getTransportTaskStatusSearch()},
  	{path:"/platform/:id/list/transportTaskStatusCreateForm", component: this.getTransportTaskStatusCreateForm()},
  	{path:"/platform/:id/list/transportTaskStatusUpdateForm", component: this.getTransportTaskStatusUpdateForm()},
   	
  	{path:"/platform/:id/list/locationList", component: this.getLocationSearch()},
  	{path:"/platform/:id/list/locationCreateForm", component: this.getLocationCreateForm()},
  	{path:"/platform/:id/list/locationUpdateForm", component: this.getLocationUpdateForm()},
   	
  	{path:"/platform/:id/list/merchantList", component: this.getMerchantSearch()},
  	{path:"/platform/:id/list/merchantCreateForm", component: this.getMerchantCreateForm()},
  	{path:"/platform/:id/list/merchantUpdateForm", component: this.getMerchantUpdateForm()},
   	
  	{path:"/platform/:id/list/transportProjectList", component: this.getTransportProjectSearch()},
  	{path:"/platform/:id/list/transportProjectCreateForm", component: this.getTransportProjectCreateForm()},
  	{path:"/platform/:id/list/transportProjectUpdateForm", component: this.getTransportProjectUpdateForm()},
   	
  	{path:"/platform/:id/list/transportItemList", component: this.getTransportItemSearch()},
  	{path:"/platform/:id/list/transportItemCreateForm", component: this.getTransportItemCreateForm()},
  	{path:"/platform/:id/list/transportItemUpdateForm", component: this.getTransportItemUpdateForm()},
   	
  	{path:"/platform/:id/list/transportTaskList", component: this.getTransportTaskSearch()},
  	{path:"/platform/:id/list/transportTaskCreateForm", component: this.getTransportTaskCreateForm()},
  	{path:"/platform/:id/list/transportTaskUpdateForm", component: this.getTransportTaskUpdateForm()},
     	
  	
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

     //const {PlatformEditDetail} = GlobalComponents
     //const {PlatformViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.platform)}
		 
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
  platform: state._platform,
  ...state,
}))(PlatformBizApp)



