package com.github.yurysauchuk;

import org.junit.jupiter.api.Test;

public class RecordTest {

    record Point(int x, int y) {}

    @Test
    void test() {
        Point p1 = new Point(10, 20);
        System.out.println(p1.x());
        System.out.println(p1.y());

        Point p2 = new Point(11, 22);
        System.out.println(p2.x());
        System.out.println(p2.y());

        Point p3 = new Point(10, 20);
        System.out.println(p1.x());
        System.out.println(p1.y());

        System.out.println(p1);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p2.equals(p3));

    }
}
