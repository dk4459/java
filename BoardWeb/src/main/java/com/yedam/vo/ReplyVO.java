package com.yedam.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int replyNo;
	private String reply;
	private String replyer;
	private int boardNo;
	private Date replyDate;
}
