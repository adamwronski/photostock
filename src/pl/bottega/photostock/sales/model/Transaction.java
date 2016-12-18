package pl.bottega.photostock.sales.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Adam.Wronski on 2016-12-11.
 */
public class Transaction {

    private Money value;
    private String description;
    private LocalDateTime timestamp;

    public Transaction(Money value, String description){
        this.value = value;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }
}
