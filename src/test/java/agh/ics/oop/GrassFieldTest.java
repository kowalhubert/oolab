package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {


    private final GrassField field = new GrassField(10);
    private final Vector2d vec1 = new Vector2d(2, 4);
    private final Vector2d vec2 = new Vector2d(3, 6);
    private final Animal zbigniewTheFrog = new Animal(field, vec1);
    private final Animal rafalTheHorse = new Animal(field, vec2);
    private final Animal peppaThePig = new Animal(field, vec2);

    @Test
    public void IWorldMapTest() {
        assertTrue(field.place(zbigniewTheFrog));
        assertTrue(field.place(rafalTheHorse));
        assertEquals(field.objectAt(vec2), rafalTheHorse);
        assertFalse(field.canMoveTo(zbigniewTheFrog.getPosition()));
        assertTrue(field.isOccupied(vec2));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> field.place(peppaThePig));
    }
}