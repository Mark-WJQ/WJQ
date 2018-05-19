package com.wjq.collection;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by wangjianqiang on 2017/12/30.
 */
public class SList {

    private Link<String> startLink;
    private Link<String> current;


    public static  <T> SListIterator<T> iterator(final Link<T> start){
       return new SListIterator<>(start);
    }

    static class Link<T>{
        private Link<T> next;
        private T t;

        public Link(T t) {
            this.t = t;
        }

        public void setNext(Link next) {
            this.next = next;
        }

        public Link getNext() {
            return next;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }


   static class SListIterator<T>{

       private Link<T> curr;

       private Link<T> start;

       private Link<T> last;

       public SListIterator(Link<T> start) {
           this.start = start;
           this.curr = start;
       }

       public boolean hasNext(){
           return Objects.nonNull(curr);
       }

       public T next(){
           T t = curr.getT();
           curr = curr.getNext();
           return t;
       }

       public T remove(){
           if (Objects.isNull(curr)){
               return null;
           }
           T t = null;
           if (Objects.nonNull(curr.getNext())) {
               t = curr.getT();
               curr.setNext(curr.getNext().getNext());
           }
           return t;
       }

       public void add(T t){
          Link<T> link = new Link<>(t);
          curr.setNext(link);
          if (curr.equals(start)){
              start.setNext(link);
          }
          last = curr.getNext();
          curr = start;
       }

    }

    public Link<String> getStartLink() {
        return startLink;
    }

    public void setStartLink(Link<String> startLink) {
        this.startLink = startLink;
    }


    public Link<String> getCurrent() {
        return current;
    }

    public void setCurrent(Link<String> current) {
        this.current = current;
    }

    public static void main(String[] args) {
        SList sList = new SList();
        sList.setStartLink(new Link<>("hello"));
        Link<String> link = new Link<>("hello");
        SListIterator<String> sli = iterator(link);
        while (sli.hasNext()){
            sli.next();
        }

    }


}
