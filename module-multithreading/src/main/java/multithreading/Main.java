package multithreading;

import static java.util.Arrays.asList;

import java.util.List;
import multithreading.tasks.Task;
import multithreading.tasks.task1.Task1;
import multithreading.tasks.task2.Task2;
import multithreading.tasks.task3.Task3;
import multithreading.tasks.task4.Task4;
import multithreading.tasks.task5.Task5;

public class Main {
  public static void main(String[] args) {
    List<Task> tasks = asList(
        new Task1(),
        new Task2(),
        new Task3(),
        new Task4(),
        new Task5()
    );
    tasks.get(4).runTask();
  }
}
