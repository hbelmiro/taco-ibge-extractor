package br.com.helberbelmiro.reader;

import br.com.helberbelmiro.model.Food;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PageReader {

    private final File file;

    public PageReader(File file) {
        this.file = file;
    }

    public List<Food> read(int pageNumber) {
        throw new RuntimeException("Not implemented");
    }

    public String readText(int pageNumber) throws IOException {
        try (PDDocument document = PDDocument.load(file)) {
            final PDFTextStripper reader = new PDFTextStripper();

            reader.setStartPage(pageNumber);
            reader.setEndPage(pageNumber);

            return reader.getText(document);
        }
    }

}
