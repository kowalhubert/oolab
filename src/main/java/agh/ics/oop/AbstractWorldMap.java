package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    private final MapVisualiser mapVisualizer = new MapVisualiser(this);
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary();

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            mapBoundary.addPosition(animal.getPosition());
            animal.addObserver(this);
            animal.addObserver(mapBoundary);
            return true;
        }
        else {
            throw new IllegalArgumentException(animal.getPosition() + " is occupied");
        }
    }

    public Map<Vector2d, Animal> getAnimals(){
        return animals;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }

    public abstract Vector2d getLeftBorder();
    public abstract Vector2d getRightBorder();
    @Override
    public String toString(){
        return this.mapVisualizer.draw(getLeftBorder(), getRightBorder());
    }
}