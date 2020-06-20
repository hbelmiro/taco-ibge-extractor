package br.com.helberbelmiro;

import br.com.helberbelmiro.reader.PageReader;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class Extractor {

    private static final File FILE = new File("/Users/helber/Desktop/ibge.pdf");

    public static void main(String[] args) throws IOException {
        PageReader reader = new PageReader(FILE);

        final String pageText = reader.readText(42);

        Stream.of(pageText.split("\n\r"))
              .forEach(System.out::println);
    }

}
