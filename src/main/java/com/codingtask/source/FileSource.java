package com.codingtask.source;

import com.codingtask.constant.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;

/**
 * Created by Bohdan on 20.08.2015.
 */
public class FileSource implements SourceInterface {
    /* Mutable instance variable */
    private final File sourceFile;
    private final Logger logger = Logger.getLogger(FileSource.class);

    public FileSource(String path) throws FileNotFoundException {
        this.sourceFile = new File(path);
        if(!sourceFile.exists() || !sourceFile.isFile()) {
            throw new FileNotFoundException("Wrong path to the file: " + path);
        }
    }

    public File getSourceFile() {
        return sourceFile;
    }

    @Override
    public List<String> getWords() throws IOException {
        if (sourceFile.length() == 0 ){
            return Collections.EMPTY_LIST;
        }
        try (Stream<String> stream = Files.lines(Paths.get(sourceFile.toURI()), Charset.defaultCharset())) {
            return stream.flatMap(line -> Stream.of(line.split(Constants.WORD_SPLIT)))
                    .filter( word -> word.length() > 0 )
                    .collect( Collectors.toList() );
        }
    }

    public List<String> getLowerCaseWords() throws IOException {
        return getWords().parallelStream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
