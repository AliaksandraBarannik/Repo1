package org.example.object;


import lombok.Data;
import org.example.service.ShoppingCartPageService;

import java.util.List;
import java.util.Objects;

@Data
public class BaseProduct {

    ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();

    protected List<String> list;

    private String name;
    private String price;

    public BaseProduct(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public BaseProduct() {}

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
}
