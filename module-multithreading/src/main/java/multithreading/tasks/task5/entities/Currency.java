package multithreading.tasks.task5.entities;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Currency extends AbstractIdentifiableObject {

  private CurrencyType currencyType;
  private Map<CurrencyType, Double> exchangeRates;
}
