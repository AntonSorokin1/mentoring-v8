package database.api.controller;

import static database.constants.URL.EXAM_RESULT;

import database.entities.ExamResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EXAM_RESULT)
@RequiredArgsConstructor
public class ExamResultController extends CrudController<ExamResult> {

}
