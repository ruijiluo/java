package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class Box {
    private int milkNumber=0;
    private final ReentrantLock lock=new ReentrantLock(true);

    public synchronized void put(int milk ){
        if (milkNumber != 0){
            try {
                notifyAll();   //Objact的方法唤醒在等待的线程
                wait();   //Objact的方法使线程等待唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (milkNumber == 0) {
            try {
                lock.lock();
                System.out.println("生产者将1瓶牛奶放入奶箱");
                milkNumber++;
                System.out.println("奶箱余下"+milkNumber+"瓶牛奶");
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                notifyAll();
            }
        }

    }

    public synchronized void get() {
        if(milkNumber == 0){
            try {
                wait();   //Objact的方法使线程等待唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (milkNumber != 0) {
            System.out.println("用户拿到1瓶牛奶");
            milkNumber--;
            System.out.println("奶箱余下" + milkNumber + "瓶牛奶");
            if (milkNumber == 0) {
                notifyAll();   //Objact的方法唤醒在等待的线程
            }
        }
    }
}
