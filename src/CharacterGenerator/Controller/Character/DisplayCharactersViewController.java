package CharacterGenerator.Controller.Character;

import CharacterGenerator.Model.Character;
import CharacterGenerator.Model.DatabaseModelCharacter;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
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


    @FXML
    private TableView<Character> tableCharacter;
    @FXML
    private TableColumn<Character, String> characterName;
    @FXML
    private TableColumn<Character, String> characterDescription;
    @FXML
    public TableColumn<Character, Integer> characterStrength;
    @FXML
    public TableColumn<Character, Integer> characterDexterity;

    ObservableList<Character> characterObservableList = FXCollections.observableArrayList();

    public void initialize() throws SQLException {

        characterName.setCellValueFactory(new PropertyValueFactory<Character, String>("characterName"));
        characterDescription.setCellValueFactory(new PropertyValueFactory<Character, String>("characterDescription"));
        characterDexterity.setCellValueFactory(new PropertyValueFactory<Character, Integer>("characterDexterity"));
        characterStrength.setCellValueFactory(new PropertyValueFactory<Character, Integer>("characterStrength"));

        characterObservableList = DatabaseModelCharacter.getAllEntries();
        tableCharacter.setItems(characterObservableList);

    }

    public void printSelectedCharacter(ActionEvent actionEvent) throws Exception {

        // Get selected Character from tableview
        Character character = tableCharacter.getSelectionModel().getSelectedItem();

        String SRC = "./Resources/pdf/5E_CharacterSheetTemplate.pdf";
        String DEST = "./target/" + character.getCharacterName() + ".pdf";
        String FONT = "./Resources/fonts/blackchancery.ttf";

        // Debug
        System.out.println(character.getCharacterName());

        File file = new File(DEST);
        file.getParentFile().mkdirs();

        PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(SRC),
                new PdfWriter(DEST)
        );

        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
        form.setGenerateAppearance(true);

        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);

        form.getField("CharacterName").setValue(character.getCharacterName()).setFont(font);
        form.getField("Background").setValue(character.getCharacterDescription()).setFont(font);
        form.getField("STR").setValue(String.valueOf(character.getCharacterDexterity())).setFont(font);
        form.getField("DEX").setValue(String.valueOf(character.getCharacterStrength())).setFont(font);

        form.flattenFields();

        pdfDoc.close();

    }

}
