package br.com.helberbelmiro.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public final class MacroNutrients {

    private final BigDecimal energy;

    private final BigDecimal protein;

    private final BigDecimal lipids;

    private final BigDecimal carbs;

    private final BigDecimal dietaryFibre;

    public MacroNutrients(Builder builder) {
        energy = builder.energy;
        protein = builder.protein;
        lipids = builder.lipids;
        carbs = builder.carbs;
        dietaryFibre = builder.dietaryFibre;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MacroNutrients that = (MacroNutrients) o;
        return getEnergy().compareTo(that.getEnergy()) == 0 &&
                getProtein().compareTo(that.getProtein()) == 0 &&
                getLipids().compareTo(that.getLipids()) == 0 &&
                getCarbs().compareTo(that.getCarbs()) == 0 &&
                getDietaryFibre().compareTo(that.getDietaryFibre()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEnergy(), getProtein(), getLipids(), getCarbs(), getDietaryFibre());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MacroNutrients.class.getSimpleName() + '[', "]")
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
