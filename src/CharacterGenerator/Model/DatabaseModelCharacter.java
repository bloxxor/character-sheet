package CharacterGenerator.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static CharacterGenerator.Model.DatabaseModel.connect;
import static CharacterGenerator.Model.DatabaseModel.connection;

public class DatabaseModelCharacter {

    public void insertCharacter(Character character) {

        try {

            // SQL Query - prepared statement
            String sql = "INSERT INTO characters (name, description) VALUES (?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, character.getCharacterName());
            preparedStatement.setString(2, character.getCharacterDescription());

            preparedStatement.execute();
            System.out.println("Datensatz wurde eingefügt.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static ObservableList<Character> getAllEntries() throws SQLException {

        connect();

        ObservableList<Character> characterObservableList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM characters";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            String characterName = resultSet.getString("name");
            String characterDescription = resultSet.getString("description");
            Character character = new Character(characterName, characterDescription);
            characterObservableList.add(character);
        }

        return characterObservableList;

    }

}
