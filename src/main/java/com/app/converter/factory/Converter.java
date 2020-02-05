package com.app.converter.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

public interface Converter {
	
	public String convert(Document document, String imageFile) throws FileNotFoundException, DocumentException, MalformedURLException, IOException;

}
