package com.wjq.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangjianqiang on 2017/11/20.
 */
public class Groups {

    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the more raths outgrabe.\n\n" +
                    "Beware the Jabberwock,my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";


    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while (m.find()){
            for (int j = 0;j < m.groupCount(); j++){
                System.out.print("[" + m.group(j) + "]");
            }
            System.out.println();
        }

        Matcher matcher = Pattern.compile("(?m)(\\s+[a-z]\\w+)").matcher(POEM);
        matcher = Pattern.compile("\\b([a-z]\\w+)\\b").matcher(POEM);
        while (matcher.find()){
            System.out.println( matcher.group());
        }

    }
}
