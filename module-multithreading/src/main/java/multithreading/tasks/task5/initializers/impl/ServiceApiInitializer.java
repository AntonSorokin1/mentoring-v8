package multithreading.tasks.task5.initializers.impl;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;
import static multithreading.tasks.task5.EntitiesContainer.getInstance;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import multithreading.tasks.task5.EntitiesContainer;
import multithreading.tasks.task5.api.repositories.AccountRepository;
import multithreading.tasks.task5.api.repositories.CurrencyRepository;
import multithreading.tasks.task5.api.services.AccountService;
import multithreading.tasks.task5.api.services.CurrencyService;
import multithreading.tasks.task5.api.services.impl.AccountServiceImpl;
import multithreading.tasks.task5.api.services.impl.CurrencyServiceImpl;
import multithreading.tasks.task5.initializers.ApiInitializer;

public class ServiceApiInitializer implements ApiInitializer {

  private final EntitiesContainer container = getInstance();

  @Override
  public Map<Class<?>, Object> init() {
    return of(
        new SimpleEntry<>(
            AccountService.class,
            new AccountServiceImpl(container.get(AccountRepository.class))),
        new SimpleEntry<>(
            CurrencyService.class,
            new CurrencyServiceImpl(container.get(CurrencyRepository.class))))
        .collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue));
  }
}
