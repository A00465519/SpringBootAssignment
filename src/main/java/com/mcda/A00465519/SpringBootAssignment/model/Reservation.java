package com.mcda.A00465519.SpringBootAssignment.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.util.UUID;

public class Reservation {
    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private final UUID id;
    private final UUID uid;
    private final UUID hid;
    private final Integer numberOfRoomsBooked;
    public Reservation(UUID id, UUID uid, UUID hid, Integer numberOfRoomsBooked) {
        this.id = id;
        this.uid = uid;
        this.hid = hid;
        this.numberOfRoomsBooked = numberOfRoomsBooked;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUid() {
        return uid;
    }

    public UUID getHid() {
        return hid;
    }

    public Integer getNumberOfRoomsBooked() {
        return numberOfRoomsBooked;
    }
}
