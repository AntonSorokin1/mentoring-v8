package multithreading.tasks.task5.api.services.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import multithreading.tasks.task5.api.repositories.CrudRepository;
import multithreading.tasks.task5.api.services.CrudService;
import multithreading.tasks.task5.entities.AbstractIdentifiableObject;

@RequiredArgsConstructor
public class CrudServiceImpl<T extends AbstractIdentifiableObject, R extends CrudRepository<T>>
    implements CrudService<T> {

  protected final R repository;

  @Override
  public void create(T object) {
    repository.create(object);
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
  public Boolean update(Long id, T object) {
    return repository.update(id, object);
  }

  @Override
  public Boolean delete(Long id) {
    return repository.delete(id);
  }
}
