package com.wjq.algorithm.recursion;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 描述
 * The objective of the program you are going to produce is to evaluate boolean expressions as the one shown next:
 * Expression: ( V | V ) & F & ( F | V )
 *
 * where V is for True, and F is for False. The expressions may include the following operators: ! for not , & for and, | for or , the use of parenthesis for operations grouping is also allowed.
 *
 * To perform the evaluation of an expression, it will be considered the priority of the operators, the not having the highest, and the or the lowest. The program must yield V or F , as the result for each expression in the input file.
 * 输入
 * The expressions are of a variable length, although will never exceed 100 symbols. Symbols may be separated by any number of spaces or no spaces at all, therefore, the total length of an expression, as a number of characters, is unknown.
 *
 * The number of expressions in the input file is variable and will never be greater than 20. Each expression is presented in a new line, as shown below.
 * 输出
 * For each test expression, print "Expression " followed by its sequence number, ": ", and the resulting value of the corresponding test expression. Separate the output for consecutive test expressions with a new line.
 *
 * Use the same format as that shown in the sample output shown below.
 * 样例输入
 * ( V | V ) & F & ( F| V)
 * !V | V & V & !F & (F | V ) & (!F | F | !V & V)
 * (F&F|V|!V&!F&!(F|F&V))
 * 样例输出
 * Expression 1: F
 * Expression 2: V
 * Expression 3: V
 *
 * 解题思路参考
 *
 * {@link ExpressionEvaluation}
 * 分为项，因子，表达式
 *  表达式由项组成可以 一项或多项组成使用 &，| 连接
 *  项由因子组成 使用 ！连接,包含一个因子
 *  因子 '(表达式)' 或 V F
 *
 *
 * @author wangjianqiang24
 * @date 2020/10/29
 */
public class BooleanExpressions {

	Deque<Character> expr = new LinkedList<>();
	{
		/*expr.add('(');
		expr.add('V');
		expr.add('|');
		expr.add('V');
		expr.add(')');
		expr.add('&');
		expr.add('F');
		expr.add('&');
		expr.add('(');
		expr.add('|');
		expr.add('V');
		expr.add(')');*/
	}
	public static void main(String[] args) {
		BooleanExpressions expressions = new BooleanExpressions();

		String e = "(F&F|V|!V&!F&!(F|F&V))";

		for (int i=0;i < e.length();i++){
			char c = e.charAt(i);
			if (c == ' '){
				continue;
			}
			expressions.expr.add(c);
		}

		boolean result = expressions.exp();
		if (result){
			System.out.println("V");
		}else {
			System.out.println("F");
		}
	}




	/**
	 * 表达式
	 * @return
	 */
	boolean exp() {

		boolean r1 = item();
		boolean more = true;
		while (more){
			Character sym = expr.peekFirst();
			if (Character.valueOf('&').equals( sym) || Character.valueOf('|').equals( sym)) {
				expr.pollFirst();
				boolean r2 = item();
				if (sym == '|') {
					 r1 |= r2;
				}
				else if (sym == '&') {
					 r1 &= r2;
				}
			}else {
				more = false;
			}
		}
		return r1;
	}

	/**
	 * 项
	 * @return
	 */
	boolean item() {
		Character c = expr.peekFirst();
		if (c == '!'){
			expr.pollFirst();
			return !factory();
		}else {
			return factory();
		}
	}

	/**
	 * 因子
	 * @return
	 */
	boolean factory() {

		Character c = expr.pollFirst();
		boolean r = false;
		if (c == '(') {
			r = exp();
			expr.pollFirst();
		}
		else {
			if (c == 'V') {
				return true;
			}
			else if (c == 'F') {
				return false;
			}
		}

		return r;
	}

}
