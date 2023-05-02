package day3.exercice6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NouvelleFenetreApplicationModal extends Application {

	@Override
	public void start(Stage primaryStage) {

		Button btnOuvrir = new Button();
		btnOuvrir.setText("Cliquez ici pour ouvrir une nouvelle fenêtre");
		btnOuvrir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//Construction de la nouvelle fenêtre
				// Ceci pourrait être placé dans une classe séparée
				Label nouvFenetreLbl = new Label("Vous êtes sur la nouvelle fenêtre");
				StackPane nouvFenetreSPane = new StackPane();
				nouvFenetreSPane.getChildren().add(nouvFenetreLbl);
				Scene nouvFenetreScene = new Scene(nouvFenetreSPane, 230, 100);
				// Nouvelle Fenêtre (Stage)
				Stage nouvFenetre = new Stage();
				nouvFenetre.setTitle("Nouvelle Fenêtre");
				nouvFenetre.setScene(nouvFenetreScene);
				// Spécification de la position de la nouvelle fenetre 
				//relativement à la fenetre principale.
				nouvFenetre.setX(primaryStage.getX() + 200);
				nouvFenetre.setY(primaryStage.getY() + 100);			
				//Spécification du mode d'affichage

				//Cela bloque toooooooutes les fênetres
				nouvFenetre.initModality(Modality.APPLICATION_MODAL);
				//Autres modes
				//nouvFenetre.initModality(Modality.WINDOW_MODAL);
				//nouvFenetre.initModality(Modality.NONE);
				// Spécification de la fenêtre parente de cette fenêtre
				//Cette option est obligatoire pour bien vérouiller la fenêtre parente
				nouvFenetre.initOwner(primaryStage);
				//Affichage de la nouvelle fenêtre
				nouvFenetre.show();
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(btnOuvrir);

		Scene scene = new Scene(root, 450, 250);

		primaryStage.setTitle("Exemple ouverture Fenêtre en mode APPLICATION_MODAL");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}


