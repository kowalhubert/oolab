package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void precedesTest() {
        assertFalse(new Vector2d(2, 3).precedes(new Vector2d(2, 2)));
        assertFalse(new Vector2d(5, 5).precedes(new Vector2d(3, 4)));
        assertTrue(new Vector2d(5, 6).precedes(new Vector2d(6, 6)));
        assertTrue(new Vector2d(2, 6).precedes(new Vector2d(4, 6)));
    }

    @Test
    void followsTest() {
        assertFalse(new Vector2d(4, 3).follows(new Vector2d(5, 8)));
        assertFalse(new Vector2d(8, 2).follows(new Vector2d(9, 3)));
        assertTrue(new Vector2d(3, 6).follows(new Vector2d(3, 6)));
        assertTrue(new Vector2d(4, 9).follows(new Vector2d(2, 2)));
    }

    @Test
    public void upperRightTest() {
        assertEquals(new Vector2d(2, 6).upperRight(new Vector2d(4, 6)), new Vector2d(4, 6));
        assertEquals(new Vector2d(3, 7).upperRight(new Vector2d(2, 9)), new Vector2d(3, 9));
        assertNotEquals(new Vector2d(2, 3).upperRight(new Vector2d(9, 6)), new Vector2d(4, 6));
        assertNotEquals(new Vector2d(4, -5).upperRight(new Vector2d(-3, 6)), new Vector2d(4, 2));

    }

    @Test
    public void lowerLeftTest() {
        assertEquals(new Vector2d(5, 6).lowerLeft(new Vector2d(7, 6)), new Vector2d(5, 6));
        assertEquals(new Vector2d(3, 6).lowerLeft(new Vector2d(2, 5)), new Vector2d(2, 5));
        assertNotEquals(new Vector2d(1, 3).lowerLeft(new Vector2d(-3, 6)), new Vector2d(9, 3));
        assertNotEquals(new Vector2d(4, -5).lowerLeft(new Vector2d(-3, 0)), new Vector2d(-3, 5));
    }

    @Test
    public void addTest() {
        assertEquals(new Vector2d(1, 6).add(new Vector2d(8, 2)), new Vector2d(9, 8));
        assertEquals(new Vector2d(5, 4).add(new Vector2d(7, -3)), new Vector2d(12, 1));
        assertNotEquals(new Vector2d(3, 9).add(new Vector2d(1, 6)), new Vector2d(8, 6));
        assertNotEquals(new Vector2d(6, 7).add(new Vector2d(7, -4)), new Vector2d(5, 7));
    }

    @Test
    public void subtractTest() {
        assertEquals(new Vector2d(1, 6).subtract(new Vector2d(0, 2)), new Vector2d(1, 4));
        assertEquals(new Vector2d(4, 4).subtract(new Vector2d(7, -3)), new Vector2d(-3, 7));
        assertNotEquals(new Vector2d(1, 9).subtract(new Vector2d(4, 6)), new Vector2d(3, 6));
        assertNotEquals(new Vector2d(6, 8).subtract(new Vector2d(7, -4)), new Vector2d(5, 3));
    }

    @Test
    public void equalsTest() {
        assertEquals(new Vector2d(5, 6), new Vector2d(5, 6));
        assertEquals(new Vector2d(4, 1), new Vector2d(4, 1));
        assertNotEquals(new Vector2d(6, 6), new Vector2d(7, 6));
        assertNotEquals(new Vector2d(2, 6), new Vector2d(4, 9));
    }

    @Test
    public void oppositeTest() {
        assertEquals(new Vector2d(2, 6).opposite(), new Vector2d(-2, -6));
        assertEquals(new Vector2d(3, 7).opposite(), new Vector2d(-3, -7));
        assertNotEquals(new Vector2d(2, 3).opposite(), new Vector2d(2, -3));
        assertNotEquals(new Vector2d(4, -5).opposite(), new Vector2d(3, 2));

    }
}