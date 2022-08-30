package org.example.object;

import lombok.Data;

import java.util.Objects;

@Data
public class GamingMouseProduct extends BaseProduct {

    private String color;

    public GamingMouseProduct() {
    }

    public GamingMouseProduct(String name, String price, String color) {
        super(name, price);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GamingMouseProduct that = (GamingMouseProduct) o;

        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GamingMouse{" +
                "color='" + color + '\'' +
                '}';
    }
}
