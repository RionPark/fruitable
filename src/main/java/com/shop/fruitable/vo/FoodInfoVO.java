package com.shop.fruitable.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FoodInfoVO {
	private Integer foiNum;
	private String foiName;
	private Integer foiPrice;
	private String foiImgPath;
	private String foiSummary;
	private String foiDesc;
	private String credat;
	private String cretim;
	private Integer caiNum;
	private String caiName;
	private String orderType;
	private int friRate;
	private int start;
	private int count;
}
