package Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void count() {
        List<Integer> ex1 = Arrays.asList(3, 2, 1, 3, 1, 1, 2, 1, 2);
        List<Integer> ex2 = Arrays.asList(3, 3, 1, 2, 4, 1, 2);
        List<Integer> ex3 = Arrays.asList(4, 4, 1, 2, 1, 3, 3);
        List<Integer> ex4 = Arrays.asList(5, 1, 6, 9, 8, 1);
        List<Integer> ex5 = Arrays.asList(1, 5, 3, 2, 0, 1);
        List<Integer> ex6 = new ArrayList<>();
        List<Integer> ex7 = Arrays.asList(2,0,2,1,0,1,2,0,2);

        assertEquals(6, Main.count(ex1));
        assertEquals(4, Main.count(ex2));
        assertEquals(5, Main.count(ex3));
        assertEquals(4, Main.count(ex4));
        assertEquals(1, Main.count(ex5));
        assertEquals(0, Main.count(ex6));
        assertEquals(5, Main.count(ex7));

    }
}