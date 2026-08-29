package amazon.locker.service;

import amazon.locker.entities.Locker;
import amazon.locker.entities.Otp;
import amazon.locker.entities.Parcel;
import amazon.locker.enums.Status;
import amazon.locker.repository.LockerDB;
import amazon.locker.repository.OtpDB;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LockerManager {
    private final Map<String , Parcel> lockerParcelMap;
    private final Map<String , String> otpLockerMap;
    private final LockerDB lockerDB;
    private final OtpDB otpDB;
    private final SecureRandom secureRandom;

    public LockerManager(LockerDB lockerDB, OtpDB otpDB) {
        this.lockerDB = lockerDB;
        this.otpDB = otpDB;
        this.lockerParcelMap = new HashMap<>();
        this.otpLockerMap = new HashMap<>();
        this.secureRandom = new SecureRandom();
    }

    private String findSuitableLocker(Parcel parcel){
        Collection<Locker> lockers = lockerDB.getAll();
        for(Locker locker : lockers){
            if( locker.getStatus() == Status.AVAILABLE && locker.getSize() == parcel.getSize()) return locker.getId();
        }
        throw new RuntimeException("Locker not found");

    }

    public String delivery(Parcel parcel){
        String lockerId = findSuitableLocker(parcel);

        Locker locker = lockerDB.get(lockerId);
        locker.setStatus(Status.OCCUPIED);

        lockerParcelMap.put(lockerId , parcel);
        String otp = String.valueOf(secureRandom.nextInt());
        Otp otp1 = new Otp(otp);
        otpDB.add(otp1);
        otpLockerMap.put(otp , lockerId);

        return otp;
        // notify the customer
    }

    public Parcel getParcel(String inputOtp){
        if(!otpLockerMap.containsKey(inputOtp)) throw new RuntimeException("Otp not found") ;
        Otp otp = otpDB.get(inputOtp);
        if(otp.isExpired()) throw new RuntimeException("Otp Expired ") ;

        String lockerId = otpLockerMap.get(inputOtp);

        System.out.println("lockar id "+lockerId);
        System.out.println(lockerParcelMap.toString());
        if(lockerParcelMap.containsKey(lockerId) ){

            return lockerParcelMap.get(lockerId);
        }
        throw new RuntimeException("Parcel not found");
    }
}
