package com.recipeAPI.recipe.exceptions;

public class NoSuchRecipeException extends Exception{
    public NoSuchRecipeException(String message) {
        super(message);
    }

    public NoSuchRecipeException() {
    }
}
