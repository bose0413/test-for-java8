package com.codingtask.test;

import com.codingtask.service.WordInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Bohdan on 22.08.2015.
 */
public class WordInfoTest {

    @Test
    public void testNumberOfVowels(){
        String testString = "Aabcd";
        assertEquals(2 , WordInfo.getNumberOfVowels(testString));
    }

    @Test
    public void testSetOfVowels() {
        String test = "bybdsaasi";
        assertEquals("[a, i, y]",WordInfo.getOrderedSetOfVowels(test).toString());
    }

}
