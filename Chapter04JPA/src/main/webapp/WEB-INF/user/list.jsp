<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	border-collapse: collapse;
}
th, td{
	padding: 5px;
	width: 200px;
}
#currentPaging {
	border: 1px solid black;
	color: red;
	cursor: pointer;
	font-size: 15pt;
	margin: 5px;
	padding: 5px 8px;
}
#paging {
	color: black;
	cursor: pointer;
	font-size: 15pt;
	margin: 5px;
	padding: 5px;
}
span:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<input type="hidden" id="pg" value="${pg }"/><br><br>
	
	<!-- <a href="/Chapter06_Web/"><img src="../image/bitcamp.png" width="200" height="200"></a> -->
	<table border="1" frame="hsides" role="rows" id="userListTable">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
		
		<!-- 동적 처리 -->
	</table>
	<!-- <div id="userPagingDiv" style="text-align: center; width: 650px; margin-top: 15px;">	
		</div> -->
<script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/list.js"></script>
<script type="text/javascript">
/* function userPaging(pg) {
	location.href = "/Chapter06_Web/user/list?pg=" + pg;
} */
</script>
</body>
</html>