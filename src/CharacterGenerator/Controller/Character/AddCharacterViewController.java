package CharacterGenerator.Controller.Character;

import CharacterGenerator.CharacterGenerator;
import CharacterGenerator.Model.Character;
import CharacterGenerator.Model.DatabaseModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddCharacterViewController {

    public Button insertCharacterButton;
    public TextField enterCharacterName;
    public TextArea enterCharacterDescription;

    public void insertCharacterButtonClick(ActionEvent actionEvent) {

        String characterName = enterCharacterName.getText();
        String characterDescription = enterCharacterDescription.getText();
        Character character = new Character(characterName, characterDescription);
        DatabaseModel.connect();
        CharacterGenerator.instance.dbInsertCharacter.insertCharacter(character);

    }

}
