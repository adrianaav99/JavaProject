package com.unibuc.javaproject.dto;

public class ParticipantRequest extends UserRequest{
    public ParticipantRequest() {
    }

    public ParticipantRequest(String username, String password, String email) {
        super(username, password, email);
    }
}
