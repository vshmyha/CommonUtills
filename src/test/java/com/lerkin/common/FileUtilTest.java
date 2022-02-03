package com.lerkin.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileUtilTest {
    @Test
    void createFileTest() throws IOException {
        File file = new File("test.txt");
        file.delete();
        FileUtil.createIfNotExists(file);
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.isFile());
    }
}
