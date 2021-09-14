package database.entities;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Subject extends AbstractIdentifiableObject {

  private String name;
  private Long teacherId;

  public Subject(Long id, LocalDate created, LocalDate updated, String name, Long teacherId) {
    super(id, created, updated);
    this.name = name;
    this.teacherId = teacherId;
  }
}
