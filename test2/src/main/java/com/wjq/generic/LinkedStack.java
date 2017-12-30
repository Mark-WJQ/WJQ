package com.wjq.generic;

/**
 * Created by wangjianqiang on 2017/11/28.
 */
public class LinkedStack<T> {



    private class Node{
        T item;
        Node next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end(){
            return item == null && next == null;
        }
    }



    private Node top = new Node();

    public void push(T item){
        top = new Node(item,top);
    }

    public T pop(){
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

}
