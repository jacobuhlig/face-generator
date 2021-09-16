package com.example.facegenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    static Scanner scan = new Scanner(System.in);
    static boolean boo = true;
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        drawShape();

        stage.show();
    }


    //Shape of head
    public static void drawShape() {

        System.out.println("What shape of face would you like?");
        System.out.println("Square:\t\t\t\tPress 1\nOval:\t\t\t\tPress 2\nTriangular:\t\t\tPress 3");

        while (boo) {
            String shapeOfHead = scan.next();
            if (shapeOfHead.equals("1")) { //Square head
                gc.strokeRect(150, 150, 300, 300);
                System.out.println("\n");
                drawMouth();
                boo = false;
            } else if (shapeOfHead.equals("2")) { //Oval head
                gc.strokeOval(150, 150, 300, 300);
                System.out.println("\n");
                drawMouth();
                boo = false;
            } else if (shapeOfHead.equals("3")) { //Triangular head
                gc.strokePolygon(new double[]{300, 80, 520}, new double[]{500, 160, 160}, 3);
                System.out.println("\n");
                drawMouth();
                boo = false;
            }

        }
    }

    //Shape of mouth
    public static void drawMouth() {

        System.out.println("How big would you like the mouth to be?");
        System.out.println("Small:\t\t\t\tPress 1\nMedium:\t\t\t\tPress 2\nLarge:\t\t\t\tPress 3");

        while (boo) {
            String mouthSize = scan.nextLine();
            gc.setFill(Color.BLACK);
            if (mouthSize.equals("1")) { //Small mouth
                gc.fillOval(290, 320, 25, 25);
                System.out.println("\n");
                drawEyes();
                boo = false;
            } else if (mouthSize.equals("2")) { //Medium mouth
                gc.fillOval(260, 310, 80, 80);
                System.out.println("\n");
                drawEyes();
                boo = false;
            } else if (mouthSize.equals("3")) { //Large mouth
                gc.fillOval(240, 300, 120, 120);
                System.out.println("\n");
                drawEyes();
                boo = false;
            }

        }
    }

    //Style of eyes
    public static void drawEyes() {

        System.out.println("How big would you like your eyes?");
        System.out.println("Small n' squinty:\tPress 1\nNormal n' boring:\tPress 2\nHuge n' scary:\t\tPress 3");

        while (boo) {
            String styleOfEyes = scan.nextLine();
            gc.setFill(Color.BLACK);
            if (styleOfEyes.equals("1")) { //Small n' squinty
                gc.fillOval(220,220,20,20);
                gc.fillOval(360,220,20,20);
                System.out.println("\n");
                boo = false;
            } else if (styleOfEyes.equals("2")) { //Normal n' boring
                gc.fillOval(220,220,45,45);
                gc.fillOval(360,220,45,45);
                System.out.println("\n");
                boo = false;
            } else if (styleOfEyes.equals("3")) { //Huge n' scary
                gc.fillOval(220,220,65,65);
                gc.fillOval(360,220,65,65);
                System.out.println("\n");
                boo = false;
            }

        }
    }


    public static void main(String[] args) {
        launch();
    }
}