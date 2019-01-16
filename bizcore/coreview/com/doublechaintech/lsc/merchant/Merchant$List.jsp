<%@ page import='java.util.*,com.doublechaintech.lsc.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty merchantList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['merchant']}! 
		 <a href="./${ownerBeanName}Manager/addMerchant/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty merchantList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("merchantList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['merchant']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addMerchant/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'merchantList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${merchantListName};${merchantListName}CurrentPage=${page.pageNumber};${merchantListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='merchantListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['merchant.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['merchant.name']}</th>
</c:if>
<c:if test="${param.referName ne 'type'}">
	<th>${userContext.localeMap['merchant.type']}</th>
</c:if>
<c:if test="${param.referName ne 'platform'}">
	<th>${userContext.localeMap['merchant.platform']}</th>
</c:if>
<c:if test="${param.referName ne 'description'}">
	<th>${userContext.localeMap['merchant.description']}</th>
</c:if>
<c:if test="${param.referName ne 'createTime'}">
	<th>${userContext.localeMap['merchant.create_time']}</th>
</c:if>
<c:if test="${param.referName ne 'updateTime'}">
	<th>${userContext.localeMap['merchant.update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${merchantList}">
				<tr currentVersion='${item.version}' id="merchant-${item.id}" ><td><a class="link-action-removed" href="./merchantManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateMerchant/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'type'}">
	<td class="select_candidate_td"
			data-candidate-method="./merchantManager/requestCandidateType/${ownerBeanName}/${item.id}/"
			data-switch-method="./merchantManager/transferToAnotherType/${item.id}/"
			data-link-template="./merchantTypeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.type}">
			<a href='./merchantTypeManager/view/${item.type.id}/'>${item.type.displayName}</a>
			</c:if>
			<c:if test="${empty  item.type}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'platform'}">
	<td class="select_candidate_td"
			data-candidate-method="./merchantManager/requestCandidatePlatform/${ownerBeanName}/${item.id}/"
			data-switch-method="./merchantManager/transferToAnotherPlatform/${item.id}/"
			data-link-template="./platformManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.platform}">
			<a href='./platformManager/view/${item.platform.id}/'>${item.platform.displayName}</a>
			</c:if>
			<c:if test="${empty  item.platform}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'description'}">	<td contenteditable='true' class='edit-value'  propertyToChange='description' storedCellValue='${item.description}' prefix='${ownerBeanName}Manager/updateMerchant/${result.id}/${item.id}/'><a title='${item.description}'>${fn:substring(item.description,0,10)}...</a></td>
</c:if><c:if test="${param.referName ne 'createTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='createTime' storedCellValue='${item.createTime}' prefix='${ownerBeanName}Manager/updateMerchant/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.createTime}" /></td>
</c:if><c:if test="${param.referName ne 'updateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='updateTime' storedCellValue='${item.updateTime}' prefix='${ownerBeanName}Manager/updateMerchant/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.updateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeMerchant/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyMerchantFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


