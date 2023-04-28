package day1.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutExemple extends Application {
    public static void main(String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Rectangle rect = new Rectangle(20,50,50,40);
        root.getChildren().add(rect);

        //Creating a scene object
        Scene scene = new Scene(root);


        //Setting title to the Stage
        primaryStage.setTitle("Formulaire d'enregistrement");

        //Adding scene to the stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();
    }
}
