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
	<form action="/declare/delete">
	<h2>글 상세보기</h2>
	
		<table>
			<thead>
				<tr>
					<th>트윗 글 번호</th>
					<th>유저 아이디</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${declare.tid}</td>
					<td>${declare.uuid}</td>
					<td>${declare.content}</td>
					<td>${declare.regdate}</td>
				</tr>
			</tbody>
		</table>
		<ul class="actions special">
			<li>
				<a href="/Albatross/adminDelete?tid=${declare.tid}">삭제</a>
			</li>
		</ul>
	</form>
</body>

<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/admin.js"></script>

</html>