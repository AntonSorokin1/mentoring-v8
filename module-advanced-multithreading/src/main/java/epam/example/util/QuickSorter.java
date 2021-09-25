package epam.example.util;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class QuickSorter extends RecursiveTask<List<Integer>> {

  private final int minIndex;
  private final int maxIndex;
  private final Integer[] array;

  public QuickSorter(Integer[] array) {
    this.array = array;
    this.minIndex = 0;
    this.maxIndex = array.length - 1;
  }

  public QuickSorter(Integer[] array, int minIndex, int maxIndex) {
    this.array = array;
    this.minIndex = minIndex;
    this.maxIndex = maxIndex;
  }

  @Override
  protected List<Integer> compute() {
    if (array.length == 0) {
      return emptyList();
    }
    if (minIndex < maxIndex) {
      int middleIndex = minIndex + (maxIndex - minIndex) / 2;
      int middleValue = array[middleIndex];
      int leftIndex = minIndex;
      int rightIndex = maxIndex;
      while (leftIndex <= rightIndex) {
        while (array[leftIndex] < middleValue) {
          leftIndex++;
        }
        while (array[rightIndex] > middleValue) {
          rightIndex--;
        }
        if (leftIndex <= rightIndex) {
          int temp = array[leftIndex];
          array[leftIndex] = array[rightIndex];
          array[rightIndex] = temp;
          leftIndex++;
          rightIndex--;
        }
      }
      if (minIndex < rightIndex) {
        QuickSorter left = new QuickSorter(array, minIndex, rightIndex);
        left.fork();
        left.join();
      }
      if (maxIndex > leftIndex) {
        QuickSorter right = new QuickSorter(array, leftIndex, maxIndex);
        right.compute();
      }
    }
    return asList(array);
  }
}
