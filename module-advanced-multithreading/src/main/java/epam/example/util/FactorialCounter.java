package epam.example.util;

import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class FactorialCounter extends RecursiveTask<BigInteger> {

  private final Integer minValue;
  private final Integer maxValue;

  public FactorialCounter(Integer maxValue) {
    this.minValue = 1;
    this.maxValue = maxValue;
  }

  public FactorialCounter(Integer minValue, Integer maxValue) {
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  @Override
  public BigInteger compute() {
    if (maxValue - minValue <= 1) {
      BigInteger result = valueOf(1);
      for (int i = minValue; i <= maxValue; i++) {
        result = result.multiply(valueOf(i));
      }
      return result;
    } else {
      int middleValue = (minValue + maxValue) / 2;
      FactorialCounter left = new FactorialCounter(minValue, middleValue);
      FactorialCounter right = new FactorialCounter(middleValue + 1, maxValue);
      left.fork();
      return right.compute().multiply(left.join());
    }
  }
}
