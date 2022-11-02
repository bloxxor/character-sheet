package CharacterGenerator.Controller;

import CharacterGenerator.CharacterGenerator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class MainSceneController {

    public void onMenuCloseClick(ActionEvent actionEvent) {

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Exit CharacterGenerator?",
                ButtonType.OK,
                ButtonType.CANCEL
        );

        alert.showAndWait();

        if( alert.getResult() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }

    }

    public void onMenuAboutClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //alert.setTitle("Character Generator");
        //alert.setHeaderText("By");
        alert.setContentText("Content Text");
        alert.setGraphic(null);
        alert.show();
    }

    public void onMenuAddCharacterClick(ActionEvent actionEvent) throws IOException {
        CharacterGenerator.instance.loadScene("Character/AddCharacterView.fxml");
    }

    public void onMenuDisplayCharactersClick(ActionEvent actionEvent) throws IOException {
        CharacterGenerator.instance.loadScene("Character/DisplayCharactersView.fxml");
    }

}
