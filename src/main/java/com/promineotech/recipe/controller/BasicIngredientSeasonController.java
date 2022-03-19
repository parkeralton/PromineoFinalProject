package com.promineotech.recipe.controller;

import java.time.MonthDay;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.recipe.entity.Ingredients;

import com.promineotech.recipe.service.IngredientSeasonService;

@RestController
public class BasicIngredientSeasonController implements IngredientSeasonController {

  @Autowired
  private IngredientSeasonService ingredientSeasonService;
  
  @Override
  public List<Ingredients> fetchIngredients(String date) {
    // TODO Auto-generated method stub
    return ingredientSeasonService.fetchIngredients(date);
  
}
}
