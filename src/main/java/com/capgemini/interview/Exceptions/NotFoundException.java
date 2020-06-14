package com.capgemini.interview.Exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -7806029002430564887L;

    public NotFoundException() {
        super("Appliance does not exist!");
    }
}