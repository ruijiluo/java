package Thread;
/*
3.	参照教材例子9，编写一个Java应用程序，在主线程中再创建3个线程：“运货司机”、“装运工”和“仓库管理员”。
    要求线程“运货司机”占有CPU资源后立刻联合线程“装运工”，也就是让“运货司机”一直等到“装运工”完成工作才能开车，
    而“装运工”占有CPU资源后立刻联合线程“仓库管理员”， 也就是让“装运工”一直等到“仓库管理员”打开仓库才能开始搬运货物。
*/

public class Warehouse implements Runnable{
    Thread driver,shipper,administrator;  //创建三个线程(运货司机、装运工、仓库管理员)
    public void setThread(Thread driver,Thread shipper,Thread administrator){
        this.driver=driver;
        this.shipper=shipper;
        this.administrator=administrator;
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("运货司机")){
            try {shipper.start();
                 shipper.join();
                 System.out.println("运货司机运货离开");
            }catch (InterruptedException e){}
        }else if(Thread.currentThread().getName().equals("装运工")){
            try {administrator.start();
                administrator.join();
                System.out.println("装运工开始装货");
            }catch (InterruptedException e){}
        }else {
                System.out.println("仓库管理员打开了仓库大门");
        }
    }
}

class Test3{
    public static void main(String[] args) {
        Warehouse warehouse=new Warehouse();
        Thread driver=new Thread(warehouse,"运货司机");
        Thread shipper=new Thread(warehouse,"装运工");
        Thread administrator=new Thread(warehouse,"仓库管理员");
        warehouse.setThread(driver,shipper,administrator);
        //“运货司机”->“装运工”->“仓库管理员”
        driver.start();
    }
}