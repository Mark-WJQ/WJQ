package com.wjq.file;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by wangjianqiang on 2018/4/21.
 */
public class FileTest {


    public static void main(String[] args) throws IOException {


        //Reader reader = new FileReader("");

        //RandomAccessFile raf = new RandomAccessFile("","");



       File file = new File("./test1/src/main/java/com/test/wjq/file");
        System.out.println(file.list().length);


        BufferedReader in = new BufferedReader(new FileReader("./test1/src/main/java/com/test/wjq/file/FileTest.java"));


        LineNumberReader lnr = new LineNumberReader(in);


        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("FileTest.out")));

        int lineCount = 1;
        String s;
        while ((s = lnr.readLine()) != null)
            pw.println(lnr.getLineNumber() +": " + s);
        pw.close();

        FileChannel fc = new FileInputStream("./test1/src/main/java/com/test/wjq/file/FileTest.java").getChannel();
       // ByteBuffer bb = ByteBuffer.allocateDirect();




    }
}
