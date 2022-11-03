package CharacterGenerator.Controller.Character;

import CharacterGenerator.Model.Character;
import CharacterGenerator.Model.DatabaseModelCharacter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class DisplayCharactersViewController {

    @FXML
    private TableView<Character> tableCharacter;
    @FXML
    private TableColumn<Character, String> characterName;
    @FXML
    private TableColumn<Character, String> characterDescription;

    ObservableList<Character> characterObservableList = FXCollections.observableArrayList();

    public void initialize() throws SQLException {

        characterName.setCellValueFactory(new PropertyValueFactory<Character, String>("characterName"));
        characterDescription.setCellValueFactory(new PropertyValueFactory<Character, String>("characterDescription"));

        characterObservableList = DatabaseModelCharacter.getAllEntries();
        tableCharacter.setItems(characterObservableList);

    }

    public void printSelectedCharacter(ActionEvent actionEvent) {

        Character character = tableCharacter.getSelectionModel().getSelectedItem();

        System.out.println(
                character.getCharacterName()
        );

    }

}
