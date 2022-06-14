package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class Box {
    private int milkNumber=0;
    private final ReentrantLock lock=new ReentrantLock(true);

    public synchronized void put(int milk ){
        if (milkNumber != 0){
            try {
                notifyAll();   //Objact�ķ��������ڵȴ����߳�
                wait();   //Objact�ķ���ʹ�̵߳ȴ�����
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (milkNumber == 0) {
            try {
                lock.lock();
                System.out.println("�����߽�1ƿţ�̷�������");
                milkNumber++;
                System.out.println("��������"+milkNumber+"ƿţ��");
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
                wait();   //Objact�ķ���ʹ�̵߳ȴ�����
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (milkNumber != 0) {
            System.out.println("�û��õ�1ƿţ��");
            milkNumber--;
            System.out.println("��������" + milkNumber + "ƿţ��");
            if (milkNumber == 0) {
                notifyAll();   //Objact�ķ��������ڵȴ����߳�
            }
        }
    }
}
