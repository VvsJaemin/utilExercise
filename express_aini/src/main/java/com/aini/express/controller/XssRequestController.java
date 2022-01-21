package com.aini.express.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aini.express.dto.XssRequestDto;
import com.aini.express.dto.XssRequestDto2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class XssRequestController {
	
	@GetMapping("/xss")
	public Map<String, Object> responseXss(){
		Map<String, Object> result = new HashMap<>();
		

		result.put("htmlTdTag", "<td></td>");
		result.put("htmlTableTag", "<table>");
		
		log.info("result = " + result);

	    return result;
		
	}
}
