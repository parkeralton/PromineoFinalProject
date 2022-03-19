package com.promineotech.recipe.service;

import com.promineotech.recipe.entity.Recipe;

public interface CreateRecipeService {

  Recipe createRecipe(String recipeName, String countryOfOrigin, boolean cooked);
}
