package CharacterGenerator;

import CharacterGenerator.Model.DatabaseModel;
import CharacterGenerator.Model.DatabaseModelCharacter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class CharacterGenerator extends Application {

    public static CharacterGenerator instance;

    public DatabaseModelCharacter dbInsertCharacter = new DatabaseModelCharacter();

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
        setIcon();

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

    public void setIcon() {
        InputStream iconStream = getClass().getResourceAsStream("/images/favicon.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);
    }

}