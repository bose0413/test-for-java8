package com.codingtask.service;

import com.codingtask.source.SourceInterface;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 22.08.2015.
 */
public class VowelsService {
    private static final Logger logger = Logger.getLogger(VowelsService.class);

    /**
     * @param source list of words
     * @return a Map containing:
     * key - sorted set of vowels and number of letters in the word. For example, "Platon" -  ([a, o], 6)
     * value - the average number of vowels per word grouped by the key     *
     */
    public static Map<String, Float> getVowelsInformation(List<String> source) {

//        Map<String, Float> vowelsInfo = new HashMap<>();
//        source.parallelStream()
//                .filter(word -> WordInfo.getNumberOfVowels(word) > 0)
//                .forEach(word ->
//                        vowelsInfo.merge(format(WordInfo.getOrderedSetOfVowels(word).toString(), word.length())
//                                , (float) WordInfo.getNumberOfVowels(word)
//                                , (value, newValue) -> (value + newValue) / 2));
        return source.stream()
                .filter(word -> WordInfo.getNumberOfVowels(word) > 0)
                .collect(Collectors.toMap(
                        word -> format(WordInfo.getOrderedSetOfVowels(word).toString(), word.length()), // key
                        word -> (float) WordInfo.getNumberOfVowels(word),                               // value
                        (coef1, coef2) -> (coef1 + coef2) / 2                                           // if key is duplicated
                ));
        //return vowelsInfo;
    }

    private static String format(String setOfVowels, long numOfVowels) {
        return "(" + setOfVowels + ", " + numOfVowels + ")";
    }

}
