package com.epam.cdp.m2.hw2.aggregator;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

public class Java7Aggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        if (words.isEmpty()) return emptyList();
        List<Pair<String, Long>> wordList = new ArrayList<>();
        Collections.sort(words);
        long cnt = 1L;
        String currentWord = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            String word = words.get(i);
            if (word.equals(currentWord)) {
                cnt++;
            } else {
                wordList.add(new Pair<>(currentWord, cnt));
                cnt = 1L;
                currentWord = word;
            }
        }
        wordList.add(new Pair<>(currentWord, cnt));
        Collections.sort(wordList, new Comparator<Pair<String, Long>>() {
            @Override
            public int compare(Pair<String, Long> o1, Pair<String, Long> o2) {
                return (int) (o2.getValue() - o1.getValue());
            }
        });
        return wordList;
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        List<String> uppercase = new ArrayList<>();
        for (String word : words) {
            uppercase.add(word.toUpperCase());
        }
        List<Pair<String, Long>> wordList = getMostFrequentWords(uppercase, limit);
        List<String> result = new ArrayList<>();
        for (Pair<String, Long> pair : wordList) {
            if (pair.getValue() > 1) {
                result.add(pair.getKey());
            }
        }
        Collections.sort(result);
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return result;
    }
}
