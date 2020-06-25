package br.com.helberbelmiro.parsing;

import br.com.helberbelmiro.model.MacroNutrients;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.*;

@ApplicationScoped
public class MacroNutrientsParser {

    public int getMacroNutrientsStartIndex(String line) {
        final List<String> splittedLine = Arrays.asList(line.split(" "));

        Collections.reverse(splittedLine);

        final String macronutrientsString = String.join(
                " ",
                splittedLine.get(4),
                splittedLine.get(3),
                splittedLine.get(2),
                splittedLine.get(1),
                splittedLine.get(0)
        );

        return line.indexOf(macronutrientsString);
    }

    public MacroNutrients parse(String line) {
        final List<String> splittedLine = Arrays.asList(line.split(" "));

        Collections.reverse(splittedLine);

        return MacroNutrients.builder()
                             .withDietaryFibre(new BigDecimal(splittedLine.get(0).replace(",", ".")))
                             .withCarbs(new BigDecimal(splittedLine.get(1).replace(",", ".")))
                             .withLipids(new BigDecimal(splittedLine.get(2).replace(",", ".")))
                             .withProtein(new BigDecimal(splittedLine.get(3).replace(",", ".")))
                             .withEnergy(new BigDecimal(splittedLine.get(4).replace(",", ".")))
                             .build();
    }

}
