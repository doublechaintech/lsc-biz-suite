

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
import styles from './TransportTask.dashboard.less'
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


const imageList =(transportTask)=>{return [
	 ]}

const internalImageListOf = (transportTask) =>defaultImageListOf(transportTask,imageList)

const optionList =(transportTask)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (transportTask) =>defaultSettingListOf(transportTask, optionList)
const internalLargeTextOf = (transportTask) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (transportTask,targetComponent) =>{
	
	
	const {TransportTaskService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{transportTask.id}</Description> 
<Description term="名称">{transportTask.name}</Description> 
<Description term="Source">{transportTask.source==null?"未分配":transportTask.source.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Source","location",TransportTaskService.requestCandidateSource,
	      TransportTaskService.transferToAnotherSource,"anotherSourceId",transportTask.source?transportTask.source.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Destination">{transportTask.destination==null?"未分配":transportTask.destination.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Destination","location",TransportTaskService.requestCandidateDestination,
	      TransportTaskService.transferToAnotherDestination,"anotherDestinationId",transportTask.destination?transportTask.destination.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Remark">{transportTask.remark}</Description> 
<Description term="Status">{transportTask.status==null?"未分配":transportTask.status.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Status","transportTaskStatus",TransportTaskService.requestCandidateStatus,
	      TransportTaskService.transferToAnotherStatus,"anotherStatusId",transportTask.status?transportTask.status.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Sender">{transportTask.sender==null?"未分配":transportTask.sender.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Sender","merchant",TransportTaskService.requestCandidateSender,
	      TransportTaskService.transferToAnotherSender,"anotherSenderId",transportTask.sender?transportTask.sender.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Receiver">{transportTask.receiver==null?"未分配":transportTask.receiver.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Receiver","merchant",TransportTaskService.requestCandidateReceiver,
	      TransportTaskService.transferToAnotherReceiver,"anotherReceiverId",transportTask.receiver?transportTask.receiver.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Create Time">{ moment(transportTask.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="Update Time">{ moment(transportTask.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(transportTask,targetComponent)}
      </DescriptionList>
	)

}


class TransportTaskDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'transportTask'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, transportTaskTrackListMetaInfo, transportTaskTrackCount } = this.props.transportTask
    if(!this.props.transportTask.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Transport Task",cardsFor: "transportTask",
    	cardsSource: this.props.transportTask,returnURL,displayName,
  		subItems: [
{name: 'transportTaskTrackList', displayName:'Transport Task Track',type:'transportTaskTrack',count:transportTaskTrackCount,addFunction: true, role: 'transportTaskTrack', metaInfo: transportTaskTrackListMetaInfo},
    
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
  transportTask: state._transportTask,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(TransportTaskDashboard))

