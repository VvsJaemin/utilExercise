package com.aini.express.mapper;

import java.util.List;

import com.aini.express.dto.FileDTO;

public interface FileMapper {
	
	void fileList(List<FileDTO> list) throws Exception;
}
