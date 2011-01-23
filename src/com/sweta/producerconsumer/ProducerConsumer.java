/**
 * @copyright (C) 2011
 * @author Sweta Vajjhala (work jointly with David Ackerman)
 * This code is free to use for purposes of studying, but it may NOT be submitted as 
 * part of school assignments and may NOT be used for profit. If this code is copied
 * for any purpose, you must also include this notice.
*/

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
