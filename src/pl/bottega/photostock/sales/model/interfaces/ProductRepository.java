package pl.bottega.photostock.sales.model.interfaces;

import pl.bottega.photostock.sales.model.Picture;
import pl.bottega.photostock.sales.model.Product;

import java.util.Collection;

/**
 * Created by Adam.Wronski on 2016-12-17.
 */
public interface ProductRepository {

    void put(Product product);
    Product get(String number);
}
