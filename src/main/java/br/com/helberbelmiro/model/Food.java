package br.com.helberbelmiro.model;

import java.util.Objects;
import java.util.StringJoiner;

public final class Food {

    private final Integer code;

    private final String description;

    private final Preparation preparation;

    private final MacroNutrients macroNutrients;

    private Food(Builder builder) {
        code = builder.code;
        description = builder.description;
        preparation = builder.preparation;
        macroNutrients = builder.macroNutrients;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Preparation getPreparation() {
        return preparation;
    }

    public MacroNutrients getMacroNutrients() {
        return macroNutrients;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Food.class.getSimpleName() + '[', "]")
                .add("code=" + code)
                .add("description='" + description + '\'')
                .add("preparation=" + preparation)
                .add("macroNutrients=" + macroNutrients)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return getCode().equals(food.getCode()) &&
                getDescription().equals(food.getDescription()) &&
                getPreparation().equals(food.getPreparation()) &&
                getMacroNutrients().equals(food.getMacroNutrients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getDescription(), getPreparation(), getMacroNutrients());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer code;
        private String description;
        private Preparation preparation;
        private MacroNutrients macroNutrients;

        public Builder withCode(Integer code) {
            this.code = code;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPreparation(Preparation preparation) {
            this.preparation = preparation;
            return this;
        }

        public Builder withMacroNutrients(MacroNutrients macroNutrients) {
            this.macroNutrients = macroNutrients;
            return this;
        }

        public Food build() {
            return new Food(this);
        }

    }

}
