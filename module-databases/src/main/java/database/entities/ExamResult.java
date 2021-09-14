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
public class ExamResult extends AbstractIdentifiableObject {

  private Long subjectId;
  private Long studentId;
  private Integer mark;

  public ExamResult(Long id, LocalDate created, LocalDate update, Long subjectId, Long studentId,
      Integer mark) {
    super(id, created, update);
    this.subjectId = subjectId;
    this.studentId = studentId;
    this.mark = mark;
  }
}
