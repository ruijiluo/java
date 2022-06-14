package Thread;

public class MyRunnable implements Runnable {
    private final String name;
    MyRunnable(String name) {
        this.name = name;   //设置name
    }
    public void run() {
       for (int i = 0; i < 50; i++) {
           System.out.println(name);   //输出50次name
       }
    }
}

class Tset {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable("new");   //创建MyRunnable对象
        Thread thread = new Thread(myRunnable);   //创建Thread对象
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());   //输出100次当前(mian)线程的名字
        }
        thread.start();
    }
}