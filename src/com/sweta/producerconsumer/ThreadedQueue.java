package com.sweta.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadedQueue<T> implements ProducerConsumerQueue<T> {
	
	private final Queue<T> q; //final protects you from saying "x = something"
	private final int maxQueueSize; //private final because this will never change
	
	private final Object consumerLock = new Object();
	private final Object producerLock = new Object();

	public ThreadedQueue(int size) {
		q = new LinkedList<T>();
		maxQueueSize = size;
	}

	@Override
	public T get() {
		T value = lockAndPull();
		while(value == null) {
			System.out.println("List is empty - wait for producer");
			objectWait(consumerLock);
			value = lockAndPull();
		}
		synchronized(producerLock) {
			producerLock.notify();
		}
		return value;
	}

	@Override
	public void put(T value) {
		while(!lockAndPut(value)) {
			System.out.println("List is full - wait for consumer");
			objectWait(producerLock);
		}
		synchronized(consumerLock) {
			consumerLock.notify();
		}
	}
	
	private void objectWait(Object lock) {
		try {
			synchronized(lock) {
				lock.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private T lockAndPull() {
		synchronized(q) {
			T value = q.poll();
			return value;
		}
	}
	
	private boolean lockAndPut(T value) {
		synchronized(q) {
			if(q.size() < maxQueueSize) {
				q.add(value);
				return true;
			} else {
				return false;
			}
		}
	}
}
