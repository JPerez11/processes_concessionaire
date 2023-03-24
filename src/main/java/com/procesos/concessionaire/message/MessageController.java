package com.procesos.concessionaire.message;

public enum MessageController {

    USER_CREATED("The user has been create"),
    USER_UPDATED("The user has been update");

    private final String message;

    MessageController(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
