package day2.exercice1;

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

public class GestionnaireDeEvenements1 extends Application {

    static Label message;

    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();

        gridPane.setMinSize(500, 500);

        Button buttonAction = new Button("Cliquez ici pour dire 'Bonjour tout le monde !'");
        message = new Label();

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.TOP_LEFT);


        gridPane.add(buttonAction, 0, 0);
        gridPane.add(message, 0, 2);


        Scene scene = new Scene(gridPane, 400, 350);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestionnaire d'évènements");
        primaryStage.show();

        buttonAction.setOnAction(new BtnEventHandler());
    }
    static class BtnEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            message.setText("Vous avez cliqué sur le button ===> 'Bonjour tout le monde !' ");
        }
    }
}

