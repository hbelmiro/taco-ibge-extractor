package br.com.helberbelmiro.parsing;

import br.com.helberbelmiro.model.Food;

import java.text.MessageFormat;

public class FoodParser {

    public Food parse(String line) {
        if (line.matches("^[0-9]{7}\\s.*")) {
            return Food.builder()
                       .withCode(parseCode(line))
                       .build();
        } else {
            throw new IllegalArgumentException(MessageFormat.format("Invalid food line: [{0}]", line));
        }
    }

    private Integer parseCode(String line) {
        return Integer.valueOf(line.substring(0, 7));
    }

}
