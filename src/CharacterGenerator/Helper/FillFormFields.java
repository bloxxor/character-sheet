package CharacterGenerator.Helper;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;

public class FillFormFields {
    public static final String DEST = "./target/sandbox/acroforms/fill_form_special_chars2.pdf";

    public static final String FONT = "./Resources/fonts/blackchancery.ttf";
    public static final String SRC = "./Resources/pdf/5E_CharacterSheetTemplate.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new FillFormFields().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {

        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(dest));
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);

        // This method tells to generate an appearance Stream while flattening for all form fields that don't have one.
        // Generating appearances will slow down form flattening,
        // but otherwise the results can be unexpected in Acrobat.
        form.setGenerateAppearance(true);

        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);

        // ӧ character is used here
        form.getField("CharacterName").setValue("Robin Hood").setFont(font);

        // If no fields have been explicitly included, then all fields are flattened.
        // Otherwise only the included fields are flattened.
        form.flattenFields();

        pdfDoc.close();

    }

}
