package com.wjq.algorithm.recursion;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 表达式计算
 * 输入为size运算表达式，仅由数字、+、-、*、/、（、）组成，
 * 么有空格，要求求其值。假设运算符结果都是整数。"/" 结果也是整数。
 * 表达式定义
 * 表达式是一个递归的定义：
 *  表达式由项组成，可以是一个项，也可以是多个项 + 或 -
 *  项是由因子组成 可以为单个因子，也可以为多个因子 * 或 /
 *  因子的组成 "(表达式)" 或整数
 *
 * @author wangjianqiang24
 * @date 2020/10/22
 */
public class ExpressionEvaluation {

	/**
	 * 输入(2+3)*(5+7)+9/3
	 * 输出 63
	 * @param args
	 */
	public static void main(String[] args) {
		ExpressionEvaluation evaluation = new ExpressionEvaluation();
		System.out.println(evaluation.express());
	}


	static Deque<String> expr;

	static {
		expr = new LinkedList<>();
		expr.add("(");
		expr.add("2");
		expr.add("+");
		expr.add("3");
		expr.add(")");
		expr.add("*");
		expr.add("(");
		expr.add("5");
		expr.add("+");
		expr.add("7");
		expr.add(")");
		expr.add("+");
		expr.add("9");
		expr.add("/");
		expr.add("3");
	}


	/**
	 * 表达式
	 * @return
	 */
	int express(){
		//获取项
		int t = term();
		boolean more = true;
		while (more){
			String v = expr.peekFirst();
			if ("+".equals(v) || "-".equals(v)){
				expr.pollFirst();
				int next = term();
				if (v.equals("+")){
					t += next;
				}else {
					t -= next;
				}
			}else {
				more = false;
			}
		}
		return t;
	}

	/**
	 * 项
	 * @return
	 */
	int term(){
		int f = factory();
		boolean more = true;
		while (more){
			String v = expr.peekFirst();
			if ("*".equals(v) || "/".equals(v)){
				expr.pollFirst();
				int next = factory();
				if (v.equals("*")){
					f *= next;
				}else {
					f /= next;
				}
			}else {
				more = false;
			}
		}
		return f;
	}

	/**
	 * 因子
	 * @return
	 */
	int factory(){
		String v = expr.pollFirst();
		if (v.equals("(")){
			int r = express();
			expr.pollFirst();
			return r;
		}else {
			return Integer.valueOf(v);
		}
	}







}
