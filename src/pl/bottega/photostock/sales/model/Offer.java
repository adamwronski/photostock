package pl.bottega.photostock.sales.model;

import java.util.*;

/**
 * Created by Adam.Wronski on 2016-12-10.
 */
public class Offer {

    private List<Product> items;
    private Client client;

    public Offer(Client client, Collection<Product> items) {
        this.client = client;
        this.items = new LinkedList<>(items);
        sortProducteByPrice();
    }



    public boolean sameAs(Offer other, Money money) {
        return true;
    } // sprawdza czy dana rezerwacja jest taka sama jak druga,
    // podana w parametrze; dozwolona jest różnica w cenach pozycji
    // na poziomie procent jaki podano w drugim parametrze

    public int getItemsCount() {
        return items.size();
    } // zwraca ilosc pozycji oferty

    public Money getTotalCost() {
        Money totalCost = Money.ZERO;
        for(Product product : items){
            Money productCost = product.calculatePrice(client);
            totalCost = totalCost.add(productCost);
        }
        return totalCost;
    } // zwraca całkowity koszt oferty

    private void sortProducteByPrice() {
        this.items.sort( new Comparator<Product>(){
            @Override
            public int compare(Product p1, Product p2){
                Money price1 = p1.calculatePrice(client);
                Money price2 = p2.calculatePrice(client);
                //sortowanie malejące
                //return - price1.compareTo(price2); -> to też będzie malejąco
                return price2.compareTo(price1);
            }
        } );
    }

}
