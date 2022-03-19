package com.promineotech.recipe.dao;

import com.promineotech.recipe.entity.Ingredients;
import com.promineotech.recipe.entity.Recipe;

public interface AddIngredientDao {

  Ingredients addIngredient(String recipeName, String ingredientName);

}
