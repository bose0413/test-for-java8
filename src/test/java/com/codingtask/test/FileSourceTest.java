package com.codingtask.test;

import com.codingtask.source.FileSource;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan on 20.08.2015.
 */

public class FileSourceTest {



    @Test (expected = FileNotFoundException.class)
    public void testWrongFilePath() throws FileNotFoundException {
        FileSource f = new FileSource("ddd.ss");
    }

    @Test
    public void testGettingWords() throws IOException {
        List<String> expectedResults = new ArrayList<>();
        expectedResults.add("Platon");
        expectedResults.add("made");
        expectedResults.add("bamboo");
        expectedResults.add("boats");
        expectedResults.add("ddss");
        FileSource f = new FileSource(ClassLoader.getSystemResource("input.txt").getPath());
        assertEquals(expectedResults,f.getWords());
    }
}
