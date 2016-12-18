package pl.bottega.photostock.sales.model;

import pl.bottega.photostock.sales.model.interfaces.ProductRepository;

import java.util.*;

/**
 * Created by Adam.Wronski on 2016-12-17.
 */
public class InMemoryProductRepository implements ProductRepository {

    private static final  Map<String, Product> REPOSITORY = new HashMap<>();

    static {
        Collection<String> tags = Arrays.asList("przyroda","motoryzacja");
        Product object1 = new Picture("1","BMW", tags, Money.valueOf(3));
        Product object2 = new Picture("2","Mercedes", tags, Money.valueOf(2));
        Product object3 = new Picture("3","Hyundai", tags, Money.valueOf(4));
        Product clip1 = new Clip("4", "Wściekłe pięsci węża", 2l * 1000 * 60 * 2, Money.valueOf(6));
        Product clip2 = new Clip("5", "Sum tzw. olimpijczyk", 40l * 1000 * 60 * 2, Money.valueOf(10));
        REPOSITORY.put("1", object1);
        REPOSITORY.put("2", object2);
        REPOSITORY.put("3", object3);
        REPOSITORY.put("4", clip1);
        REPOSITORY.put("5", clip2);


    }

    @Override
    public void put(Product product) {
        REPOSITORY.put(product.getNumber(),product);
    }
    @Override
    public Product get(String number) {
        return REPOSITORY.get(number);
    }

}
