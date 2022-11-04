package CharacterGenerator.Controller.Equipment;

import CharacterGenerator.CharacterGenerator;
import CharacterGenerator.Model.DatabaseModel;
import CharacterGenerator.Model.Equipment;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEquipmentViewController {
    public TextField enterEquipmentName;
    public TextField enterEquipmentType;
    public TextField enterEquipmentAttack;
    public TextField enterEquipmentDefense;
    public TextArea enterEquipmentDescription;
    public Button insertEquipmentButton;

    public void insertEquipmentButtonClick(ActionEvent actionEvent) {

        String equipmentName = enterEquipmentName.getText();
        String equipmentType = enterEquipmentType.getText();
        String equipmentDescription = enterEquipmentDescription.getText();
        int equipmentAttack = Integer.parseInt(enterEquipmentAttack.getText());
        int equipmentDefense = Integer.parseInt(enterEquipmentDefense.getText());

        Equipment equipment = new Equipment(equipmentName, equipmentDescription, equipmentType, equipmentAttack, equipmentDefense);
        DatabaseModel.connect();
        CharacterGenerator.instance.dbInsertEquipment.insertEquipment(equipment);

    }

}
