package multithreading.tasks.task5.api.controllers.impl;

import static java.lang.Math.floor;

import java.util.Map;
import multithreading.tasks.task5.api.controllers.AccountController;
import multithreading.tasks.task5.api.services.AccountService;
import multithreading.tasks.task5.api.services.CurrencyService;
import multithreading.tasks.task5.entities.Account;
import multithreading.tasks.task5.entities.Currency;
import multithreading.tasks.task5.entities.CurrencyType;

public class AccountControllerImpl extends CrudControllerImpl<Account, AccountService>
    implements AccountController {

  private final CurrencyService currencyService;

  public AccountControllerImpl(AccountService service, CurrencyService currencyService) {
    super(service);
    this.currencyService = currencyService;
  }

  @Override
  public Double getBalanceByCurrencyType(Long accountId, CurrencyType currencyType) {
    return service.getBalanceByCurrencyType(accountId, currencyType);
  }

  @Override
  public Map<CurrencyType, Double> getBalanceOfAllCurrencies(Long accountId) {
    return service.getBalanceOfAllCurrencies(accountId);
  }

  @Override
  public Double topUpBalanceByCurrencyType(Long accountId, CurrencyType currencyType,
      Double deposit) {
    return service.topUpBalanceByCurrencyType(accountId, currencyType, deposit);
  }

  @Override
  public Double withdrawFromCurrency(Long accountId, CurrencyType currencyType, Double amount) {
    return service.withdrawFromCurrency(accountId, currencyType, amount);
  }

  @Override
  public void buyMaxCurrency(Long accountId, CurrencyType purchasedCurrencyType,
      CurrencyType tradedCurrencyType) {
    Account account = service.read(accountId);
    Currency purchasedCurrency = currencyService.readByCurrencyType(purchasedCurrencyType);

    Double exchangeRate = purchasedCurrency.getExchangeRates().getOrDefault(tradedCurrencyType, null);
    Double currencyBalance = account.getCurrencies().getOrDefault(tradedCurrencyType, null);
    Double amount = floor(currencyBalance / exchangeRate);

    account.getCurrencies()
        .computeIfPresent(tradedCurrencyType, (k, v) -> v - (exchangeRate * amount));
    account.getCurrencies()
        .computeIfPresent(purchasedCurrencyType, (k, v) -> v + amount);

    service.update(accountId, account);
  }

  @Override
  public void buyCurrency(Long accountId, CurrencyType purchasedCurrencyType,
      CurrencyType tradedCurrencyType, Double amount) {
    Account account = service.read(accountId);
    Currency purchasedCurrency = currencyService.readByCurrencyType(purchasedCurrencyType);

    Double exchangeRate = purchasedCurrency.getExchangeRates().getOrDefault(tradedCurrencyType, null);
    Double currencyBalance = account.getCurrencies().getOrDefault(tradedCurrencyType, null);
    Double newAmount = (floor(currencyBalance / exchangeRate) < amount) ? 0 : amount;

    account.getCurrencies()
        .computeIfPresent(tradedCurrencyType, (k, v) -> v - (exchangeRate * newAmount));
    account.getCurrencies().computeIfPresent(purchasedCurrencyType, (k, v) -> v + newAmount);

    service.update(accountId, account);
  }
}
