package org.example.service;

import org.example.object.GamingMouseProduct;
import org.example.object.HeadsetProduct;
import org.example.object.PhoneProduct;

import java.util.List;

public class ProductService {

    private GamingMouseProduct gamingMouseProduct = new GamingMouseProduct();
    private  HeadsetProduct headsetProduct = new HeadsetProduct();
    private  PhoneProduct phoneProduct = new PhoneProduct();

    public PhoneProduct getPhoneProduct(List<String> list){
       return new PhoneProduct(list.get(0), list.get(4), list.get(1),list.get(2),list.get(3));
    }

    public PhoneProduct getActualPhoneObject() {
        return phoneProduct.createPhoneProduct();
    }

    public GamingMouseProduct getGamingMouseProduct(List<String> list){
        return new GamingMouseProduct(list.get(0).substring(0,40), list.get(4), list.get(2));
    }

    public GamingMouseProduct getActualGamingMouseObject() {
        return gamingMouseProduct.createGamingMouseProduct();
    }

    public HeadsetProduct getHeadsetProduct(List<String> list){
        return new HeadsetProduct(list.get(0).substring(0,40), list.get(4), list.get(5));
    }

    public HeadsetProduct getActualHeadsetObject() {
        return headsetProduct.createHeadsetProduct();
    }
}
