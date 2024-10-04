<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="main">

	<div class="container-fluid py-5 mt-5">
		<div class="container py-5">
			<div class="row g-4 mb-5">
				<div class="col-lg-8 col-xl-9"></div>
				<form action="#">
					<h4 class="mb-5 fw-bold">Login</h4>
					<div class="row g-4">
						<div class="col-lg-12">
							<div class="border-bottom rounded">
								<input type="text" class="form-control border-0 me-4"
									placeholder="Yur ID *" id="usiId">
							</div>
						</div>
						<div class="col-lg-12">
							<div class="border-bottom rounded">
								<input type="password" class="form-control border-0 me-4"
									placeholder="Yur Password *" id="usiPwd">
							</div>
						</div>
						<div class="col-lg-12">
							<div class="d-flex align-items-center py-3 mb-5">
								<div class="d-flex align-items-center">
									<a href="javascript:login()"
										class="btn border border-secondary text-primary rounded-pill px-4 py-3">
										Login</a>
								</div>

							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
</div>
<script>
function login(){
	const param = {
			usiId : document.querySelector('#usiId').value,
			usiPwd : document.querySelector('#usiPwd').value
	}
	const conf = {
			url : '/login',
			method : 'POST',
			param : JSON.stringify(param),
			json : true,
			callback : function(res){
				if(!res){
					alert('아이디 비밀번호를 확인해주세요!');
				}else{
					const user = JSON.parse(res);
					alert(user.usiName + '님 안녕하세요');
					location.href='/';Z
				}
			}
	}
	ajax(conf);
}
</script>
<%@ include file="/WEB-INF/views/common/bottom.jsp"%>