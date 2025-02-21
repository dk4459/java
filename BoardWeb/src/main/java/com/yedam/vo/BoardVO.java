package com.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private int boardNo; // boat
	private String title;
	private String content;
	private String writer;
	private Date writerDate;
	private int viewCnt;
	private String img;
	
	
}
