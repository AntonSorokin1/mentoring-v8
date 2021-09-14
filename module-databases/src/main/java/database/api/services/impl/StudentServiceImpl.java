package database.api.services.impl;

import database.api.services.StudentService;
import database.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudServiceImpl<Student> implements StudentService {

}
