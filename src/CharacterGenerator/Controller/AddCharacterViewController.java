package CharacterGenerator.Controller;

import CharacterGenerator.Model.Character;
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
        //Character.instance.db.insertEntry(recipe);
    }

}
