package com.wjq.dataStruct;

import java.util.Scanner;

/**
 * 平衡二叉树
 */
public class AVLTree {

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();
        AVLNode root = null;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
           String next = scanner.next();
           if ("#".equals(next))
               break;
          root = tree.insert(Integer.valueOf(next),root);
        }
        System.out.println(root);

        tree.inOrderTraverse(root);





    }




   public void inOrderTraverse(AVLNode root){
        if (root == null)
            return;
        inOrderTraverse(root.left);
       System.out.println(root);
       inOrderTraverse(root.right);
   }

    /**
     * 平衡二叉树插入
     *
     * @param data
     * @param root
     */
    public AVLNode insert(int data, AVLNode root) {
        if (root == null) {
            return new AVLNode(data);
        }
        //左子树
        if (data < root.data) {
            root.left = insert(data, root.left);
            //如果左子树跟右子树间的高度差=2，进行旋转操作
            if (height(root.left) - height(root.right) == 2) {
                //单旋转,如果插入的数据 < 左子树的data，说明插入点在左子树的左侧,只需旋转一次即可，root.left 旋转
                if (data < root.left.data) {
                    root = rotateWithLeftChild(root);
                } else {
                    //双旋转
                    root = doubleWithLeftChild(root);
                }
            }
        } else {
            //右子树
            root.right = insert(data, root.right);
            if (height(root.right) - height(root.left) == 2) {
                //单旋转，如果data > root.right.data ,说明 data 不在 root.data 跟 root.right.data 中间那么只需旋转一次，并不会产生新的不平衡
                if (data > root.right.data) {
                    root = rotateWithRightChild(root);
                } else {
                    //双旋，反之需将 data 先旋转至 root.data 跟 root.right.data 中间，然后再旋转
                    root = doubleWithRightChild(root);
                }
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }


    private int height(AVLNode t) {
        return t == null ? -1 : t.height;
    }


    /**
     * 一次旋转
     *
     * @param k
     * @return
     */
    private AVLNode rotateWithLeftChild(AVLNode k) {
        AVLNode k1 = k.left;
        k.left = k1.right;
        k1.right = k;
        k.height = Math.max(height(k.left),height(k.right)) + 1;
        k1.height = Math.max(height(k1.left),k.height) + 1;
        return k1;
    }


    /**
     * 双旋转
     * @param k
     * @return
     */
    private AVLNode doubleWithLeftChild(AVLNode k) {
       k.left = rotateWithRightChild(k.left);
        return rotateWithLeftChild(k);
    }

    /**
     * 一次旋转
     *
     * @param k
     * @return
     */
    private AVLNode rotateWithRightChild(AVLNode k) {
        AVLNode k1 = k.right;
        k.right = k1.left;
        k1.left = k;
        k.height = Math.max(height(k.left),height(k.right)) + 1;
        //相当于获取左右子树的高度
        k1.height = Math.max(height(k1.right),k.height) + 1;
        return k1;
    }


    /**
     * 双旋转
     * @param k
     * @return
     */
    private AVLNode doubleWithRightChild(AVLNode k) {
        k.left = rotateWithLeftChild(k.right);
        return rotateWithRightChild(k);
    }


    class AVLNode {


        public AVLNode(int data) {
            this(data, null, null, 0);
        }

        public AVLNode(int data, AVLNode left, AVLNode right, int height) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }


        @Override
        public String toString() {
            return "AVLNode{" +
                    "data=" + data +
                    ", left=" + (left==null ? null :left.data) +
                    ", right=" +( right == null ? null : right.data )+
                    ", height=" + height +
                    '}';
        }

        //暂时用数字，简化变成，在此处实际上可以使用任何可比较的对象
        private int data;

        private AVLNode left;

        private AVLNode right;

        private int height;


        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public AVLNode getLeft() {
            return left;
        }

        public void setLeft(AVLNode left) {
            this.left = left;
        }

        public AVLNode getRight() {
            return right;
        }

        public void setRight(AVLNode right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }


}
