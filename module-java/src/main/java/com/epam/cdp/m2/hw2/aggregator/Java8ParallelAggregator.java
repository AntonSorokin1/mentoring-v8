package com.epam.cdp.m2.hw2.aggregator;

import static java.util.Comparator.comparingInt;
import static java.util.Map.Entry.comparingByKey;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map.Entry;
import javafx.util.Pair;

public class Java8ParallelAggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.parallelStream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        return words.parallelStream()
            .collect(groupingBy(identity(), counting()))
            .entrySet().parallelStream()
            .sorted(comparingByKey())
            .sorted((p1, p2) -> (int) (p2.getValue() - p1.getValue()))
            .map(e -> new Pair<>(e.getKey(), e.getValue()))
            .collect(toList());
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        return words.parallelStream()
            .map(String::toUpperCase)
            .collect(groupingBy(identity(), counting()))
            .entrySet().parallelStream()
            .filter(e -> e.getValue() > 1)
            .map(Entry::getKey)
            .sorted()
            .sorted(comparingInt(String::length))
            .collect(toList());
    }
}
