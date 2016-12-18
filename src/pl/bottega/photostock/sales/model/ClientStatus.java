package pl.bottega.photostock.sales.model;

/**
 * Created by Adam.Wronski on 2016-12-10.
 */
public enum ClientStatus {

    STANDARD("Standardowy"),
    VIP("Vip"),
    GOLD("Złoty"),
    SILVER("Srebrny"),
    PLATINUM("Platynowy");

    private String statusName;

    ClientStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName(){
        return statusName;
    }
}
