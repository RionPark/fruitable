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
									placeholder="Yur ID *" id="usiId" value="${user.usiId}">
							</div>
						</div>
						<div class="col-lg-12">
							<div class="border-bottom rounded">
								<input type="text" class="form-control border-0 me-4"
									placeholder="Yur Password *" id="usiName" value="${user.usiName}">
							</div>
						</div>
						<div class="col-lg-12">
							<div class="border-bottom rounded">
								<input type="file" class="form-control border-0 me-4"
									placeholder="Yur Password *" id="usiImg">
								<c:if test="${not empty user.usiImgPath}">
									<img src="${user.usiImgPath}" class="img-fluid rounded-circle p-3" style="width: 100px; height: 100px;" alt="">
								</c:if>									
							</div>
						</div>
						<div class="col-lg-12">
							<div class="border-bottom rounded">
								<textarea id="usiDesc">${user.usiDesc}</textarea>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="d-flex align-items-center py-3 mb-5">
								<div class="d-flex align-items-center">
									<a href="javascript:modifyUser()"
										class="btn border border-secondary text-primary rounded-pill px-4 py-3">
										수정</a>
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
function modifyUser(){
	const formData = new FormData();
	formData.append('usiId',document.querySelector('#usiId').value);
	formData.append('usiName',document.querySelector('#usiName').value);
	formData.append('usiDesc',document.querySelector('#usiDesc').value);
	const fileObj = document.querySelector('#usiImg');
	if(fileObj.files.length==1){
		const usiImg = fileObj.files[0];
		formData.append('usiImg',usiImg);
	}
	
	const conf = {
			url : '/users',
			method : 'PUT',
			param : formData,
			callback : function(res){
				if(res === '1'){
					alert('회원정보가 수정되었습니다.');
					location.reload();
				}
			}
	}
	ajax(conf);
}
</script>
<%@ include file="/WEB-INF/views/common/bottom.jsp"%>