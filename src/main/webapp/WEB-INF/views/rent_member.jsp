<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/include-head.jspf" %>
</head>
<style>
table{
	width: 80%;
	margin: 20px auto;
	border: 1px solid gainsboro;
	color: gainsboro;
}
td, th{
	border: 1px solid gainsboro;
	padding: 4px 8px;	
}
.table-row{
	cursor: pointer;
}
.table-row:hover{
	background-color: gainsboro;
	color: dimgray;
}
</style>
<script>
$(function(){
	$(".table-row").click(function(){
		let user_seq=$(this).attr("data-id")
		let user_name=$(this).attr("data-name")
		opener.document.getElementById("rent_user_seq").value=user_seq
		window.close()
	})
})
</script>
<body>
<article class="content-container">
	<h2>Member List</h2>
	<table>
		<tr>
			<th>NO</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>전화번호</th>
			<th>가입날짜</th>
		</tr>
		<c:choose>
			<c:when test="${empty LIST}">
				<tr><td colspan="5">No data</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="user" items="${LIST}" varStatus="i">
					<tr class="table-row" data-id="${user.user_seq}" data-name="${user.user_name}">
						<td>${i.count}</td>
						<td>${user.user_name}</td>
						<td>${user.user_birth}</td>
						<td>${user.user_phone}</td>
						<td>${user.user_reg_date}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</article>


</body>
</html>