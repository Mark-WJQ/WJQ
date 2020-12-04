package com.wjq.jvm;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;
import org.openjdk.jol.info.ClassLayout;

/**
 *
 * sychronized 锁机制
 *
 * 批量重偏向：当一个线程创建了大量对象并执行了初始的同步操作，后来另一个线程也来将这些对象作为锁对象进行操作，会导偏向锁重偏向的操作。
 * 批量撤销：在多线程竞争剧烈的情况下，使用偏向锁将会降低效率，于是乎产生了批量撤销机制。
 *
 *	intx BiasedLockingBulkRebiasThreshold   = 20   默认偏向锁批量重偏向阈值
 *	intx BiasedLockingBulkRevokeThreshold  = 40   默认偏向锁批量撤销阈值
 *	当然我们可以通过-XX:BiasedLockingBulkRebiasThreshold 和 -XX:BiasedLockingBulkRevokeThreshold 来手动设置阈值
 * 1、批量重偏向和批量撤销是针对类的优化，和对象无关。
 * 2、偏向锁重偏向一次之后不可再次重偏向。
 * 3、当某个类已经触发批量撤销机制后，JVM会默认当前类产生了严重的问题，剥夺了该类的新实例对象使用偏向锁的权利
 *
 * 偏向锁  01
 *  只有一个线程偏向
 * 轻量锁 00
 *  两个线程竞争
 * 重量锁  10
 * 多个线程竞争
 *
 * @author wangjianqiang24
 * @date 2020/11/2
 */
public class SychronizedTest {

	static class A {
		boolean f;

	}

	static A a;
	static List<A> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		System.out.println(ByteOrder.nativeOrder());
		//threadId();
		//rebias();
		bias();
	}

	static void rebias() throws InterruptedException {
		Thread.sleep(5000);
		a = new A();
		System.out.println("t1");
		System.out.println(ClassLayout.parseInstance(a).toPrintable());

		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 50; i++) {
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
						if (k == 18 || k == 19 || k == 41) {
							System.out.println(k + "---------t2---" + ClassLayout.parseInstance(a).toPrintable());
						}
						if (k == 28) {
							a15 = list.get(15);
						}
					}
					k++;
				}
				synchronized (a15) {
					System.out.println("----15-----t2---" + ClassLayout.parseInstance(a15).toPrintable());
					//此时打印的是轻量级锁
				}
				try {
					Thread.sleep(5000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t2.start();
		//t2.join();
		System.out.println("t3");
		Thread t3 = new Thread() {
			A a15;
			int k = 0;

			public void run() {
				for (A a : list) {
					synchronized (a) {
						if (k == 18 || k == 19 || k == 41) {
							System.out.println(k + "---------t3---" + ClassLayout.parseInstance(a).toPrintable());
						}
						if (k == 28) {
							a15 = list.get(15);
						}
					}
					k++;
				}
				synchronized (a15) {
					System.out.println("----15-----t3---" + ClassLayout.parseInstance(a15).toPrintable());
					//此时打印的是轻量级锁
				}

			}

		};
		t3.start();
		t3.join();
		System.out.println("--------" + ClassLayout.parseInstance(new A()).toPrintable());

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
		t2.join();
	}


	static void bias() throws InterruptedException {

		A a = new A();
		Thread t1 = new Thread() {
			@SneakyThrows
			@Override
			public void run() {
				synchronized (a) {
					System.out.println(Thread.currentThread().getId() + "t1--" + ClassLayout.parseInstance(a).toPrintable());
				}
				Thread.sleep(5000);
				System.out.println("t1--unlock--" + ClassLayout.parseInstance(a).toPrintable());
			}
		};

		t1.start();
		t1.join();
		Thread.sleep(2000);
		System.out.println("main--" + ClassLayout.parseInstance(a).toPrintable());

		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 21; i++) {
					synchronized (a) {
						if (i == 18 || i == 20) {
							System.out.println(Thread.currentThread().getId() + "t2--" + i + ClassLayout.parseInstance(a).toPrintable());
						}
					}
				}
			}
		};
		t2.start();
		t2.join();

	}

}
