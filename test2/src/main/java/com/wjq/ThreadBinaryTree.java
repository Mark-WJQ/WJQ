package com.wjq;

/**
 * Created by wangjianqiang on 2017/10/18.
 */
public class ThreadBinaryTree {


    Node preNode;  //线索化时记录前一个节点

    static class Node{
        String data;
        Node left;
        Node right;
        boolean isLeftThread = false;  //false 子节点  true 前驱或后继
        boolean isRightThread = false; //false 子节点  true 前驱或后继

        public Node(String data) {
            this.data = data;
        }
    }

    static Node createBinaryTree(String[] array,int index){
        Node node = null;
        if (index < array.length){
            node = new Node(array[index]);
            node.left = createBinaryTree(array,index*2+1);
            node.right = createBinaryTree(array,index*2+2);
        }
        return node;
    }

    //中序线索化二叉树
    void inThreadOrder(Node node){
        if (node == null)
            return;
        //处理左子树
        inThreadOrder(node.left);
        //左指针为空，将左指针指向前驱节点
        if (node.left == null){
            node.left = preNode;
            node.isLeftThread = true;
        }
        //前一个节点的后继节点指向当前节点
        if (preNode != null && preNode.right == null){
            preNode.right = node;
            preNode.isRightThread = true;
        }

        preNode = node;
        //处理右子树
        inThreadOrder(node.right);

    }

    /**
     * 中序遍历线索二叉树，按照后继方式遍历（思路：找到最左子节点开始）
     * @param node
     */
    void inThreadList(Node node){
        //找中序遍历开始的节点,节点不为空，并且左指针指向节点
        while(node != null && !node.isLeftThread){
            node = node.left;
        }
        //node 此时为遍历开始的节点
        while(node != null){
            System.out.println(node.data + ",");
            //如果右指针是线索
            if (node.isRightThread){
                node = node.right;
            }else {  //如果右指针不是线索，找到右子树开始的节点
                node = node.right;
                while (node != null && !node.isLeftThread){
                    node = node.left;
                }
            }
        }
    }

    /**
     * 中序遍历线索二叉树，按照前驱方式遍历（思路：找到左右子节点开始倒序遍历）
     * @param node
     */
    void inPreThreadList(Node node) {
        //找中序遍历开始的节点
        while (node != null && !node.isRightThread) {
            node = node.right;
        }

        while (node != null) {
            System.out.println(node.data + ",");
            //如果左指针是线索
            if (node.isLeftThread)
                node = node.left;
            else {
                node = node.left;
                while (node != null && !node.isRightThread) {
                    node = node.right;
                }
            }
        }
    }


    /**
     * 前序线索化二叉树
     * @param node
     */
    void preThreadOrder(Node node){
        if (node == null)
            return;
        //左指针为空将左指针指向前驱节点
        if (node.left == null){
            node.left = preNode;
            node.isLeftThread = true;
        }
        //前一个节点的后继节点指向当前节点
        if (preNode != null && preNode.right == null){
            preNode.right = node;
            preNode.isRightThread = true;
        }
        preNode = node;

        if (!node.isLeftThread){
            preThreadOrder(node.left);
        }

        if (!node.isRightThread)
            preThreadOrder(node.right);

    }


    void preThreadList(Node node){
        while (node != null){
            while (!node.isLeftThread){
                System.out.println(node.data + ",");
                node = node.left;
            }

            System.out.println(node.data + ",");
            node = node.right;
        }

    }


    public static void main(String[] args) {
        String[] array = {"A","B","C","D","E","F","G","H"};
        Node root = createBinaryTree(array,0);
        ThreadBinaryTree tbt = new ThreadBinaryTree();
        tbt.inThreadOrder(root);
        System.out.println("中序按后继节点遍历二叉树的结果");
        tbt.inThreadList(root);

        System.out.println("\n中序按后继节点遍历二叉树的结果");
        tbt.inPreThreadList(root);
        Node root2 = createBinaryTree(array, 0);
        ThreadBinaryTree tree2 = new ThreadBinaryTree();
        tree2.preThreadOrder(root2);
        tree2.preNode = null;
        System.out.println("\n前序按后继节点遍历线索二叉树结果：");
        tbt.preThreadList(root2);
    }



}

class Node{
    String data;
    Node left;
    Node right;
    byte leftType; //左指针域类型  0 指向子节点 1 前驱或后继
    byte rightType;  //右指针域类型  0 指向子节点 1 前驱或后继
 }
