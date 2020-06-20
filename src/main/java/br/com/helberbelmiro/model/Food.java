package br.com.helberbelmiro.model;

public class Food {

    private final Integer code;

    private final String description;

    private final Preparation preparation;

    private final MacroNutrients macroNutrients;

    private Food(Builder builder) {
        this.code = builder.code;
        this.description = builder.description;
        this.preparation = builder.preparation;
        this.macroNutrients = builder.macroNutrients;
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
