package database.api.controller;

import static database.constants.URL.TEACHERS;

import database.entities.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TEACHERS)
@RequiredArgsConstructor
public class TeacherController extends CrudController<Teacher> {

}
