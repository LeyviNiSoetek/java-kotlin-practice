package org.example.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class InputTester {
    static final File existingFile = new File("test-io-in.txt");
    static final File nonexistingFile = new File("non-existing.txt");
    public static void main(String[] args) {
        System.out.println("Charset.defaultCharset(): " + Charset.defaultCharset());
        System.out.println("System.out.charset(): " + System.out.charset());
        System.out.println("---------");
//        inputStreamPractice();
//        readerPractice();
//        bufferedReaderPractice();
    }

    private static void bufferedReaderPractice() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(existingFile));
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void inputStreamPractice() {
        File file =
                existingFile;
//                nonexistingFile;
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getTotalSpace());
        System.out.println(file.getFreeSpace());
        System.out.println(file.length());
        try {
            System.out.println(Files.size(file.toPath()));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            System.out.println("File opened successfully.");
            int byteRead = 0;
            try {
                while ((byteRead = inputStream.read()) != -1) {
                    System.out.println("byte read: " + byteRead + "; ASCII char: " + (char) byteRead);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (FileNotFoundException exception) { // NOTE: this is for FileInputStream constructor
            System.out.println("Failed to open file.");
            exception.printStackTrace();
        }
        finally {
            System.out.println("finally block");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void readerPractice() {
        try {
            Reader reader = new FileReader(
                    existingFile
//                    , StandardCharsets.UTF_8 // or: Charset.forName("UTF-8")
            );
            System.out.println("--- start of file ---");
            int charRead = 0;
            try {
                while ((charRead = reader.read()) != -1) {
                    System.out.print((char)charRead);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("\n--- end of file ---");
        }
    }
}
