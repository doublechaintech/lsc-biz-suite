

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
import styles from './TransportTaskTrack.dashboard.less'
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


const imageList =(transportTaskTrack)=>{return [
	 ]}

const internalImageListOf = (transportTaskTrack) =>defaultImageListOf(transportTaskTrack,imageList)

const optionList =(transportTaskTrack)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (transportTaskTrack) =>defaultSettingListOf(transportTaskTrack, optionList)
const internalLargeTextOf = (transportTaskTrack) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (transportTaskTrack,targetComponent) =>{
	
	
	const {TransportTaskTrackService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{transportTaskTrack.id}</Description> 
<Description term="名称">{transportTaskTrack.name}</Description> 
<Description term="Latitude">{transportTaskTrack.latitude}</Description> 
<Description term="Longitude">{transportTaskTrack.longitude}</Description> 
<Description term="Task">{transportTaskTrack.task==null?"未分配":transportTaskTrack.task.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Task","transportTask",TransportTaskTrackService.requestCandidateTask,
	      TransportTaskTrackService.transferToAnotherTask,"anotherTaskId",transportTaskTrack.task?transportTaskTrack.task.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Create Time">{ moment(transportTaskTrack.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="Update Time">{ moment(transportTaskTrack.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(transportTaskTrack,targetComponent)}
      </DescriptionList>
	)

}


class TransportTaskTrackDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'transportTaskTrack'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.transportTaskTrack
    if(!this.props.transportTaskTrack.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Transport Task Track",cardsFor: "transportTaskTrack",
    	cardsSource: this.props.transportTaskTrack,returnURL,displayName,
  		subItems: [
    
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
  transportTaskTrack: state._transportTaskTrack,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(TransportTaskTrackDashboard))

