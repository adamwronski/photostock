package pl.bottega.photostock.sales.model;

/**
 * Created by Adam.Wronski on 2016-12-18.
 */
public class ProductNotAvailableException extends RuntimeException {

    public ProductNotAvailableException(Product product){
        super(String.format("Picture %s is not available for reservation", product.getNumber()));

    }
}
