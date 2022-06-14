package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable2 implements Runnable {
    final Object object=new Object();   // ����һ������synchronizedʹ��
    Lock lock=new ReentrantLock();
    int book=1;  // ��ʼ���������

    @Override
    public void run() {
        while (book <79) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "�ٷ���" + book + "����");
                book++;
                Thread.sleep(100);   //ÿ��һ���飬˯��500����
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
        Thread t1=new Thread(myRunnable2,"����ʦ");   //�����߳�
        Thread t2=new Thread(myRunnable2,"����ʦ");
        Thread t3=new Thread(myRunnable2,"ɽ��ʦ");
        t1.start();   //�����߳�
        t2.start();
        t3.start();
    }
}
