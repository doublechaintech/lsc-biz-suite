

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
import styles from './Merchant.dashboard.less'
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


const imageList =(merchant)=>{return [
	 ]}

const internalImageListOf = (merchant) =>defaultImageListOf(merchant,imageList)

const optionList =(merchant)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (merchant) =>defaultSettingListOf(merchant, optionList)
const internalLargeTextOf = (merchant) =>{

	return(<div> 
   <Card title={`描述`} ><pre>{merchant.description}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (merchant,targetComponent) =>{
	
	
	const {MerchantService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{merchant.id}</Description> 
<Description term="名称">{merchant.name}</Description> 
<Description term="类型">{merchant.type==null?"未分配":merchant.type.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"类型","merchantType",MerchantService.requestCandidateType,
	      MerchantService.transferToAnotherType,"anotherTypeId",merchant.type?merchant.type.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Create Time">{ moment(merchant.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="Update Time">{ moment(merchant.updateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(merchant,targetComponent)}
      </DescriptionList>
	)

}


class MerchantDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'merchant'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, transportProjectListMetaInfo, transportTaskListAsSenderMetaInfo, transportTaskListAsReceiverMetaInfo, merchantAccountListMetaInfo, transportProjectCount, transportTaskAsSenderCount, transportTaskAsReceiverCount, merchantAccountCount } = this.props.merchant
    if(!this.props.merchant.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Merchant",cardsFor: "merchant",
    	cardsSource: this.props.merchant,returnURL,displayName,
  		subItems: [
{name: 'transportProjectList', displayName:'Transport Project',type:'transportProject',count:transportProjectCount,addFunction: true, role: 'transportProject', metaInfo: transportProjectListMetaInfo},
{name: 'transportTaskListAsSender', displayName:'Transport Task(Sender)',type:'transportTask',count:transportTaskAsSenderCount,addFunction: true, role: 'transportTaskAsSender', metaInfo: transportTaskListAsSenderMetaInfo},
{name: 'transportTaskListAsReceiver', displayName:'Transport Task(Receiver)',type:'transportTask',count:transportTaskAsReceiverCount,addFunction: true, role: 'transportTaskAsReceiver', metaInfo: transportTaskListAsReceiverMetaInfo},
{name: 'merchantAccountList', displayName:'Merchant Account',type:'merchantAccount',count:merchantAccountCount,addFunction: true, role: 'merchantAccount', metaInfo: merchantAccountListMetaInfo},
    
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
  merchant: state._merchant,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(MerchantDashboard))

