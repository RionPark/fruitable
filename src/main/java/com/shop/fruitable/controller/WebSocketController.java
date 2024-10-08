package com.shop.fruitable.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.shop.fruitable.vo.ChatMsg;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WebSocketController {

	@MessageMapping("/chat")
	@SendTo("/test/listen")
	public ChatMsg sendChatMsg(ChatMsg chatMsg) {
		return chatMsg;
	}
	
	@MessageMapping("/bb")
	@SendTo("/game/baseball")
	public ChatMsg mine(ChatMsg chatMsg) {
		return chatMsg;
	}
	
	@MessageMapping("/check")
	@SendTo("/game/check")
	public ChatMsg check(ChatMsg chatMsg) {
		return chatMsg;
	}
}
