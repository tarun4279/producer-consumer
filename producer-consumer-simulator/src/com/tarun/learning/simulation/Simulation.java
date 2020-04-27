package com.tarun.learning.simulation;


import java.util.LinkedList;
import java.util.Queue;

import com.tarun.learning.consumer.WorkConsumer;
import com.tarun.learning.producer.WorkProducer;
import com.tarun.learning.request.WorkRequest;

public class Simulation {

	static Queue<WorkRequest> workQueue = new LinkedList<>();
	
	
	public static void main(String[] args) {
		
//		WorkConsumerGroup consumer = new WorkConsumerGroup(100, 100, 0, TimeUnit.MILLISECONDS, workQueue);
		prepareAndStartConsumer("C1");
		prepareAndStartProducer("P1");		
		
		
	}
	
	
	private static void prepareAndStartConsumer(String name) {
		WorkConsumer consumer = new WorkConsumer(name);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					consumer.startConsuming(workQueue);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
	}
	
	
	private static void prepareAndStartProducer(String name) {
		WorkProducer producer = new WorkProducer(name, 10);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producer.startProduction(workQueue);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
	}

}
