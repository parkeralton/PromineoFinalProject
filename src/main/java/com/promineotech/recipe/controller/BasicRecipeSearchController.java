package com.promineotech.recipe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.recipe.entity.Recipe;
import com.promineotech.recipe.service.RecipeSearchService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicRecipeSearchController implements RecipeSearchController {

  @Autowired
  private RecipeSearchService recipeSearchService;
  
  @Override
  public List<Recipe> fetchRecipe(String ingredient, String country, Boolean cooked) {
    // TODO Auto-generated method stub
    return recipeSearchService.fetchRecipe(ingredient, country, cooked);
  }

}
