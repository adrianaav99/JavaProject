package com.unibuc.javaproject.dto;

public class OrganizerRequest extends UserRequest{
    public OrganizerRequest() {
    }

    public OrganizerRequest(String username, String password, String email) {
        super(username, password, email);
    }
}
