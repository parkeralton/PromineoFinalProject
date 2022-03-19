package com.promineotech.recipe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.recipe.dao.RecipeSearchDao;
import com.promineotech.recipe.entity.Recipe;

@Service
public class DefaultRecipeSearchService implements RecipeSearchService {

  @Autowired
  private RecipeSearchDao recipeSearchDao;
  
  @Override
  public List<Recipe> fetchRecipe(String ingredient, String country, boolean cooked) {
    return recipeSearchDao.fetchRecipe(ingredient, country, cooked);
  }

}
