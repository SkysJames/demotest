package com.example.demotest.test;

import org.openjdk.jol.info.ClassLayout;

public class Test {
	
	public static void main(String[] args) throws Exception {
		Object o = new Object();
		System.out.println(ClassLayout.parseInstance(o).toPrintable());
		
		Thread a = new Thread(() -> {
			System.out.println("haha-a");
		});
		
		Thread b = new Thread(() -> {
			System.out.println("haha-b");
		});
		
		a.start();b.start();
		a.join();b.join();
		System.out.println("haha------------end");
	}

}
