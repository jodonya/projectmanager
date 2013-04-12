package com.asal.projectmanager.service;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SlowWorker {
	

	private static int i=0;
	public SlowWorker(){
		i++;
	}
	
	public void doWork(){
		try {
			System.out.println("==== working, working, working ====== "+" (Worker Id = "+i+")");
			Thread.sleep(2000);
			System.out.println("==== ready! ======");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Start Work "+ new Date());
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		final Future<Object> future = es.submit(new Callable<Object>() {
			public Object call() throws Exception{
				new SlowWorker().doWork();
				return null;
			}
		});
		
		System.out.println("Try doing something while work is being done ");
		System.out.println(" and more ");
		
		try {
			future.get(); //blocking call - the main thread blocks until task is done
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(" End Work " + new Date());
		System.exit(0);
	}

}
