package multithreading.tasks.task5.api.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import multithreading.tasks.task5.entities.Account;
import multithreading.tasks.task5.entities.CurrencyType;

public interface AccountService extends CrudService<Account> {
  void toFile(Long accountId, File file) throws IOException;

  Account getFromFile(File file) throws IOException;

  Double getBalanceByCurrencyType(Long accountId, CurrencyType currencyType);

  Map<CurrencyType, Double> getBalanceOfAllCurrencies(Long accountId);

  Double topUpBalanceByCurrencyType(Long accountId, CurrencyType currencyType, Double deposit);

  Double withdrawFromCurrency(Long accountId, CurrencyType currencyType, Double amount);
}
