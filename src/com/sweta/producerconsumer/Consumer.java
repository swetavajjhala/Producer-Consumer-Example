/**
 * @copyright (C) 2011
 * @author Sweta Vajjhala (work jointly with David Ackerman)
 * This code is free to use for purposes of studying, but it may NOT be submitted as 
 * part of school assignments and may NOT be used for profit. If this code is copied
 * for any purpose, you must also include this notice.
*/

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
