package multithreading.tasks.task5.api.services;

import multithreading.tasks.task5.entities.Currency;
import multithreading.tasks.task5.entities.CurrencyType;

public interface CurrencyService extends CrudService<Currency> {

  Currency readByCurrencyType(CurrencyType currencyType);

  void changeExchangeRate(CurrencyType currencyType1, CurrencyType currencyType2, Double newRate);
}
