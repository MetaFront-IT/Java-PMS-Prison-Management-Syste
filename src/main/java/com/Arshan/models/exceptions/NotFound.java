package com.Arshan.models.exceptions;

public class NotFound extends RuntimeException {
    public NotFound() {
        try {
            throw new RuntimeException("Not Found");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
