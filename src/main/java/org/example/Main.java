package org.example;

import java.util.HashMap;
import java.util.Map;
/*
* Basically, it's a class-level hierarchy. I have written a program that will allow you to create only two objects in each class; it will not allow more than two.
*/
public class Main {
    public static void main(String[] args) {
        new C();
        new A(); // [class Cc, class Aa]
        new B(); // [class Bb, class Cc, class Aa]
        new B();

    }
}


class A {
    private static Map<Class,Integer> map = new HashMap<>();

    static void validateAndAdd(Class c) {
        System.out.println(map.get(c));
        if (map.getOrDefault(c,0)>=2) {
            throw new IllegalStateException("...");
        }
        map.put(c, map.getOrDefault(c,0)+1);
        System.out.println(map);
    }

    public A() {
        validateAndAdd(getClass());
    }
}

class B extends A {
}

class C extends B {
}
