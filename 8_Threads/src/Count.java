import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Count {

  private long count;

  ReadWriteLock lock = new ReentrantReadWriteLock();

  public void inc(){
    lock.writeLock().lock();
    try{
      count = count + 1;
    } catch (Exception ex){
      ex.printStackTrace();
      throw ex;
    } finally {
      lock.writeLock().unlock();
    }
  }

  public void inc2(){
    lock.writeLock().lock();
    try{
      count = count + 1;
    } catch (Exception ex){
      ex.printStackTrace();
      throw ex;
    } finally {
      lock.writeLock().unlock();
    }
  }

  public long getCount(){
    lock.readLock().lock();
    var l = count;
    lock.readLock().unlock();
    return count;
  }

}
