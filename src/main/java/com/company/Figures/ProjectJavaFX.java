package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ProjectJavaFX extends Application {
    public ArrayList<Figure> figures;

    public static void main(String[] args) {
        launch(args);
    }
    public Group paint(ArrayList<Figure> figures){
        Group root = new Group();
        Line line;
        Circle circle;
        for (var f:figures) {
            if (f.getPoints().size() == 2) {
                circle = new Circle((int) f.getPoints().get(0).getX(), (int) f.getPoints().get(0).getY(), (int) f.getRadius());
                root.getChildren().add(circle);
            } else {
                for (int i = 0; i < f.getPoints().size(); i++) {
                    Point value1 = f.getPoints().get(i);
                    int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
                    Point value2 = f.getPoints().get(temp);
                    line = new Line((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
                    root.getChildren().add(line);
                }
            }
        }
        return root;
    }
    @Override
    public void start(Stage stage) throws Exception {
        Point p1 = new Point(100, 100);
        Point p2 = new Point(200, 200);
        Point p3 = new Point(300, 200);

        Point p4 = new Point(400, 200);
        Point p5 = new Point(400, 400);
        Point p6 = new Point(500, 400);
        Point p7 = new Point(500, 200);

        Point p8 = new Point(600, 200);
        Point p9 = new Point(600, 400);
        Point p10 = new Point(700, 500);
        Point p11 = new Point(800, 400);
        Point p12 = new Point(800, 200);

        Point p13 = new Point(200, 400);
        Point p14 = new Point(200, 300);

        ArrayList<Figure> figures = new ArrayList<>();
        FigureCreator creator = new FigureCreator();
        figures.add(creator.createFigure(Arrays.asList(p13, p14)));
        figures.add(creator.createFigure(Arrays.asList(p1, p2, p3)));
        figures.add(creator.createFigure(Arrays.asList(p4, p5, p6, p7)));
        figures.add(creator.createFigure(Arrays.asList(p8, p9, p10, p11, p12)));

        stage.setTitle("My project JavaFX");
        stage.setWidth(1400);
        stage.setHeight(900);
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL,20,20);

        Button buttonCreateFigure = new Button("СОЗДАТЬ ФИГУРУ");
        Button buttonChangeFigure = new Button("ИЗМЕНИТЬ ФИГУРУ");
        Button buttonDeleteFigure = new Button("УДАЛИТЬ ФИГУРУ");

        buttonCreateFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FlowPane rootCreate = new FlowPane(Orientation.VERTICAL,20,20);
                Button btnCreateCircle = new Button("СОЗДАТЬ КРУГ");
                Button btnCreateTriangle = new Button("СОЗДАТЬ ТРЕУГОЛЬНИК");
                Button btnCreateRectangle = new Button("СОЗДАТЬ ЧЕТЫРЕХУГОЛЬНИК");
                Button btnCreateNangle = new Button("СОЗДАТЬ МНОГОУГОЛЬНИК");
                Button btnComeback = new Button("НАЗАД");

                Scene mySceneCreate = new Scene(rootCreate);
                rootCreate.getChildren().addAll(btnCreateCircle,btnCreateTriangle,btnCreateRectangle,btnCreateNangle, btnComeback);
                stage.setScene(mySceneCreate);
                ArrayList<Button> myEventList = new ArrayList<>(Arrays.asList(btnCreateCircle,btnCreateTriangle,btnCreateRectangle,btnCreateNangle));
                for (var listEv:myEventList) {
                    listEv.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Text writeX = new Text("введите x:");
                            Text writeY = new Text("введите y:");
                            TextField tfWriteX = new TextField();
                            TextField tfWriteY = new TextField();
                            Button btnAddX = new Button("ДОБАВИТЬ X");
                            Button btnAddY = new Button("ДОБАВИТЬ Y");
                            Button btnSave = new Button("СОХРАНИТЬ");
                            GridPane gridPane = new GridPane();
                            gridPane.setMinSize(400, 200);
                            gridPane.setVgap(5);
                            gridPane.setHgap(5);
                            gridPane.setAlignment(Pos.CENTER);
                            gridPane.add(writeX, 0, 0);
                            gridPane.add(writeY, 1, 0);
                            gridPane.add(tfWriteX, 0, 1);
                            gridPane.add(tfWriteY, 1, 1);
                            gridPane.add(btnAddX, 0, 2);
                            gridPane.add(btnAddY, 1, 2);
                            gridPane.add(btnSave, 2, 2);

                            Scene gridScene = new Scene(gridPane);
                            stage.setScene(gridScene);
//                            Scene scenePaint = new Scene(paint(figures));
//                            stage.setScene(scenePaint);
                        }
                    });
                }
            }
        });
        buttonChangeFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FlowPane rootChange = new FlowPane(Orientation.VERTICAL, 20, 20);
                Button btnMove = new Button("ПЕРЕМЕСТИТЬ ФИГУРУ");
                Button btnScale = new Button("ИЗМЕНИТЬ РАЗМЕР ФИГУРЫ");
                Button btnRotate = new Button("ВРАЩАТЬ ФИГУРУ");
                Button btnComeback = new Button("НАЗАД");
                rootChange.getChildren().addAll(btnMove, btnScale, btnRotate, btnComeback);
                Scene myScaneChange = new Scene(rootChange);
                stage.setScene(myScaneChange);
            }
        });
        buttonDeleteFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label myLabelDelete = new Label("Выберите фигуру, которую хотите удалить");
                rootNode.getChildren().add(myLabelDelete);
            }
        });


        Scene myScene = new Scene(rootNode);
        rootNode.getChildren().addAll(buttonCreateFigure,buttonChangeFigure,buttonDeleteFigure);
        stage.setScene(myScene);
        stage.show();
    }
}
