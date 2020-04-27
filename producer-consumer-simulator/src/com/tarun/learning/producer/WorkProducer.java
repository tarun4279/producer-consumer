package com.tarun.learning.producer;

import java.util.Queue;
import java.util.UUID;
import java.util.function.Function;

import com.tarun.learning.request.WorkRequest;

public class WorkProducer {

	private String name;
	private int cps;

	private static boolean aborted = false;
	
	public WorkProducer(String name, int cps) {
		this.name = name;
		this.cps = cps;
	}
	
	
	public void startProduction(Queue<WorkRequest> workQueue) throws InterruptedException {
		
		int sleepTime =   1000 / cps;
		
		while(!aborted) {
			
				
				String workName = this.name+"-"+UUID.randomUUID().toString();
				System.out.println("Adding a new work item : " + workName + "to the queue");
				workQueue.add(new WorkRequest(workName, new Function<Void, Void>() {

					@Override
					public Void apply(Void t) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						return null;
					}
				}));
				
				Thread.sleep(sleepTime);
			
		}

		
	}
	
	public void abort() {
		aborted = true;
	}
	
	
	public String getName() {
		return name;
	}
	
	
}
