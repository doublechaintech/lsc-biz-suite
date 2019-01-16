

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
import styles from './Location.dashboard.less'
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


const imageList =(location)=>{return [
	 ]}

const internalImageListOf = (location) =>defaultImageListOf(location,imageList)

const optionList =(location)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (location) =>defaultSettingListOf(location, optionList)
const internalLargeTextOf = (location) =>{

	return(<div> 
   <Card title={`描述`} ><pre>{location.description}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (location,targetComponent) =>{
	
	
	const {LocationService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{location.id}</Description> 
<Description term="名称">{location.name}</Description> 
<Description term="联系人">{location.contactPerson}</Description> 
<Description term="联系电话">{location.contactPhone}</Description> 
<Description term="创建时间">{ moment(location.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="更新时间">{ moment(location.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(location,targetComponent)}
      </DescriptionList>
	)

}


class LocationDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'location'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, transportTaskListAsSourceMetaInfo, transportTaskListAsDestinationMetaInfo, transportTaskAsSourceCount, transportTaskAsDestinationCount } = this.props.location
    if(!this.props.location.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"位置",cardsFor: "location",
    	cardsSource: this.props.location,returnURL,displayName,
  		subItems: [
{name: 'transportTaskListAsSource', displayName:'运输任务(源)',type:'transportTask',count:transportTaskAsSourceCount,addFunction: true, role: 'transportTaskAsSource', metaInfo: transportTaskListAsSourceMetaInfo},
{name: 'transportTaskListAsDestination', displayName:'运输任务(目的地)',type:'transportTask',count:transportTaskAsDestinationCount,addFunction: true, role: 'transportTaskAsDestination', metaInfo: transportTaskListAsDestinationMetaInfo},
    
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
  location: state._location,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(LocationDashboard))

