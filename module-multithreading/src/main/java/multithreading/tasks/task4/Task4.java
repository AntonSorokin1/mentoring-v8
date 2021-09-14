package multithreading.tasks.task4;

import static java.util.logging.Level.INFO;

import java.util.logging.Logger;
import multithreading.tasks.Task;

public class Task4 implements Task {

  private final Logger logger = Logger.getLogger(Task4.class.getName());

  @Override
  public void runTask(String... args) {
    logger.log(INFO, "Nothing to execute. Look into the task package.");
  }
}
