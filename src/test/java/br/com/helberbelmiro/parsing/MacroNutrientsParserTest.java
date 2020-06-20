package br.com.helberbelmiro.parsing;

import br.com.helberbelmiro.model.MacroNutrients;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class MacroNutrientsParserTest {

    @Inject
    MacroNutrientsParser macroNutrientsParser;

    @Test
    void parse() {
        final String line = "6600301 Castanha portuguesa 99 Não se aplica 131,00 2,00 1,38 27,76 4,14";

        final MacroNutrients macroNutrients = this.macroNutrientsParser.parse(line);

        final MacroNutrients expected = MacroNutrients.builder()
                                                      .withEnergy(new BigDecimal("131.00"))
                                                      .withProtein(new BigDecimal("2.00"))
                                                      .withLipids(new BigDecimal("1.38"))
                                                      .withCarbs(new BigDecimal("27.76"))
                                                      .withDietaryFibre(new BigDecimal("4.14"))
                                                      .build();

        assertEquals(expected, macroNutrients);
    }

}