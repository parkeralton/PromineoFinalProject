package com.promineotech.recipe.service;

import com.promineotech.recipe.entity.Ingredients;
import com.promineotech.recipe.entity.Recipe;

public interface AddIngredientService {

  Ingredients addIngredient(String recipeName, String ingredientName);

}
