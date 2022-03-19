package com.promineotech.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.recipe.dao.UpdateRecipeDao;
import com.promineotech.recipe.entity.Recipe;
@Service
public class DefaultUpdateRecipeService implements UpdateRecipeService {

  @Autowired
  private UpdateRecipeDao updateRecipeDao;
  
  @Override
  public Recipe updateRecipe(String recipeName, boolean cooked) {
    // TODO Auto-generated method stub
    return updateRecipeDao.updateRecipe(recipeName, cooked);
  }

}
