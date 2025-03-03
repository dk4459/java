package com.yedam.kakao;

import java.sql.Date;

import lombok.Data;

@Data
public class KakaoVO {
	private int id;
	private String userId;
	private String subscriptionId;
	private Date nextPaymentDate;
	private String status;
	private Date createdAt;
}
