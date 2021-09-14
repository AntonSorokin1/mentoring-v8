package multithreading.tasks.task5.initializers.impl;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import multithreading.tasks.task5.api.repositories.AccountRepository;
import multithreading.tasks.task5.api.repositories.CurrencyRepository;
import multithreading.tasks.task5.api.repositories.impl.AccountRepositoryImpl;
import multithreading.tasks.task5.api.repositories.impl.CurrencyRepositoryImpl;
import multithreading.tasks.task5.initializers.ApiInitializer;

public class RepositoryApiInitializer implements ApiInitializer {

  @Override
  public Map<Class<?>, Object> init() {
    return of(
            new SimpleEntry<>(AccountRepository.class, new AccountRepositoryImpl()),
            new SimpleEntry<>(CurrencyRepository.class, new CurrencyRepositoryImpl()))
        .collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue));
  }
}
