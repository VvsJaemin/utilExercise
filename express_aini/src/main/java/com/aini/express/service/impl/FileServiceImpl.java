//package com.aini.express.service.impl;
//
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import com.aini.express.dto.FileDTO;
//import com.aini.express.service.FileService;
//import com.aini.express.utils.FileUtil;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class FileServiceImpl implements FileService {
//	
//	@Autowired
//	private FileUtil fileUtil;
//
//	@Override
//	public void insertFile(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
//		// TODO Auto-generated method stub
//		
//		List<FileDTO> fileList = fileUtil.parseFileInfo(multipartHttpServletRequest);
//		
//		if(CollectionUtils.isEmpty(fileList)==false) {
//			
//		}
//		
//		if(ObjectUtils.isEmpty(multipartHttpServletRequest)==false) {
//			Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//			String name;
//			while(iterator.hasNext()) {
//				name = iterator.next(); 
//				log.debug("file tag name : " + name);
//				List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
//				for(MultipartFile multipartFile : list) {
//					log.debug("Start File Infomation");
//					log.debug("파일 명 : " + multipartFile.getOriginalFilename());	
//					log.debug("파일 크기 : " + multipartFile.getSize());	
//					log.debug("파일 확장자 : " + multipartFile.getContentType());		
//				}
//			}
//		}
//		
//	}
//
//}
