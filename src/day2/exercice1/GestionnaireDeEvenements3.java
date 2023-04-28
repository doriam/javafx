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

public class GestionnaireDeEvenements3 extends Application {
    private String message = "Vous avez cliqué sur le button ===> 'Bonjour tout le monde !'";
Label label;
    public static void main(String[] args) {
    Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();

        gridPane.setMinSize(500, 500);

        Button buttonAction = new Button("Cliquez ici pour dire 'Bonjour tout le monde !'");
        buttonAction.setOnAction(new BtnEventHandler(this));

        label = new Label(message);
        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.TOP_LEFT);

        gridPane.add(buttonAction, 0, 0);
        gridPane.add(label, 0, 2);
        Scene scene = new Scene(gridPane, 400, 350);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestionnaire d'évènements");
        primaryStage.show();

    }

    public void message() {
       label.setText(this.message);
    }
}

class BtnEventHandler implements EventHandler<ActionEvent> {

    GestionnaireDeEvenements3 test;
    BtnEventHandler(GestionnaireDeEvenements3 test){
        this.test = test;
    }

    @Override
    public void handle(ActionEvent event) {
        this.test.message();
    }
}
