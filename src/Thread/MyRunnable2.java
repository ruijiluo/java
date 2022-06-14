package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable2 implements Runnable {
    final Object object=new Object();   // 创建一个对象供synchronized使用
    Lock lock=new ReentrantLock();
    int book=1;  // 初始化书的数量

    @Override
    public void run() {
        while (book <79) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "再发第" + book + "本书");
                book++;
                Thread.sleep(100);   //每发一本书，睡眠500毫秒
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}

class Test2{
    public static void main(String[] args) {
        MyRunnable2 myRunnable2=new MyRunnable2();
        Thread t1=new Thread(myRunnable2,"易老师");   //创建线程
        Thread t2=new Thread(myRunnable2,"而老师");
        Thread t3=new Thread(myRunnable2,"山老师");
        t1.start();   //启动线程
        t2.start();
        t3.start();
    }
}
