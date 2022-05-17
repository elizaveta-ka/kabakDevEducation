package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.*;

import java.io.*;
import java.util.ArrayList;

public class ProjectJavaFX extends Application {
    private ArrayList<Figure> figures;
    private ArrayList<Point> points;
    final ColorPicker color1 = new ColorPicker(Color.WHITE);
    final ColorPicker color2 = new ColorPicker(Color.AQUA);
    final ColorPicker color3 = new ColorPicker(Color.BLACK);
    static final double mainCenterX = 440;
    static final double mainCenterY = 440;
    private int multiplierX;
    private int multiplierY;

    Pane pane = new Pane(); //NEW
    private double width = pane.getWidth();
    private double height = pane.getHeight();

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void paint(Pane pane, ArrayList<Figure> figures) {
        pane.prefWidth(880);
        pane.prefHeight(880);

                if(figures.size() > 0) {

                    double maxX = figures.get(0).getPoints().get(0).getX();
                    double maxY = figures.get(0).getPoints().get(0).getY();
                    double minX = figures.get(0).getPoints().get(0).getX();
                    double minY = figures.get(0).getPoints().get(0).getY();

                    for (var f : figures) {
                        for (var p : f.getPoints()) {
                            if (Math.abs(p.getX()) > Math.abs(maxX)) maxX = p.getX();
                            if (Math.abs(p.getY()) > Math.abs(maxY)) maxY = p.getY();
                            if (Math.abs(p.getX()) < Math.abs(maxX)) minX = p.getX();
                            if (Math.abs(p.getY()) < Math.abs(maxY)) minY = p.getY();
                        }
                    }
                    if (maxX == 0) maxX = 1;
                    // нужен отдельный мультиплайер для круга
//                    for (var f:figures) {
//                        if (f.getPoints().size() == 2) {
//                            multiplierX = (int) ((pane.getWidth() / 2 * 0.9) / Math.abs(maxX + (maxX - minX)));
//                            multiplierY = (int) ((pane.getHeight() / 2 * 0.9) / Math.abs(maxY + (maxY - minY)));
//                        } else {
                            multiplierX = (int) ((mainCenterX * 0.9) / Math.abs(maxX));
                            multiplierY = (int) ((mainCenterY * 0.9) / Math.abs(maxY));
//                        }
//                    }
                    System.out.println("mlpx " + multiplierX);
                    System.out.println("mlpy " + multiplierY);

                    Line line;
                    Circle circle;
                    for (var f : figures) {
                        if (f.getPoints().size() == 2) {
                            int multiplier = Math.min(multiplierX,multiplierY);
                            circle = new Circle((int) f.getPoints().get(0).getX() * multiplier + mainCenterX,
                                    -(int) f.getPoints().get(0).getY() * multiplier + mainCenterY, (int) f.getRadius() * multiplier);
                            pane.getChildren().add(circle);
                        } else {
                            for (int i = 0; i < f.getPoints().size(); i++) {
                                Point value1 = f.getPoints().get(i);
                                int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
                                Point value2 = f.getPoints().get(temp);
                                line = new Line((int) value1.getX() * multiplierX + mainCenterX,
                                        - (int) value1.getY() * multiplierY + mainCenterY,
                                        (int) value2.getX() * multiplierX + mainCenterX,
                                        -(int) value2.getY() * multiplierY + mainCenterY);
                                pane.getChildren().add(line);
                            }
                        }
                    }
                }
    }
//
//    public void paintOneFigure(AnchorPane anch, Figure f) {
//        anch.autosize();
//        Line line;
//        Circle circle;
//        if (f.getPoints().size() == 2) {
//            circle = new Circle((int) f.getPoints().get(0).getX(), (int) f.getPoints().get(0).getY(), (int) f.getRadius());
//            anch.getChildren().add(circle);
//        } else {
//            for (int i = 0; i < f.getPoints().size(); i++) {
//                Point value1 = f.getPoints().get(i);
//                int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
//                Point value2 = f.getPoints().get(temp);
//                line = new Line((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
//                anch.getChildren().add(line);
//            }
//        }
//    }
//
//    public void repaintMove(Figure f, ArrayList<Point> points){
//                for (int i = 0; i < f.getPoints().size(); i++) {
//                    f.move(points.get(0).getX(),points.get(0).getY());
//            }
//        writeObjectFigure(figures);
//    }
//
//    public void repaintScale(Figure figure, double num) {
//                figure.scale(num);
//        writeObjectFigure(figures);
//    }
//
//    public void repaintRotate(Figure f, double angle) {
//                f.rotate(angle);
//        writeObjectFigure(figures);
//    }

