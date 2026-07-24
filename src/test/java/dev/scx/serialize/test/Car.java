package dev.scx.serialize.test;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Car {

    public String name;
    public LocalDateTime createdDate;

    public AtomicLong mileage = new AtomicLong(18625);

    public byte[] byteData = "Car Byte Data !!!".getBytes();

    @Override
    public String toString() {
        return "name : " + name + "\ncreatedDate : " + createdDate+"\nmileage : " + mileage+"\nbyteData : " + new String(byteData);
    }

}
