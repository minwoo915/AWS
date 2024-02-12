<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>Albatross Manager</title>
	    <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/admin.css" />
	</head>
<body>
	<h2>관리자 페이지</h2>
	
	<table>
		<thead>
			<tr>
				<th>트윗 글 번호</th>
				<th>신고 횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="declare" items="${declarelist}">
				<tr>
					<td><a href="/Albatross/adminRead?tid=${declare.tid}">${declare.tid}</a></td>
					<td>${declare.count}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/admin.js"></script>

</html>







