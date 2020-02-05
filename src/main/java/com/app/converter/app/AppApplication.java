package com.app.converter.app;

import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.converter.service.FileStorageService;

@SpringBootApplication(scanBasePackages = "com.app.converter")
@EnableBatchProcessing
public class AppApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(AppApplication.class);
	
	@Autowired
	private FileStorageService fileStorageService;
	private Calendar calendar = Calendar.getInstance();
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Scheduled(cron = "0 * * * *")
	public void removeOldFiles() throws IOException {
		logger.info("batch job is starting at " + calendar.getTime());
		fileStorageService.deleteFiles();
		logger.info("batch job is ending at " + calendar.getTime());
	}

}
