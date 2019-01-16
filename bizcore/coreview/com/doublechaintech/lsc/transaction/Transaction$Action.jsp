
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transaction}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Transaction" style="color: green">${userContext.localeMap['transaction']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['transaction.id']}</span> ${transaction.id}</li>
<li><span>${userContext.localeMap['transaction.name']}</span> ${transaction.name}</li>
<li><span>${userContext.localeMap['transaction.amount']}</span> <fmt:formatNumber type="currency"  value="${transaction.amount}" /></li>

	
	</ul>
</div>



</c:if>


