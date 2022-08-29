//package org.example.object;
//
//
//import lombok.Data;
//
//import java.util.Objects;
//
//@Data
//public class GamingMouseProduct extends BaseProduct {
//
//    private String color;
//
//    public GamingMouseProduct() {
//    }
//
//    @Override
//    public ProductBuilder create(String key) {
//        return super.create(key);
//
//    }
//
//    protected GamingMouseProduct(Builder<?> builder) {
//        super(builder);
//        this.color=builder.color;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        GamingMouseProduct that = (GamingMouseProduct) o;
//
//        return Objects.equals(color, that.color);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + (color != null ? color.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "GamingMouseProduct{" +
//                "color='" + color + '\'' +
//                '}';
//    }
//
//    public static class Builder<T extends Builder<T>> extends BaseProduct.ProductBuilder<T> {
//        private String color;
//
//        public T withColor(String color) {
//            this.color = color;
//            return self();
//        }
//
//        public GamingMouseProduct build() {
//            return new GamingMouseProduct(this);
//        }
//    }
//
//    @SuppressWarnings("rawtypes")
//    public static GamingMouseProduct.Builder<?> builder() {
//        return new GamingMouseProduct.Builder();
//    }
//}
