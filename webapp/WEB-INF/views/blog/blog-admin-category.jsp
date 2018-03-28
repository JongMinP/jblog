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
<script src="${ctx}/assets/js/jquery/jquery-1.9.0.js"
	type="text/javascript"></script>
<script type="text/javascript">
	
var registCategory = function() {
	$.ajax({
		url:"${ctx}/api/category/addCategory"
		,type:"post"
		,data:{name:$("#name").val(), content:$("#desc").val(), blogNo : ${blog.no} } 
		,success:displayCategory
		,error:errorCallback
	});
};

var removeCategory = function(no,bno) {
	$.ajax({
		url:"${ctx}/api/category/removeCategory?no="+no +"&bno=" + bno
		,type:"get"
		,data:{no: no , bno : ${blog.no} }
		,success:displayCategory
		,error:errorCallback
	});
};


var displayCategory = function(resultData) { //article이 json(자바스크립트객체)으로 온다. 
	var categoryHtml = "";
	categoryHtml += '<table class="admin-cat"> <tr> <th>번호</th> <th>카테고리명</th> <th>포스트 수</th> <th>설명</th> <th>삭제</th> </tr>' ;
	
	$.each(resultData, function(index, category){
		categoryHtml += '<tr> <td>'+ category.no + '</td>' ;
		categoryHtml += '<td>' + category.name + '</td>' ;
		categoryHtml += '<td>' + category.postCount + '</td>' ;
		categoryHtml += '<td>' + category.content + '</td>' ;
		categoryHtml += '<td> <a href="javascript:removeCategory('+ category.no + ',' + category.blogNo + ');">'  
		categoryHtml +=  '<img src="${ctx}/assets/images/delete.jpg"></a> </td> </tr>';
	});
	
	$("#categoryArea").empty();
	
	$("#categoryArea").append(categoryHtml);
	$("#categoryArea").append('</table>');
	
	$("#name").val("");
	$("#desc").val("");
};

var errorCallback = function() {
	alert("수행중 오류가 발생했습니다.");
};

</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/blog-menu.jsp">
					<c:param name="menu" value="category" />
				</c:import>
				<div id="categoryArea">
				<table class="admin-cat">
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					
					<c:forEach items="${categorys }" var="category" varStatus="status">
					<tr>
						<td>${categorys.size() - status.index }</td>
						<td>${category.name }</td>
						<td>${category.postCount }</td>
						<td>${category.content }</td>
						<td> <a href="javascript:removeCategory(${category.no},${blog.no});"><img
							src="${ctx}/assets/images/delete.jpg"></a></td>
					</tr>
					</c:forEach>
				</table>
				</div>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<form onsubmit="registCategory(); return false;">
				<table id="admin-cat-add">
					<tr>
						<td class="t">카테고리명</td>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<td class="t">설명</td>
						<td><input type="text" name="desc" id="desc"></td>
					</tr>
					<tr>
						<td class="s">&nbsp;</td>
						<td><input type="submit" value="카테고리 추가"></td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp" />
	</div>
</body>
</html>