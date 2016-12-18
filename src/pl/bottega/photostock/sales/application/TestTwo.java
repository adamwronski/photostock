package pl.bottega.photostock.sales.application;

import pl.bottega.photostock.sales.model.*;
import pl.bottega.photostock.sales.model.interfaces.ProductRepository;

/**
 * Created by Adam.Wronski on 2016-12-14.
 */
public class TestTwo {
    public static void main(String[] args) {
        Client client1 = new Client("Bruce_Client_nr_1", new Address(), Money.valueOf(200));
        Client client2 = new Client("Bane_Client_nr_2", new Address(), Money.valueOf(300));

        InMemoryLightBoxRepository inMemoryLightBoxRepository = new InMemoryLightBoxRepository();

        ProductRepository productRepository = new InMemoryProductRepository();

        Product object1 = productRepository.get("1");
        Product object2 = productRepository.get("2");
        Product object3 = productRepository.get("3");




    }
}
