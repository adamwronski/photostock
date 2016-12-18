package pl.bottega.photostock.sales.model.interfaces;

import pl.bottega.photostock.sales.model.Client;
import pl.bottega.photostock.sales.model.LightBox;

import java.util.Collection;

/**
 * Created by Adam.Wronski on 2016-12-14.
 */
public interface LightBoxRepository {
    void put(LightBox l);
    Collection<LightBox> getFor(Client client);
}
