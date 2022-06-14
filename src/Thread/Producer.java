package Thread;

public class Producer implements Runnable{
    Box box;
    public Producer(Box box) {
        this.box=box;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            box.put(i);
        }
    }
}
