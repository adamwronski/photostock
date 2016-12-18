package pl.bottega.photostock.sales.model;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Adam.Wronski on 2016-12-10.
 */
public class Purchase {

    private Client client;
    private Date purchaseData;
    private Collection<Product> items;

    public Purchase(Client client, Collection<Product> items) {
        this.client = client;
        this.items = new LinkedList<>(items);
    }

    public Purchase(Client client, Product... items) {
        this(client,Arrays.asList(items));

    }

    public int getItemsCount() {
        return items.size();
    }

    public void sortProductByNumber(){

    }
}
