package com.sweta.producerconsumer;

public class ProducerConsumer extends Thread {

	protected ThreadedQueue<Integer> q;
	protected final String name;
	private final int sleepTime;

	public ProducerConsumer(ThreadedQueue<Integer> q, String name, int sleepTime) {
		this.q = q;
		this.name = name;
		this.sleepTime = sleepTime;
	}
	
	protected void sleepForTime() {
		try {
			sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
