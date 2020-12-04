package com.wjq.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by wangjianqiang on 2018/4/21.
 */
public class LockingMappedFiles {

    static final int LENGTH = 0x8FFFFFF;

    static FileChannel fc;

    public static void main(String[] args) throws IOException {
        fc = new RandomAccessFile("test.dat","rw").getChannel();

        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE,0,LENGTH);


        for (int i = 0; i < LENGTH; i ++)
            mbb.put((byte) 'x');

        new LockAndModify(mbb,0,LENGTH/3);
        new LockAndModify(mbb,0,LENGTH/2+ LENGTH/4);

    }



    private static class LockAndModify extends Thread{


        private ByteBuffer buff;

        private int start,end;

        /**
         * Allocates a new {@code Thread} object. This constructor has the same
         * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
         * {@code (null, null, gname)}, where {@code gname} is a newly generated
         * name. Automatically generated names are of the form
         * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
         */
        public LockAndModify(ByteBuffer buff, int start, int end) {
            this.start = start;
            this.end = end;
            buff.limit(end);
            buff.position(start);
            this.buff = buff.slice();
            start();
        }


        @Override
        public void run() {
            try {
                FileLock lock = fc.tryLock(start,end,false);
                System.out.println("Locked: " + start + " to "+ end);

                while (buff.position() < buff.limit()-1)
                    buff.put((byte) (buff.get()+1));
                lock.release();
                System.out.println("Released: "+ start + " to " + end);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
