package pl.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Adam.Wronski on 2016-12-10.
 */
public class Picture extends AbstractProduct {

    private Collection<String> tags;


    public Picture(String number, String name, Collection<String> tags, Money catalogPrice, boolean active) {
        super(number, name, catalogPrice, active);

        this.tags = new HashSet<String>(tags);
    }

    public Picture(String number, String name, Collection<String> tags, Money catalogPrice) {
        this(number, name, tags, catalogPrice, true);
    }
    @Override
    public Money calculatePrice(Client client) {
        return catalogPrice;
    } // wylicza cene za zdjęcie per klient




}
