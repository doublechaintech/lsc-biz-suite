
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transportProject}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A TransportProject" style="color: green">${userContext.localeMap['transport_project']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['transport_project.id']}</span> ${transportProject.id}</li>
<li><span>${userContext.localeMap['transport_project.name']}</span> ${transportProject.name}</li>
<li><span>${userContext.localeMap['transport_project.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${transportProject.createTime}" /></li>
<li><span>${userContext.localeMap['transport_project.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${transportProject.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


