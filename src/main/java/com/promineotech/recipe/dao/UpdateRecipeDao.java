package com.promineotech.recipe.dao;

import com.promineotech.recipe.entity.Recipe;

public interface UpdateRecipeDao {

  Recipe updateRecipe(String recipeName, boolean cooked);

}
