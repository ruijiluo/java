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
                    System.out.println(Thread.currentThread().getName() + "在睡觉,不听课");
                    Thread.sleep(10 * 60 * 1000);    // 睡觉10分钟
                } catch (Exception e) {   //休眠中断抛出异常,被 e 接收,catch运行
                    System.out.println(Thread.currentThread().getName() + "被老师叫醒开始上课");
                    t2.interrupt();       // 唤醒student2
                }
            } else if (Thread.currentThread().getName().equals("student2")) {
                try {
                    System.out.println(Thread.currentThread().getName() + "在睡觉,不听课");
                    Thread.sleep(60 * 60 * 1000);   // 睡觉1小时
                } catch (InterruptedException e) {   //休眠中断抛出异常,被 e 接收,catch运行
                    System.out.println(Thread.currentThread().getName() + "被student1叫醒开始上课");
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    System.out.println("上课");
                }
                t1.interrupt();   // 唤醒student1
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
