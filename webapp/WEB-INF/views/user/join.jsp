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
					console.log("sdf");

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

<script>
$(function(){
	$( "#join-form" ).submit( function(){
		//1. 이름 체크
		if( $( "#name" ).val() == "" ) {
			messageBox( "입력폼", "이름은 필수 입력 항목입니다.", function(){
				$( "#name" ).focus();
			});				
			return false;
		}
		
		//2-1. 아이디가 비어있는 지 체크
		if( $( "#id" ).val() == "" ) {
			messageBox( "입력폼", "아이디는 필수 입력 항목입니다.", function(){
				$( "#id" ).focus();
			});				
			return false;
		}
		
		//2-2. 아이디 중복 체크 유무
		if( $( "#img-checkid" ).is( ":visible" ) == false ){
			messageBox( "입력폼", "아이디 중복 체크를 해야 합니다.");			
			return false;
		}
		
		//3. 비밀번호 체크
		if( $("#password").val() == "" ) {
			messageBox( "입력폼", "비밀번호는 필수 입력 항목입니다.", function(){
				$( "#password" ).focus();
			});			
			return false;
		}
		
		//4. 약관동의
		if( $( "#agree-prov" ).is( ":checked" ) == false ) {
			messageBox( "입력폼", "약관 동의를 해야 합니다.");			
			return false;
		}
		
		return true;
	});
	
	$( "#id" ).change( function(){
		$("#img-checkid").hide();
		$("#btn-checkid").show();			
	});
	
	
	
	$("#btn-checkid").click( function(){
		var id = $( "#id" ).val();
		
		if( id == "" ) {
			return;
		}
		
		$.ajax({
			url:"${pageContext.request.contextPath }/api/user/checkid?id=" + id,
			type: "get",
			dataType: "json",
			data: "",
			success: function( response ) {
				console.log( response );
				
				// 통신 에러(서버 에러)
				if( response.result == "fail" ) {
					console.log( response.message );
					return;
				}

				// 사용중인 아이디인 경우,
				if( response.data == "exist" ) {
					messageBox( "입력폼", "이미 존재하는 이메일입니다. 다른 이메일을 사용해 주세요.", function(){
						$("#id").val("").focus();
					});						
					return;
				}
				
				// 사용중이 아닌 아이디인 경우,
				$("#img-checkid").show();
				$("#btn-checkid").hide();
			},
			error: function( jqXHR, status, e ) {
				console.error( status + ":" + e );
			}
		});
	});
});

var messageBox = function( title, message, callback ){
	$( "#dialog-message" ).attr( "title", title );
	$( "#dialog-message p" ).text( message );
	$( "#dialog-message" ).dialog({
		modal: true,
		buttons: {
			Ok: function() {
				$( this ).dialog( "close" );
			}
		},
		close: callback || function(){}
	});
}
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
