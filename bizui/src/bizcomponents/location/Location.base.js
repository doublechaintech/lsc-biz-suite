
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"位置", menuFor: "location",
  		subItems: [
  {name: 'transportTaskListAsSource', displayName:'Transport Task(Source)', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'transportTaskListAsDestination', displayName:'Transport Task(Destination)', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'location') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Contact Person', debugtype: 'string', dataIndex: 'contactPerson', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Contact Phone', debugtype: 'string_china_mobile_phone', dataIndex: 'contactPhone', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '描述', debugtype: 'string_longtext', dataIndex: 'description', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Platform', dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Create Time', dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: 'Update Time', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  contactPerson: 'Contact Person',
  contactPhone: 'Contact Phone',
  description: '描述',
  platform: 'Platform',
  createTime: 'Create Time',
  updateTime: 'Update Time',

}


const LocationBase={menuData,displayColumns,fieldLabels,displayColumns}
export default LocationBase



