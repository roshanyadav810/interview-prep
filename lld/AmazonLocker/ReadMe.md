## Problem
    Design a locker system like Amazon Locker where delivery drivers can deposit packages
    and customers can pick them up using a code.

## Core entities
    1. Locker - this what thaT store the parcel and has a size like Small, Medium , Large
    2. Parcel - Has size for matching the locker Small . Medium , Large
    3. LockerManager -  Accept the parcel , assigned locker to it , get the Parcel Based on otp
    5. Otp - To get the parcel from Locker


    We are keeping delivery driver and customer out of scope as they need some Auth mechanism to 
    access the LockerManager 

## DB
    1. LockerDB - Map<Id , Locker>
    2. ParcelDB - Map<Id , Parcel>
    3. OtpDB - Map<Id , Otp>

## LockerManager
    functionalities : 
        1. accept the locker
            - take package and find suitable locker based on size and status we can 
                add other parameters like geolocation later as well
            - if locker present add the parcel to Locker and return otp 
            - real world scenario it  would send otp to the customer
        2. get parcel -  user wil give otp
            - find otp based on locker
            - get parcel from locker


