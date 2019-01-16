import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './TransportTask.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import TransportTaskBase from './TransportTask.base'
import SelectObject from '../../components/SelectObject'


const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  name: '橡胶运输任务',
  remark: '在二号通道',
  sourceId: 'L000001',
  destinationId: 'L000001',
  statusId: 'TTS000001',
  senderId: 'M000001',
  receiverId: 'M000001',
  platformId: 'P000001',
}
*/


const imageKeys = [
]


class TransportTaskAssociateForm extends Component {
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
    const {TransportTaskService} = GlobalComponents
 const {TransportTaskTrackModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = TransportTaskBase
    
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
                <Form.Item label={fieldLabels.remark} {...formItemLayout}>
                  {getFieldDecorator('remark', {
                    rules: [{ required: true, message: '请输入备注' }],
                  })(
                    <Input placeholder="请输入备注" />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.source} {...formItemLayout}>
                  {getFieldDecorator('sourceId', {
                  	initialValue: tryinit('source'),
                    rules: [{ required: true, message: '请输入源' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('source')}
                    targetType={"source"} 
                    requestFunction={TransportTaskService.requestCandidateSource}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.destination} {...formItemLayout}>
                  {getFieldDecorator('destinationId', {
                  	initialValue: tryinit('destination'),
                    rules: [{ required: true, message: '请输入目的地' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('destination')}
                    targetType={"destination"} 
                    requestFunction={TransportTaskService.requestCandidateDestination}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.status} {...formItemLayout}>
                  {getFieldDecorator('statusId', {
                  	initialValue: tryinit('status'),
                    rules: [{ required: true, message: '请输入状态' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('status')}
                    targetType={"status"} 
                    requestFunction={TransportTaskService.requestCandidateStatus}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.sender} {...formItemLayout}>
                  {getFieldDecorator('senderId', {
                  	initialValue: tryinit('sender'),
                    rules: [{ required: true, message: '请输入发送方' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('sender')}
                    targetType={"sender"} 
                    requestFunction={TransportTaskService.requestCandidateSender}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.receiver} {...formItemLayout}>
                  {getFieldDecorator('receiverId', {
                  	initialValue: tryinit('receiver'),
                    rules: [{ required: true, message: '请输入接收机' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('receiver')}
                    targetType={"receiver"} 
                    requestFunction={TransportTaskService.requestCandidateReceiver}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.platform} {...formItemLayout}>
                  {getFieldDecorator('platformId', {
                  	initialValue: tryinit('platform'),
                    rules: [{ required: true, message: '请输入平台' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('platform')}
                    targetType={"platform"} 
                    requestFunction={TransportTaskService.requestCandidatePlatform}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<TransportTaskTrackModalTable data={data.transportTaskTrackList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(TransportTaskAssociateForm))




