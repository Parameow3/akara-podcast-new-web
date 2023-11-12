package tech.akarahub.akara;/*-----------------------------------------------------------------------------------------
 * NAME : MainFormController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 *---------------------------------------------------------------------------------------*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/main/MainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 840);
        stage.setMaximized(true);
        stage.setMinHeight(840);
        stage.setMinWidth(1280);
        stage.setTitle("Akara Podcast");
        stage.setScene(scene);

        Image applicationIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Akara-logo.png")));
        stage.getIcons().add(applicationIcon);

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }


}