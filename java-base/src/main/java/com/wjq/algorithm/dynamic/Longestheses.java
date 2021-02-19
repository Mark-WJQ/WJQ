package com.wjq.algorithm.dynamic;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/23
 */
public class Longestheses {


	public static void main(String[] args) {
		Longestheses l = new Longestheses();		//l.longestValidParentheses(")(((((()())()()))()(()))(");

		l.cal("())");
	}


	/**
	 *  * 以第i个元素结尾的最长有效串
	 * 	 * if(s[i] = ')'){
	 * 	 *   if(left(s[i - r[i-1]-1])){
	 * 	 *      r[i] = r[i-1] +2;
	 * 	 *    }
	 * 	 *
	 * 	 *    if(r[i-r[i]-1] > 0){
	 * 	 *        r[i] += r[i-r[i]-1]
	 * 	 *    }
	 * 	 * }
	 * @param s
	 * @return
	 */
	int cal(String s){
		int l = s.length();
		int[] r = new int[l];
		int max = 0;
		for (int i = 1; i < l; i++) {
			if (right(s.charAt(i))){
				if (i-r[i-1]-1 >=0 && left(s.charAt(i-r[i-1]-1))){
					r[i] = r[i-1]+2;
					int pre = i-r[i];
					if (pre >= 0 && r[pre] > 0){
						r[i] += r[pre];
					}
				}
				max = Math.max(max,r[i]);
			}
		}
		return max;
	}
	


	/**
	 * 以第i个元素结尾的最长有效串
	 * if(s[i] = ')'){
	 *   if(left(s[i - r[i-1]-1])){
	 *      r[i] = r[i-1] +2;
	 *    }
	 *    
	 *    if(r[i-r[i]-1] > 0){
	 *        r[i] += r[i-r[i]-1]
	 *    }
	 * }
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		int l = s.length();
		int max = 0;
		result = new int[l][l];


		for (int i = 1; i < l; i++) {
			if (match(s.charAt(i - 1), s.charAt(i)) && result[i-1][i] !=1) {
				max = Math.max(getMax(s,i-1,i),max);
			}
		}

		/*for (int i = 0; i < l; i++) {
			for (int j = i + 1; j < l; j++) {

				if (j - i == 1) {

				}


				boolean match = false;
				if (j - i == 1 || result[i + 1][j - 1] == 1) {
					if (match(s.charAt(i), s.charAt(j))) {
						match = true;
					}
				}
				if (!match && j > 1 && result[i][j - 2] == 1 && match(s.charAt(j - 1), s.charAt(j))) {
					match = true;
				}
				if (match) {
					result[i][j] = 1;
					for (int k = 0; k < i - 1; k++) {
						if (result[k][i - 1] == 1) {
							result[k][j] = 1;
							max = Math.max(max, j - k + 1);
							break;
						}
					}
					max = Math.max(max, j - i + 1);

				}

			}
		}
*/

		/*for (int i = 0; i < l; i++) {
			Character c = s.charAt(i);
			if (left(c)) {
				//左括号
				stack.push(c);
			}
			else {
				//右括号
				Character cs = stack.pop();
				//如果匹配
				if (match(cs, c)) {
					count += 2;
					max = Math.max(count, max);
				}
			}

		}*/
		return max;

	}



	int[][] result;

	int getMax(String s, int i, int j) {
		int l = s.length();
		if ((i > 0 && j < l-1)) {
			if (match(s.charAt(i - 1), s.charAt(j + 1))) {
				result[i-1][j+1] = 1;
				return getMax(s, i - 1, j + 1);
			}
		}
		if (j + 2 < l) {
			if (match(s.charAt(j + 1), s.charAt(j + 2))) {
				result[i][j+2] = 1;
				result[j+1][j+2] = 1;
				return getMax(s,i, j + 2);
			}
		}
		for (int k = 0; k < i; k++) {
			if (result[k][i-1] == 1){
				result[k][j] = 1;
				return getMax(s,k,j);
			}
		}
		return j-i+1;

	}


	boolean left(Character c) {
		return c == '(';
	}

	boolean right(Character c) {
		return c == ')';
	}

	boolean match(Character left, Character right) {
		return left(left) && right(right);
	}
}
