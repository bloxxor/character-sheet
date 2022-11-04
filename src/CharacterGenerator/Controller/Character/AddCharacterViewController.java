package CharacterGenerator.Controller.Character;

import CharacterGenerator.CharacterGenerator;
import CharacterGenerator.Model.Character;
import CharacterGenerator.Model.DatabaseModel;
import CharacterGenerator.Model.Equipment;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddCharacterViewController {

    public Button insertCharacterButton;
    public TextField enterCharacterName;
    public TextArea enterCharacterDescription;
//    public ComboBox<Equipment> selectEquipmentComboBox;
    public ComboBox selectEquipmentComboBox;

    public void insertCharacterButtonClick(ActionEvent actionEvent) {

        String characterName = enterCharacterName.getText();
        String characterDescription = enterCharacterDescription.getText();
        Character character = new Character(characterName, characterDescription);
        DatabaseModel.connect();
        CharacterGenerator.instance.dbInsertCharacter.insertCharacter(character);

    }

    public void fillComboBox(MouseEvent mouseEvent) {
        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Choice 1");
        comboBox.getItems().add("Choice 2");
        comboBox.getItems().add("Choice 3");
//        ComboBox<Equipment> comboBox = new ComboBox<>();
//        comboBox.getItems().add(new Equipment("1","2","3",4,5));
//        comboBox.getItems().add(new Equipment("1","2","3",4,5));
//        System.out.println(comboBox);

    }
}
