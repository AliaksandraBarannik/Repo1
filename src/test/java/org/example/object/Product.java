package org.example.object;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Product {

    private String name;
    private String size;
    private String color;
    private String serviceProvider;
    private String price;
    private String option;

    public static class ProductBuilder {

        private Product product;

        public ProductBuilder() {
            product = new Product();
        }

        public ProductBuilder withName(String name) {
            product.name = name;
            return this;
        }

        public ProductBuilder withSize(String size) {
            product.size = size;
            return this;
        }

        public ProductBuilder withColor(String color) {
            product.color = color;
            return this;
        }

        public ProductBuilder withServiceProvider(String serviceProvider) {
            product.serviceProvider = serviceProvider;
            return this;
        }

        public ProductBuilder withPrice(String price) {
            product.price = price;
            return this;
        }

        public ProductBuilder withOption(String option) {
            product.option = option;
            return this;
        }

        public Product build() {
            return new Product();
        }
    }
}
