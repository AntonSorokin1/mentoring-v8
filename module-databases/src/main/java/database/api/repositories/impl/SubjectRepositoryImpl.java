package database.api.repositories.impl;

import database.api.repositories.SubjectRepository;
import database.entities.Subject;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

  @Override
  public Subject create(Subject object) {
    return null;
  }

  @Override
  public Subject read(Long id) {
    return null;
  }

  @Override
  public List<Subject> readAll() {
    return null;
  }

  @Override
  public Boolean update(Subject object, Long id) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }
}
