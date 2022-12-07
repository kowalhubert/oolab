package agh.ics.oop;

import agh.ics.oop.gui.App;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {

    private final IWorldMap map;
    private MoveDirection[] directions;
    private final List<Animal> animalsList;
    private final Vector2d[] initialPosition;
    private int moveDelay;
    private App app;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialPosition) {
        this.map = map;
        this.directions = directions;
        this.initialPosition = initialPosition;
        this.animalsList = new ArrayList<Animal>();
        addAnimal();
    }

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialPosition, int moveDelay, App app){
        this(directions, map, initialPosition);
        this.moveDelay = moveDelay;
        this.app = app;
    }

    public void addAnimal() {
        for (Vector2d position : initialPosition) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                animalsList.add(animal);
            }
        }
    }

    public void setDirections(MoveDirection[] directions) { this.directions = directions; }

    @Override
    public void run() {
        try{
            Thread.sleep(moveDelay);
            for (int i = 0; i < directions.length; i++) {
                animalsList.get(i % animalsList.size()).move(directions[i]);
                app.setScene();
                Thread.sleep(moveDelay);
            }
        } catch (InterruptedException exeption) {
            exeption.printStackTrace();
        }
    }
}