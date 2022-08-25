package org.example.object;

import java.util.Objects;

public class Product {

    private final String name;
    private final String size;
    private final String color;
    private final String serviceProvider;
    private final String price;
    private final String style;

    public static class ProductBuilder {

        private String name;
        private String size;
        private String color;
        private String serviceProvider;
        private String price;
        private String style;

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withSize(String size) {
            this.size = size;
            return this;
        }

        public ProductBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public ProductBuilder withServiceProvider(String serviceProvider) {
            this.serviceProvider = serviceProvider;
            return this;
        }

        public ProductBuilder withPrice(String price) {
            this.price = price;
            return this;
        }

        public ProductBuilder withStyle(String style) {
            this.style = style;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    private Product(ProductBuilder productBuilder) {
        name = productBuilder.name;
        size = productBuilder.size;
        color = productBuilder.color;
        serviceProvider = productBuilder.serviceProvider;
        price = productBuilder.price;
        style = productBuilder.style;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                ", price='" + price + '\'' +
                ", style='" + style + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!Objects.equals(name, product.name)) return false;
        if (!Objects.equals(size, product.size)) return false;
        if (!Objects.equals(color, product.color)) return false;
        if (!Objects.equals(serviceProvider, product.serviceProvider))
            return false;
        if (!Objects.equals(price, product.price)) return false;
        return Objects.equals(style, product.style);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (serviceProvider != null ? serviceProvider.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        return result;
    }
}
