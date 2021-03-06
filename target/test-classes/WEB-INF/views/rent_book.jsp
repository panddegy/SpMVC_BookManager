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
		let book_seq=$(this).attr("data-id")
		opener.document.getElementById("rent_book_seq").value=book_seq
		window.close()
	})
})
</script>
<article class="content-container">
	<h2>Book List</h2>
	<table>
		<tr>
			<th>NO</th>
			<th>ISBN</th>
			<th>TITLE</th>
			<th>AUTHOR</th>
			<th>RENTABLE</th>
		</tr>
		<c:choose>
			<c:when test="${empty LIST}">
				<tr><td colspan="5">No data</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="book" items="${LIST}" varStatus="i">
					<tr class="table-row" data-id="${book.book_seq}" data-title="${book.book_title}">
						<td>${i.count}</td>
						<td>${book.book_isbn}</td>
						<td>${book.book_title}</td>
						<td>${book.book_author}</td>
						<td>${book.book_rent_yn}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</article>
