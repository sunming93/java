package com.cultivation.javaBasicExtended.posMachine;

import com.fasterxml.jackson.core.type.TypeReference;
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
    public static final String ITEM_FORMAT = "%-32s%-11d%d\n";
    public static final String PRICE = "Price: ";

    Map<String,Product> products = new LinkedHashMap<>();

    public void readDataSource(Reader reader) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start

        try {
            char[] readContents = new char[1000];
            reader.read(readContents);
            String contents = String.valueOf(readContents);

            ObjectMapper mapper = new ObjectMapper();
            List<Product> productList = mapper.readValue(contents,new TypeReference<List<Product>>(){});

            for (Product product : productList){
                products.put(product.getId(),product);
            }
        } catch (IOException e){
            reader.close();
        }
        // --end-->
    }

    public String printReceipt(String barcodeContent) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        if(products.size() == 0)
            throw new IllegalStateException();

        StringBuilder sb = new StringBuilder();
        sb.append(RECEIPTS_TITLE)
                .append(SEPARATOR_LINE);

        if (barcodeContent == null || barcodeContent.length() <= 2){

            sb.append(SEPARATOR_LINE)
                    .append(PRICE + "0" + LINE_SEPARATOR);

            return sb.toString();
        }

        ObjectMapper mapper = new ObjectMapper();
        List<String> contentIds = mapper.readValue(barcodeContent,new TypeReference<List<String>>(){});

        Map<String,Integer> contents = new LinkedHashMap<>();
        for(String contentId : contentIds){
            if(!contents.containsKey(contentId)){
                contents.put(contentId,1);
            }else {
                contents.put(contentId,contents.get(contentId)+1);
            }
        }

        int totalPrice = 0;
        for(String contentId : contents.keySet()){
            Product product = products.get(contentId);
            Integer quantity = contents.get(contentId);

            sb.append(String.format(ITEM_FORMAT, product.getName(), product.getPrice(), quantity));

            totalPrice += product.getPrice() * quantity;
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