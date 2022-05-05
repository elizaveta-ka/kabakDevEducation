//package com.company.Figures;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Line;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.util.ArrayList;
//
//public class ExampleProjectFX extends Application {
//    public static void writeToFile(String str) throws IOException {
//        File file = new File("testFileFX");
//        try(FileWriter fr = new FileWriter(file);
//            BufferedWriter bw = new BufferedWriter(fr)) {
//            bw.write(str);
//        }
//    }
//    public ArrayList<Point> readToFile() throws IOException {
//        File file = new File("testFileFX");
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//        String str;
//        ArrayList<Point> pointsList = new ArrayList<>();
//        while ((str = br.readLine()) != null) {
//            String[] coordinates = str.split(";");
//            double x = Double.parseDouble(coordinates[0].trim());
//            double y = Double.parseDouble(coordinates[1].trim());
//            Point pointNew = new Point(x, y);
//            pointsList.add(pointNew);
//        }
//        return pointsList;
//    }
//    public void writeObjectFigure(ArrayList<Figure> figures) {
//        try (FileOutputStream fos = new FileOutputStream("ProjectFXFile");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            for (int i = 0; i < figures.size(); i++) {
//                oos.writeObject(figures.get(i));
//            }
//
//        } catch (IOException ex) {
//            System.out.println("Exception");
//        }
//    }
//    public ArrayList<Figure> readObjectFigure() {
//        ArrayList<Figure> figures = new ArrayList<>();
//        try (FileInputStream fis = new FileInputStream("ProjectFXFile");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            Object str;
//            while ((str = ois.readObject()) != null) {
//                figures.add((Figure) str);
//            }
//        } catch (IOException ex) {
//            System.out.println("Exception");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return figures;
//    }
//
//    public Group paint(ArrayList<Figure> figures){
//        Stage stagePaint = new Stage();
//        stagePaint.setWidth(1300);
//        stagePaint.setHeight(800);
//        Group root = new Group();
//        Line line;
//        javafx.scene.shape.Circle circle;
//        for (var f:figures) {
//            if (f.getPoints().size() == 2) {
//                circle = new Circle((int) f.getPoints().get(0).getX(), (int) f.getPoints().get(0).getY(), (int) f.getRadius());
//                root.getChildren().add(circle);
//            } else {
//                for (int i = 0; i < f.getPoints().size(); i++) {
//                    Point value1 = f.getPoints().get(i);
//                    int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
//                    Point value2 = f.getPoints().get(temp);
//                    line = new Line((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
//                    root.getChildren().add(line);
//                }
//            }
//        }
////        writeObjectFigure(figures);
//        return root;
//    }
//        @Override
//        public void start(Stage stage) throws Exception {
//            stage.setHeight(600);
//            stage.setWidth(1000);
//            BorderPane mainPane = new BorderPane();
//
//            Button buttonCreateFigure = new Button("СОЗДАТЬ ФИГУРУ");
//            Button buttonChangeFigure = new Button("ИЗМЕНИТЬ ФИГУРУ");
//            Button buttonDeleteFigure = new Button("УДАЛИТЬ ФИГУРУ");
//            Button buttonShowAllFigures = new Button("ВЫВЕСТИ ВСЕ ФИГУРЫ");
//
//            buttonCreateFigure.setMaxHeight(Double.MAX_VALUE);
//            buttonChangeFigure.setMaxHeight(Double.MAX_VALUE);
//            buttonDeleteFigure.setMaxHeight(Double.MAX_VALUE);
//            buttonShowAllFigures.setMaxHeight(Double.MAX_VALUE);
//            VBox vbox = new VBox(10);
//            Group figures = new Group();
//
//            GridPane gridPane = new GridPane();
//            Text writeX = new Text("введите x:");
//            Text writeY = new Text("введите y:");
//            TextField tfWriteX = new TextField();
//            TextField tfWriteY = new TextField();
//            Button btnAdd = new Button("ДОБАВИТЬ");
//            Button btnDelete = new Button("УДАЛИТЬ");
//            Button btnSave = new Button("СОХРАНИТЬ");
//
//            gridPane.setMinSize(100, 200);
//            gridPane.setVgap(5);
//            gridPane.setHgap(5);
//            gridPane.setAlignment(Pos.CENTER);
//            gridPane.add(writeX, 0, 0);
//            gridPane.add(writeY, 1, 0);
//            gridPane.add(tfWriteX, 0, 1);
//            gridPane.add(tfWriteY, 1, 1);
//            gridPane.add(btnAdd, 1, 2);
//            gridPane.add(btnDelete,1,3);
//            gridPane.add(btnSave, 2, 2);
//            gridPane.getChildren().addAll(writeX,writeY,tfWriteX,tfWriteY,btnAdd,btnDelete,btnSave);
//
//            mainPane.setCenter(paint(readObjectFigure()));
//            mainPane.setLeft(gridPane);
//
////            paint(readObjectFigure()).getChildren().add(lb1);
//
//            buttonCreateFigure.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
////                    mainPane.setCenter(st1);
//                }
//            });
//
//            buttonChangeFigure.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    mainPane.setCenter(figures);
//                }
//            });
//
//            vbox.setSpacing(10);
//            vbox.setPadding(new Insets(10, 20, 20, 10));
//            vbox.getChildren().addAll(buttonCreateFigure,buttonChangeFigure,buttonDeleteFigure,buttonShowAllFigures);
//
//            Scene scene = new Scene(mainPane);
//            stage.setScene(scene);
//
//            stage.show();
//        }
//
//        public static void main(String[] args) {
//            launch();
//        }
//    }
