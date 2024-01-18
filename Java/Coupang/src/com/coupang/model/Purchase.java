package com.coupang.model;

import java.util.Date;

public class Purchase {

	private int purCode;
	private Date purDate;
	private String purStatus;
	// 조건식'구매대기중','구매중','구매완료','배송대기중','배송중','배송완료'

	private Customer customer;
	private Product product;
}
