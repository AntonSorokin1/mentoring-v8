package multithreading.tasks.task5.api.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import multithreading.tasks.task5.api.repositories.AccountRepository;
import multithreading.tasks.task5.api.services.AccountService;
import multithreading.tasks.task5.entities.Account;
import multithreading.tasks.task5.entities.CurrencyType;

public class AccountServiceImpl extends CrudServiceImpl<Account, AccountRepository>
    implements AccountService {

  public AccountServiceImpl(AccountRepository repository) {
    super(repository);
  }

  @Override
  public void toFile(Long accountId, File file) throws IOException {
    Account account = repository.read(accountId);
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(file, account);
  }

  @Override
  public Account getFromFile(File file) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(file, Account.class);
  }

  @Override
  public Double getBalanceByCurrencyType(Long accountId, CurrencyType currencyType) {
    return repository.read(accountId).getCurrencies().get(currencyType);
  }

  @Override
  public Map<CurrencyType, Double> getBalanceOfAllCurrencies(Long accountId) {
    return repository.read(accountId).getCurrencies();
  }

  @Override
  public Double topUpBalanceByCurrencyType(Long accountId, CurrencyType currencyType,
      Double deposit) {
    Account account = repository.read(accountId);
    account.getCurrencies().computeIfPresent(currencyType, (k, v) -> v + deposit);
    repository.update(accountId, account);
    return account.getCurrencies().get(currencyType);
  }

  @Override
  public Double withdrawFromCurrency(Long accountId, CurrencyType currencyType, Double amount) {
    Account account = repository.read(accountId);
    account.getCurrencies().computeIfPresent(currencyType, (k, v) -> v - amount);
    repository.update(accountId, account);
    return account.getCurrencies().get(currencyType);
  }
}
