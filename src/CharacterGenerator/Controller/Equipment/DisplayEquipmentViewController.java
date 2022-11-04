package CharacterGenerator.Controller.Equipment;

import CharacterGenerator.Model.DatabaseModelEquipment;
import CharacterGenerator.Model.Equipment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class DisplayEquipmentViewController {

    @FXML
    private TableView<Equipment> tableEquipment;
    @FXML
    private TableColumn<Equipment, String> equipmentName;
    @FXML
    private TableColumn<Equipment, String> equipmentDescription;
    @FXML
    private TableColumn<Equipment, String> equipmentType;
    @FXML
    private TableColumn<Equipment, Integer> equipmentAttack;
    @FXML
    private TableColumn<Equipment, Integer> equipmentDefense;

    ObservableList<Equipment> equipmentObservableList = FXCollections.observableArrayList();

    public void initialize() throws SQLException {

        equipmentName.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equipmentName"));
        equipmentDescription.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equipmentDescription"));
        equipmentType.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equipmentType"));
        equipmentAttack.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("equipmentAttack"));
        equipmentDefense.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("equipmentDefense"));

        equipmentObservableList = DatabaseModelEquipment.getAllEntries();
        tableEquipment.setItems(equipmentObservableList);

    }

}
