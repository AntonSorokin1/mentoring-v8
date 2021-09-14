package database;

import static java.time.LocalDate.now;

import database.api.controller.CrudController;
import database.api.controller.StudentController;
import database.configurations.MainConfig;
import database.entities.Student;
import java.util.Objects;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

    CrudController<Student> controller = context.getBean(StudentController.class);
    System.out.println(controller);

    Student student = new Student("Petya", "Petrov", "88005553535", now());
    System.out.println(student);
    controller.create(student);

    Objects.requireNonNull(controller.getAll().getBody()).forEach(System.out::println);
  }
}
