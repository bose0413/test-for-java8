package com.codingtask.source;

import java.io.IOException;
import java.util.List;

/**
 * Created by Bohdan on 20.08.2015.
 */
public interface SourceInterface {
    List<String> getWords() throws IOException;
}
