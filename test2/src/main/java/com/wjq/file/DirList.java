package com.wjq.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by wangjianqiang on 2018/1/30.
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list = path.list(new DirFilter("data"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);

        for (String dirItem : list)
            System.out.println(dirItem);
    }


}


class DirFilter implements FilenameFilter{

    private Pattern pattern;

    public DirFilter(String regex) {
        pattern =  Pattern.compile(regex);
    }

    /**
     * Tests if a specified file should be included in a file list.
     *
     * @param dir  the directory in which the file was found.
     * @param name the name of the file.
     * @return <code>true</code> if and only if the name should be
     * included in the file list; <code>false</code> otherwise.
     */
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
