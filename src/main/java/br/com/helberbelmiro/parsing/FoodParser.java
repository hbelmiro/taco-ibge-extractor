package br.com.helberbelmiro.parsing;

import br.com.helberbelmiro.model.Food;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.text.MessageFormat;

@ApplicationScoped
public class FoodParser {

    @Inject
    private MacroNutrientsParser macroNutrientsParser;

    @Inject
    private PreparationParser preparationParser;

    public boolean isFoodLine(String line) {
        return line.matches("^[0-9]{7}\\s.*");
    }

    public Food parse(String line) {
        if (line.matches("^[0-9]{7}\\s.*")) {
            return Food.builder()
                       .withCode(parseCode(line))
                       .withDescription(parseDescription(line))
                       .withPreparation(preparationParser.parse(line))
                       .withMacroNutrients(macroNutrientsParser.parse(line))
                       .build();
        } else {
            throw new IllegalArgumentException(MessageFormat.format("Invalid food line: [{0}]", line));
        }
    }

    private String parseDescription(String line) {
        return line.substring(8, preparationParser.getPreparationStartIndex(line) - 1);
    }

    private static Integer parseCode(String line) {
        return Integer.valueOf(line.substring(0, 7));
    }

}
