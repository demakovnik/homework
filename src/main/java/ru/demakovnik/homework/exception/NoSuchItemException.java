package ru.demakovnik.homework.exception;

public class NoSuchItemException extends RuntimeException{
    public NoSuchItemException(String message) {
        super(message);
    }
}
