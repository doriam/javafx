package day1.login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class LoginForm extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        //créer une grille (GridPane Layout)
        GridPane grille = new GridPane();
        grille.setAlignment(Pos.CENTER);
        grille.setHgap(10);
        grille.setVgap(10);
        grille.setPadding(new Insets(20, 20, 20, 20));

        //Remplir la grille
        Text titre = new Text("Fenêtre d'Authentification");
        //titre.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        //Utilisé dans le fichier css pour identifier le noeud
        titre.setId("titreText");

        grille.add(titre, 0, 0, 2, 1 );

        Label login = new Label("Login:");

        grille.add(login, 0, 1);

        TextField loginTextField = new TextField();
        grille.add(loginTextField, 1, 1);

        Label pswd = new Label("Mot de passe :");
        grille.add(pswd, 0, 2);

        PasswordField pswdPasswordField = new PasswordField();
        grille.add(pswdPasswordField, 1, 2);

        //Ajout du bouton à la grille
        Button btn = new Button("Validez");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grille.add(hbBtn, 1, 4);
        
        //Ajout d'une zone de texte
        Text actionTexte = new Text();
        actionTexte.setId("actionTexte");
        grille.add(actionTexte, 1, 6);

        //Action Bouton
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actionTexte.setFill(Color.FIREBRICK);
                actionTexte.setText("Vérification en cours");
            }
        });

        //grille.setGridLinesVisible(true);

        Scene scene = new Scene(grille, 400, 350);
        scene.getStylesheets().add(getClass().getResource("loginForm.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Fenêtre d'Authentification");
        primaryStage.show();
    }
}
