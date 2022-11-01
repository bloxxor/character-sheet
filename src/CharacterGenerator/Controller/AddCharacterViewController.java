package CharacterGenerator.Controller;

import CharacterGenerator.CharacterGenerator;
import CharacterGenerator.Model.Character;
import CharacterGenerator.Model.DatabaseModel;
import CharacterGenerator.Model.DatabaseModelCharacter;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCharacterViewController {

    public Button insertCharacterButton;
    public TextField enterCharacterName;

    public void insertCharacterButtonClick(ActionEvent actionEvent) {
        String characterName = enterCharacterName.getText();
        Character character = new Character(characterName);
        DatabaseModel.connect();
        CharacterGenerator.instance.dbInsertCharacter.insertCharacter(character);

//        DatabaseModelCharacter
//        Character.instance.db.insertEntry(character);
//        Character
    }

}