    public Figure defineFigureByCursor(double x, double y, int multiplierX, int multiplierY, ArrayList<Figure> figures) {
        for (var f:figures) {
            if (f.containPoint(x,y,multiplierX,multiplierY)) return f;
        }
        return null;
    }
    public double getNewCenterX(double n, double multiplierX) {
        double number = n * multiplierX;
        return mainCenterX + number;
    }

    public double getNewCenterY (double m, double multiplierY) {
        double number = m * multiplierY;
        return mainCenterY - number;
    }

    public void writeObjectFigure(ArrayList<Figure> figures) {
        try (FileOutputStream fos = new FileOutputStream("ProjectFXFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(figures);

        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    public ArrayList<Figure> readObjectFigure() {
        ArrayList<Figure> figures = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("ProjectFXFile");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            figures = (ArrayList<Figure>) ois.readObject();
        } catch (IOException ex) {
            System.out.println("Exception");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    public double readToFileForScale() throws IOException {
        double num = 0;
        File file = new File("testFileFX");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str;
        while((str = br.readLine()) != null) {
            num = Double.parseDouble(str);
        }
//        br.close();

        return num;
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
//        br.close();
        return pointsList;
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("My project JavaFX");
        BorderPane mainPane = new BorderPane();
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL,5,5);

        Button buttonCreateFigure = new Button("СОЗДАТЬ ФИГУРУ");
        Button buttonChangeFigure = new Button("ИЗМЕНИТЬ ФИГУРУ");
        Button buttonDeleteFigure = new Button("УДАЛИТЬ ФИГУРУ");
        Button buttonShowAllFigures = new Button("ВЫВЕСТИ ВСЕ ФИГУРЫ");
        TextArea text = new TextArea();
//        text.editableProperty();
        text.setPrefSize(60,300);

        FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
        Text writeX = new Text("введите x:");
        Text writeY = new Text("введите y:");
        TextField tfWriteX = new TextField();
        TextField tfWriteY = new TextField();
        Button btnAdd = new Button("ДОБАВИТЬ");
        Button btnDelete = new Button("УДАЛИТЬ");
        Button btnSave = new Button("СОХРАНИТЬ");
        flowPane.setAlignment(Pos.CENTER);
        flowPane.getChildren().addAll(writeX,tfWriteX,writeY,tfWriteY,btnAdd,btnDelete,btnSave);

        FlowPane rootChange = new FlowPane(Orientation.VERTICAL,20,20);
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

        mainPane.setLeft(rootNode);
        mainPane.setRight(flowPane);
        mainPane.setRight(rootChange);

        flowPane.setVisible(false);
        rootChange.setVisible(false);
        //new
        mainPane.setCenter(pane);
        Line line1 = new Line(440,0,440,880);
        Line line2 = new Line(0,440,880,440);
        pane.getChildren().addAll(line1,line2);
        pane.setBorder(Border.stroke(color3.getValue()));

        //для масштабирования фигуры
        EventHandler<MouseEvent> mouseEvent2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked " + event.getX() + " " +  event.getY());
                ArrayList<Figure> figures = readObjectFigure();
                for (var f:figures) {
                    System.out.println(f);
                }
                double x = event.getX() - mainCenterX;
                double y = -event.getY() + mainCenterY;
                Figure figure = defineFigureByCursor(x,y,multiplierX, multiplierY, figures);
                try {
                    double num = readToFileForScale();
                    figure.scale(num);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeObjectFigure(figures);
                pane.getChildren().clear();
                paint(pane, figures);
                pane.getChildren().addAll(line1,line2);
            }
        };

        // для движения фигуры
        EventHandler<MouseEvent> mouseEvent1 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked " + event.getX() + " " +  event.getY());
                ArrayList<Figure> figures = readObjectFigure();
                for (var f:figures) {
                    System.out.println(f);
                }
                double x = event.getX() - mainCenterX;
                double y = -event.getY() + mainCenterY;
                Figure figure = defineFigureByCursor(x,y,multiplierX,multiplierY,figures);
                try {
                    ArrayList<Point> points = readToFile();
                    double xP = points.get(0).getX();
                    double yP = points.get(0).getY();
                    figure.move(xP,yP);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeObjectFigure(figures);
                pane.getChildren().clear();
                paint(pane, figures);
                pane.getChildren().addAll(line1,line2);

            }
        };
        //для вращения фигуры
        EventHandler<MouseEvent> mouseEvent3 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked " + event.getX() + " " +  event.getY());
                ArrayList<Figure> figures = readObjectFigure();
                for (var f:figures) {
                    System.out.println(f);
                }
                double x = event.getX() - mainCenterX;
                double y = -event.getY() + mainCenterY;
                Figure figure = defineFigureByCursor(x,y,multiplierX, multiplierY, figures);
                if(figure.getClass().getSimpleName().equals("Circle")) {
                    Label label = new Label("Ты правда собрался вращать круг?");
                    label.setBackground(Background.fill(color2.getValue()));
                    rootNode.getChildren().add(label);
                }
                try {
                    double num = readToFileForScale();
                    figure.rotate(num);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeObjectFigure(figures);
                pane.getChildren().clear();
                paint(pane, figures);
                pane.getChildren().addAll(line1,line2);
            }
        };
        // для удаления фигуры
        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked " + event.getX() + " " +  event.getY());
                ArrayList<Figure> figures = readObjectFigure();
                for (var f:figures) {
                    System.out.println(f);
                }
                double x = event.getX() - mainCenterX;
                double y = -event.getY() + mainCenterY;
                Figure figure = defineFigureByCursor(x,y,multiplierX, multiplierY, figures);
                figures.remove(figure);
                writeObjectFigure(figures);
                pane.getChildren().clear();
                paint(pane, readObjectFigure());
                pane.getChildren().addAll(line1,line2);
            }
        };

        ArrayList<Figure> figures = new ArrayList<>();
        buttonCreateFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                paint(pane, readObjectFigure());
                pane.getChildren().addAll(line1,line2);
                flowPane.setVisible(true);
                mainPane.setRight(flowPane);
                stage.show();

