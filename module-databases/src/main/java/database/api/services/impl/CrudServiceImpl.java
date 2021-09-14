package database.api.services.impl;

import database.api.repositories.CrudRepository;
import database.api.services.CrudService;
import database.entities.AbstractIdentifiableObject;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrudServiceImpl<T extends AbstractIdentifiableObject> implements CrudService<T> {
  @Autowired
  protected CrudRepository<T> repository;

  @Override
  public T create(T object) {
    return repository.create(object);
  }

  @Override
  public T read(Long id) {
    return repository.read(id);
  }

  @Override
  public List<T> readAll() {
    return repository.readAll();
  }

  @Override
  public Boolean update(T object, Long id) {
    return repository.update(object, id);
  }

  @Override
  public Boolean delete(Long id) {
    return repository.delete(id);
  }
}
