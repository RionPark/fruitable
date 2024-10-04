package com.shop.fruitable.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfoVO {

	private Integer usiNum;
	private String usiName;
	private String usiId;
	private String usiPwd;
	private String usiImgPath;
	private MultipartFile usiImg;
	private String usiDesc;
	private String credat;
	private String cretim;
}
