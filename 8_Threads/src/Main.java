import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

  public static class MyThread extends Thread{
    private final String text;

    public MyThread(String text) {
      this.setName(text);
      this.text = text;
    }

    @Override
    public void run() {
      IntStream.range(0, 10).forEach((i) -> System.out.println(text));
    }
  }

  public static void main(String[] args) throws InterruptedException {
    var t1 = new MyThread("T1");
    var t2 = new MyThread("T2");
    t1.setPriority(Thread.MAX_PRIORITY);
    t1.setDaemon(true);
    t2.setDaemon(true);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    var ex = Executors.newFixedThreadPool(10);
    ex.submit(() -> {System.out.println("Exe");});

    System.out.println("Main started");
  }

//  public static void main(String[] args) {
//    // var t1 = new MyThread("T1");  другой вариант создания потока
//    var t1 = new Thread(() -> {
//      Thread.yield();
//      System.out.println("T1");
//      throw new RuntimeException();  //В исключении прописывается имя потока
//    } , "T1");
//    t1.setDaemon(true);
//    t1.start();
//    System.out.println("Main started");
//  }

}
