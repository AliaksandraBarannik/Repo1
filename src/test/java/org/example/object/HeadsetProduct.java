package org.example.object;

import lombok.Data;

import java.util.Objects;

@Data
public class HeadsetProduct extends BaseProduct {

    private String style;

    public HeadsetProduct() {
    }

    public HeadsetProduct(String name, String price, String style) {
        super(name, price);
        this.style = style;
    }

    public HeadsetProduct createHeadsetProduct() {
        HeadsetProduct headsetProduct = new HeadsetProduct();
        String productName = shoppingCartPageService.getItemNameText().substring(0,40);
        headsetProduct.setName(productName);
        headsetProduct.setPrice(shoppingCartPageService.getItemPriceText());
        headsetProduct.setStyle(shoppingCartPageService.getProductFieldValueByFieldNameText("Style"));
        return headsetProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        HeadsetProduct headsetProduct = (HeadsetProduct) o;

        return Objects.equals(style, headsetProduct.style);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (style != null ? style.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Headset{" +
                "style='" + style + '\'' +
                '}';
    }
}
