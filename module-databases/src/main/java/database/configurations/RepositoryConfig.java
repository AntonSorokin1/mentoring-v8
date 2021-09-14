package database.configurations;

import database.api.repositories.CrudRepository;
import database.api.repositories.ExamResultRepository;
import database.api.repositories.StudentRepository;
import database.api.repositories.SubjectRepository;
import database.api.repositories.TeacherRepository;
import database.api.repositories.impl.ExamResultRepositoryImpl;
import database.api.repositories.impl.StudentRepositoryImpl;
import database.api.repositories.impl.SubjectRepositoryImpl;
import database.api.repositories.impl.TeacherRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

  @Bean
  public StudentRepository studentRepository() {
    return new StudentRepositoryImpl();
  }

  @Bean
  public TeacherRepository teacherRepository() {
    return new TeacherRepositoryImpl();
  }

  @Bean
  public SubjectRepository subjectRepository() {
    return new SubjectRepositoryImpl();
  }

  @Bean
  public ExamResultRepository examResultRepository() {
    return new ExamResultRepositoryImpl();
  }
}
