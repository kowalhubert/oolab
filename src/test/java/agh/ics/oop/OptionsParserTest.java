package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void correctOnly() {
        String[] moves = {"f","right","backward","b","left"};
        MoveDirection[] actualMoves = new OptionsParser().parse(moves);
        MoveDirection[] correctDirections = {MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.LEFT};
        assertArrayEquals(actualMoves, correctDirections);
    }

    @Test
    void someIncorrect(){
        String[] moves = {"baaaward", "f", "left", "forward", "h"};
        Assertions.assertThrows(IllegalArgumentException.class, ()->new OptionsParser().parse(moves));
    }
}