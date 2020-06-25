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

    public Food parse(String line) {
        if (line.matches("^[0-9]{7}\\s.*")) {
            return Food.builder()
                       .withCode(parseCode(line))
                       .withPreparation(this.preparationParser.parse(line))
                       .withMacroNutrients(this.macroNutrientsParser.parse(line))
                       .build();
        } else {
            throw new IllegalArgumentException(MessageFormat.format("Invalid food line: [{0}]", line));
        }
    }

    private Integer parseCode(String line) {
        return Integer.valueOf(line.substring(0, 7));
    }

}
