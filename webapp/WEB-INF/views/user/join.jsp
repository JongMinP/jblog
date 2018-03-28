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
<script src="${ctx}/assets/js/jquery/jquery-1.9.0.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(function() {

		$("#btn-checkid").click(function() {
			var id = $("#blog-id").val();
			if (id == "") {
				return;
			}

			$.ajax({
				url : "${ctx}/api/user/checkid?id=" + id,
				type : "get",
				data : "",
				dataType : "json",
				success : function(response) {

					if (response.result != "success") {
						return;
					}

					if (response.data == "exist") {
						alert("이미 사용중인 아이디");
						$("#blog-id").val("").focus();
						return;
					}

					$("#img-checkid").show();
					$("#btn-checkid").hide();

				},
				error : function(xhr, status, e) {
					console.log("gg");
					// 개발단계에서만 
				}
			});

		});

	});
</script>




</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<ul class="menu">
			<c:import url="/WEB-INF/views/includes/header.jsp" />
		</ul>
		<form class="join-form" id="join-form" method="post"
			action="${ctx}/user/join">
			<label class="block-label" for="name">이름</label> <input id="name"
				name="name" type="text" value=""> <label class="block-label"
				for="blog-id">아이디</label> <input id="blog-id" name="id" type="text">
			<input id="btn-checkid" type="button" value="id 중복체크"> <img
				id="img-checkid" style="display: none;"
				src="${ctx}/assets/images/check.png"> <label
				class="block-label" for="password">패스워드</label> <input id="password"
				name="password" type="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>
	<div id="dialog-message" title="" style="display: none">
		<p></p>
	</div>
</body>
</html>
