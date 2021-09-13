package br.com.helberbelmiro.parsing;

import br.com.helberbelmiro.model.Food;
import br.com.helberbelmiro.model.MacroNutrients;
import br.com.helberbelmiro.model.Preparation;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class FoodParserTest {

    @Inject
    FoodParser foodParser;

    private static Stream<Arguments> parseSource() {
        return Stream.of(
                Arguments.of(
                        "6600301 Castanha portuguesa 99 Não se aplica 131,00 2,00 1,38 27,76 4,14",
                        Food.builder()
                            .withCode(6600301)
                            .withDescription("Castanha portuguesa")
                            .withPreparation(Preparation.builder()
                                                        .withCode(99)
                                                        .withDescription("Não se aplica")
                                                        .build())
                            .withMacroNutrients(MacroNutrients.builder()
                                                              .withEnergy(new BigDecimal("131.00"))
                                                              .withProtein(new BigDecimal("2.00"))
                                                              .withLipids(new BigDecimal("1.38"))
                                                              .withCarbs(new BigDecimal("27.76"))
                                                              .withDietaryFibre(new BigDecimal("4.14"))
                                                              .build())
                            .build()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parseSource")
    void parse(String line, Food expectedFood) {
        assertEquals(expectedFood, foodParser.parse(line));
    }

}