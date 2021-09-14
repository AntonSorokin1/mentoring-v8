package database.api.services.impl;

import database.api.services.TeacherService;
import database.entities.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends CrudServiceImpl<Teacher> implements TeacherService {

}
