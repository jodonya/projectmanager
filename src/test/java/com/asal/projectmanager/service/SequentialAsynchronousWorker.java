package com.asal.projectmanager.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SequentialAsynchronousWorker {

	public SequentialAsynchronousWorker() {

	}

	private static int numberOfJobs = 5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date startTime = new Date();

		System.out.println(" Start Work " + startTime);

		ExecutorService es = Executors.newFixedThreadPool(3);

		List<Future<Object>> futures = new ArrayList<Future<Object>>();

		for (int i = 0; i < numberOfJobs; i++) {

			System.out.println(" Start Work " + i);
			futures.add(es.submit(new Callable<Object>() {

				public Object call() throws Exception {
					new SlowWorker().doWork();
					return null;
				}

			}));

		}

		System.out
				.println("... try to do something while the work is being done....");
		System.out.println("... and more ....");
		
		int ctr = 0;
		for(Future<Object> future : futures){
			try {
				future.get(); // blocking call, explicitly waiting for the response from a specific task, not necessarily the first task that is completed
				System.out.println(" *** response worker"+ ++ctr +" is in");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Date endTime = new Date();
		
		System.out.println("End of Work at "+endTime);
		System.out.println(" Job took ..."+ new Double(0.001*(endTime.getTime() - startTime.getTime()))+" seconds");
		System.exit(0);

	}

}
