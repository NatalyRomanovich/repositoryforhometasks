package by.nat.homework3.util;

import java.util.List;
import java.util.Set;

public class OutputOnDisplay {


    //<T> - the type of elements in this collection, T extends Object;

    public static <T> void showObject(List<T> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " " + list.get(i));
        }
    }

    public static <T> void showObject(Set<T> set) {
        for (T object : set) {
            System.out.println(object);
        }
    }
}
