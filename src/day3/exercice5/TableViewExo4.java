package day3.exercice5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class TableViewExo4 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<Contact> data = getContactList();

        //Création de la table
        TableView<Contact> table = new TableView<Contact>();
        table.setEditable(true);

        Label label = new Label("Liste des contacts");
        label.setFont(new Font("Arial", 20));

        //Création des trois colonnes
        TableColumn<Contact, String> prenomCol =
                new TableColumn<Contact, String>("Prénom");
        prenomCol.setMinWidth(100);
        //specifier un "cell value factory" pour cette colonne.
        prenomCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("prenom"));
        //Réimplémenter la cellule comme un TextField
        prenomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        //Affecter la nouvelle valeur à la cellule
        prenomCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Contact, String>>() {
                    @Override
                    public void handle(CellEditEvent<Contact, String> event) {
                        ((Contact) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setPrenom(event.getNewValue());
                    }
                }
        );


        TableColumn<Contact, String> nomCol = new TableColumn<Contact, String>("Nom");
        nomCol.setMinWidth(100);
        //spécifier une préférence de tri pour cette colonne
        nomCol.setSortType(TableColumn.SortType.ASCENDING);
        //specifier un "cell value factory" pour cette colonne.
        nomCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("nom"));
        //Réimplémenter la cellule comme un TextField
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        //Affecter la nouvelle valeur à la cellule
        nomCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Contact, String>>() {
                    @Override
                    public void handle(CellEditEvent<Contact, String> event) {
                        ((Contact) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setNom(event.getNewValue());
                    }
                }
        );


        TableColumn<Contact, String> emailCol = new TableColumn<Contact, String>("Email");
        emailCol.setMinWidth(100);
        //specifier un "cell factory" pour cette colonne.
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("email"));
        //Réimplémenter la cellule comme un TextField
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        //Affecter la nouvelle valeur à la cellule
        emailCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Contact, String>>() {
                    @Override
                    public void handle(CellEditEvent<Contact, String> event) {
                        ((Contact) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setEmail(event.getNewValue());
                    }
                }
        );

        //On ajoute les trois colonnes à la table
        table.getColumns().addAll(prenomCol, nomCol, emailCol);
        table.setItems(data);




        //On place le label et la table dans une VBox
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));

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


        vbox.getChildren().addAll(label, table, hBox);


        Scene scene = new Scene(vbox);
        primaryStage.setTitle("TableView - Cellules editables");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private ObservableList<Contact> getContactList() {

        Contact contact1 = new Contact("Louis", "Blèriot", "bleriot@gmail.com");
        Contact contact2 = new Contact("Hélène", "Boucher", "boucher@gmail.com");
        Contact contact3 = new Contact("Jean", "Mermoz", "mermoz@gmail.com");
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
