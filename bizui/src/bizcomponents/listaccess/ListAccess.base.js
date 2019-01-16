
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"List Access", menuFor: "listAccess",
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
  { title: 'Internal Name', debugtype: 'string', dataIndex: 'internalName', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Read Permission', dataIndex: 'readPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Create Permission', dataIndex: 'createPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Delete Permission', dataIndex: 'deletePermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Update Permission', dataIndex: 'updatePermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Execution Permission', dataIndex: 'executionPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '应用程序', dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  internalName: 'Internal Name',
  readPermission: 'Read Permission',
  createPermission: 'Create Permission',
  deletePermission: 'Delete Permission',
  updatePermission: 'Update Permission',
  executionPermission: 'Execution Permission',
  app: '应用程序',

}


const ListAccessBase={menuData,displayColumns,fieldLabels,displayColumns}
export default ListAccessBase



