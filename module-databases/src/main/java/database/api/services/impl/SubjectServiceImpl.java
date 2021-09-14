package database.api.services.impl;

import database.api.services.SubjectService;
import database.entities.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl extends CrudServiceImpl<Subject> implements SubjectService {

}
