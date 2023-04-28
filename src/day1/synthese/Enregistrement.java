package day1.synthese;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Enregistrement extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        //Label for name
        Label nameLabel = new Label("Nom");
        //Text field for name
        TextField nameText = new TextField();

        //Label for date of birth
        Label dobLabel = new Label("Date de naissance");
        //date picker to choose date
        DatePicker datePicker = new DatePicker();

        //Label for gender
        Label genderLabel = new Label("Genre");
        //Toggle group of radio buttons
        //A ToggleGroup allows at most one RadioButton to be selected at any time.
        RadioButton maleRadio = new RadioButton("Homme");
        RadioButton femaleRadio = new RadioButton("Femme");

        //Seulement un des valeurs peut être sélectionné en même temps.
        ToggleGroup groupGender = new ToggleGroup();

        maleRadio.setToggleGroup(groupGender);
        femaleRadio.setToggleGroup(groupGender);
        //femaleRadio2.setToggleGroup(groupGender);

        //Label for disponibility
        Label disponibilityLabel = new Label("Disponible ?");
        // A JavaFX ToggleButton is a button that can be selected or not selected.

        //Like a button that stays in when you press it, and when you press it the next time it comes out again.
        //Toggle button for disponibility
        ToggleButton yes = new ToggleButton("Oui");
        ToggleButton no = new ToggleButton("Non");
        //Toggle group of ToggleButton buttons
        ToggleGroup groupDisponibility = new ToggleGroup();
        yes.setToggleGroup(groupDisponibility);
        no.setToggleGroup(groupDisponibility);

        //Label for technologies known
        Label technologiesLabel = new Label("Technologies Connues");

        //check box for technologies known
        CheckBox javaCheckBox = new CheckBox("Java");

        //Si on ne lui donne pas une valeur, ce sera false.
        javaCheckBox.setIndeterminate(false);

        //check box for technologies known
        CheckBox dotnetCheckBox = new CheckBox("DotNet");
        javaCheckBox.setIndeterminate(false);


        //Label for location
        Label locationLabel = new Label("Localisation");

        //Choice box for location
        ChoiceBox locationchoiceBox = new ChoiceBox();
        locationchoiceBox.getItems().addAll
                ("Paris", "Lyon", "Brest", "Marseille", "Bordeaux");



        TextField data = new TextField();
        data.setMinWidth(400);

        //Button for register
        Button buttonRegister = new Button("Soumettre");
        buttonRegister.setId("buttonRegister");

        Button buttonClear = new Button("Supprimer");
        buttonClear.setId("buttonClear");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(600, 500);
        gridPane.setMaxWidth(1000);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameText, 3, 0);

        gridPane.add(dobLabel, 0, 1);
        gridPane.add(datePicker, 3, 1);

        gridPane.add(genderLabel, 0, 2);
        gridPane.add(maleRadio, 3, 2);
        gridPane.add(femaleRadio, 4, 2);

        gridPane.add(disponibilityLabel, 0, 3);
        gridPane.add(yes, 3, 3);
        gridPane.add(no, 4, 3);

        gridPane.add(technologiesLabel, 0, 4);
        gridPane.add(javaCheckBox, 3, 4);
        gridPane.add(dotnetCheckBox, 4, 4);


        buttonRegister.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                    data.setText(nameText.getText() + " - " + datePicker.getValue());

                    if(javaCheckBox.isSelected()){
                        data.appendText(" - " + javaCheckBox.getText());
                    }
                    if(dotnetCheckBox.isSelected()){
                       data.appendText(" - " +dotnetCheckBox.getText()) ;
                    }
                    if(groupGender.getSelectedToggle() != null){
                        RadioButton selectedGender = (RadioButton)groupGender.getSelectedToggle();
                        data.appendText( " - " + selectedGender.getText());
                    }
                    if (groupDisponibility.getSelectedToggle() != null) {
                        ToggleButton selectedDisponibility = (ToggleButton)groupDisponibility.getSelectedToggle();
                        data.appendText(" - "+ selectedDisponibility.getText());
                    }
                    data.appendText( " - " + locationchoiceBox.getValue());
            }
        });

        buttonClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.clear();
            }
        });

        gridPane.add(locationLabel, 0, 5);
        gridPane.add(locationchoiceBox, 3, 5);

        gridPane.add(buttonRegister, 4, 8);
        gridPane.add(buttonClear, 3, 8);


        gridPane.add(data, 0, 9, 3,1);

        //Setting the back ground color
        gridPane.setStyle("-fx-background-color: BEIGE;");

        //Creating a scene object
        Scene scene = new Scene(gridPane);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //Setting title to the Stage
        stage.setTitle("Formulaire d'enregistrement");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
}
