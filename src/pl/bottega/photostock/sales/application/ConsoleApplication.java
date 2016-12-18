package pl.bottega.photostock.sales.application;

import pl.bottega.photostock.sales.model.*;
import pl.bottega.photostock.sales.model.interfaces.ProductRepository;

/**
 * Created by Adam.Wronski on 2016-12-10.
 */
public class ConsoleApplication {

    public static void main(String[] args) {

        ProductRepository productRepository = new InMemoryProductRepository();

        Product object1 = productRepository.get("1");
        Product object2 = productRepository.get("2");
        Product object3 = productRepository.get("3");
        Product object4 = productRepository.get("4");


        Client HelgaBurak = new Client("HelgaBurak", new Address(), Money.valueOf(100));
        Client vipClient = new VIPClient("John Snow", new Address(), Money.ZERO, Money.valueOf(150));

        System.out.println(HelgaBurak.introduce());
        System.out.println(vipClient.introduce());
      //  Reservation HelgaReserv = new Reservation(HelgaBurak);
        Reservation HelgaReserv = new Reservation(vipClient);

        HelgaReserv.add(object1);
        HelgaReserv.add(object2);
        HelgaReserv.add(object3);
        HelgaReserv.add(object4);
        System.out.println("After adding items count : " + HelgaReserv.getItemsCount());

       /* //ponownie próbujemy dodać
        HelgaReserv.add(object1);
        HelgaReserv.add(object2);
        HelgaReserv.add(object3);
        System.out.println("After adding items count : " + HelgaReserv.getItemsCount());
*/
        Offer offer = HelgaReserv.generateOffer();

     //   boolean canAfford = HelgaBurak.canAfford(offer.getTotalCost());
        boolean canAfford = vipClient.canAfford(offer.getTotalCost());
        // System.out.println("Client can afford :" + String.valueOf(canAfford));
        System.out.println("Client can afford : " + canAfford);

        if (canAfford) {
          //  HelgaBurak.charge(offer.getTotalCost(), "Test Purchase");
            vipClient.charge(offer.getTotalCost(), "Test Purchase");
          //  Purchase purchase = new Purchase(HelgaBurak, object1, object2, object3);
            Purchase purchase = new Purchase(vipClient, object1, object2, object3);
            System.out.println("Client purchased : " + purchase.getItemsCount());
            System.out.println("Total cost : " + offer.getTotalCost());
        } else {
            System.out.println("Client cannot afford");
        }


    }
}
