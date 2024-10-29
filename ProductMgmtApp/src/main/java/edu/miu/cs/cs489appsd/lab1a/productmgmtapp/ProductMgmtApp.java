package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.service.ProductService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductMgmtApp {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 124, 0.55f));
        products.add(new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18, 1.09f));
        products.add(new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89, 2.99f));

        List<Product> sortedProducts = products.stream()
                .sorted((Product p1, Product p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());

        printProducts(sortedProducts);
    }

    private static void printProducts(List<Product> products) {
        ProductService service = new ProductService();

        List<Map<String, Object>> productKeyValList = service.getKeyValList(products);

        System.out.println("Printed in JSON Format:");
        System.out.println(service.createJson(productKeyValList));

        System.out.println("---------------------------");
        System.out.println("Printed in XML Format:");
        System.out.println(service.createXML(productKeyValList));

        System.out.println("---------------------------");
        System.out.println("Printed in Comma-Separated Value(CSV) Format:");
        System.out.println(service.createCSV(productKeyValList));
    }

}