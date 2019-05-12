package com.wjq.dataStruct;

import java.util.Scanner;

public class BinaryTree {


    public Node creatNode() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            if (" ".equals(next)){

            }else {
                Node node = new Node(next);
                node.left = creatNode();
                node.right = creatNode();
            }
        }
        return new Node("");

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }


    }









    class Node {

      public   Node(String data){
          this.data = data;
      }

        private String data;
        private Node left, right;

    }


}
