package br.com.helberbelmiro.parsing;

import br.com.helberbelmiro.model.Food;

import java.util.List;

public class FoodParser {

    public Food parse(String line) {
        if (line.matches("^[0-9]{7}\\s.*")) {
            return Food.builder()
                       .withCode(parseCode(line))
                       .build();
        } else {
            throw new IllegalArgumentException("Invalid food line");
        }
    }

    private Integer parseCode(String line) {
        return Integer.valueOf(line.substring(0, 7));
    }

}