//                ArrayList<Point> points = new ArrayList<>();
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

                        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    text.undo();
                                    String str = text.getText();
                                    writeToFile(str);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });

                btnSave.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        pane.getChildren().clear();
                        text.clear();
                        FigureCreator creator = new FigureCreator();
                        try {
                            figures.add(creator.createFigure(readToFile()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        writeObjectFigure(figures);
                        pane.getChildren().addAll(line1,line2);
                        paint(pane, readObjectFigure());
                        System.out.println(figures);
                    }
                });
            }
        });
        buttonChangeFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                paint(pane, readObjectFigure());
                rootChange.setVisible(true);
                mainPane.setRight(rootChange);
                stage.show();
                btnOk1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
                        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
                        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
                        String moveX = tfMoveX.getText();
                        String moveY = tfMoveY.getText();
                        text.setText(moveX + ";" + moveY);
                        try {
                            writeToFile(text.getText());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        btnMove.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                Label label1 = new Label("Кликай на фигуру, чтобы она двигалась");
                                label1.setBackground(Background.fill(color2.getValue()));
                                rootNode.getChildren().add(label1);

                                pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
                            }
                        });
                    }
                });
                btnOk2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
                        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
                        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
                        text.setText(tfScale.getText());
                        try {
                            writeToFile(text.getText());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        btnScale.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                Label label2 = new Label("Кликай на фигуру, чтобы она масштабировалась");
                                label2.setBackground(Background.fill(color2.getValue()));
                                rootNode.getChildren().add(label2);

                                pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
//                                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
//                                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
//                                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
//                                        Label myLabelChange = new Label("Выберите фигуру, которую хотите подвинуть");
//                                        myLabelChange.setBackground(Background.fill(color2.getValue()));
//                                        rootNode.getChildren().add(myLabelChange);
//
//                                        anch.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
//
////                                        anch.getChildren().clear();
//                                        try {
//                                            repaintScale(figure,readToFileForScale());
//                                        } catch (IOException e) {
//                                            e.printStackTrace();
//                                        }
//                                        paint(readObjectFigure());
                            }
                        });
                    }
                });
                btnOk3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        text.setText(tfRotate.getText());
                        try {
                            writeToFile(text.getText());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        btnRotate.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                Label label3 = new Label("Кликай на фигуру, чтобы она крутилась");
                                label3.setBackground(Background.fill(color2.getValue()));
                                rootNode.getChildren().add(label3);

                                pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
                                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
                                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
                                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
//                                        anch.getChildren().clear();
//                                        try {
//                                            repaintRotate(readObjectFigure(),readToFileForScale());
//                                        } catch (IOException e) {
//                                            e.printStackTrace();
//                                        }
//                                        paint(readObjectFigure());
                            }
                        });
                    }
                });
            }
        });
        buttonDeleteFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label label4 = new Label("Выберите фигуру, которую хотите удалить");
                label4.setBackground(Background.fill(color2.getValue()));
                rootNode.getChildren().add(label4);
                flowPane.setVisible(false);
                rootChange.setVisible(false);

//                paint(pane, readObjectFigure());

                pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
                pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);

                paint(pane, readObjectFigure());

            }
        });

        buttonShowAllFigures.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                paint(pane, readObjectFigure());
                flowPane.setVisible(false);
                rootChange.setVisible(false);
            }
        });
        Scene myScene = new Scene(mainPane);
        rootNode.getChildren().addAll(buttonCreateFigure,text,buttonChangeFigure,buttonDeleteFigure, buttonShowAllFigures);
        stage.setScene(myScene);
        stage.show();
    }
}
