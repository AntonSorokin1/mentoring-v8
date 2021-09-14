package multithreading.tasks.task5.api.controllers;

import multithreading.tasks.task5.entities.Currency;
import multithreading.tasks.task5.entities.CurrencyType;

public interface CurrencyController extends CrudController<Currency> {

  void changeExchangeRate(CurrencyType currencyType1, CurrencyType currencyType2, Double newRate);
}
