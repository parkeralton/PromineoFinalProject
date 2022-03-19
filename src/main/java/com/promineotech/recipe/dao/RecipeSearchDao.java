package com.promineotech.recipe.dao;

import java.util.List;
import com.promineotech.recipe.entity.Recipe;

public interface RecipeSearchDao {

  /**
   * 
   * @param ingredient
   * @param country
   * @param cooked
   * @return
   */
  
  List<Recipe> fetchRecipe(String ingredient, String country, Boolean cooked);
}
