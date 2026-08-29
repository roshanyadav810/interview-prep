package amazon.locker.repository;

import amazon.locker.entities.Locker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LockerDB {
    private final Map<String , Locker> lockers;

    public LockerDB() {
        this.lockers = new HashMap<>();
    }

    public Locker get(String id){
        if(lockers.containsKey(id)) return lockers.get(id);
        throw new RuntimeException("Not found");
    }

    public void add(Locker locker){
        lockers.put(locker.getId() , locker);

    }

    public Collection<Locker> getAll(){
        return lockers.values();
    }




}
