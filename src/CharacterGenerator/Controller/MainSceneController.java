package CharacterGenerator.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

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

}
