
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty merchant}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Merchant" style="color: green">${userContext.localeMap['merchant']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['merchant.id']}</span> ${merchant.id}</li>
<li><span>${userContext.localeMap['merchant.name']}</span> ${merchant.name}</li>
<li><span>${userContext.localeMap['merchant.description']}</span> ${merchant.description}</li>
<li><span>${userContext.localeMap['merchant.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${merchant.createTime}" /></li>
<li><span>${userContext.localeMap['merchant.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${merchant.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


