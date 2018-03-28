<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${ctx}/assets/css/jblog.css">
</head>
<%
	pageContext.setAttribute("newLine", "\n");
%>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${category.name }</h4>
					<p>${fn: replace(category.content, newLine,"<br>") }
					
					<p>
				</div>
				<ul class="blog-list">

					<c:forEach items="${posts }" var="post">
						<li><a href="">${post.title }</a><span>2015/05/02</span></li>
					</c:forEach>
				</ul>
				
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img
					src="${pageContext.request.contextPath}/uploads/images/${blog.image}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categorys }" var="category">
					<li><a href="${ctx}/blog/${authUser.id}?pno=${category.no}">${category.name }</a></li>
				</c:forEach>
			</ul>
		</div>

		<c:import url="/WEB-INF/views/includes/blog-footer.jsp" />
	</div>
</body>
</html>