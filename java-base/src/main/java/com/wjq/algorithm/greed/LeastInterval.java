package com.wjq.algorithm.greed;

//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
//
// 你需要计算完成所有任务所需要的 最短时间 。
//
//
//
// 示例 1：
//
//
//输入：tasks = ['A','A','A','B','B','B'], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
//
// 示例 2：
//
//
//输入：tasks = ['A','A','A','B','B','B'], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//['A','A','A','B','B','B']
//['A','B','A','B','A','B']
//['B','B','B','A','A','A']
//...
//诸如此类
//
//
// 示例 3：
//
//
//输入：tasks = ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
//
//
//
//
// 提示：
//
//
// 1 <= task.length <= 104
// tasks[i] 是大写英文字母
// n 的取值范围为 [0, 100]
//
// Related Topics 贪心算法 队列 数组

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 *
 * @author wangjianqiang24
 * @date 2021/1/12
 */
public class LeastInterval {

	public static void main(String[] args) {
		LeastInterval leastInterval = new LeastInterval();
		char[] tasks = new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		leastInterval.leastInterval(tasks, 2);

	}


	/**
	 * 准备两个容器
	 * 一个存放在n范围内的任务
	 * 一个存放可以执行的任务，有序，任务数量排序
	 * @param tasks
	 * @param n
	 * @return
	 */

	public int leastInterval(char[] tasks, int n) {
		if (n == 0 || tasks.length == 1){
			return tasks.length;
		}
		Data NULL = new Data('0',-1,-1);
		HashMap<Character, Data> counter = new HashMap<>();
		Deque<Data> list = new LinkedList<>();
		for (int i = 0; i < tasks.length; i++) {
			counter.compute(tasks[i], (k, v) -> {
				if (v == null) {
					return new Data(k, 1, 0);
				}
				v.count++;
				return v;
			});
		}
		TreeSet<Data> set = new TreeSet<>(counter.values());
		counter.clear();
		int count = 0;
		int nc = 0;
		while (!(set.isEmpty() && nc >=n)) {
			count++;
			if (!set.isEmpty()) {
				Data d = set.pollFirst();
				d.count--;
				//放入范围内
				if (d.count > 0) {
					list.offer(d);
				}else {
					list.offer(NULL);
					nc++;
				}
			}else {
				list.offer(NULL);
				nc++;
			}

			if (list.size() > n){
				Data d = list.pollFirst();
				if (d != NULL){
					set.add(d);
				}else {
					nc --;
				}
			}
		}
		return count;
	}


	static class Data implements Comparable<Data> {

		public Data(char c, int count, int position) {
			this.c = c;
			this.count = count;
			this.position = position;
		}

		/**
		 * 任务字符
		 */
		char c;
		/**
		 * 任务个数
		 */
		int count;

		/**
		 * 执行位置，是否在n范围内,-1表示未使用
		 */
		int position;


		@Override
		public int compareTo(Data o) {
			if (o.count != count) {
				return o.count - count;
			}
			return o.c - c;

		}
	}

}
