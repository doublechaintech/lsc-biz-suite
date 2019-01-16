
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"Transport Task", menuFor: "transportTask",
  		subItems: [
  {name: 'transportTaskTrackList', displayName:'Transport Task Track', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: 'Source', dataIndex: 'source', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Destination', dataIndex: 'destination', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Remark', debugtype: 'string', dataIndex: 'remark', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Status', dataIndex: 'status', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Sender', dataIndex: 'sender', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Receiver', dataIndex: 'receiver', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Platform', dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Create Time', dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: 'Update Time', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  source: 'Source',
  destination: 'Destination',
  remark: 'Remark',
  status: 'Status',
  sender: 'Sender',
  receiver: 'Receiver',
  platform: 'Platform',
  createTime: 'Create Time',
  updateTime: 'Update Time',

}


const TransportTaskBase={menuData,displayColumns,fieldLabels,displayColumns}
export default TransportTaskBase



