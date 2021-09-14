package database.api.controller;

import static database.constants.URL.STUDENTS;

import database.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(STUDENTS)
@RequiredArgsConstructor
public class StudentController extends CrudController<Student> {

}
