package com.example.backend_shelter.exception;

public class PetException extends RuntimeException {
    private String message;

        public PetException(String message) {
            super(message);
            this.message = message;
        }

    }
