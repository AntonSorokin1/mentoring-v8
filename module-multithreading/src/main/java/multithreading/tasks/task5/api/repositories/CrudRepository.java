package multithreading.tasks.task5.api.repositories;

import java.util.List;
import multithreading.tasks.task5.entities.AbstractIdentifiableObject;

public interface CrudRepository<T extends AbstractIdentifiableObject> {
  void create(T object);

  T read(Long id);

  List<T> readAll();

  boolean update(Long id, T object);

  boolean delete(Long id);
}
