package multithreading.tasks.task5.api.controllers.impl;

import multithreading.tasks.task5.api.controllers.CurrencyController;
import multithreading.tasks.task5.api.services.CurrencyService;
import multithreading.tasks.task5.entities.Currency;
import multithreading.tasks.task5.entities.CurrencyType;

public class CurrencyControllerImpl extends CrudControllerImpl<Currency, CurrencyService>
    implements CurrencyController {

  public CurrencyControllerImpl(CurrencyService service) {
    super(service);
  }

  @Override
  public void changeExchangeRate(CurrencyType currencyType1, CurrencyType currencyType2, Double newRate) {
    service.changeExchangeRate(currencyType1, currencyType2, newRate);
  }
}
