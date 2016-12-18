package pl.bottega.photostock.sales.model;

/**
 * Created by Adam.Wronski on 2016-12-17.
 */
public class VIPClient extends Client {

    private Money creditLimit;

    public VIPClient(String name, Address addres, Money balance, Money creditLimit){
        super(name, addres, ClientStatus.VIP, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean canAfford(Money money) {
        return balance.add(creditLimit).gte(money);
    }

}
