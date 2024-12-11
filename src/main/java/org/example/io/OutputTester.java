package org.example.io;

import java.io.*;

public class OutputTester {
    public static void main(String[] args) throws IOException {
        writerPractice();
    }

    private static void writerPractice() throws IOException {
        File file = new File("test-io-out.txt");
        Writer writer = new FileWriter(file);
        writer.write("written by writer");
        // NOTE: only when `flush` being called would data be actually written.
        writer.flush();

        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("written by bufferedWriter");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        // NOTE: `close` will call `flush`.
        writer.close();
    }
}
