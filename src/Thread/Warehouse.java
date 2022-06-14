package Thread;
/*
3.	���ս̲�����9����дһ��JavaӦ�ó��������߳����ٴ���3���̣߳����˻�˾��������װ�˹����͡��ֿ����Ա����
    Ҫ���̡߳��˻�˾����ռ��CPU��Դ�����������̡߳�װ�˹�����Ҳ�����á��˻�˾����һֱ�ȵ���װ�˹�����ɹ������ܿ�����
    ����װ�˹���ռ��CPU��Դ�����������̡߳��ֿ����Ա���� Ҳ�����á�װ�˹���һֱ�ȵ����ֿ����Ա���򿪲ֿ���ܿ�ʼ���˻��
*/

public class Warehouse implements Runnable{
    Thread driver,shipper,administrator;  //���������߳�(�˻�˾����װ�˹����ֿ����Ա)
    public void setThread(Thread driver,Thread shipper,Thread administrator){
        this.driver=driver;
        this.shipper=shipper;
        this.administrator=administrator;
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("�˻�˾��")){
            try {shipper.start();
                 shipper.join();
                 System.out.println("�˻�˾���˻��뿪");
            }catch (InterruptedException e){}
        }else if(Thread.currentThread().getName().equals("װ�˹�")){
            try {administrator.start();
                administrator.join();
                System.out.println("װ�˹���ʼװ��");
            }catch (InterruptedException e){}
        }else {
                System.out.println("�ֿ����Ա���˲ֿ����");
        }
    }
}

class Test3{
    public static void main(String[] args) {
        Warehouse warehouse=new Warehouse();
        Thread driver=new Thread(warehouse,"�˻�˾��");
        Thread shipper=new Thread(warehouse,"װ�˹�");
        Thread administrator=new Thread(warehouse,"�ֿ����Ա");
        warehouse.setThread(driver,shipper,administrator);
        //���˻�˾����->��װ�˹���->���ֿ����Ա��
        driver.start();
    }
}