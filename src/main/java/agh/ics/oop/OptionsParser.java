package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public MoveDirection[] parse(String[] directions) throws IllegalArgumentException{
        List<MoveDirection> moves = new ArrayList<>();
        for (String direction : directions) {
            switch (direction){
                case "f", "forward" -> moves.add(MoveDirection.FORWARD);
                case "b", "backward" -> moves.add(MoveDirection.BACKWARD);
                case "r", "right" -> moves.add(MoveDirection.RIGHT);
                case "l", "left" -> moves.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(direction + " is not legal move specification");
            }
        }
        return moves.toArray(new MoveDirection[0]);
    }
}