package com.epam.cdp.m2.hw2.aggregator;

import static java.lang.Runtime.getRuntime;
import static java.lang.Thread.currentThread;
import static java.util.Collections.sort;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.ForkJoinPool.commonPool;

import com.epam.cdp.m2.hw2.aggregator.recursive.SumCounter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import javafx.util.Pair;

public class Java7ParallelAggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        ForkJoinPool pool = commonPool();
        return pool.invoke(new SumCounter(numbers));
    }

    public Pair<String, Long> wordCount(String template, List<String> words) {
        long counter = 0L;
        for (String word : words) {
            if (word.equals(template)) {
                counter++;
            }
        }
        return new Pair<>(template, counter);
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        int numberOfThreads = getRuntime().availableProcessors();
        ExecutorService service = newFixedThreadPool(numberOfThreads);

        Set<String> uniqueWords = new HashSet<>(words);
        List<Future<Pair<String, Long>>> futures = new ArrayList<>();
        for (String word : uniqueWords) {
            Callable<Pair<String, Long>> converter = new Callable<Pair<String, Long>>() {
                @Override
                public Pair<String, Long> call() throws Exception {
                    return wordCount(word, words);
                }
            };
            futures.add(service.submit(converter));
        }

        List<Pair<String, Long>> result = new ArrayList<>();
        for (Future<Pair<String, Long>> future : futures) {
            try {
                result.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                currentThread().interrupt();
            }
        }

        return result;
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        int numberOfThreads = getRuntime().availableProcessors();
        ExecutorService service = newFixedThreadPool(numberOfThreads);

        List<String> uppercaseWords = new ArrayList<>();
        for (String word : words) {
            uppercaseWords.add(word.toUpperCase());
        }
        Set<String> uniqueWords = new HashSet<>(uppercaseWords);
        List<Future<Pair<String, Long>>> futures = new ArrayList<>();
        for (String word : uniqueWords) {
            Callable<Pair<String, Long>> converter = new Callable<Pair<String, Long>>() {
                @Override
                public Pair<String, Long> call() throws Exception {
                    return wordCount(word, uppercaseWords);
                }
            };
            futures.add(service.submit(converter));
        }

        List<String> result = new ArrayList<>();
        for (Future<Pair<String, Long>> future : futures) {
            try {
                Pair<String, Long> pair = future.get();
                if (pair.getValue() > 1) {
                    result.add(pair.getKey());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                currentThread().interrupt();
            }
        }
        sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return result;
    }
}
