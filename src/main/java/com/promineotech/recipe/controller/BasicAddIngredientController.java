package com.promineotech.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.recipe.entity.Ingredients;
import com.promineotech.recipe.entity.Recipe;
import com.promineotech.recipe.service.AddIngredientService;
@RestController
@Service
public class BasicAddIngredientController implements AddIngredientController {

  @Autowired
  private AddIngredientService addIngredientService;
  
  @Override
  public Ingredients addIngredient(String RecipeName, String IngredientName) {
    // TODO Auto-generated method stub
    return addIngredientService.addIngredient(RecipeName, IngredientName);
  }

}
