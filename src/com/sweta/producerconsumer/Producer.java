package com.sweta.producerconsumer;

public class Producer extends ProducerConsumer {

	public Producer(ThreadedQueue<Integer> q, String name, int sleepTime) {
		super(q, name, sleepTime);
	}

	@Override
	public void run() {
		while(true) {
			sleepForTime();
			Integer randNum = getRandom();
			System.out.println(name + " generated random number: " + randNum);
			q.put(randNum);
			System.out.println(name + " is sleeeeeeping...");
		}
	}

	private Integer getRandom() {
		return Integer.valueOf((int)(Math.random()*100));
	}

}
