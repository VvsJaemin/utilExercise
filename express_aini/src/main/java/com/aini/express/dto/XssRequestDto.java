package com.aini.express.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class XssRequestDto {
	private String content;

	public XssRequestDto(String content) {
		this.content = content;
	}
	
}
