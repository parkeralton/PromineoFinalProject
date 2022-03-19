package com.promineotech.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.recipe.entity.Recipe;
import com.promineotech.recipe.service.CreateRecipeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Service
public class BasicCreateRecipeController implements CreateRecipeController {

  @Autowired
  private CreateRecipeService createRecipeService;
  @Override
  public Recipe createRecipe(String RecipeName, String CountryOfOrigin, boolean cooked) {
    log.info("controller recipe={}, country={}, cooked = {}", RecipeName, CountryOfOrigin, cooked);
    return createRecipeService.createRecipe(RecipeName, CountryOfOrigin, cooked);
  }

}
