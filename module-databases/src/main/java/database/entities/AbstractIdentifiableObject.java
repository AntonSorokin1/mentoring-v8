package database.entities;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractIdentifiableObject {

  protected Long id;
  protected LocalDate created;
  protected LocalDate updated;
}
