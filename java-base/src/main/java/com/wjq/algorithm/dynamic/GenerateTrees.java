package com.wjq.algorithm.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wangjianqiang24
 * @date 2020/12/7
 */
public class GenerateTrees {


	public static void main(String[] args) {
		GenerateTrees gen = new GenerateTrees();
		gen.generateTrees(3);
	}

	public List<TreeNode> generateTrees(int n) {
		return gen(1, n);
	}

	List<TreeNode> gen(int i, int j) {
		List<TreeNode> ns = new ArrayList<>();
		if (i > j) {
			return Collections.emptyList();
		}
		if (i == j) {
			ns.add(new TreeNode(i));
			return ns;
		}

		for (int k = i; k <= j; k++) {
			List<TreeNode> ls = gen(i, k - 1);
			List<TreeNode> rs = gen(k + 1, j);
			if (ls.isEmpty()) {
				for (TreeNode r : rs) {
					TreeNode tn = new TreeNode(k);
					tn.right = r;
					ns.add(tn);
				}
			}
			else if (rs.isEmpty()) {
				for (TreeNode l : ls) {
					TreeNode tn = new TreeNode(k);
					tn.left = l;
					ns.add(tn);
				}
			}
			else {
				for (TreeNode l : ls) {
					for (TreeNode r : rs) {
						TreeNode tn = new TreeNode(k);
						tn.left = l;
						tn.right = r;
						ns.add(tn);
					}
				}
			}
		}
		return ns;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
