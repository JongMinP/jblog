<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<title>JBlog</title>
<Link rel="stylesheet" href="${ctx}/assets/css/jblog.css">
<script type="text/javascript"
	src="${ctx}/assets/js/jquery/jquery-1.9.0.js"></script>
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
		<form class="login-form">
			<label>아이디</label> <input type="text" name="id"> <label>패스워드</label>
			<c:if test="${'fail' eq  result }">
				<p>로그인이 실패 했습니다.</p>
			</c:if>
			<input type="text" name="password"> <input type="submit"
				value="로그인">
		</form>
	</div>
</body>
</html>
