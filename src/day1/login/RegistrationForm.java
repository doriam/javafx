package day1.login;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class RegistrationForm extends Application {

    @Override
    public void start(Stage stage)  {
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
        //RadioButton femaleRadio2 = new RadioButton("Femmeddddddd");

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

        //Label for education
        Label educationLabel = new Label("Diplome & Qualification");

        //list View for educational qualification
        ObservableList<String> names = FXCollections.observableArrayList(
                "Licence", "Master", "Doctorat", "MBA", "Ingénieur");

        ListView<String> educationListView = new ListView<String>(names);

        //Label for location
        Label locationLabel = new Label("Localisation");

        //Choice box for location
        ChoiceBox locationchoiceBox = new ChoiceBox();
        locationchoiceBox.getItems().addAll
                ("Paris", "Lyon", "Brest", "Marseille", "Bordeaux");

        //Button for register
        Button buttonRegister = new Button("Soumettre");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(500, 500);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameText, 1, 0);

        gridPane.add(dobLabel, 0, 1);
        gridPane.add(datePicker, 1, 1);

        gridPane.add(genderLabel, 0, 2);
        gridPane.add(maleRadio, 1, 2);
        gridPane.add(femaleRadio, 2, 2);
        //gridPane.add(femaleRadio2, 3, 2);

        gridPane.add(disponibilityLabel, 0, 3);
        gridPane.add(yes, 1, 3);
        gridPane.add(no, 2, 3);

        gridPane.add(technologiesLabel, 0, 4);
        gridPane.add(javaCheckBox, 1, 4);
        gridPane.add(dotnetCheckBox, 2, 4);

        gridPane.add(educationLabel, 0, 5);
        gridPane.add(educationListView, 1, 5);

        gridPane.add(locationLabel, 0, 6);
        gridPane.add(locationchoiceBox, 1, 6);

        gridPane.add(buttonRegister, 2, 8);

        //Styling nodes
        buttonRegister.setStyle("-fx-background-color: darkslateblue; -fx-textfill: white");
        nameLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        dobLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        genderLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        disponibilityLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        technologiesLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        educationLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        locationLabel.setStyle("-fx-font: normal bold 15px 'serif' ");

        //Setting the back ground color
        gridPane.setStyle("-fx-background-color: BEIGE;");

        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        stage.setTitle("Formulaire d'enregistrement");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
}
