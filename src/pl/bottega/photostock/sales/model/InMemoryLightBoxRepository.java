package pl.bottega.photostock.sales.model;

import pl.bottega.photostock.sales.model.interfaces.LightBoxRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Adam.Wronski on 2016-12-14.
 */
public class InMemoryLightBoxRepository implements LightBoxRepository {

    private static final Map<Client, Collection<LightBox>> memory = new HashMap<>();

    @Override
     public void put(LightBox l){
        Client owner = l.getOwner();
        memory.putIfAbsent(owner,new HashSet<>());
        Collection<LightBox> ownerLightBoxes = memory.get(owner);
        ownerLightBoxes.add(l);
        //memory.put(l.getOwner(),getFor(l.getOwner()));
    }

    @Override
    public Collection<LightBox> getFor(Client client){
        return memory.get(client);
    }

}
