package epam.example;

import static java.util.Arrays.asList;

import epam.example.task.impl.Task1;
import epam.example.task.impl.Task2;
import epam.example.task.impl.Task3;

public class Main {

  public static void main(String[] args) {
    asList(
        new Task1(),
        new Task2(),
        new Task3())
        .get(2).start();
  }
}
