package pl.bottega.photostock.sales.model;

import com.sun.deploy.util.StringUtils;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Adam.Wronski on 2016-12-10.
 */
public class Reservation {

    private Client client;
    private Collection<Product> items;

    public Reservation(Client client) {
        this.client = client;
        this.items = new HashSet<Product>();
    }

    public void add(Product product) {
        if(items.contains(product))
            throw new IllegalArgumentException(String.format("Product %s is already in this reservation !", product.getNumber()));
        if(!product.isAvailable())
            throw new IllegalArgumentException(String.format("Product %s is not available !", product.getNumber()));
        items.add(product);
    } // dodaje zdjecie do rezerwacji

    public void remowe(Product product) {
        items.remove(product);
    } // usuwa zdjecie z rezerwacji

    public Offer generateOffer() {
        // ZREDUKUJ ELEMENTY KOLECJI DO MNIEJSZEJ KOLEKCJI KTÓRE SPEŁNIAJĄ JAKIŚ WARUNEK
        return new Offer(client, getActiveItems());
    } //generuje oferte na podstawie rezerwacji

    private Collection<Product> getActiveItems() {
        Collection<Product> filterItems = new HashSet<>();
        for(Product product : items)
        {
            if(product.isActive())
            {
                filterItems.add(product);
            }
        }
        return filterItems;
    }

    public int getItemsCount() {
        return items.size();
    } //zwraca ilosc pozycji rezerwacji

}
