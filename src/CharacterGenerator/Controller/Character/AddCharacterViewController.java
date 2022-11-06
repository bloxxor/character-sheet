package CharacterGenerator.Controller.Character;

import CharacterGenerator.CharacterGenerator;
import CharacterGenerator.Model.*;
import CharacterGenerator.Model.Character;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static CharacterGenerator.Model.DatabaseModel.connect;
import static CharacterGenerator.Model.DatabaseModel.connection;

public class AddCharacterViewController {

    public Button insertCharacterButton;
    public TextField enterCharacterName;
    public TextArea enterCharacterDescription;
    public ListView<Object> selectEquipmentListView = new ListView<>();
    public TextField enterCharacterStrength;
    public TextField enterCharacterDexterity;

    ObservableList<Equipment> equipmentObservableList = FXCollections.observableArrayList();

    public void insertCharacterButtonClick(ActionEvent actionEvent) throws SQLException {

        String characterName = enterCharacterName.getText();
        String characterDescription = enterCharacterDescription.getText();
        int characterStrength = Integer.parseInt(enterCharacterStrength.getText());
        int characterDexterity = Integer.parseInt(enterCharacterDexterity.getText());

        Character character = new Character(characterName, characterDescription, characterStrength, characterDexterity);
        DatabaseModel.connect();
        CharacterGenerator.instance.dbInsertCharacter.insertCharacter(character);


        equipmentObservableList = DatabaseModelEquipment.getAllEntries();
        //tableCharacter.setItems(characterObservableList);
        System.out.println(selectEquipmentListView.getSelectionModel().getSelectedItems());

    }

    public void initialize() throws SQLException {

        connect();

        String sql = "SELECT * FROM equipment";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            String equipmentName = resultSet.getString("name");
            String equipmentDescription = resultSet.getString("description");
            String equipmentType = resultSet.getString("type");
            int equipmentAttack = resultSet.getInt("attack");
            int equipmentDefense = resultSet.getInt("defense");
            int equipmentId = resultSet.getInt("id");

            // Equipment equipment = new Equipment(equipmentName, equipmentDescription, equipmentType, equipmentAttack, equipmentDefense);

            selectEquipmentListView.getItems().add(equipmentName + " " + equipmentId );

        }

    }

}
