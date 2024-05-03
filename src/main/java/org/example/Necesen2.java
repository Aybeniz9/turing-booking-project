package org.example;

import java.io.IOException;

public class Necesen2 {
    static int a = 5;


    public static void main(String[] args) {
        try {
            getAgain("aa");
        } catch (Exception e) {
            System.out.println("aaa");
        }
    }

    public static void getAgain(String file) throws IOException {
        Main.getFile("Hello");
    }
}
