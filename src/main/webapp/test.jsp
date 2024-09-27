<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="test" class="a b">
	<div><div></div></div>
	<a href="1">a</a>
</div>
<div id="test" class="b">
	<div></div>
</div>

<script>
	const divs = document.querySelectorAll('#test.a,.b');
	alert(divs.length);
</script>
</body>
</html>