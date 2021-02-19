package com.wjq.algorithm.map;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * You are give two pots,having the voilume of A and B liters respectively.The following operations can be performed:
 * 1. FILL(i) fill the pot i (1 <=i <=2) from the tap;
 * 2. DROP(i) empty the pot i to the drain;
 * 3 POUR(i,j) pour from pot i to pot j;after this operation either the pot j is full(and there may be some water left in pot i),
 * 	or the pot i is empty (and all its contents have been move to the pot j).
 * write a program to find the shortest possiable sequence of these operations that will yield exactly C liters of water in one of the pots.
 *
 * input
 * on the first and only line are the numbers A ,B ,C.These are all integers in the range from 1 to 100 and C < max(A,B)
 *
 * output
 * 	The first line of output must contain the length of the sequence of operations K.The follwing K lines must each describe one operation,
 * 	if there are serveral sequences of minniamal length,output any one of them.If the desired result can't be achieved,the first and only line of the file must contain the word 'impossible'.
 *
 *
 * 几日思路
 *  两个容器中的初始液体量为 0,0
 *  则对于下一个状态有以下操作
 *  FILL，DROP，POUR，分别针对不同的容器，有6种操作
 *
 *  对于广搜来说
 *  遍历太多无用节点
 *
 *
 *  样例输入
 * 3 5 4
 * 样例输出
 * 6
 * FILL(2)
 * POUR(2,1)
 * DROP(1)
 * POUR(2,1)
 * FILL(2)
 * POUR(2,1)
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/23
 */
public class Pots {

	public Pots( int a,int b) {
		this.visit = new int[a+1][b+1];
		this.potV = new int[]{a,b};
	}


	public static void main(String[] args) {
		Pots pots = new Pots(3,5);
		OP op = pots.pot(4);
		if (op == null){
			System.out.println("impossiable");
		}else {
			System.out.println(op.getCount());
			String result = "";
			while (op != null){
				result = op + "\n" + result;
				op = op.getParent();
			}
			System.out.println(result);
		}

	}
	/**
	 * 一容器中液体数位表示
	 */
	int visit[][];


	/**
	 * 容器容量
	 */
	int[] potV;


	/**
	 * 面向对象的思维，一切操作都是对象的动作
	 * 属于对象的一部分
	 */
	interface OP {
		String name();

		void op();

		int[] getPots();

		int getCount();

		OP getParent();
	}

	abstract class AbstractOp implements OP {

		int count = 1;

		public AbstractOp(OP parent) {
			this.parent = parent;
			if (parent != null) {
				pots = Arrays.copyOf(parent.getPots(),2);
				count = parent.getCount() + 1;
			}
		}

		@Override
		public int getCount() {
			return count;
		}


		@Override
		public OP getParent() {
			return parent;
		}

		/**
		 * 容器中液体，下标表示容器，value表示液体数
		 */
		private int[] pots = new int[] {0, 0};

		public int[] getPots() {
			return pots;
		}

		OP parent;

		String value() {
			return "impossible";
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder(name());
			sb.append("(");
			sb.append(value());
			sb.append(")");
			return sb.toString();
		}
	}

	class Fill extends AbstractOp {

		int p;

		public Fill(int p, OP parent) {
			super(parent);
			this.p = p;
		}

		public void op() {
			getPots()[p - 1] = potV[p - 1];
		}


		@Override
		public String name() {
			return "FILL";
		}


		String value() {
			return p + "";
		}

	}


	class Drop extends AbstractOp {

		int p;

		public Drop(int p, OP parent) {
			super(parent);
			this.p = p;
		}

		public void op() {
			getPots()[p - 1] = 0;
		}


		@Override
		public String name() {
			return "DROP";
		}

		String value() {
			return p + "";
		}

	}


	class Pour extends AbstractOp {


		int pa;
		int pb;

		public Pour(OP parent, int pa, int pb) {
			super(parent);
			this.pa = pa;
			this.pb = pb;
		}


		/**
		 * 倾倒
		 */
		public void op() {
			int b = potV[pb - 1] - getPots()[pb - 1];
			int a = getPots()[pa - 1];
			//满的,倒不进去了
			if (b == 0) {
				return;
			}

			//可以倒进去
			if (a >= b) {
				//倒满了
				getPots()[pb - 1] = potV[pb - 1];
				getPots()[pa - 1] -= b;
			}
			else {
				getPots()[pa - 1] = 0;
				getPots()[pb - 1] += a;
			}

		}


		@Override
		public String name() {
			return "POUR";
		}

		@Override
		String value() {
			StringBuilder sb = new StringBuilder(pa+"");
			sb.append(",");
			sb.append(pb);
			return sb.toString();
		}
	}


	OP pot(int result) {

		Queue<OP> queue = new LinkedList<>();
		do {
			if (queue.isEmpty()) {
				visit[0][0] = 1;
				queue.add(new Fill(1, null));
				queue.add(new Fill(2, null));
				queue.add(new Drop(1, null));
				queue.add(new Drop(2, null));
				queue.add(new Pour(null, 1, 2));
				queue.add(new Pour(null, 2, 1));
			}
			OP op = queue.poll();
			//开始操作
			op.op();
			int[] pots = op.getPots();
			//已经看过
			if (visit[op.getPots()[0]][op.getPots()[1]] == 1) {
				continue;
			}
			visit[pots[0]][pots[1]] = 1;
			//找到结果
			if (pots[0] == result || pots[1] == result) {
				return op;
			}

			//第一个放满
			queue.add(new Fill(1, op));
			//第二个放满
			queue.add(new Fill(2, op));
			//第一个倒掉
			queue.add(new Drop(1, op));
			//第二个倒掉
			queue.add(new Drop(2, op));
			//从第一个倒进去
			queue.add(new Pour(op, 1, 2));
			//从第二个倒进去
			queue.add(new Pour(op, 2, 1));

		}
		while (!queue.isEmpty());

		return null;
	}

}
