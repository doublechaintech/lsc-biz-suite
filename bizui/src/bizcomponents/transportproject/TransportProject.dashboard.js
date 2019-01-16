

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './TransportProject.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'


const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(transportProject)=>{return [
	 ]}

const internalImageListOf = (transportProject) =>defaultImageListOf(transportProject,imageList)

const optionList =(transportProject)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (transportProject) =>defaultSettingListOf(transportProject, optionList)
const internalLargeTextOf = (transportProject) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (transportProject,targetComponent) =>{
	
	
	const {TransportProjectService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{transportProject.id}</Description> 
<Description term="名称">{transportProject.name}</Description> 
<Description term="商人">{transportProject.merchant==null?"未分配":transportProject.merchant.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"商人","merchant",TransportProjectService.requestCandidateMerchant,
	      TransportProjectService.transferToAnotherMerchant,"anotherMerchantId",transportProject.merchant?transportProject.merchant.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="创建时间">{ moment(transportProject.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="更新时间">{ moment(transportProject.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(transportProject,targetComponent)}
      </DescriptionList>
	)

}


class TransportProjectDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'transportProject'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, transportItemListMetaInfo, transportTaskListMetaInfo, transportItemCount, transportTaskCount } = this.props.transportProject
    if(!this.props.transportProject.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"交通项目",cardsFor: "transportProject",
    	cardsSource: this.props.transportProject,returnURL,displayName,
  		subItems: [
{name: 'transportItemList', displayName:'运输项目',type:'transportItem',count:transportItemCount,addFunction: true, role: 'transportItem', metaInfo: transportItemListMetaInfo},
{name: 'transportTaskList', displayName:'运输任务',type:'transportTask',count:transportTaskCount,addFunction: true, role: 'transportTask', metaInfo: transportTaskListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  transportProject: state._transportProject,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(TransportProjectDashboard))

