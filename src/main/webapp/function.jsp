<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="test" data-format="test"></div>
<button onclick="makeSome()">생성</button>
<script>
function makeSome(){
	let html = '<div id="m1">안녕</div>';

	document.querySelector('#m1').onclick = function(){
		alert('hello');
	}
	document.querySelector('#test').innerHTML = html;
}
</script>
</body>
</html>