package br.com.helberbelmiro.parsing;

import br.com.helberbelmiro.model.Preparation;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.inject.Inject;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class PreparationParserTest {

    @Inject
    PreparationParser preparationParser;

    @ParameterizedTest
    @MethodSource("parseSource")
    void parse(String line, Preparation expected) {
        final Preparation preparation = this.preparationParser.parse(line);

        assertEquals(expected, preparation);
    }

    private static Stream<Arguments> parseSource() {
        return Stream.of(
                Arguments.of(
                        "6600301 Castanha portuguesa 99 Não se aplica 131,00 2,00 1,38 27,76 4,14",
                        Preparation.builder()
                                   .withCode(99)
                                   .withDescription("Não se aplica")
                                   .build()
                ),
                Arguments.of(
                        "6600301 Castanha 55 portuguesa 99 Não se aplica 131,00 2,00 1,38 27,76 4,14",
                        Preparation.builder()
                                   .withCode(99)
                                   .withDescription("Não se aplica")
                                   .build()
                ),
                Arguments.of(
                        "6600301 Castanha 22 vermelha 55 portuguesa 99 Não se aplica 131,00 2,00 1,38 27,76 4,14",
                        Preparation.builder()
                                   .withCode(99)
                                   .withDescription("Não se aplica")
                                   .build()
                ),
                Arguments.of(
                        "6600301 Castanha 22 vermelha 55 portuguesa 6 Copo 131,00 2,00 1,38 27,76 4,14",
                        Preparation.builder()
                                   .withCode(6)
                                   .withDescription("Copo")
                                   .build()
                ),
                Arguments.of(
                        "6600301 Castanha 22 vermelha 55 portuguesa 8 Colher de Sopa 131,00 2,00 1,38 27,76 4,14",
                        Preparation.builder()
                                   .withCode(8)
                                   .withDescription("Colher de Sopa")
                                   .build()
                )
        );
    }

}