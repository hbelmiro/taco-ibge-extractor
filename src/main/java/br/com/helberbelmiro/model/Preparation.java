package br.com.helberbelmiro.model;

import java.util.Objects;
import java.util.StringJoiner;

public final class Preparation {

    private final Integer code;

    private final String description;

    public Preparation(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
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
        Preparation that = (Preparation) o;
        return getCode().equals(that.getCode()) &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getDescription());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Preparation.class.getSimpleName() + '[', "]")
                .add("code=" + code)
                .add("description='" + description + '\'')
                .toString();
    }

    public static class Builder {
        private Integer code;
        private String description;

        public Builder withCode(Integer code) {
            this.code = code;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Preparation build() {
            return new Preparation(code, description);
        }
    }

}
