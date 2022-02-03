package com.lerkin.common;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtil {

    public static void writeFile(File file, String note, boolean append) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            if (append) {
                fileWriter.write("\n" + note);
            } else {
                fileWriter.write(note);
            }
        } finally {
            IOUtil.closeOrThrowRunnable(fileWriter);
        }
    }

    public static void writeFile(String path, String note, boolean append) throws IOException {
        File file = createIfNotExists(path);
        writeFile(file, note, append);
    }

    public static String readFile(File file) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars;
            while (fileReader.read(chars = new char[1024]) != -1) {
                stringBuilder.append(chars);
            }
            String fileContent = stringBuilder.toString();
            return fileContent;
        } finally {
            IOUtil.closeOrThrowRunnable(fileReader);
        }
    }

    public static void readFile(String path) throws IOException {
        File file = new File(path);
        readFile(file);
    }

    public static File createIfNotExists(String path) throws IOException {
        File file = new File(path);
        return createIfNotExists(file);
    }

    public static File createIfNotExists(File file) throws IOException {
        createParentDirs(file);
        file.createNewFile();
        return file;
    }

    public static void createNonexistentDirectories(File file) {
        if (file.isFile()) {
            createParentDirs(file);
        } else {
            file.mkdirs();
        }
    }

    public static void createParentDirs(File file) {
        File parent = file.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
    }

    public static void createNonexistentDirectories(String path) {
        File file = new File(path);
        createNonexistentDirectories(file);
    }

    public static String getFileName(String path) {
        int i = path.lastIndexOf('\\');
        if (i <= 0) {
            i = path.lastIndexOf('/');
        }
        String fileName = path.substring(i + 1);
        return fileName;
    }

    public static String getFileName(File file) {
        String path = file.getPath();
        String fileName = getFileName(path);
        return fileName;
    }
}
