package com.promineotech.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.recipe.dao.CreateRecipeDao;
import com.promineotech.recipe.entity.Recipe;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DefaultCreateRecipeService implements CreateRecipeService {

  @Autowired
  private CreateRecipeDao createRecipeDao;
  
  @Override
  @Transactional
  public Recipe createRecipe(String recipeName, String countryOfOrigin, boolean cooked) {
    log.info("controller recipe={}, country={}, cooked = {}", recipeName, countryOfOrigin, cooked);
    return createRecipeDao.saveRecipe(recipeName, countryOfOrigin, cooked);
  }

}
