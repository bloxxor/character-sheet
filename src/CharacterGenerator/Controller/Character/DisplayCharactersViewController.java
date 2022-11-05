package CharacterGenerator.Controller.Character;

import CharacterGenerator.Helper.FillFormFields;
import CharacterGenerator.Helper.PdfGen;
import CharacterGenerator.Model.Character;
import CharacterGenerator.Model.DatabaseModelCharacter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.sql.SQLException;

public class DisplayCharactersViewController {

    public static final String DEST = "./target/sandbox/tables/simple_table.pdf";

    @FXML
    private TableView<Character> tableCharacter;
    @FXML
    private TableColumn<Character, String> characterName;
    @FXML
    private TableColumn<Character, String> characterDescription;

    ObservableList<Character> characterObservableList = FXCollections.observableArrayList();

    public void initialize() throws SQLException {

        characterName.setCellValueFactory(new PropertyValueFactory<Character, String>("characterName"));
        characterDescription.setCellValueFactory(new PropertyValueFactory<Character, String>("characterDescription"));

        characterObservableList = DatabaseModelCharacter.getAllEntries();
        tableCharacter.setItems(characterObservableList);

    }

    public void printSelectedCharacter(ActionEvent actionEvent) throws Exception {

        Character character = tableCharacter.getSelectionModel().getSelectedItem();

        File file = new File(DEST);
        file.getParentFile().mkdirs();

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("./target/sandbox/tables/simple_table.pdf"));
        Document doc = new Document(pdfDoc);

        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();

        System.out.println(character.getCharacterName());

        for (int i = 0; i < 16; i++) {
            table.addCell("hi");
            table.addCell(character.getCharacterName());
        }

        doc.add(table);

        doc.close();

    }


}
