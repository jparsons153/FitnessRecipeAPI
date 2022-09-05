package com.recipeAPI.recipe.services;

/**
 * Implementers can identify the index of a String efficiently within a sorted array of candidates.
 */

public interface Locator {
    /**
     * @param itemSought
     *        the item for which the index is sought
     * @param candidates
     *        a sorted array of items, from within which the itemSought must be found
     * @return the zero based index of the itemSought within the array of candidates. In the event that
     *        the itemSought is not found in the candidates array an index of -1 is returned.
     */
    public int getIndex(String itemSought, String[] candidates);

}
