package amazon.locker;

import amazon.locker.entities.Locker;
import amazon.locker.entities.Parcel;
import amazon.locker.enums.Size;
import amazon.locker.enums.Status;
import amazon.locker.repository.LockerDB;
import amazon.locker.repository.OtpDB;
import amazon.locker.service.LockerManager;


public class Main {
    public static void main(String[] args) {
        System.out.println("Locker Manager System");

        // Add lockers to the system
        LockerDB lockerDB = new LockerDB();
        lockerDB.add(new Locker("1", Size.SMALL, Status.AVAILABLE));
        lockerDB.add(new Locker("2", Size.MEDIUM, Status.AVAILABLE));
        lockerDB.add(new Locker("3", Size.LARGE, Status.AVAILABLE));



        Parcel parcel = new Parcel("p1",Size.SMALL);

        OtpDB otpDB = new OtpDB();

        LockerManager lockerManager = new LockerManager(lockerDB , otpDB);

        String otp = lockerManager.delivery(parcel);

        Parcel parcel1 = lockerManager.getParcel(otp);

        System.out.println("get the parcel");



    }
}