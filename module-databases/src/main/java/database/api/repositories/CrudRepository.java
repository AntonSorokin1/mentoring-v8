package database.api.repositories;

import database.entities.AbstractIdentifiableObject;
import java.util.List;

public interface CrudRepository<T extends AbstractIdentifiableObject> {

  T create(T object);

  T read(Long id);

  List<T> readAll();

  Boolean update(T object, Long id);

  Boolean delete(Long id);
}
