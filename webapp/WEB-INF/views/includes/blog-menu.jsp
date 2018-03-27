<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link rel="stylesheet" href="${ctx}/assets/css/jblog.css">


<ul class="admin-menu">

	<c:choose>
		<c:when test="${param.menu == 'basic' }">
			<li class="selected">기본설정</li>
			<li><a href="${ctx}/blog/${authUser.id}/admin/category">카테고리</a></li>
			<li><a href="${ctx}/blog/${authUser.id}/admin/write">글작성</a></li>
		</c:when>
		<c:when test="${param.menu == 'category' }">
			<li><a href="${ctx}/blog/${authUser.id}/admin/basic">기본설정</a></li>
			<li class="selected">카테고리</li>
			<li><a href="${ctx}/blog/${authUser.id}/admin/write">글작성</a></li>

		</c:when>
		<c:when test="${param.menu == 'write' }">
			<li><a href="${ctx}/blog/${authUser.id}/admin/basic">기본설정</a></li>
			<li><a href="${ctx}/blog/${authUser.id}/admin/category">카테고리</a></li>
			<li class="selected">글작성</li>
		</c:when>
		<c:otherwise>
			<li><a href="${ctx}/blog/${authUser.id}/admin/basic">기본설정</a></li>
			<li><a href="${ctx}/blog/${authUser.id}/admin/category">카테고리</a></li>
			<li><a href="${ctx}/blog/${authUser.id}/admin/write">글작성</a></li>
		</c:otherwise>



	</c:choose>
</ul>