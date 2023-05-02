package day3.exercice4;

import day3.exercice4.LesEmployes;
import day3.exercice3.Contact;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableViewFichierExo extends Application {

    //ObservableList<Contact> data =lesEmployes;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        String path = "src/day3/exercice4/employes.txt";
//        LesEmployes lesEmployes = new LesEmployes(path);
//        //lesEmployes.fabriqueVecteur();
//        ObservableList<Employe> t = FXCollections.observableList(lesEmployes.fabriqueVecteur()) ;

        ObservableList<Employe> data = getEmployeList();
        //Création de la table
        TableView<Employe> table = new TableView<Employe>();
        table.setEditable(true);

        Label label = new Label("Liste des employés");
        label.setFont(new Font("Arial", 20));

        //Création des cinq colonnes

        TableColumn<Employe, Integer> numeroCol =
                new TableColumn<Employe, Integer>("Numéro");
        numeroCol.setMinWidth(100);
        //specifier un "cell factory" pour cette colonne.
        numeroCol.setCellValueFactory(
                new PropertyValueFactory<Employe, Integer>("numero"));


        TableColumn<Employe, String> nomCol =
                new TableColumn<Employe, String>("Nom");
        nomCol.setMinWidth(100);
        //specifier un "cell factory" pour cette colonne.
        nomCol.setCellValueFactory(
                new PropertyValueFactory<Employe, String>("nom"));

        TableColumn<Employe, String> adresseCol = new TableColumn<Employe, String>("Adresse");
        nomCol.setMinWidth(100);
        //specifier un "cell factory" pour cette colonne.
        adresseCol.setCellValueFactory(
                new PropertyValueFactory<Employe, String>("adresse"));

        TableColumn<Employe, String> telCol = new TableColumn<Employe, String>("Téléphone");
        telCol.setMinWidth(100);
        //specifier un "cell factory" pour cette colonne.
        telCol.setCellValueFactory(
                new PropertyValueFactory<Employe, String>("telephone"));

        TableColumn<Employe, Double> salaireCol =
                new TableColumn<Employe, Double>("Salaire");
        salaireCol.setMinWidth(100);
        //specifier un "cell factory" pour cette colonne.
        salaireCol.setCellValueFactory(
                new PropertyValueFactory<Employe, Double>("salaire"));

        //On ajoute les cinq colonnes à la table
        table.getColumns().addAll(numeroCol, nomCol, adresseCol,telCol,salaireCol);

        table.setItems(data);



        //On place le label et la table dans une VBox
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table);

        Scene scene = new Scene(vbox);
        primaryStage.setTitle("TableView - Deuxième exercice");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Employe> getEmployeList(){
        String path = "src/day3/exercice4/employes.txt";
        LesEmployes lesEmployes = new LesEmployes(path);
        //lesEmployes.fabriqueVecteur();
        ObservableList<Employe> t = FXCollections.observableList(lesEmployes.fabriqueVecteur()) ;
        return t;
    }
}
