package com.capgemini.interview.Exceptions;

public class NotUniqueException extends RuntimeException {
    private static final long serialVersionUID = -7806029002430564887L;

    public NotUniqueException() {
        super("Appliance already exists!");
    }
}