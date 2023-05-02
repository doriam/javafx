package day3.exercice1;

import day2.exercice2.LesEmployes;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class ListViewEx3V1 extends Application {

    // Variables d'instance
    TextArea resultat;
    //La méthode createPersonList() est définie en fin de fichier
    ObservableList<Personne> data =createPersonList();

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        // Creation du TextArea resultat
        resultat = new TextArea();
        resultat.setMaxWidth(350);
        resultat.setMaxHeight(350);

        // Creation du Label
        Label personneLbl = new Label("Sélectionnez une personne dans la liste : ");

        // Creation de la ListView
        ListView<Personne> personnes = new ListView<>();

        //
        personnes.setEditable(true);
        // spécifier la taille de la liste
        personnes.setPrefSize(150, 120);
        // Remplir la ListView
        personnes.setItems(data);

        // ======Add a custom cell factory to display formatted names of persons
        // persons.setCellFactory(new PersonneCellFactory());

        //Mettre à jour le TextArea resultat quand l'item sélectionné change
        personnes.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Personne>()
                {
                    public void changed(ObservableValue<? extends Personne> ov,
                                        final Personne oldValue, final Personne newValue)
                    {
                        String oldText = oldValue == null ? "null" : oldValue.toString();
                        String newText = newValue == null ? "null" : newValue.toString();

                        resultat.appendText("Change: old = " + oldText + ", new = " + newText + "\n");

                    }
                });

        // Creation du VBox Selection
        VBox selection = new VBox();
        selection.setSpacing(20);
        //Ajouter le label et la listView dans le VBox
        selection.getChildren().addAll(personneLbl, personnes);

        // Creation d'un VBox pour le noeud racine
        VBox root = new VBox();
        root.setSpacing(10);

        HBox hBox = new HBox();

        TextField prenom = new TextField();
        prenom.setPromptText("Prenom");

        TextField nom = new TextField();
        nom.setPromptText("Nom");
        Button ajouter = new Button("Ajouter");

        ajouter.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(!prenom.getText().equals("") && !nom.getText().equals("")){
                    Personne personne = new Personne(prenom.getText(), nom.getText());
                    data.add(personne);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Veuillez saisir un nom et un prénom");
                }
            } });

        Button supprimer = new Button("Supprimer");

        supprimer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
            Personne personne = personnes.getSelectionModel().getSelectedItem();
                data.remove(personne);
            } });

        hBox.setSpacing(5);
        hBox.getChildren().addAll(prenom, nom, ajouter, supprimer);

        // Ajouter le VBox selection et le TextArea resultat dans la VBox racine
        root.getChildren().addAll(selection, resultat, hBox);

        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        //Création de la scène
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Gestion d'une liste de personne");
        stage.show();
    }

    // Création de la liste de personnes
    private ObservableList<Personne> createPersonList() {

        Personne person1 = new Personne("Louis", "Blériot");
        Personne person2 = new Personne("Jean", "Mermoz");
        Personne person3 = new Personne("Roland", "Garros");
        Personne person4 = new Personne("Antoine", "de Saint-Exupéry");
        Personne person5 = new Personne("Hélène", "Boucher");
        Personne person6 = new Personne("Maryse", "Bastié");

        ObservableList<Personne> list = FXCollections.observableArrayList(person1, person2, person3, person4, person5,person6);
        return list;
    }

}
