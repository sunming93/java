package com.cultivation.javaBasicExtended.posMachine;

import com.fasterxml.jackson.databind.ObjectMapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

@SuppressWarnings({"WeakerAccess", "unused", "RedundantThrows"})
public class PosMachine {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String SEPARATOR_LINE = "------------------------------------------------------------" + LINE_SEPARATOR;
    public static final String RECEIPTS_TITLE = "Receipts" + LINE_SEPARATOR;
    public static final String PRICE = "Price: ";

    Map<Product,Integer> products = new LinkedHashMap<>();

    public void readDataSource(Reader reader) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        try {
            char[] readContents = new char[1000];
            reader.read(readContents);
            String contents = String.valueOf(readContents);

            ObjectMapper mapper = new ObjectMapper();
            List<Product> productList = new ArrayList<>();
            productList = mapper.readValue(contents,productList.getClass());

            for(Product product : productList){
                if(!products.containsKey(product)){
                    products.put(product,1);
                }else {
                    products.put(product,products.get(product)+1);
                }
            }
        } catch (IOException e){
            reader.close();
        }
        // --end-->
    }

    public String printReceipt(String barcodeContent) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start


        StringBuilder sb = new StringBuilder();
        sb.append(RECEIPTS_TITLE)
                .append(SEPARATOR_LINE);

        if (barcodeContent == null || barcodeContent.length() <= 2){

            sb.append(SEPARATOR_LINE)
                    .append(PRICE + "0" + LINE_SEPARATOR);

            return sb.toString();
        }

        int totalPrice = 0;
        for(Product product : products.keySet()){
            sb.append(product.getName()+"\t\t\t")
                    .append(product.getPrice()+"\t")
                    .append(products.get(product));
            totalPrice += product.getPrice() * products.get(product);
        }

        sb.append(SEPARATOR_LINE)
                .append(PRICE + totalPrice + LINE_SEPARATOR);

        return sb.toString();
        // --end-->
    }
}

@SuppressWarnings("unused")
class Product {
    private String id;
    private String name;
    private Integer price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;

        Product other = (Product) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}