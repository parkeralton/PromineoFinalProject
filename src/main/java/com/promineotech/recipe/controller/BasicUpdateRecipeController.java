package com.promineotech.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.recipe.entity.Recipe;
import com.promineotech.recipe.service.UpdateRecipeService;
@RestController
public class BasicUpdateRecipeController implements UpdateRecipeController {

  @Autowired
  private UpdateRecipeService updateRecipeService;
  
  @Override
  public Recipe createRecipe(String RecipeName, boolean cooked) {
    // TODO Auto-generated method stub
    return updateRecipeService.updateRecipe(RecipeName, cooked);
  }

}
