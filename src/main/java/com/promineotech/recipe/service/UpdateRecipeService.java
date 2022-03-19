package com.promineotech.recipe.service;

import com.promineotech.recipe.entity.Recipe;

public interface UpdateRecipeService {

  Recipe updateRecipe(String recipeName, boolean cooked);

}
