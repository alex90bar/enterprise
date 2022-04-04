public class Count {

  private long count = 0;

  public synchronized void inc(){
    count = count + 1;
  }

  public long getCount(){
    return count;
  }

}
