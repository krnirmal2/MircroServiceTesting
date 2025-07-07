package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class TempdirTestDemo {

    @TempDir Path fileDir;// it is help to file handling read and write and open and close
    @Test
    void testcase1(/*@TempDir Path fileDir*/) throws IOException {

        Path file = fileDir.resolve("abc.txt");

        String description  = "this is green learner youtube channel";
        Files.write(file, description.getBytes());

        List<String> actualData = Files.readAllLines(file);
        List<String> expected = Collections.singletonList(description);

        Assertions.assertEquals(expected, actualData);

    }
    //    Own annotation method Juit
    @FastTest
    void testcase2(/*@TempDir Path fileDir*/) throws IOException {

        Path file = fileDir.resolve("abc.txt");
        String description  = "this is green learner youtube channel";
        Files.write(file, description.getBytes());
        List<String> actualData = Files.readAllLines(file);
        List<String> expected = Collections.singletonList(description);
        Assertions.assertEquals(expected, actualData);

    }
}
