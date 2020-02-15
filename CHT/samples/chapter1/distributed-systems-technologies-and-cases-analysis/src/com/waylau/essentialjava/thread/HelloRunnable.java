package com.waylau.essentialjava.thread;

/**
 * ��{ Runnable �w�q�M�Ұʤ@�Ӱ����
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016�~7��28��
 */
public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from runnable!");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new Thread(new HelloRunnable())).start();
	}
}
