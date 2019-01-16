
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../../components/Result'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';
import GlobalComponents from '../../custcomponents'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './TransportTask.search.less'
import ListViewTool from '../../common/ListView.tool'
import PermissionSettingService from '../../permission/PermissionSetting.service'
const  {  hasCreatePermission,hasExecutionPermission,hasDeletePermission,hasUpdatePermission,hasReadPermission } = PermissionSettingService


const {handleSelectRows,handleStandardTableChange,
  showDeletionDialog,handleUpdate,handleDeletionModalVisible,
  handleElementCreate,toggleAssociateModalVisible,handleCloseAlert}=ListViewTool


const buttonMenuFor =(targetComponent, internalName, localeName)=> (
  <Menu >
    <Menu.Item key="1" onClick={()=>toggleAssociateModalVisible(targetComponent,internalName)}>新建{localeName}</Menu.Item>
    <Menu.Item key="2">合并{localeName}</Menu.Item>
   
  </Menu>
);


 
const showListActionBar = (targetComponent)=>{

  const {selectedRows} = targetComponent.state
  const {metaInfo} = targetComponent.props
  const disable = (selectedRows.length === 0)

  return (<div className={styles.tableListOperator}>
        
 
              {hasCreatePermission(metaInfo)&&<Button icon="plus" type="primary" onClick={() => handleElementCreate(targetComponent)}>新建</Button>}
              
 {hasDeletePermission(metaInfo)&&<Button onClick={(event)=>handleDeletionModalVisible(event,targetComponent)} type="danger" icon="delete" disabled={disable}>批量删除</Button>}
               

               {hasUpdatePermission(metaInfo)&&<Button onClick={()=>handleUpdate(targetComponent)} icon="update" disabled={disable}>批量更新</Button>}
 
 	
    
               
	</div> )


}


const showAssociateDialog = (targetComponent) => {
  const {data, owner, visible,onCancel,onCreate} = targetComponent.props
  const {currentAssociateModal} = targetComponent.state
  
  const {selectedRows} = targetComponent.state
  
  const { TransportProjectAssociateForm } = GlobalComponents
  const { LocationAssociateForm } = GlobalComponents
  const { TransportTaskStatusAssociateForm } = GlobalComponents
  const { MerchantAssociateForm } = GlobalComponents
  const { PlatformAssociateForm } = GlobalComponents


  return (
  <div>
  
   
  
    <TransportProjectAssociateForm 
	visible={currentAssociateModal==='project'} 
	data={{transportTaskList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'project')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'project')}/> <LocationAssociateForm 
	visible={currentAssociateModal==='source'} 
	data={{transportTaskListAsSource:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'source')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'source')}/> <LocationAssociateForm 
	visible={currentAssociateModal==='destination'} 
	data={{transportTaskListAsDestination:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'destination')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'destination')}/> <TransportTaskStatusAssociateForm 
	visible={currentAssociateModal==='status'} 
	data={{transportTaskList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'status')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'status')}/> <MerchantAssociateForm 
	visible={currentAssociateModal==='sender'} 
	data={{transportTaskListAsSender:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'sender')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'sender')}/> <MerchantAssociateForm 
	visible={currentAssociateModal==='receiver'} 
	data={{transportTaskListAsReceiver:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'receiver')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'receiver')}/> <PlatformAssociateForm 
	visible={currentAssociateModal==='platform'} 
	data={{transportTaskList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'platform')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'platform')}/> 
 


    </div>
    
    
    
    )
}


class TransportTaskSearch extends PureComponent {
  state = {
    deletionModalVisible: false,
    selectedRows: [],
    showDeleteResult: false,
    currentAssociateModal: null,
  }

  render(){
    const { data, loading, count, currentPage, owner,partialList } = this.props;
    const {displayName} = owner.ref
    const { showDeleteResult, selectedRows, deletionModalVisible, showAssociatePaymentForm } = this.state;
    const {TransportTaskTable} = GlobalComponents;
    const {TransportTaskSearchForm} = GlobalComponents;
    const {TransportTaskModalTable} = GlobalComponents;
    
    
  
    return (
      <PageHeaderLayout title={`${displayName}:${this.props.name}列表`}>
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>
              <TransportTaskSearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
           
   
              {showListActionBar(this)}
              {partialList&&(
              <div className={styles.searchAlert}>
                	<Alert message="下面显示最近更新结果，关闭显示全部" type="success" closable  afterClose={()=>handleCloseAlert(displayName, this)}/>
              </div>  	
              )}
              
            </div>
            <TransportTaskTable
              selectedRows={selectedRows}
              loading={loading}
              data={data}
              count={count}
              current={currentPage}
              onSelectRow={(selectedRows)=>handleSelectRows(selectedRows,this)}
              onChange={(pagination, filtersArg, sorter)=>handleStandardTableChange(pagination, filtersArg, sorter,this)}
              owner={owner}
              {...this.props}
            />
          </div>
        </Card>
        {showDeletionDialog(this,TransportTaskModalTable,"transportTaskIds")}
        {showAssociateDialog(this)}
      </PageHeaderLayout>
    )
  }
}

export default Form.create()(TransportTaskSearch)


