
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"运输任务", menuFor: "transportTask",
  		subItems: [
  {name: 'transportTaskTrackList', displayName:'运输任务跟踪', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
  		],
}

const renderTextCell=(value, record)=>{

	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+"字)"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	if(!value){
		return '空'
	}
	if(value == null){
		return '空'
	}
	return (`￥${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{

	return  (value? '是' : '否')

}

const renderReferenceCell=(value, record)=>{

	return (value ? value.displayName : '暂无') 

}

const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'transportTask') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '源', dataIndex: 'source', render: (text, record) => renderReferenceCell(text, record)},
  { title: '目的地', dataIndex: 'destination', render: (text, record) => renderReferenceCell(text, record)},
  { title: '备注', debugtype: 'string', dataIndex: 'remark', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: '状态', dataIndex: 'status', render: (text, record) => renderReferenceCell(text, record)},
  { title: '发送方', dataIndex: 'sender', render: (text, record) => renderReferenceCell(text, record)},
  { title: '接收机', dataIndex: 'receiver', render: (text, record) => renderReferenceCell(text, record)},
  { title: '平台', dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},
  { title: '创建时间', dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '更新时间', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  source: '源',
  destination: '目的地',
  remark: '备注',
  status: '状态',
  sender: '发送方',
  receiver: '接收机',
  platform: '平台',
  createTime: '创建时间',
  updateTime: '更新时间',

}


const TransportTaskBase={menuData,displayColumns,fieldLabels,displayColumns}
export default TransportTaskBase



