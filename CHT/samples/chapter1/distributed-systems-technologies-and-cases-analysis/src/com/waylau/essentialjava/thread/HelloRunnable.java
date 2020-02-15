package com.waylau.essentialjava.thread;

/**
 * 實現 Runnable 定義和啟動一個執行緒
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016年7月28日
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
