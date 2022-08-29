package org.example.object;

import lombok.Data;
import org.example.util.ReadDataFromFile;

import java.util.List;
import java.util.Objects;

@Data
public class PhoneProduct extends BaseProduct {

    private String size;
    private String color;
    private String serviceProvider;

//    public static PhoneProduct getPhone() {
//        List<String> list = BaseProduct.getProductFromProperties("3");
//        return new PhoneBuilder()
//                .withProduct(list, list.get(4))
//                .withSize(list.get(1))
//                .withColor(list.get(2))
//                .withServiceProvider(list.get(3))
//                .build();
//    }


    @Override
    public <T> T createFromFile(String key) {
        list = ReadDataFromFile.getDataFromProperties(key);
        PhoneProduct phoneProduct = super.createFromFile(key);
        return (T) new PhoneBuilder()
                .withSize(list.get(1))
                .withColor(list.get(2))
                .withServiceProvider(list.get(3))
                .build();
    }

    public PhoneProduct(PhoneBuilder<?> phoneBuilder) {
        super(phoneBuilder);
        this.size = phoneBuilder.size;
        this.color = phoneBuilder.color;
        this.serviceProvider = phoneBuilder.serviceProvider;
    }

    public static class PhoneBuilder<T extends PhoneBuilder<T>> extends BaseProduct.ProductBuilder<T> {

        private String size;
        private String color;
        private String serviceProvider;

//        public PhoneBuilder() {
//            phoneProduct = new PhoneProduct();
//        }
//
//        public PhoneBuilder withProduct(List<String> productList, String price) {
//            phoneProduct.baseProduct = new BaseProduct.ProductBuilder()
//                    .withName(productList.get(0))
//                    .withPrice(price)
//                    .build();
//            return this;
//        }

        public T getObject(T obj){
            return obj;
        }

        public T withSize(String size) {
            this.size = size;
            return self();
        }

        public T withColor(String color) {
            this.color = color;
            return self();
        }

        public T withServiceProvider(String serviceProvider) {
            this.serviceProvider = serviceProvider;
            return self();
        }

        public PhoneProduct build() {
            return new PhoneProduct(this);
        }
    }

    public static PhoneProduct.PhoneBuilder<?> builder() {
        return new PhoneProduct.PhoneBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneProduct that = (PhoneProduct) o;

        if (!Objects.equals(baseProduct, that.baseProduct)) return false;
        if (!Objects.equals(size, that.size)) return false;
        if (!Objects.equals(color, that.color)) return false;
        return Objects.equals(serviceProvider, that.serviceProvider);
    }

    @Override
    public int hashCode() {
        int result = baseProduct != null ? baseProduct.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (serviceProvider != null ? serviceProvider.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneProduct{" +
                "product=" + baseProduct +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                '}';
    }
}
