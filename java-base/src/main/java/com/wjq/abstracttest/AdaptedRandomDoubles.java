package com.wjq.abstracttest;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.Scanner;

/**
 * Created by wangjianqiang on 2017/10/28.
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {

    private int count;

    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    /**
     * Attempts to read characters into the specified character buffer.
     * The buffer is used as a repository of characters as-is: the only
     * changes made are the results of a put operation. No flipping or
     * rewinding of the buffer is performed.
     *
     * @param cb the buffer to read characters into
     * @return The number of {@code char} values added to the buffer,
     * or -1 if this source of characters is at its end
     * @throws IOException             if an I/O error occurs
     * @throws NullPointerException    if cb is null
     * @throws ReadOnlyBufferException if cb is a read only buffer
     */
    public int read(CharBuffer cb) throws IOException {

        if (count-- == 0)
            return -1;
        String result = Double.toString(next());
        cb.append(result);

        return result.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdaptedRandomDoubles(7));
        while (scanner.hasNext())
            System.out.println(scanner.next());
    }
}
