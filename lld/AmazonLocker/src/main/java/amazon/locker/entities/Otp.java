package amazon.locker.entities;

import java.util.Objects;

public class Otp {
    private static final long ExpiryDuration = 180*1000;
    private final String otp;
    private final long created;
    public Otp(String otp) {
        this.otp = otp;
        this.created = System.currentTimeMillis();
    }

    public String getOtp(){
        return this.otp;
    }

    public boolean isValid(String inputOtp){
        return Objects.equals(inputOtp, this.otp) && System.currentTimeMillis() < (created + ExpiryDuration);
    }

}
