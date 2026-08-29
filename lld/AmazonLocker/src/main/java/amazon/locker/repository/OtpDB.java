package amazon.locker.repository;

import amazon.locker.entities.Locker;
import amazon.locker.entities.Otp;

import java.util.HashMap;
import java.util.Map;

public class OtpDB {

    private final Map<String , Otp> otps;

    public OtpDB() {
        this.otps = new HashMap<>();
    }

    public Otp get(String id){
        if(otps.containsKey(id)) return otps.get(id);
        throw new RuntimeException("Not found");
    }

    public void add(Otp otp){
        otps.put(otp.getOtp() , otp);

    }

}
