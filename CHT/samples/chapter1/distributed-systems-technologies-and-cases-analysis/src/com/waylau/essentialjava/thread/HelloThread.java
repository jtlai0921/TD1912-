package com.waylau.essentialjava.thread;

/**
 * 繼承 Thread 定義和啟動一個執行緒
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016年7月28日
 */
public class HelloThread extends Thread {
	
	@Override
	public void run() {
        System.out.println("Hello from a thread!");
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new HelloThread()).start();
	}

}
