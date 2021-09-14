package multithreading.tasks.task1;

import static java.util.Arrays.asList;
import static java.util.Collections.synchronizedMap;
import static java.util.logging.Level.INFO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import multithreading.tasks.Task;

public class Task1 implements Task {

  private final Logger logger = Logger.getLogger(Task1.class.getName());

  private final Map<Integer, Integer> map = synchronizedMap(new ConcurrentHashMap<>());

  @Override
  public void runTask(String... args) {
    Runnable task1 = () -> {
      for (int i = 0; i < 5_000; i++) {
        map.put(i, i);
      }
    };
    Thread thread1 = new Thread(task1);

    Runnable task2 = () -> {
      while (thread1.isAlive()) {
        synchronized (map) {
          logger.log(INFO, "Size = {0}, sum = {1}", new Object[]{
              map.values().size(),
              map.values().stream()
                  .mapToInt(Integer::intValue)
                  .sum()
          });
        }
      }
    };
    Thread thread2 = new Thread(task2);

    asList(thread1, thread2).forEach(Thread::start);
  }
}
