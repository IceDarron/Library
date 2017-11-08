package com.iceDarron.test;

import java.util.HashMap;
import java.util.Map;

public class T1 {

    static int i = 0;
    int j = 0;

    public static void  main(String[] args) {

        System.out.println("1");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2");
        for (int i = 0; i <999999999; i++) {
            a();
        }
        System.out.println("3");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4");
        System.gc();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5");
    }


    public static Map a() {
        i = i + 1;
        Map map = new HashMap();
        return map;
    }
}
