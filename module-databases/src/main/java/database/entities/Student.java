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
public class Student extends AbstractIdentifiableObject {

  private String name;
  private String surname;
  private String phoneNumber;
  private LocalDate birthDate;

  public Student(Long id, LocalDate created, LocalDate updated, String name, String surname,
      String phoneNumber, LocalDate birthDate) {
    super(id, created, updated);
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
    this.birthDate = birthDate;
  }
}
