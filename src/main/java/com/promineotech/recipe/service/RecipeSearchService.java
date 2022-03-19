package com.promineotech.recipe.service;

import java.util.List;
import com.promineotech.recipe.entity.Recipe;

public interface RecipeSearchService {

  List<Recipe> fetchRecipe(String ingredient, String country, boolean cooked);
}
