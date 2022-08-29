package org.example.object;

import lombok.Data;
import org.example.util.ReadDataFromFile;

import java.util.List;
import java.util.Objects;


@Data
public class BaseProduct {

    protected List<String> list;
    private String name;
    private String price;

    public BaseProduct() {
    }

    public <T> T createFromFile(String key){
        list = ReadDataFromFile.getDataFromProperties(key);
        return (T) new ProductBuilder()
                .withName(list.get(0).substring(0, 40))
                .withPrice(list.get(4));
    }


    protected BaseProduct(BaseProduct.ProductBuilder<?> productBuilder){
        this.name=productBuilder.name;
        this.price=productBuilder.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseProduct that = (BaseProduct) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public static class ProductBuilder<T extends ProductBuilder<T>> {
        private String name;
        private String price;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T withName(String name) {
            this.name = name;
            return self();
        }

        public T withPrice(String price) {
            this.price = price;
            return self();
        }
    }
}
