package multithreading.tasks.task5.entities;

import java.util.EnumMap;
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
public class Account extends AbstractIdentifiableObject {

  private Map<CurrencyType, Double> currencies = new EnumMap<>(CurrencyType.class);
}
