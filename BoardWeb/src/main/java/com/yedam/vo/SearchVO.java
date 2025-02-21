package com.yedam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchVO {

	private int page;
	private String searchCondition;
	private String keyword;
	
}
