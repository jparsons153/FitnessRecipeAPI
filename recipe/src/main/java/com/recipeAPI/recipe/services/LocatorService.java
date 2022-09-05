package com.recipeAPI.recipe.services;

import org.springframework.stereotype.Service;

@Service
public class LocatorService implements Locator {

    @Override
    public int getIndex(String itemSought, String[] candidates) {
        // uses binary search O(log N) to search array for itemSought
        int leftIndex = 0, rightIndex = candidates.length-1;
        while(leftIndex<=rightIndex){
            int middleIndex = leftIndex + ((rightIndex-leftIndex)/2);

            int res = itemSought.compareTo(candidates[middleIndex]);

            // Check if itemSought is present at middleIndex
            if (res == 0)
                return middleIndex;

            // If itemSought greater, ignore left half
            if (res > 0)
                leftIndex = middleIndex + 1;

                // If itemSought is smaller, ignore right half
            else
                rightIndex = middleIndex - 1;
        }
        return -1;
    }
}
