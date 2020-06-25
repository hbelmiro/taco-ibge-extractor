package br.com.helberbelmiro.parsing;

import br.com.helberbelmiro.model.Preparation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ApplicationScoped
public class PreparationParser {

    @Inject
    private MacroNutrientsParser macroNutrientsParser;

    public int getPreparationStartIndex(String line) {
        return line.indexOf(extractPreparationText(line));
    }

    private String extractPreparationText(String line) {
        final int macroNutrientsStartIndex = macroNutrientsParser.getMacroNutrientsStartIndex(line);

        final String reversedlineWithoutMacroNutrients = new StringBuilder(line.substring(0, macroNutrientsStartIndex))
                .reverse().toString().trim();

        final Pattern pattern = Pattern.compile(".*?\\s[0-9]{1,2}\\s");

        final Matcher matcher = pattern.matcher(reversedlineWithoutMacroNutrients);

        if (matcher.find()) {
            return new StringBuilder(matcher.group()).reverse().toString().trim();
        } else {
            throw new IllegalArgumentException(MessageFormat.format("A Preparation could not be found in [{0}]", line));
        }
    }

    public Preparation parse(String line) {
        final String preparationText = extractPreparationText(line);

        final Pattern codePattern = Pattern.compile("[0-9]{1,2}");
        final Matcher codeMatcher = codePattern.matcher(preparationText);

        final Pattern descriptionPattern = Pattern.compile("(?<=[0-9]{1,2}\\s).*");
        final Matcher descriptionMatcher = descriptionPattern.matcher(preparationText);

        if (codeMatcher.find() && descriptionMatcher.find()) {
            return Preparation.builder()
                              .withCode(Integer.valueOf(codeMatcher.group()))
                              .withDescription(descriptionMatcher.group())
                              .build();
        } else {
            throw new IllegalArgumentException(MessageFormat.format("A Preparation could not be found in [{0}]", line));
        }
    }

}
