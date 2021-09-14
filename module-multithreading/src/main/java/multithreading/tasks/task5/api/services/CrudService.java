package multithreading.tasks.task5.api.services;

import java.util.List;
import multithreading.tasks.task5.entities.AbstractIdentifiableObject;

public interface CrudService<T extends AbstractIdentifiableObject> {
  void create(T object);

  T read(Long id);

  List<T> readAll();

  Boolean update(Long id, T object);

  Boolean delete(Long id);
}
