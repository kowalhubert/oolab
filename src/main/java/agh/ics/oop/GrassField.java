package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    private final int bound;
    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private final List<Vector2d> possiblePlaces = new ArrayList<>();

    public GrassField(int grassNum){
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
            mapBoundary.addPosition(grassPosition);
        }
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

    public Vector2d getLeftBorder(){
        return mapBoundary.getLowerleft();
    }

    public Vector2d getRightBorder(){
        return mapBoundary.getUpperRight();
    }
}