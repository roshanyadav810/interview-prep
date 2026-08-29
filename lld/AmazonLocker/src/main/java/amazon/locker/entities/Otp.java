package amazon.locker.entities;


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

    public boolean isExpired(){
        return System.currentTimeMillis() > this.created + ExpiryDuration;
    }
}
