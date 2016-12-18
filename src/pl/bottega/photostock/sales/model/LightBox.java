package pl.bottega.photostock.sales.model;

import java.util.*;

/**
 * Created by Adam.Wronski on 2016-12-10.
 */
public class LightBox implements Iterable<Product> {

    private Client client;
    // zawsze przy deklaracji pol stosujemy minimailny interface który będziemy stosować !
    private String name;

    public LightBox(Client client, String name) {
        this.name = name;
        this.client = client;
    }

    @Override
    public Iterator<Product> iterator() {
        return items.iterator();
    }

    private Collection<Product> items = new LinkedList<>();

    //  private Set<Picture> items;
    //  private HashSet<Picture> items;
    //  private Iterable<Picture> items;

    public void add(Product product) {
        if (items.contains(product))
            throw new IllegalArgumentException(String.format("Lightbox dont contain picture %s !", product.getNumber()));
        if (!product.isAvailable())
            throw new IllegalArgumentException(String.format("Picture %s is not available !", product.getNumber()));
        items.add(product);
    } //dodaje zdjecie do lightboxa

    public void remowe(Product product) {
        if (!items.contains(product))
            throw new IllegalArgumentException(String.format("Lightbox dont contain picture %s !", product.getNumber()));
        items.remove(product);
    }//usuwa zdjecie z lightboxa

    public void rename(String newName) {
        this.name = newName;
    }

    public Object getName() {
        return name;
    }

    public Client getOwner() {
        return client;
    }

    public static LightBox joined(Client client1, String name, LightBox... lightboxes) {
        LightBox output = new LightBox(client1, name);
        for (LightBox lightbox : lightboxes) {
            for (Product product : lightbox) {
                if (product.isActive() && !output.items.contains(product))
                    output.items.add(product);
            }
        }
        return output;
    }
}
