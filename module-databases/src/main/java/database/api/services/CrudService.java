package database.api.services;

import database.entities.AbstractIdentifiableObject;
import java.util.List;

public interface CrudService<T extends AbstractIdentifiableObject> {

  T create(T object);

  T read(Long id);

  List<T> readAll();

  Boolean update(T object, Long id);

  Boolean delete(Long id);
}
