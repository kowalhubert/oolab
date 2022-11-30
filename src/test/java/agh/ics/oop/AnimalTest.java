package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void placeTest(){
        RectangularMap field = new RectangularMap(10, 10);
        Animal zbigniewTheFrog = new Animal(field, new Vector2d(3, 8));
        Animal peppaThePig = new Animal(field, new Vector2d(3, 8));
        field.place(zbigniewTheFrog);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {field.place(peppaThePig);});
        assertEquals(new Vector2d(3, 8) + " is occupied", exception.getMessage());
    }
}