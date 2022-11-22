package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{

    private final IWorldMap map;
    private MapDirection direction;
    private Vector2d position;
    private final List<IPositionChangeObserver> observerList = new ArrayList<IPositionChangeObserver>();

    public Animal(IWorldMap map) {
        this.map = map;
        this.direction = MapDirection.NORTH;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
        addObserver((IPositionChangeObserver) map);
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
        Vector2d newPosition = position;
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> newPosition = position.add(directionVector);
            case BACKWARD -> newPosition = position.subtract(directionVector);
        }
        if (map.canMoveTo(newPosition)){
            positionChanged(position, newPosition);
            this.position = newPosition;
        }
    }

    void addObserver(IPositionChangeObserver observer){
        observerList.add(observer);
    }
    
    void removeObserver(IPositionChangeObserver observer){
        observerList.remove(observer);
    }
    
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observerList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}