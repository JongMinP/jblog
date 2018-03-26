<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<title>JBlog</title>
<Link rel="stylesheet" href="${ctx}/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<ul class="menu">
			<li><a href="${ctx}/user/login">로그인</a></li>
			<li><a href="${ctx}/user/join">회원가입</a></li>
			<li><a href="${ctx}/user/logout">로그아웃</a></li>
			<li><a href="${ctx}/board/main">내블로그</a></li>
		</ul>
		<p class="welcome-message">
			<span> 감사합니다. 회원 가입 및 블로그가 성공적으로 만들어 졌습니다.</span>
			<br><br>
			<a href="${ctx}/user/login"">로그인 하기</a>
		</p>
	</div>
</body>
</html>
