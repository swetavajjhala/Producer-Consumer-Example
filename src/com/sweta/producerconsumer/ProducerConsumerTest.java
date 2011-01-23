package com.sweta.producerconsumer;

public class ProducerConsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadedQueue<Integer> q = new ThreadedQueue<Integer>(5);
		Producer p1 = new Producer(q, "Soumya", 1500);
		Producer p2 = new Producer(q, "Sweta", 500);
		Consumer c1 = new Consumer(q, "Kim", 800);
		Consumer c2 = new Consumer(q, "Roger", 700);
		
		p1.start();
		p2.start();
		c1.start();
		c2.start();
	}

}
