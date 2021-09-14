package multithreading.tasks.task5.initializers.impl;

import static java.util.stream.Collectors.toMap;
import static multithreading.tasks.task5.EntitiesContainer.getInstance;
import static multithreading.tasks.task5.entities.CurrencyType.DOLLAR;
import static multithreading.tasks.task5.entities.CurrencyType.EURO;
import static multithreading.tasks.task5.entities.CurrencyType.RUBLE;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import multithreading.tasks.task5.EntitiesContainer;
import multithreading.tasks.task5.api.controllers.CurrencyController;
import multithreading.tasks.task5.entities.Currency;
import multithreading.tasks.task5.initializers.EntityInitializer;

public class CurrencyEntityInitializer implements EntityInitializer {

  private final EntitiesContainer container = getInstance();
  private final CurrencyController controller = container.get(CurrencyController.class);

  private final List<Currency> currencies = new ArrayList<>();

  @Override
  public void init() {
    currencies.add(new Currency(RUBLE, Stream.of(
        new SimpleEntry<>(RUBLE, 1d),
        new SimpleEntry<>(DOLLAR, 72.68d),
        new SimpleEntry<>(EURO, 85.73d)
    ).collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue))));

    currencies.add(new Currency(DOLLAR, Stream.of(
        new SimpleEntry<>(RUBLE, 0.012d),
        new SimpleEntry<>(DOLLAR, 1d),
        new SimpleEntry<>(EURO, 1.18d)
    ).collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue))));

    currencies.add(new Currency(EURO, Stream.of(
        new SimpleEntry<>(RUBLE, 0.015d),
        new SimpleEntry<>(DOLLAR, 0.85d),
        new SimpleEntry<>(EURO, 1d)
    ).collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue))));

    currencies.forEach(controller::create);
  }
}
