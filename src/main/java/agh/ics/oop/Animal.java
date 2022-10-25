package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d position;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    @Override
    public String toString() {
        return (this.direction + ", " + this.position);
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public MapDirection getDirection(){return this.direction;}
    public Vector2d getPosition(){return this.position;}


    public void move(MoveDirection direction){
        Vector2d directionVector = this.direction.toUnitVector();
            switch (direction) {
                case RIGHT -> this.direction = this.direction.next();
                case LEFT -> this.direction = this.direction.previous();
                default -> {
                    if (direction == MoveDirection.BACKWARD) {
                        directionVector = directionVector.opposite();
                    }
                    Vector2d temporaryDirection = this.position.add(directionVector);
                    if (temporaryDirection.precedes(new Vector2d(4, 4)) && temporaryDirection.follows(new Vector2d(0, 0))){
                        this.position = temporaryDirection;
                    }
                }
            }
    }

}