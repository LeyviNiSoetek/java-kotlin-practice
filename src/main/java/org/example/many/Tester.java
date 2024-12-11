package org.example.many;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
//        sets();
        maps();
    }

    private static void maps() {
        Map<String, String> stocks = new HashMap<>();
        stocks.put("2330", "台積電");
        stocks.put("2317", "鴻海");
        System.out.println(stocks);
        stocks.put("2330", "TSMC");
        System.out.println(stocks);
        System.out.println();

        for (String key : stocks.keySet()) {
            System.out.println(stocks.get(key));
        }
        System.out.println();

        System.out.println(stocks.get("2330"));
        System.out.println(stocks.get("23300"));
    }

    static public void sets() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(3);
        set1.add(0);
        System.out.println(set1);
        set1.add(0);
        System.out.println(set1);

        // Collections.iterator is called, maybe?
        for (int i: set1) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println(set1.contains(3));
        System.out.println(set1.contains(4));
    }
}
