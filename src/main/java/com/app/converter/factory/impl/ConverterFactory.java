package com.app.converter.factory.impl;

import com.app.converter.exception.CustomException;
import com.app.converter.factory.Converter;

public class ConverterFactory {
	
	private static Converter converter=null;
	
	public static Converter getInstance(String fileName) throws CustomException {
		String fileType = fileName.substring(fileName.lastIndexOf('.')+1);
		if("jpg".equalsIgnoreCase(fileType) || "png".equalsIgnoreCase(fileType) || "gif".equalsIgnoreCase(fileType) || "jpeg".equalsIgnoreCase(fileType)) {
			converter = new ImageToPDFConverter();
		}
		else {
			throw new CustomException("", "unsupported format" + fileType);
		}
		return converter;
	}

}
