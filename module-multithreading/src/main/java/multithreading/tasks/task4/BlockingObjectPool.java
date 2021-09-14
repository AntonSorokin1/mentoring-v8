package multithreading.tasks.task4;

import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.List;

/**
 * Pool that block when it has not any items, or it fulls
 */
public class BlockingObjectPool {

  private static final Integer POOL_SIZE = 16;
  private final List<Object> pool = new ArrayList<>();

  /**
   * Creates filled pool of passed size
   *
   * @param size of pool
   */
  public BlockingObjectPool(int size) {
    synchronized (pool) {
      range(0, size)
          .forEach(i -> pool.add(new Object()));
    }
  }

  /**
   * Gets object from pool or blocks if pool is empty
   *
   * @return object from pool
   */
  public synchronized Object get() throws InterruptedException {
    while (pool.isEmpty()) {
      wait();
    }
    Object result = pool.remove(0);
    notifyAll();
    return result;
  }

  /**
   * Puts object to pool or blocks if pool is full
   *
   * @param object to be taken back to pool
   */
  public synchronized void take(Object object) throws InterruptedException {
    while (pool.size() >= POOL_SIZE) {
      wait();
    }
    pool.add(object);
    notifyAll();
  }
}
