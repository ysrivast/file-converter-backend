package com.app.converter.service.impl;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.converter.exception.CustomException;
import com.app.converter.factory.Converter;
import com.app.converter.factory.impl.ConverterFactory;
import com.app.converter.service.FileConvertService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

@Service
public class FileConvertServiceImpl implements FileConvertService {
	private static final String FILE_WRITE_LOCATION = "src/main/resources/files/";

	@Override
	public String convert(MultipartFile file)
			throws CustomException, DocumentException, IOException {

		if (file == null || file.isEmpty()) {
			throw new CustomException("", "File is empty");
		}
		String fileName = file.getOriginalFilename();
		Document document = new Document();
		Converter converter = ConverterFactory.getInstance(fileName);
		return converter.convert(document, fileName);
	}

	@Override
	public Resource getFile(String fileName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(FILE_WRITE_LOCATION + fileName);
		return new InputStreamResource(fileInputStream);
	}

}
