package com.unibuc.javaproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VenueRequest {
    @NotNull
    @NotBlank(message = "Name cannot be null.")
    private String name;
    private String address;
    private int capacity;

    public VenueRequest(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public VenueRequest() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }
}
