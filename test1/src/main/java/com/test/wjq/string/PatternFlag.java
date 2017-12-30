package com.test.wjq.string;

import lombok.NonNull;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangjianqiang on 2017/11/21.
 */
public class PatternFlag {


    public static void main(String[] args) {

        Matcher m = Pattern.compile("a\u030A",Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE).matcher("?");
       // m.appendReplacement()
        //aa22jjj

        System.out.println(m.find());
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String fp = scanner.next();

            File file = new File(fp);
            try {
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis);

                BufferedReader reader = new BufferedReader(isr);
                String s = "";
                while (reader.ready()) {
                    s += reader.readLine();
                }
                System.out.println(s);

               m = Pattern.compile("/\\*.*\\. \\*/",Pattern.MULTILINE).matcher(s);
                if (m.find()){
                    System.out.println(m.group());
                }

                System.out.println(Arrays.deepToString(s.split("\\b")));
                m =Pattern.compile("[a-zA-Z]([^\\.;/(]\\D\\w\\D)\\w+").matcher(s);
                while (m.find()){
                    System.out.print(m.group() + " ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
