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
					<div class="row g-4" id="startDiv">
						<div class="col-lg-6">
							<div class="border-bottom rounded">
								<input type="text" class="form-control border-0 me-4"
									placeholder="니이름" id="name">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="border-bottom rounded">
								<input type="text" class="form-control border-0 me-4"
									placeholder="내 야구숫자" id="myNumber">
							</div>
						</div>
						
						<div class="col-lg-12">
							<div class="d-flex align-items-center py-3 mb-5">
								<div class="d-flex align-items-center">
									<a href="javascript:startGame()"
										class="btn border border-secondary text-primary rounded-pill px-4 py-3">
										시작</a>
								</div>

							</div>
						</div>
					</div>
					<div class="row g-4" style="display:none" id="gameDiv">
						
						<div class="col-lg-12">
							<div class="border-bottom rounded">
								<textarea id="content" class="form-control border-1 me-4" style="resize:none;height:200px"></textarea>
							</div>
							
						</div>
						<div class="col-lg-6">
							<div class="border-bottom rounded">
								<input type="text" class="form-control border-0 me-4"
									placeholder="맞출 숫자" id="msg">
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
let name = '';
let myNumber = '';

stomp.connect({},function(data){
	console.log(data);

	stomp.subscribe('/game/check',function(data){
		const chatMsg = JSON.parse(data.body);
		if(chatMsg.name === name){
			return;
		}
		document.querySelector('#content').value += name + ' : ' + chatMsg.msg + '\r\n';
	});
	stomp.subscribe('/game/baseball',function(data){
		const chatMsg = JSON.parse(data.body);
		if(chatMsg.name === name){
			return;
		}
		let strike = 0;
		let ball = 0;
		for(let i = 0 ;i <myNumber.length;i++){ //134 // 123
			const idx = chatMsg.msg.indexOf(myNumber[i]);
			if(idx!==-1){
				if(idx===i){
					strike++;
				}else{
					ball++;
				}
			}
		}
		let msg = chatMsg.msg + ',' + strike +'S ' + ball + 'B';
		if(strike===3){
			msg = chatMsg.msg + ',[OUT]Game Over';
		}

		const param = {
				name : name,
				msg : msg
		}
		stomp.send('/chat/check',{},JSON.stringify(param));
		
		document.querySelector('#content').value += chatMsg.name + ' : ' + msg + '\r\n';
	});
})
function startGame(){
	name = document.querySelector('#name').value;
	if(name.trim().length<2){
		alert('이름은 2글자 이상입니다.');
		return;
	}
	myNumber = document.querySelector('#myNumber').value;
	
	myNumber = parseInt(myNumber)
	if(isNaN(myNumber) ){
		alert('숫자만 작성가능합니다.');
		return;
	}
	
	myNumber += '';
	if(myNumber.trim().length!==3){
		alert('숫자3개를 작성해주세요.');
		return;
	}
	
	document.querySelector('#gameDiv').style.display='';
	document.querySelector('#startDiv').style.display='none';
}
function sendMsg(){
	let msg = document.querySelector('#msg').value;
	
	msg = parseInt(msg)
	if(isNaN(msg) ){
		alert('숫자만 작성가능합니다.');
		return;
	}
	
	msg += '';
	if(msg.trim().length!==3){
		alert('숫자3개를 작성해주세요.');
		return;
	}
	const param = {
			name : name,
			msg : msg
	}
	stomp.send('/chat/bb',{},JSON.stringify(param));
}
</script>
</div>
<%@ include file="/WEB-INF/views/common/bottom.jsp"%>