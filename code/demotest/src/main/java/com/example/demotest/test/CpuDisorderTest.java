package com.example.demotest.test;

public class CpuDisorderTest {

	private static int x,y,a,b;
	
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while(true) {
			i++;
			x = 0; y = 0;
			a = 0; b = 0;
			Thread t1 = new Thread(() -> {
				a = 1;
				x = b;
			});
			Thread t2 = new Thread(() -> {
				b = 1;
				y = a;
			});
			
			t1.start();t2.start();
			t1.join();t2.join();
			
			// 如果cpu没有乱序执行，那么不可能出现x和y同时等于0的情况
			if (x == 0 && y == 0) {
				System.out.println("第" + i + "次，(" + x + ", " + y + ")");
				break;
			}
		}
	}

}
