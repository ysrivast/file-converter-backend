package com.app.converter.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.converter.exception.CustomException;


public interface FileStorageService {
	public void storeFile(MultipartFile file) throws IOException, CustomException ;
	public void deleteFiles() throws IOException;

}
