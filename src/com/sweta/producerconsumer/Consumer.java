package com.sweta.producerconsumer;

public class Consumer extends ProducerConsumer {	
	
	public Consumer(ThreadedQueue<Integer> q, String name, int sleepTime) {
		super(q, name, sleepTime);
	}
	
	@Override
	public void run() {
		while(true) {
			sleepForTime();
			Integer value = q.get();
			System.out.println(name + " got value: " + value);
		}
	}
}
