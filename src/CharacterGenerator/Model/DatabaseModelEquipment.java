package CharacterGenerator.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static CharacterGenerator.Model.DatabaseModel.connect;
import static CharacterGenerator.Model.DatabaseModel.connection;

public class DatabaseModelEquipment {

    public void insertEquipment(Equipment equipment) {

        try {

            String sql = "INSERT INTO equipment (name, description, type, attack, defense) VALUES (?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, equipment.getEquipmentName());
            preparedStatement.setString(2, equipment.getEquipmentDescription());
            preparedStatement.setString(3, equipment.getEquipmentType());
            preparedStatement.setInt(4, equipment.getEquipmentAttack());
            preparedStatement.setInt(5, equipment.getEquipmentDefense());

            preparedStatement.execute();
            System.out.println("Equipment added!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static ObservableList<Equipment> getAllEntries() throws SQLException {

        connect();

        ObservableList<Equipment> equipmentObservableList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM equipment";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            String equipmentName = resultSet.getString("name");
            String equipmentDescription = resultSet.getString("description");
            String equipmentType = resultSet.getString("type");
            int equipmentAttack = resultSet.getInt("attack");
            int equipmentDefense = resultSet.getInt("defense");
            Equipment equipment = new Equipment(equipmentName,equipmentDescription,equipmentType,equipmentAttack,equipmentDefense);
            equipmentObservableList.add(equipment);
        }

        return equipmentObservableList;

    }

}
