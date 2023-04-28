package day1.exemple1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class HelloWorld extends Application {

    public static void main(String[] args) {

        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button();
        Label txt = new Label();

        button.setText("Click here to say 'Hello World !'");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                    txt.setText("Hello World");
                    if(txt.isVisible()){
                        txt.setVisible(false);
                    }
                    else {
                        txt.setVisible(true);
                    }

            }
        });
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.add(button, 0, 0);
        root.add(txt, 0,1);

        Scene scene = new Scene(root, 350, 350);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();


    }
}
