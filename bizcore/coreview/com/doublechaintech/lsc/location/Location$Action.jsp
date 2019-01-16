
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty location}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Location" style="color: green">${userContext.localeMap['location']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['location.id']}</span> ${location.id}</li>
<li><span>${userContext.localeMap['location.name']}</span> ${location.name}</li>
<li><span>${userContext.localeMap['location.contact_person']}</span> ${location.contactPerson}</li>
<li><span>${userContext.localeMap['location.contact_phone']}</span> ${location.maskedContactPhone}</li>
<li><span>${userContext.localeMap['location.description']}</span> ${location.description}</li>
<li><span>${userContext.localeMap['location.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${location.createTime}" /></li>
<li><span>${userContext.localeMap['location.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${location.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


