package com.aini.express.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aini.express.dto.FileDTO;

public interface FileService {
	
	public void insertFile(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
}
