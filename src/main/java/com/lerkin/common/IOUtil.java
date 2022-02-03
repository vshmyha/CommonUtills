package com.lerkin.common;

import java.io.Closeable;
import java.io.IOException;

public class IOUtil {
    public static void closeOrThrowRunnable(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }
}
