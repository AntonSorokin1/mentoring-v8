package com.epam.cdp.m2.hw2.aggregator.recursive;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumCounter extends RecursiveTask<Integer> {

  private final Integer leftIndex;
  private final Integer rightIndex;
  private final List<Integer> integerList;

  public SumCounter(List<Integer> integerList) {
    this.integerList = integerList;
    this.leftIndex = 0;
    this.rightIndex = integerList.size() - 1;
  }

  public SumCounter(List<Integer> integerList, Integer leftIndex, Integer rightIndex) {
    this.leftIndex = leftIndex;
    this.rightIndex = rightIndex;
    this.integerList = integerList;
  }

  @Override
  protected Integer compute() {
    if (integerList.isEmpty()) {
      return 0;
    } else if (rightIndex.equals(leftIndex)) {
      return integerList.get(rightIndex);
    } else if (rightIndex - leftIndex <= 1) {
      return integerList.get(leftIndex) + integerList.get(rightIndex);
    } else {
      int middleIndex = (leftIndex + rightIndex) / 2;
      SumCounter leftCounter = new SumCounter(integerList, leftIndex, middleIndex);
      SumCounter rightCounter = new SumCounter(integerList, middleIndex + 1, rightIndex);
      leftCounter.fork();
      return rightCounter.compute() + leftCounter.join();
    }
  }
}
