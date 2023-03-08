package com.mcda.A00465519.SpringBootAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.util.UUID;

public class Hotel {
    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private final UUID id;
    private final String name;
    private final String phone;
    private final String email;
    private final Integer numberOfRoomsAvailable;

    public Hotel(@JsonProperty("id") UUID id, @JsonProperty("name") String name,
                 @JsonProperty("phone") String phone, @JsonProperty("email") String email,
                 @JsonProperty("numberOfRoomsAvailable") Integer numberOfRoomsAvailable) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getNumberOfRoomsAvailable() {
        return numberOfRoomsAvailable;
    }

}
