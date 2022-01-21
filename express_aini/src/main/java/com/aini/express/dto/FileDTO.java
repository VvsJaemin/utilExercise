package com.aini.express.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDTO {
	private int idx;
	private String fileName;
	private String origin_file_name;
	private String file_path;
	private Long file_size;
	private String file_ext;
}
