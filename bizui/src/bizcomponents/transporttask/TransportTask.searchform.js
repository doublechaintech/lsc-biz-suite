

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './TransportTask.search.less'
import GlobalComponents from '../../custcomponents'
import SelectObject from '../../components/SelectObject'
const FormItem = Form.Item
const { Option } = Select
const getValue = obj => Object.keys(obj).map(key => obj[key]).join(',')

const pushIfNotNull=(holder,value)=>{
  if(value==null){
    return
  }
  holder.push(value)

}

const overrideValue=(values,defaultValue)=>{
  
  const result = _.findLast(values,it=>!_.isUndefined(it)&&!_.isNull(it))
  if(_.isUndefined(result)){
    return defaultValue
  }
  return result
}


const filterObjectKeys=(targetObject)=>{

  const filteredValues = {}
  for(var key in targetObject){
      const value = targetObject[key]
      if(!value){
        continue
      }
      filteredValues[key] = value
     
  }
  return filteredValues

}

class TransportTaskSearchForm extends PureComponent {
  state = {
    // addInputValue: '',
    // modalVisible: false,
    expandForm: false,
    // selectedRows: [],
    // formValues: {},
  }
componentDidMount() {
    // const { dispatch } = this.props
    // console.log(this.props)
    // const { getFieldDecorator, setFieldsValue } = this.props.form
    const { setFieldsValue,setFieldValue } = this.props.form
    const { expandForm } = this.props
    
    const { searchFormParameters } = this.props
    if (!searchFormParameters) {
      return
    }
    console.log("searchFormParameters", searchFormParameters)

    setFieldsValue(searchFormParameters)
    if(_.isUndefined(expandForm)){
      this.setState({searchParams:searchFormParameters,expandForm:false})
      return
    }
    this.setState({searchParams:searchFormParameters,expandForm})
    
  }
  toggleForm = () => {
    this.setState({
      expandForm: !this.state.expandForm,
    })
  }
  handleFormReset = () => {
    const { form, dispatch } = this.props
    form.resetFields()
    dispatch({
      type: 'rule/fetch',
      payload: {},
    })
  }
  /*
  buildStringSearchParameters = (formValues, fieldName) => {
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      console.log('NO VALUE')
      return {}
    }
    return {
      transportTaskList: 1,
      'transportTaskList.searchField': fieldName,
      'transportTaskList.searchVerb': 'startsWith',
      'transportTaskList.searchValue': fieldValue,
    }
  }
  */
  buildStringSearchParameters = (formValues, searchVerb, fieldName) => {
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      return null
    }
    
    //paramHolder.length
    const value = {}

    value[`transportTaskList.searchField`] = fieldName
    value[`transportTaskList.searchVerb`] =  searchVerb
    value[`transportTaskList.searchValue`] = fieldValue
    
    return value

  }
  
  
  
  handleSearch = (e) => {
    e.preventDefault()
    const { dispatch, form } = this.props
    form.validateFields((err, fieldsValue) => {
      if (err) return
      const paramList = []
      
     
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'id'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'name'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'project'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'source'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'destination'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'remark'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'status'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'sender'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'receiver'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'platform'))

     
      console.log("the final parameter", paramList)
      
      const params = {}
      
     
      for(var i=0;i<paramList.length;i++){
        const element = paramList[i];
        for (var key in element) {
          params[key+"."+i]=element[key]
        }

      }
     
      params['transportTaskList'] = 1
      params['transportTaskList.orderBy.0'] = "id"
      params['transportTaskList.descOrAsc.0'] = "desc"
      
      const { owner } = this.props
      const expandForm = overrideValue([this.state.expandForm],false)
      dispatch({
        type: `${owner.type}/load`,
        payload: { id: owner.id, parameters: params, 
        transportTaskSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const {TransportTaskService} = GlobalComponents
    const tryinit  = (fieldName) => {
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    const availableForEdit = (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    }
    
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>

       <Col md={8} sm={24}>
         <FormItem label="ID">
           {getFieldDecorator('id')(
             <Input placeholder="请输入ID" />
           )}
         </FormItem>
       </Col>

       <Col md={8} sm={24}>
         <FormItem label="名称">
           {getFieldDecorator('name')(
             <Input placeholder="请输入名称" />
           )}
         </FormItem>
       </Col>

          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
              <Button type="primary" htmlType="submit">查询</Button>
              <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>重置</Button>
              <a style={{ marginLeft: 8 }} onClick={this.toggleForm}> 展开 <Icon type="down" /> </a>
            </span>
          </Col>
        </Row>
      </Form>
    )
  }
  renderAdvancedForm() {
  	const {TransportTaskService} = GlobalComponents
    const { getFieldDecorator } = this.props.form
    
    const tryinit  = (fieldName) => {
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
    
    
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>

          <Col md={8} sm={24}>
            <FormItem label="ID">
              {getFieldDecorator('id')(
                <Input placeholder="请输入ID" />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="名称">
              {getFieldDecorator('name')(
                <Input placeholder="请输入名称" />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="项目">
                  {getFieldDecorator('project', {
                    initialValue: tryinit('project'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('project')}
                    targetType={"project"} 
                    requestFunction={TransportTaskService.requestCandidateProject}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="源">
                  {getFieldDecorator('source', {
                    initialValue: tryinit('source'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('source')}
                    targetType={"source"} 
                    requestFunction={TransportTaskService.requestCandidateSource}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="目的地">
                  {getFieldDecorator('destination', {
                    initialValue: tryinit('destination'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('destination')}
                    targetType={"destination"} 
                    requestFunction={TransportTaskService.requestCandidateDestination}/>
                  
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label="备注">
              {getFieldDecorator('remark')(
                <Input placeholder="请输入备注" />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="状态">
                  {getFieldDecorator('status', {
                    initialValue: tryinit('status'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('status')}
                    targetType={"status"} 
                    requestFunction={TransportTaskService.requestCandidateStatus}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="发送方">
                  {getFieldDecorator('sender', {
                    initialValue: tryinit('sender'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('sender')}
                    targetType={"sender"} 
                    requestFunction={TransportTaskService.requestCandidateSender}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="接收机">
                  {getFieldDecorator('receiver', {
                    initialValue: tryinit('receiver'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('receiver')}
                    targetType={"receiver"} 
                    requestFunction={TransportTaskService.requestCandidateReceiver}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="平台">
                  {getFieldDecorator('platform', {
                    initialValue: tryinit('platform'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('platform')}
                    targetType={"platform"} 
                    requestFunction={TransportTaskService.requestCandidatePlatform}/>
                  
                 
                  )}
                </Form.Item></Col>

        </Row>
        <div style={{ overflow: 'hidden' }}>
          <span style={{ float: 'right', marginBottom: 24 }}>
            <Button type="primary" htmlType="submit">查询</Button>
            <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>重置</Button>
            <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>收起 <Icon type="up" /></a>
          </span>
        </div>
      </Form>
    )
  }

  render() {
  	const expandForm = overrideValue([this.state.expandForm],false)
    return expandForm ? this.renderAdvancedForm() : this.renderSimpleForm()
  }
}

export default Form.create()(TransportTaskSearchForm)


