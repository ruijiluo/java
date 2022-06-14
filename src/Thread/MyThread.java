package Thread;

public class MyThread implements Runnable {
    final Object object1=new Object();
    final Object object2=new Object();
    Thread t,t1 ,t2;
    MyThread() {
        t1 = new Thread(this);
        t2 = new Thread(this);
        t  = new Thread(this);
        t.setName("teacher");
        t1.setName("student1");
        t2.setName("student2");
    }
    public void run() {
            if (Thread.currentThread().getName().equals("student1")) {
                try {
                    System.out.println(Thread.currentThread().getName() + "��˯��,������");
                    Thread.sleep(10 * 60 * 1000);    // ˯��10����
                } catch (Exception e) {   //�����ж��׳��쳣,�� e ����,catch����
                    System.out.println(Thread.currentThread().getName() + "����ʦ���ѿ�ʼ�Ͽ�");
                    t2.interrupt();       // ����student2
                }
            } else if (Thread.currentThread().getName().equals("student2")) {
                try {
                    System.out.println(Thread.currentThread().getName() + "��˯��,������");
                    Thread.sleep(60 * 60 * 1000);   // ˯��1Сʱ
                } catch (InterruptedException e) {   //�����ж��׳��쳣,�� e ����,catch����
                    System.out.println(Thread.currentThread().getName() + "��student1���ѿ�ʼ�Ͽ�");
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    System.out.println("�Ͽ�");
                }
                t1.interrupt();   // ����student1
            }
    }
}

class Test1{
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.t1.start();
        mt.t1.join(100);
        mt.t2.start();
        mt.t2.join(100);
        mt.t.start();
    }
}
