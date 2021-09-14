package multithreading.tasks.task5.api.repositories;

import multithreading.tasks.task5.entities.Currency;
import multithreading.tasks.task5.entities.CurrencyType;

public interface CurrencyRepository extends CrudRepository<Currency> {

  Currency readByCurrencyType(CurrencyType currencyType);
}
