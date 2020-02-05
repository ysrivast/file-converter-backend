package com.app.converter.controller;

import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.converter.exception.CustomException;
import com.app.converter.service.FileConvertService;
import com.app.converter.service.FileStorageService;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("/converter")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private FileConvertService fileConvertService;

	private Calendar calender = Calendar.getInstance();

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
			throws IOException, CustomException, DocumentException {
		logger.info("file conversion started at ", calender.getTime());
		if (file.isEmpty()) {
			return new ResponseEntity<>("empty file", HttpStatus.OK);
		}
		fileStorageService.storeFile(file);
		String fileName = fileConvertService.convert(file);
		logger.info("file conversion ended at " + calender.getTime());
		return new ResponseEntity<>(fileName, HttpStatus.OK);
	}

	@PostMapping("/download-file")
	public ResponseEntity<Resource> download(@RequestBody String fileName) throws IOException {
		Resource resource = fileConvertService.getFile(fileName);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test() throws IOException {
		fileStorageService.deleteFiles();
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
}
