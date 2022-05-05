package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.*;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;

public class ProjectJavaFX extends Application {
    private ArrayList<Figure> figures;
    private ArrayList<Point> points;

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

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
//        writeObjectFigure(figures);
        return root;
    }

    public void writeObjectFigure(ArrayList<Figure> figures) {
        try (FileOutputStream fos = new FileOutputStream("ProjectFXFile",true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (int i = 0; i < figures.size(); i++) {
                oos.writeObject(figures.get(i));
            }

        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    public ArrayList<Figure> readObjectFigure() {
        ArrayList<Figure> figures = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("ProjectFXFile");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object str;
            while ((str = ois.readObject()) != null) {
                figures.add((Figure) str);
            }
        } catch (IOException ex) {
            System.out.println("Exception");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Figure fig:figures) {
            System.out.println(fig);
        }
       return figures;
    }

    public static void writeToFile(String str) throws IOException {
        File file = new File("testFileFX");
       try(FileWriter fr = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fr)) {
           bw.write(str);
       }
    }

    public ArrayList<Point> readToFile() throws IOException {
        File file = new File("testFileFX");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str;
        ArrayList<Point> pointsList = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            String[] coordinates = str.split(";");
            double x = Double.parseDouble(coordinates[0].trim());
            double y = Double.parseDouble(coordinates[1].trim());
            Point pointNew = new Point(x, y);
            pointsList.add(pointNew);
        }
        return pointsList;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("My project JavaFX");
        stage.setWidth(1400);
        stage.setHeight(900);
        BorderPane mainPane = new BorderPane();
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL,20,20);

        Button buttonCreateFigure = new Button("СОЗДАТЬ ФИГУРУ");
        Button buttonChangeFigure = new Button("ИЗМЕНИТЬ ФИГУРУ");
        Button buttonDeleteFigure = new Button("УДАЛИТЬ ФИГУРУ");
        Button buttonShowAllFigures = new Button("ВЫВЕСТИ ВСЕ ФИГУРЫ");
        TextArea text = new TextArea();

        GridPane gridPane = new GridPane();
        Text writeX = new Text("введите x:");
        Text writeY = new Text("введите y:");
        TextField tfWriteX = new TextField();
        TextField tfWriteY = new TextField();
        Button btnAdd = new Button("ДОБАВИТЬ");
        Button btnDelete = new Button("УДАЛИТЬ");
        Button btnSave = new Button("СОХРАНИТЬ");
        gridPane.setMinSize(70, 200);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(writeX, 1, 0);
        gridPane.add(tfWriteX, 1, 2);
        gridPane.add(writeY, 1, 3);
        gridPane.add(tfWriteY, 1, 4);
        gridPane.add(btnAdd, 1, 5);
        gridPane.add(btnDelete,1,6);
        gridPane.add(btnSave, 1, 7);

        FlowPane rootChange = new FlowPane(Orientation.VERTICAL, 20, 20);
        Button btnMove = new Button("ПЕРЕМЕСТИТЬ ФИГУРУ");
        Button btnScale = new Button("ИЗМЕНИТЬ РАЗМЕР ФИГУРЫ");
        Button btnRotate = new Button("ВРАЩАТЬ ФИГУРУ");
        Text textMove = new Text("Задайте координаты перемещения фигуры");
        Text textMoveX = new Text("по X");
        Text textMoveY = new Text("по Y");
        TextField tfMoveX = new TextField();
        TextField tfMoveY = new TextField();
        Button btnOk1 = new Button("OK");

        Text textScale = new Text("Во сколько раз увеличить фигуру?");
        TextField tfScale = new TextField();
        Button btnOk2 = new Button("OK");

        Text textRotate = new Text("Задайте угол вращения фигуры");
        TextField tfRotate = new TextField();
        Button btnOk3 = new Button("OK");
        rootChange.getChildren().addAll(btnMove,textMove,textMoveX,tfMoveX,textMoveY,tfMoveY,btnOk1,btnScale,textScale,tfScale,btnOk2,btnRotate,textRotate,tfRotate,btnOk3);
//        Group group = paint(readObjectFigure());
        mainPane.setLeft(rootNode);
        mainPane.setRight(gridPane);
        mainPane.setRight(rootChange);
//        mainPane.setCenter(paint(readObjectFigure()));
        gridPane.setVisible(false);
        rootChange.setVisible(false);

        ArrayList<Figure> figures = new ArrayList<>();
                    buttonCreateFigure.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
//                                group.setVisible(true);
                                gridPane.setVisible(true);
                                mainPane.setRight(gridPane);
                                stage.show();

                            ArrayList<Point> points = new ArrayList<>();
                                    btnAdd.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            String readX = tfWriteX.getText();
                                            String readY = tfWriteY.getText();
                                            text.appendText(readX + ";" + readY + "\n");
                                            tfWriteX.clear();
                                            tfWriteY.clear();
                                            String str = text.getText();
                                            try {
                                                writeToFile(str);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });

                            btnSave.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    text.clear();
//                                    group.setVisible(true);
//                                    System.out.println("SAVE");
//                                    System.out.println(text.getText());
                                    FigureCreator creator = new FigureCreator();
//                                    ArrayList<Figure> figures = new ArrayList<>();
                                    try {
                                        figures.add(creator.createFigure(readToFile()));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    writeObjectFigure(figures);
                                    mainPane.setCenter(paint(figures));
//                                    paint(readObjectFigure());
                                }
                            });
                        }
                    });
        buttonChangeFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainPane.setCenter(paint(readObjectFigure()));
                paint(readObjectFigure());
//                group.setVisible(true);
//                mainPane.setCenter(paint(readObjectFigure()));
//                paint(readObjectFigure());
//                mainPane.setCenter(paint(readObjectFigure()));

                rootChange.setVisible(true);
                mainPane.setRight(rootChange);
                stage.show();
                        btnOk2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                textScale.setText(tfScale.getText());
//                                paint(readObjectFigure());

                            }
                        });
            }
        });
        buttonDeleteFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label myLabelDelete = new Label("Выберите фигуру, которую хотите удалить");
                rootNode.getChildren().add(myLabelDelete);
//                mainPane.setCenter(stackPane);
//                group.setVisible(true);
//                mainPane.setCenter(paint(readObjectFigure()));
                paint(readObjectFigure());
            }
        });

        buttonShowAllFigures.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                paint(readObjectFigure());
            }
        });
        Scene myScene = new Scene(mainPane);
        rootNode.getChildren().addAll(buttonCreateFigure,text,buttonChangeFigure,buttonDeleteFigure, buttonShowAllFigures);
        stage.setScene(myScene);
        stage.show();
    }
}
