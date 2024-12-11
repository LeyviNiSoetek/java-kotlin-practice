package org.example.abstracts;

import java.io.Closeable;

public class MultiplePossibleParameters {
    public interface MethodWithoutParameter {
        public void method();
    }
    public interface AnotherMethodWithoutParameter {
        public void method();
    }
    public interface MethodWithParameter {
        public void method(int placeHolder);
    }
    public static void method1(MethodWithoutParameter hasMethod) {}

    public static void method2(MethodWithoutParameter hasMethod) {}
    public static void method2(MethodWithParameter hasMethod) {}

    public static void method3(MethodWithoutParameter hasMethod) {}
    public static void method3(AnotherMethodWithoutParameter hasMethod) {}
    public static void method3(MethodWithParameter hasMethod) {}

    public static void main(String[] args) {
        MultiplePossibleParameters.method1(() -> {});

        MultiplePossibleParameters.method2(() -> {});
        MultiplePossibleParameters.method2((placeHolder) -> {});

        // NOTE: compiling error: reference to method3 is ambiguous
        //MultiplePossibleParameters.method3(() -> {});
        MultiplePossibleParameters.method3((placeHolder) -> {});
    }
}
