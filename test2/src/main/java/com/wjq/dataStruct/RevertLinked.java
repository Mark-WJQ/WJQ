package com.wjq.dataStruct;

public class RevertLinked {


    public static void main(String[] args) {

        Node n1 = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        RevertLinked revertLinked = new RevertLinked();
        Node node = revertLinked.revert(n1, 2, 3);

        //revertLinked.del(n4, 3);
        System.out.println();


    }


    public void del(Node first, int i) {


        do {


            if (first.index == i) {
                first.index = first.next.index;
                Node node = first.next;
                first.next = node.next;
                node = null;
                break;
            }
            first = first.next;

        } while (first.next != null);


    }


    public void revert(Node first) {

        Node node = first;
        do {
            //当前首节点
            Node cur = first;
            first = node.next;
            node.next = first.next;
            first.next = cur;
        } while (node.next != null);

    }


    public Node revert(Node first, int m, int n) {

        if (m > n)
            return first;

        Node node = first;

        int index = 0;
        Node mNode = null;
        int m1 = m - 1;
        Node pre = new Node(null);
        pre.next = first;
        do {
            ++index;
            if (index == m) {
                mNode = node;
            } else if (index > m && index <= n) {
                Node cur = mNode;
                mNode = node.next;
                if (first == cur) {
                    first = mNode;
                }
                node.next = mNode.next;
                mNode.next = cur;
                pre.next = mNode;
            } else {
                if (index == m1) {
                    pre = node;
                }
                node = node.next;
            }

        } while (node.next != null);

        return first;


    }


    static class Node {
        Integer index;

        public Node(Integer index) {
            this.index = index;
        }

        Node next;
    }

}
