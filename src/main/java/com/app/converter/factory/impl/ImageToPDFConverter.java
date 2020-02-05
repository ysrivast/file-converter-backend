package com.app.converter.factory.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.app.converter.factory.Converter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageToPDFConverter implements Converter{

	private static final String FILE_WRITE_LOCATION="src/main/resources/files/";
	private static final String FILE_STORAGE_LOCATION="src/main/resources/files/";
	@Override
	public String convert(Document document, String imageFile) throws DocumentException, IOException {
		String uniqueID = UUID.randomUUID().toString();
		String fileName = uniqueID+".pdf";
		FileOutputStream fos = new FileOutputStream(FILE_WRITE_LOCATION+fileName);
	      PdfWriter writer = PdfWriter.getInstance(document, fos);
	      writer.open();
	      document.open();
	      Image image =Image.getInstance(FILE_STORAGE_LOCATION+imageFile);
	      image.scalePercent(50);
	      image.setAlignment(Image.MIDDLE);
	      document.add(image);
	      document.close();
	      writer.close();
	      return fileName;
	}

}
