package com.recipeAPI.recipe.repos;

import com.recipeAPI.recipe.models.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<CustomUserDetails, Long> {

    CustomUserDetails findByUsername(String username);
}