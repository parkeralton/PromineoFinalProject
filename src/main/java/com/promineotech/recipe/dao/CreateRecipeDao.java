package com.promineotech.recipe.dao;

import com.promineotech.recipe.entity.Recipe;

public interface CreateRecipeDao {

  Recipe saveRecipe(String recipeName, String countryOfOrigin, boolean cooked);

}
