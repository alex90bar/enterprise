import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

  public static class Writer extends Thread {
    private Count count;

    public Writer(Count count, int number) {
      this.setName("Writer" + number);
      this.count = count;
    }

    @Override
    public void run() {
      IntStream.range(0, 1000000).forEach((i) -> count.inc());
    }
  }

  public static class Reader extends Thread {
    private Count count;

    public Reader(Count count, int number) {
      this.setName("Reader" + number);
      this.count = count;
    }

    @Override
    public void run() {
      IntStream.range(0, 1000000).forEach((i) -> System.out.println(count.getCount()));
    }
  }


  public static void main(String[] args) throws InterruptedException {
    var counter = new Count();
    var w1 = new Writer(counter,1);
    var w2 = new Writer(counter,2);
    var w3 = new Writer(counter,3);
    var w4 = new Writer(counter,4);

    var r1 = new Reader(counter, 1);

    w1.start();
    w2.start();
    w3.start();
    w4.start();

    r1.start();

    w1.join();
    w2.join();
    w3.join();
    w4.join();

    r1.join();

    System.out.println(counter.getCount());

  }


}
