package com.codingtask.constant;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bohdan on 20.08.2015.
 */
public interface Constants {
    final String WORD_SPLIT = "[,\\s:\\?\\.\\!(\\s\\-\\s)]";
    final List<Character> VOWELS_LIST = new LinkedList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
}
