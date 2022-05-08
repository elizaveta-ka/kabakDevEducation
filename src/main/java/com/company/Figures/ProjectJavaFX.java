package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.*;
import lombok.SneakyThrows;

import java.io.*;
import java.time.Year;
import java.util.ArrayList;

public class ProjectJavaFX extends Application {
    private ArrayList<Figure> figures;
    private ArrayList<Point> points;
    final ColorPicker color1 = new ColorPicker(Color.WHITE);
    final ColorPicker color2 = new ColorPicker(Color.AQUA);
    final ColorPicker color3 = new ColorPicker(Color.BLACK);
    static final double mainCenterX = 430;
    static final double mainCenterY = 440;

    AnchorPane anch = new AnchorPane(); //NEW

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void paint(AnchorPane anch, ArrayList<Figure> figures){
    Line line;
    Circle circle;
    for (var f:figures) {
        if (f.getPoints().size() == 2) {
            circle = new Circle((int) f.getPoints().get(0).getX(), (int) f.getPoints().get(0).getY(), (int) f.getRadius());
            anch.getChildren().add(circle);
        } else {
            for (int i = 0; i < f.getPoints().size(); i++) {
                Point value1 = f.getPoints().get(i);
                int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
                Point value2 = f.getPoints().get(temp);
                line = new Line((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
                anch.getChildren().add(line);
            }
        }
    }
}

    public void paintOneFigure(AnchorPane anch, Figure f) {
        anch.autosize();
        Line line;
        Circle circle;
        if (f.getPoints().size() == 2) {
            circle = new Circle((int) f.getPoints().get(0).getX(), (int) f.getPoints().get(0).getY(), (int) f.getRadius());
            anch.getChildren().add(circle);
        } else {
            for (int i = 0; i < f.getPoints().size(); i++) {
                Point value1 = f.getPoints().get(i);
                int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
                Point value2 = f.getPoints().get(temp);
                line = new Line((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
                anch.getChildren().add(line);
            }
        }
    }
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

    public Figure defineFigureByCursor(double x, double y, ArrayList<Figure> figures) {
        for (var f:figures) {
            if (f.containPoint(x,y)) return f;
        }
        return null;
    }
    public static double getNewCentrX (double n) {
        return n * mainCenterX/ 50;
    }

    public static double getNewCentrY (double m) {
        return m * mainCenterY/ 50;
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
        text.setPrefSize(15,300);


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

        mainPane.setLeft(rootNode);
        mainPane.setRight(gridPane);
        mainPane.setRight(rootChange);

        gridPane.setVisible(false);
        rootChange.setVisible(false);
        //new
        mainPane.setCenter(anch);
        Line line1 = new Line(430,0,430,900);
        Line line2 = new Line(0,440,430,440);
        anch.getChildren().addAll(line1,line2);
        anch.setBorder(Border.stroke(color3.getValue()));

        //для масштабирования фигуры
        EventHandler<MouseEvent> mouseEvent2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked " + event.getX() + " " +  event.getY());
                ArrayList<Figure> figures = readObjectFigure();
                for (var f:figures) {
                    System.out.println(f);
                }
                System.out.println(anch.getWidth() + " " + anch.getHeight());
                double x = event.getX();
                double y = event.getY();
                Figure figure = defineFigureByCursor(x,y,figures);
                try {
                    double num = readToFileForScale();
                    figure.scale(num);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeObjectFigure(figures);
                anch.getChildren().clear();
                paint(anch, figures);
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
                System.out.println(anch.getWidth() + " " + anch.getHeight());
                double x = event.getX();
                double y = event.getY();
                Figure figure = defineFigureByCursor(x,y,figures);
                try {
                    ArrayList<Point> points = readToFile();
                    double xP = points.get(0).getX();
                    double yP = points.get(0).getY();
                    figure.move(xP,yP);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeObjectFigure(figures);
                anch.getChildren().clear();
                paint(anch, figures);
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
                System.out.println(anch.getWidth() + " " + anch.getHeight());
                double x = event.getX();
                double y = event.getY();
                Figure figure = defineFigureByCursor(x,y,figures);
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
                anch.getChildren().clear();
                paint(anch, figures);
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
                System.out.println(anch.getWidth() + " " + anch.getHeight());
                double x = event.getX();
                double y = event.getY();
                Figure figure = defineFigureByCursor(x,y,figures);
                figures.remove(figure);
                writeObjectFigure(figures);
                anch.getChildren().clear();
                paint(anch, readObjectFigure());
            }
        };

        ArrayList<Figure> figures = new ArrayList<>();
                    buttonCreateFigure.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            paint(anch, readObjectFigure());
//                                group.setVisible(true);
//                            mainPane.setCenter(paint(readObjectFigure())); //anchorPane = paint(readObject)
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
                                    paint(anch, readObjectFigure());
                                    text.clear();
                                    FigureCreator creator = new FigureCreator();
                                    try {
                                        figures.add(creator.createFigure(readToFile()));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    writeObjectFigure(figures);
                                    paint(anch, readObjectFigure());
//                                    mainPane.setCenter(paint(readObjectFigure()));
                                    //anchorPane = paint(readObject)
//                                    paint(readObjectFigure());
                                }
                            });
                        }
                    });
        buttonChangeFigure.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                mainPane.setCenter(paint(readObjectFigure()));
                paint(anch, readObjectFigure());

                rootChange.setVisible(true);
                mainPane.setRight(rootChange);
                stage.show();
                btnOk1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
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
                                Label myLabelChange = new Label("Кликай на фигуру, чтобы она двигалась");
                                myLabelChange.setBackground(Background.fill(color2.getValue()));
                                rootNode.getChildren().add(myLabelChange);

                                anch.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
                            }
                        });
                    }
                });
                        btnOk2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                text.setText(tfScale.getText());
                                try {
                                    writeToFile(text.getText());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                btnScale.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        Label myLabelScale = new Label("Кликай на фигуру, чтобы она масштабировалась");
                                        myLabelScale.setBackground(Background.fill(color2.getValue()));
                                        rootNode.getChildren().add(myLabelScale);

                                        anch.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
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
                                        Label myLabelScale = new Label("Кликай на фигуру, чтобы она крутилась");
                                        myLabelScale.setBackground(Background.fill(color2.getValue()));
                                        rootNode.getChildren().add(myLabelScale);

                                        anch.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
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
                Label myLabelDelete = new Label("Выберите фигуру, которую хотите удалить");
                myLabelDelete.setBackground(Background.fill(color2.getValue()));
                rootNode.getChildren().add(myLabelDelete);
                gridPane.setVisible(false);
                rootChange.setVisible(false);

                paint(anch, readObjectFigure());

                anch.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);



//                mainPane.setCenter(stackPane);
//                group.setVisible(true);
//                mainPane.setCenter(paint(readObjectFigure()));
//                mainPane.setCenter(paint(readObjectFigure()));
                //anchorPane = paint(readObject)
                paint(anch, readObjectFigure());

            }
        });

        buttonShowAllFigures.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                mainPane.setCenter(paint(readObjectFigure()));
                //anchorPane = paint(readObject)
                paint(anch, readObjectFigure());
                gridPane.setVisible(false);
                rootChange.setVisible(false);
            }
        });
        Scene myScene = new Scene(mainPane);
        rootNode.getChildren().addAll(buttonCreateFigure,text,buttonChangeFigure,buttonDeleteFigure, buttonShowAllFigures);
        stage.setScene(myScene);
        stage.show();
    }
}
