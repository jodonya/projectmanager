package com.asal.projectmanager.service;

import java.util.Date;

public class SequentialWorker {
	
	public SequentialWorker(){
		
		
	}
	
	private static int numberOfJobs = 5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Date startTime =  new Date();
		
		System.out.println("Start Work "+startTime);
		for (int i=0; i < numberOfJobs; i++){
			System.out.println(" Start Worker "+i);
			SlowWorker worker =  new SlowWorker();
			worker.doWork();
			
			
		}
		
		 System.out.println("... try to do something while the work is being done....");
		 Date endTime = new Date();
		 System.out.println("End work at " + endTime);
		 
		 System.out.println("Job took " + new Double(0.001*(endTime.getTime() - startTime.getTime()))+ " seconds");
	        System.exit(0);
	}

}
