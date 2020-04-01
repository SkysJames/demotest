package com.example.demotest.test;

import java.util.Calendar;

import org.openjdk.jol.info.ClassLayout;

public class CacheLineTest {

	private static class T {
		public static long p1,p2,p3,p4,p5,p6,p7;
		// long类型刚好8个字节
		public static volatile long x = 0L;
		public static long p8,p9,p10,p11,p12,p13,p14;
	}
	
	public static T[] arr = new T[2];
	
	static {
		arr[0] = new T();
		arr[1] = new T();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (long i=0; i<1000_0000L; i++) {
				arr[0].x = i;
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (long i=0; i<1000_0000L; i++) {
				arr[1].x = i;
			}
		});
		
		final long startLong = System.currentTimeMillis();
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println("耗时：" + (System.currentTimeMillis() - startLong) + "ms");
	}

}
