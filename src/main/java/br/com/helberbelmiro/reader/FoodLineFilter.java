package br.com.helberbelmiro.reader;

import br.com.helberbelmiro.parsing.FoodParser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FoodLineFilter {

    @Inject
    private FoodParser foodParser;

    public List<String> filter(List<String> lines) {
        return lines.stream()
                    .filter(foodParser::isFoodLine)
                    .collect(Collectors.toUnmodifiableList());
    }

}
