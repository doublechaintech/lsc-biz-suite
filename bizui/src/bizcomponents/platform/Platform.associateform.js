import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './Platform.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import PlatformBase from './Platform.base'
import SelectObject from '../../components/SelectObject'


const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  name: '物流综合服务平台',
  introduction: '一个连通货主和司机的物流综合服务平台',
  currentVersion: 'V1.0',
}
*/


const imageKeys = [
]


class PlatformAssociateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
 
    
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
	const { form, dispatch, submitting, role,data,owner,toggleAssociatePaymentVisible,visible,onCancel, onCreate } = this.props
    const { convertedImagesValues } = this.state
    const {PlatformService} = GlobalComponents
 const {TransactionTypeModalTable} = GlobalComponents;
 const {MerchantTypeModalTable} = GlobalComponents;
 const {TransportTaskStatusModalTable} = GlobalComponents;
 const {LocationModalTable} = GlobalComponents;
 const {MerchantModalTable} = GlobalComponents;
 const {TransportProjectModalTable} = GlobalComponents;
 const {TransportItemModalTable} = GlobalComponents;
 const {TransportTaskModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = PlatformBase
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    

    
    
    const tryinit  = (fieldName, candidates) => {
      
      if(candidates&&candidates.length==1){
          return candidates[0].id
      }
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
    
    return (
 <Modal
          title="创建新的支付"
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
        <Card title="基础信息"  className={styles.card} style={{ backgroundColor:"#eee" }}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: '请输入名称' }],
                  })(
                    <Input placeholder="请输入名称" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.introduction} {...formItemLayout}>
                  {getFieldDecorator('introduction', {
                    rules: [{ required: true, message: '请输入Introduction' }],
                  })(
                    <Input placeholder="请输入Introduction" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.currentVersion} {...formItemLayout}>
                  {getFieldDecorator('currentVersion', {
                    rules: [{ required: true, message: '请输入Current Version' }],
                  })(
                    <Input placeholder="请输入Current Version" />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









			</Form>
			
			
			
			
        </Card>
        
	<TransactionTypeModalTable data={data.transactionTypeList} owner={owner} />
	<MerchantTypeModalTable data={data.merchantTypeList} owner={owner} />
	<TransportTaskStatusModalTable data={data.transportTaskStatusList} owner={owner} />
	<LocationModalTable data={data.locationList} owner={owner} />
	<MerchantModalTable data={data.merchantList} owner={owner} />
	<TransportProjectModalTable data={data.transportProjectList} owner={owner} />
	<TransportItemModalTable data={data.transportItemList} owner={owner} />
	<TransportTaskModalTable data={data.transportTaskList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(PlatformAssociateForm))




