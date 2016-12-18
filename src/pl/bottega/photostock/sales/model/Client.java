package pl.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Adam.Wronski on 2016-12-10.
 */
public class Client {

    private String name;
    private Address address;
    private ClientStatus status;
    protected Money balance;

    private Collection<Transaction> transactions;

    public Client(String name, Address address, ClientStatus status, Money InitialBalance) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.balance = InitialBalance;

        this.transactions = new LinkedList<>();
        if (!InitialBalance.equals(Money.ZERO))
            this.transactions.add(new Transaction(InitialBalance, "Openning account "));
    }

    public Client(String name, Address address, Money balance) {
        this(name, address, ClientStatus.STANDARD, balance);
    }

    public boolean canAfford(Money money) {
        return balance.gte(money);
    } // sprawdza czy klient posiada dostateczą ilość środków (do zmiany na Money)

    public void charge(Money money, String reason) {
        if(money.lt(Money.ZERO))
            throw new IllegalArgumentException("Negative charge amount prohibited !");
        if (canAfford(money)) {
            Transaction chargeTransaction = new Transaction(money.opposite(), reason);
            transactions.add(chargeTransaction);
            balance = balance.subtract(money);
        } else {
            String template = "Client Balance is %s and requested amount was %s "; //  jeżeli parametry sa strinagmi to wpisujemy %s, liczby to %d itp.
            String message = String.format(template, balance, money);
            throw new CanAffordException(message);
        }
    } // obciąza klienta daną kwotą odnotowując fakt płatnośći gdzie przyczynajest taka jak podano w drugim parametrze

    public void recharge(Money money) {
        if(money.lt(Money.ZERO))
            throw new IllegalArgumentException("Negative charge amount prohibited !");
        Transaction transaction = new Transaction(money, "Recharge account");
        transactions.add(transaction);
        balance = balance.add(money);

    } //doładowanie konta


    public String getName() {
        return name;
    }

    public String introduce(){
     String statusName = status.getStatusName();
        return String.format("%s - %S", name, statusName);
    }
}




