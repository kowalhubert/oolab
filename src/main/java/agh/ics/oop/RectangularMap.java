package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d leftBorder;
    private final Vector2d rightBorder;

    public RectangularMap(int width, int height) {
        this.leftBorder = new Vector2d(0, 0);
        this.rightBorder = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(rightBorder) && position.follows(leftBorder) && !this.isOccupied(position);
    }

    protected Vector2d getRightBorder(){
        return rightBorder;
    }

    protected Vector2d getLeftBorder(){
        return leftBorder;
    }
}