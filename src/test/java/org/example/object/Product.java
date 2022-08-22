package org.example.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Product {

    private String name;
    private String size;
    private String color;
    private String serviceProvider;
    private String price;

}
