package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application implements IPositionChangeObserver {
    private AbstractWorldMap map;
    private GridPane gridPane = new GridPane();
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private final int width = 40;
    private final int height = 40;
    private SimulationEngine engine;

    @Override
    public void init() throws IllegalArgumentException {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            engine = new SimulationEngine(directions, map, positions, 300, this);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    public void drawScene(){
        minX = map.getLeftBorder().x;
        minY = map.getLeftBorder().y;
        maxX = map.getRightBorder().x;
        maxY = map.getRightBorder().y;

        Label labelyx = new Label("y/x");
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
                    GuiElementBox guiElementBox = new GuiElementBox((IMapElement) objectOnMap);
                    VBox vBox = guiElementBox.getVBox();
                    gridPane.add(vBox, position.x - minX + 1, maxY - position.y + 1);
                    GridPane.setHalignment(vBox, HPos.CENTER);
                }
            }
        }
    }

    public void setScene(){
        Platform.runLater(() -> {
            gridPane.getColumnConstraints().clear();
            gridPane.getRowConstraints().clear();
            gridPane.getChildren().clear();
            gridPane.setGridLinesVisible(false);
            gridPane.setGridLinesVisible(true);
            drawScene();
        });
    }

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Button button = new Button("START");
        HBox hBox = new HBox(textField, button);
        button.setOnAction(event -> {
            String[] args = textField.getText().split(" ");
            MoveDirection[] directions = new OptionsParser().parse(args);
            engine.setDirections(directions);
            Thread thread = new Thread(engine);
            thread.start();
        });
        gridPane.setGridLinesVisible(true);
        drawScene();
        VBox vBox = new VBox(hBox, gridPane);
        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(this::setScene);
    }
}