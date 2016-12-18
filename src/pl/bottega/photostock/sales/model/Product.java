package pl.bottega.photostock.sales.model;

/**
 * Created by Adam.Wronski on 2016-12-17.
 */
public interface Product {
    Money calculatePrice(Client client) // wylicza cene za zdjęcie per klient
    ;

    boolean isAvailable() // sprawdza czy zdjęcie jest dostępne
    ;

    void reservedPer(Client client) // oznacza zjęcie jako zarezerwowane per klient
    ;

    void unreservedPer(Client client) // zwalnia rezerwacje per klient
    ;

    void soldPer(Client client) // oznacza zdjęcie jako sprzedane per klient
    ;

    String getNumber();

    boolean isActive();

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
    String getName();

    void deactivate();

   default void ensureAvailable() {
       if(!isAvailable())
           throw new ProductNotAvailableException(this);
   }
}
