package br.com.helberbelmiro.reader;

import br.com.helberbelmiro.parsing.FoodParser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class CategoryLineFilter {

    @Inject
    private FoodParser foodParser;

    public List<String> filter(List<String> lines) {
        String lastFoodLine = null;

        final List<String> categoryLines = new ArrayList<>();

        for (String line : lines) {
            if (!line.isBlank()) {
                if (foodParser.isFoodLine(line)) {
                    lastFoodLine = line;
                } else {
                    if (lastFoodLine != null) {
                        categoryLines.add(line);
                    }
                }
            }
        }

        return Collections.unmodifiableList(categoryLines);
    }

}
