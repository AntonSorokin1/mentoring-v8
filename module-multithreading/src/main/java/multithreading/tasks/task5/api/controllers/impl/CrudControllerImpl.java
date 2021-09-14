package multithreading.tasks.task5.api.controllers.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import multithreading.tasks.task5.api.controllers.CrudController;
import multithreading.tasks.task5.api.services.CrudService;
import multithreading.tasks.task5.entities.AbstractIdentifiableObject;

@RequiredArgsConstructor
public class CrudControllerImpl<T extends AbstractIdentifiableObject, S extends CrudService<T>>
    implements CrudController<T> {

  protected final S service;

  @Override
  public void create(T object) {
    service.create(object);
  }

  @Override
  public T read(Long id) {
    return service.read(id);
  }

  @Override
  public List<T> readAll() {
    return service.readAll();
  }

  @Override
  public Boolean update(Long id, T object) {
    return service.update(id, object);
  }

  @Override
  public Boolean delete(Long id) {
    return service.delete(id);
  }
}
