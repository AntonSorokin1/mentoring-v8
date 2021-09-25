package epam.example.task.impl;

import static java.util.concurrent.ForkJoinPool.commonPool;

import epam.example.task.Task;
import epam.example.util.QuickSorter;
import java.util.concurrent.ForkJoinPool;

public class Task2 implements Task {

  private static final Integer[] ARRAY = {2, 3, 1, 4, 9, 5, 7, 6, 8};

  @Override
  public void start() {
    ForkJoinPool pool = commonPool();
    pool.invoke(new QuickSorter(ARRAY))
        .forEach(System.out::println);
  }
}
