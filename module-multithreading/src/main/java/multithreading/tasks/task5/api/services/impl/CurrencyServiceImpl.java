package multithreading.tasks.task5.api.services.impl;

import multithreading.tasks.task5.api.repositories.CurrencyRepository;
import multithreading.tasks.task5.api.services.CurrencyService;
import multithreading.tasks.task5.entities.Currency;
import multithreading.tasks.task5.entities.CurrencyType;

public class CurrencyServiceImpl extends CrudServiceImpl<Currency, CurrencyRepository>
    implements CurrencyService {

  public CurrencyServiceImpl(CurrencyRepository repository) {
    super(repository);
  }

  @Override
  public Currency readByCurrencyType(CurrencyType currencyType) {
    return repository.readByCurrencyType(currencyType);
  }

  @Override
  public void changeExchangeRate(CurrencyType currencyType1, CurrencyType currencyType2,
      Double newRate) {
    Currency currency1 = repository.readByCurrencyType(currencyType1);
    Currency currency2 = repository.readByCurrencyType(currencyType2);

    currency1.getExchangeRates().computeIfPresent(currencyType2, (k, v) -> newRate);
    currency2.getExchangeRates().computeIfPresent(currencyType1, (k, v) -> 1 / newRate);

    repository.update(currency1.getId(), currency1);
    repository.update(currency2.getId(), currency2);
  }
}
