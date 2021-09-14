package database.configurations;

import database.api.services.CrudService;
import database.api.services.ExamResultService;
import database.api.services.StudentService;
import database.api.services.SubjectService;
import database.api.services.TeacherService;
import database.api.services.impl.CrudServiceImpl;
import database.api.services.impl.ExamResultServiceImpl;
import database.api.services.impl.StudentServiceImpl;
import database.api.services.impl.SubjectServiceImpl;
import database.api.services.impl.TeacherServiceImpl;
import database.entities.AbstractIdentifiableObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  public <T extends AbstractIdentifiableObject> CrudService<T> crudService() {
    return new CrudServiceImpl<>();
  }

  @Bean
  public StudentService studentService() {
    return new StudentServiceImpl();
  }

  @Bean
  public TeacherService teacherService() {
    return new TeacherServiceImpl();
  }

  @Bean
  public SubjectService subjectService() {
    return new SubjectServiceImpl();
  }

  @Bean
  public ExamResultService examResultService() {
    return new ExamResultServiceImpl();
  }
}
