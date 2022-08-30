package org.example.object;

import lombok.Data;

import java.util.Objects;


@Data
public class PhoneProduct extends BaseProduct {

    BaseProduct baseProduct;
    private String size;
    private String color;
    private String serviceProvider;

    public PhoneProduct() {
    }

    public PhoneProduct(String name, String price, String size, String color, String serviceProvider) {
        super(name, price);
        this.size = size;
        this.color = color;
        this.serviceProvider = serviceProvider;
    }

    public PhoneProduct createPhoneProduct(){
        PhoneProduct phoneProduct = new PhoneProduct();
        String productName = shoppingCartPageService.getItemNameText();
        phoneProduct.setName(productName);
        phoneProduct.setSize(shoppingCartPageService.getProductFieldValueByFieldNameText("Size"));
        phoneProduct.setColor(shoppingCartPageService.getProductFieldValueByFieldNameText("Color"));
        phoneProduct.setServiceProvider(shoppingCartPageService.getProductFieldValueByFieldNameText("Service Provider"));
        phoneProduct.setPrice(shoppingCartPageService.getItemPriceText());
        return phoneProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PhoneProduct that = (PhoneProduct) o;

        if (!Objects.equals(baseProduct, that.baseProduct)) return false;
        if (!Objects.equals(size, that.size)) return false;
        if (!Objects.equals(color, that.color)) return false;
        return Objects.equals(serviceProvider, that.serviceProvider);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (baseProduct != null ? baseProduct.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (serviceProvider != null ? serviceProvider.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneProduct{" +
                "baseProduct=" + baseProduct +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                '}';
    }
}
