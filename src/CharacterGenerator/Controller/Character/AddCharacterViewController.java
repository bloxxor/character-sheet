package CharacterGenerator.Controller.Character;

import CharacterGenerator.CharacterGenerator;
import CharacterGenerator.Model.Character;
import CharacterGenerator.Model.DatabaseModel;
import CharacterGenerator.Model.Equipment;
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
    //    public ComboBox<Equipment> selectEquipmentComboBox;
    public ComboBox<Equipment> selectEquipmentComboBox;
    public ListView<Object> selectEquipmentListView = new ListView<>();

    ObservableList<Equipment> equipmentObservableList = FXCollections.observableArrayList();

    public void insertCharacterButtonClick(ActionEvent actionEvent) {

        String characterName = enterCharacterName.getText();
        String characterDescription = enterCharacterDescription.getText();
        Character character = new Character(characterName, characterDescription);
        DatabaseModel.connect();
        CharacterGenerator.instance.dbInsertCharacter.insertCharacter(character);

    }

    public void fillComboBox(MouseEvent mouseEvent) throws SQLException {

        ComboBox<Equipment> comboBox = new ComboBox<>();
//        comboBox.getItems().add(ObservableList<Equipment>);
        //comboBox.getItems().add(new Equipment("1","2","3",4,5));

        connect();

        ObservableList<Equipment> equipmentObservableList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM equipment";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String equipmentName = resultSet.getString("name");
            String equipmentDescription = resultSet.getString("description");
            String equipmentType = resultSet.getString("type");
            int equipmentAttack = resultSet.getInt("attack");
            int equipmentDefense = resultSet.getInt("defense");
            Equipment equipment = new Equipment(equipmentName, equipmentDescription, equipmentType, equipmentAttack, equipmentDefense);
            //equipmentObservableList.add(equipment);
            comboBox.getItems().add(equipment);
        }

        // Terminal Test
//        System.out.println(
//                comboBox.getItems().set(0, new Equipment("1","2","3",4,5))
//        );

    }

    public void fillListView() throws SQLException {

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
