package multithreading.tasks.task5.api.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import multithreading.tasks.task5.api.repositories.CurrencyRepository;
import multithreading.tasks.task5.entities.Currency;
import multithreading.tasks.task5.entities.CurrencyType;

public class CurrencyRepositoryImpl extends CrudRepositoryImpl<Currency> implements
    CurrencyRepository {

  @Override
  public Currency readByCurrencyType(CurrencyType currencyType) {
    List<Currency> currencies = new ArrayList<>(objects.values());
    return currencies.stream()
        .filter(currency -> currency.getCurrencyType().equals(currencyType))
        .findFirst().orElse(null);
  }
}
