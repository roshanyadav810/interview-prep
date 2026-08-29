package amazon.locker.repository;

import amazon.locker.entities.Otp;
import amazon.locker.entities.Parcel;

import java.util.HashMap;
import java.util.Map;

public class ParcelDB {

    private final Map<String , Parcel> parcels;

    public ParcelDB() {
        this.parcels = new HashMap<>();
    }

    public Parcel get(String id){
        if(parcels.containsKey(id)) return parcels.get(id);
        throw new RuntimeException("Not found");
    }

    public void set(Parcel parcel){
        parcels.put(parcel.getId() , parcel);

    }
}
