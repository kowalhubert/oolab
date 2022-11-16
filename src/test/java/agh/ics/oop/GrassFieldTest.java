package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    public void IWorldMapTest() {
        GrassField field = new GrassField(10);
        Vector2d vec = new Vector2d(1, 1);
        Animal animal = new Animal(field, vec);
        assertTrue(field.place(animal));
        assertEquals(field.objectAt(vec), animal);
        assertFalse(field.canMoveTo(animal.getPosition()));
        assertTrue(field.isOccupied(vec));
    }
}