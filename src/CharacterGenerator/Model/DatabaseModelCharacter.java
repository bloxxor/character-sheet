package CharacterGenerator.Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DatabaseModelCharacter {

    public void insertCharacter(Character character) {

        try {

            // SQL Query - prepared statement
            String sql = "INSERT INTO charactergenerator (name) VALUES (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, burgerRecipe.getRecipetitle());
            preparedStatement.setInt(2, burgerRecipe.getRecipeCookingTime());
            preparedStatement.setString(3, burgerRecipe.getRecipeIngredients());

            preparedStatement.execute();
            System.out.println("Datensatz wurde eingefügt.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
