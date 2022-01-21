package com.aini.express.utils;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aini.express.dto.FileDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileUtil {

	/**
	 * 현재 날짜로 업로드 저장 폴더 생성
	 * 
	 * @return
	 */
	private static String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 단일 파일 업로드 저장
	 * 
	 * @param uploadFile
	 * @throws Exception
	 */
	public static void saveOneFile(MultipartFile uploadFile) throws Exception {
		String uploadFolder = "C:\\upload\\single";
		File uploadPath = new File(uploadFolder, getFolder());
		log.info("업로드 경로 : " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		String uploadFileName = uploadFile.getOriginalFilename();

		log.info("파일 원본 이름 : " + uploadFileName);
		log.info("파일 크기 : " + uploadFile.getSize() + " Byte");

		String ext = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
		log.info("파일 확장자 : " + ext);

		uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);

		uploadFileName = Long.toString(System.nanoTime()) + "_" + uploadFileName;
		log.info("업로드 파일 명 : " + uploadFileName);

		File saveOneFile = new File(uploadPath, uploadFileName);

		if (isPermissionFileExt(uploadFileName) == true) {
			uploadFile.transferTo(saveOneFile);
		} else {
			log.error("허용되지 않은 확장자 입니다.(이미지 및 pdf, zip파일만 가능)");
		}

	}

	/**
	 * 다중 파일 업로드 저장
	 * 
	 * @param uploadFile
	 * @throws Exception
	 */

	public static void saveFile(MultipartFile[] uploadFile) throws Exception {
		String uploadFolder = "C:\\upload";
		File uploadPath = new File(uploadFolder, getFolder());
		log.info("업로드 경로 : " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : uploadFile) {
			log.info("----------------------------------");
			log.info("파일 원본 이름 : " + multipartFile.getOriginalFilename());
			log.info("파일 크기 : " + multipartFile.getSize() + " Byte");
			String uploadFileName = multipartFile.getOriginalFilename();

			String ext = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
			log.info("파일 확장자 : " + ext);

			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);

			uploadFileName = Long.toString(System.nanoTime()) + "_" + uploadFileName;
			log.info("업로드 파일 명 : " + uploadFileName);

			File saveFile = new File(uploadPath, uploadFileName);

			if (isPermissionFileExt(uploadFileName) == true) {
				multipartFile.transferTo(saveFile);
			} else {
				log.error("허용되지 않은 확장자 입니다.(이미지 및 pdf, zip파일만 가능)");
			}

		}

	}

	/**
	 * 파일 업로드 시 확장자 검증
	 * 
	 * @param uploadFileName
	 * @return
	 * @throws Exception
	 */
	private static boolean isPermissionFileExt(String uploadFileName) throws Exception {
		// 파일 업로드시 허용하는 확장자 명
		final String[] PERMISSION_FILE_EXT_ARR = { "GIF", "JPEG", "JPG", "PNG", "BMP", "PDF", "ZIP" };

		if (!StringUtils.hasText(uploadFileName)) {
			return false;
		}

		// 확장자만 잘라서 검증
		String[] fileNameArr = ((String) uploadFileName).split("\\.");

		if (fileNameArr.length == 0) {
			return false;
		}

		String ext = fileNameArr[fileNameArr.length - 1].toUpperCase();

		boolean isPermissionFileExt = false;

		for (int i = 0; i < PERMISSION_FILE_EXT_ARR.length; i++) {
			if (PERMISSION_FILE_EXT_ARR[i].endsWith(ext)) {
				isPermissionFileExt = true;
				break;
			}
		}
		return isPermissionFileExt;
	}

	/*
	 * private static final String RUNABLE_FILE_EXT =
	 * "^(.*\\.)(?i)(bat|bin|cmd|com|cpl|dll|exe|gadget|inf1|ins|isu|jse|lnk|msc|msi|msp"
	 * +
	 * "|mst|paf|pif|ps1|reg|rgs|scr|sct|sh|shb|shs|u3p|vb|vbe|vbs|vbscript|ws|wsf|wsh)$";
	 * 
	 * // 확장자가 실행 파일이면 true를 반환한다. private static boolean
	 * checkRunableExtension(String fileName) { if (fileName == null) return false;
	 * return fileName.matches(RUNABLE_FILE_EXT); }
	 */

}
