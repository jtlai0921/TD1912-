package com.waylau.essentialjava.thread;

/**
 * �~�� Thread �w�q�M�Ұʤ@�Ӱ����
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016�~7��28��
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
