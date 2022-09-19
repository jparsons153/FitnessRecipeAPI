package com.recipeAPI.recipe.controllers;

import com.recipeAPI.recipe.exceptions.NoSuchUserException;
import com.recipeAPI.recipe.models.CustomUserDetails;
import com.recipeAPI.recipe.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    CustomUserDetailsService userDetailsService;

    @GetMapping("/user")
    public CustomUserDetails getUser(@CurrentSecurityContext Authentication authentication) {
        return (CustomUserDetails) authentication.getPrincipal();
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUserByUserName(@PathVariable("username") String username){
        try{
            CustomUserDetails user = userDetailsService.getUsersByUserName(username);
            return ResponseEntity.ok(user);
        } catch (NoSuchUserException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> createNewUser(@RequestBody CustomUserDetails userDetails) {
        try {
            return ResponseEntity.ok(userDetailsService.createNewUser(userDetails));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}