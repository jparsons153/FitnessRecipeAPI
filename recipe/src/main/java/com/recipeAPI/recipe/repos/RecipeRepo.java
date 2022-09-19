package com.recipeAPI.recipe.repos;

import com.recipeAPI.recipe.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    ArrayList<Recipe> findByNameContaining(String name);

    ArrayList<Recipe> findByNameContainingAndAverageRatingGreaterThan(String name,double minRating);

    ArrayList<Recipe> findByAverageRatingIs(double rating);

    ArrayList<Recipe> findByUser(String user);
}
