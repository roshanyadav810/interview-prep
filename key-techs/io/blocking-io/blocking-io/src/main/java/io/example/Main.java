package io.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("key-techs/io/blocking-io/blocking-io/src/main/resources/test.txt");
        InputStream in = new FileInputStream(file);
        int c = -1;
        while((c = in.read()) != -1){
            System.out.print((char)c);
        }

        System.out.println("\n----- Read from Memory ------");

        byte[] bytes = {'h','i'};
        InputStream inMemory = new ByteArrayInputStream(bytes);
        c = -1;
        while((c = inMemory.read()) != -1){
            System.out.print((char)c);
        }


    }
}