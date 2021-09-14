package database.configurations;

import database.api.controller.CrudController;
import database.api.controller.ExamResultController;
import database.api.controller.StudentController;
import database.api.controller.SubjectController;
import database.api.controller.TeacherController;
import database.api.services.CrudService;
import database.entities.AbstractIdentifiableObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {


  public <T extends AbstractIdentifiableObject> CrudController<T> crudController() {
    return new CrudController<>();
  }

  @Bean
  public StudentController studentController() {
    return new StudentController();
  }

  @Bean
  public TeacherController teacherController() {
    return new TeacherController();
  }

  @Bean
  public SubjectController subjectController() {
    return new SubjectController();
  }

  @Bean
  public ExamResultController examResultController() {
    return new ExamResultController();
  }
}
