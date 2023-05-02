package day3.exercice2;

import day3.exercice1.Personne;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewEx3V2 extends Application {

    //La méthode createPersonList() est définie en fin de fichier
    ObservableList<Personne> data =createPersonList();
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Ajout du Button Récupérer
        Button recupererButton = new Button("Récupérer Sélection");

        // Creation du Label
        Label contentItems = new Label("");

        // Creation de la ListView
        ListView<Personne> personnes = new ListView<>();
        personnes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        personnes.setEditable(true);
        // spécifier la taille de la liste
        personnes.setPrefSize(150, 200);
        // Remplir la ListView
        personnes.setItems(data);

        recupererButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                StringBuffer sb = new StringBuffer();
                //On récupère les items sélectionnées sous forme de liste
                ObservableList<Personne> selectedItems =
                        personnes.getSelectionModel().getSelectedItems();
                // Affichage des items sélectionné dans le label resultat.
                for (int i = 0; i < selectedItems.size(); i++)
                    sb.append("\n " + selectedItems.get(i).toString());
                contentItems.setText("Les items sélectionnés : " + sb.toString());
            } });
        // Creation du VBox Selection
        VBox selection = new VBox();
        selection.setSpacing(20);
        //Ajouter le label et la listView dans le VBox
        selection.getChildren().addAll(personnes);

        // Creation d'un VBox pour le noeud racine
        HBox firstLine = new HBox();
        HBox secondLine = new HBox();

        VBox contentRoot = new VBox();
        secondLine.getChildren().add(contentItems);

        firstLine.setSpacing(10);

        firstLine.setAlignment(Pos.CENTER);
        // Ajouter le VBox selection et le TextArea resultat dans la VBox racine
        firstLine.getChildren().addAll(selection, recupererButton);

        contentRoot.getChildren().addAll(firstLine, secondLine);

        contentRoot.setMinWidth(200);
        contentRoot.setMinHeight(300);
        // Set the Style-properties of the VBox
        contentRoot.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        //Création de la scène
        Scene scene = new Scene(contentRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion d'une liste de personne");
        primaryStage.show();
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
