package multithreading.tasks.task5.api.controllers;

import java.util.List;
import multithreading.tasks.task5.entities.AbstractIdentifiableObject;

public interface CrudController<T extends AbstractIdentifiableObject> {
  void create(T object);

  T read(Long id);

  List<T> readAll();

  Boolean update(Long id, T object);

  Boolean delete(Long id);
}
