package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest() {
        String[] example_moves = new String[]{"f","t","right","backwaard","b","left","forward"};
        MoveDirection[] actual_moves = new OptionsParser().parse(example_moves);
        MoveDirection[] correct_moves = new MoveDirection[]{MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.FORWARD};
        assertArrayEquals(correct_moves, actual_moves);
    }
}