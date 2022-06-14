package Thread;

public class MyRunnable implements Runnable {
    private final String name;
    MyRunnable(String name) {
        this.name = name;   //����name
    }
    public void run() {
       for (int i = 0; i < 50; i++) {
           System.out.println(name);   //���50��name
       }
    }
}

class Tset {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable("new");   //����MyRunnable����
        Thread thread = new Thread(myRunnable);   //����Thread����
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());   //���100�ε�ǰ(mian)�̵߳�����
        }
        thread.start();
    }
}