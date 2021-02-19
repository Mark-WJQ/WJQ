package com.wjq.algorithm.recursion;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式
 * 是一种把运算符前置的算数表达式。例如普通的表达式 2 + 3，逆波兰表达式就是 + 2 3。逆波兰表达式的优点是
 * 运算符之间不必有优先级关系，也不必用括号改变运算次序，例如（2 + 3 ） * 4 的逆波兰表示法 * + 2 3 4。
 * 本题求解逆波兰表达式的值，运算符包括+ - / * 四个。
 *
 *
 * 输入
 * 输入为一行，其中运算符与运算数之间都用空格分隔，运算数是浮点数
 * 输出
 * 输出为一行，表达式的值
 *
 * 逆波兰表达式的定义：
 * 1》 一个数是一个逆波兰表达式，值为该数
 * 2》 “运算分 逆波兰表达式 逆波兰表达式” 是逆波兰表达式，值为两个逆波兰表达式的值运算的结果
 *
 *
 * 样例输入
 *   * + 11.0 12.0 + 24.0 35.0
 * 样例输出
 *   1357.00000
 *
 * @author wangjianqiang24
 * @date 2020/10/21
 */
public class ReversePolishNotation {



	private static Deque<String> deque;

	static {
		deque = new LinkedList<>();
		deque.add("*");
		deque.add("+");
		deque.add("11.0");
		deque.add("12.0");
		deque.add("+");
		deque.add("24.0");
		deque.add("35.0");
	}

	public static void main(String[] args) {
		ReversePolishNotation notation = new ReversePolishNotation();
		System.out.println(notation.exp(deque.pollFirst()));
	}


	double exp(String exp){
		switch (exp){
		case "+":
			return exp(deque.pollFirst()) + exp(deque.pollFirst());
		case "-":
			return exp(deque.pollFirst()) - exp(deque.pollFirst());
		case "*":
			return exp(deque.pollFirst()) * exp(deque.pollFirst());
		case "/":
			return exp(deque.pollFirst()) / exp(deque.pollFirst());
		default:
			return Double.valueOf(exp);
		}
	}



}
