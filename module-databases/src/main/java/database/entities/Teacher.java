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
public class Teacher extends AbstractIdentifiableObject {

  private String name;
  private String surname;
  private LocalDate birthDate;
  private TeacherTitle title;

  public Teacher(Long id, LocalDate created, LocalDate updated, String name, String surname,
      LocalDate birthDate, TeacherTitle title) {
    super(id, created, updated);
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
    this.title = title;
  }
}
