
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"Platform", menuFor: "platform",
  		subItems: [
  {name: 'locationList', displayName:'位置', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'merchantList', displayName:'Merchant', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'transportProjectList', displayName:'Transport Project', icon:'project-diagram',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'transportItemList', displayName:'Transport Item', icon:'sitemap',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'transportTaskList', displayName:'Transport Task', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'platform') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '12',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Introduction', debugtype: 'string', dataIndex: 'introduction', width: '22',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Current Version', debugtype: 'string', dataIndex: 'currentVersion', width: '8',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  introduction: 'Introduction',
  currentVersion: 'Current Version',

}


const PlatformBase={menuData,displayColumns,fieldLabels,displayColumns}
export default PlatformBase



