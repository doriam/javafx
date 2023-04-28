package day2.exercice3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class MultiSceneSquelette extends Application {
    Scene scene1, scene2;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Exemple de gestion de plusieurs scènes");

        //Spécification de Scene 1
        Label label1= new Label("Je suis sur la première scène");

        Button button1= new Button("Cliquez pour aller sur Scene 2");
        StackPane button1SPane = new StackPane();
        button1SPane.getChildren().add(button1);

        //Méthode 4
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent ae) {
                primaryStage.setScene(scene2);
            } }

        );

        VBox layout1 = new VBox(20);
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(label1, button1SPane);
        scene1= new Scene(layout1, 300, 240);
        //Fin spécification de Scene 1

        //Spécification de Scene 2
        Label label2= new Label("Je suis sur la deuxième scène");

        Button button2= new Button("Cliquez pour aller sur Scene 1");
        StackPane button2SPane = new StackPane();
        button2SPane.getChildren().add(button2);


        //Méthode 4
        button2.setOnAction(new EventHandler<ActionEvent> () {

            public void handle(ActionEvent ae) {
                primaryStage.setScene(scene1);
            } }

        );

        VBox layout2= new VBox(20);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(label2, button2SPane);
        scene2= new Scene(layout2,300,240);

        //Fin spécification Scène 2
        primaryStage.setScene(scene1);// Affichage scène1
        primaryStage.show();
    }
}
