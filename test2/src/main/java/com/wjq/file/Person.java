package com.wjq.file;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.*;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by wangjianqiang on 2018/4/23.
 */
public class Person {



    private String first,last;


    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Element getXml(){

        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);

        Element lastName = new Element("last");
        lastName.appendChild(last);

        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;

    }

    public Person(Element person){
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }


    @Override
    public String toString() {
        return first + " " + last;
    }

    public static void format(OutputStream os, Document doc){

        try {
            Serializer serializer = new Serializer(os,"ISO-8859-1");
            serializer.setIndent(4);
            serializer.setMaxLength(60);
            serializer.write(doc);
            serializer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) throws FileNotFoundException {
        List<Person> people = Arrays.asList(new Person("Dr . Bunsen","Honeydew"),new Person("Gonzo","The Great"),new Person("Phillip J.","Fry"));


        System.out.println(people);

        Element root = new Element("people");
        for (Person p : people)
            root.appendChild(p.getXml());

        Document doc = new Document(root);
        format(new BufferedOutputStream(new FileOutputStream("people.xml")),doc);


    }



}
