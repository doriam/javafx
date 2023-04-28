package day1.menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MenuEx2 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label();

        Circle circle = new Circle();
        circle.setRadius(80);
        circle.setFill(Color.AQUA);

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);

        root.getChildren().addAll(label, circle);

        // Création d'un day1.menu contextuel
        ContextMenu contextMenu = new ContextMenu();

        MenuItem item1 = new MenuItem("Changer la couleur de fond");
        MenuItem item2 = new MenuItem("Rétablir la couleur initiale");
        item1.setDisable(false);
        item2.setDisable(true);


        item1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                label.setText("Vous avez choisi le changement de la couleur de fond");
                circle.setFill(Color.BEIGE);
                    item1.setDisable(true);
                    item2.setDisable(false);
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                label.setText("Vous avez choisi de rétablir la couleur initiale");
                circle.setFill(Color.AQUA);
                item1.setDisable(false);
                item2.setDisable(true);
            }
        });

        // Ajouter les menuItems au ContextMenu
        contextMenu.getItems().addAll(item1, item2);

        // Quand l'utilisateur fait un click droit sur le cercle
        circle.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(circle, event.getScreenX(), event.getScreenY());
            }
        });

        Scene scene = new Scene(root, 400, 200);

        stage.setTitle("MenuEx4 - Menu contextuel");
        stage.setScene(scene);
        stage.show();
    }
}
