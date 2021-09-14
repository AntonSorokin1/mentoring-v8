package multithreading.tasks.task5.api.repositories.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import multithreading.tasks.task5.api.repositories.CrudRepository;
import multithreading.tasks.task5.entities.AbstractIdentifiableObject;

public class CrudRepositoryImpl<T extends AbstractIdentifiableObject> implements CrudRepository<T> {

  protected final Map<Long, T> objects = new HashMap<>();
  protected Long generatedId = 0L;

  @Override
  public void create(T object) {
    objects.computeIfAbsent(generatedId, k -> {
      object.setId(k);
      objects.put(k, object);
      generatedId++;
      return object;
    });
  }

  @Override
  public T read(Long id) {
    return objects.getOrDefault(id, null);
  }

  @Override
  public List<T> readAll() {
    return new ArrayList<>(objects.values());
  }

  @Override
  public boolean update(Long id, T object) {
    return objects.computeIfPresent(id, (k, v) -> v = object) != null;
  }

  @Override
  public boolean delete(Long id) {
    return objects.computeIfPresent(id, (k, v) -> objects.remove(k)) != null;
  }
}
