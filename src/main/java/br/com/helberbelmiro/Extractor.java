package br.com.helberbelmiro;

import br.com.helberbelmiro.reader.PageReader;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class Extractor {

    private static final File FILE = new File("src/main/resources/META-INF/resources/taco/liv50002.pdf");

    private static final Pattern LINE_BREAK = Pattern.compile("\n\r");

    public static void main(String[] args) throws IOException {
        PageReader reader = new PageReader(FILE);

        final String pageText = reader.readText(42);

        Stream.of(LINE_BREAK.split(pageText))
              .forEach(System.out::println);
    }

}
