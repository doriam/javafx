package day2.exercice2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Launcher extends Application {
    Scene scene1, scene2;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)  {

        // Création de MenuBar
        MenuBar menuBar = new MenuBar();

        // Creation des menus
        Menu fichierMenu = new Menu("Fichier");

        //Ce day1.menu aura un sous-day1.menu avec les options : copier, coller.
        Menu editionMenu = new Menu("Edition");
        Menu aideMenu = new Menu("Aide");

        // Creation des MenuItems du day1.menu Fichier
        MenuItem nouveauItem = new MenuItem("Nouveau");
        MenuItem ouvrirItem = new MenuItem("Ouvrir");

        MenuItem quitterItem = new MenuItem("Quitter");

        // Creation des MenuItems du day1.menu Edition
        MenuItem copierItem = new MenuItem("Copier");
        MenuItem collerItem = new MenuItem("Coller");

        // Ajouter les menuItems aux Menus
        fichierMenu.getItems().addAll(nouveauItem, ouvrirItem, quitterItem);
        editionMenu.getItems().addAll(copierItem, collerItem);

        // Ajouter les menus à la barre de menus
        menuBar.getMenus().addAll(fichierMenu, editionMenu, aideMenu);

        HBox hbox1 = new HBox();
        Label label = new Label();

        HBox hbox2 = new HBox();

        Button button = new Button("Retourner");

        hbox1.getChildren().add(label);
        hbox2.getChildren().add(button);


        ouvrirItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {

                //FileChooser fileChooser = new FileChooser();
                //String path = String.valueOf(fileChooser.showOpenDialog(stage));
                String path = "src/day2/exercice2/employes.txt";
                LesEmployes lesEmployes = new LesEmployes(path);
                label.setText(lesEmployes.fabriqueChaine());
            } });

        quitterItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                stage.close();
            } });

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(hbox1);
        root.setCenter(hbox2);

         scene2 = new Scene(root, 350, 200);


        //Spécification de Scene 2
        Label label2= new Label("Je suis sur la deuxième scène");

        Button button2= new Button("Cliquez pour aller sur Scene 1");
        StackPane button2SPane = new StackPane();
        button2SPane.getChildren().add(button2);

        VBox layout2= new VBox(20);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(label2, button2SPane);

        scene1= new Scene(layout2,300,240);

        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                stage.setScene(scene1);
            } });


        //Méthode 4
        button2.setOnAction(new EventHandler<ActionEvent> () {
            public void handle(ActionEvent ae) {
                stage.setScene(scene2);
            } }
        );


        stage.setTitle("Choisissez un document");
        stage.setScene(scene1);
        stage.show();
    }


}
