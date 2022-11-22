package agh.ics.oop;

import java.util.*;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class GrassField extends AbstractWorldMap{

    private final int bound;
    private final Map<Vector2d, Grass> grasses;
    private final List<Vector2d> possiblePlaces = new ArrayList<>();

    public GrassField(int grassNum){
        this.grasses = new HashMap<>();
        this.bound = (int) Math.sqrt(grassNum * 10);
        putGrassOnField(grassNum);
    }

    public void putGrassOnField(int grassNum) {
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                possiblePlaces.add(new Vector2d(i, j));
            }
        }
        Collections.shuffle(possiblePlaces);
        for(int i = 0; i < grassNum; i++){
            Vector2d grassPosition = possiblePlaces.get(i);
            Grass grass = new Grass(grassPosition);
            grasses.put(grassPosition, grass);
        }
    }

    protected Vector2d getLeftBorder(){
        Vector2d leftBorder = new Vector2d(MAX_VALUE, MAX_VALUE);
        for (Vector2d position: grasses.keySet()){
            leftBorder = leftBorder.lowerLeft(position);
        }
        for (Vector2d position: getAnimals().keySet()){
            leftBorder = leftBorder.lowerLeft(position);
        }
        return leftBorder;
    }

    protected Vector2d getRightBorder(){
        Vector2d rightBorder = new Vector2d(MIN_VALUE, MIN_VALUE);
        for (Vector2d position: grasses.keySet()){
            rightBorder = rightBorder.upperRight(position);
        }
        for (Vector2d position: getAnimals().keySet()){
            rightBorder = rightBorder.upperRight(position);
        }
        return rightBorder;
    }

    public Object objectAt(Vector2d position){
        Object animalPosition = super.objectAt(position);
        if (animalPosition == null){
            return grasses.get(position);
        }
        return animalPosition;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) || this.objectAt(position) instanceof Grass;
    }
}