package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.service;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.lang.reflect.Field;
import java.util.*;

public class ProductService {

    public String createJson(List<Map<String, Object>> productKeyValList) {
        StringBuilder sb = new StringBuilder("[\n");

        for (Map<String, Object> map : productKeyValList) {
            sb.append("\t{");
            for (String key : map.keySet()) {
                Object val = map.get(key);
                sb.append(String.format("\"%s\": %s, ", key, val));
            }
            sb.setLength(sb.length() - 2);
            sb.append("}\n");
        }

        return sb.append("]").toString();
    }

    public String createXML(List<Map<String, Object>> productKeyValList) {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\"?>\n");
        sb.append("<products>\n");

        for (Map<String, Object> map : productKeyValList) {
            sb.append("\t<product ");
            for (String key : map.keySet()) {
                Object val = map.get(key);
                sb.append(String.format("%s=\"%s\" ", key, val));
            }
            sb.append("/>\n");
        }

        return sb.append("</products>").toString();
    }

    public String createCSV(List<Map<String, Object>> productKeyValList) {
        StringBuilder sb = new StringBuilder();

        for (Map<String, Object> map : productKeyValList) {
            for (Object value : map.values()) {
                sb.append(value).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }

        return sb.toString();
    }

    public List<Map<String, Object>> getKeyValList(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        List<Map<String, Object>> list = new ArrayList<>(products.size() + 1);

        for (Product product : products) {
            Map<String, Object> map = new LinkedHashMap<>();
            Class<?> productClass = product.getClass();

            try {
                for (Field field : productClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    map.put(field.getName(), field.get(product));
                }
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException while printing: " + ex.getMessage());
            }

            list.add(map);
        }

        return list;
    }

}
