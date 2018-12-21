package com.wjq.collection;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by wangjianqiang on 2018/12/16.
 *
 * 二叉树实现
 *
 *
 */
public class Btree implements BinaryTree {

    private Node root;

    public Btree(Node root) {
        this.root = root;
    }


    public Btree() {
    }

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    /**
     * 先序遍历
     */
    private void preOrderTraverse(){
        if (Objects.isNull(root)){
            return;
        }
        //输出根结点
        System.out.print(root.data + " ");
        //遍历左子树
       Btree lbt = new Btree(root.left);
       lbt.preOrderTraverse();
        //遍历右子树
       Btree rbt = new Btree(root.right);
       rbt.preOrderTraverse();
    }

    /**
     * 中序遍历
     */

    private void inOrderTraverse(){
        System.out.print("中序遍历: ");
        inOrderTraverse(root);
        System.out.println();
    }



    private void inOrderTraverse(Node node){
        if (Objects.isNull(node))
            return;

        //遍历左子树
        inOrderTraverse(node.left);
        //输出根结点
        System.out.print(node.data + " ");
        //遍历右子树
        inOrderTraverse(node.right);

    }



    public void inOrderByStack(){
        Deque<Node> deque = new LinkedList<>();
        Node current = root;
        System.out.print("非递归中序遍历：");
        while (Objects.nonNull(current) || !deque.isEmpty()){
            while (Objects.nonNull(current)){
                deque.push(current);
                current = current.left;
            }
            if (!deque.isEmpty()){
                Node node = deque.poll();
                System.out.print(node.data + " ");
                current = node.right;
            }
        }
    }


    /**
     * 后续遍历
     */
    public void postOrderTraverse(){
        System.out.print("后续遍历： ");
        postOrderTraverse(root);
        System.out.println("");
    }


    private void postOrderTraverse(Node node){
        if (Objects.isNull(node))
            return;
        //先遍历左子树
        postOrderTraverse(node.left);
        //遍历右子树
        postOrderTraverse(node.right);
        //输出根节点
        System.out.print(node.data + " ");

    }

   public int getHeight(){
       System.out.print("二叉树高度：");
        return getHeight(root);
    }


    private int getHeight(Node node){
       if (Objects.isNull(node))
           return 0;
       //获取左子树的高度
        int lh = getHeight(node.left);
        //获取右子树高度
        int rh = getHeight(node.right);
        //返回左右子树较大值 + 1
        return (lh > rh ? lh : rh) +1;

    }

    public int size(){
        System.out.print("二叉树节点数：");
       return size(root);
    }

    public int size(Node node){
        if (Objects.isNull(node))
            return 0;
        //左子树
        int l = size(node.left);
        //右子树
        int r = size(node.right);


        return l + r + 1;


    }






    @Override
    public ExpressionTree getLeftOperand() {
        return null;
    }

    @Override
    public ExpressionTree getRightOperand() {
        return null;
    }

    /**
     * Gets the kind of this tree.
     *
     * @return the kind of this tree.
     */
    @Override
    public Kind getKind() {
        return null;
    }

    /**
     * Accept method used to implement the visitor pattern.  The
     * visitor pattern is used to implement operations on trees.
     *
     * @param visitor
     * @param data
     */
    @Override
    public <R, D> R accept(TreeVisitor<R, D> visitor, D data) {
        return null;
    }


    public static void main(String[] args) {
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, node5, null);
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, node7, null);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node6, node3);
        Node node1 = new Node(1, node2, node4);
        //构建数
        Btree bt = new Btree(node1);

        System.out.println(bt.isEmpty());


        //先序遍历
        System.out.print("先序遍历: ");
        bt.preOrderTraverse();

        System.out.println();
        //中序遍历
        bt.inOrderTraverse();

        //后续遍历
        bt.postOrderTraverse();

        //高度
        System.out.println(bt.getHeight());

        //节点数
        System.out.println(bt.size());


        bt.inOrderByStack();


    }
}


class Node{

     Object data;

     Node right;

     Node left;

    public Node(Object data, Node right, Node left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", right=" + right +
                ", left=" + left +
                '}';
    }
}

