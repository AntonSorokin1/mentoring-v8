package epam.example.task.impl;

import static java.util.concurrent.ForkJoinPool.commonPool;

import epam.example.task.Task;
import epam.example.util.FactorialCounter;
import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

public class Task1 implements Task {

  private static final int VALUE = 10;

  @Override
  public void start() {
    ForkJoinPool pool = commonPool();
    BigInteger result = pool.invoke(new FactorialCounter(VALUE));
    System.out.printf("Factorial of %d = %s%n", VALUE, result.toString());
  }
}
