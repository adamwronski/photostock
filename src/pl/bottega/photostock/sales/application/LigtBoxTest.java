package pl.bottega.photostock.sales.application;

import pl.bottega.photostock.sales.model.*;
import pl.bottega.photostock.sales.model.interfaces.ProductRepository;

/**
 * Created by Adam.Wronski on 2016-12-11.
 */
public class LigtBoxTest {
    public static void main(String[] args) {
        ProductRepository productRepository = new InMemoryProductRepository();

        Product object1 = productRepository.get("1");
        Product object2 = productRepository.get("2");
        Product object3 = productRepository.get("3");

        Client client1 = new Client("Kamil", new Address(), Money.valueOf(100));
        Client client2 = new Client("Kasia", new Address(), Money.valueOf(130));

        LightBox lightBox1 = new LightBox(client1, "Samochody");
        LightBox lightBox2 = new LightBox(client2, "Wyścigowe samochody");
        LightBox lightBox3 = new LightBox(client1, "BMW");

        lightBox1.add(object1);
        lightBox2.add(object2);
        lightBox3.add(object3);

        lightBox3.add(object1);

      //  object1.deactivate();

        printLightBoxes(lightBox1, lightBox2,lightBox3 );

        LightBox l = LightBox.joined(client1, "Joined Lightbox",lightBox1, lightBox2, lightBox3);
        System.out.println("Jooined lightbox");
        printLightBox(l);
    }

    private static void printLightBoxes(LightBox... lightboxes) {
        int nr = 1;
        for(LightBox lightbox : lightboxes){
            System.out.println(String.format("%d. %s - %s", nr, lightbox.getName(), lightbox.getOwner().getName()));
                printLightBox(lightbox);
            System.out.println("===###===***===@@@===$$$===%%%===###===");
            nr++;
        }
    }

    private static void printLightBox(LightBox lightbox) {
        for (Product product : lightbox)
        System.out.println(String.format("%s%s | %s" , (product.isActive() ? "" : "X "),
                product.getNumber(), product.calculatePrice(lightbox.getOwner())));
    }

}
