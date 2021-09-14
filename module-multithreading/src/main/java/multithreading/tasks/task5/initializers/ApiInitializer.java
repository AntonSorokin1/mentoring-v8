package multithreading.tasks.task5.initializers;

import java.util.Map;

public interface ApiInitializer {
  Map<Class<?>, Object> init();
}
