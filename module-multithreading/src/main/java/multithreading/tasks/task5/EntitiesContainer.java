package multithreading.tasks.task5;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import multithreading.tasks.task5.initializers.ApiInitializer;
import multithreading.tasks.task5.initializers.impl.ControllerApiInitializer;
import multithreading.tasks.task5.initializers.impl.RepositoryApiInitializer;
import multithreading.tasks.task5.initializers.impl.ServiceApiInitializer;

public final class EntitiesContainer {

  private static volatile EntitiesContainer instance;

  private final Map<Class<?>, Object> entityMap = new HashMap<>();

  public static EntitiesContainer getInstance() {
    EntitiesContainer localInstance = instance;
    if (localInstance == null) {
      synchronized (EntitiesContainer.class) {
        localInstance = instance;
        if (localInstance == null) {
          instance = localInstance = new EntitiesContainer();
        }
      }
    }
    return localInstance;
  }

  private EntitiesContainer() {
  }

  public void init() {
    List<ApiInitializer> apiInitializers = asList(
        new RepositoryApiInitializer(),
        new ServiceApiInitializer(),
        new ControllerApiInitializer()
    );
    apiInitializers.forEach(i -> entityMap.putAll(i.init()));
  }

  public <T> T get(Class<T> clazz) {
    return (T) entityMap.getOrDefault(clazz, null);
  }
}
