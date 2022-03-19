package com.promineotech.recipe.dao;

import com.promineotech.recipe.entity.Recipe;

public interface DeleteRecipeDao {

  Recipe deleteRecipe(String recipeName);

}
