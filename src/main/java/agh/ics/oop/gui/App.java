package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {
    private AbstractWorldMap map;

    @Override
    public void init() throws Exception {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {

        int minX = map.getLeftBorder().x;
        int minY = map.getLeftBorder().y;
        int maxX = map.getRightBorder().x;
        int maxY = map.getRightBorder().y;
        int width = 30;
        int height = 30;

        GridPane gridPane = new GridPane();
        Label labelyx = new Label("y/x");
        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));
        GridPane.setHalignment(labelyx, HPos.CENTER);
        gridPane.add(labelyx, 0, 0);

        for (int i = 1; i <= maxX - minX + 1; i++) {
            Label label = new Label(Integer.toString(minX + i - 1));
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, i, 0);
        }

        for (int i = 1; i <= maxY - minY + 1; i++) {
            Label label = new Label(Integer.toString(maxY - i + 1));
            gridPane.getRowConstraints().add(new RowConstraints(height));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, 0, i);
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Vector2d position = new Vector2d(x, y);
                if (map.isOccupied(position)) {
                    Object objectOnMap = map.objectAt(position);
                    Label label = new Label(objectOnMap.toString());
                    gridPane.add(label, position.x - minX + 1, maxY - position.y + 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}