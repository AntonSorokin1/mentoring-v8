package multithreading.tasks.task5;

import static java.lang.Thread.currentThread;
import static java.util.Arrays.asList;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.ThreadLocalRandom.current;
import static java.util.logging.Level.INFO;
import static java.util.stream.IntStream.range;
import static multithreading.tasks.task5.EntitiesContainer.getInstance;
import static multithreading.tasks.task5.entities.CurrencyType.values;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import multithreading.tasks.Task;
import multithreading.tasks.task5.api.controllers.AccountController;
import multithreading.tasks.task5.entities.CurrencyType;
import multithreading.tasks.task5.initializers.EntityInitializer;
import multithreading.tasks.task5.initializers.impl.AccountEntityInitializer;
import multithreading.tasks.task5.initializers.impl.CurrencyEntityInitializer;

public class Task5 implements Task {

  private final Logger logger = Logger.getLogger(Task5.class.getName());

  private final EntitiesContainer container = getInstance();

  @Override
  public void runTask(String... args) {
    container.init();
    asList(new CurrencyEntityInitializer(), new AccountEntityInitializer())
        .forEach(EntityInitializer::init);

    Callable<String> exchangeTask = () -> {
      AccountController accountController = container.get(AccountController.class);
      Long id = current().nextLong(10);
      CurrencyType purchased = values()[current().nextInt(3)];
      CurrencyType traded = values()[current().nextInt(3)];
      accountController.buyMaxCurrency(id, purchased, traded);
      logger.log(INFO, "Called \"buyMaxCurrency\" method with params ({0}, {1}, {2})",
          new Object[]{id, purchased, traded});
      return null;
    };
    List<Callable<String>> tasks = new ArrayList<>();
    range(0, 1_000).forEach(index -> tasks.add(exchangeTask));

    try {
      ExecutorService service = newFixedThreadPool(10);
      service.invokeAll(tasks);
      service.shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
      currentThread().interrupt();
    }

  }
}