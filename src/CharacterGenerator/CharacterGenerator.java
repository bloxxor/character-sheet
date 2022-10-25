package CharacterGenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CharacterGenerator extends Application {

    public static CharacterGenerator instance;

    Stage primaryStage;

    BorderPane rootLayout;

    public static void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;
        instance = this;

        primaryStage.setTitle("Character Generator");
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);
        primaryStage.setResizable(false);

        initRootLayout();
        loadScene("WelcomeView.fxml");

        primaryStage.show();

    }

    public void initRootLayout() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/CharacterGenerator/View/MainScene.fxml"));

        rootLayout = fxmlLoader.load();
        Scene primaryScene = new Scene(rootLayout);
        primaryStage.setScene(primaryScene);

    }

    public void loadScene(String sceneToLoad) throws IOException {

        rootLayout.getChildren().remove(rootLayout.getCenter());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/CharacterGenerator/View/" + sceneToLoad));

        Pane pane = loader.load();
        rootLayout.setCenter(pane);

    }

}