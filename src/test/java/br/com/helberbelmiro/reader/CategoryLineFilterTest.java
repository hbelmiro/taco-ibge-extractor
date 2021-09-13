package br.com.helberbelmiro.reader;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class CategoryLineFilterTest {

    @Inject
    CategoryLineFilter categoryLineFilter;

    @Test
    void filter() {
        final List<String> linesToFilter = List.of(
                "Carboi-",
                "drato",
                "(g)",
                "Fibra",
                "alimentar",
                "total (g)",
                "Código e descrição do alimento Código e descrição da preparação",
                "Tabela 1 - Energia, macronutrientes e fibra na composição de alimentos por 100 gramas de parte comestível",
                "6600101 Coco-da-baía (seco ou verde) 99 Não se aplica 354,00 3,33 33,49 15,23 9,00",
                "6600301 Castanha portuguesa 99 Não se aplica 131,00 2,00 1,38 27,76 4,14",
                "6600401 Pinhão 99 Não se aplica 174,37 2,98 0,75 43,92 15,60",
                "6600501 Amêndoa 99 Não se aplica 578,00 21,26 50,64 19,74 11,80",
                "6600601 Avelã 99 Não se aplica 628,00 14,95 60,75 16,70 9,70",
                "Cocos, castanhas e nozes",
                "Hortaliças folhosas, frutosas e outras",
                "",
                ""
        );

        assertThat(categoryLineFilter.filter(linesToFilter))
                .containsExactly(
                        "Cocos, castanhas e nozes",
                        "Hortaliças folhosas, frutosas e outras"
                );
    }

}