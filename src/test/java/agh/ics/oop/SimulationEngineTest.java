package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    public void givenTest() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 0)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
    }

    @Test
    public void samePlace() {
        String[] args = {"r", "l", "f", "l", "r", "f", "f", "r", "r", "f", "b"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(4, 3);
        Vector2d[] positions = {new Vector2d(1, 2), new Vector2d(3, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 1)));
        assertTrue(map.isOccupied(new Vector2d(3, 1)));
    }

    @Test
    public void outOfMap() {
        String[] args = {"l", "r", "f", "f", "f", "b", "l", "l", "f", "f", "b", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(5, 6);
        Vector2d[] positions = {new Vector2d(2, 5), new Vector2d(4, 1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0, 5)));
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
    }
}