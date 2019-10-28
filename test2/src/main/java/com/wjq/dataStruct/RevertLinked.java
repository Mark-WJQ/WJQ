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
        revertLinked.revert(n1);

        revertLinked.del(n4,3);
        System.out.println();




    }


    public void del(Node first,int i){


        do {


            if (first.index == i){
                first.index = first.next.index;
                Node node = first.next;
                first.next = node.next;
                node = null;
                break;
            }
            first = first.next;

        }while (first.next != null);


    }



    public void revert(Node first){



        Node node = first;
        do {
            //当前首节点
            Node cur = first;
            first = node.next;
            node.next = first.next;
            first.next = cur;
        }while (node.next != null);

    }


   static class Node{
        int index;

       public Node(int index) {
           this.index = index;
       }

       Node next;
    }

}
