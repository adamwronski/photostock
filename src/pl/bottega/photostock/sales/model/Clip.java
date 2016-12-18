package pl.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Adam.Wronski on 2016-12-17.
 */
public class Clip extends AbstractProduct {

    public static final Long FIVE_MINUTES = 1000l * 60 * 5;
    private Long length;

    public Clip(String number, String name, Long length, Money catalogPrice, boolean active) {
        super(name, number, catalogPrice, active);
        this.length = length;

    }

    public Clip(String number, String name, Long length, Money catalogPrice) {
        this(number, name, length, catalogPrice, true);
    }
    @Override
    public Money calculatePrice(Client client) {
        if(length > FIVE_MINUTES)
        return catalogPrice.multiply(2);
        else
            return catalogPrice;
    } // wylicza cene za clip per klient
}
