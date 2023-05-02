package day3.exercice3;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.JOptionPane;


public class TableViewExo2 extends Application{

    ObservableList<Contact> data =getContactList();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Création de la table
        TableView<Contact> table = new TableView<>();
        table.setEditable(true);

        Label label = new Label("Liste des contacts");
        label.setFont(new Font("Arial", 20));

        //Création des trois colonnes
        TableColumn<Contact, String> prenomCol =
                new TableColumn<>("Prénom");
        prenomCol.setMinWidth(100);

        //Spécifier comment remplir la donnée pour chaque cellule de cette colonne
        //Ceci se fait en specifiant un "cell value factory" pour cette colonne.
        prenomCol.setCellValueFactory(
                new PropertyValueFactory<>("prenom"));

        TableColumn<Contact, String> nomCol = new TableColumn<>("Nom");
        nomCol.setMinWidth(100);
        //spécifier une préférence de tri pour cette colonne
        //nomCol.setSortType(TableColumn.SortType.ASCENDING);
        //nomCol.setSortType(TableColumn.SortType.DESCENDING);

        //Spécifier comment remplir la donnée pour chaque cellule de cette colonne
        //Ceci se fait en specifiant un "cell value factory" pour cette colonne.
        nomCol.setCellValueFactory(
                new PropertyValueFactory<>("nom"));

        TableColumn<Contact, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(100);
        //Spécifier comment remplir la donnée pour chaque cellule de cette colonne
        //Ceci se fait en specifiant un "cell value factory" pour cette colonne.
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        //On ajoute les trois colonnes à la table
        table.getColumns().addAll(prenomCol, nomCol, emailCol);

        //On rempli la table avec la liste observable
        table.setItems(data);

        HBox hBox = new HBox();

        TextField prenom = new TextField();
        prenom.setPromptText("Prenom");
        prenom.setPrefWidth(100);

        TextField nom = new TextField();
        nom.setPromptText("Nom");
        nom.setPrefWidth(100);

        TextField email = new TextField();
        email.setPromptText("Email");
        email.setPrefWidth(100);

        Button ajouter = new Button("Ajouter");
        ajouter.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(!prenom.getText().equals("") && !nom.getText().equals("") && !email.getText().equals("")){
                    Contact contact = new Contact(prenom.getText(), nom.getText(), email.getText());
                    data.add(contact);
                    clear(prenom, nom, email);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir correctement le formulaire.");
                }
            } });

        Button supprimer = new Button("Supprimer");
        supprimer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                Contact contact = table.getSelectionModel().getSelectedItem();
                if(contact != null){
                    data.remove(contact);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Il n'y a plus d'éléments dans la liste.");
                }
            } });
        hBox.setSpacing(5);
        hBox.getChildren().addAll(prenom, nom, email, ajouter, supprimer);

        //On place le label et la table dans une VBox
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table, hBox);




        Scene scene = new Scene(vbox);
        primaryStage.setTitle("TableView - Deuxième exercice");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Contact> getContactList() {

        Contact contact1 = new Contact("Louis", "bleriot", "bleriot@gmail.com");
        Contact contact2 = new Contact("Hélène", "boucher", "boucher@gmail.com");
        Contact contact3 = new Contact("Jean", "mermoz", "mermoz@gmail.com");
        ObservableList<Contact> list = FXCollections.observableArrayList(contact1,
                contact2, contact3);
        return list;
    }

    private void clear(TextField prenom, TextField nom, TextField email){
        prenom.setText("");
        nom.setText("");
        email.setText("");
    }
}
