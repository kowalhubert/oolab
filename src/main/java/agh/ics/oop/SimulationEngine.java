package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    private final IWorldMap map;
    private final MoveDirection[] directions;
    private final List<Animal> animalsList;
    private final Vector2d[] initialPosition;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialPosition) {
        this.map = map;
        this.directions = directions;
        this.initialPosition = initialPosition;
        this.animalsList = new ArrayList<Animal>();
        addAnimal();
    }

    public void addAnimal() {
        for (Vector2d position : initialPosition) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                animalsList.add(animal);
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < directions.length; i++) {
            animalsList.get(i % animalsList.size()).move(directions[i]);
            System.out.println(map);
        }
    }
}