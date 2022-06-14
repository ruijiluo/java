package Thread;

public class Customer implements Runnable{
    Box box;
    public Customer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            box.get();
        }
    }
}
