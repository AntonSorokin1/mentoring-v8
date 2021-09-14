package database.api.controller;

import static database.constants.URL.SUBJECTS;

import database.entities.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SUBJECTS)
@RequiredArgsConstructor
public class SubjectController extends CrudController<Subject> {

}
