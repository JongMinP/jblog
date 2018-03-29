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
<Link rel="stylesheet"
	href="${ctx}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/blog-menu.jsp">
					<c:param name="menu" value="basic" />
				</c:import>
				<form action="${ctx}/${authUser.id}/admin/basic" method="post" enctype="multipart/form-data" >
					<input type="hidden" name = "no" value="${authUser.no}">
					<table class="admin-config">
						<tr>
							<td class="t">블로그 제목</td>
							<td><input type="text" size="40" name="title" value="${blog.title }"></td>
						</tr>
						<tr>
							<td class="t">로고이미지</td>
							<td><img
								src="${pageContext.request.contextPath}/uploads/images/${blog.image}"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td><input type="file" name="logo-file"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td class="s"><input type="submit" value="기본설정 변경"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp" />
	</div>
</body>
</html>