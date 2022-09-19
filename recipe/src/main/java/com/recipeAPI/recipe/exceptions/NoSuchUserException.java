package com.recipeAPI.recipe.exceptions;

public class NoSuchUserException extends Throwable {
    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException(){};

}
