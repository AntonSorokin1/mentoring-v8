package multithreading.tasks.task5.api.controllers;

import java.util.Map;
import multithreading.tasks.task5.entities.Account;
import multithreading.tasks.task5.entities.CurrencyType;

public interface AccountController extends CrudController<Account> {

  Double getBalanceByCurrencyType(Long accountId, CurrencyType currencyType);

  Map<CurrencyType, Double> getBalanceOfAllCurrencies(Long accountId);

  Double topUpBalanceByCurrencyType(Long accountId, CurrencyType currencyType, Double deposit);

  Double withdrawFromCurrency(Long accountId, CurrencyType currencyType, Double amount);

  void buyMaxCurrency(Long accountId, CurrencyType purchasedCurrencyType,
      CurrencyType tradedCurrencyType);

  void buyCurrency(Long accountId, CurrencyType purchasedCurrencyType,
      CurrencyType tradedCurrencyType, Double amount);
}
