package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    public void IWorldMapTest() {
        IWorldMap field = new RectangularMap(10, 10);
        Vector2d vec1 = new Vector2d(3, 2);
        Vector2d vec2 = new Vector2d(12, 2);
        Animal animal = new Animal(field, vec1);
        assertTrue(field.place(animal));
        assertEquals(field.objectAt(vec1), animal);
        assertFalse(field.canMoveTo(animal.getPosition()));
        assertFalse(field.canMoveTo(vec2));
        assertTrue(field.isOccupied(vec1));
    }
}