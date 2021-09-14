package multithreading.tasks.task3;

import static java.lang.Thread.currentThread;
import static java.util.Arrays.asList;
import static java.util.logging.Level.INFO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import multithreading.tasks.Task;

public class Task3 implements Task {

  private static final Integer NUMBER_OF_MESSAGES = 5_000;

  private static final Integer BUFFER_SIZE = 30;
  private static final Logger logger = Logger.getLogger(Task3.class.getName());

  private final Random random = new Random();
  private final List<Integer> buffer = new ArrayList<>();

  protected synchronized Integer produce(Integer value) {
    while (buffer.size() == BUFFER_SIZE) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
        currentThread().interrupt();
      }
    }
    buffer.add(value);
    notifyAll();
    return value;
  }

  protected synchronized Integer consume() {
    while (buffer.isEmpty()) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
        currentThread().interrupt();
      }
    }
    Integer result = buffer.remove(0);
    notifyAll();
    return result;
  }

  @Override
  public void runTask(String... args) {
    Runnable producerTask = () -> {
      for (int i = 0; i < NUMBER_OF_MESSAGES; i++) {
        logger.log(INFO, "Message produced - {0}", produce(random.nextInt(10_000)));
      }
    };
    Runnable consumerTask = () -> {
      while (true) {
        logger.log(INFO, "Message consumed - {0}", consume());
      }
    };

    asList(new Thread(producerTask), new Thread(consumerTask)).forEach(Thread::start);
  }
}
