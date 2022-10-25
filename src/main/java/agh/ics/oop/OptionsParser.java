package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static Object[] parse(String[] directions){
        List<MoveDirection> Moves = new ArrayList<>();
        for (String direction : directions) {
            switch (direction){
                case "f", "forward" -> Moves.add(MoveDirection.FORWARD);
                case "b", "backward" -> Moves.add(MoveDirection.BACKWARD);
                case "r", "right" -> Moves.add(MoveDirection.RIGHT);
                case "l", "left" -> Moves.add(MoveDirection.LEFT);
            }
        }
        return Moves.toArray();
    }
}

