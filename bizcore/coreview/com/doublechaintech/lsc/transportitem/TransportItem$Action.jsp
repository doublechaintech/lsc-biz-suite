
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transportItem}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A TransportItem" style="color: green">${userContext.localeMap['transport_item']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['transport_item.id']}</span> ${transportItem.id}</li>
<li><span>${userContext.localeMap['transport_item.name']}</span> ${transportItem.name}</li>
<li><span>${userContext.localeMap['transport_item.quantity']}</span> ${transportItem.quantity}</li>
<li><span>${userContext.localeMap['transport_item.unit']}</span> ${transportItem.unit}</li>
<li><span>${userContext.localeMap['transport_item.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${transportItem.createTime}" /></li>
<li><span>${userContext.localeMap['transport_item.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${transportItem.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


