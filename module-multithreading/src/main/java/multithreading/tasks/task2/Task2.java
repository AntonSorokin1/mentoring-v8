package multithreading.tasks.task2;

import static java.lang.Math.sqrt;
import static java.lang.Thread.currentThread;
import static java.util.Arrays.asList;
import static java.util.logging.Level.INFO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import multithreading.tasks.Task;

public class Task2 implements Task {

  private final Logger logger = Logger.getLogger(Task2.class.getName());

  private final List<Integer> collection = new ArrayList<>();
  private final Random random = new Random();

  @Override
  public void runTask(String... args) {
    Runnable task1 = () -> {
      while (true) {
        synchronized (collection) {
          collection.add(random.nextInt(10));
        }
        if (currentThread().isInterrupted()) {
          break;
        }
      }
    };
    Runnable task2 = () -> {
      while (true) {
        synchronized (collection) {
          logger.log(INFO, "Sum = {0}", collection.stream()
              .mapToInt(Integer::intValue)
              .sum());
        }
        if (currentThread().isInterrupted()) {
          break;
        }
      }
    };
    Runnable task3 = () -> {
      while (true) {
        synchronized (collection) {
          logger.log(INFO, "Sqrt = {0}", sqrt(collection.stream()
              .map(n -> n * n)
              .mapToInt(Integer::intValue)
              .sum()
          ));
        }
        if (currentThread().isInterrupted()) {
          break;
        }
      }
    };

    asList(new Thread(task1), new Thread(task2), new Thread(task3)).forEach(Thread::start);
  }
}
