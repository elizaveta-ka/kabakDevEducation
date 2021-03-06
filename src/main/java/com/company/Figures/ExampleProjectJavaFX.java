//package com.company.Figures;
//
//import com.company.Figures.CreateFigures.FigureCreator;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Line;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import javafx.event.*;
//import javafx.geometry.*;
//
//import java.io.*;
//import java.util.ArrayList;
//
// public class ExamoleProjectJavaFX extends Application {
//    final ColorPicker color1 = new ColorPicker(Color.WHITE);
//    final ColorPicker color2 = new ColorPicker(Color.AQUA);
//    final ColorPicker color3 = new ColorPicker(Color.BLACK);
//    static final double mainCenterX = 430;
//    static final double mainCenterX = 440;
//    static final double mainCenterY = 440;
//    private double width = 1000;
//    private double height = 900;
//    private double width = 880;
//    private double height = 880;
//    private double multiplierX;
//    private double multiplierY;
//
//    Pane pane = new Pane(); //NEW
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//    public void paint(Pane pane, ArrayList<Figure> figures){
//        pane.prefWidth(pane.getWidth());
//        pane.prefHeight(pane.getHeight());
//        Line line;
//        Circle circle;
//        for (var f : figures) {
//            if (f.getPoints().size() == 2) {
//                circle = new Circle((int) f.getPoints().get(0).getX(),
//                        (int) f.getPoints().get(0).getY(), (int) f.getRadius());
//                pane.getChildren().add(circle);
//            } else {
//                for (int i = 0; i < f.getPoints().size(); i++) {
//                    Point value1 = f.getPoints().get(i);
//                    int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
//                    Point value2 = f.getPoints().get(temp);
//                    line = new Line((int) value1.getX(),
//                            (int) value1.getY(),
//                            (int) value2.getX(),
//                            (int) value2.getY()) ;
//                    pane.getChildren().add(line);
//                }
//            }
//        }
//    }
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
//    //
////    public void repaintMove(Figure f, ArrayList<Point> points){
////                for (int i = 0; i < f.getPoints().size(); i++) {
////                    f.move(points.get(0).getX(),points.get(0).getY());
////            }
////        writeObjectFigure(figures);
////    }
////
////    public void repaintScale(Figure figure, double num) {
////                figure.scale(num);
////        writeObjectFigure(figures);
////    }
////
////    public void repaintRotate(Figure f, double angle) {
////                f.rotate(angle);
////        writeObjectFigure(figures);
////    }
//    public Figure defineFigureByCursor(double x, double y, ArrayList<Figure> figures) {
//        for (var f:figures) {
//            if (f.containPoint(x,y)) return f;
//        }
//        return null;
//    }
//    public double getNewCenterX(double n) {
//        double number = n * 50;
//        return mainCenterX + number;
//    }
//    public double getNewCenterY (double m) {
//        double number = m * 50;
//        return mainCenterY - number;
//    }
//    public void writeObjectFigure(ArrayList<Figure> figures) {
//        try (FileOutputStream fos = new FileOutputStream("ProjectFXFile");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(figures);
//        } catch (IOException ex) {
//            System.out.println("Exception");
//        }
//    }
//    public ArrayList<Figure> readObjectFigure() {
//        ArrayList<Figure> figures = new ArrayList<>();
//        try (FileInputStream fis = new FileInputStream("ProjectFXFile");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            figures = (ArrayList<Figure>) ois.readObject();
//        } catch (IOException ex) {
//            System.out.println("Exception");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return figures;
//    }
//    public static void writeToFile(String str) throws IOException {
//        File file = new File("testFileFX");
//        try(FileWriter fr = new FileWriter(file);
//            BufferedWriter bw = new BufferedWriter(fr)) {
//            bw.write(str);
//        }
//    }
//    public double readToFileForScale() throws IOException {
//        double num = 0;
//        File file = new File("testFileFX");
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//        String str;
//        while((str = br.readLine()) != null) {
//            num = Double.parseDouble(str);
//        }
//        return num;
//    }
//    public ArrayList<Point> readToFile() throws IOException {
//        File file = new File("testFileFX");
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//        String str;
//        ArrayList<Point> pointsList = new ArrayList<>();
//        while ((str = br.readLine()) != null) {
//            String[] coordinates = str.split(";");
//            double x = getNewCenterX(Double.parseDouble(coordinates[0].trim()));
//            double y = getNewCenterY(Double.parseDouble(coordinates[1].trim()));
//            Point pointNew = new Point(x, y);
//            pointsList.add(pointNew);
//        }
//        return pointsList;
//    }
//    @Override
//    public void start(Stage stage) {
//        stage.setTitle("My project JavaFX");
////        stage.setWidth(1400);
////        stage.setHeight(900);
//        BorderPane mainPane = new BorderPane();
//        FlowPane rootNode = new FlowPane(Orientation.VERTICAL,20,20);
//        Button buttonCreateFigure = new Button("?????????????? ????????????");
//        Button buttonChangeFigure = new Button("???????????????? ????????????");
//        Button buttonDeleteFigure = new Button("?????????????? ????????????");
//        Button buttonShowAllFigures = new Button("?????????????? ?????? ????????????");
//        TextArea text = new TextArea();
//        text.editableProperty();
//        text.setPrefSize(15,300);
//
//
//        //        GridPane gridPane = new GridPane();
////        Text writeX = new Text("?????????????? x:");
////        Text writeY = new Text("?????????????? y:");
////        TextField tfWriteX = new TextField();
////        TextField tfWriteY = new TextField();
////        Button btnAdd = new Button("????????????????");
////        Button btnDelete = new Button("??????????????");
////        Button btnSave = new Button("??????????????????");
////        gridPane.setMinSize(70, 200);
////        gridPane.setVgap(5);
////        gridPane.setHgap(5);
////        gridPane.setAlignment(Pos.CENTER);
////        gridPane.add(writeX, 1, 0);
////        gridPane.add(tfWriteX, 1, 2);
////        gridPane.add(writeY, 1, 3);
////        gridPane.add(tfWriteY, 1, 4);
////        gridPane.add(btnAdd, 1, 5);
////        gridPane.add(btnDelete,1,6);
////        gridPane.add(btnSave, 1, 7);
//         FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
//                 Text writeX = new Text("?????????????? x:");
//                 Text writeY = new Text("?????????????? y:");
//                 TextField tfWriteX = new TextField();
//                 TextField tfWriteY = new TextField();
//                 Button btnAdd = new Button("????????????????");
//                 Button btnDelete = new Button("??????????????");
//                 Button btnSave = new Button("??????????????????");
//                 //        gridPane.setMinSize(70, 200);
//                 //        gridPane.setVgap(5);
//                 //        gridPane.setHgap(5);
//                 flowPane.setAlignment(Pos.CENTER);
//                 flowPane.getChildren().addAll(writeX,tfWriteX,writeY,tfWriteY,btnAdd,btnDelete,btnSave);
//
//                 FlowPane rootChange = new FlowPane(Orientation.VERTICAL,20,20);
//                 Button btnMove = new Button("?????????????????????? ????????????");
//                 Button btnScale = new Button("???????????????? ???????????? ????????????");
//                 Button btnRotate = new Button("?????????????? ????????????");
//                 Text textMove = new Text("?????????????? ???????????????????? ?????????????????????? ????????????");
//                 Text textMoveX = new Text("???? X");
//                 Text textMoveY = new Text("???? Y");
//                 TextField tfMoveX = new TextField();
//                 TextField tfMoveY = new TextField();
//                 Button btnOk1 = new Button("OK");
//                 Text textScale = new Text("???? ?????????????? ?????? ?????????????????? ?????????????");
//                 TextField tfScale = new TextField();
//                 Button btnOk2 = new Button("OK");
//                 Text textRotate = new Text("?????????????? ???????? ???????????????? ????????????");
//                 TextField tfRotate = new TextField();
//                 Button btnOk3 = new Button("OK");
//                 rootChange.getChildren().addAll(btnMove,textMove,textMoveX,tfMoveX,textMoveY,tfMoveY,btnOk1,btnScale,textScale,tfScale,btnOk2,btnRotate,textRotate,tfRotate,btnOk3);
//                 mainPane.setLeft(rootNode);
//                 mainPane.setRight(flowPane);
//                 mainPane.setRight(rootChange);
//                 flowPane.setVisible(false);
//                 rootChange.setVisible(false);
//                 //new
//                 mainPane.setCenter(pane);
//                 Line line1 = new Line(430,0,430,900);
//                 Line line2 = new Line(0,440,1000,440);
//                 pane.getChildren().addAll(line1,line2);
////        anch.setBorder(Border.stroke(color3.getValue()));
//                 //?????? ?????????????????????????????? ????????????
//                 EventHandler<MouseEvent> mouseEvent2 = new EventHandler<MouseEvent>() {
//@Override
//public void handle(MouseEvent event) {
//        System.out.println("clicked " + event.getX() + " " +  event.getY());
//        ArrayList<Figure> figures = readObjectFigure();
//        for (var f:figures) {
//        System.out.println(f);
//        }
//        double x = event.getX();
//        double y = event.getY();
//        Figure figure = defineFigureByCursor(x,y,figures);
//        try {
//        double num = readToFileForScale();
//        figure.scale(num);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        writeObjectFigure(figures);
//        pane.getChildren().clear();
//        paint(pane, figures);
//        pane.getChildren().addAll(line1,line2);
//        }
//        };
//        // ?????? ???????????????? ????????????
//        EventHandler<MouseEvent> mouseEvent1 = new EventHandler<MouseEvent>() {
//@Override
//public void handle(MouseEvent event) {
//        System.out.println("clicked " + event.getX() + " " +  event.getY());
//        ArrayList<Figure> figures = readObjectFigure();
//        for (var f:figures) {
//        System.out.println(f);
//        }
//        double x = event.getX();
//        double y = event.getY();
//        Figure figure = defineFigureByCursor(x,y,figures);
//        try {
//        ArrayList<Point> points = readToFile();
//        double xP = points.get(0).getX() - mainCenterX;
//        double yP = points.get(0).getY() - mainCenterY;
//        figure.move(xP,yP);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        writeObjectFigure(figures);
//        pane.getChildren().clear();
//        paint(pane, figures);
//        pane.getChildren().addAll(line1,line2);
//        }
//        };
//        //?????? ???????????????? ????????????
//        EventHandler<MouseEvent> mouseEvent3 = new EventHandler<MouseEvent>() {
//@Override
//public void handle(MouseEvent event) {
//        System.out.println("clicked " + event.getX() + " " +  event.getY());
//        ArrayList<Figure> figures = readObjectFigure();
//        for (var f:figures) {
//        System.out.println(f);
//        }
//        double x = event.getX();
//        double y = event.getY();
//        Figure figure = defineFigureByCursor(x,y,figures);
//        if(figure.getClass().getSimpleName().equals("Circle")) {
//        Label label = new Label("???? ???????????? ???????????????? ?????????????? ?????????");
//        label.setBackground(Background.fill(color2.getValue()));
//        rootNode.getChildren().add(label);
//        }
//        try {
//        double num = readToFileForScale();
//        figure.rotate(num);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        writeObjectFigure(figures);
//        pane.getChildren().clear();
//        paint(pane, figures);
//        pane.getChildren().addAll(line1,line2);
//        }
//        };
//        // ?????? ???????????????? ????????????
//        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
//@Override
//public void handle(MouseEvent event) {
//        System.out.println("clicked " + event.getX() + " " +  event.getY());
//        ArrayList<Figure> figures = readObjectFigure();
//        for (var f:figures) {
//        System.out.println(f);
//        }
//        double x = event.getX();
//        double y = event.getY();
//        Figure figure = defineFigureByCursor(x,y,figures);
//        figures.remove(figure);
//        writeObjectFigure(figures);
//        pane.getChildren().clear();
//        paint(pane, readObjectFigure());
//        pane.getChildren().addAll(line1,line2);
//        }
//        };
//        ArrayList<Figure> figures = new ArrayList<>();
//        buttonCreateFigure.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        pane.getChildren().clear();
//        paint(pane, readObjectFigure());
//        pane.getChildren().addAll(line1,line2);
//        flowPane.setVisible(true);
//        mainPane.setRight(flowPane);
//        stage.show();
////                ArrayList<Point> points = new ArrayList<>();
//        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        String readX = tfWriteX.getText();
//        String readY = tfWriteY.getText();
//        text.appendText(readX + ";" + readY + "\n");
//        tfWriteX.clear();
//        tfWriteY.clear();
//        String str = text.getText();
//        try {
//        writeToFile(str);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//
//        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        try {
//        text.undo();
//        String str = text.getText();
//        writeToFile(str);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        }
//        });
//        }
//        });
//
//        btnSave.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        pane.getChildren().clear();
//        text.clear();
//        FigureCreator creator = new FigureCreator();
//        try {
//        figures.add(creator.createFigure(readToFile()));
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        writeObjectFigure(figures);
//        pane.getChildren().addAll(line1,line2);
//        paint(pane, readObjectFigure());
//        System.out.println(figures);
//        }
//        });
//        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        //                        try {
//        //                            points = readToFile();
//        //                            System.out.println(points);
//        //                            points.remove(points.get(points.size() - 1));
//        //                            System.out.println(points);
//        //                            text.setText(text.getText().);
//        //
//        //
//        //                        } catch (IOException e) {
//        //                            e.printStackTrace();
//        //                        }
//        }
//        });
//        }
//        });
//        buttonChangeFigure.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        paint(pane, readObjectFigure());
//        rootChange.setVisible(true);
//        mainPane.setRight(rootChange);
//        stage.show();
//        btnOk1.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        String moveX = tfMoveX.getText();
//        String moveY = tfMoveY.getText();
//        text.setText(moveX + ";" + moveY);
//        try {
//        writeToFile(text.getText());
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        btnMove.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        Label myLabelChange = new Label("???????????? ???? ????????????, ?????????? ?????? ??????????????????");
//        myLabelChange.setBackground(Background.fill(color2.getValue()));
//        rootNode.getChildren().add(myLabelChange);
//        pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
//        }
//        });
//        }
//        });
//        btnOk2.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        text.setText(tfScale.getText());
//        try {
//        writeToFile(text.getText());
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        btnScale.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        Label myLabelScale = new Label("???????????? ???? ????????????, ?????????? ?????? ????????????????????????????????");
//        myLabelScale.setBackground(Background.fill(color2.getValue()));
//        rootNode.getChildren().add(myLabelScale);
//        pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
////                                        Label myLabelChange = new Label("???????????????? ????????????, ?????????????? ???????????? ??????????????????");
////                                        myLabelChange.setBackground(Background.fill(color2.getValue()));
////                                        rootNode.getChildren().add(myLabelChange);
////
////                                        anch.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
////
//////                                        anch.getChildren().clear();
////                                        try {
////                                            repaintScale(figure,readToFileForScale());
////                                        } catch (IOException e) {
////                                            e.printStackTrace();
////                                        }
////                                        paint(readObjectFigure());
//        }
//        });
//        }
//        });
//        btnOk3.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        text.setText(tfRotate.getText());
//        try {
//        writeToFile(text.getText());
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        btnRotate.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        Label myLabelScale = new Label("???????????? ???? ????????????, ?????????? ?????? ??????????????????");
//        myLabelScale.setBackground(Background.fill(color2.getValue()));
//        rootNode.getChildren().add(myLabelScale);
//        pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
////                                        anch.getChildren().clear();
////                                        try {
////                                            repaintRotate(readObjectFigure(),readToFileForScale());
////                                        } catch (IOException e) {
////                                            e.printStackTrace();
////                                        }
////                                        paint(readObjectFigure());
//        }
//        });
//        }
//        });
//        }
//        });
//        buttonDeleteFigure.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        Label myLabelDelete = new Label("???????????????? ????????????, ?????????????? ???????????? ??????????????");
//        myLabelDelete.setBackground(Background.fill(color2.getValue()));
//        rootNode.getChildren().add(myLabelDelete);
//        flowPane.setVisible(false);
//        rootChange.setVisible(false);
//        paint(pane, readObjectFigure());
//        pane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent1);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent2);
//        pane.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent3);
//        paint(pane, readObjectFigure());
//        }
//        });
//        buttonShowAllFigures.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//        paint(pane, readObjectFigure());
//        flowPane.setVisible(false);
//        rootChange.setVisible(false);
//        }
//        });
//        Scene myScene = new Scene(mainPane);
//        rootNode.getChildren().addAll(buttonCreateFigure,text,buttonChangeFigure,buttonDeleteFigure, buttonShowAllFigures);
//        stage.setScene(myScene);
//        stage.show();
//        }
//        }