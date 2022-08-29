//package org.example.object;
//
//import java.util.List;
//import java.util.Objects;
//
//public class HeadsetProduct {
//
//    private BaseProduct baseProduct;
//    private String style;
//
////    public static HeadsetProduct getHeadSet() {
////        List<String> list = BaseProduct.getProductFromProperties("3.2");
////        return new HeadSetBuilder()
////                .withProduct(list, list.get(4))
////                .withStyle(String.valueOf(list.get(5)))
////                .build();
////    }
//
//    public static class HeadSetBuilder {
//
//        private final HeadsetProduct headsetProduct;
//
//        public HeadSetBuilder() {
//            headsetProduct = new HeadsetProduct();
//        }
//
//        public HeadSetBuilder withProduct(List<String> productList, String price) { //вызывать из родителького класса
//            headsetProduct.baseProduct = new BaseProduct.ProductBuilder()
//                    .withName(productList.get(0).substring(0, 60))
//                    .withPrice(price)
//                    .build();
//            return this;
//        }
//
//        public HeadSetBuilder withStyle(String style) {
//            headsetProduct.style = style;
//            return this;
//        }
//
//        public HeadsetProduct build() {
//            return headsetProduct;
//        }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        HeadsetProduct that = (HeadsetProduct) o;
//
//        if (!Objects.equals(baseProduct, that.baseProduct)) return false;
//        return Objects.equals(style, that.style);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = baseProduct != null ? baseProduct.hashCode() : 0;
//        result = 31 * result + (style != null ? style.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "HeadsetProduct{" +
//                "product=" + baseProduct +
//                ", style='" + style + '\'' +
//                '}';
//    }
//}
