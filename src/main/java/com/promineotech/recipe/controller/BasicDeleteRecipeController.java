package com.promineotech.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.recipe.entity.Recipe;
import com.promineotech.recipe.service.DeleteRecipeService;
@RestController
@Service
public class BasicDeleteRecipeController implements DeleteRecipeController {

  @Autowired
  private DeleteRecipeService deleteRecipeService;
  @Override
  public Recipe deleteRecipe(String RecipeName) {
    // TODO Auto-generated method stub
    return deleteRecipeService.deleteRecipe(RecipeName);
  }

}
