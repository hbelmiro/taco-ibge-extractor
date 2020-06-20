package br.com.helberbelmiro.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

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

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MacroNutrients that = (MacroNutrients) o;
        return getEnergy().equals(that.getEnergy()) &&
                getProtein().equals(that.getProtein()) &&
                getLipids().equals(that.getLipids()) &&
                getCarbs().equals(that.getCarbs()) &&
                getDietaryFibre().equals(that.getDietaryFibre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEnergy(), getProtein(), getLipids(), getCarbs(), getDietaryFibre());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MacroNutrients.class.getSimpleName() + "[", "]")
                .add("energy=" + energy)
                .add("protein=" + protein)
                .add("lipids=" + lipids)
                .add("carbs=" + carbs)
                .add("dietaryFibre=" + dietaryFibre)
                .toString();
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
