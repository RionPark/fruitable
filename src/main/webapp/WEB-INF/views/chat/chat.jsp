<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="main">

<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<div class="container-fluid py-5 mt-5">
		<div class="container py-5">
			<div class="row g-4 mb-5">
				<div class="col-lg-8 col-xl-9"></div>
				<form action="#">
					<h4 class="mb-5 fw-bold">채팅</h4>
					<div class="row g-4">
						
						<div class="col-lg-12">
							<div class="border-bottom rounded">
								<textarea id="content" class="form-control border-1 me-4" style="resize:none;height:200px"></textarea>
							</div>
							
						</div>
						<div class="col-lg-6">
							<div class="border-bottom rounded">
								<input type="text" class="form-control border-0 me-4"
									placeholder="니이름" id="name">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="border-bottom rounded">
								<input type="text" class="form-control border-0 me-4"
									placeholder="내용" id="msg">
							</div>
						</div>
						<div class="col-lg-12">
							<div class="d-flex align-items-center py-3 mb-5">
								<div class="d-flex align-items-center">
									<a href="javascript:sendMsg()"
										class="btn border border-secondary text-primary rounded-pill px-4 py-3">
										전송</a>
								</div>

							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
<script>
const ws = new SockJS('http://' + location.hostname + '/ws');
const stomp = Stomp.over(ws);
stomp.connect({},function(data){
	console.log(data);

	stomp.subscribe('/test/listen',function(data){
		const chatMsg = JSON.parse(data.body);
		document.querySelector('#content').value += chatMsg.name + ' : ' + chatMsg.msg + '\r\n';
	});
})

function sendMsg(){
	const param = {
			name : document.querySelector('#name').value,
			msg : document.querySelector('#msg').value
	}
	stomp.send('/chat/chat',{},JSON.stringify(param));
}
</script>
</div>
<%@ include file="/WEB-INF/views/common/bottom.jsp"%>