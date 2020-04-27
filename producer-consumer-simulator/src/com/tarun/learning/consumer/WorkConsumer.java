package com.tarun.learning.consumer;

import java.util.Queue;

import com.tarun.learning.request.WorkRequest;

public class WorkConsumer {
	
	private String name;
	private boolean aborted;

	public WorkConsumer(String name) {
		this.name = name;
	}
	
	public void startConsuming(Queue<WorkRequest> queue) throws InterruptedException {
		
		while(!this.aborted) {
			
			WorkRequest request = queue.poll();

			if(request != null) {
				System.err.print("Request : " + request.getId() + " picked by  " + this.name);
				request.run();
			}
			Thread.sleep(1000);
			System.err.println("Queue-size" + queue.size());
		}
		
	}
	
	public void abort() {
		this.aborted = true;
	}
}
