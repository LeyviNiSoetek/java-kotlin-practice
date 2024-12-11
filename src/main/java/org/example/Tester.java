package org.example;

public class Tester {
    public static void main(String[] args) {
//        hashCodes();
    }

    private static void hashCodes() {
        Integer i1 = -1147759404;
        Integer i2 = -1147759404;
        String s1 = "test5678";
        System.out.println(i1.hashCode());
        System.out.println(i2.hashCode());
        System.out.println(s1.hashCode());

        System.out.println(i1 == i2);
        System.out.println(i1.equals(i1));

        System.out.println(i1.hashCode() == s1.hashCode());
        System.out.println(i1.equals(s1));
    }
}
