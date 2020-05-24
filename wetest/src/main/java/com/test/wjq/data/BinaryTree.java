package com.test.wjq.data;

import java.util.Objects;
import java.util.Scanner;


/**
 * 线索二叉树
 */
public class BinaryTree {


    static Scanner scanner = new Scanner(System.in);


    /**
     * 先序遍历建立二叉树
     * @param root
     * @return
     */
    public Node creatTree(Node root) {
        scanner.useDelimiter("\n");
        Node node = null;
        while (scanner.hasNextLine()) {
            node = root;
            String next = scanner.nextLine();
            //如果是空串该节点终结
            if (" ".equals(next)) {
                System.out.println("-----");
                return null;
            } else {
                System.out.println(next);
                node.data = next;
                //创建左子树
                node.left = creatTree(new Node());
                //创建右子树
                node.right = creatTree(new Node());
                return node;
            }
        }
        return root;
    }

    static Node pre = null;
    /**
     * 中序遍历 ,线索化
     */
    public static void inOrderTraverse(Node root,Node pre){
        //遍历左子树
        if (Objects.nonNull(root)) {
            inOrderTraverse(root.left,pre);
             //如果当前结点没有左子树,前驱结点
            if (Objects.isNull(root.left)){
                root.ltag = 1;
                root.left = pre;
            }
           System.out.println(root.data);

            if(Objects.isNull(pre.right)){
                pre.right = root;
                pre.rtag = 1;
            }
           pre = root;
            //遍历右子树
            inOrderTraverse(root.right,pre);
        }

    }





    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Node root = new Node();

        Node node = tree.creatTree(root);

        System.out.println("================");
        System.out.println(node);

        //一个空节点避免null
        Node pre = new Node("#");
        pre.left = root;
        pre.ltag = 0;
       inOrderTraverse(root,pre);
        System.out.println(pre);


    }


    static class Node {

        public Node(String data) {
            this.data = data;
        }


        public Node() {

        }

        private String data;
        private Node left, right;
        //线索二叉树线索  0 子结点  1 双亲或其他结点
        private int ltag,rtag;

        @Override
        public String toString() {
            return "{ data : " + data + ",ltag:" + ltag  +",left :" +( Objects.nonNull(left) ? left.data : null)+",rtag:" + rtag+ ",right :" +(Objects.nonNull(right)? right.data:null) + "}";
        }






    }


}
