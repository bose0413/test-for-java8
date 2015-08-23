package com.codingtask.service;

import com.codingtask.constant.Constants;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 22.08.2015.
 */
public class WordInfo {
    public static long getNumberOfVowels(String word) {
        return word.toLowerCase().chars()
                .filter(ch -> Constants.VOWELS_LIST.contains((char) ch))
                .count();
    }

    public static Set<Character> getOrderedSetOfVowels(String word) {
        Supplier<TreeSet<Character>> orderdVowels = () -> new TreeSet<>();
        return word.toLowerCase().chars()
                .filter(ch -> Constants.VOWELS_LIST.contains((char) ch))
                .distinct()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toCollection(orderdVowels));
    }


}
