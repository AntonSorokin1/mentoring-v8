package multithreading.tasks.task5.initializers.impl;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static multithreading.tasks.task5.EntitiesContainer.getInstance;
import static multithreading.tasks.task5.entities.CurrencyType.values;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import multithreading.tasks.task5.EntitiesContainer;
import multithreading.tasks.task5.api.controllers.AccountController;
import multithreading.tasks.task5.entities.Account;
import multithreading.tasks.task5.entities.CurrencyType;
import multithreading.tasks.task5.initializers.EntityInitializer;

public class AccountEntityInitializer implements EntityInitializer {

  private final EntitiesContainer container = getInstance();
  private final AccountController controller = container.get(AccountController.class);
  private final Random random = new Random();

  private final List<Account> accountList = new ArrayList<>();

  @Override
  public void init() {
    range(0, 10).forEach(i -> {
      Map<CurrencyType, Double> map = new EnumMap<>(CurrencyType.class);
      stream(values())
              .forEach(t -> map.put(t, 1_000 * random.nextDouble()));
      accountList.add(new Account(map));
    });
    accountList.forEach(controller::create);
  }
}
