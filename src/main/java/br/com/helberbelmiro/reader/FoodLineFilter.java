package br.com.helberbelmiro.reader;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FoodLineFilter {

    public List<String> filter(List<String> lines) {
        return lines.stream()
                    .filter(line -> line.matches("^[0-9]{7}\\s.*"))
                    .collect(Collectors.toUnmodifiableList());
    }

}
