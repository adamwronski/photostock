package pl.bottega.photostock.sales.model;

/**
 * Created by Adam.Wronski on 2016-12-17.
 */
public  abstract class AbstractProduct implements Product {
    protected String number;
    private String name;
    protected Money catalogPrice;
    private boolean active; // to jest pole które pomaga wycofać produkt ze sprzedazy, np kiedy został sprzedany poza serwisem
    // zamiast fizycznie usuwać obiekty, flagujemy je czy są usunięte czy nie są usunięte
    private Client reservationOwner;
    private Client buyer;

    public AbstractProduct(String name, String number, Money catalogPrice, boolean active) {
        this.name = name;
        this.number = number;
        this.catalogPrice = catalogPrice;
        this.active = active;
    }

    public abstract Money calculatePrice(Client client);

    @Override
    public boolean isAvailable() {

        return active && !isSold() && !isReserved();
    } // sprawdza czy zdjęcie jest dostępne

    private boolean isReserved() {
        return reservationOwner != null;
    }

    private boolean isSold() {
        return buyer != null;
    }

    @Override
    public void reservedPer(Client client) {
       ensureAvailable();
        this.reservationOwner = client;

    } // oznacza zjęcie jako zarezerwowane per klient

    @Override
    public void unreservedPer(Client client) {
        ensureReservedBy(client);
        this.reservationOwner = null;

    } // zwalnia rezerwacje per klient

    private boolean isReservedBy(Client client) {
        return isReserved() && client.equals(reservationOwner);
    }

    @Override
    public void soldPer(Client client) {
        ensureReservedBy(client);
        buyer = client;
        unreservedPer(client);
    } // oznacza zdjęcie jako sprzedane per klient

    private void ensureReservedBy(Client client) {
        if(!isReservedBy(client))
            throw new IllegalArgumentException(String.format("Picture %s is not reserved by %s ", getNumber(), client.getName()));
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    /*//////////////////////********************************************************????????????????????/////////////////////
        @Override
        public boolean equals(Object other){
         if (this == o) return true;
            if(other == null || !(other instanceof Picture))
                return false;
            Picture otherPicture = (Picture)other;
            return (otherPicture.number == this.number) ||
                    (otherPicture.number!= null && otherPicture.number.equals(this.number));
        }
    *///////////////////////********************************************************????????????????????//////////////////
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void deactivate() {
        active = false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractProduct product = (AbstractProduct) o;

        return number != null ? number.equals(product.number) : product.number == null;

    }

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;

        AbstractProduct product = (AbstractProduct) o;

        return number != null ? number.equals(product.number) : product.number == null;

    } */

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() :     0;
    }


}
