package com.wjq.jvm;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jol.info.ClassLayout;

/**
 *
 * @author wangjianqiang24
 * @date 2020/11/2
 */
public class SychronizedTest {

	static class A{

	}

	static A a;
	static List<A> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		threadId();
		//rebias();
	}

	static void rebias() throws InterruptedException {
		Thread.sleep(5000);
		a = new A();
		System.out.println("t1");
		System.out.println(ClassLayout.parseInstance(a).toPrintable());
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 30; i++) {
					A a = new A();
					synchronized (a) {
						list.add(a);
					}
					if (i == 3) {
						System.out.println("t1--" + ClassLayout.parseInstance(a).toPrintable());
					}
				}
			}
		};
		t1.start();
		t1.join();
		Thread tnull = new Thread() {
			@Override
			public void run() {
				super.run();
			}
		};
		tnull.start();
		System.out.println("t2");
		Thread t2 = new Thread() {
			A a15;
			int k = 0;

			public void run() {
				for (A a : list) {
					synchronized (a) {
						if (k == 18 || k == 19 || k == 29) {
							System.out.println(k + "---------" + ClassLayout.parseInstance(a).toPrintable());
						}
						if (k == 28) {
							a15 = list.get(15);
						}
					}
					k++;
				}
				synchronized (a15) {
					System.out.println("----15-----" + ClassLayout.parseInstance(a15).toPrintable());
					//此时打印的是轻量级锁
				}
			}
		};
		t2.start();
	}



	static void threadId() throws InterruptedException {
		Thread.sleep(5000);
		a = new A();
		System.out.println("t1");
		Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					list.add(a);
					System.out.println(ClassLayout.parseInstance(a).toPrintable());
				}
			}
		};
		t1.start();
		t1.join();

		System.out.println("t2");
		Thread t2 = new Thread() {
			public void run() {
				synchronized (a) {
					System.out.println("---------" + ClassLayout.parseInstance(a).toPrintable());
				}
			}
		};
		t2.start();
	}

}
