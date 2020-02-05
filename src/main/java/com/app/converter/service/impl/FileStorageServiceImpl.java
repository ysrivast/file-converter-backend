package com.app.converter.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.converter.exception.CustomException;
import com.app.converter.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {
	
	private static final String FILE_STORAGE_LOCATION="src/main/resources/files/";
	
	@Override
	public void storeFile(MultipartFile file) throws IOException, CustomException {
		if (file.isEmpty()) {
			throw new CustomException("", "file is empty");
		}
		byte[] bytes = file.getBytes();
		Path path = Paths.get(FILE_STORAGE_LOCATION, file.getOriginalFilename());
		Files.write(path, bytes);
	}

	@Override
	public void deleteFiles() throws IOException {
		try (Stream<Path> paths = Files.walk(Paths.get("D:\\\\temp\\\\out\\\\"))){
			paths
			.filter(x -> ((System.currentTimeMillis()-x.toFile().lastModified())>3600000 && !x.toFile().isDirectory()))
			.map(Path :: toFile)
			.forEach(File :: delete);
			}
	}
}
