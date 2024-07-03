package com.odk.V5_Ticketing.exceptions;

public class TicketNotFoundException extends  RuntimeException {
    public TicketNotFoundException(String message) {
        super(message);
    }
}
