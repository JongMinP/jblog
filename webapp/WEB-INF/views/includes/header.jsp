<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<Link rel="stylesheet" href="${ctx}/assets/css/jblog.css">
<ul class="menu">

	<c:choose>
		<c:when test="${authUser eq null }">
			<li><a href="${ctx}/user/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li>${authUser.id }님 반갑습니다.</li>
		</c:otherwise>
	</c:choose>
	
	<li><a href="${ctx}/user/join">회원가입</a></li>
	<li><a href="${ctx}/user/logout">로그아웃</a></li>
	<c:if test="${authUser != null }">
		<li><a href="${ctx}/${authUser.id}">내블로그</a></li>
	</c:if>
</ul>