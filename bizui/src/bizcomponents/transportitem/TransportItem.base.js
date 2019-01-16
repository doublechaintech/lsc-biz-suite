
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"Transport Item", menuFor: "transportItem",
  		subItems: [
  
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
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Quantity', debugtype: 'int', dataIndex: 'quantity', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Unit', debugtype: 'string', dataIndex: 'unit', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Project', dataIndex: 'project', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Merchant', dataIndex: 'merchant', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Platform', dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Create Time', dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: 'Update Time', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  quantity: 'Quantity',
  unit: 'Unit',
  project: 'Project',
  merchant: 'Merchant',
  platform: 'Platform',
  createTime: 'Create Time',
  updateTime: 'Update Time',

}


const TransportItemBase={menuData,displayColumns,fieldLabels,displayColumns}
export default TransportItemBase



