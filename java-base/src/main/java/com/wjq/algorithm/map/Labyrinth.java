package com.wjq.algorithm.map;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 迷宫问题
 * 定义一个二维数组：
 * int maze[5][5] = {
 *
 * 0, 1, 0, 0, 0,
 *
 * 0, 1, 0, 1, 0,
 *
 * 0, 0, 0, 0, 0,
 *
 * 0, 1, 1, 1, 0,
 *
 * 0, 0, 0, 1, 0,
 *
 * };
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找到从左上角到右下角的最短路线。
 *
 * 输入
 * 一个 5 X 5 的二维数组，表示一个迷宫，数据保证有唯一解。
 *
 * 输出
 * 左上角到右下角的最短路径，格式如样例所示。
 *
 *
 * 样例输入
 *
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 *
 * 样例输出
 *
 * (0, 0)
 * (1, 0)
 * (2, 0)
 * (2, 1)
 * (2, 2)
 * (2, 3)
 * (2, 4)
 * (3, 4)
 * (4, 4)
 *
 *
 *
 * @author wangjianqiang24
 * @date 2020/11/23
 */
public class Labyrinth {


	public static void main(String[] args) {
		Labyrinth labyrinth = new Labyrinth();
		labyrinth.points[0] = new int[]{0, 1 ,0, 0, 0};
		labyrinth.points[1] = new int[]{0, 1 ,0, 1, 0};
		labyrinth.points[2] = new int[]{0, 0 ,0, 0, 0};
		labyrinth.points[3] = new int[]{0, 1 ,1, 1, 0};
		labyrinth.points[4] = new int[]{0, 0 ,0, 1, 0};

		Point point = new Point(0,0,0,null);
		point = labyrinth.visit(point);

		while (point != null){
			System.out.println(point);
			point = point.parent;
		}


	}



	int[][] visited = new int[5][5];
	int[][] points = new int[5][5];


	private static class Point {
		int x;
		int y;
		int v;
		Point parent;


		public Point(int x, int y, int v, Point parent) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.parent = parent;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("{");
			sb.append("\"x\":")
					.append(x);
			sb.append(",\"y\":")
					.append(y);
			sb.append("}");
			return sb.toString();
		}
	}

	Point visit(Point point) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(point);
		Point last = null;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.x >= 5 || p.y >= 5 || p.x < 0 || p.y < 0) {
				continue;
			}

			if (visited[p.x][p.y] == 1) {
				continue;
			}
			p.v = points[p.x][p.y];
			if (p.v == 1) {
				continue;
			}
			visited[p.x][p.y] = 1;
			last = p;

			queue.add(new Point(p.x + 1, p.y, 0, p));
			queue.add(new Point(p.x - 1, p.y, 0, p));
			queue.add(new Point(p.x, p.y + 1, 0, p));
			queue.add(new Point(p.x, p.y - 1, 0, p));
		}
		return last;

	}

}
