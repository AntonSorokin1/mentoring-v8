package multithreading.tasks.task5.initializers.impl;

import static java.util.stream.Collectors.toMap;
import static multithreading.tasks.task5.EntitiesContainer.getInstance;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;
import multithreading.tasks.task5.EntitiesContainer;
import multithreading.tasks.task5.api.controllers.AccountController;
import multithreading.tasks.task5.api.controllers.CurrencyController;
import multithreading.tasks.task5.api.controllers.impl.AccountControllerImpl;
import multithreading.tasks.task5.api.controllers.impl.CurrencyControllerImpl;
import multithreading.tasks.task5.api.services.AccountService;
import multithreading.tasks.task5.api.services.CurrencyService;
import multithreading.tasks.task5.initializers.ApiInitializer;

public class ControllerApiInitializer implements ApiInitializer {

  private final EntitiesContainer container = getInstance();

  @Override
  public Map<Class<?>, Object> init() {
    return Stream.of(
            new SimpleEntry<>(
                AccountController.class,
                new AccountControllerImpl(
                    container.get(AccountService.class),
                    container.get(CurrencyService.class))),
            new SimpleEntry<>(
                CurrencyController.class,
                new CurrencyControllerImpl(container.get(CurrencyService.class))
            ))
        .collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue));
  }
}
