package CharacterGenerator.Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
