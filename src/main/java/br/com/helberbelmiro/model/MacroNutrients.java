package br.com.helberbelmiro.model;

import java.math.BigDecimal;

public class MacroNutrients {

    private final BigDecimal energy;

    private final BigDecimal protein;

    private final BigDecimal lipids;

    private final BigDecimal carbs;

    private final BigDecimal dietaryFibre;

    public MacroNutrients(Builder builder) {
        this.energy = builder.energy;
        this.protein = builder.protein;
        this.lipids = builder.lipids;
        this.carbs = builder.carbs;
        this.dietaryFibre = builder.dietaryFibre;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public BigDecimal getLipids() {
        return lipids;
    }

    public BigDecimal getCarbs() {
        return carbs;
    }

    public BigDecimal getDietaryFibre() {
        return dietaryFibre;
    }

    public static class Builder {
        private BigDecimal energy;
        private BigDecimal protein;
        private BigDecimal lipids;
        private BigDecimal carbs;
        private BigDecimal dietaryFibre;

        public Builder withEnergy(BigDecimal energy) {
            this.energy = energy;
            return this;
        }

        public Builder withProtein(BigDecimal protein) {
            this.protein = protein;
            return this;
        }

        public Builder withLipids(BigDecimal lipids) {
            this.lipids = lipids;
            return this;
        }

        public Builder withCarbs(BigDecimal carbs) {
            this.carbs = carbs;
            return this;
        }

        public Builder withDietaryFibre(BigDecimal dietaryFibre) {
            this.dietaryFibre = dietaryFibre;
            return this;
        }

        public MacroNutrients build() {
            return new MacroNutrients(this);
        }
    }

}
