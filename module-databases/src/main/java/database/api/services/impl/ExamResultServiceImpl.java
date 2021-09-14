package database.api.services.impl;

import database.api.services.ExamResultService;
import database.entities.ExamResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamResultServiceImpl extends CrudServiceImpl<ExamResult> implements ExamResultService {

}
