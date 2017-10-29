package com.bdo.esoa.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.bdo.esoa.service.FileFinderService;

public class EsoaJob implements Job {
	
	@Autowired
	FileFinderService service;

	@Override
	public void execute(JobExecutionContext arg0) {
		try {
			System.out.println("STARTING JOB");
			
			service.findFileAndSavesomewhere();
		
		} catch (Exception e) {
			System.out.println("Encountered exception");
			e.printStackTrace();
		}
			
	}

}
