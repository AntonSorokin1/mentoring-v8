package database.configurations;

import database.entities.ExamResult;
import database.entities.Student;
import database.entities.Subject;
import database.entities.Teacher;
import database.mappers.ExamResultMapper;
import database.mappers.Mapper;
import database.mappers.StudentMapper;
import database.mappers.SubjectMapper;
import database.mappers.TeacherMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
  @Bean
  public Mapper<Student> studentMapper() {
    return new StudentMapper();
  }

  @Bean
  public Mapper<Teacher> teacherMapper() {
    return new TeacherMapper();
  }

  @Bean
  public Mapper<Subject> subjectMapper() {
    return new SubjectMapper();
  }

  @Bean
  public Mapper<ExamResult> examResultMapper() {
    return new ExamResultMapper();
  }
}
