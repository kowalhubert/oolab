package agh.ics.oop;

public class Animal {

    private final IWorldMap map;
    private MapDirection direction;
    private Vector2d position;

    public Animal(IWorldMap map) {
        this.map = map;
        this.direction = MapDirection.NORTH;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return switch (this.direction) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public void move(MoveDirection direction) {
        Vector2d directionVector = this.direction.toUnitVector();
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d forwardDirection = this.position.add(directionVector);
                if (this.map.canMoveTo(forwardDirection)) {
                    this.position = forwardDirection;
                }
            }
            case BACKWARD -> {
                Vector2d backwardDirection = this.position.add(directionVector.opposite());
                if (this.map.canMoveTo(backwardDirection)) {
                    this.position = backwardDirection;
                }
            }
        }
    }
}