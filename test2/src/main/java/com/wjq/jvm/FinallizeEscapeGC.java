package com.wjq.jvm;

/**
 * Created by wangjianqiang on 2018/3/18.
 */
public class FinallizeEscapeGC {


    public static FinallizeEscapeGC SAVE_HOOK = null;


    public void isAlive() {
        System.out.println("yes,i am still alive");
    }

    /**
     * 任何一个对象的finallize 方法只能被系统调用一次
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method excuted!");
        FinallizeEscapeGC.SAVE_HOOK = this;
    }


    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinallizeEscapeGC();

        SAVE_HOOK = null;

        //gc 的时候会自动调用对象的finallize()方法
        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("no , i am dead!");


        SAVE_HOOK = null;
        //第二次不会调用
        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("no , i am dead!");
    }

}
