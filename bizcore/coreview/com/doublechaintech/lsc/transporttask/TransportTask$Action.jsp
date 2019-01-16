
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transportTask}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A TransportTask" style="color: green">${userContext.localeMap['transport_task']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['transport_task.id']}</span> ${transportTask.id}</li>
<li><span>${userContext.localeMap['transport_task.name']}</span> ${transportTask.name}</li>
<li><span>${userContext.localeMap['transport_task.remark']}</span> ${transportTask.remark}</li>
<li><span>${userContext.localeMap['transport_task.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${transportTask.createTime}" /></li>
<li><span>${userContext.localeMap['transport_task.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${transportTask.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


