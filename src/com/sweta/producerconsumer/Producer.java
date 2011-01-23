/**
 * @copyright (C) 2011
 * @author Sweta Vajjhala (work jointly with David Ackerman)
 * This code is free to use for purposes of studying, but it may NOT be submitted as 
 * part of school assignments and may NOT be used for profit. If this code is copied
 * for any purpose, you must also include this notice.
*/

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
