package com.tarun.learning.request;

import java.util.function.Function;

public class WorkRequest implements Runnable{
	
	private String id;
	private Function<Void, Void> workFunction;
	
	
	public WorkRequest(String id, Function<Void, Void> work) {
		this.id = id;
		this.workFunction = work;
	}
	
	
	@Override
	public void run() {
		
		System.out.println();

		System.out.println("Staring work : " + id);
		workFunction.apply(null);
		System.out.println("Completed work : " + id);
		
		System.out.println();
		
	}

	public String getId() {
		return id;
	}
}
