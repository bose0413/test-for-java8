package com.codingtask.test;

import com.codingtask.service.VowelsService;
import com.codingtask.source.FileSource;
import com.codingtask.source.SourceInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bohdan on 22.08.2015.
 */
public class VowelsServiceTest {

    @Test
    public void testVowelsInfo() throws FileNotFoundException {
        List<String> source = new ArrayList<>(Arrays.asList("Platon", "made", "bamboo", "boats", "ddss"));
        String expectedResult = "{([a, o], 5)=2.0, ([a, o], 6)=2.5, ([a, e], 4)=2.0}";
        assertEquals(expectedResult, VowelsService.getVowelsInformation(source).toString());
    }
}
